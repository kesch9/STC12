package ru.innopolis.lesson_9_dz;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigServer {

    private  static Integer DEFAULT_PORT_SERVER = 3999;

    public static void main(String[] args) throws IOException {
        ExecutorService threadpool = Executors.newSingleThreadExecutor();

        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT_SERVER);
        Socket socket = serverSocket.accept();
        InputStream fromClient = socket.getInputStream();
        OutputStream toClient = socket.getOutputStream();
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));
        BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(toClient));
        String message = null;
        while ((message = clientReader.readLine()) != null) {
            System.out.println(message);
            if (message.equals("New Port")){
                ServerThread serverThread = new ServerThread(3997);
                serverThread.start();
                threadpool.submit(serverThread);
                System.out.println("Send Client new Port");
                clientWriter.write("3998");
                clientWriter.newLine();
                clientWriter.flush();
            }
        }
        System.out.println("out");
    }
}

package ru.innopolis.lesson_9_dz;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {

    private Integer port;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            System.out.println("Server port " + port + " run");
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedReader = new BufferedReader(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerThread(Integer port) {
        this.port = port;
    }

    public void writeMessage(String message) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.flush();
    }

    public String readMessage() throws IOException {
        return bufferedReader.readLine();
    }

}

package ru.innopolis.lesson_9_online_socket.server;

import ru.innopolis.lesson_9_online_socket.client.Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static Integer SERVER_PORT = 4999;

    public static void main(String[] args) throws InterruptedException {
        ServerListener serverListener = new ServerListener();
        serverListener.start();
        Thread.sleep(10000);
        try {
            Socket socket = new Socket("127.0.0.1", Client.CLIENT_PORT);
            OutputStreamWriter toClient = new OutputStreamWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message = null;
            while ((message = scanner.nextLine()) != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(toClient);
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

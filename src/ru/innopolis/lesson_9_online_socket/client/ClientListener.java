package ru.innopolis.lesson_9_online_socket.client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static ru.innopolis.lesson_9_online_socket.client.Client.CLIENT_PORT;

public class ClientListener extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(CLIENT_PORT);
            Socket socket = serverSocket.accept();
            InputStream fromServer = socket.getInputStream();
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(fromServer));
            String message = null;
            while ((message = serverReader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

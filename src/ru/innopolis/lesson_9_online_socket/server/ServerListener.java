package ru.innopolis.lesson_9_online_socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import static ru.innopolis.lesson_9_online_socket.server.Server.SERVER_PORT;

public class ServerListener extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket clientSocket = new ServerSocket(SERVER_PORT);
            Socket socket = clientSocket.accept();
            InputStream fromClient = socket.getInputStream();
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));
            String message = null;
            while ((message = clientReader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

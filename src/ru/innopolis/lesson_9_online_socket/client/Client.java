package ru.innopolis.lesson_9_online_socket.client;

import ru.innopolis.lesson_9_online_socket.Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static Integer CLIENT_PORT = 4988;

    public static void main(String[] args) {
        ClientListener clientListener = new ClientListener();
        clientListener.start();
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", Server.SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            OutputStreamWriter serverOutput = new OutputStreamWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message;
            while ((message = scanner.nextLine()) != "") {
                BufferedWriter bufferedWriter = new BufferedWriter(serverOutput);
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

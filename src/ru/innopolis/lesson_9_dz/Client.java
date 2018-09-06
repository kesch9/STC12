package ru.innopolis.lesson_9_dz;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Integer DEFAULT_PORT_SERVER = 3999;
    private static String HOST_SERVER = "127.0.0.1";
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private Socket socket;

    public static void main(String[] args) throws IOException, InterruptedException {

//        Connect Server Default
        Client client = new Client();
        client.connectServer(HOST_SERVER,DEFAULT_PORT_SERVER);
        System.out.println("Connect to server");
        client.bufferedWriter.write("New Port");
        client.bufferedWriter.newLine();
        client.bufferedWriter.flush();
        String message;
        Integer newPort = 3999;
        if (( message = client.bufferedReader.readLine()) != null){
            System.out.println("Accept new Port");
            newPort = Integer.valueOf(message);
            System.out.println("NEW PORT = " + newPort);
        }
//        Recconect Server New Port
        client.socket.close();
        Thread.sleep(2000);
        client.connectServer(HOST_SERVER,newPort);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if ((message = scanner.nextLine()) != "") {
                client.bufferedWriter.write(message);
                client.bufferedWriter.newLine();
                client.bufferedWriter.flush();
            }
            if ((message = client.bufferedReader.readLine()) != "") {
                System.out.println("Server echo: " + message);
            }
        }
    }

    public boolean connectServer(String ipHost, Integer portHost){
        try {
            socket = new Socket(ipHost,portHost);
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
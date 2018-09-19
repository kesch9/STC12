package ru.innopolis.lesson_9_dz.NewRelease;

/**
 * Created by admin on 17.04.2017.
 */
public class Client {
    public static void main(String[] args) {
        ChatClient client = new ChatClient("localhost", 5556);
        client.startChat();
    }
}

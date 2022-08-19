import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class World {
    ServerSocket serverSocket;

    World() {
        try {
            // создаем серверный сокет на порту 1234
            serverSocket = new ServerSocket(1234);
        } catch (IOException e) {
            System.out.println("Connection error. Cant create server socket");
            e.printStackTrace();
        }
    }

    public void startWorld(){
        new ConnectWindow().setVisible(true);
        while(true) {
            System.out.println("Waiting...");
            // ждем клиента из сети

            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                // создаем клиента на своей стороне
                String name = Client.getName();
                new Client(socket, this, name);

            } catch (IOException e) {
                System.out.println("Connection error. Acceptance is not allowed");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new World().startWorld();
        System.out.println(Fighting.getMonstersCount());
    }

    public static void writeMsg(String msg) {
        //Client.writeMsg(msg);
        Client.writeMsg("Where do you want to go?");
        Client.writeMsg("Please choose the number from: \n" +
                "1. To the merchant \n" +
                "2. To the dark forest \n" +
                "3. Exit \n");

    }
}

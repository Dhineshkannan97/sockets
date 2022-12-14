package com.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void socServer(int port) throws IOException {
        Socket socket;
        ServerSocket serverSocket;
        DataInputStream input;
        serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("server start");
            System.out.println(serverSocket);
            socket = serverSocket.accept();
            System.out.println("Client accepted");
            System.out.println(socket);
            try {
                input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                String str = "";
                while (!str.equals("end")) {
                    str = input.readUTF();
                    System.out.println(str);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            serverSocket.close();
//            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.socServer(5000);
    }
}

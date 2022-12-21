package com.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void socServer(int port) throws IOException {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream input = null;
        DataOutputStream output = null;
        serverSocket = new ServerSocket(port);
        System.out.println("server start");
        while (true) {
            socket = serverSocket.accept();
            System.out.println("Client accepted");
            System.out.println(socket);
            Thread thread = new ServerThread(socket, input, output);
            thread.start();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.socServer(5000);

    }
}

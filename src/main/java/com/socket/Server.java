package com.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private DataInputStream in = null;
    private Socket s = null;
    private ServerSocket ss = null;

    public void socServer(int port) {
        try {
            ss = new ServerSocket(port);
            System.out.println("server start");
            s = ss.accept();
            System.out.println("client accepted");
            try {
                in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
                String str = "";
                while (str.equals("over")) {
                    str = in.readUTF();
                    System.out.println(str);

                }
            } catch (IOException e) {
                System.out.println(e);
//                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.socServer(5000);

    }

}

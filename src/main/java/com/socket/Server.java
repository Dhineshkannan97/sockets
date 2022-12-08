package com.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void socServer(int port) throws IOException {
        DataInputStream in;
        Socket s;
        ServerSocket ss;
            ss = new ServerSocket(port);
            System.out.println("server start");
            s = ss.accept();
            System.out.println("Client accepted");
            try {
                in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
                String str = "";
                while (!str.equals("end")) {
                    str = in.readUTF();
                    System.out.println(str);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.socServer(5000);
    }

}

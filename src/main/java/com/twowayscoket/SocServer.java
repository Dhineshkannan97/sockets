package com.twowayscoket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class SocServer {
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(5000);

        while (true){
            Socket s=null;
            try{
           s= ss.accept();
            System.out.println("connection accepted");
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dot = new DataOutputStream(s.getOutputStream());

            Thread t = new ClientHandler(s,din,dot);
               t.start();
            }
            catch (IOException e) {
                s.close();
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        SocServer socServer=new SocServer();
        socServer.server();
    }
}

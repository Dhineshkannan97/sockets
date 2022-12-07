package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
    private Socket s = null;
    private DataOutputStream out = null;
    private DataInputStream input = null;

    public void clientServer(String ip ,int port){
        try{
            s= new Socket(ip,port);
            input =new DataInputStream(System.in);
            out=new DataOutputStream(s.getOutputStream());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String line="";
        while (!line.equals("end")){
            try{
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException e) {
                System.out.println();
                throw new RuntimeException(e);
            }
            }
        try{
            input.close();
            out.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        client client= new client();
        client.clientServer("localhost",5000);
    }
}

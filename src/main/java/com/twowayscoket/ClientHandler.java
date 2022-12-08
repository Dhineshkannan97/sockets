package com.twowayscoket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler extends Thread{
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
   final DataInputStream din;
  final DataOutputStream dot;
    final Socket s;
    public ClientHandler(Socket s,DataInputStream din ,DataOutputStream dot){
             this.s=s;
             this.din=din;
             this.dot=dot;
    }
      public void run(){
        String received;
        String toreturn;
        while (true){
            try {
                dot.writeUTF("type date|type exit to leave");
                received=din.readUTF();
                if (received.equals("exit")){
                    s.close();
                    System.out.println("conn closed");
                }
                Date date=new Date();
                toreturn=fordate.format(date);
                dot.writeUTF(toreturn);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
      }
}

package com.twowayscoket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void client() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket s = new Socket("localhost", 5000);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dot = new DataOutputStream(s.getOutputStream());
        System.out.println(din.readUTF());
        String tosend = scanner.nextLine();
        dot.writeUTF(tosend);
        if (tosend.equals("Exit")) {
            System.out.println("Closing this connection : " + s);
            s.close();
            System.out.println("Connection closed");
        }
        String received = din.readUTF();
        System.out.println(received);
        scanner.close();
        din.close();
        dot.close();
    }

    public static void main(String[] args) throws IOException {
        Client cc = new Client();
        cc.client();
    }
}

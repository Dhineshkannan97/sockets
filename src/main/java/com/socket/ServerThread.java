package com.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket;
    DataOutputStream output;
    DataInputStream input;

    public ServerThread(Socket socket, DataInputStream input, DataOutputStream output) {
        this.socket = socket;
        this.input = input;
        this.output = output;
    }

    public void run() {
        try {
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String str = "";
            while (!str.equals("end")) {
                str = input.readUTF();
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                output.close();
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

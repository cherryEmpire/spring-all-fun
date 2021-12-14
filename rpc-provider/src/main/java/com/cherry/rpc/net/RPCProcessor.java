package com.cherry.rpc.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author: Cherry
 * @Date: 2021/3/27
 * @Desc: RPCProcessor
 */
public class RPCProcessor implements Runnable {

    private Socket socket;

    public RPCProcessor(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object readObject = objectInputStream.readObject();
            socket.getOutputStream();
            socket.getInputStream();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

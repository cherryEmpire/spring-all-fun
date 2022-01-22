package com.cherry.rpc.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Cherry
 * @Date: 2021/3/27
 * @Desc: NetServer
 */
public class NetServer {

    static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(100);

    public static void startUp(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            EXECUTOR_SERVICE.submit(new RPCProcessor(socket));
        }
    }
}

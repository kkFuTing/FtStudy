package com.futing.javalib.tcpip.bio;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Mark老师   享学课堂 https://enjoy.ke.qq.com
 * <p>
 * 类说明：Bio通信的服务端
 */
public class Server {

//    public static void main(String[] args) throws IOException {
//
//        System.out.println("当前线程：：" + Thread.currentThread().getName());
//        //服务端启动必备
//        ServerSocket serverSocket = new ServerSocket();
//        //表示我们服务器在哪个端口上监听
//        serverSocket.bind(new InetSocketAddress(10001));
//        System.out.println("Start server.......");
//        try {
//
//            while (true) {
//                System.out.println("当前线程：：" + Thread.currentThread().getName());
//                new Thread(
//                        new ServerTask(serverSocket.accept())).start();
//            }
//        } finally {
//            serverSocket.close();
//        }
//    }

    private static void client() throws IOException {
        System.out.println("能开始吗");
        //客户端必备
        Socket socket = null;
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
//        127.0.0.1 本机的意思
        InetSocketAddress serverAddr = new InetSocketAddress("127.0.0.1", 10001);

        try {
            socket = new Socket();
            socket.connect(serverAddr);

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            outputStream.writeUTF("Lance");
            outputStream.flush();

            System.out.println(inputStream.readUTF());
        } finally {
            if (socket != null) socket.close();
            if (outputStream != null) outputStream.close();
            if (inputStream != null) inputStream.close();
        }

    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---------------");
                    Thread.sleep(3000);
                    System.out.println("-----------结束----");
                    client();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }

    private static void test() throws IOException {
        System.out.println("当前线程：：" + Thread.currentThread().getName());
        //服务端启动必备
        ServerSocket serverSocket = new ServerSocket();
        //表示我们服务器在哪个端口上监听
        serverSocket.bind(new InetSocketAddress(10001));
        System.out.println("Start server.......");
        try {

            while (true) {
                System.out.println("当前线程：：" + Thread.currentThread().getName());
                new Thread(new ServerTask(serverSocket.accept())).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class ServerTask implements Runnable {
        private Socket socket = null;

        public ServerTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("开始接收了 ：：" + Thread.currentThread().getName());
            try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream()); ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                /*接受客户端的输出，也就是服务器的输入*/
                String userName = inputStream.readUTF();
                System.out.println("Accetp client message:" + userName);

                //处理各种实际的业务

                /*服务器的输入的输出，也就是客户端的输入*/
                outputStream.writeUTF("Hello," + userName);
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

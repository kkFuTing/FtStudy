package com.futing.javalib.tcpip.bio;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com
 *
 *类说明：Bio通信的客户端
 */

//先开启server 。然后运行这个client 但是我启动不成功client，servcer一直在阻塞 导致再开启这个类没有办法执行，我全部写道server了
public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("能开始吗");
        //客户端必备
        Socket socket = null;
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
//        127.0.0.1 本机的意思
        InetSocketAddress serverAddr = new InetSocketAddress("127.0.0.1",10001);

        try {
            socket = new Socket();
            socket.connect(serverAddr);

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            outputStream.writeUTF("Lance");
            outputStream.flush();

            System.out.println(inputStream.readUTF());
        } finally {
            if(socket!= null) socket.close();
            if(outputStream!=null ) outputStream.close();
            if(inputStream!=null ) inputStream.close();
        }


    }

}

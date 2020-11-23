package com.wucstone.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NioMainClient {


    public static void main(String[] args) throws Exception {

        SocketChannel channel =SocketChannel.open(new InetSocketAddress(1001));

    }


}

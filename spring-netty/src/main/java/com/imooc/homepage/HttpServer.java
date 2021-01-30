package com.imooc.homepage;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.net.InetSocketAddress;

public class HttpServer {

    /**
     * 首先创建引导器；然后配置线程模型，通过引导器绑定业务逻辑处理器，并配置一些网络参数；
     * 最后绑定端口，就可以完成服务器的启动了。
     */

    public void start(int port) throws Exception {
        //1、创建引导器
        EventLoopGroup bossEvent = new NioEventLoopGroup();
        EventLoopGroup workEvent = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossEvent, workEvent).channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port)).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {
                    ch.pipeline().addLast("codec", new HttpServerCodec()) // HTTP 编解码
                            .addLast("compressor", new HttpContentCompressor())// HttpContent 压缩
                            .addLast("aggregator", new HttpObjectAggregator(65536))// HTTP 消息聚合
                            .addLast("handler", new HttpServerHandler());
                }
            })
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture f = b.bind().sync();
            System.out.println("Http Server started， Listening on " + port);
            f.channel().closeFuture().sync();
        } finally {
            workEvent.shutdownGracefully();
            bossEvent.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        new HttpServer().start(80);
    }
}

package com.jd.ebs.netty.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NIOServer {
	
	public void run() throws IOException{
		//创建一个server管道
		ServerSocketChannel channel= ServerSocketChannel.open();
		channel.socket().bind(new InetSocketAddress(InetAddress.getByName("localhost"), 808));
		//设置成非阻塞
		channel.configureBlocking(false);
		
		//创建Reactor
		Selector selector=Selector.open();
		SelectionKey key=channel.register(selector, SelectionKey.OP_ACCEPT, null);
		
		key.readyOps();
		if((key.readyOps() & SelectionKey.OP_READ) 
			     == SelectionKey.OP_READ){
			
		}
		//解码器
		CharsetDecoder charsetDecoder=null;
		//编码器
		CharsetEncoder charsetEncoder=null;
		
//		charsetDecoder.decode(in)
//		charsetEncoder.encode(in)
		
		AsynchronousSocketChannel asc=AsynchronousSocketChannel.open();
		ByteBuffer bb=ByteBuffer.allocate(1024);
		asc.write(bb, bb, new CompletionHandler<Integer, ByteBuffer>() {

			public void completed(Integer result, ByteBuffer attachment) {
				
				if(attachment.hasRemaining()){
					
				}
			}

			public void failed(Throwable exc, ByteBuffer attachment) {
				
				
			}
		});
		
	}
	
	public static void main(String[] args) throws UnknownHostException {
		System.out.println(InetAddress.getByName("jingdong05"));
	}

}

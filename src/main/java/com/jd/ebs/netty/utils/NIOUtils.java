package com.jd.ebs.netty.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class NIOUtils {

	public void run() throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		FileInputStream fis = new FileInputStream("dd.txt");
		FileChannel fc = fis.getChannel();
		
		FileOutputStream fos = new FileOutputStream("ddd.txt");
		FileChannel fco = fos.getChannel();
		// 注意在这里同样不需要告诉通道要写入多数据。缓冲区的内部统计机制会跟踪它包含多少数据以及还有多少数据要写入
		byteBuffer.clear();
		int bufferSize = fc.read(byteBuffer);
		while (bufferSize != -1) {
			byteBuffer.flip();
			fco.write(byteBuffer, 0);
			bufferSize=fc.read(byteBuffer);
		}
		//得到一个分片
		byteBuffer.slice(); 
		
		MappedByteBuffer mbb=fc.map(MapMode.READ_WRITE, 0, 1024);
		
		
	}

}

package com.lec.ex01_basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadMain {

	public static void main(String[] args) throws Exception {
		// 1. read()
		InputStream is = new FileInputStream("src/com/lec/ex01_basic/news.txt");
		System.out.println(is);
		
		// System.out.println((char)is.read());
		int read_bytes = 0;
		
		while(true) {
			read_bytes = is.read();
			if (read_bytes == -1) break;
			System.out.println(read_bytes + " = " + (char) read_bytes);
		}
		is.close();
		System.out.println("------------------------------------");
		
		// 2. read(byte[], int off, int len)
		is = new FileInputStream("src/com/lec/ex01_basic/news.txt");

		int readByte = 0;
		byte[] readBytes = new byte[3];
		String data = "";
		
		while(true) {
			readByte = is.read(readBytes);
			if (readByte == -1) break;
			data += new String(readBytes, 0, readByte);
		}
		System.out.println(data);
		is.close();		
		System.out.println("------------------------------------");
		
		// 3. read(byte[] b)
		is = new FileInputStream("src/com/lec/ex01_basic/news.txt");
		int readByteNo;
		byte[] readBytes1 = new byte[8];
		
		readByteNo = is.read(readBytes1, 2, 3);
		for(int i=0;i<readBytes1.length;i++) {
			System.out.println((char)readBytes1[i]);
		}
		is.close();
	}

}

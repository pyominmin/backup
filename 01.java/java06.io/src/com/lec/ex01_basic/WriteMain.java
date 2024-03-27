package com.lec.ex01_basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteMain {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("src/com/lec/ex01_basic/test.txt");

		// 1. write()
		byte[] data = "대한민국만세".getBytes();
		System.out.println(data.toString());
		for(int i=0;i<data.length;i++) {
			os.write(data[i]);
		}
		os.flush();
		os.close();
		
		// 2. write(byte[] b)
		os = new FileOutputStream("src/com/lec/ex01_basic/test1.txt");
		data = "1234567890".getBytes();
		os.write(data);
		os.flush();
		os.close();
		
		// 3. write(byte[] b, int off, int len)
		os = new FileOutputStream("src/com/lec/ex01_basic/test2.txt");
		data = "1234567890".getBytes();
		os.write(data, 1, 3);
		os.flush();
		os.close();
	}

}

package com.lec.ex01_basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReaderMain {

	public static void main(String[] args) throws Exception {
		
		Reader reader = new FileReader("src/com/lec/ex01_basic/news.txt");
		
		// 1. read()
		int readData;
		while(true) {
			readData = reader.read();
			if(readData == -1) break;
			System.out.println(readData + " = " + (char) readData);
		}
		reader.close();
		System.out.println("------------------------------------");
		
		// 2. read(char[] c)
		reader = new FileReader("src/com/lec/ex01_basic/news.txt");
		int readCharNo;
		char buff[] = new char[2];
		String data = "";
		while(true) {
			readCharNo = reader.read(buff);
			if(readCharNo == -1) break;
			data += new String(buff, 0, readCharNo);
		}
		System.out.println(data);
		reader.close();
		System.out.println("------------------------------------");
				
		// 3. read(char[], int off, int length)
		reader = new FileReader("src/com/lec/ex01_basic/news.txt");
		int readNo;
		char[] cbuf = new char[8];
		readNo = reader.read(cbuf, 1, 4);
		for(int i=0;i<cbuf.length;i++) {
			System.out.println(cbuf[i]);
		}
		reader.close();
	}

}
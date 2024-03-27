package com.lec.ex02_file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class FileReaderMain {

	public static void main(String[] args) throws Exception {
	
		FileReader fr = new FileReader("src/com/lec/ex02_file/FileMain.java");

		int readChar;
		char[] cbuf = new char[100];
		while((readChar = fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readChar);
			System.out.println(data);
		}
		fr.close();
	}
}

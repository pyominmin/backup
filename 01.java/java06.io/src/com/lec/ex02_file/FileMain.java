package com.lec.ex02_file;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMain {

	public static void main(String[] args) throws Exception {
		
		// 1. 폴더 or 파일 or URI로 생성
		File dir = new File("c:/temp/dir");
		File file1 = new File("c:/temp/file1.txt");
		File file2 = new File("c:/temp/file2.txt");
		File file3 = new File(new URI("file:///c:/temp/file3.txt"));
		
		// 2. 생성하기
		if(dir.exists() == false) dir.mkdir();
		if(file1.exists() == false) file1.createNewFile();
		if(file2.exists() == false) file2.createNewFile();
		if(file3.exists() == false) file3.createNewFile();
		
		// 3. 파일목록(최종수정일시)
		File temp = new File("D:\\lec\\01.java\\java06.io\\src\\com\\lec\\ex01_basic");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd \t a \t HH:mm:SS");
		File[] fileList = temp.listFiles();
		System.out.println("------------------------------------------");
		for(File file:fileList) {
			System.out.println(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.println("\t <dir> \t" + file.getName());
			} else {
				System.out.println("\t " + file.getName() + "\t " + file.length());
			}
		}
	}

}

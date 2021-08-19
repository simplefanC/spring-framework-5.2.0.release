package com.simplefanc.demo.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.*;

public class ResourceDemo {
	public static void main(String[] args) throws IOException {
		FileSystemResource fileSystemResource = new FileSystemResource(
				"E:\\JAVA\\慕课网_Spring源码-未学完\\spring-framework-5.2.0.RELEASE\\spring-demo\\src\\main\\java\\com\\simplefanc\\demo\\resource\\test.txt"
		);
		File file = fileSystemResource.getFile();
		System.out.println(file.length());
		OutputStream outputStream = fileSystemResource.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("Hello World");
		bufferedWriter.flush();
		outputStream.close();
		bufferedWriter.close();
	}
}

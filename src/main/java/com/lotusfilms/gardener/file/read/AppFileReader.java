package com.lotusfilms.gardener.file.read;

import java.io.IOException;

public abstract class AppFileReader {

	private String fileName;
	private Object readData;
	
	public Object read() throws IOException{
		return null;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Object getReadData() {
		return readData;
	}

	public void setReadData(Object readData) {
		this.readData = readData;
	}
	
}

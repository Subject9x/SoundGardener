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
	
	/**
	 * find and extract the file's extension type
	 * @param fileName
	 * @return
	 */
	public static String parseFileExt(String fileName) {
		int extMark = fileName.lastIndexOf('/');
		String ext = fileName.substring(extMark + 1).toLowerCase();
		return  ext;
	}
}

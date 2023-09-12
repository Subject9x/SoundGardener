package com.lotusfilms.gardener.file.write;

import java.io.IOException;

public abstract class SoundFileWriter {

	private String targetFile;
	private Object targetData;
	
	public void write() throws IOException{}
		
	public Object getTargetData() {
		return targetData;
	}

	public void setTargetData(Object targetData) {
		this.targetData = targetData;
	}

	public String getTargetFile() {
		return targetFile;
	}

	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}
}

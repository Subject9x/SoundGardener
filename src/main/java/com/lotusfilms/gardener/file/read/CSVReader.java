package com.lotusfilms.gardener.file.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.file.csv.CSVFile;

public class CSVReader extends AppFileReader{

	private Logger logger = LoggerFactory.getLogger(CSVReader.class);
	
	@Override
	public Object read() throws IOException{
		if(getFileName() == null || getFileName().isEmpty()) {
			throw new IOException("File name was null or empty");
		}
		
		File load = new File(getFileName());
		
		if(!load.exists()) {
			throw new IOException("File["+getFileName()+"] doesn't exist.");
		}
		
		if(!load.canRead()) {
			throw new IOException("File["+getFileName()+"] can't be read.");
		}		
		
		FileReader reader = new FileReader(load);
		BufferedReader buffer = new BufferedReader(reader);
		
		List<List<String>> fileData = new ArrayList<List<String>>();
		
		String line = "";
		String[] tokens;
		while((line = buffer.readLine()) != null) {
			tokens = line.split(",");
			
			List<String> row = Arrays.asList(tokens);
			
			
			fileData.add(row);			
		}
		buffer.close();
		reader.close();
		
		CSVFile csv = new CSVFile(fileData);
		
		return csv;
	}
}

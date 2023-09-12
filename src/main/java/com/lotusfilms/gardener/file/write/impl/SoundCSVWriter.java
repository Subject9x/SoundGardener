package com.lotusfilms.gardener.file.write.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.file.csv.CSVItem;
import com.lotusfilms.gardener.file.write.SoundFileWriter;
import com.opencsv.CSVWriter;

public class SoundCSVWriter extends SoundFileWriter {

	private Logger logger = LoggerFactory.getLogger(SoundCSVWriter.class);

	
	@Override
	public void write() throws IOException{
		if(getTargetData() == null) {
			logger.info("target data was null.");
			return;
		}
		if(!(getTargetData() instanceof CSVItem)) {
			logger.info("target data was not a CSVItem.");
			return;
		}
		
		
		CSVItem item = (CSVItem)getTargetData();
		
		File outputFile = new File(getTargetFile());
		
		if(!outputFile.canWrite()) {
			logger.info("file[ {} ] couldn't be written to.", getTargetFile());
			return;
		}
		
		try(CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile.getPath()))){
			item.getData().stream().forEach((List<String> row)->{
				String[] rowDat = (String[])row.toArray();
				csvWriter.writeNext(rowDat);
			});
		}
	}
}

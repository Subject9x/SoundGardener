package com.lotusfilms.gardener.file.write;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.file.csv.CSVItem;

public class CSVWriter extends FileWriter {

	private Logger logger = LoggerFactory.getLogger(CSVWriter.class);
	
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
		
		try(PrintWriter pw = new PrintWriter(outputFile)){
			item.getData()
				.stream()
				.map(CSVItem::convertToCSV)
				.forEach(pw::println);
		}
	}
}

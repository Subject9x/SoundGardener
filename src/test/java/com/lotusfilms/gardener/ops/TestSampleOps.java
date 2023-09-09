package com.lotusfilms.gardener.ops;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.api.SoundSampleOperator;
import com.lotusfilms.gardener.api.impl.SoundSampleOpsImpl;
import com.lotusfilms.gardener.core.AppCore;
import com.lotusfilms.gardener.file.csv.CSVFile;
import com.lotusfilms.gardener.file.read.AppFileReader;
import com.lotusfilms.gardener.file.read.CSVReader;

public class TestSampleOps {

	private Logger logger = LoggerFactory.getLogger(TestSampleOps.class);
	
	@Test
	public void testOps() {
		AppCore core = AppCore.getInstance();
		
		SoundSampleOperator ops = new SoundSampleOpsImpl();
		
		AppFileReader reader = new CSVReader();
		
		reader.setFileName(ClassLoader.getSystemResource("test_main.csv").getFile());
		
		try {
			CSVFile f = (CSVFile)reader.read();
			logger.info(f.toString());
		} catch (IOException e) { 
			logger.error(e.getMessage());
		}
	}
}

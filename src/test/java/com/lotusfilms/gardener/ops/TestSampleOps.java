package com.lotusfilms.gardener.ops;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.api.SoundSampleOperator;
import com.lotusfilms.gardener.api.impl.SoundSampleOpsImpl;
import com.lotusfilms.gardener.data.atom.SoundSample;
import com.lotusfilms.gardener.file.csv.CSVFile;
import com.lotusfilms.gardener.file.read.impl.SoundCSVReader;

public class TestSampleOps {

	private Logger logger = LoggerFactory.getLogger(TestSampleOps.class);
	
	@Test
	public void testOps() {
		SoundSampleOperator ops = new SoundSampleOpsImpl();
		
		SoundCSVReader reader = new SoundCSVReader();
		
		reader.setIncludeHeader(true);
		reader.setFileName(ClassLoader.getSystemResource("test_main.csv").getFile());
		
		try {
			CSVFile f = (CSVFile)reader.read();
			List<SoundSample> test = reader.csvToSamples(f);
			
			test.stream().forEach((SoundSample s) -> {
				ops.insertNewSample(s);
			});
			
			
			logger.info(f.toString());
		} catch (IOException e) { 
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}

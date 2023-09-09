package com.lotusfilms.gardener.api.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.api.SoundSampleOperator;
import com.lotusfilms.gardener.core.AppCore;
import com.lotusfilms.gardener.data.FileTagType;
import com.lotusfilms.gardener.data.SoundSampleLib;
import com.lotusfilms.gardener.data.atom.SoundSample;

public class SoundSampleOpsImpl implements SoundSampleOperator{

	private static Logger logger = LoggerFactory.getLogger(SoundSampleOperator.class);
	
	@Override
	public void insertNewSample(SoundSample newSample) {
		AppCore app = AppCore.getInstance();
		
		List<SoundSample>library = app.getSoundSamples().getSamplesTable();
		
		if(library == null) {
			app.getSoundSamples().setSamplesTable(new ArrayList<SoundSample>());
			library = app.getSoundSamples().getSamplesTable();
			
			logger.info("Sound Sample{} library object was null, instantiating.");
		}
		if(library.isEmpty()) {
			library.add(newSample);
			logger.info("Sound Sample[ {} ] added.", newSample.getFileName());
			return;
		}
		Predicate<SoundSample> exists = test -> (test.equals(newSample));
		
		long isThere = library.stream().filter(exists).count();
		if(isThere == 0l){
			library.add(newSample);
			logger.info("Sound Sample[ {} ] added.", newSample.getFileName());
		}
		else {
			logger.info("Sound Sample[ {} ] already exists.", newSample.getFileName());
		}
	}

	@Override
	public List<SoundSample> getAllSamples() {
		return AppCore.getInstance().getSoundSamples().getSamplesTable();
	}

	@Override
	public List<SoundSample> sampleByTypeTag(FileTagType type, String tagVal) {
		AppCore app = AppCore.getInstance();
		
		SoundSampleLib library = app.getSoundSamples();
		
		Predicate<SoundSample> tagType = sample -> (sample.getData().get(type).equals(tagVal));
		
		SoundSample[] found = (SoundSample[])library.getSamplesTable().stream().filter(tagType).toArray();
		if(found.length > 0) {
			return Arrays.asList(found);
		}
		return null;
	}

	@Override
	public List<SoundSample> sampleByMultiType(FileTagType type) {
		AppCore app = AppCore.getInstance();
		
		return null;
	}

	@Override
	public List<SoundSample> sampleByMultiTypeTags(List<FileTagType> types, List<String> tags) {
		AppCore app = AppCore.getInstance();
		
		
		
		return null;
	}	
}

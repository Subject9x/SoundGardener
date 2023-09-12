package com.lotusfilms.gardener.api;

import java.util.List;

import com.lotusfilms.gardener.core.AppCore;
import com.lotusfilms.gardener.data.FileTagType;
import com.lotusfilms.gardener.data.atom.SoundSample;

/***
 *  Interface for querying and operations on the {@linkplain AppCore}'s SoundSample list.
 */
public interface SoundSampleOperator {

	public void insertNewSample(SoundSample newSample);
	
	public List<SoundSample> getAllSamples();
	
	public List<SoundSample> sampleByTypeTag(FileTagType type, String tagVal);
	
	public List<SoundSample> sampleByMultiType(FileTagType type);
	
	public List<SoundSample> sampleByMultiTypeTags(List<FileTagType> types, List<String> tags);
	
}

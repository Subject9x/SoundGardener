package com.lotusfilms.gardener.data;

import java.util.List;

import com.lotusfilms.gardener.data.atom.SoundSample;

/***
 * Main data class for {@linkplain SoundSample} collection.
 */
public final class SoundSampleLib {
	
	private static SoundSampleLib instance;
	
	private  List<SoundSample> samplesTable;
	
	private SoundSampleLib() {}

	public List<SoundSample> getSamplesTable() {
		return samplesTable;
	}

	public void setSamplesTable(List<SoundSample> sampleTable) {
		samplesTable = sampleTable;
	}
	
	public static SoundSampleLib instance() {
		if(instance == null) {
			instance = new SoundSampleLib();
		}
		return instance;
	}
}

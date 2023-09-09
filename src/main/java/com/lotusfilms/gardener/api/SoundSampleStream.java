package com.lotusfilms.gardener.api;

import java.util.function.Predicate;

import com.lotusfilms.gardener.data.atom.SoundSample;

public interface SoundSampleStream extends Predicate<SoundSample> {

	@Override
	default boolean test(SoundSample t) {
		// TODO Auto-generated method stub
	
		
		return false;
	}
}

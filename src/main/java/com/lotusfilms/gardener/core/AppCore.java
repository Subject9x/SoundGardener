package com.lotusfilms.gardener.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.data.FileTagLib;
import com.lotusfilms.gardener.data.SoundSampleLib;

/***
 * Singleton core class of Gardener module.
 */
public class AppCore {
	
	private Logger logger = LoggerFactory.getLogger(AppCore.class);
	
	private static AppCore instance;
	
	private final SoundSampleLib soundSamples;
	private final FileTagLib fileTags;
	
	public AppCore() {
		this.fileTags = FileTagLib.instance();
		this.soundSamples = SoundSampleLib.instance();
	}
	
	//DEBUG entry
	public static void main(String[] args) {
		AppCore core = AppCore.getInstance();
		core.dbg_init();
	}
	
	public void dbg_init() {
		logger.info("boot!");
	}
	
	public FileTagLib getFileTagLib() {
		return this.fileTags;
	}
	
	public SoundSampleLib getSoundSamples() {
		return this.soundSamples;
	}
	
	public static AppCore getInstance() {
		if(instance == null) {
			instance = new AppCore();
		}
		return instance;
	}
	
}

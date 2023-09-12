package com.lotusfilms.gardener.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.data.FileTagType;
import com.lotusfilms.gardener.data.atom.FileTag;
import com.lotusfilms.gardener.data.atom.SoundSample;

/***
 * Singleton core class of Gardener module.
 */
public class AppCore {
	
	private Logger logger = LoggerFactory.getLogger(AppCore.class);
	
	private HashMap<FileTagType, FileTag> fileTags;
	private List<SoundSample> samplesTable;
	
	private static AppCore instance;
	
	private AppCore() {
		fileTags = new HashMap<FileTagType, FileTag>();
		samplesTable = new ArrayList<SoundSample>();
	}
	
	//DEBUG entry
	public static void main(String[] args) {
		AppCore core = AppCore.getInstance();
		core.dbg_init();
	}
	
	public void dbg_init() {
		logger.info("boot!");
		iniData();
	}
	
	public HashMap<FileTagType, FileTag> getFileTagLib() {
		return this.fileTags;
	}
	
	public List<SoundSample> getSoundSamples() {
		return this.samplesTable;
	}
	
	public static AppCore getInstance() {
		if(instance == null) {
			instance = new AppCore();
			instance.dbg_init();
		}
		return instance;
	}
	
    /**
     * DEBUG ONLY
     */
    public void iniData(){
        iniTagSpatials();
        iniTagSoundCats();
        iniTagFreqs();
        iniTagTrackNum();
        iniTagExts();
        logger.info("tag library booted.");
    }
    
    
    private void iniTagSpatials(){
        List<String> tags = new ArrayList<String>();
        tags.add("int");
        tags.add("ext");
        
        fileTags.put(FileTagType.SPATION_INFORMATION, new FileTag(FileTagType.SPATION_INFORMATION, tags));
    }
    private void iniTagSoundCats(){
        List<String> tags = new ArrayList<String>();
        tags.add("amb");
        tags.add("effect");
        
        fileTags.put(FileTagType.SOUND_CATEGORY, new FileTag(FileTagType.SOUND_CATEGORY, tags));
    }
    private void iniTagFreqs(){
        List<String> tags = new ArrayList<String>();
        tags.add("48khz");
        tags.add("44.1khz");
        fileTags.put(FileTagType.FREQUENCY, new FileTag(FileTagType.FREQUENCY, tags));
    }
    private void iniTagTrackNum(){
        List<String> tags = new ArrayList<String>();
        tags.add("stereo");
        tags.add("mono");
        fileTags.put(FileTagType.FREQUENCY, new FileTag(FileTagType.FREQUENCY, tags));
    }
    private void iniTagExts(){
        List<String> tags = new ArrayList<String>();
        tags.add("wav");
        tags.add("ogg");
        tags.add("mp3");
        tags.add("flac");
        fileTags.put(FileTagType.FILE_EXT, new FileTag(FileTagType.FILE_EXT, tags));
    }

}

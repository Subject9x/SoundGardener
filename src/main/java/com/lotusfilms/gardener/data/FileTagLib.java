package com.lotusfilms.gardener.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.data.atom.FileTag;

/***
 * Data handler for Main Tag Library collection.
 * Each Appcore instance should only have 1 of these, and usually its populated at run-time by reading in from
 * an existing datasource (for initial local version, it's a csv file).
 */
public final class FileTagLib {
	private Logger logger = LoggerFactory.getLogger(FileTagLib.class);
	private static FileTagLib instance;
	
    private HashMap<FileTagType, FileTag> fileTags;
    
    private FileTagLib() {
    	fileTags = new HashMap<FileTagType, FileTag>();
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

    
    public static FileTagLib instance() {
    	if(instance == null) {
    		instance = new FileTagLib();
    		instance.iniData();	//debug
    	}
    	return instance;
    }
	
}

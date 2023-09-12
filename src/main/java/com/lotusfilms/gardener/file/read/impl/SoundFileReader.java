package com.lotusfilms.gardener.file.read.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.api.FileTagOperator;
import com.lotusfilms.gardener.api.impl.TagLibOperator;
import com.lotusfilms.gardener.data.FileTagType;
import com.lotusfilms.gardener.data.atom.SoundSample;
import com.lotusfilms.gardener.file.read.AppFileReader;

public class SoundFileReader extends AppFileReader {

	private static Logger logger = LoggerFactory.getLogger(SoundFileReader.class);
	
	private FileTagOperator fileTagOp;
	
	@Override
	public Object read() throws IOException{
		if (getFileName() == null || getFileName().isEmpty()) {
			throw new IOException("File name was null or empty");
		}

		File load = new File(getFileName());

		if (!load.exists()) {
			throw new IOException("File[" + getFileName() + "] doesn't exist.");
		}

		if (!load.canRead()) {
			throw new IOException("File[" + getFileName() + "] can't be read.");
		}

		fileTagOp = new TagLibOperator();
		
		SoundSample sample = new SoundSample();
		
		sample.setFileExt(parseFileExt(getFileName()));
		sample.setFileName(getFileName() + sample.getFileExt());
		sample.setFileSize(String.valueOf(load.length()));
		sample.setFileLength(getSoundLength(load));

		String[] tagsInFile = sample.getFileName().split("_");
		parseFileTags(tagsInFile, sample);
		
		return sample;
	}
	
    public String getSoundLength(File sound){
        AudioInputStream audioInputStream = null;
        AudioFormat audioFormat = null;
        
        try {
			audioInputStream = AudioSystem.getAudioInputStream(sound);
	        audioFormat = audioInputStream.getFormat();
	        long audioLength = sound.length();
	        int frameSize = audioFormat.getFrameSize();
	        float frameRate = audioFormat.getFrameRate();
	        float duration = (audioLength / (frameSize * frameRate));
	        return String.valueOf(duration);
        
		} catch (UnsupportedAudioFileException | IOException e) {
			logger.error(e.getMessage());
		}
        finally{
        	try {
				audioInputStream.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
        }
        
        return "0";
    }
    
	/**
	 * After the pre-req tags in the filename, the rest are 'discoverable'
	 * tag values and their types. The system has to check to see if a tag
	 * conforms to the known types. 
	 * @param tags
	 * @param tagData
	 * @param rawFile
	 */
	private void parseFileTags(String[] tags, SoundSample soundSample) {
		StringBuilder descTags = new StringBuilder();
		for(String tag : tags) {
			boolean tagUsed = false;
			//check date
			tagUsed = checkDate(tag);
			if(tagUsed) {
				soundSample.setDate(tag);
				continue;
			}
			//check Spatial
			tagUsed = checkTag(tag, fileTagOp.getTag(FileTagType.SPATION_INFORMATION).getTags());
			if(tagUsed) {
				soundSample.setSpatialInfo(tag);
				continue;
			}
			//check Sound Category
			tagUsed = checkTag(tag, fileTagOp.getTag(FileTagType.SOUND_CATEGORY).getTags());
			if(tagUsed) {
				soundSample.setSoundCategory(tag);
				continue;
			}
			//check Freq
			tagUsed = checkTag(tag.toLowerCase(), fileTagOp.getTag(FileTagType.FREQUENCY).getTags());
			if(tagUsed) {
				soundSample.setFrequency(tag);
				continue;
			}	
			//check sequence number
			tagUsed = checkSeqId(tag);
			if(tagUsed) {
				soundSample.setSeqNum(tag);
				continue;
			}
			//check Track No
			tagUsed = checkTag(tag, fileTagOp.getTag(FileTagType.TRACK_NUMBER).getTags());
			if(tagUsed) {
				soundSample.setTrackNo(tag);
				continue;
			}
			
			//Tag does not conform to presets, must be uncategorized
			descTags.append(tag);
			descTags.append(",");
		}
		soundSample.setDesc(descTags.toString());
	}

	private boolean checkSeqId(String tag) {
		if(tag.length() <= 2) {
			Pattern datePattern = Pattern.compile("[a-zA-z]+", Pattern.CASE_INSENSITIVE);
			Matcher matcher = datePattern.matcher(tag);
			if(matcher.find()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDate(String tag) {
		if(tag.length() >= 4 && tag.length() <= 8) {
			Pattern datePattern = Pattern.compile("\\b\\d+\\b", Pattern.CASE_INSENSITIVE);
			Matcher matcher = datePattern.matcher(tag);
			if(matcher.find()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkTag(String tag, List<String> tagList) {
		if(tagList.contains(tag)) {
			return true;
		}
		return false;
	}
}

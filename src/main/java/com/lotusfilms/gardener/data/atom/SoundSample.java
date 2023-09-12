package com.lotusfilms.gardener.data.atom;

import java.util.HashMap;
import java.util.List;

import com.lotusfilms.gardener.data.FileTagType;

/***
 * Atomic data class of Sound Samples used in the app.

 */
public class SoundSample {

	private String path;
	private HashMap<FileTagType, String> data;
	private List<String> tags;
	
	public SoundSample() {
		this.data = new HashMap<FileTagType, String>();
	}
	
	public String getFileName() {
		return this.data.get(FileTagType.FILENAME);
	}

	public void setFileName(String fileName) {
		this.data.put(FileTagType.FILENAME, fileName);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSeqNum() {
		return this.data.get(FileTagType.SEQUENCE_NUMBER);
	}

	public void setSeqNum(String seqNum) {
		this.data.put(FileTagType.SEQUENCE_NUMBER, seqNum);
	}

	public String getDate() {
		return this.data.get(FileTagType.DATE);
	}

	public void setDate(String date) {
		this.data.put(FileTagType.DATE, date);
	}

	public String getSpatialInfo() {
		return this.data.get(FileTagType.SPATION_INFORMATION);
	}

	public void setSpatialInfo(String spatialInfo) {
		this.data.put(FileTagType.SPATION_INFORMATION, spatialInfo);
	}

	public String getSoundCategory() {
		return this.data.get(FileTagType.SOUND_CATEGORY);
	}

	public void setSoundCategory(String soundCategory) {
		this.data.put(FileTagType.SOUND_CATEGORY, soundCategory);
	}

	public String getFrequency() {
		return this.data.get(FileTagType.FREQUENCY);
	}

	public void setFrequency(String frequency) {
		this.data.put(FileTagType.FREQUENCY, frequency);
	}

	public String getTrackNo() {
		return this.data.get(FileTagType.TRACK_NUMBER);
	}

	public void setTrackNo(String trackNo) {
		this.data.put(FileTagType.TRACK_NUMBER, trackNo);
	}

	public String getFileSize() {
		return this.data.get(FileTagType.FILE_SIZE);
	}

	public void setFileSize(String fileSize) {
		this.data.put(FileTagType.FILE_SIZE, fileSize);
	}

	public String getFileExt() {
		return this.data.get(FileTagType.FILE_EXT);
	}

	public void setFileExt(String fileExt) {
		this.data.put(FileTagType.FILE_EXT, fileExt);
	}

	public String getFileLength() {
		return this.data.get(FileTagType.FILE_LENGTH);
	}

	public void setFileLength(String fileLength) {
		this.data.put(FileTagType.FILE_LENGTH, fileLength);
	}

	public String getDesc() {
		return this.data.get(FileTagType.DESCRIPTION);
	}

	public void setDesc(String desc) {
		this.data.put(FileTagType.DESCRIPTION, desc);
	}
	
	public HashMap<FileTagType, String> getData(){
		return this.data;
	}
	
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}

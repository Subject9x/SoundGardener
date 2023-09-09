package com.lotusfilms.gardener.data;

/***
 * Defined tag names for convenience across various other file data classes.
 */
public enum FileTagType {

	FILENAME("Filename"),
	SEQUENCE_NUMBER("Sequence Number"),
	DATE("Date"),
	SPATION_INFORMATION("Spatial Information"),
	SOUND_CATEGORY("Sound Category"),
	FREQUENCY("Frequency"),
	TRACK_NUMBER("Track Number"),
	FILE_SIZE("FileSize"),
	FILE_EXT("FileExt"),
	FILE_LENGTH("FileLength"),
	DESCRIPTION("Description");
	
	private String val;
	
	private FileTagType(String v) {
		this.val = v;
	}
	
	public String val() {
		return this.val;
	}
}

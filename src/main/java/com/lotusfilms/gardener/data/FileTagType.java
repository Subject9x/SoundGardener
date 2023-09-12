package com.lotusfilms.gardener.data;

import java.util.ArrayList;
import java.util.List;

/***
 * Defined tag names for convenience across various other file data classes.
 */
public enum FileTagType {

	FILENAME("Filename", 0),
	SEQUENCE_NUMBER("Sequence Number", 1),
	DATE("Date", 2),
	SPATION_INFORMATION("Spatial Information", 3),
	SOUND_CATEGORY("Sound Category", 4),
	FREQUENCY("Frequency", 5),
	TRACK_NUMBER("Track Number", 6),
	FILE_SIZE("FileSize", 7),
	FILE_EXT("FileExt", 8),
	FILE_LENGTH("FileLength", 9),
	DESCRIPTION("Description", 10);
	
	private String val;
	private int col;
	
	private FileTagType(String v, int col) {
		this.val = v;
		this.col = col;
	}
	
	public String val() {
		return this.val;
	}
	
	public int colId() {
		return this.col;
	}
	
	public static List<String> toList(){
		
		List<String> header = new ArrayList<String>();
		header.add(FILENAME.val());
		header.add(SEQUENCE_NUMBER.val());
		header.add(DATE.val());
		header.add(SPATION_INFORMATION.val());
		header.add(SOUND_CATEGORY.val());
		header.add(FREQUENCY.val());
		header.add(TRACK_NUMBER.val());
		header.add(FILE_SIZE.val());
		header.add(FILE_EXT.val());
		header.add(FILE_LENGTH.val());
		header.add(DESCRIPTION.val());
		
		return header;
	}
}

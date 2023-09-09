package com.lotusfilms.gardener.data.atom;

import java.util.List;

import com.lotusfilms.gardener.data.FileTagType;

/***
 * Concrete class to track tags of specific types for file meta data.
 */
public class FileTag {

	private FileTagType type;
	private List<String> tags;
	
	public FileTag() {}
	
	public FileTag(FileTagType type, List<String> tags) {
		this.type = type;
		this.tags = tags;
	}

	public FileTagType getType() {
		return type;
	}

	public void setType(FileTagType type) {
		this.type = type;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}

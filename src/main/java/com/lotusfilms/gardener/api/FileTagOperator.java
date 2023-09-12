package com.lotusfilms.gardener.api;

import java.util.List;

import com.lotusfilms.gardener.data.FileTagType;
import com.lotusfilms.gardener.data.atom.FileTag;

public interface FileTagOperator {

	public List<FileTag> getAllTags();
	
	public FileTag getTag(FileTagType t);
	
	public void addTag(FileTagType t, String tag);
}

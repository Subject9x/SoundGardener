package com.lotusfilms.gardener.api.impl;

import java.util.List;

import com.lotusfilms.gardener.api.FileTagOperator;
import com.lotusfilms.gardener.core.AppCore;
import com.lotusfilms.gardener.data.FileTagType;
import com.lotusfilms.gardener.data.atom.FileTag;

public class TagLibOperator implements FileTagOperator{

	@Override	
	public List<FileTag> getAllTags() {
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileTag getTag(FileTagType t) {
		return AppCore.getInstance().getFileTagLib().get(t);
	}

	@Override
	public void addTag(FileTagType t, String tag) {
		FileTag fileTag = AppCore.getInstance().getFileTagLib().get(t);
		if(!fileTag.getTags().contains(tag)) {
			fileTag.getTags().add(tag);
		}
	}
}

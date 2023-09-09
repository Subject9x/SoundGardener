package com.lotusfilms.gardener.file.csv;

import java.util.ArrayList;
import java.util.List;

/**
 * Atomic CSV data class, these are the intermediary format between the APP and the OS' file system.
 * 
 */
public class CSVFile extends CSVItem{
	
	private	List<List<String>> data;
	
	public CSVFile() {
		this.data = new ArrayList<List<String>>();
	}
	
	public CSVFile(List<List<String>> newData) {
		this.data = newData;
	}
	
	public void setData(List<List<String>> data) {
		this.data = data;
	}
	
	@Override
	public List<List<String>> getData(){
		return this.data;
	}
}

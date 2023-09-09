package com.lotusfilms.gardener.file.csv;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CSVItem {
	
	public static String escapeSpecialChar(String data) {
		String escapedData = data.replace("\\R", " ");
		if(data.contains(",") || data.contains("\"") || data.contains("'")) {
			data = data.replace("\"", "\"\"");
			escapedData = "\"" + data + "\"";
		}
		return escapedData;
	}
	
	public static String convertToCSV(List<String> data) {
		return data.stream().map(CSVItem::escapeSpecialChar).collect(Collectors.joining(","));
	}
	
	//Override me
	public List<List<String>> getData(){
		return null;
	}
}

package com.lotusfilms.gardener.file.read.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotusfilms.gardener.data.FileTagType;
import com.lotusfilms.gardener.data.atom.SoundSample;
import com.lotusfilms.gardener.file.csv.CSVFile;
import com.lotusfilms.gardener.file.read.AppFileReader;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.exceptions.CsvException;

public class SoundCSVReader extends AppFileReader {

	private Logger logger = LoggerFactory.getLogger(SoundCSVReader.class);
	private boolean includeHeader = false;

	@Override
	public Object read() throws IOException {
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

		int headerSkip = isIncludeHeader() ? 1 : 0;

		FileReader reader = new FileReader(load);
		BufferedReader buffer = new BufferedReader(reader);

		List<List<String>> fileData = new ArrayList<List<String>>();

		CSVParser csvParse = new CSVParserBuilder().withQuoteChar('"').withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
				.build();

		CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(csvParse).withSkipLines(headerSkip).build();

		CSVFile csv = null;
		
		List<String[]> dataString;
		try {
			dataString = csvReader.readAll();
			
			dataString.stream().forEach((String[] rowArr) -> {
				fileData.add(Arrays.asList(rowArr));
			});
			
			csv = new CSVFile(fileData);
			
		} catch (IOException | CsvException e) {
			logger.error(e.getMessage());
		}
		finally {
			csvReader.close();
			buffer.close();
			reader.close();
		}
		return csv;
	}

	public List<SoundSample> csvToSamples(CSVFile csvFile) throws Exception {

		List<SoundSample> samples = new ArrayList<SoundSample>();

		csvFile.getData().stream().forEach((List<String> row) -> {
			if (row.size() < csvFile.getData().get(0).size()) {
				logger.info("Row[ {} ] incorrect number of columns!", row);
			} else {
				SoundSample file = new SoundSample();
				file.setFileName(row.get(FileTagType.FILENAME.colId()));
				file.setSeqNum(row.get(FileTagType.SEQUENCE_NUMBER.colId()));
				file.setDate(row.get(FileTagType.DATE.colId()));
				file.setSpatialInfo(row.get(FileTagType.SPATION_INFORMATION.colId()));
				file.setSoundCategory(row.get(FileTagType.SOUND_CATEGORY.colId()));
				file.setFrequency(row.get(FileTagType.FREQUENCY.colId()));
				file.setTrackNo(row.get(FileTagType.TRACK_NUMBER.colId()));
				file.setTrackNo(row.get(FileTagType.FILE_SIZE.colId()));
				file.setTrackNo(row.get(FileTagType.FILE_EXT.colId()));
				file.setTrackNo(row.get(FileTagType.FILE_LENGTH.colId()));
				file.setTrackNo(row.get(FileTagType.DESCRIPTION.colId()));
				samples.add(file);
			}
		});

		return samples;
	}

	public boolean isIncludeHeader() {
		return includeHeader;
	}

	public void setIncludeHeader(boolean includeHeader) {
		this.includeHeader = includeHeader;
	}
}

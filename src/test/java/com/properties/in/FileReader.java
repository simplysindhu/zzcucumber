package com.properties.in;

public class FileReader {

	private FileReader() {
	}

	public static FileReader fileReaderFR() {
		FileReader fr = new FileReader();
		return fr;

	}

	public ConfigReader ConfigReaderCR() throws Exception {
		ConfigReader cr = new ConfigReader();
		return cr;

	}

}

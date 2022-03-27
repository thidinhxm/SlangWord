package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class FileIO {
	private final static String SLANG_WORD_FILE = "dictionary.txt";
	private final static String BACKUP_SLANG_WORD_FILE = "slang.txt";
	private final static String HISTORY_FILE = "history.txt";
	
	public static HashMap<String, HashSet<String>> readDictionary() throws IOException {
		HashMap<String, HashSet<String>> dictionary = new HashMap<>();
		File dictionaryFile = new File(SLANG_WORD_FILE);
		dictionaryFile.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(dictionaryFile));
		String line = br.readLine();
		if (line == null) {
			br.close();
			br = new BufferedReader(new FileReader(BACKUP_SLANG_WORD_FILE));
			BufferedWriter wr = new BufferedWriter(new FileWriter(SLANG_WORD_FILE));
			line = br.readLine();
			while (line != null) {
					wr.write(line + "\n");
					String[] slang = line.split("`");
					String[] definitionList = slang[1].split("| ");
					HashSet<String> definitionSet = new HashSet<>();
					for (String definition : definitionList) {
						definitionSet.add(definition);
					}
					dictionary.put(slang[0], definitionSet);
					line = br.readLine();
			}
			br.close();
			wr.close();
		} else {
			while (line != null) {
				String[] slang = line.split("`");
				String[] definitionList = slang[1].split("\\| ");
				HashSet<String> definitionSet = new HashSet<>();
				for (String definition : definitionList) {
					definitionSet.add(definition);
				}
				dictionary.put(slang[0], definitionSet);
				line = br.readLine();
			}
			br.close();
		}
		return dictionary;
	}
}

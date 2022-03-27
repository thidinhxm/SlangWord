package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;

public class FileIO {
	private final static String SLANG_WORD_FILE = "dictionary.txt";
	private final static String BACKUP_SLANG_WORD_FILE = "slang.txt";
	private final static String HISTORY_FILE = "history.txt";
	
	public static HashMap<String, ArrayList<String>> readDictionary() throws IOException {
		HashMap<String, ArrayList<String>> dictionary = new HashMap<>();
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
					ArrayList<String> definitionSet = new ArrayList<>();
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
				ArrayList<String> definitionSet = new ArrayList<>();
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
	
	public static void addNewDefinitionToFile(Dictionary dictionary, String slangword, String definition) throws IOException {
		String oldLine = dictionary.getLineBySlangWord(slangword);
		dictionary.addSlangWord(slangword, definition);
		String newLine = dictionary.getLineBySlangWord(slangword);
		Path path = Paths.get(SLANG_WORD_FILE);
		Charset charset = StandardCharsets.UTF_8;
		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceFirst(oldLine, newLine);
		Files.write(path, content.getBytes(charset));
	}
	
	public static void writeHistory(History history) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(HISTORY_FILE));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(history);
		oos.close();
	}
	
	public static History readHistory() throws IOException, ClassNotFoundException {
		File historyFile = new File(HISTORY_FILE);
		historyFile.createNewFile();
		if (historyFile.length() == 0) {
			return new History();
		}
		FileInputStream fis = new FileInputStream(historyFile);
		ObjectInputStream ois = new ObjectInputStream(fis);
		History history = (History) ois.readObject(); 
		ois.close();
		return history;
	}
}

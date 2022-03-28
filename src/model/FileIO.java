package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class FileIO {
	private final static String SLANG_WORD_FILE = "dictionary.txt";
	private final static String BACKUP_SLANG_WORD_FILE = "slang.txt";
	private final static String HISTORY_FILE = "history.txt";
	private final static String RANDOM_SLANGWORD_FILE = "random.txt";
	private final static String MAX_SCORE_FILE = "max_score.txt";
	
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
	
	public static void addNewSlangWordToFile(String slangword, String definition) throws IOException {
		File dictionaryFile = new File(SLANG_WORD_FILE);
		BufferedWriter bw = new BufferedWriter(new FileWriter(dictionaryFile, true));
		bw.write(slangword + "`" + definition + "\n");
		bw.close();
	}
	
	public static void editSlangWord(Dictionary dictionary, String slangword, String oldDefinition, String newDefinition) throws IOException {
		String oldLine = dictionary.getLineBySlangWord(slangword);
		dictionary.editSlangWord(slangword, oldDefinition, newDefinition);
		String newLine = dictionary.getLineBySlangWord(slangword);
		Path path = Paths.get(SLANG_WORD_FILE);
		Charset charset = StandardCharsets.UTF_8;
		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceFirst(oldLine, newLine);
		Files.write(path, content.getBytes(charset));
	}
	
	public static void deleteSlangWordFromFile(Dictionary dictionary, String slangword, String definition) throws IOException {
		String oldLine = dictionary.getLineBySlangWord(slangword);
		String newLine = "";
		dictionary.deleteSlangWord(slangword, definition);
		if (oldLine.contains("|")) {
			newLine = dictionary.getLineBySlangWord(slangword);
		}
		else {
			oldLine += "\n";
		}
		Path path = Paths.get(SLANG_WORD_FILE);
		Charset charset = StandardCharsets.UTF_8;
		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceFirst(oldLine, newLine);
		Files.write(path, content.getBytes(charset));
	}
	
	public static void resetDictionary() throws IOException {
		Path pathDictionary = Paths.get(SLANG_WORD_FILE);
		Path pathBackUp = Paths.get(BACKUP_SLANG_WORD_FILE);
		Charset charset = StandardCharsets.UTF_8;
		String content = new String(Files.readAllBytes(pathBackUp), charset);
		Files.write(pathDictionary, content.getBytes(charset));
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
	
	public static void writeRandomSlangWordThisDay(String slangword) throws IOException {
		File randomFile = new File(RANDOM_SLANGWORD_FILE);
		randomFile.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(randomFile));
		bw.write(slangword + "\n");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		bw.write(dateFormat.format(date));
		bw.close();
	}
	
	public static String readRandomSlangWordThisDay() throws IOException {
		String randomSlangWord = "";
		File randomFile = new File(RANDOM_SLANGWORD_FILE);
		randomFile.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(randomFile));
		randomSlangWord += br.readLine();
		randomSlangWord += "\n";
		randomSlangWord += br.readLine();
		br.close();
		return randomSlangWord;
	}
	
	public static int readMaxScore() throws IOException {
		File maxScoreFile = new File(MAX_SCORE_FILE);
		maxScoreFile.createNewFile();
		if (maxScoreFile.length() == 0) {
			return 0;
		}
		BufferedReader br = new BufferedReader(new FileReader(maxScoreFile));
		int maxScore = Integer.parseInt(br.readLine());
		br.close();
		return maxScore;
	}
	
	public static void writeMaxScore(int maxScore) throws IOException {
		File maxScoreFile = new File(MAX_SCORE_FILE);
		maxScoreFile.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(maxScoreFile));
		bw.write(maxScore + "");
		bw.close();
	}
	
}

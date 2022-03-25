package model;

import java.util.ArrayList;
import java.util.HashMap;

public class SlangWordModel {
	private HashMap<String, String> dictionary;
	private ArrayList<SearchWord> history;
	private static String slangFile;
	private static String backUpSlangFile;
	
	public SlangWordModel() {
		dictionary = new HashMap<>();
		history = new ArrayList<>();
	}
	
	public String searchBySlangWord(String slangWord) {
		return dictionary.get(slangWord);
	}
	
	public HashMap<String, String> searchByDefinition(String definition) {
		return new HashMap<String, String>();
	}
	
	public ArrayList<SearchWord> getHistory() {
		return history;
	}
	
	public void addSearchWordToHistory(SearchWord searchWord) {
		
	}
	
	public void addSlangWord(String slangWord, String definition) {
		
	}
	
	public void editSlangWord(String slangWord) {
		
	}
	
	public void resetSlangWord() {
		
	}
	
	public String getRandomSlangWord() {
		return "";
	}
	
}

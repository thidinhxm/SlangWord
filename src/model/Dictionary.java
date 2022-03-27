package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Dictionary {
	private HashMap<String, HashSet<String>> dictionary;
	
	public Dictionary() {
		try {
			dictionary = FileIO.readDictionary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<HashMap.Entry<String, HashSet<String>>> searchBySlangWord(String keyword) {
		ArrayList<HashMap.Entry<String, HashSet<String>>> list = new ArrayList<>();
		
		for (HashMap.Entry<String, HashSet<String>> entry : dictionary.entrySet()) {
			if (entry.getKey().toLowerCase().contains(keyword.toLowerCase())) {
				list.add(entry);
			}
		}
		return list;
	}
	
//	public ArrayList<HashMap.Entry<String, String>> searchByDefinition(String definition) {
//		return new HashMap<String, String>();
//	}
//	
	public void addSlangWord(String slangWord, String definition) {
		
	}
	
	public void editSlangWord(String slangWord) {
		
	}
	
	public void resetSlangWord() {
		
	}
	
	public String getRandomSlangWord() {
		return "";
	}
	
	public HashMap<String, HashSet<String>> getDictionary() {
		return dictionary;
	}
}

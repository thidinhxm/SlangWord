package model;

import java.util.HashMap;

public class SlangWordModel {
	private HashMap<String, String> dictionary;
	
	public SlangWordModel() {
		dictionary = new HashMap<>();
	}
	
	String searchBySlangWord(String slangWord) {
		return dictionary.get(slangWord);
	}
	
	HashMap<String, String> searchByDefinition(String definition) {
		return new HashMap<String, String>();
	}
}

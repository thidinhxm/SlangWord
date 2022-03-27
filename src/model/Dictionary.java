package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
	private HashMap<String, ArrayList<String>> dictionary;
	
	public Dictionary() {
		try {
			dictionary = FileIO.readDictionary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<HashMap.Entry<String, ArrayList<String>>> searchBySlangWord(String keyword) {
		ArrayList<HashMap.Entry<String, ArrayList<String>>> list = new ArrayList<>();
		
		for (HashMap.Entry<String, ArrayList<String>> entry : dictionary.entrySet()) {
			if (entry.getKey().toLowerCase().contains(keyword.toLowerCase())) {
				list.add(entry);
			}
		}
		return list;
	}
	
	public ArrayList<HashMap.Entry<String, ArrayList<String>>> searchByDefinition(String keyword) {
		ArrayList<HashMap.Entry<String, ArrayList<String>>> list = new ArrayList<>();
		
		for (HashMap.Entry<String, ArrayList<String>> entry : dictionary.entrySet()) {
			ArrayList<String> definitionList = new ArrayList<>();
			for (String definition : entry.getValue()) {
				if (definition.toLowerCase().contains(keyword.toLowerCase())) {
					definitionList.add(definition);
				}
			}
			if (!definitionList.isEmpty()) {
				list.add(new HashMap.SimpleEntry<String, ArrayList<String>>(entry.getKey(), definitionList));
			}
		}
		return list;
	}
	public boolean checkSlangWordExisted(String slangword) {
		return dictionary.containsKey(slangword);
	}
	
	public boolean checkDefinitionExisted(String slangword, String definition) {
		if (dictionary.containsKey(slangword)) {
			if (dictionary.get(slangword).contains(definition)) {
				return true;
			}
		}
		return false;
	}
	
	public void addSlangWord(String slangword, String definition) {
		if (dictionary.containsKey(slangword)) {
			dictionary.get(slangword).add(definition);
		}
		else {
			ArrayList<String> definitionList = new ArrayList<>();
			definitionList.add(definition);
			dictionary.put(slangword, definitionList);
		}
	}
	
	public void editSlangWord(String slangword, String oldDefinition, String newDefinition) {
		ArrayList<String> definitionList = dictionary.get(slangword);
		for (int i = 0; i < definitionList.size(); i++) {
			if (definitionList.get(i).equals(oldDefinition)) {
				definitionList.set(i, newDefinition);
				break;
			}
		}	
	}
	
	public void resetSlangWord() {
		
	}
	
	public String getRandomSlangWord() {
		return "";
	}
	
	public HashMap<String, ArrayList<String>> getDictionary() {
		return dictionary;
	}
	
	public String getLineBySlangWord(String slangword) {
		return slangword + "`" + String.join("| ", dictionary.get(slangword));
	}
}

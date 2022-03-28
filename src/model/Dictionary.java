package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

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
	
	public void deleteSlangWord(String slangword, String definition) {
		ArrayList<String> definitionList = dictionary.get(slangword);
		if (definitionList.size() == 1) {
			dictionary.remove(slangword);
		}
		else {
			definitionList.remove(definition);
		}
	}
	
	public void resetDictionary() throws IOException {
		FileIO.resetDictionary();
		dictionary = FileIO.readDictionary();
	}
	
	public String getRandomSlangWord() {
		Random random = new Random();
		int size = dictionary.keySet().size();
		int randomPosition = random.nextInt(size);
		return (String) dictionary.keySet().toArray()[randomPosition];
		
	}
	
	public HashMap<String, ArrayList<String>> getDictionary() {
		return dictionary;
	}
	
	public String getLineBySlangWord(String slangword) {
		return slangword + "`" + String.join("| ", dictionary.get(slangword));
	}
	
	public String getDefinitionString(String slangword) {
		return String.join("| ", dictionary.get(slangword));
	}
	
	
	// [Q, CA, WA1, WA2, WA3, posA, posB, posC, posD]
	public ArrayList<String> getRandomQuestionAndAnswerSlangWord() {
		ArrayList<String> result = new ArrayList<>();
		String slangword = getRandomSlangWord();
		String question = "What definition for this slang word \"" + slangword + "\"?"; 
		result.add(question);
		result.add(getDefinitionString(slangword));
		result.add(getDefinitionString(getRandomSlangWord()));
		result.add(getDefinitionString(getRandomSlangWord()));
		result.add(getDefinitionString(getRandomSlangWord()));
		Random random = new Random();
		HashSet<Integer> posAnswer = new HashSet<>();
		for (int i = 0; i < 4; i++) {
			int pos = 0;
			do {
				pos = random.nextInt(4) + 1;
			} while(posAnswer.contains(pos));
			
			posAnswer.add(pos);
			result.add(pos + "");
		}
		return result;
	}
	
	public ArrayList<String> getRandomQuestionAndAnswerDefinition() {
		ArrayList<String> result = new ArrayList<>();
		String slangword = getRandomSlangWord();
		String question = "What slang word for this definition \"" + getDefinitionString(slangword) + "\"?";
		result.add(question);
		result.add(slangword);
		result.add(getRandomSlangWord());
		result.add(getRandomSlangWord());
		result.add(getRandomSlangWord());
		Random random = new Random();
		HashSet<Integer> posAnswer = new HashSet<>();
		for (int i = 0; i < 4; i++) {
			int pos = 0;
			do {
				pos = random.nextInt(4) + 1;
			} while(posAnswer.contains(pos));
			
			posAnswer.add(pos);
			result.add(pos + "");
		}
		return result;
	}
}

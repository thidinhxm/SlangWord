package model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class History implements Serializable {
	private ArrayList<SearchWord> history;
	public History() {
		history = new ArrayList<>();
	}
	
	public ArrayList<SearchWord> getHistory() {
		return history;
	}
	
	public void addSearchWordToHistory(SearchWord word) throws IOException {
		history.add(word);
		FileIO.writeHistory(this);
	}
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import model.SearchWord;
import view.DictionaryPanel;
import view.HistoryPanel;
import view.SlangWordView;

public class SlangWordController implements ActionListener {
	private SlangWordView view;
	
	public SlangWordController(SlangWordView view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
//		JOptionPane.showMessageDialog(dictionaryView, "You have just enter " + command);
		if (command.equals("Search")) {
			String keyword = ((DictionaryPanel) view.getDictionaryView()).getSearchWord();
			String searchType = ((DictionaryPanel) view.getDictionaryView()).getSearchType();
			int result = ((DictionaryPanel) view.getDictionaryView()).search(keyword, searchType);
			LocalDateTime now = LocalDateTime.now(); 
			SearchWord word = new SearchWord(keyword, searchType, now, result + " results found");
			((HistoryPanel) view.getHistoryView()).addSearchWordToHistoryTable(word);
			try {
				view.getHistory().addSearchWordToHistory(word);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (command.equals("Add")) {
			
		}
		else if (command.equals("Edit")) {
			
		}
		else if (command.equals("Delete")) {
			
		}
		else if (command.equals("Reset")) {
			
		}
	}

}

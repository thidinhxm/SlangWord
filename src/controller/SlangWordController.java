package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.FileIO;
import model.SearchWord;
import view.DictionaryPanel;
import view.HistoryPanel;
import view.GamePanel;
import view.SlangWordView;

public class SlangWordController implements ActionListener {
	private SlangWordView view;
	
	public SlangWordController(SlangWordView view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "You have just enter " + command);
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
			String slangword = ((DictionaryPanel) view.getDictionaryView()).getSlangWord().toUpperCase().trim();
			String definition = ((DictionaryPanel) view.getDictionaryView()).getDefinition().trim();
			
			if (slangword.trim().equals("") || definition.trim().equals("")) {
				JOptionPane.showMessageDialog(view, "Please enter slang word and definition");
			} else {
				if (view.getDictionary().checkSlangWordExisted(slangword)) {
					if (view.getDictionary().checkDefinitionExisted(slangword, definition)) {
						JOptionPane.showMessageDialog(view, "The slang word and definition existed");
					} else {
						int choice = JOptionPane.showConfirmDialog(
								view, 
								"The slang word existed. Do you want to add new definition?", 
								"Notification", 
								JOptionPane.YES_NO_OPTION
								);
						if (choice == JOptionPane.YES_OPTION) {
							try {
								FileIO.addNewDefinitionToFile(view.getDictionary(), slangword, definition);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(view, "Add a new definition successfully");
						}
					}
				} else {
					view.getDictionary().addSlangWord(slangword, definition);
					try {
						FileIO.addNewSlangWordToFile(slangword, definition);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(view, "Add a new slang word successfully");
				}
				
			}
		}
		else if (command.equals("Edit")) {
			String slangword = ((DictionaryPanel) view.getDictionaryView()).getSlangWord().toUpperCase().trim();
			String definition = ((DictionaryPanel) view.getDictionaryView()).getDefinition().trim();
			if (view.getDictionary().checkDefinitionExisted(slangword, definition)) {
		            String newDefinition = JOptionPane.showInputDialog("Enter new definition");
		            try {
						FileIO.editSlangWord(view.getDictionary(), slangword, definition, newDefinition);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            JOptionPane.showMessageDialog(view, "Edit this slang word successfully");
			} else {
				JOptionPane.showMessageDialog(view, "Please enter correct slang word and definition");
			}
		}
		else if (command.equals("Delete")) {
			String slangword = ((DictionaryPanel) view.getDictionaryView()).getSlangWord().toUpperCase().trim();
			String definition = ((DictionaryPanel) view.getDictionaryView()).getDefinition().trim();
			if (view.getDictionary().checkDefinitionExisted(slangword, definition)) {
				int choice = JOptionPane.showConfirmDialog(
						view, 
						"Do you really want to delete the slang word with this definition?", 
						"Confirm Delete Slang Word", 
						JOptionPane.YES_NO_OPTION
						);
				if (choice == JOptionPane.YES_OPTION) {
					try {
						FileIO.deleteSlangWordFromFile(view.getDictionary(), slangword, definition);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(view, "Delete the slang word with this definition successfully");
				}
			} else {
				JOptionPane.showMessageDialog(view, "Please enter correct slang word and definition");
			}
		}
		else if (command.equals("Cancel")) {
			((DictionaryPanel) view.getDictionaryView()).clearTextFieldSlang();
		}
		else if (command.equals("Reset Dictionary")) {
			int choice = JOptionPane.showConfirmDialog(
					view, 
					"Do you really want to reset the dictionary?", 
					"Confirm Reset Dictionary", 
					JOptionPane.YES_NO_OPTION
					);
			if (choice == JOptionPane.YES_OPTION) {
				try {
					view.getDictionary().resetDictionary();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(view, "Reset the dictionary successfully");
			}
		}
		else if (command.equals("Random")) {
			String oldRandomSlangWordText = "";
			try {
				oldRandomSlangWordText = FileIO.readRandomSlangWordThisDay();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (oldRandomSlangWordText.length() > 0) {
				String oldSlangWord = oldRandomSlangWordText.split("\n")[0];
				String time = oldRandomSlangWordText.split("\n")[1].split(" ")[0];
				if (time.length() > 0) {
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date now = new Date();
					String nowString = dateFormat.format(now);
					if (nowString.contains(time)) {
						((GamePanel) view.getGameView()).setTextRandomSlangWord(oldSlangWord, view.getDictionary().getDefinitionString(oldSlangWord));
					}
					else {
						String randomSlangWord = view.getDictionary().getRandomSlangWord();
						String randomDefintion = view.getDictionary().getDefinitionString(randomSlangWord);
						((GamePanel) view.getGameView()).setTextRandomSlangWord(randomSlangWord, randomDefintion);
						try {
							FileIO.writeRandomSlangWordThisDay(randomSlangWord);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else {
					String randomSlangWord = view.getDictionary().getRandomSlangWord();
					String randomDefintion = view.getDictionary().getDefinitionString(randomSlangWord);
					((GamePanel) view.getGameView()).setTextRandomSlangWord(randomSlangWord, randomDefintion);
					try {
						FileIO.writeRandomSlangWordThisDay(randomSlangWord);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else {
				String randomSlangWord = view.getDictionary().getRandomSlangWord();
				String randomDefintion = view.getDictionary().getDefinitionString(randomSlangWord);
				((GamePanel) view.getGameView()).setTextRandomSlangWord(randomSlangWord, randomDefintion);
				try {
					FileIO.writeRandomSlangWordThisDay(randomSlangWord);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		else if (command.equals("Play Now")) {
			ArrayList<String> questionAndAnswerList = null;
			String typeGame = ((GamePanel) view.getGameView()).getTypeGame();
			if (typeGame.equals("Slang Word")) {
				questionAndAnswerList = view.getDictionary().getRandomQuestionAndAnswerSlangWord();
			}
			else {
				questionAndAnswerList = view.getDictionary().getRandomQuestionAndAnswerDefinition();
			}
			
			((GamePanel) view.getGameView()).createQuestionAndAnwser(questionAndAnswerList);
			((GamePanel) view.getGameView()).setVisibleQuestion(true);
			((GamePanel) view.getGameView()).setEnabledNextQuestionBtn(false);
			((GamePanel) view.getGameView()).setVisiblePlayNowBtn(false);
		}
		else if (command.equals("Next Question")) {
			((GamePanel) view.getGameView()).setEnabledAnswerBtn(true);
			ArrayList<String> questionAndAnswerList = null;
			String typeGame = ((GamePanel) view.getGameView()).getTypeGame();
			if (typeGame.equals("Slang Word")) {
				questionAndAnswerList = view.getDictionary().getRandomQuestionAndAnswerSlangWord();
			}
			else {
				questionAndAnswerList = view.getDictionary().getRandomQuestionAndAnswerDefinition();
			}
			((GamePanel) view.getGameView()).createQuestionAndAnwser(questionAndAnswerList);
			((GamePanel) view.getGameView()).setEnabledNextQuestionBtn(false);
		}
		else if (command.equals("End")) {
			int choice = JOptionPane.showConfirmDialog(
					view, 
					"Do you really want to end this game?", 
					"Confirm end game", 
					JOptionPane.YES_NO_OPTION
					);
			if (choice == JOptionPane.YES_OPTION) {
				((GamePanel) view.getGameView()).setVisibleQuestion(false);
				((GamePanel) view.getGameView()).setVisiblePlayNowBtn(true);
			}
			
		}
	}

}

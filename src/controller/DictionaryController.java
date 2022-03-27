package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.DictionaryPanel;

public class DictionaryController implements ActionListener {
	private DictionaryPanel view;
	
	public DictionaryController(DictionaryPanel view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		JOptionPane.showMessageDialog(view, "You have just enter " + command);
		if (command.equals("Search")) {
			view.search();
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

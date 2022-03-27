package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Dictionary;
import model.SearchWord;

public class DictionaryPanel extends JPanel {

	private JTable tableDictionary;
	private DefaultTableModel tableModel;
	private JTextField textFieldSearch;
	private JTextField textFieldSlangWord;
	private JTextField textFieldDefinition;
	private Dictionary dictionaryModel;
	private JComboBox<String> comboBoxSearchType;
	/**
	 * Create the panel.
	 */
	public DictionaryPanel(Dictionary dictionaryModel, ActionListener action) {
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(244, 164, 96));
		this.setLayout(null);
		
		this.dictionaryModel = dictionaryModel;
		
		
		textFieldSearch = new JTextField("Enter keyword");
		textFieldSearch.addFocusListener(new FocusAdapter() {
			@Override
		    public void focusGained(FocusEvent e) {
		        if (textFieldSearch.getText().equals("Enter keyword")) {
		        	textFieldSearch.setText("");
		        	textFieldSearch.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (textFieldSearch.getText().isEmpty()) {
		        	textFieldSearch.setForeground(Color.GRAY);
		        	textFieldSearch.setText("Enter keyword");
		        }
		    }
		});
		textFieldSearch.setForeground(Color.GRAY);
		textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(240, 27, 467, 54);
		this.add(textFieldSearch);
		
		comboBoxSearchType = new JComboBox<>();
		comboBoxSearchType.addItem("Slang Word");
		comboBoxSearchType.addItem("Definition");
		comboBoxSearchType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxSearchType.setBounds(45, 26, 147, 54);
		this.add(comboBoxSearchType);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(action);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(752, 26, 104, 54);
		this.add(btnSearch);
		
		textFieldSlangWord = new JTextField("Enter slang word");
		textFieldSlangWord.addFocusListener(new FocusAdapter() {
			@Override
		    public void focusGained(FocusEvent e) {
		        if (textFieldSlangWord.getText().equals("Enter slang word")) {
		        	textFieldSlangWord.setText("");
		        	textFieldSlangWord.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (textFieldSlangWord.getText().isEmpty()) {
		        	textFieldSlangWord.setForeground(Color.GRAY);
		        	textFieldSlangWord.setText("Enter slang word");
		        }
		    }
		});
		textFieldSlangWord.setForeground(Color.GRAY);
		textFieldSlangWord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldSlangWord.setColumns(10);
		textFieldSlangWord.setBounds(45, 516, 554, 54);
		this.add(textFieldSlangWord);
		
		textFieldDefinition = new JTextField("Enter definition");
		textFieldDefinition.addFocusListener(new FocusAdapter() {
			@Override
		    public void focusGained(FocusEvent e) {
		        if (textFieldDefinition.getText().equals("Enter definition")) {
		        	textFieldDefinition.setText("");
		        	textFieldDefinition.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (textFieldDefinition.getText().isEmpty()) {
		        	textFieldDefinition.setForeground(Color.GRAY);
		        	textFieldDefinition.setText("Enter definition");
		        }
		    }
		});
		textFieldDefinition.setForeground(Color.GRAY);
		textFieldDefinition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDefinition.setColumns(10);
		textFieldDefinition.setBounds(45, 594, 554, 54);
		this.add(textFieldDefinition);
		
		JScrollPane scrollPaneDictionary = new JScrollPane();
		scrollPaneDictionary.setBounds(45, 121, 811, 357);
		this.add(scrollPaneDictionary);
		
		tableDictionary = new JTable();
		tableDictionary.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Slang Word", "Definition"
			}
		));
		tableDictionary.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableDictionary.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableDictionary.getColumnModel().getColumn(2).setPreferredWidth(500);
		tableDictionary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tableDictionary.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 20 ));
		tableDictionary.setRowHeight(25);
		scrollPaneDictionary.setViewportView(tableDictionary);
		tableModel = (DefaultTableModel) tableDictionary.getModel();
		displayDictionary();
		tableDictionary.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String slangword = tableDictionary.getValueAt(tableDictionary.getSelectedRow(), 1).toString();
				String definition = tableDictionary.getValueAt(tableDictionary.getSelectedRow(), 2).toString();
				textFieldSlangWord.setText(slangword);
				textFieldSlangWord.setForeground(Color.BLACK);
				textFieldDefinition.setText(definition);
				textFieldDefinition.setForeground(Color.BLACK);
			}
			
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(action);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(752, 515, 104, 54);
		this.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(action);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(638, 593, 104, 54);
		this.add(btnDelete);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(action);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(638, 515, 104, 54);
		this.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(action);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(752, 593, 104, 54);
		this.add(btnReset);
	}
	
	public int search(String keyword, String searchType) {
		ArrayList<HashMap.Entry<String, ArrayList<String>>> result = new ArrayList<>();
		tableModel.setRowCount(0);
		if (searchType.equals("Slang Word")) {
			  result = dictionaryModel.searchBySlangWord(keyword);
		}
		else {
			result = dictionaryModel.searchByDefinition(keyword);
		}
		int size = 0;
		for (HashMap.Entry<String, ArrayList<String>> entry : result) {
			addSlangWordToTable(entry, tableModel.getRowCount() + 1);  
			size += entry.getValue().size();
		}
		return size;
		
	}
	
	public void addSlangWordToTable(HashMap.Entry<String, ArrayList<String>> entry, int position) {
		for (String definition : entry.getValue()) {
			tableModel.addRow(new Object[] {
					position++ + "",
					entry.getKey(),
					definition
			});
		}
	}
	
	public void displayDictionary() {
		tableModel.setRowCount(0);
		for (HashMap.Entry<String, ArrayList<String>> entry : dictionaryModel.getDictionary().entrySet()) {
			addSlangWordToTable(entry, tableDictionary.getRowCount() + 1);
		}
	}

	
	public String getSearchType() {
		return "" + comboBoxSearchType.getSelectedItem();
	}
	
	public String getSearchWord() {
		return textFieldSearch.getText();
	}
	
	public String getSlangWord() {
		return textFieldSlangWord.getText();
	}
	
	public String getDefinition() {
		return textFieldDefinition.getText();
	}
}

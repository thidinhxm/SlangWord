package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Dictionary;
import model.SearchWord;
import javax.swing.JLabel;

public class DictionaryPanel extends JPanel {

	private JTable tableDictionary;
	private DefaultTableModel tableModel;
	private JTextField textFieldSearch;
	private JTextField textFieldSlangWord;
	private JTextField textFieldDefinition;
	private Dictionary dictionaryModel;
	private JComboBox<String> comboBoxSearchType;
	private JTextField txtSlangWord;
	private JTextField txtDefinition;
	private JTextField txtKeyword;
	/**
	 * Create the panel.
	 */
	public DictionaryPanel(Dictionary dictionaryModel, ActionListener action) {
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(244, 164, 96));
		this.setLayout(null);
		
		this.dictionaryModel = dictionaryModel;
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(action);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(549, 26, 104, 54);
		this.add(btnSearch);
		
		textFieldSearch = new JTextField("");
		textFieldSearch.setForeground(Color.GRAY);
		textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(140, 27, 242, 54);
		textFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changeDictionaryTable();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changeDictionaryTable();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changeDictionaryTable();
			}
			
			public void changeDictionaryTable() {
				if (textFieldSearch.getText().length() == 0) {
					displayDictionary();
				}

			}
			
		});
		this.add(textFieldSearch);
		
		comboBoxSearchType = new JComboBox<>();
		comboBoxSearchType.addItem("Slang Word");
		comboBoxSearchType.addItem("Definition");
		comboBoxSearchType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxSearchType.setBounds(392, 26, 147, 54);
		this.add(comboBoxSearchType);
		
		
		
		textFieldSlangWord = new JTextField("");
		textFieldSlangWord.setForeground(Color.GRAY);
		textFieldSlangWord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldSlangWord.setColumns(10);
		textFieldSlangWord.setBounds(164, 516, 435, 54);
		this.add(textFieldSlangWord);
		
		textFieldDefinition = new JTextField("");
		textFieldDefinition.setForeground(Color.GRAY);
		textFieldDefinition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDefinition.setColumns(10);
		textFieldDefinition.setBounds(164, 594, 435, 54);
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
		tableDictionary.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDictionary.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableDictionary.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableDictionary.getColumnModel().getColumn(2).setPreferredWidth(500);
		tableDictionary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tableDictionary.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 20 ));
		tableDictionary.setRowHeight(25);
		scrollPaneDictionary.setViewportView(tableDictionary);
		tableModel = (DefaultTableModel) tableDictionary.getModel();
		displayDictionary();
		tableDictionary.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableDictionary.getSelectedRow();
				if (row >= 0) {
					String slangword = tableModel.getValueAt(row, 1) + "";
					String definition = tableModel.getValueAt(row, 2) + "";
					textFieldSlangWord.setText(slangword);
					textFieldDefinition.setText(definition);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		add(btnAdd);
		
		JButton btnReset = new JButton("Reset Dictionary");
		btnReset.addActionListener(action);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(663, 26, 193, 54);
		add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(action);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(752, 594, 104, 54);
		add(btnCancel);
		
		txtSlangWord = new JTextField("Slang Word:");
		txtSlangWord.setEditable(false);
		txtSlangWord.setForeground(Color.GRAY);
		txtSlangWord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSlangWord.setColumns(10);
		txtSlangWord.setBounds(45, 516, 120, 54);
		add(txtSlangWord);
		
		txtDefinition = new JTextField("Definition:");
		txtDefinition.setForeground(Color.GRAY);
		txtDefinition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDefinition.setEditable(false);
		txtDefinition.setColumns(10);
		txtDefinition.setBounds(45, 594, 120, 54);
		add(txtDefinition);
		
		txtKeyword = new JTextField("Keyword:");
		txtKeyword.setForeground(Color.GRAY);
		txtKeyword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKeyword.setEditable(false);
		txtKeyword.setColumns(10);
		txtKeyword.setBounds(45, 27, 95, 54);
		add(txtKeyword);
		
	}
	
	public int search(String keyword, String searchType) {
		
		ArrayList<HashMap.Entry<String, ArrayList<String>>> result = new ArrayList<>();
		int selectedRow = tableDictionary.getSelectedRow();
		if (selectedRow > 0) {
			tableModel.removeRow(selectedRow);
		}
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
	
	public void clearTextFieldSlang() {
		textFieldSlangWord.setText("");
		textFieldDefinition.setText("");
	}
}

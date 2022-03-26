package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DictionaryPanel extends JPanel {

	private JTable tableDictionary;
	private JTextField textFieldSearch;
	private JTextField textFieldSlangWord;
	private JTextField textFieldDefinition;

	/**
	 * Create the panel.
	 */
	public DictionaryPanel() {
//		JPanel this = new JPanel();
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(244, 164, 96));
//		tabbedPaneMenu.addTab("Dictionary", null, this, null);
		this.setLayout(null);
		
		JLabel lblResut = new JLabel("");
		lblResut.setForeground(Color.BLACK);
		lblResut.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblResut.setBounds(192, 173, 189, 54);
		this.add(lblResut);
		
		JScrollPane scrollPaneDictionary = new JScrollPane();
		scrollPaneDictionary.setBounds(45, 121, 811, 357);
		this.add(scrollPaneDictionary);
		
		tableDictionary = new JTable();
		tableDictionary.setEnabled(false);
		tableDictionary.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Slang Word", "Definition"
			}
		));
		tableDictionary.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableDictionary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tableDictionary.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 20 ));
		tableDictionary.setRowHeight(25);
		scrollPaneDictionary.setViewportView(tableDictionary);
		
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
		textFieldSearch.setBounds(45, 27, 467, 54);
		this.add(textFieldSearch);
		
		JComboBox<String> comboBoxSearchType = new JComboBox<>();
		comboBoxSearchType.addItem("Slang Word");
		comboBoxSearchType.addItem("Definition");
		comboBoxSearchType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxSearchType.setBounds(555, 26, 147, 54);
		this.add(comboBoxSearchType);
		
		JButton btnSearch = new JButton("Search");
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
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(752, 515, 104, 54);
		this.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(638, 593, 104, 54);
		this.add(btnDelete);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(638, 515, 104, 54);
		this.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(752, 593, 104, 54);
		this.add(btnReset);
	}

}

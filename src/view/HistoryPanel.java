package view;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.History;
import model.SearchWord;

public class HistoryPanel extends JPanel {

	private JTable tableHistory;
	private DefaultTableModel tableModel;
	private History historyModel;
	/**
	 * Create the panel.
	 */
	public HistoryPanel(History historyModel) {
		this.setBackground(new Color(244, 164, 96));
		this.setLayout(null);
		
		this.historyModel = historyModel;
		
		JScrollPane scrollPaneHistory = new JScrollPane();
		scrollPaneHistory.setBounds(50, 96, 806, 543);
		this.add(scrollPaneHistory);
		
		tableHistory = new JTable();
		tableHistory.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Keyword", "Type Search", "Result", "Time"
			}
		));
		tableHistory.getColumnModel().getColumn(0).setResizable(false);
		tableHistory.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tableHistory.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 20 ));
		tableHistory.setRowHeight(25);
		
		tableModel = (DefaultTableModel) tableHistory.getModel();
		scrollPaneHistory.setViewportView(tableHistory);
		displayHistory();
		
		JLabel lblKeywordsSearched = new JLabel("100 keywords searched");
		lblKeywordsSearched.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblKeywordsSearched.setBounds(135, 22, 219, 54);
		add(lblKeywordsSearched);
		
		JLabel lblHistory = new JLabel("History: ");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHistory.setBounds(50, 22, 75, 54);
		add(lblHistory);
	}
	
	public void addSearchWordToHistoryTable(SearchWord word) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		tableModel.addRow(new Object[] {
				(tableModel.getRowCount() + 1) + "",
				word.getKeyword(),
				word.getType(),
				word.getResult(),
				word.getTime().format(formatter),
		});
	}
	
	public void displayHistory() {
		for (SearchWord word : historyModel.getHistory()) {
			addSearchWordToHistoryTable(word);
		}
	}

}

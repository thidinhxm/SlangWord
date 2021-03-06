package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.FileIO;
import model.History;
import model.SearchWord;
import javax.swing.JButton;

public class HistoryPanel extends JPanel {

	private JTable tableHistory;
	private DefaultTableModel tableModel;
	private History historyModel;
	private JButton btnClearHistory;
	private JButton btnClearSearch;
	private JLabel lblKeywordsSearched;
	/**
	 * Create the panel.
	 */
	public HistoryPanel(History historyModel, ActionListener action) {
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
		tableHistory.getColumnModel().getColumn(1).setResizable(false);
		tableHistory.getColumnModel().getColumn(2).setResizable(false);
		tableHistory.getColumnModel().getColumn(3).setResizable(false);
		tableHistory.getColumnModel().getColumn(4).setResizable(false);
		tableHistory.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableHistory.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableHistory.getColumnModel().getColumn(2).setPreferredWidth(130);
		tableHistory.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableHistory.getColumnModel().getColumn(4).setPreferredWidth(200);
		tableHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tableHistory.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 20 ));
		tableHistory.setRowHeight(25);
		
		tableModel = (DefaultTableModel) tableHistory.getModel();
		scrollPaneHistory.setViewportView(tableHistory);
		displayHistory();
		
		lblKeywordsSearched = new JLabel(historyModel.getHistory().size() + " Searched");
		lblKeywordsSearched.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblKeywordsSearched.setBounds(135, 22, 219, 54);
		add(lblKeywordsSearched);
		
		JLabel lblHistory = new JLabel("History: ");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHistory.setBounds(50, 22, 75, 54);
		add(lblHistory);
		
		btnClearHistory = new JButton("Clear History");
		btnClearHistory.addActionListener(action);
		btnClearHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClearHistory.setBounds(491, 22, 175, 54);
		add(btnClearHistory);
		
		btnClearSearch = new JButton("Clear Search");
		btnClearSearch.addActionListener(action);
		btnClearSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClearSearch.setBounds(681, 22, 175, 54);
		add(btnClearSearch);
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
	
	public void clearHistory() throws IOException {
		tableModel.setRowCount(0);
		FileIO.clearHistory();
		historyModel = new History();
		setLblKeywordsSearched("0 Searched");
	}
	
	public void setLblKeywordsSearched(String txt) {
		lblKeywordsSearched.setText(txt);
	}
	
	public void clearSearch() throws IOException {
		int row = tableHistory.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "You have not chosen a search row");
		}
		else {
			String keyword = tableModel.getValueAt(row, 1) + "";
			String searchType = tableModel.getValueAt(row, 2) + "";
			String result = tableModel.getValueAt(row, 3) + "";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String time = tableModel.getValueAt(row, 4) + "";
			
			for (SearchWord e : historyModel.getHistory()) {
				String eTime = e.getTime().format(formatter);
				if (e.getKeyword().equals(keyword) && e.getType().equals(searchType) && e.getResult().equals(result) && eTime.equals(time)) {
					historyModel.getHistory().remove(e);
					break;
				}
			}
			FileIO.writeHistory(historyModel);
			tableModel.removeRow(row);
			JOptionPane.showMessageDialog(this, "Clear a search successfully");
		}
	}

}

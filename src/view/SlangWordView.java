package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;

public class SlangWordView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlangWordView frame = new SlangWordView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SlangWordView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(245, 245, 220));
		panelTitle.setBounds(0, 0, 1126, 37);
		contentPane.add(panelTitle);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblTitle = new JLabel("Slang Word");
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelTitle.add(lblTitle);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.ORANGE);
		panelMenu.setBounds(0, 36, 224, 683);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelMenuSearchDefinition = new JPanel();
		panelMenuSearchDefinition.setLayout(null);
		panelMenuSearchDefinition.setBounds(0, 77, 224, 57);
		panelMenu.add(panelMenuSearchDefinition);
		
		JLabel lblMenuSearchDefinition = new JLabel("Search Definition");
		lblMenuSearchDefinition.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuSearchDefinition.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuSearchDefinition.setBounds(0, 0, 224, 57);
		panelMenuSearchDefinition.add(lblMenuSearchDefinition);
		
		JPanel panelMenuSearchSlangWord = new JPanel();
		panelMenuSearchSlangWord.setLayout(null);
		panelMenuSearchSlangWord.setBounds(0, 10, 224, 57);
		panelMenu.add(panelMenuSearchSlangWord);
		
		JLabel lblMenuSearchSlangWord = new JLabel("Search Slang Word");
		lblMenuSearchSlangWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuSearchSlangWord.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuSearchSlangWord.setBounds(0, 0, 224, 57);
		panelMenuSearchSlangWord.add(lblMenuSearchSlangWord);
		
		JPanel panelMenuShowHistory = new JPanel();
		panelMenuShowHistory.setLayout(null);
		panelMenuShowHistory.setBounds(0, 144, 224, 57);
		panelMenu.add(panelMenuShowHistory);
		
		JLabel lblMenuShowHistory = new JLabel("Show History");
		lblMenuShowHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuShowHistory.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuShowHistory.setBounds(0, 0, 224, 57);
		panelMenuShowHistory.add(lblMenuShowHistory);
		
		JPanel panelMenuAdd = new JPanel();
		panelMenuAdd.setLayout(null);
		panelMenuAdd.setBounds(0, 210, 224, 57);
		panelMenu.add(panelMenuAdd);
		
		JLabel lblMenuAdd = new JLabel("Add");
		lblMenuAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuAdd.setBounds(0, 0, 224, 57);
		panelMenuAdd.add(lblMenuAdd);
		
		JPanel panelMenuEdit = new JPanel();
		panelMenuEdit.setLayout(null);
		panelMenuEdit.setBounds(0, 277, 224, 57);
		panelMenu.add(panelMenuEdit);
		
		JLabel lblMenuEdit = new JLabel("Edit");
		lblMenuEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuEdit.setBounds(0, 0, 224, 57);
		panelMenuEdit.add(lblMenuEdit);
		
		JPanel panelMenuDelete = new JPanel();
		panelMenuDelete.setLayout(null);
		panelMenuDelete.setBounds(0, 343, 224, 57);
		panelMenu.add(panelMenuDelete);
		
		JLabel lblMenuDelete = new JLabel("Delete");
		lblMenuDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuDelete.setBounds(0, 0, 224, 57);
		panelMenuDelete.add(lblMenuDelete);
		
		JPanel panelMenuReset = new JPanel();
		panelMenuReset.setLayout(null);
		panelMenuReset.setBounds(0, 410, 224, 57);
		panelMenu.add(panelMenuReset);
		
		JLabel lblMenuReset = new JLabel("Reset");
		lblMenuReset.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuReset.setBounds(0, 0, 224, 57);
		panelMenuReset.add(lblMenuReset);
		
		JPanel panelMenuRandom = new JPanel();
		panelMenuRandom.setLayout(null);
		panelMenuRandom.setBounds(0, 477, 224, 57);
		panelMenu.add(panelMenuRandom);
		
		JLabel lblMenuRandom = new JLabel("Random");
		lblMenuRandom.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuRandom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuRandom.setBounds(0, 0, 224, 57);
		panelMenuRandom.add(lblMenuRandom);
		
		JPanel panelMenuQuizSlangWord = new JPanel();
		panelMenuQuizSlangWord.setLayout(null);
		panelMenuQuizSlangWord.setBounds(0, 544, 224, 57);
		panelMenu.add(panelMenuQuizSlangWord);
		
		JLabel lblMenuQuizSlangWord = new JLabel("Quiz Slang Word");
		lblMenuQuizSlangWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuQuizSlangWord.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuQuizSlangWord.setBounds(0, 0, 224, 57);
		panelMenuQuizSlangWord.add(lblMenuQuizSlangWord);
		
		JPanel panelMenuQuizDefinition = new JPanel();
		panelMenuQuizDefinition.setLayout(null);
		panelMenuQuizDefinition.setBounds(0, 611, 224, 57);
		panelMenu.add(panelMenuQuizDefinition);
		
		JLabel lblMenuQuizDefinition = new JLabel("Quiz Definition");
		lblMenuQuizDefinition.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuQuizDefinition.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuQuizDefinition.setBounds(0, 0, 224, 57);
		panelMenuQuizDefinition.add(lblMenuQuizDefinition);
		
		JTabbedPane tabbedPaneMenu = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneMenu.setBounds(223, 10, 906, 710);
		contentPane.add(tabbedPaneMenu);
		
		JPanel panelSearchSlangWord = new JPanel();
		panelSearchSlangWord.setBackground(new Color(244, 164, 96));
		tabbedPaneMenu.addTab("Search Slang Word", null, panelSearchSlangWord, null);
		
		JPanel panelSearchDefinition = new JPanel();
		panelSearchDefinition.setBackground(new Color(135, 206, 235));
		tabbedPaneMenu.addTab("Search Definition", null, panelSearchDefinition, null);
		
		JPanel panelShowHistory = new JPanel();
		panelShowHistory.setBackground(new Color(178, 34, 34));
		tabbedPaneMenu.addTab("Show History", null, panelShowHistory, null);
		
		JPanel panelAdd = new JPanel();
		panelAdd.setBackground(new Color(128, 128, 128));
		tabbedPaneMenu.addTab("Add", null, panelAdd, null);
		
		JPanel panelEdit = new JPanel();
		panelEdit.setBackground(new Color(255, 0, 0));
		tabbedPaneMenu.addTab("Edit", null, panelEdit, null);
		
		JPanel panelDelete = new JPanel();
		tabbedPaneMenu.addTab("Delete", null, panelDelete, null);
		
		JPanel panelReset = new JPanel();
		tabbedPaneMenu.addTab("Reset", null, panelReset, null);
		
		JPanel panelRandom = new JPanel();
		tabbedPaneMenu.addTab("Random", null, panelRandom, null);
		
		JPanel panelQuizSlangWord = new JPanel();
		tabbedPaneMenu.addTab("Quiz Slang Word", null, panelQuizSlangWord, null);
		
		JPanel panelQuizDefinition = new JPanel();
		tabbedPaneMenu.addTab("Quiz Definition", null, panelQuizDefinition, null);
	}
}

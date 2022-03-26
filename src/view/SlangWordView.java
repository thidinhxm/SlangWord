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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class SlangWordView extends JFrame {

	private JPanel contentPane;
	private Color defaultColor;
	private Color clickedColor;
	private JLabel lblMenuSearchAboutMe;
	private JLabel lblMenuSearch;
	private JLabel lblMenuHistory;
	private JLabel lblMenuAdd;
	private JLabel lblMenuEdit;
	private JLabel lblMenuDelete;
	private JLabel lblMenuReset;
	private JLabel lblMenuRandom;
	private JLabel lblMenuQuizSlangWord;
	private JLabel lblMenuQuizDefinition;
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
		defaultColor = Color.ORANGE;
		clickedColor = Color.WHITE;
		
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
		
		JTabbedPane tabbedPaneMenu = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneMenu.setBounds(223, 10, 906, 710);
		contentPane.add(tabbedPaneMenu);
		
		JPanel panelAboutMe = new JPanel();
		panelAboutMe.setBackground(new Color(244, 164, 96));
		tabbedPaneMenu.addTab("Search Slang Word", null, panelAboutMe, null);
		panelAboutMe.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello guys,");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 141, 98, 42);
		panelAboutMe.add(lblNewLabel);
		
		JTextArea txtrIAmA = new JTextArea();
		txtrIAmA.setText("I am a developer who enjoys developing softwares.\n"
				+ "I create a slang word application to help people\n"
				+ "easily search a slang word with more 10.000 words.\n"
				+ "You can also see keywords you searched before.\n"
				+ "Besides, you can add, edit or delete a slang word. If you\n"
				+ "want to return the default dictionary, you can reset it.\n"
				+ "Furthermore, you can play a game with random slang\n"
				+ "word. Hope you like this application.");
		txtrIAmA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtrIAmA.setBackground(new Color(244, 164, 96));
		txtrIAmA.setLineWrap(true);
		txtrIAmA.setBounds(137, 216, 514, 204);
		panelAboutMe.add(txtrIAmA);
		
		JLabel lblDinhTranXuan = new JLabel("Dinh Tran Xuan Thi");
		lblDinhTranXuan.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinhTranXuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDinhTranXuan.setBounds(138, 455, 174, 42);
		panelAboutMe.add(lblDinhTranXuan);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(135, 206, 235));
		tabbedPaneMenu.addTab("Search Definition", null, panelSearch, null);
		
		JPanel panelHistory = new JPanel();
		panelHistory.setBackground(new Color(178, 34, 34));
		tabbedPaneMenu.addTab("Show History", null, panelHistory, null);
		
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.ORANGE);
		panelMenu.setBounds(0, 36, 224, 683);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelMenuAboutMe = new JPanel();
		panelMenuAboutMe.setBackground(Color.ORANGE);
		panelMenuAboutMe.setLayout(null);
		panelMenuAboutMe.setBounds(0, 10, 224, 57);
		panelMenu.add(panelMenuAboutMe);
		
		lblMenuSearchAboutMe = new JLabel("About Me");
		lblMenuSearchAboutMe.setForeground(Color.WHITE);
		lblMenuSearchAboutMe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuAboutMe.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuAboutMe.setBackground(defaultColor);
				lblMenuSearchAboutMe.setForeground(clickedColor);
			}
		});
		lblMenuSearchAboutMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuSearchAboutMe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuSearchAboutMe.setBounds(0, 0, 224, 57);
		panelMenuAboutMe.add(lblMenuSearchAboutMe);
		
		JPanel panelMenuSearch = new JPanel();
		panelMenuSearch.setBackground(Color.ORANGE);
		panelMenuSearch.setLayout(null);
		panelMenuSearch.setBounds(0, 77, 224, 57);
		panelMenu.add(panelMenuSearch);
		
		lblMenuSearch = new JLabel("Search");
		lblMenuSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(1);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuSearch.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuSearch.setBackground(defaultColor);
				lblMenuSearch.setForeground(clickedColor);
			}
		});
		lblMenuSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuSearch.setBounds(0, 0, 224, 57);
		panelMenuSearch.add(lblMenuSearch);
		
		JPanel panelMenuHistory = new JPanel();
		panelMenuHistory.setBackground(Color.ORANGE);
		panelMenuHistory.setLayout(null);
		panelMenuHistory.setBounds(0, 144, 224, 57);
		panelMenu.add(panelMenuHistory);
		
		lblMenuHistory = new JLabel("History");
		lblMenuHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(2);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuHistory.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuHistory.setBackground(defaultColor);
				lblMenuHistory.setForeground(clickedColor);
			}
		});
		lblMenuHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuHistory.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuHistory.setBounds(0, 0, 224, 57);
		panelMenuHistory.add(lblMenuHistory);
		
		JPanel panelMenuAdd = new JPanel();
		panelMenuAdd.setBackground(Color.ORANGE);
		panelMenuAdd.setLayout(null);
		panelMenuAdd.setBounds(0, 210, 224, 57);
		panelMenu.add(panelMenuAdd);
		
		lblMenuAdd = new JLabel("Add");
		lblMenuAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(3);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuAdd.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuAdd.setBackground(defaultColor);
				lblMenuAdd.setForeground(clickedColor);
			}
		});
		lblMenuAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuAdd.setBounds(0, 0, 224, 57);
		panelMenuAdd.add(lblMenuAdd);
		
		JPanel panelMenuEdit = new JPanel();
		panelMenuEdit.setBackground(Color.ORANGE);
		panelMenuEdit.setLayout(null);
		panelMenuEdit.setBounds(0, 277, 224, 57);
		panelMenu.add(panelMenuEdit);
		
		lblMenuEdit = new JLabel("Edit");
		lblMenuEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(4);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuEdit.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuEdit.setBackground(defaultColor);
				lblMenuEdit.setForeground(clickedColor);
			}
		});
		lblMenuEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuEdit.setBounds(0, 0, 224, 57);
		panelMenuEdit.add(lblMenuEdit);
		
		JPanel panelMenuDelete = new JPanel();
		panelMenuDelete.setBackground(Color.ORANGE);
		panelMenuDelete.setLayout(null);
		panelMenuDelete.setBounds(0, 343, 224, 57);
		panelMenu.add(panelMenuDelete);
		
		lblMenuDelete = new JLabel("Delete");
		lblMenuDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(5);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuDelete.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuDelete.setBackground(defaultColor);
				lblMenuDelete.setForeground(clickedColor);
			}
		});
		lblMenuDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuDelete.setBounds(0, 0, 224, 57);
		panelMenuDelete.add(lblMenuDelete);
		
		JPanel panelMenuReset = new JPanel();
		panelMenuReset.setBackground(Color.ORANGE);
		panelMenuReset.setLayout(null);
		panelMenuReset.setBounds(0, 410, 224, 57);
		panelMenu.add(panelMenuReset);
		
		lblMenuReset = new JLabel("Reset");
		lblMenuReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(6);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuReset.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuReset.setBackground(defaultColor);
				lblMenuReset.setForeground(clickedColor);
			}
		});
		lblMenuReset.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuReset.setBounds(0, 0, 224, 57);
		panelMenuReset.add(lblMenuReset);
		
		JPanel panelMenuRandom = new JPanel();
		panelMenuRandom.setBackground(Color.ORANGE);
		panelMenuRandom.setLayout(null);
		panelMenuRandom.setBounds(0, 477, 224, 57);
		panelMenu.add(panelMenuRandom);
		
		lblMenuRandom = new JLabel("Random");
		lblMenuRandom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(7);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuRandom.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuRandom.setBackground(defaultColor);
				lblMenuRandom.setForeground(clickedColor);
			}
		});
		lblMenuRandom.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuRandom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuRandom.setBounds(0, 0, 224, 57);
		panelMenuRandom.add(lblMenuRandom);
		
		JPanel panelMenuQuizSlangWord = new JPanel();
		panelMenuQuizSlangWord.setBackground(Color.ORANGE);
		panelMenuQuizSlangWord.setLayout(null);
		panelMenuQuizSlangWord.setBounds(0, 544, 224, 57);
		panelMenu.add(panelMenuQuizSlangWord);
		
		lblMenuQuizSlangWord = new JLabel("Quiz Slang Word");
		lblMenuQuizSlangWord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(8);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuQuizSlangWord.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuQuizSlangWord.setBackground(defaultColor);
				lblMenuQuizSlangWord.setForeground(clickedColor);
			}
		});
		lblMenuQuizSlangWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuQuizSlangWord.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuQuizSlangWord.setBounds(0, 0, 224, 57);
		panelMenuQuizSlangWord.add(lblMenuQuizSlangWord);
		
		JPanel panelMenuQuizDefinition = new JPanel();
		panelMenuQuizDefinition.setBackground(Color.ORANGE);
		panelMenuQuizDefinition.setLayout(null);
		panelMenuQuizDefinition.setBounds(0, 611, 224, 57);
		panelMenu.add(panelMenuQuizDefinition);
		
		lblMenuQuizDefinition = new JLabel("Quiz Definition");
		lblMenuQuizDefinition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneMenu.setSelectedIndex(9);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuQuizDefinition.setBackground(clickedColor);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuQuizDefinition.setBackground(defaultColor);
				lblMenuQuizDefinition.setForeground(clickedColor);
			}
		});
		lblMenuQuizDefinition.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuQuizDefinition.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuQuizDefinition.setBounds(0, 0, 224, 57);
		panelMenuQuizDefinition.add(lblMenuQuizDefinition);
		
	}
	
	private void setBlackWordLabel() {
		lblMenuSearchAboutMe.setForeground(Color.BLACK);
		lblMenuSearch.setForeground(Color.BLACK);
		lblMenuHistory.setForeground(Color.BLACK);
		lblMenuAdd.setForeground(Color.BLACK);
		lblMenuEdit.setForeground(Color.BLACK);
		lblMenuDelete.setForeground(Color.BLACK);
		lblMenuReset.setForeground(Color.BLACK);
		lblMenuRandom.setForeground(Color.BLACK);
		lblMenuQuizSlangWord.setForeground(Color.BLACK);
		lblMenuQuizDefinition.setForeground(Color.BLACK);
	}
}

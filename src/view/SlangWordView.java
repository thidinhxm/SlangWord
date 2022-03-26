package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SlangWordView extends JFrame {

	private JPanel contentPane;
	private JLabel lblMenuSearchAboutMe;
	private JLabel lblMenuDictionary;
	private JLabel lblMenuHistory;
	private JLabel lblMenuGame;
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
		
		JPanel panelTitle = new TitlePanel();
		contentPane.add(panelTitle);
		
		JTabbedPane tabbedPaneMenu = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneMenu.setBounds(223, 10, 906, 710);
		tabbedPaneMenu.setEnabled(false);
		contentPane.add(tabbedPaneMenu);
		
		JPanel panelDictionary = new DictionaryPanel();
		tabbedPaneMenu.addTab("Dictionary", null, panelDictionary, null);
		
		JPanel panelHistory = new HistoryPanel();
		tabbedPaneMenu.addTab("Show History", null, panelHistory, null);
		
		JPanel panelGame = new GamePanel();
		tabbedPaneMenu.addTab("Game", null, panelGame, null);
		
		JPanel panelAboutMe = new AboutMePanel();
		tabbedPaneMenu.addTab("About Me", null, panelAboutMe, null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.ORANGE);
		panelMenu.setBounds(0, 36, 224, 683);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelMenuDictionary = new JPanel();
		panelMenuDictionary.setBackground(Color.ORANGE);
		panelMenuDictionary.setLayout(null);
		panelMenuDictionary.setBounds(0, 94, 224, 57);
		panelMenu.add(panelMenuDictionary);
		
		lblMenuDictionary = new JLabel("Dictionary");
		lblMenuDictionary.setForeground(Color.WHITE);
		lblMenuDictionary.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuDictionary.setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuDictionary.setBackground(Color.ORANGE);
				lblMenuDictionary.setForeground(Color.WHITE);
				tabbedPaneMenu.setSelectedIndex(0);
			}
		});
		lblMenuDictionary.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuDictionary.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuDictionary.setBounds(0, 0, 224, 57);
		panelMenuDictionary.add(lblMenuDictionary);
		
		JPanel panelMenuHistory = new JPanel();
		panelMenuHistory.setBackground(Color.ORANGE);
		panelMenuHistory.setLayout(null);
		panelMenuHistory.setBounds(0, 242, 224, 57);
		panelMenu.add(panelMenuHistory);
		
		lblMenuHistory = new JLabel("History");
		lblMenuHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuHistory.setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuHistory.setBackground(Color.ORANGE);
				lblMenuHistory.setForeground(Color.WHITE);
				tabbedPaneMenu.setSelectedIndex(1);
			}
		});
		lblMenuHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuHistory.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuHistory.setBounds(0, 0, 224, 57);
		panelMenuHistory.add(lblMenuHistory);
		
		JPanel panelMenuGame = new JPanel();
		panelMenuGame.setBackground(Color.ORANGE);
		panelMenuGame.setLayout(null);
		panelMenuGame.setBounds(0, 392, 224, 57);
		panelMenu.add(panelMenuGame);
		
		lblMenuGame = new JLabel("Game");
		lblMenuGame.setBounds(0, 0, 224, 57);
		panelMenuGame.add(lblMenuGame);
		lblMenuGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuGame.setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuGame.setBackground(Color.ORANGE);
				lblMenuGame.setForeground(Color.WHITE);
				tabbedPaneMenu.setSelectedIndex(2);
			}
		});
		lblMenuGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panelMenuAboutMe = new JPanel();
		panelMenuAboutMe.setBackground(Color.ORANGE);
		panelMenuAboutMe.setLayout(null);
		panelMenuAboutMe.setBounds(0, 532, 224, 57);
		panelMenu.add(panelMenuAboutMe);
		
		lblMenuSearchAboutMe = new JLabel("About Me");
		lblMenuSearchAboutMe.setForeground(new Color(0, 0, 0));
		lblMenuSearchAboutMe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setBlackWordLabel();
				panelMenuAboutMe.setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelMenuAboutMe.setBackground(Color.ORANGE);
				lblMenuSearchAboutMe.setForeground(Color.WHITE);
				tabbedPaneMenu.setSelectedIndex(3);
			}
		});
		lblMenuSearchAboutMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuSearchAboutMe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenuSearchAboutMe.setBounds(0, 0, 224, 57);
		panelMenuAboutMe.add(lblMenuSearchAboutMe);
	}
	
	private void setBlackWordLabel() {
		lblMenuSearchAboutMe.setForeground(Color.BLACK);
		lblMenuDictionary.setForeground(Color.BLACK);
		lblMenuHistory.setForeground(Color.BLACK);
		lblMenuGame.setForeground(Color.BLACK);
	}
}

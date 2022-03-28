package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SlangWordController;
import model.Dictionary;
import model.FileIO;
import model.History;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;


public class SlangWordView extends JFrame {

	private JPanel contentPane;
	private JLabel lblMenuSearchAboutMe;
	private JLabel lblMenuDictionary;
	private JLabel lblMenuHistory;
	private JLabel lblMenuGame;
	private Dictionary dictionaryModel;
	private History historyModel;
	private JPanel panelDictionary;
	private JPanel panelHistory;
	private JPanel panelGame;
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
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener((WindowListener) new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Yes","No"};
		        int choice = JOptionPane.showOptionDialog(
		        		null,
		        		"Are you sure you want to exit?",
		        		"Slang Word Dictionary",
		        		JOptionPane.DEFAULT_OPTION,
		        		JOptionPane.WARNING_MESSAGE,
		        		null,
		        		ObjButtons,
		        		ObjButtons[1]
		        		);
		        if(choice == JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
		setBounds(100, 100, 1140, 750);
		setTitle("Slang Word");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener action = new SlangWordController(this);
		
		JPanel panelTitle = new TitlePanel();
		contentPane.add(panelTitle);
		
		JTabbedPane tabbedPaneMenu = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneMenu.setBounds(223, 10, 906, 710);
		tabbedPaneMenu.setEnabled(false);
		contentPane.add(tabbedPaneMenu);
		
		dictionaryModel = new Dictionary();
		panelDictionary = new DictionaryPanel(dictionaryModel, action);
		tabbedPaneMenu.addTab("Dictionary", null, panelDictionary, null);
		
		try {
			historyModel = FileIO.readHistory();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelHistory = new HistoryPanel(historyModel);
		tabbedPaneMenu.addTab("Show History", null, panelHistory, null);
		
		panelGame = new GamePanel(action);
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
	
	public JPanel getDictionaryView() {
		return panelDictionary;
	}
	
	public JPanel getHistoryView() {
		return panelHistory;
	}
	
	public JPanel getGameView() {
		return panelGame;
	}
	
	public History getHistory() {
		return historyModel;
	}
	
	public Dictionary getDictionary() {
		return dictionaryModel;
	}
	
	
}

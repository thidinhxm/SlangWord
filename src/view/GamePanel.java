package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Dictionary;

public class GamePanel extends JPanel {

	private JTextField txtRandomSlangWord;
	private JTextField txtRandomDefinition;
	private JPanel panelQuestion;
	private JTextField textFieldMaxScore;
	private JTextField textFieldYourScore;
	private Dictionary dictionaryModel;
	private JLabel lblQuestion;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JButton btnD;
	private JComboBox<String> comboBoxGameType;
	private JButton btnPlayNow;
	private JButton btnNextQuestion;
	private int maxScore;
	/**
	 * Create the panel.
	 */
	public GamePanel(ActionListener action) {
		this.setBackground(new Color(244, 164, 96));
		this.setLayout(null);
		
		JButton btnRandom = new JButton("Random");
		btnRandom.addActionListener(action);
		btnRandom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRandom.setBounds(48, 63, 117, 54);
		this.add(btnRandom);
		
		txtRandomSlangWord = new JTextField("Slang Word:");
		txtRandomSlangWord.setEditable(false);
		txtRandomSlangWord.setForeground(Color.GRAY);
		txtRandomSlangWord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRandomSlangWord.setColumns(10);
		txtRandomSlangWord.setBounds(249, 64, 583, 54);
		this.add(txtRandomSlangWord);
		
		txtRandomDefinition = new JTextField("Definition:");
		txtRandomDefinition.setForeground(Color.GRAY);
		txtRandomDefinition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRandomDefinition.setEditable(false);
		txtRandomDefinition.setColumns(10);
		txtRandomDefinition.setBounds(249, 142, 583, 54);
		add(txtRandomDefinition);
		
		btnPlayNow = new JButton("Play Now");
		btnPlayNow.addActionListener(action);
		btnPlayNow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlayNow.setBounds(249, 276, 177, 54);
		add(btnPlayNow);
		
		comboBoxGameType = new JComboBox<String>();
		comboBoxGameType.addItem("Slang Word");
		comboBoxGameType.addItem("Definition");
		comboBoxGameType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxGameType.setBounds(48, 276, 177, 54);
		add(comboBoxGameType);
		
		panelQuestion = new JPanel();
		panelQuestion.setLayout(null);
		panelQuestion.setBackground(new Color(244, 164, 96));
		panelQuestion.setBounds(48, 358, 784, 283);
		add(panelQuestion);
		
		lblQuestion = new JLabel("");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuestion.setBounds(0, 20, 505, 54);
		panelQuestion.add(lblQuestion);
		
		btnA = new JButton("A");
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnA.setBounds(0, 103, 374, 54);
		panelQuestion.add(btnA);
		
		btnB = new JButton("B");
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnB.setBounds(410, 103, 374, 54);
		panelQuestion.add(btnB);
		
		btnC = new JButton("C");
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnC.setBounds(0, 167, 374, 54);
		panelQuestion.add(btnC);
		
		btnD = new JButton("D");
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnD.setBounds(410, 167, 374, 54);
		panelQuestion.add(btnD);
		
		btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.addActionListener(action);
		btnNextQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNextQuestion.setBounds(199, 229, 175, 54);
		panelQuestion.add(btnNextQuestion);
		
		JButton btnEnd = new JButton("End");
		btnEnd.addActionListener(action);
		btnEnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEnd.setBounds(410, 231, 175, 54);
		panelQuestion.add(btnEnd);
		
		JLabel lblYourScore = new JLabel("Your Score:");
		lblYourScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYourScore.setBounds(581, 19, 124, 54);
		panelQuestion.add(lblYourScore);
		
		textFieldYourScore = new JTextField("0");
		textFieldYourScore.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldYourScore.setForeground(Color.GRAY);
		textFieldYourScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldYourScore.setEditable(false);
		textFieldYourScore.setColumns(10);
		textFieldYourScore.setBounds(715, 21, 69, 54);
		panelQuestion.add(textFieldYourScore);
		
		JLabel lblMaxScore = new JLabel("Max Score:");
		lblMaxScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaxScore.setBounds(629, 276, 126, 54);
		add(lblMaxScore);
		
		textFieldMaxScore = new JTextField("0");
		textFieldMaxScore.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMaxScore.setForeground(Color.GRAY);
		textFieldMaxScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldMaxScore.setEditable(false);
		textFieldMaxScore.setColumns(10);
		textFieldMaxScore.setBounds(765, 277, 67, 54);
		add(textFieldMaxScore);
		panelQuestion.setVisible(false);
	}
	
	public void setVisibleQuestion(boolean choice) {
		panelQuestion.setVisible(choice);
	}
	
	public void setTextRandomSlangWord(String slangword, String definition) {
		txtRandomSlangWord.setText("Slang Word: " + slangword);
		txtRandomDefinition.setText("Definition: " + definition);
	}
	
	public void createQuestionAndAnwser(ArrayList<String> listQuestionAndAnswer) {
		
		lblQuestion.setText(listQuestionAndAnswer.get(0));
		int a = Integer.parseInt(listQuestionAndAnswer.get(5));
		int b = Integer.parseInt(listQuestionAndAnswer.get(6));
		int c = Integer.parseInt(listQuestionAndAnswer.get(7));
		int d = Integer.parseInt(listQuestionAndAnswer.get(8));
		btnA.setText(listQuestionAndAnswer.get(a));
		btnB.setText(listQuestionAndAnswer.get(b));
		btnC.setText(listQuestionAndAnswer.get(c));
		btnD.setText(listQuestionAndAnswer.get(d));
		
		setNewListener(btnA, a);
		setNewListener(btnB, b);
		setNewListener(btnC, c);
		setNewListener(btnD, d);
	}
	
	public String getTypeGame() {
		return comboBoxGameType.getSelectedItem() + "";
	}
	
	private void showDialogAnswer(String text) {
		JOptionPane.showMessageDialog(this, text);
	}
	
	public void setNewListener(JButton btn, int answer) {
		for( ActionListener al : btn.getActionListeners() ) {
			btn.removeActionListener( al );
	    }
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (answer != 1) {
					showDialogAnswer("Wrong Answer! Your score will be reseted");
					setEnabledAnswerBtn(false);
					setEnabledNextQuestionBtn(true);
				} else {
					showDialogAnswer("Correct Answer! Your score will increase");
					setEnabledAnswerBtn(true);
				}
			}
			
		});
	}
	
	public void setEnabledAnswerBtn(boolean choice) {
		btnA.setEnabled(choice);
		btnB.setEnabled(choice);
		btnC.setEnabled(choice);
		btnD.setEnabled(choice);
	}
	
	public void setVisiblePlayNowBtn(boolean choice) {
		btnPlayNow.setVisible(choice);
	}
	
	public void setEnabledNextQuestionBtn(boolean choice) {
		btnNextQuestion.setEnabled(choice);
	}
		
}

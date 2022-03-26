package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel {

	private JTextField txtRandomSlangWord;

	/**
	 * Create the panel.
	 */
	public GamePanel() {
//		JPanel this = new JPanel();
		this.setBackground(new Color(244, 164, 96));
		this.setLayout(null);
		
		JButton btnRandom = new JButton("Random");
		btnRandom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRandom.setBounds(63, 63, 158, 54);
		this.add(btnRandom);
		
		JComboBox<String> comboBoxGameType = new JComboBox<String>();
		comboBoxGameType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxGameType.setBounds(63, 197, 147, 54);
		this.add(comboBoxGameType);
		
		JButton btnPlayNow = new JButton("Play Now");
		btnPlayNow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlayNow.setBounds(266, 197, 158, 54);
		this.add(btnPlayNow);
		
		JLabel lblQuestion = new JLabel("None Question");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuestion.setBounds(63, 277, 782, 54);
		this.add(lblQuestion);
		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnA.setBounds(63, 360, 361, 54);
		this.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnB.setBounds(471, 360, 361, 54);
		this.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnC.setBounds(63, 456, 361, 54);
		this.add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnD.setBounds(471, 456, 361, 54);
		this.add(btnD);
		
		JButton btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNextQuestion.setBounds(249, 545, 175, 54);
		this.add(btnNextQuestion);
		
		JButton btnEnd = new JButton("End");
		btnEnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEnd.setBounds(471, 545, 175, 54);
		this.add(btnEnd);
		
		txtRandomSlangWord = new JTextField("");
		txtRandomSlangWord.setEditable(false);
		txtRandomSlangWord.setForeground(Color.GRAY);
		txtRandomSlangWord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRandomSlangWord.setColumns(10);
		txtRandomSlangWord.setBounds(264, 63, 568, 54);
		this.add(txtRandomSlangWord);
	}

}

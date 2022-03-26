package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AboutMePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AboutMePanel() {
		this.setBackground(new Color(244, 164, 96));
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello guys,");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 141, 98, 42);
		this.add(lblNewLabel);
		
		JTextArea txtrIAmA = new JTextArea();
		txtrIAmA.setEditable(false);
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
		txtrIAmA.setBounds(137, 216, 514, 204);
		this.add(txtrIAmA);
		
		JLabel lblDinhTranXuan = new JLabel("Dinh Tran Xuan Thi");
		lblDinhTranXuan.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinhTranXuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDinhTranXuan.setBounds(138, 455, 174, 42);
		this.add(lblDinhTranXuan);
	}

}

package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TitlePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TitlePanel() {
		this.setBackground(new Color(245, 245, 220));
		this.setBounds(0, 0, 1126, 37);
		
		this.setLayout(null);
		
		JLabel lblTitle = new JLabel("Slang Word");
		lblTitle.setBounds(504, 5, 117, 25);
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.add(lblTitle);
	}

}

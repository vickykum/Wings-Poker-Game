package PokerGame_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

public class View_Hand {

	private JFrame f = new JFrame("CheckPoint");
	private JButton back = new JButton("Back");

	public View_Hand(String hand, int num) throws IOException {
		//////////////////////////////////////////////////
		// String path = "src\\Card_PNG\\2C.png";
		String path = "src\\Ranking_PNG\\" + hand + ".png";

		File file = new File(path);
		BufferedImage img = ImageIO.read(file);
		String[] rule_reader = new RuleReader().getRules("src\\PokerGame_GUI\\allPokerRules.txt");
		System.out.println("lenght of rule:" + rule_reader.length);
		f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
		f.getContentPane().setBackground(Color.WHITE);

		//
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(1);
		flowLayout.setHgap(1);
		f.getContentPane().add(panel);
		panel.add(back);
		back.setBackground(Color.GREEN);
		
				JPanel j = new JPanel();
				j.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
				JLabel label = new JLabel("img");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				j.add(label);
				label.setText("");
				label.setIcon(new ImageIcon(img));
				
						f.getContentPane().add(j);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(1);
		flowLayout_1.setHgap(1);
		f.getContentPane().add(panel_1);
		JLabel rule_label = new JLabel("Rule Label");
		panel_1.add(rule_label);
		rule_label.setHorizontalAlignment(SwingConstants.CENTER);
	rule_label.setText("<html>" + rule_reader[num] + " "+"<br/>" + rule_reader[num + 1]+"</html>");

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
			}

		});

		f.setVisible(true);
		f.pack();
		f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

}

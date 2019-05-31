package PokerGame_GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Profile extends JFrame{
	
	public Integer userBalance = 200;
	
	public Profile(String username) {
		setExtendedState(Frame.ICONIFIED);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 102));
		getContentPane().add(panel, "name_1367497409417015");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 0, 0};
		gbl_panel.rowHeights = new int[] {0, 1, 1, 1, 1, 1, 0, 0, 0, 1};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 8;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		GridBagConstraints gbc_lblProfile = new GridBagConstraints();
		gbc_lblProfile.insets = new Insets(0, 0, 5, 0);
		gbc_lblProfile.gridx = 8;
		gbc_lblProfile.gridy = 1;
		panel.add(lblProfile, gbc_lblProfile);
		
		JLabel lblName = new JLabel("NAME : Michael");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 8;
		gbc_lblName.gridy = 2;
		panel.add(lblName, gbc_lblName);
		
		JLabel lblAge = new JLabel("AGE : 56");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.insets = new Insets(0, 0, 5, 0);
		gbc_lblAge.gridx = 8;
		gbc_lblAge.gridy = 3;
		panel.add(lblAge, gbc_lblAge);
		
		JLabel lblMoney = new JLabel("MONEY : $90");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblMoney = new GridBagConstraints();
		gbc_lblMoney.insets = new Insets(0, 0, 5, 0);
		gbc_lblMoney.gridx = 8;
		gbc_lblMoney.gridy = 4;
		panel.add(lblMoney, gbc_lblMoney);
		
		JLabel lblWins = new JLabel("WINS : 10");
		lblWins.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblWins = new GridBagConstraints();
		gbc_lblWins.insets = new Insets(0, 0, 5, 0);
		gbc_lblWins.gridx = 8;
		gbc_lblWins.gridy = 5;
		panel.add(lblWins, gbc_lblWins);
		
		
		JButton btnBack = new JButton("<- BACK");
		btnBack.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JLabel lblBluffs = new JLabel("BLUFFS : 3");
		lblBluffs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblBluffs = new GridBagConstraints();
		gbc_lblBluffs.insets = new Insets(0, 0, 5, 0);
		gbc_lblBluffs.gridx = 8;
		gbc_lblBluffs.gridy = 6;
		panel.add(lblBluffs, gbc_lblBluffs);
		
		JLabel lblTotalGames = new JLabel("TOTAL GAMES : 59");
		lblTotalGames.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTotalGames = new GridBagConstraints();
		gbc_lblTotalGames.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotalGames.gridx = 8;
		gbc_lblTotalGames.gridy = 7;
		panel.add(lblTotalGames, gbc_lblTotalGames);
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 8;
		gbc_btnBack.gridy = 8;
		panel.add(btnBack, gbc_btnBack);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, "name_1425395403287164");
		
		JLabel lblNewLabel_3 = new JLabel("SORRY YOU ARE NOT A MEMBER");
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnNewButton);
		
		if(username.equals("")) {
			panel.setVisible(false);
			panel_1.setVisible(true);
		}else {
			try {
				Update(username,lblName,lblAge,lblMoney,lblWins);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.setVisible(true);
			panel_1.setVisible(false);
		}
		
		this.setVisible(true);
		this.pack();
		
	}
	
	
	public void Update(String username, JLabel name,JLabel age,JLabel money,JLabel win) throws IOException {
		String inputFile = "src\\Player_Record\\record.xls";
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);

			Sheet sheet = w.getSheet(0);

			Cell[] cols = sheet.getColumn(0);
			for (int i = 0; i < cols.length; i++) {
				if (cols[i].getContents().equals(username)) {
					name.setText("Name : "+sheet.getColumn(2)[i].getContents());
					age.setText("Age : "+sheet.getColumn(3)[i].getContents());
					money.setText("Balance : $"+sheet.getColumn(4)[i].getContents());
					userBalance = Integer.parseInt(sheet.getColumn(4)[i].getContents());
					win.setText("Wins : "+sheet.getColumn(5)[i].getContents());
				}

				System.out.println("the usernames is: " + cols[i].getContents());
			}

		} catch (BiffException e) {
			e.printStackTrace();
			return;
		}
	}
}

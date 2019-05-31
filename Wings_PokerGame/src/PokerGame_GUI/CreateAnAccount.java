package PokerGame_GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class CreateAnAccount extends JFrame {
	private JTextField nameField;
	private JTextField ageField;
	private JTextField usernameField;
	private JTextField passField;
	private String inputFile;

	public CreateAnAccount() {
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, "name_24601528624056");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 235, 150, 56, 0 };
		gbl_panel.rowHeights = new int[] { 16, 3, 0, 0, 0, 0, 30, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblCreateYourWing = new JLabel("Create Your Wing Account");
		lblCreateYourWing.setFont(new Font("Nirmala UI", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCreateYourWing = new GridBagConstraints();
		gbc_lblCreateYourWing.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCreateYourWing.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateYourWing.gridx = 1;
		gbc_lblCreateYourWing.gridy = 0;
		panel.add(lblCreateYourWing, gbc_lblCreateYourWing);

		JLabel First_Name = new JLabel("Name");
		First_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_First_Name = new GridBagConstraints();
		gbc_First_Name.insets = new Insets(0, 0, 5, 5);
		gbc_First_Name.gridx = 0;
		gbc_First_Name.gridy = 2;
		panel.add(First_Name, gbc_First_Name);

		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.gridx = 2;
		gbc_nameField.gridy = 2;
		panel.add(nameField, gbc_nameField);
		nameField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		ageField = new JTextField();
		ageField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_ageField = new GridBagConstraints();
		gbc_ageField.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_ageField.insets = new Insets(0, 0, 5, 0);
		gbc_ageField.gridx = 2;
		gbc_ageField.gridy = 3;
		panel.add(ageField, gbc_ageField);
		ageField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_usernameField.insets = new Insets(0, 0, 5, 0);
		gbc_usernameField.gridx = 2;
		gbc_usernameField.gridy = 4;
		panel.add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("4-Digit Code");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		passField = new JTextField();
		passField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_passField = new GridBagConstraints();
		gbc_passField.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_passField.insets = new Insets(0, 0, 5, 0);
		gbc_passField.gridx = 2;
		gbc_passField.gridy = 5;
		panel.add(passField, gbc_passField);
		passField.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				// Get the Text
				String name = nameField.getText();
				String username = usernameField.getText();
				try {
					int age = Integer.parseInt(ageField.getText());
					int password = Integer.parseInt(passField.getText());

					// Handle the Age requirement for game
					// Scanner sc = new Scanner(System.in); // Scanner
					String d1 = "You are not allow to play Poker Game"; // Decision 1
					String d2 = "Try Different username"; // Decision 2
					String d3; // Decision 3
					if (age < 14) {
						JOptionPane.showMessageDialog(ageField, d1);
						// System.out.println(d1);
					} else if (password > 9999 || password < 0) {
						JOptionPane.showMessageDialog(ageField, "Only 4-digit code sorry try again");
					} else if (name.equals("")) {
						JOptionPane.showMessageDialog(ageField, "Please Enter a Proper Name");
					} else
						try {
							if (isUnique(username)) {
								JOptionPane.showMessageDialog(usernameField, d2);
							} else {
								// CODE FOR SUMBITTING DATA TO XLS FILE
								try {
									writeTheData(name, age, username, password);
									JOptionPane.showMessageDialog(nameField, "Created an account successfully");
									//Back to login page
									dispose();
									LoginPage lp = new LoginPage();
					                lp.setVisible(true);
									
								} catch (WriteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BiffException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				} catch (NumberFormatException nfe) {
					// nfe.printStackTrace();
					JOptionPane.showMessageDialog(ageField, "Please enter numbers in Age and Password");
				}

			}
		});

		btnSubmit.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 7;
		panel.add(btnSubmit, gbc_btnSubmit);
		
		JButton btnNewButton = new JButton("Back to Login Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginPage lp = new LoginPage();
                lp.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 7;
		panel.add(btnNewButton, gbc_btnNewButton);

		this.setVisible(true);
		this.pack();
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	public void setOutputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public boolean isUnique(String username) throws IOException, BiffException {
		String inputFile = "src\\Player_Record\\record.xls";
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);

			Sheet sheet = w.getSheet(0);

			Cell[] cols = sheet.getColumn(0);
			for (int i = 0; i < cols.length; i++) {
				if (cols[i].getContents().equals(username)) {
					return true;
				}

				System.out.println("the usernames is: " + cols[i].getContents());
			}
			return false;

		} catch (BiffException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void writeTheData(String name, int age, String username, int pass) throws BiffException, IOException, WriteException {
		// Find a way to updated data without deleting original file
		Workbook w = Workbook.getWorkbook(new File("src\\Player_Record\\record.xls"));
		WritableWorkbook copy = Workbook.createWorkbook(new File("src\\Player_Record\\record.xls"), w);
		WritableSheet s = copy.getSheet(0); 
		//Updated
		
		int row = s.getRows();
		int col = s.getColumns();
		System.out.println("rows" + s.getRows() + "columns"+ s.getColumns());
		for(int i = 0; i<col; i++) {
			switch(i) {
			case 0: s.addCell(new Label(i,row,username));
			case 1: s.addCell(new Label(i,row,""+pass));
			case 2: s.addCell(new Label(i,row,name));
			case 3: s.addCell(new Label(i,row,""+age));
			case 4: s.addCell(new Label(i,row,"1000"));
			case 5: s.addCell(new Label(i,row,"0"));
			case 6: s.addCell(new Label(i,row,"0"));
			}
			
		}
		
		System.out.println("rows " + s.getRows() + "columns "+ s.getColumns());
		
		//
		copy.write();
		copy.close();
	}
}

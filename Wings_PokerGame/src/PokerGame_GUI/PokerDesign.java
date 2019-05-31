package PokerGame_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.border.LineBorder;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.util.Map;
import java.util.HashMap;
import java.util.Timer;

public class PokerDesign {

	private Integer _tableAmount = 0;
	private Integer _playerMoney = 200;
	// Rule explain navigator
	// private JFrame checkPoint_frame = new JFrame("CheckPoint");
	// private JButton Check_Your_Understanding = new JButton("Check Your
	// understanding");
//	private JButton straightFlush = new JButton("straight Flush");

	public PokerDesign(String username) {
		Profile profile = new Profile(username);
		_playerMoney = profile.userBalance;
		
		JFrame guiFrame = new JFrame();
		guiFrame.getContentPane().setBackground(Color.WHITE);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// checkPoint_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);///
		guiFrame.setTitle("THE WINGS POKER");
		guiFrame.setSize(700, 700);
		guiFrame.setBackground(Color.black);
		guiFrame.setResizable(true);
		// Center Frame
		guiFrame.setLocationRelativeTo(null);

		// The first JPanel contains a JLabel and JCombobox
		final JPanel comboPanel = new JPanel(new GridBagLayout());
		comboPanel.setBackground(Color.WHITE);

		JLabel welcomeLabl = new JLabel("THE WINGS POKER");
		welcomeLabl.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		GridBagConstraints gbc_welcomeLabl = new GridBagConstraints();
		gbc_welcomeLabl.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabl.gridx = 1;
		gbc_welcomeLabl.gridy = 0;
		comboPanel.add(welcomeLabl, gbc_welcomeLabl);

		// Create the second JPanel. Add a JLabel and JList and
		// make use the JPanel is not visible.
		GridBagLayout gbl_listPanel = new GridBagLayout();
		gbl_listPanel.rowWeights = new double[] { 0.0, 1.0 };
		gbl_listPanel.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		final JPanel listPanel = new JPanel(gbl_listPanel);
		listPanel.setBackground(Color.WHITE);
		GridBagConstraints lc = new GridBagConstraints();
		lc.insets = new Insets(0, 0, 5, 5);
		lc.gridx = 0;
		lc.gridy = 0;

		listPanel.setVisible(false);
		JLabel listLbl = new JLabel("BEST HANDS POSSIBLE");
		listLbl.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_listLbl = new GridBagConstraints();
		gbc_listLbl.insets = new Insets(0, 0, 5, 5);
		gbc_listLbl.gridx = 0;
		gbc_listLbl.gridy = 0;
		listPanel.add(listLbl, gbc_listLbl);

		JButton BACKButton = new JButton("BACK");
		BACKButton.setBackground(Color.RED);

		GridBagConstraints p1c = new GridBagConstraints();
		p1c.gridx = 20;
		p1c.gridy = 20;
		GridBagConstraints p2c = new GridBagConstraints();
		p2c.gridx = 20;
		p2c.gridy = 20;
		JPanel picPanel = new JPanel();
		picPanel.setBackground(new Color(0, 128, 0));
		picPanel.setVisible(false);
		picPanel.setLayout(new CardLayout(0, 0));

		JPanel subPicpanel = new JPanel();
		subPicpanel.setBackground(new Color(0, 128, 0));
		picPanel.add(subPicpanel, "name_1357962556221288");
		GridBagLayout gbl_subPicpanel = new GridBagLayout();
		gbl_subPicpanel.columnWidths = new int[] { 539, 0 };
		gbl_subPicpanel.rowHeights = new int[] { 100, 0, 0, 100, 100, 0 };
		gbl_subPicpanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_subPicpanel.rowWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		subPicpanel.setLayout(gbl_subPicpanel);

		JPanel p1cards = new JPanel();
		p1cards.setBackground(new Color(0, 128, 0));
		GridBagConstraints gbc_p1cards = new GridBagConstraints();
		gbc_p1cards.fill = GridBagConstraints.BOTH;
		gbc_p1cards.insets = new Insets(0, 0, 5, 0);
		gbc_p1cards.gridx = 0;
		gbc_p1cards.gridy = 0;
		subPicpanel.add(p1cards, gbc_p1cards);
		FlowLayout fl_p1cards = new FlowLayout(FlowLayout.CENTER, 5, 5);
		p1cards.setLayout(fl_p1cards);

		JPanel mainTable = new JPanel();
		mainTable.setBackground(new Color(0, 128, 0));
		mainTable.setToolTipText("Main Table");
		GridBagConstraints gbc_mainTable = new GridBagConstraints();
		gbc_mainTable.insets = new Insets(0, 0, 5, 0);
		gbc_mainTable.fill = GridBagConstraints.BOTH;
		gbc_mainTable.gridx = 0;
		gbc_mainTable.gridy = 1;
		subPicpanel.add(mainTable, gbc_mainTable);

		JLabel lblDeal = new JLabel("DEAL $" + _tableAmount);
		mainTable.add(lblDeal);

		JPanel addMoney = new JPanel();
		addMoney.setBackground(new Color(0, 128, 0));
		GridBagConstraints gbc_addMoney = new GridBagConstraints();
		gbc_addMoney.insets = new Insets(0, 0, 5, 0);
		gbc_addMoney.fill = GridBagConstraints.BOTH;
		gbc_addMoney.gridx = 0;
		gbc_addMoney.gridy = 2;
		subPicpanel.add(addMoney, gbc_addMoney);

		JLabel label_1 = new JLabel("$");
		addMoney.add(label_1);

		JSlider slider = new JSlider();
		getClass();
		slider.setMinimum(10);
		slider.setMaximum(_playerMoney);
		slider.setMinorTickSpacing(25);
		slider.setMajorTickSpacing(50);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setForeground(new Color(0, 0, 0));
		slider.setValue(10);
		slider.setToolTipText("Amount to  raise");
		addMoney.add(slider);

		JLabel cpuLabel = new JLabel("CPU $" + 200);
		p1cards.add(cpuLabel);

		JPanel p2cards = new JPanel();
		p2cards.setBackground(new Color(0, 128, 0));
		GridBagConstraints gbc_p2cards = new GridBagConstraints();
		gbc_p2cards.fill = GridBagConstraints.BOTH;
		gbc_p2cards.insets = new Insets(0, 0, 5, 0);
		gbc_p2cards.gridx = 0;
		gbc_p2cards.gridy = 3;
		subPicpanel.add(p2cards, gbc_p2cards);
		FlowLayout fl_p2cards = new FlowLayout(FlowLayout.CENTER, 5, 5);
		p2cards.setLayout(fl_p2cards);

		JLabel userLabel = new JLabel("YOU $" + slider.getMaximum());
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		p2cards.add(userLabel);

		Cards cards = new Cards();
		Evaluate ev = new Evaluate();
		/* These labels are the back side of cards with The wings LOGO */
		JLabel[][] label = cards.gameCardsLabel();
		for (int i = 0; i < 5; i++) {
			p1cards.add(label[i][0]);// player 1 cards
			if (i + 5 > 7) {
				p2cards.add(label[i + 5][1]);// player 2 cards front faced
			} else
				p2cards.add(label[i + 5][0]);// player 2 cards
		}

		/* These labels are the face side of the card that will be updated later */

		ArrayList<String> label_names = cards.getCardLabelNames();
		ArrayList<String> player_one_names = new ArrayList<String>();
		ArrayList<String> player_two_names = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			player_one_names.add(label_names.get(i));
			player_two_names.add(label_names.get(i + 5));
		}

//                System.out.println("Player one");
//                for (int i = 0; i < 5; i++) {
//                    System.out.println(player_one_names.get(i));
//                }
//                
//                System.out.println("Player two");
//                for (int i = 0; i < 5; i++) {
//                    System.out.println(player_two_names.get(i));
//                }

		ActionListener quitAction = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				picPanel.setVisible(false);
				listPanel.setVisible(false);
				comboPanel.setVisible(true);
			}
		};

		BACKButton.addActionListener(quitAction);
		GridBagConstraints gbc_BACKButton = new GridBagConstraints();
		gbc_BACKButton.insets = new Insets(0, 0, 5, 0);
		gbc_BACKButton.gridx = 2;
		gbc_BACKButton.gridy = 0;
		listPanel.add(BACKButton, gbc_BACKButton);

		GridLayout grid = new GridLayout(0, 1, 2, 2);
		picPanel.setLayout(grid);
		guiFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		guiFrame.getContentPane().add(comboPanel);
		JButton btnShop = new JButton("NEW GAME");
		btnShop.setVisible(false);
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiFrame.dispose();
				new PokerDesign(username);
			}
		});
		GridBagConstraints gbc_btnShop = new GridBagConstraints();
		gbc_btnShop.gridx = 5;
		gbc_btnShop.gridy = 1;
		comboPanel.add(btnShop, gbc_btnShop);

		JButton btnStartGame = new JButton("START GAME");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShop.setVisible(true);
				btnStartGame.setText("RESUME GAME");
				comboPanel.setVisible(false);
				listPanel.setVisible(false);
				picPanel.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnStartGame = new GridBagConstraints();
		gbc_btnStartGame.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartGame.gridx = 0;
		gbc_btnStartGame.gridy = 1;
		comboPanel.add(btnStartGame, gbc_btnStartGame);

		JButton btnHowToPlay = new JButton("ABOUT GAME");
		btnHowToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboPanel.setVisible(false);
				listPanel.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnHowToPlay = new GridBagConstraints();
		gbc_btnHowToPlay.insets = new Insets(0, 0, 0, 5);
		gbc_btnHowToPlay.gridx = 1;
		gbc_btnHowToPlay.gridy = 1;
		comboPanel.add(btnHowToPlay, gbc_btnHowToPlay);

		JButton btnMoneyboard = new JButton("PROFILE");
		btnMoneyboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Profile(username);
			}
		});
		GridBagConstraints gbc_btnMoneyboard = new GridBagConstraints();
		gbc_btnMoneyboard.insets = new Insets(0, 0, 0, 5);
		gbc_btnMoneyboard.gridx = 2;
		gbc_btnMoneyboard.gridy = 1;
		comboPanel.add(btnMoneyboard, gbc_btnMoneyboard);

		guiFrame.getContentPane().add(picPanel);

		JPanel allButtons = new JPanel();
		allButtons.setBackground(new Color(0, 128, 0));
		GridBagConstraints gbc_allButtons = new GridBagConstraints();
		gbc_allButtons.fill = GridBagConstraints.BOTH;
		gbc_allButtons.gridheight = 2;
		gbc_allButtons.gridx = 0;
		gbc_allButtons.gridy = 4;
		subPicpanel.add(allButtons, gbc_allButtons);
		allButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel evLbl = new JLabel("CLICK TO");
		allButtons.add(evLbl);
		evLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JButton evaluateButton = new JButton("EVALUATE");
		evaluateButton.setEnabled(false);
		allButtons.add(evaluateButton);

		JButton QUITButton = new JButton("BACK");
		allButtons.add(QUITButton);
		QUITButton.setBackground(Color.RED);
		QUITButton.addActionListener(quitAction);

		evaluateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
//                                 System.out.println(ev.evaluateHand(player_one_names));
//                                 System.out.println(ev.evaluateHand(player_two_names));
				if (ev.evaluateHand(player_one_names) < ev.evaluateHand(player_two_names)) {
					evLbl.setText("YOU WON THE DEAL $" + _tableAmount);
					_playerMoney += _tableAmount;
					updateBalance(_playerMoney,username);
				} else {
					evLbl.setText("YOU LOST THE DEAL");
				}
				comboPanel.setVisible(false);
				picPanel.setVisible(true);
				listPanel.setVisible(false);
				evaluateButton.setVisible(false);
				addMoney.setVisible(false);
			}
		});

		JButton raiseButton = new JButton("RAISE");
		raiseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				btnShop.setEnabled(false);
				int val = slider.getValue();
				if(val>0) {
					_tableAmount = _tableAmount + 2 * val;
					lblDeal.setText("ON TABLE $" + _tableAmount);
					slider.setMaximum(slider.getMaximum() - val);
					val = slider.getMaximum();
					_playerMoney = val;
					updateBalance(_playerMoney,username);
					cpuLabel.setText("CPU $" + val);
					userLabel.setText("YOU $" + val);
					if (val == 0) {
						btnShop.setEnabled(true);
						if (ev.evaluateHand(player_one_names) < ev.evaluateHand(player_two_names)) {
							evLbl.setText("YOU WON THE DEAL" + _tableAmount);
						} else {
							evLbl.setText("YOU LOST THE DEAL");
						}
						comboPanel.setVisible(false);
						picPanel.setVisible(true);
						listPanel.setVisible(false);
						evaluateButton.setVisible(false);
						addMoney.setVisible(false);
				}
				}

			}
		});
		addMoney.add(raiseButton);

		JButton foldButton = new JButton("FOLD");
		foldButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ev.evaluateHand(player_one_names) < ev.evaluateHand(player_two_names)) {
					evLbl.setText("YOU COULD HAVE WON $" + _tableAmount);
				} else {
					evLbl.setText("BETTER YOU GAVE UP");
				}
				comboPanel.setVisible(false);
				picPanel.setVisible(true);
				listPanel.setVisible(false);
				evaluateButton.setVisible(false);
				addMoney.setVisible(false);
			}
		});
		addMoney.add(foldButton);

		JButton showButton = new JButton("SHOW");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 5; i++) {
//                                        System.out.print(player_one_names.get(i));
//                                        System.out.print(player_two_names.get(i));
					label[i][0].setIcon(cards.getImageIcon(player_one_names.get(i)));// player 1 cards
					label[i + 5][0].setIcon(cards.getImageIcon(player_two_names.get(i)));// player 2 cards
					evaluateButton.setEnabled(true);
					foldButton.setEnabled(false);
					raiseButton.setEnabled(false);
				}
			}
		});
		addMoney.add(showButton);

		guiFrame.getContentPane().add(listPanel);

		JPanel Image_Ilustration = new JPanel();
		Image_Ilustration.setBorder(new LineBorder(new Color(0, 0, 0)));
		Image_Ilustration.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_Image_Ilustration = new GridBagConstraints();
		gbc_Image_Ilustration.insets = new Insets(0, 0, 5, 5);
		gbc_Image_Ilustration.fill = GridBagConstraints.BOTH;
		gbc_Image_Ilustration.gridx = 1;
		gbc_Image_Ilustration.gridy = 1;
		listPanel.add(Image_Ilustration, gbc_Image_Ilustration);
		GridBagLayout gbl_Image_Ilustration = new GridBagLayout();
		gbl_Image_Ilustration.columnWidths = new int[] { 97, 111, 113, 91, 63, 0 };
		gbl_Image_Ilustration.rowHeights = new int[] { 25, 0, 0 };
		gbl_Image_Ilustration.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_Image_Ilustration.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		Image_Ilustration.setLayout(gbl_Image_Ilustration);
		////////////////////////////////////////////// Royal
		////////////////////////////////////////////// Flush////////////////////////////////////////////////////
		JButton Royal_Flush = new JButton("Royal Flush");
		Royal_Flush.setBackground(Color.PINK);
		GridBagConstraints gbc_Royal_Flush = new GridBagConstraints();
		gbc_Royal_Flush.anchor = GridBagConstraints.NORTHWEST;
		gbc_Royal_Flush.insets = new Insets(0, 0, 5, 5);
		gbc_Royal_Flush.gridx = 0;
		gbc_Royal_Flush.gridy = 0;
		Image_Ilustration.add(Royal_Flush, gbc_Royal_Flush);
		// guiFrame.getContentPane().add(CheckPoint);
		Royal_Flush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					new View_Hand("royal_flush", 0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		JButton Straight_Flush = new JButton("Straight Flush");
		Straight_Flush.setBackground(Color.YELLOW);
		GridBagConstraints gbc_Straight_Flush = new GridBagConstraints();
		gbc_Straight_Flush.anchor = GridBagConstraints.NORTHWEST;
		gbc_Straight_Flush.insets = new Insets(0, 0, 5, 5);
		gbc_Straight_Flush.gridx = 1;
		gbc_Straight_Flush.gridy = 0;
		Image_Ilustration.add(Straight_Flush, gbc_Straight_Flush);
		Straight_Flush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					new View_Hand("straight_flush", 2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		JButton Four_Of_A_Kind = new JButton("Four of A Kind");
		Four_Of_A_Kind.setBackground(Color.MAGENTA);
		GridBagConstraints gbc_Four_Of_A_Kind = new GridBagConstraints();
		gbc_Four_Of_A_Kind.anchor = GridBagConstraints.NORTHWEST;
		gbc_Four_Of_A_Kind.insets = new Insets(0, 0, 5, 5);
		gbc_Four_Of_A_Kind.gridx = 2;
		gbc_Four_Of_A_Kind.gridy = 0;
		Image_Ilustration.add(Four_Of_A_Kind, gbc_Four_Of_A_Kind);
		Four_Of_A_Kind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new View_Hand("four_of_a_kind", 4);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		JButton Full_House = new JButton("Full House");
		Full_House.setBackground(Color.GREEN);
		GridBagConstraints gbc_Full_House = new GridBagConstraints();
		gbc_Full_House.anchor = GridBagConstraints.NORTHWEST;
		gbc_Full_House.insets = new Insets(0, 0, 5, 5);
		gbc_Full_House.gridx = 3;
		gbc_Full_House.gridy = 0;
		Image_Ilustration.add(Full_House, gbc_Full_House);
		Full_House.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					new View_Hand("Full_House", 6);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		JButton Straight = new JButton("Straight");
		Straight.setBackground(Color.ORANGE);
		GridBagConstraints gbc_Straight = new GridBagConstraints();
		gbc_Straight.insets = new Insets(0, 0, 5, 0);
		gbc_Straight.anchor = GridBagConstraints.NORTHWEST;
		gbc_Straight.gridx = 0;
		gbc_Straight.gridy = 1;
		Image_Ilustration.add(Straight, gbc_Straight);
		Straight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					new View_Hand("Straight", 10);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		JButton Three_Of_A_Kind = new JButton("Three Of A kind");
		Three_Of_A_Kind.setBackground(Color.CYAN);
		GridBagConstraints gbc_Three_Of_A_Kind = new GridBagConstraints();
		gbc_Three_Of_A_Kind.insets = new Insets(0, 0, 0, 5);
		gbc_Three_Of_A_Kind.gridx = 1;
		gbc_Three_Of_A_Kind.gridy = 1;
		Image_Ilustration.add(Three_Of_A_Kind, gbc_Three_Of_A_Kind);
		Three_Of_A_Kind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					new View_Hand("three_of_a_kind", 12);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		JButton Two_Pair = new JButton("Two Pair");
		Two_Pair.setBackground(Color.GRAY);
		GridBagConstraints gbc_Two_Pair = new GridBagConstraints();
		gbc_Two_Pair.insets = new Insets(0, 0, 0, 5);
		gbc_Two_Pair.gridx = 2;
		gbc_Two_Pair.gridy = 1;
		Image_Ilustration.add(Two_Pair, gbc_Two_Pair);
		Two_Pair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					new View_Hand("two_pair", 14);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		JButton High_Card = new JButton("High_Card");
		High_Card.setBackground(Color.PINK);
		GridBagConstraints gbc_High_Card = new GridBagConstraints();
		gbc_High_Card.insets = new Insets(0, 0, 0, 5);
		gbc_High_Card.gridx = 4;
		gbc_High_Card.gridy = 1;
		Image_Ilustration.add(High_Card, gbc_High_Card);

		JButton Flush = new JButton("Flush");
		Flush.setBackground(Color.PINK);
		GridBagConstraints gbc_Flush = new GridBagConstraints();
		gbc_Flush.insets = new Insets(0, 0, 0, 5);
		gbc_Flush.gridx = 4;
		gbc_Flush.gridy = 0;
		Image_Ilustration.add(Flush, gbc_Flush);
		Flush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					new View_Hand("Flush", 8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		JButton One_Pair = new JButton("One Pair");
		One_Pair.setBackground(Color.PINK);
		GridBagConstraints gbc_One_Pair = new GridBagConstraints();
		gbc_One_Pair.gridx = 3;
		gbc_One_Pair.gridy = 1;
		Image_Ilustration.add(One_Pair, gbc_One_Pair);
		High_Card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					new View_Hand("High_Card", 18);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		One_Pair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					new View_Hand("One_Pair", 16);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		////////////////////
		guiFrame.setVisible(true);
		// Maximize windows
		guiFrame.setExtendedState(guiFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	public void updateBalance(Integer money, String user){
		if(user.equals("") || user == null) {
			return;
		}
		
		else {
			Workbook w;
			try {
				w = Workbook.getWorkbook(new File("src\\Player_Record\\record.xls"));
				//get location of the user
				Sheet sheet = w.getSheet(0);
				int r = -1;
				Cell[] cols = sheet.getColumn(0);
				for (int i = 0; i < cols.length; i++) {
					if (cols[i].getContents().equals(user)) {
						r = i;
					}
				}
				
				WritableWorkbook copy = Workbook.createWorkbook(new File("src\\Player_Record\\record.xls"), w);
				WritableSheet s = copy.getSheet(0); 
				//Update amount
				WritableCell cell = s.getWritableCell(0,0);
				if (r != -1) 
				{ 
				  Label l = (Label) cell; 
				  l.setString("" + money); 
				}
				
				copy.write();
				try {
					copy.close();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			} catch (BiffException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
		
		
	}
	
}

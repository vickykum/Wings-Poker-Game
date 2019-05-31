package PokerGame_GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Random;


public class Cards {
	
	private String[] _suitName = {"C", "D", "H", "S"};
	private String[] _cardNum = {"2","3","4","5","6","7","8","9","10","J","K","Q","A"};
	private ArrayList<String> _allCards;
	private ArrayList<String> _card_labels = new ArrayList<>();
	
	public Cards() {
		 ArrayList<String> AllCards = new ArrayList<String>();
		for(int f = 0; f<13; f++ ) {
			for(int s =0; s<4; s++) {
				AllCards.add( _cardNum[f] + _suitName[s]);
			}
		}
		_allCards = AllCards;
	}
	
	public BufferedImage projectImage(String getCard) {
		String pngfile;
                // System.out.println(getCard);
		pngfile = "src\\Card_PNG\\"+ getCard +".png";
		try {
			BufferedImage bg = ImageIO.read(new File(pngfile));
			
	        return bg;
		} 
		catch (Exception e) {
			System.out.println("Image didn't print ");
			return null;
		}
	}
	
	public ImageIcon getImageIcon(String type) {
		ImageIcon Img;
		if(type.equals("back")) {
			Img = new ImageIcon(projectImage("LOGO"));
		}
                else if(type.equals("face")){
                    Img = new ImageIcon(projectImage(getRandCard()));
                }
		else {
			Img = new ImageIcon(projectImage(type));
		}
	
		Image nIg = Img.getImage();
		Image aginNew = nIg.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
		ImageIcon newImg = new ImageIcon(aginNew);
		return newImg;
	}
	
	public String getRandCard() {
		Random rand = new Random();
		int elem = rand.nextInt(_allCards.size());
		//System.out.println(elem);
		String retval = "";
		retval = 	_allCards.get(elem);
		_card_labels.add(retval);
		_allCards.remove(retval);
		//System.out.println(retval);
		return retval;
	}
	
	public JLabel[][] gameCardsLabel() {
		JLabel[][] Labels = new JLabel[10][2];
		for(int i =0; i < 10; i++) {
			JLabel x = new JLabel();
			ImageIcon Img = getImageIcon("back");
			x = new JLabel(Img);
			Labels[i][0] = x;
			Img = getImageIcon("face");
			x = new JLabel(Img);
			Labels[i][1] = x;
			
		}
		return Labels;
	}
	
	public ArrayList<String> getCardLabelNames(){
            return _card_labels;
        }

}

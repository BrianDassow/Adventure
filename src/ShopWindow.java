import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopWindow {
	private JFrame frame;
	private JPanel panel, panel2, panel3, panel4;
	private JComboBox items;
	private InventoryWindow inventory;
	private JTextArea mainText;
	private String itemInformation = "";
	private Gold gold;
	private JLabel goldLabel;
	private String charType;
	private int potionTotal=0, goldAmount;
	private HashMap itemHash, itemHashInfo;

	public ShopWindow(int x, int y, String name, String charType, int attackDamage, int goldAmount) {
		frame = new JFrame(name);
		frame.setBounds(1000, 200, x, y);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.charType = charType;
		this.goldAmount = goldAmount;
	}

	public void visible() {
		inventory.visible();
		frame.setVisible(true);
	}
	public boolean check() {
		if (frame.isVisible() == false && inventory.check() == false) {
			return true;
		}
		else {
			return false;
		}
	}

	public void notVisible() {
		inventory.notVisible();
		frame.setVisible(false);
	}

	public void setupShoppe() {
		gold = new Gold(goldAmount);
		
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();

		panel.setBackground(Color.BLACK);
		panel2.setBackground(Color.BLACK);
		panel3.setBackground(Color.BLACK);
		panel4.setBackground(Color.BLACK);
		
		
		goldLabel = new JLabel();
		goldLabel.setForeground(Color.WHITE);
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Ye Olde Shoppe", 1, 1, null, Color.WHITE));
		

		inventory = new InventoryWindow();

		class buyListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				BuyItem();
				inventory.notVisible();
				inventory.visible();
			}
		}

		ActionListener buying = new buyListener();

		JButton purchase = new JButton("Buy");
		purchase.setBackground(Color.DARK_GRAY);
		purchase.setForeground(Color.WHITE);
		purchase.addActionListener(buying);
		panel2.add(purchase);

		panel.add(panel2, BorderLayout.WEST);
		frame.add(panel);
		
		
		mainText = new JTextArea(itemInformation, 5, 20);
		mainText.setEditable(false);
		mainText.setBackground(Color.BLACK);
		mainText.setForeground(Color.WHITE);
		panel3.add(mainText);
		
		panel.add(panel3, BorderLayout.SOUTH);

		goldLabel.setText(gold.getGold());
		panel4.add(goldLabel);
		panel.add(panel4, BorderLayout.CENTER);
	}

	public void addStuff() {
		int[] itemArray = new int[20];
		for (int i = 0; i < 20; i++) {
			itemArray[i] = i;
		}
	}
	
	public void itemNames() {
		itemHash = new HashMap();
		items = new JComboBox();
		items.setBackground(Color.BLACK);
		items.setForeground(Color.LIGHT_GRAY);
		
		items.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = items.getSelectedIndex();
				mainText.setText(getItemInfo()); //HASHMAP collection
			}
		});

		itemHash.put(0, "Health Potion");
		
		if (charType.equals("Warrior")) {
			itemHash.put(1, "Rapier");
		   itemHash.put(2, "Short Sword");
		   itemHash.put(3, "Long Sword");
		   itemHash.put(4, "Scimitar");
		   itemHash.put(5, "Flail");
		   itemHash.put(6, "Falchion");		
		   itemHash.put(7, "Hasta");
		   itemHash.put(8, "Battle Axe");
		   itemHash.put(9, "Morg's Greatsword");
		   itemHash.put(10, "Tom's Intimidating Dagger");
		}
		else if (charType.equals("Rogue")) {
			itemHash.put(1, "Sling");
		   itemHash.put(2, "Throwing Daggers");
		   itemHash.put(3, "Shortbow");
		   itemHash.put(4, "Longbow");
		   itemHash.put(5, "Javelin");
		   itemHash.put(6, "Crossbow");		
		   itemHash.put(7, "Throwing Axes");
		   itemHash.put(8, "Arablast");
		   itemHash.put(9, "Mystical Glaive");
		   itemHash.put(10, "Bob's Blunderbuss");
		}
		else {
			itemHash.put(1, "Oak Staff");
		   itemHash.put(2, "Ebony Wand");
		   itemHash.put(3, "Runic Orb");
		   itemHash.put(4, "Book of Elements");
		   itemHash.put(5, "Eldarj's Magic Tome");
		   itemHash.put(6, "Scroll of Fire and Ice");		
		   itemHash.put(7, "Item of Mysterious Properties");
		   itemHash.put(8, "Ebony Elder Staff");
		   itemHash.put(9, "Gem of Eternal Miseries");
		   itemHash.put(10, "Rexthar's Mystical Pen");
		}
		for (int i = 0; i < 11; i++)// enhanced for loop
		{
			items.addItem(itemHash.get(i));
		}

		panel2.add(items);
	}
	public void itemInfo() {
		itemHashInfo = new HashMap();

		itemHashInfo.put(0, "Heals you for 75 health points.\nCosts: 125Ω");
		
		if (charType.equals("Warrior")) {
		   itemHashInfo.put(1, "A standard blade; sharp and to the point.\nCosts: 375Ω\nStat: +5 AD");
		   itemHashInfo.put(2, "The size does not matter but how you use it.\nCosts: 425Ω\nStat: +8 AD");
		   itemHashInfo.put(3, "It has the reach you need and the chop the enemy deserves.\nCosts: 575Ω\nStat: +12 AD");
		   itemHashInfo.put(4, "A quick blade that requires a bit of skill to use.\nCosts: 725Ω\nStat: +18 AD");
		   itemHashInfo.put(5, "A spike ball on a chain. Need there be anything else?\nCosts: 875Ω\nStat: +22 AD");
		   itemHashInfo.put(6, "A heavy blade that is sure to cleave through any crowd.\nCosts: 1025Ω\nStat: +26 AD");		
		   itemHashInfo.put(7, "A merciless spear that seeks the hearts of your enemies.\nCosts: 1300Ω\nStat: +32 AD");
		   itemHashInfo.put(8, "With a name including 'battle' in it, it has to be good.\nCosts: 1550Ω\nStat: +38 AD");
		   itemHashInfo.put(9, "Forged by a powerful god and sent to you by a special carrier.\nCosts: 1850Ω\nStat: +45 AD");
		   itemHashInfo.put(10, "Who was Tom? And why is his dagger so dang sharp?\nCosts: 2250Ω\nStat: +50 AD");
		}
		else if (charType.equals("Rogue")) {
		   itemHashInfo.put(1, "Sticks and stones may break my bones...and words don't really work here.\nCosts: 375Ω\nStat: +5 AD");
		   itemHashInfo.put(2, "Sick of throwing rocks? Throw steel instead!\nCosts: 425Ω\nStat: +8 AD");
		   itemHashInfo.put(3, "It may be small but it sinks into the minds of the enemies quite well.\nCosts: 575Ω\nStat: +12 AD");
		   itemHashInfo.put(4, "Deadly range and deadly accuracy. Right on target!\nCosts: 725Ω\nStat: +18 AD");
		   itemHashInfo.put(5, "A large and pointy stick, heavy too.\nCosts: 875Ω\nStat: +22 AD");
		   itemHashInfo.put(6, "Tired of pulling the string back yourself? This does the trick, deadlier too!\nCosts: 1025Ω\nStat: +26 AD");		
		   itemHashInfo.put(7, "Warriors like to swing these things...what a waste.\nCosts: 1300Ω\nStat: +32 AD");
		   itemHashInfo.put(8, "Just short of a ballista.\nCosts: 1550Ω\nStat: +38 AD");
		   itemHashInfo.put(9, "A fancy throwing weapon that hums your favorite tune of death.\nCosts: 1850Ω\nStat: +45 AD");
		   itemHashInfo.put(10, "Bob was a skilled craftsman, until he lost his arms test firing this.\nCosts: 2250Ω\nStat: +50 AD");
		}
		else {
		   itemHashInfo.put(1, "Is this really a staff or just a twig you found?\nCosts: 375Ω\nStat: +5 AD");
		   itemHashInfo.put(2, "Shorter than what you're used to but it works.\nCosts: 425Ω\nStat: +8 AD");
		   itemHashInfo.put(3, "A ball that glows with mystical power.\nCosts: 575Ω\nStat: +12 AD");
		   itemHashInfo.put(4, "First page mentions a return date to the library.\nCosts: 725Ω\nStat: +18 AD");
		   itemHashInfo.put(5, "A big book with chains and hellish writing. Perfect!\nCosts: 875Ω\nStat: +22 AD");
		   itemHashInfo.put(6, "Good for aches and pains...oh and blasting enemies.\nCosts: 1025Ω\nStat: +26 AD");		
		   itemHashInfo.put(7, "It hums, beeps, screams and turns your enemies to mush.\nCosts: 1300Ω\nStat: +32 AD");
		   itemHashInfo.put(8, "Made of chisled demon stone and made by something's grandma.\nCosts: 1550Ω\nStat: +38 AD");
		   itemHashInfo.put(9, "This shiny bauble promises pain to your enemies.\nCosts: 1850Ω\nStat: +45 AD");
		   itemHashInfo.put(10, "The pen is mightier than the sword, Rexthar knew that very well. Comes with a diary.\nCosts: 2250Ω\nStat: +50 AD");
		}
		
	}
	public String getItemInfo() {
		String information = null;
		String name = (String) items.getSelectedItem();
		if (name.equals("Health Potion")) {
			information = (String) itemHashInfo.get(0);
		}
		
		else if (name.equals("Rapier")||name.equals("Sling")||name.equals("Oak Staff")) {
			information = (String) itemHashInfo.get(1); 
		}
		else if (name.equals("Short Sword")||name.equals("Throwing Daggers")||name.equals("Ebony Wand")) {
			information = (String) itemHashInfo.get(2); 
		}
		else if (name.equals("Long Sword")||name.equals("Shortbow")||name.equals("Runic Orb")) {
			information = (String) itemHashInfo.get(3); 
		}
		else if (name.equals("Scimitar")||name.equals("Longbow")||name.equals("Book of Elements")) {
			information = (String) itemHashInfo.get(4); 
		}
		else if (name.equals("Flail")||name.equals("Javelin")||name.equals("Eldarj's Magic Tome")) {
			information = (String) itemHashInfo.get(5); 
		}
		else if (name.equals("Falchion")||name.equals("Crossbow")||name.equals("Scroll of Fire and Ice")) {
			information = (String) itemHashInfo.get(6); 
		}
		else if (name.equals("Hasta")||name.equals("Throwing Axes")||name.equals("Item of Mysterious Properties")) {
			information = (String) itemHashInfo.get(7); 
		}
		else if (name.equals("Battle Axe")||name.equals("Arablast")||name.equals("Ebony Elder Staff")) {
			information = (String) itemHashInfo.get(8); 
		}
		else if (name.equals("Morg's Greatsword")||name.equals("Mystical Glaive")||name.equals("Gem of Eternal Miseries")) {
			information = (String) itemHashInfo.get(9); 
		}
		else if (name.equals("Tom's Intimidating Dagger")||name.equals("Bob's Blunderbuss")||name.equals("Rexthar's Mystical Pen")) {
			information = (String) itemHashInfo.get(10); 
		}
		return information;
	}

	
	public void BuyItem() {
		int itemAttackDamage = 0;
		Boolean bought = false;
		String name = (String) items.getSelectedItem();
		if (name.equals("Health Potion")) {
			if (gold.getGoldAmount() >= 125) {
			lowerGold(125);
			bought = true;
			potionTotal++;
			inventory.raiseHpPotionAmount();
			}
		}
		else if (name.equals("Rapier")||name.equals("Sling")||name.equals("Oak Staff")) {
			if (gold.getGoldAmount() >= 375) {
				lowerGold(375);
				bought = true;
				itemAttackDamage = 5;
			}
		}
		else if (name.equals("Short Sword")||name.equals("Throwing Daggers")||name.equals("Ebony Wand")) {
			if (gold.getGoldAmount() >= 425) {
				lowerGold(425);
				bought = true;
				itemAttackDamage = 8;
			}
		}
		else if (name.equals("Long Sword")||name.equals("Shortbow")||name.equals("Runic Orb")) {
			if (gold.getGoldAmount() >= 575) {
				lowerGold(575);
				bought = true;
				itemAttackDamage = 12;
			}
		}
		else if (name.equals("Scimitar")||name.equals("Longbow")||name.equals("Book of Elements")) {
			if (gold.getGoldAmount() >= 725) {
				lowerGold(725);
				bought = true;
				itemAttackDamage = 18;
			}
		}
		else if (name.equals("Flail")||name.equals("Javelin")||name.equals("Eldarj's Magic Tome")) {
			if (gold.getGoldAmount() >= 875) {
				lowerGold(875);
				bought = true;
				itemAttackDamage = 22;
			}
		}
		else if (name.equals("Falchion")||name.equals("Crossbow")||name.equals("Scroll of Fire and Ice")) {
			if (gold.getGoldAmount() >= 1025) {
				lowerGold(1025);
				bought = true;
				itemAttackDamage = 26;
			}
		}
		else if (name.equals("Hasta")||name.equals("Throwing Axes")||name.equals("Item of Mysterious Properties")) {
			if (gold.getGoldAmount() >= 1300) {
				lowerGold(1300);
				bought = true;
				itemAttackDamage = 32;
			}
		}
		else if (name.equals("Battle Axe")||name.equals("Arablast")||name.equals("Ebony Elder Staff")) {
			if (gold.getGoldAmount() >= 1550) {
				lowerGold(1550);
				bought = true;
				itemAttackDamage = 38;
			}
		}
		else if (name.equals("Morg's Greatsword")||name.equals("Mystical Glaive")||name.equals("Gem of Eternal Miseries")) {
			if (gold.getGoldAmount() >= 1850) {
				lowerGold(1850);
				bought = true;
				itemAttackDamage = 45;
			}
		}
		else if (name.equals("Tom's Intimidating Dagger")||name.equals("Bob's Blunderbuss")||name.equals("Rexthar's Mystical Pen")) {
			if (gold.getGoldAmount() >= 2250) {
				lowerGold(2250);
				bought = true;
				itemAttackDamage = 50;
			}
		}
			
		if (bought) {
			if (!items.getSelectedItem().equals("Health Potion")) {
				JLabel label = new JLabel();
				String itemSelected = (String) items.getSelectedItem();
				label.setText(itemSelected);
				label.setForeground(Color.WHITE);
				inventory.addInventory(label);
				items.removeItem(items.getSelectedItem());
				AdventureInterfaces.changeAdLabel(itemAttackDamage);
			}
		}
			
		else {
				JOptionPane.showMessageDialog(null, "You don't have enough Ω!");
		}
			
		
		changeGoldLabel();

	
	}
	
	public void itemDamage() {
	}
	public void itemGold() {
	}
	public void changeGoldLabel() {
		goldLabel.setText(gold.getGold());
	}
	public void lowerGold(int howMuch) {
		gold.lowerGold(howMuch);
	}
	public void raiseGold(int howMuch) {
		gold.raiseGold(howMuch);
	}
	public int getHpPotAmount() {
		return potionTotal;
	}
	public void lowerHpPot() {
		potionTotal--;
		inventory.lowerHpPotionAmount();
	}
}
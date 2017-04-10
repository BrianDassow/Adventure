import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AdventureInterfaces extends JFrame {
	private static JLabel attackDamageLabel;
	private JLabel hpLabel;
	private JTextArea mainText;
	private JButton shopButton, moveButton;
	private boolean shopShowing = false;
	private ShopWindow shopWindow = null;
	private String charType;
	private Gold gold;
	private int attackDamage = 0;
	private int charHp = 0;
	private int eventNumber = 0;
	private int maxRogueGold = 150, hpHeal = 75;
	private String eventText = "";
	private static CharacterAttackHpWithGold characterHpStartAndGold;
	private JScrollPane scrollTextArea;
	
	public AdventureInterfaces(String windowName, int x, int y, String charType) {
		this.setTitle(windowName);
		this.setBounds(70, 30, x, y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.charType = charType;
		characterHpStartAndGold = new CharacterAttackHpWithGold(charType);
		gold = new Gold(characterHpStartAndGold.getGoldAmount());
		attackDamage = characterHpStartAndGold.getAttackDamage();
		charHp = characterHpStartAndGold.getCharHp();
		
		shopWindow = new ShopWindow(500, 250, "Shop", charType, attackDamage, gold.getGoldAmount());
		shopWindow.setupShoppe();
		shopWindow.itemInfo();
		shopWindow.itemNames();
	}
	public void setupComponents() {
		attackDamageLabel = new JLabel("AD: " + characterHpStartAndGold.getAttackDamageInString());
		hpLabel = new JLabel("HP: " + characterHpStartAndGold.getCharHpInString());
		
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
	
		
		JPanel subPanelNorth = new JPanel();
		JPanel subPanelCenter = new JPanel();
		JPanel subPanelSouth = new JPanel();
		
		

		mainText = new JTextArea("", 42, 40);
		if (characterHpStartAndGold.getCharType().equals("Warrior")) {
			mainText.setText(" The small town of Oldbridge is a peaceful place.\n Many heroes have set out to "
					+ "keep it that way and it remains standing after\n the sacrifice of many noble heroes.\n "
					+ "It is shadowed by the Oberon Mountain, the mountain that many say contains\n demons and "
					+ "other fell entities but is warded to keep the town safe.\n No evil escapes it, no evil "
					+ "comes to the town but \n no heroes have been seen either.\n Until today, a youthful "
					+ "adventurer will face a trial \n and, if still standing, will make legends.\n\n Whilst "
					+ "walking near the Oberon Mountain our hero befalls destiny...\n or more like he falls "
					+ "into it. \n The earth collapsed underfoot and left our hero \n tumbling into the belly "
					+ "of the world.\n Hearing sounds dark and dastardly, and the pitter patter of feet our "
					+ "hero \n reaches for his sword.");
		}
		else if (characterHpStartAndGold.getCharType().equals("Wizard")) {
			mainText.setText(" The small town of Oldbridge is a peaceful place.\n Many heroes have set out to "
					+ "keep it that way and it remains standing after\n the sacrifice of many noble heroes.\n "
					+ "It is shadowed by the Oberon Mountain, the mountain that many say contains\n demons and "
					+ "other fell entities but is warded to keep the town safe.\n No evil escapes it, no evil "
					+ "comes to the town but \n no heroes have been seen either.\n Until today, a youthful "
					+ "adventurer will face a trial \n and, if still standing, will make legends.\n\n Whilst "
					+ "walking near the Oberon Mountain our hero befalls destiny...\n or more like he falls "
					+ "into it. \n The earth collapsed underfoot and left our hero \n tumbling into the belly "
					+ "of the world.\n Hearing sounds dark and dastardly, and the pitter patter of feet our "
					+ "hero \n reaches for his staff.");
		}
		else {
			mainText.setText(" The small town of Oldbridge is a peaceful place.\n Many heroes have set out to "
					+ "keep it that way and it remains standing after\n the sacrifice of many noble heroes.\n "
					+ "It is shadowed by the Oberon Mountain, the mountain that many say contains\n demons and "
					+ "other fell entities but is warded to keep the town safe.\n No evil escapes it, no evil "
					+ "comes to the town but \n no heroes have been seen either.\n Until today, a youthful "
					+ "adventurer will face a trial \n and, if still standing, will make legends.\n\n Whilst "
					+ "walking near the Oberon Mountain our hero befalls destiny...\n or more like he falls "
					+ "into it. \n The earth collapsed underfoot and left our hero \n tumbling into the belly "
					+ "of the world.\n Hearing sounds dark and dastardly, and the pitter patter of feet our "
					+ "hero \n reaches for his bow.");
		}
		mainText.setEditable(false);
		scrollTextArea = new JScrollPane(mainText);
		scrollTextArea.setSize(40, 50);

		subPanelNorth.setBackground(Color.BLACK);
		subPanelCenter.setBackground(Color.BLACK);
		subPanelSouth.setBackground(Color.BLACK);
		hpLabel.setForeground(Color.RED);
		attackDamageLabel.setForeground(Color.RED);
		mainText.setBackground(Color.BLACK);
		mainText.setForeground(Color.WHITE);
		moveButton = new JButton("Proceed");
		moveButton.setBackground(Color.DARK_GRAY);
		moveButton.setForeground(Color.WHITE);
		shopButton = new JButton("Shop");
		shopButton.setBackground(Color.DARK_GRAY);
		shopButton.setForeground(Color.WHITE);
		
		
		subPanelNorth.add(attackDamageLabel);
		subPanelNorth.add(shopButton);
		subPanelNorth.add(hpLabel);

		subPanelCenter.add(scrollTextArea);

		subPanelSouth.add(moveButton);

		north.setLayout(new GridLayout(1, 3));
		center.setLayout(new GridLayout(1, 1));
		south.setLayout(new GridLayout(1, 3));

		north.add(subPanelNorth);
		center.add(subPanelCenter);
		south.add(subPanelSouth);

		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);

		shopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (shopWindow.check() == true) {
					shopShowing = false;
				}
					if (shopShowing) {
						shopWindow.notVisible();
						shopShowing = false;
					} else {
						shopWindow.visible();
						shopShowing = true;
					}
				
			}
		});
		moveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					switch (eventNumber) {
					case 0:
						eventText = " 'I have to get out of this cave', you think as you grab your gear.\n "
								+ "If these are goblin warrens then getting out might\n be near impossible, "
								+ "but you have to try.\n The sounds approach closer, you mark the location\n "
								+ "of their origination and prepare for battle.\n You quickly scan the room "
								+ "and as your eyes adjust… \n";
						randomEvent();
						eventNumber++;
						break;
					case 1:
						eventText = " You head towards the way the sounds\n came from, it appears the "
								+ "only way.\n Creeping through the tunnel you hold your gear close in "
								+ "fear of losing it.\n Could the stories be true of demons and\n other "
								+ "dark entities under the mountain?\n You notice side tunnels extending "
								+ "into deeper parts\n of Oberon Mountain and the noises of numerous monsters, "
								+ "an army…\n’Must not get too distracted’ as you try to pull your thoughts "
								+ "away\n from the implications this has on Oldbridge.\n As you focus on "
								+ "the path ahead of you…\n ";
						randomEvent();
						eventNumber++;
						break;
					case 2:
						eventText = " You know you are heading in the right path.\n The air is fresher "
								+ "and there is a breeze coming down the stairs.\n This is definitely "
								+ "the way but why does it have the fewest tracks?\n What is stopping "
								+ "this horde of goblins and orcs\n from escaping and crashing down on "
								+ "Oldbridge?\n It is a mystery, one that has to wait, as you look…\n";
						randomEvent();
						eventNumber++;
						break;
					case 3:
						eventText = " The place that you are standing in looks militaristic.\n "
								+ "You must be approaching the headquarters of the army.\n ‘If the "
								+ "path leads this way I guess I will go’ you think\n as you continue "
								+ "on your course, no point in turning back.\n The hall, if you could "
								+ "call it that, that you are in\n is decorated with banners of many orc "
								+ "and goblin clans, far too many.\n The army under Oberon Mountain has to "
								+ "be huge!\n You quicken your pace and as you hurry…\n";
						randomEvent();
						eventNumber++;
						break;
					case 4:
						eventText = " You’re definitely in the barracks now.\n You creep past a tunnel "
								+ "which smells like a mess hall,\n your stomach grumbles but you must "
								+ "go on.\n With an army this size why haven’t the orcs and goblins\n "
								+ "stormed out from Oberon Mountain?\n This thought resounds in your head, "
								+ "thoroughly distracted\n you barely noticed the change in scenery,\n "
								+ "tiled well laid pavement with walls to match.\n The path you are "
								+ "headed down is leading towards what seems to be the office\n quarters, "
								+ "which might explain the path’s infrequent use.\n Being more attentive…\n";
						randomEvent();
						eventNumber++;
						break;
					case 5:
						int dialogResult = JOptionPane.showConfirmDialog(null, "There is something up "
								+ "ahead, do you wish to continue?", "WAIT!", JOptionPane.YES_NO_OPTION);
						switch (dialogResult) {
						case 0:
							eventText = " You are about to open a door\n when you stop and hear what "
									+ "is going on behind it…\n “Bork, there seems to be a disturbance in "
									+ "the lower warrens.”\n “Are those pesky goblins at it again?”\n “No "
									+ "sir, it’s something else?”\n Bork, this cannot be!\n Bork raised "
									+ "thousands of villages in his heyday\n and killed many valiant "
									+ "heroes along the way.\n He was finally stopped at Oldbridge due to "
									+ "Nikolaus the Big\n who many thought cut him down…\n but how is here "
									+ "then?\n Nikolaus the Big most have entrapped him in Oberon Mountain…\n "
									+ "this news is almost as shocking as the fact that\n there is a ginormous "
									+ "army waiting beneath Oldbridge.\n You think to yourself,\n ‘If I at "
									+ "least kill Bork I will have done the world an enormous favor’.\n "
									+ "Before you think even more, you kick down the door and charge...\n";
							specialFight(1);
							shopWindow.changeGoldLabel();
							eventNumber++;
							break;
						}
						break;
					case 6:
						eventText = " Bork is dead!\n You feel pride and fame become yours,\n riches "
								+ "unimaginable, the women of Oldbridge cheering for you,\n the Key to the "
								+ "city and much more.\n Thoroughly exhilarated you have an additional "
								+ "bounce in your step.\n The look on Bork’s face when you rushed him was "
								+ "pure gold;\n never did you think an orc could make such a face!\n The "
								+ "wall on the map confirms your path \n but the tantalizing question still "
								+ "remains;\n who is the one that is holding back the hordes in Oberon "
								+ "Mountain?\n Is he an unnamed hero or a fell entity\n that wants control of "
								+ "the armies below?\n Enough pondering!\n As you snap your focus back to "
								+ "what is ahead …\n";
						randomEvent();
						eventNumber++;
						break;
					case 7:
						eventText = " You have been traveling for some time now;\n it most certainly a new "
								+ "day but there is no rest for you.\n You feel the beady eyes of goblins "
								+ "peering\n from side tunnels, none of these are stupid enough \nto expose "
								+ "themselves to your wrath.\n You again notice a change around the walls of "
								+ "the tunnel.\n It seems more structured as if built by human hands…\nYes!\n "
								+ "The walls contain pictures of the deeds of the heroes\n of man from Bjeernov "
								+ "the Bold who arm wrestled\n K’rathanax the Mighty to death.\n To Ginnia the "
								+ "Tiny who was swallowed by the dragon\n Viaryumest the Terrible, the same "
								+ "dragon who wrecked the\n central kingdoms and owned the largest horde of "
								+ "treasure.\n Only Ginnia knew where it was, \nshe did spend a full year in "
								+ "the stomach of the beast.\n When Viarymust was struck down my Mafer "
								+ "Keenshot,\n it was not he who obtained the killing blow but Ginnia.\n "
								+ "‘It’s amazing that all my childhood tales\n when I was young were "
								+ "indeed true’\n you think to yourself.\n There are also numerous stories "
								+ "unaccounted\n for, like who is this diminutive man over this godly forge\n "
								+ "making what looks like a dagger?\n And is that Bob crafting his legendary "
								+ "weapon?\n Yes, his arms are clearly missing in the next picture.\n And "
								+ "finally there is Rexthar with his diary,\n writing his stories, and in the "
								+ "next picture\n defeating the great duelist Mizzlemar\n with his legendary "
								+ "pen.\n Right in the eye!\n ‘Man’, you think to yourself,\n ’if only "
								+ "I had more time to record all of this lost history!’\n Someday maybe your "
								+ "picture will be recorded here\n with your deeds laid bare for\n all to see "
								+ "their magnificence.\n Someday but first…you peel your eyes from the walls\n "
								+ "to the corridor ahead and…\n ";
						randomEvent();
						eventNumber++;
						break;
					case 8:
						eventText = " You feel that you have grown in your journey so far.\n You have become "
								+ "a master at your craft\n and have been defeating monsters\n and hazards "
								+ "to get so far.\n You feel apprehensive as you know that the thing at the "
								+ "end\n of the tunnels is going to be a challenge.\n You see no indication "
								+ "of it mentioned\n anywhere on the walls around you,\n so is it a demon?\n "
								+ "As you steadily walk forward you see the history\n of men on the walls "
								+ "around you,\n but of also races thought mystical and fictional,\n like "
								+ "these pictures of tall slender men,\n elves by the looks,\n or these squat "
								+ "dwarves who are fond of ale.\n ‘When things are at their darkest,\n it’s a "
								+ "brave man that can kick back and party’\n you think as you look on the wall "
								+ "at the dwarfs’ downfall\n and continual drinking habits.\n  The air is "
								+ "getting lighter and\n a refreshing breeze washes over you.\n ‘After a long "
								+ "walk such as this a bath\n right now would be a suitable award’\n you think "
								+ "to yourself.\n Turning your head…\n";
						randomEvent();
						eventNumber++;
						break;
					case 9:
						eventText = " There is a noticeable difference in the air,\n it thickens in "
								+ "anticipation.\n You think you hear bird sounds\n trickle down the "
								+ "tunnel.\n Your eyes adjust to the new lighting,\n which is brighter "
								+ "now.\n It seems like you are in a burial crypt and\n moving out of the "
								+ "corridor of histories.\n There are very few signs of goblin kind here\n "
								+ "and the side tunnels are now few\n and far between, if any, for many "
								+ "miles.\n You think you are alone when…\n";
						randomEvent();
						eventNumber++;
						break;
					case 10:
						int dialogResult2 = JOptionPane.showConfirmDialog(null, "There is something up ahead, "
								+ "do you wish to continue?", "WAIT!", JOptionPane.YES_NO_OPTION);
						switch (dialogResult2) {
						case 0:
							eventText = " Before you stands the being, Malrhune the Watcher.\n "
									+ "He stands majestically atop a pile of\n orc and goblin "
									+ "corpses sharpening his blade.\n The blade itself stands "
									+ "shining the outside light in,\n you see upon it ancient "
									+ "symbols of the yesteryear.\n Malrhune announces himself\n "
									+ "to your presence saying,\n “I am Malrhune the Watcher.\n "
									+ "I am the Vigilance who marks all who come here.\n You cannot "
									+ "leave as I do not know you.”\n\n “I fell here on mistake and\n "
									+ "tumbled into the goblin warrens”,\n you plead to Malrhune.\n\n "
									+ "“Demon I have heard far better stories in my long life,\n this is "
									+ "an affront to my knowledge.\n You cannot leave fell being.”\n "
									+ "Malrhune stops his sharpening\n and points his sword at you,\n "
									+ "dazzling you with its brilliance.\n “Not of demonic nature…\n "
									+ "then what are you, trickster?\n I shall not have Bork rain down\n "
									+ "his armies in the kingdoms below.”\n\n “I have killed the Orcish "
									+ "Champion, Bork!\n Look at my gear and realize I am a friend!”\n\n "
									+ "“ENOUGH!\n I have been sentenced to stand watch over this,\n the one "
									+ "and only escape of Oberon Mountain\n to make sure none of the evils "
									+ "leave.\n I know not what or who you are and\n I must keep my oath.”\n "
									+ "With that Malrhune charges at you swinging\n his runic blade at your "
									+ "head,\n you deftly duck and draw you weapon.\n";
							specialFight(2);
							moveButton.setText("End Game");
							eventNumber++;
							break;
						}
						break;
					case 11:
						System.exit(1);
						break;
					}
					
				}
		});
	}

	public void randomEvent() {
		Random random = new Random();
		int randomNumber = random.nextInt(7);
		
		if (randomNumber > 2 && randomNumber <= 5) { 
			randomNumber = 1;				
		}
		if (randomNumber > 5) {
			randomNumber = 2;
		}

		switch (randomNumber) {

		case 0:
			chest();
			shopWindow.changeGoldLabel();
			break;
		case 1:
			fight();
			shopWindow.changeGoldLabel();
			break;
		case 2:
			trap();
			shopWindow.changeGoldLabel();
			break;
		}
	}
	public void chest() {
		Object[] options = { "Open", "Leave" };
		int maxGold = 0;
		String chestName = "";
		
		eventText = eventText + "\nYou find a chest!\n\n";
		mainText.setText(eventText);
		
		Random random = new Random();
		int randomNumber = random.nextInt(5);

		switch (randomNumber) {

		case 0:
			chestName = "Dinky";
			maxGold = 1340;
			break;
		case 1:
			chestName = "Iron";
			maxGold = 1950;
			break;
		case 2:
			chestName = "Exuberant";
			maxGold = 3000;
			break;
		}
		maxGold = maxGold + (eventNumber * 75);
		
		int dialogResult = JOptionPane.showOptionDialog(null, "There is a chest in front of you.\nWhat do you do?",
				"Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		switch(dialogResult) {
		case 0:
			if (randomNumber != 3 && randomNumber !=4) {		
				Random randomChestAmount00 = new Random();
				int randomChestAmount0 = randomChestAmount00.nextInt(maxGold);
				if (characterHpStartAndGold.getCharType().equals("Rogue")) {
					Random rogueBonus = new Random();
					int rogueBonus0 = rogueBonus.nextInt(maxRogueGold);
					randomChestAmount0 = randomChestAmount0 + rogueBonus0;
				}
			eventText = eventText + "You open the "+chestName+" chest and find " + randomChestAmount0 + " Ω";
			shopWindow.raiseGold(randomChestAmount0);
			mainText.setText(eventText);
			}
			else {
				specialFight(0);
			}
			break;
		case 1:
			mainText.setText(eventText + "\n You decide to not open the chest.");
			break;
		}
	}
	
	public void fight() {
		Object[] options = { "Attack", "Heal", "Flee", "Details" };
		int monsterAd = 0, monsterHp = 0, maxGold = 0;
		String monsterName = "", monsterDetails = "";
		boolean monsterDead = false;
		
		Random random = new Random();
		int randomNumber = random.nextInt(11);

		switch (randomNumber) {

		case 0:
			monsterName = "Goblin Lowlife";
			monsterDetails = "A low life, living well below the standards of goblin kind.";
			monsterAd = 2;
			monsterHp = 100;
			maxGold = 450;
			break;
		case 1:
			monsterName = "Zealot Goblin";
			monsterDetails = "Shouting fanatical praises to his demonic overlords, this goblin has gone way off the reservation.";
			monsterAd = 3;
			monsterHp = 195;
			maxGold = 550;
			break;
		case 2:
			monsterName = "Goblin";
			monsterDetails = "A stinky little creature that wants to tear your face off. Not overly smart and not very strong.";
			monsterAd = 3;
			monsterHp = 125;
			maxGold = 450;
			break;
		case 3:
			monsterName = "Goblin Trickster";
			monsterDetails = "A goblin who is a bit smarter than the average. Wait, what is he doing?";
			monsterAd = 4;
			monsterHp = 150;
			maxGold = 620;
			break;
		case 4:
			monsterName = "Sploder Goblin";
			monsterDetails = "A scrawny little thing with TNT on his back...wait TNT?!?";
			monsterAd = 16;
			monsterHp = 25;
			maxGold = 600;
			break;
		case 5:
			monsterName = "Goblin Alchemist";
			monsterDetails = "A goblin that rises above the rest. A true master of alchemy and... who still wants to rip your face off.";
			monsterAd = 5;
			monsterHp = 215;
			maxGold = 850;
			break;
		case 6:
			monsterName = "Orc";
			monsterDetails = "Bigger than your average goblin and stronger. Somehow stinkier, too.";
			monsterAd = 7;
			monsterHp = 200;
			maxGold = 825;
			break;
		case 7:
			monsterName = "Orc Berserker";
			monsterDetails = "A crazed orc that looks a bit rabid, this is definitely not good.";
			monsterAd = 10;
			monsterHp = 175;
			maxGold = 850;
			break;
		case 8:
			monsterName = "Orc Shaman";
			monsterDetails = "A hooded orc who convorts with demons, true evil.";
			monsterAd = 5;
			monsterHp = 250;
			maxGold = 850;
			break;
		case 9:
			monsterName = "Troll";
			monsterDetails = "Usually thought to live under bridges, this one seems to have expanded his turf and is deciding on keeping it.";
			monsterAd = 4;
			monsterHp = 300;
			maxGold = 950;
			break;
		case 10:
			monsterName = "Ogre";
			monsterDetails = "Either it is an extremely obese goblin or a really fat orc. And it's looking for more food to stuff its face with.";
			monsterAd = 5;
			monsterHp = 450;
			maxGold = 1350;
			break;
		}
		
		monsterAd = monsterAd + (eventNumber * 3);
		monsterHp = monsterHp + (eventNumber * 45);
		maxGold = maxGold + (eventNumber * 40);
		
		if (monsterName.equals("Ogre") || monsterName.equals("Orc") || monsterName.equals("Orc Berserker") || monsterName.equals("Orc Shaman")) {
			eventText = eventText + "\nAn " +monsterName+" crosses your path!\n";
		}
		else {
			eventText = eventText + "\nA " +monsterName+" crosses your path!\n";
		}
		
		mainText.setText(eventText);
			
		while(!monsterDead) {
			int dialogResult = JOptionPane.showOptionDialog(null, "What do you do?\nThe "+ monsterName +" has: " + monsterHp + "HP\nYou have: " + characterHpStartAndGold.getCharHpInString() + " HP" , "Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			switch (dialogResult) {
				case 0:
					Random randomPlayerAttackDamage0 = new Random();
					int randomAttackDamageAmount0 = randomPlayerAttackDamage0.nextInt(characterHpStartAndGold.getAttackDamage());
					if (characterHpStartAndGold.getCharType().equals("Wizard")) {
						randomAttackDamageAmount0 = randomAttackDamageAmount0 + 5;
					}
					monsterHp = monsterHp - randomAttackDamageAmount0;
					if (randomAttackDamageAmount0 == 0) {
						eventText = eventText + "\nYou Missed";
					}
					else {
						eventText = eventText + "\nYou hit the "+monsterName+ " for " + randomAttackDamageAmount0 + " HP";
					}
					
					
					if (monsterHp <= 0) {
						monsterDead = true;
						Random randomBatGold = new Random();
						int randomBatGoldWon = randomBatGold.nextInt(maxGold);
						int minGold = maxGold/2;
						while (randomBatGoldWon <= minGold) {
							randomBatGoldWon = randomBatGold.nextInt(maxGold);
						}
						if (characterHpStartAndGold.getCharType().equals("Rogue")) {
							Random rogueBonus = new Random();
							int rogueBonus0 = rogueBonus.nextInt(maxRogueGold);
							randomBatGoldWon = randomBatGoldWon + rogueBonus0;
						}
						shopWindow.raiseGold(randomBatGoldWon);
						eventText = eventText + " and kill it!\n\nThe "+monsterName+" is dead, you get " + randomBatGoldWon + " Ω";
						if (monsterName.equals("Sploder Goblin")) {
							Random tnt = new Random();
							int tntN = tnt.nextInt(100);
							characterHpStartAndGold.lowerHp(tntN);
							eventText = eventText + "\n\nThe Sploder Goblin blows up and hits you for " +tntN+ " HP.";
							hpLabel.setText("HP: " + characterHpStartAndGold.getCharHpInString());
						}
					}
					else {
						Random randomBatAttackDamage = new Random();
						int randomBatAttackDamageAmount = randomBatAttackDamage.nextInt(monsterAd);
						randomBatAttackDamageAmount = randomBatAttackDamageAmount + 3;
						if (characterHpStartAndGold.getCharType().equals("Warrior")) {
							randomBatAttackDamageAmount = randomBatAttackDamageAmount - 3;
						}
						characterHpStartAndGold.lowerHp(randomBatAttackDamageAmount);
						hpLabel.setText("HP: " + characterHpStartAndGold.getCharHpInString());
						if (randomBatAttackDamageAmount == 0) {
							eventText = eventText + ".\n"+monsterName+ " Missed\n";
						}
						else {
							eventText = eventText + ".\nThe "+monsterName+" hits you for " + randomBatAttackDamageAmount +  " HP.\n";
						}
						
					}
					mainText.setText(eventText);
					characterHpStartAndGold.loseGame();
					break;
			case 2:
				Random randomFleeBatDamage = new Random();
				int randomFleeBatDamageAmount = randomFleeBatDamage.nextInt(monsterAd);
				randomFleeBatDamageAmount++;
				if (characterHpStartAndGold.getCharType().equals("Warrior")) {
					randomFleeBatDamageAmount = randomFleeBatDamageAmount - 1;
				}
				characterHpStartAndGold.lowerHp(randomFleeBatDamageAmount);
				eventText = eventText + "\nYou fled and took " + randomFleeBatDamageAmount + " damage!";
				mainText.setText(eventText);
				hpLabel.setText("HP: " + characterHpStartAndGold.getCharHpInString());
				characterHpStartAndGold.loseGame();
				monsterDead = true;
				break;
			case 1:
				hpPotion();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, monsterDetails + "\n\nMonster attack damage: " + monsterAd, "Character Description", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
		
	}
	public void specialFight(int i) {
		Object[] options = { "Attack", "Heal", "Details" };
		int monsterAd = 0, monsterHp = 0, maxGold = 0;
		String monsterName = "", monsterDetails = "";
		boolean monsterDead = false;

		switch (i) {

		case 0:
			monsterName = "Mimic";
			monsterDetails = "Looks just like a chest!  You cannot escape it!";
			monsterAd = 5 + (eventNumber*3);
			monsterHp = 150 + (eventNumber*45);
			maxGold = 600 + (eventNumber*50);
			break;
		case 1:
			monsterName = "Orcish Champion, Bork";
			monsterDetails = "Bork is said to have slain thousands of heroes before he was trapped under the Mountain.\nHighly exalted among his friends, he looks ready to add another notch to his axe.";
			monsterAd = 22;
			monsterHp = 1337;
			maxGold = 3500;
			break;
		case 2:
			monsterName = "Watcher, Malrhune";
			monsterDetails = "He does not allow anyone to leave Oberon Mountain.\nHis job is made easier by the wall of dead orcs and goblins at his feet.\nA truly magnificent foe. No negotiations, no mercy.";
			monsterAd = 42;
			monsterHp = 4242;
			break;
		}
			
			if (monsterName.equals("Orcish Champion, Bork")) {
				eventText = eventText + "\nYou engage Bork!\n";
			}
			else if (monsterName.equals("Watcher, Malrhune")){
				eventText = eventText + "\nYou engage Malrhune!\n";
			}
			else {
				eventText = eventText + "Instead of a chest, a "+monsterName+" clamps onto you as you reach for the treasure!\n";
			
		}
		
		mainText.setText(eventText);
		while(!monsterDead) {
			
			int dialogResult = JOptionPane.showOptionDialog(null, "What do you do?\nThe "+ monsterName +" has: " + monsterHp + "HP\nYou have: " + characterHpStartAndGold.getCharHpInString() + " HP" , "Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			switch (dialogResult) {
				case 0:
					Random randomPlayerAttackDamage0 = new Random();
					int randomAttackDamageAmount0 = randomPlayerAttackDamage0.nextInt(characterHpStartAndGold.getAttackDamage());
					if (characterHpStartAndGold.getCharType().equals("Wizard")) {
						randomAttackDamageAmount0 = randomAttackDamageAmount0 + 5;
					}
					monsterHp = monsterHp - randomAttackDamageAmount0;
					if (randomAttackDamageAmount0 == 0) {
						eventText = eventText + "\nYou Missed";
					}
					else {
						eventText = eventText + "\nYou hit the "+monsterName+ " for " + randomAttackDamageAmount0 + " HP";
					}
					
					
					if (monsterHp <= 0) {
						monsterDead = true;
						Random randomBatGold = new Random();
						if (i != 2){
							int randomBatGoldWon = randomBatGold.nextInt(maxGold);
							int minGold = maxGold/2;
							while (randomBatGoldWon <= minGold) {
								randomBatGoldWon = randomBatGold.nextInt(maxGold);
							}
							if (characterHpStartAndGold.getCharType().equals("Rogue")) {
								Random rogueBonus = new Random();
								int rogueBonus0 = rogueBonus.nextInt(maxRogueGold);
								randomBatGoldWon = randomBatGoldWon + rogueBonus0;
							}
							shopWindow.raiseGold(randomBatGoldWon);
							eventText = eventText + " and kill it!\n\nThe "+monsterName+" is dead, you get " + randomBatGoldWon + " Ω";
						}
						else {
							eventText = eventText + " and kill him!\n\n Upon looking at the mangled corpse of Malrhune,\n you shed a tear for such a dutiful soldier.\n The Watcher’s sword reads,\n\n “As long you hold your ground\n the world will be at Peace.\n If you waver we die.”\n\n You pick up the blade and carry it with you,\n a testament to your deeds.\n As you stride out in the sun shine you hear\n behind you the horns of war\n as goblin scouts report the downfall of The Watcher.\n You quicken your pace towards Oldbridge\n to warn them of their peril.\n Your legend has only begun…\n\n\n                 ******************************************************************\n                                                       You win the game!\n                 ******************************************************************";
						}
						
						
					}
					else {
						Random randomBatAttackDamage = new Random();
						int randomBatAttackDamageAmount = randomBatAttackDamage.nextInt(monsterAd);
						randomBatAttackDamageAmount = randomBatAttackDamageAmount + 3;
						if (characterHpStartAndGold.getCharType().equals("Warrior")) {
							randomBatAttackDamageAmount = randomBatAttackDamageAmount - 3;
						}
						characterHpStartAndGold.lowerHp(randomBatAttackDamageAmount);
						hpLabel.setText("HP: " + characterHpStartAndGold.getCharHpInString());
						if (randomBatAttackDamageAmount == 0) {
							eventText = eventText + ".\n"+monsterName+ " Missed\n";
						}
						else {
							eventText = eventText + ".\nThe "+monsterName+" hits you for " + randomBatAttackDamageAmount +  " HP.\n";
						}
						
					}
					mainText.setText(eventText);
					characterHpStartAndGold.loseGame();
					break;

			case 1:
				hpPotion();
				break;
			case 2:
				JOptionPane.showMessageDialog(null, monsterDetails + "\n\nMonster attack damage: " + monsterAd, "Character Description", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}

	public void trap() {
		Object[] options = { "Disable", "Heal", "Go through", "Details" };
		int trapAd = 0,  maxGold = 0, trapDifficulty = 0;
		String trapName = "", trapDetails = "";
		boolean trapDisabled = false;
		
		Random random = new Random();
		int randomNumber = random.nextInt(8);
		
		switch (randomNumber) {

		case 0:
			trapName = "Spike";
			trapDetails = "Made to skewer anyone crossing it. By the looks of it goblins come here a lot.";
			trapAd = 3;
			maxGold = 500;
			trapDifficulty = 6;
			break;
		case 1:
			trapName = "Arrow";
			trapDetails = "Tiny holes dot the walls around you. A few corpses litter the ground with arrows in their bodies. It's a trap.";
			trapAd = 5;
			maxGold = 650;
			trapDifficulty = 7;
			break;
		case 2:
			trapName = "Tripwire";
			trapDetails = "This has been undisturbed for some time. I wonder what it triggers... best not to find out.";
			trapAd = 7;
			maxGold = 600;
			trapDifficulty = 8;
			break;
		case 3:
			trapName = "Flame";
			trapDetails = "Smells crispy in here...I wonder why?";
			trapAd = 10;
			maxGold = 700;
			trapDifficulty = 9;
			break;
		case 4:
			trapName = "Pitfall";
			trapDetails = "The floor seems different here. Is that a sound of a goblin below my feet?";
			trapAd = 8;
			maxGold = 850;
			trapDifficulty = 10;
			break;
		case 5:
			trapName = "Arcane";
			trapDetails = "Looks magical, and by the way the bodies are piled around here it's definintly not good magic.";
			trapAd = 10;
			maxGold = 1000;
			trapDifficulty = 13;
			break;
		case 6:
			trapName = "Boulder";
			trapDetails = "A huge stone is carefully placed above your head. Best not to make any sudden moves.";
			trapAd = 12;
			maxGold = 1500;
			trapDifficulty = 15;
			break;
		case 7:
			trapName = "Rockfall";
			trapDetails = "A ton, both literally and metaphorically, of rocks are in such a position to mangle your body. Best to be careful now.";
			trapAd = 11;
			maxGold = 1750;
			trapDifficulty = 20;
			break;
		}
			if (characterHpStartAndGold.getCharType().equals("Rogue")) {
				trapDifficulty--;
			}
			trapAd = trapAd + eventNumber;
			trapDifficulty = trapDifficulty + (eventNumber*2);
			maxGold = maxGold + (eventNumber * 75);
			eventText = eventText + "\nYou stumble upon a "+trapName+" trap!\n";
			mainText.setText(eventText);
			while (!trapDisabled) {
			int dialogResult = JOptionPane.showOptionDialog(null, "Disable " +trapName+" trap?\n" + "\nYou have: " + characterHpStartAndGold.getCharHpInString() + " HP" , "Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			switch (dialogResult) {
				case 0:
					Random randomEasyTrapDisable = new Random();
					int randomEasyTrapDisableValue = randomEasyTrapDisable.nextInt(trapDifficulty);
					if (randomEasyTrapDisableValue == 0) {
						trapDisabled = true;
						Random randomEasyTrapGold = new Random();
						int randomEasyGoldWon = randomEasyTrapGold.nextInt(maxGold);
						int minGold = maxGold/2;
						while (randomEasyGoldWon <= minGold) {
							randomEasyGoldWon = randomEasyTrapGold.nextInt(maxGold);
						}
						if (characterHpStartAndGold.getCharType().equals("Rogue")) {
							Random rogueBonus = new Random();
							int rogueBonus0 = rogueBonus.nextInt(maxRogueGold);
							randomEasyGoldWon = randomEasyGoldWon + rogueBonus0;
						}
						shopWindow.raiseGold(randomEasyGoldWon);
						eventText = eventText + "\nYou successfully disabled the "+trapName+" trap and find " + randomEasyGoldWon + " Ω";
						mainText.setText(eventText);
					}
					else {
						Random randomEasyTrapDamage = new Random();
						int randomEasyDamageAmount = randomEasyTrapDamage.nextInt(trapAd);
						randomEasyDamageAmount++;
						if (characterHpStartAndGold.getCharType().equals("Rogue")) {
							randomEasyDamageAmount = randomEasyDamageAmount - 1;
						}
						characterHpStartAndGold.lowerHp(randomEasyDamageAmount);
						
						if (randomEasyDamageAmount == 0) {
							eventText = eventText + "\nYou didn't take any damage from the " +trapName+" trap.\n";
						}
						else {
							eventText = eventText + "\nYou took " + randomEasyDamageAmount + " damage attempting to disable the " +trapName+ " trap.\n";
						}
						hpLabel.setText("HP: " + characterHpStartAndGold.getCharHpInString());
						mainText.setText(eventText);
						characterHpStartAndGold.loseGame();
					}
					break;
				case 2:
					trapDisabled = true;
					Random randomEasyTrapDamageThrough = new Random();
					int randomEasyDamageThroughAmount = randomEasyTrapDamageThrough.nextInt(trapAd);
					randomEasyDamageThroughAmount = randomEasyDamageThroughAmount + 3;
					if (characterHpStartAndGold.getCharType().equals("Rogue")) {
						randomEasyDamageThroughAmount = randomEasyDamageThroughAmount - 3;
					}
					characterHpStartAndGold.lowerHp(randomEasyDamageThroughAmount);
					hpLabel.setText("HP: " + characterHpStartAndGold.getCharHpInString());
					if (randomEasyDamageThroughAmount == 0) {
						eventText = eventText + "\nYou didn't take any damage from going through the " +trapName+ " trap.";
					}
					else {
						eventText = eventText + "\nYou decide to go through the " +trapName+" trap. and take " + randomEasyDamageThroughAmount + " damage";
					}
					
					mainText.setText(eventText);
					characterHpStartAndGold.loseGame();
					break;
				case 1:
					hpPotion();
					break;
				case 3:
					JOptionPane.showMessageDialog(null, trapDetails + "\n\nDifficulty of trap: 1 out of " + trapDifficulty + " chance of disabling.", "Trap Description", JOptionPane.INFORMATION_MESSAGE);
					break;
			}
		}
		
	}
	public void hpPotion() {
		int testHp = charHp - hpHeal;// change to however much hp pot heals
			if (shopWindow.getHpPotAmount() > 0) {
				if (testHp >= characterHpStartAndGold.getCharHp()) {
				eventText = eventText + "\nYou used a health potion and gained "+hpHeal+" health.\n";
				mainText.setText(eventText);
				characterHpStartAndGold.raiseHp(hpHeal);
				hpLabel.setText("HP: " + characterHpStartAndGold.getCharHpInString());
				shopWindow.lowerHpPot();
			}
			else {
				eventText = eventText + "\nYou are already healthy.\n";
				mainText.setText(eventText);
			}
		}
	
		else {
			eventText = eventText + "\nYou don't have any health potions.\n";
			mainText.setText(eventText);
			
		}
	}
	public void showMe() {
		this.setVisible(true);
	}
	public static void changeAdLabel(int howMuch) {
		characterHpStartAndGold.raiseAttackDamage(howMuch);
		attackDamageLabel.setText("AD: " + characterHpStartAndGold.getAttackDamageInString());
	}
}

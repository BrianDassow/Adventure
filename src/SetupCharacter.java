import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SetupCharacter extends JFrame {
	private JTextArea mainText;
	private JButton warriorButton, rogueButton, wizardButton;
	ShopWindow shopWindow = null;
	private String typeOfCharacter = "";
	private Gold gold = null;

	public SetupCharacter() {
		this.setTitle("Select your destiny.");
		this.setBounds(550, 280, 510, 335);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setupComponents() {

		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();

		JPanel subPanelNorth = new JPanel();
		JPanel subPanelCenter = new JPanel();
		JPanel subPanelSouth = new JPanel();

		warriorButton = new JButton("Warrior");
		rogueButton = new JButton("Rogue");
		wizardButton = new JButton("Wizard");

		mainText = new JTextArea(" Like dew, a new hero rises anew.\n On wings great and proud\n "
				+ "It finds a soul, fit and sound\n And softly lands as destiny hands\n This young "
				+ "person a new life\n Reborn and revisioned with love and strife.\n Be he a Warrior, "
				+ "strong and hardy,\n Ready to cleave foes foolhardy?\n Or a Wizard, smart and wise,\n "
				+ "With fire, frost and flame, sending many to their demise.\n Or a Rogue, fearless and "
				+ "cunning,\n Shooting enemies with his bow, o so stunning.\n This is for you to choose,\n "
				+ "Now is the time, make your move… ", 20, 20);
		
		mainText.setEditable(false);

		subPanelNorth.setBackground(Color.BLACK);
		subPanelCenter.setBackground(Color.BLACK);
		subPanelSouth.setBackground(Color.BLACK);
		mainText.setBackground(Color.BLACK);
		mainText.setForeground(Color.YELLOW);
		warriorButton.setForeground(Color.RED);
		warriorButton.setBackground(Color.BLACK);
		rogueButton.setForeground(Color.GRAY);
		rogueButton.setBackground(Color.BLACK);
		wizardButton.setForeground(Color.BLUE);
		wizardButton.setBackground(Color.BLACK);

		
		
		subPanelCenter.add(mainText);

		subPanelSouth.add(warriorButton);
		subPanelSouth.add(rogueButton);
		subPanelSouth.add(wizardButton);

		north.setLayout(new GridLayout(1, 3));
		center.setLayout(new GridLayout(1, 1));
		south.setLayout(new GridLayout(1, 3));

		north.add(subPanelNorth);
		center.add(subPanelCenter);
		south.add(subPanelSouth);

		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);

		warriorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to be a Warrior?\n\nStart with:\n600 Health Points\n20 Attack Damage\n\nSpecial:\nTake less damage from monsters.", "WAIT!", JOptionPane.YES_NO_OPTION);
					switch (dialogResult) {
					case 0:
						typeOfCharacter = "Warrior";
						dontShowMe();
						AdventureInterfaces mainWindow = new AdventureInterfaces("A " + typeOfCharacter +"'s Adventure.",520, 800, typeOfCharacter);
						mainWindow.setupComponents();
						mainWindow.showMe();
						break;
					}

			}
		});
		rogueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to be a Rogue?\n\nStart with:\n500 Health Points\n15 Attack Damage\n\nSpecials:\nEarns more money.\nTakes less damage from traps.\nEasier to disable traps.", "WAIT!", JOptionPane.YES_NO_OPTION);
					switch (dialogResult) {
					case 0:
						typeOfCharacter = "Rogue";
						dontShowMe();
						AdventureInterfaces mainWindow = new AdventureInterfaces("A " + typeOfCharacter +"'s Adventure." ,520, 800, typeOfCharacter);
						mainWindow.setupComponents();
						mainWindow.showMe();
						break;
					}

			}
		});
		wizardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to be a Wizard?\n\nStart with:\n425 Health Points\n25 Attack Damage\n\nSpecial:\nDeal extra damage to monsters.", "WAIT!", JOptionPane.YES_NO_OPTION);
					switch (dialogResult) {
					case 0:
						typeOfCharacter = "Wizard";
						dontShowMe();
						AdventureInterfaces mainWindow = new AdventureInterfaces("A " + typeOfCharacter +"'s Adventure.",520, 800, typeOfCharacter);
						mainWindow.setupComponents();
						mainWindow.showMe();
						break;
					}

			}
		});
	}

	public void showMe() {
		this.setVisible(true);
	}
	public void dontShowMe() {
		this.setVisible(false);
	}
	public String typeOfChar() {
		return typeOfCharacter;
	}
}

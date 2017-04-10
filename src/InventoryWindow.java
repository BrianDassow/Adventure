import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InventoryWindow {
	private JPanel invPanel;
	private JFrame inventory;
	private int potionTotal = 0;
	private JLabel hpLabel;

	public InventoryWindow() {
		inventory = new JFrame("Inventory");
		inventory.setBounds(1000, 500, 200, 200);
		inventory.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		inventory.setVisible(false);

		invPanel = new JPanel();
		inventory.add(invPanel);
		hpLabel = new JLabel("Health Potions: " + potionTotal);
		invPanel.add(hpLabel);
		
		invPanel.setBackground(Color.BLACK);
		hpLabel.setForeground(Color.WHITE);
		
	}

	public void addInventory(JLabel label) {
		invPanel.add(label);
		inventory.add(invPanel);
	}

	public void visible() {
		inventory.setVisible(true);
	}

	public void notVisible() {
		inventory.setVisible(false);
	}
	public void lowerHpPotionAmount() {
		potionTotal--;
		hpLabel.setText("Health Potions: " + potionTotal);
	}
	public void raiseHpPotionAmount() {
		potionTotal++;
		hpLabel.setText("Health Potions: " + potionTotal);
	}
	public boolean check() {
		if (inventory.isVisible() == true) {
				return true;
		}
		else {
			return false;
		}
	}
}
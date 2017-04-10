import javax.swing.JOptionPane;

public class CharacterAttackHpWithGold {
	private int charHp = 0;
	private Gold gold = null;
	private int attackDamage = 0;
	private boolean lose = false;
	private String charType;

	public CharacterAttackHpWithGold(String charType) {
		if (charType == "Warrior") {
			charHp = 600;
			gold = new Gold(0);
			gold.setupGoldAmount(50);
			attackDamage = 20;
			this.charType = charType;
		} else if (charType == "Wizard") {
			charHp = 425;
			gold = new Gold(0);
			gold.setupGoldAmount(50);
			attackDamage = 25;
			this.charType = charType;
		}
		else {
			charHp = 500;
			gold = new Gold(0);
			gold.setupGoldAmount(100);
			attackDamage = 15;
			this.charType = charType;
		}
	}
	public int getCharHp() {
		return charHp;
	}
	public void lowerHp(int howMuch) {
		charHp = charHp - howMuch;
		if (charHp <= 0) {
			lose = true;
			
		}
	}
	public void raiseHp(int howMuch) {
		charHp = charHp + howMuch;
		}
	public int getGoldAmount() {
		return gold.getGoldAmount();
	}
	public String getGold() {
		return gold.getGold();
	}
	public int getAttackDamage() {
		int attackDamage0 = attackDamage + 1;
		return attackDamage0;
	}
	public void lowerAttackDamage(int howMuch) {
		attackDamage = attackDamage - howMuch;
	}
	public void raiseAttackDamage(int howMuch) {
		attackDamage = attackDamage + howMuch;
	}
	public String getCharHpInString() {
		return charHp + "";
	}
	public String getAttackDamageInString() {
		return attackDamage + "";
	}
	public String getCharType() {
		return charType;
	}
	public void loseGame() {
		if (lose) {
			JOptionPane.showMessageDialog(null, "You have fallen on or below 0 hp.\nYou lose.");
			System.exit(1);
		}
	}
}

import java.util.Random;


public class Gold {
	private int gold;
	private String goldString;

	public Gold(int gold) {
		this.gold = gold;
	}
	public String getGold() {
		goldString = gold + " Ω";
		return goldString;
	}
	public int getGoldAmount() {
		return gold;
	}
	public void setupGoldAmount(int howMuch) {
		this.gold = howMuch;
	}
	public void lowerGold(int howMuch) {
		gold = gold - howMuch;
	}
	public void raiseGold(int howMuch) {
		gold = gold + howMuch;
	}
}

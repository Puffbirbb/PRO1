package simple;

import java.util.function.ToLongBiFunction;

public class DiceThrower {
	// 2 dice with face count of 6 each
	private simple.Die die1, die2;
	private int rollCount;
	private int totalFaceValue;
	private int faceValueSix;
	private int sameFace;
	private int maxFaceSum;
	private double averageSum;

	/**
	 * Creates a DiceThrower object.
	 */
	public DiceThrower(){
		die1 = new simple.Die();
		die2 = new simple.Die();
		this.rollCount = 0;
		this.totalFaceValue = 0;
		this.faceValueSix = 0;
		this.sameFace = 0;
		this.maxFaceSum = 0;
		this.averageSum = 0;
	}

	public int getRollCount(){
		return rollCount;
	}

	public int getTotalFaceValue(){
		return totalFaceValue;
	}

	public int getFaceValueSix(){
		return faceValueSix;
	}

	public int getSameFace(){
		return sameFace;
	}

	public int getMaxFaceSum(){
		return maxFaceSum;
	}

	public double getAverageSum(){
		return (double)totalFaceValue / rollCount;
	}

	/**
	 * Rolls the 2 dice.
	 */
	public void roll() {
		die1.roll();
		die2.roll();
		rollCount++;
		totalFaceValue += sum();
		if (die1.faceValue == 6){
			faceValueSix++;
		}
		if (die2.faceValue == 6){
			faceValueSix++;
		}
		else if (die1.faceValue == 6 && die2.faceValue == 6){
			faceValueSix += 2;
		}
		if (die1.faceValue == die2.faceValue){
			sameFace++;
		}
		if (sum() > maxFaceSum){
			maxFaceSum = sum();
		}
	}

	/**
	 * Returns the sum of the face values in a roll.
	 */
	public int sum() {
		return die1.faceValue + die2.faceValue;
	}

	/**
	 * Returns a textual description of the roll of the 2 dice.
	 * Example: Returns "(4,5)" for a roll of 4 and 5.
	 */
	public String rollDescription() {
		return String.format("(%d,%d)", die1.getFaceValue(), die2.getFaceValue());
	}
}

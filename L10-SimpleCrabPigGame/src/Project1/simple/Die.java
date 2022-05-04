package simple;

import java.util.Random;

public class Die {
	// number of faces
	public int faceCount;
	// value of upper face
	public int faceValue = 0;
	Random generator = new Random();
	/**
	 * Creates a die with the given face count and a random face value.
	 */
	public void DiePlus(int faceCount) {
		this.faceCount = faceCount;
		this.faceValue = 1 + generator.nextInt(faceCount);
	}

	/**
	 * Creates a die with 6 faces and a random face value.
	 */
	public Die() {
		this.faceCount = 6;
		this.faceValue = 1 + generator.nextInt(faceCount);
	}

	public int getFaceCount(){
		return faceCount;
	}

	public int getFaceValue(){
		return faceValue;
	}

	/**
	 * Rolls the die, resulting in a new face value.
	 */
	public void roll() {
		faceValue = 1 + generator.nextInt(faceCount);
	}
}
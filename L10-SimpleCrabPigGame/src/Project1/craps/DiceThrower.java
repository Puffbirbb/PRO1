package Project1.craps;

public class DiceThrower {

        // 2 dice with face count of 6 each
        private Die die1;
        private Die die2;

        // Fields:
        // 1. The roll count.
        private int rollCount;


        /**
         * Creates a DiceThrower object.
         */
        public DiceThrower(){
            die1 = new Die();
            die2 = new Die();
            rollCount = 0;
        }

        public int getRollCount() {
            return rollCount;
        }

        /**
         * Rolls the 2 dice.
         */
        public void roll() {
            die1.roll();
            rollCount += 1;
        }

        public String rollDescription() {
        return String.format("(%d,%d)", die1.getFaceValue(), die2.getFaceValue());
    }

        /**
         * Returns the sum of the face values in a roll.
         */
        public int sum() {
            return die1.getFaceValue();
        }
    }

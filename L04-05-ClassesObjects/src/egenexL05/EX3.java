package egenexL05;

import java.util.Locale;

public class EX3 {
    public static void main(String[] args) {

        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";

        /**
         * a
         */
        String toUpperCase = ord1.toUpperCase();
        System.out.println(toUpperCase);

        /**
         * b
         */
        String toLowerCase = ord2.toLowerCase();
        System.out.println(toLowerCase);

        /**
         * c
         */
        System.out.println(ord1 + " " + ord2);

        /**
         * d
         */
        String ord3 = ord1 + " " + toLowerCase;
        System.out.println(ord3);

        /**
         * e
         */
        int length = ord3.length();
        System.out.println(length);

        /**
         * f
         */
        String Seven = ord3.substring(0, 7);
        System.out.println(Seven);

        /**
         * g
         */
        String TtS = ord2.substring(3, 7);
        System.out.println(TtS);

        /**
         * h
         */
        String SH = ord3.substring(ord3.lastIndexOf(' '));
        System.out.println(SH);
    }
}

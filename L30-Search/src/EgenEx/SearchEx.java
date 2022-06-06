package EgenEx;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchEx {
    public static void main(String[] args) {

        //opg 1 -------------------------------------------------------------
        int[] evenNumbers = {2, 4, 6, 8, 10, 12, 14};
        int[] unevenNumbers = {2, 4, 6, 8, 9, 10, 12, 14};
        System.out.print("Even number?: ");
        System.out.println(unevenLinearSearchArray(evenNumbers));
        System.out.print("Even number?: ");
        System.out.println(unevenLinearSearchArray(unevenNumbers));

        System.out.println();

        //opg 2 -------------------------------------------------------------
        int[] betweenNumber = {7, 56, 34, 3, 7, 14, 13, 4};
        System.out.print("Between 10 and 15: ");
        System.out.println(betweenLinearSearchArray(betweenNumber));

        System.out.println();

        //opg 3 -------------------------------------------------------------
        int[] notSameNumbers = {7, 9, 13, 7, 9, 13};
        int[] sameNumbers = {7, 9, 13, 13, 9, 7};
        System.out.print("2 numbers in a row?: ");
        System.out.println(sameLinearSearchArray(notSameNumbers));
        System.out.print("2 numbers in a row?: ");
        System.out.println(sameLinearSearchArray(sameNumbers));

        System.out.println();

        //opg 4 -------------------------------------------------------------
        //a, b, c
        Player p1 = new Player("John", 178, 72,10);
        Player p2 = new Player("Jens", 190, 78,0);
        Player p3 = new Player("Søren", 182, 74,2);
        Player p4 = new Player("Peter", 188, 76,0);
        Player p5 = new Player("Rasmus", 183, 76,3);
        Player p6 = new Player("Jannik", 176, 71,5);
        Player p7 = new Player("Simon", 152, 65,200);
        Player p8 = new Player("Lasse", 199, 83,1);

        //a, c
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
        players.add(p7);
        players.add(p8);

        //b
        ArrayList<Player> playersSorted = new ArrayList<>();
        playersSorted.add(p7);
        playersSorted.add(p1);
        playersSorted.add(p6);
        playersSorted.add(p5);
        playersSorted.add(p3);
        playersSorted.add(p8);
        playersSorted.add(p4);
        playersSorted.add(p2);

        //a
        System.out.print(goalLinearSearchPlayer(players));

        //b
        System.out.println("");
        System.out.println(findPlayerBinary(playersSorted, 3));

        //c
        System.out.println(smolPlayerName(players));

        System.out.println();

        //opg 5 -------------------------------------------------------------
        ArrayList<String> Galaxies = new ArrayList<>(List.of("Milky Way", "Andromeda", "Cigar", "Sombrero", "NGC 1300"));
        String galaxy = "NGC 1300";
        System.out.println(findAllIndices(Galaxies, galaxy));

        //opg 6 -------------------------------------------------------------
        System.out.println();
        System.out.print("kkkhahaha has 3 repeating characters?: ");
        System.out.println(repeatedChars("kkkhahaha", 3));
        System.out.print("ituuuiop has 4 repeating characters?: ");
        System.out.println(repeatedChars("ituuuiop", 4));

        //opg 7 -------------------------------------------------------------
        int[] t = {4, 3, 12, 5, 7, -4, 1, 8, 12};
        System.out.println("\n" + Arrays.toString(t));
        System.out.print("From Index ");
        System.out.print(searchSum(t,9));
        System.out.println(" total is 9.");
        int[] t1 = {1, 2, 3, 4, 5, 15, 15};
        System.out.println("\n" + Arrays.toString(t1));
        System.out.print("From Index ");
        System.out.print(searchSum(t1,30));
        System.out.println(" total is 30.");
    }

    //opg 1
    public static boolean unevenLinearSearchArray(int[] arr) {
        boolean uneven = false;
        int i = 0;
        while (!uneven && i < arr.length) {
            int k = arr[i];
            if (k % 2 != 0)
                uneven = true;
            else
                i++;
        }
        return uneven;
    }

    //opg 2
    public static int betweenLinearSearchArray(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int k = arr[i];
            if (k < 10 || k > 15)
                i++;
            else
                return arr[i];
        }
        return -1;
    }

    //opg 3
    public static boolean sameLinearSearchArray(int[] arr) {
        boolean same = false;
        int i = 0;
        while (!same && i < arr.length - 1) {
            int k = arr[i];
            if (k == arr[i+1])
                same = true;
            else
                i++;
        }
        return same;
    }

    //opg 4
    //a
    public static Player goalLinearSearchPlayer(ArrayList<Player> list) {
        Player player = null;
        int i = 0;
        while (player == null && i < list.size()) {
            Player p = list.get(i);
            if (p.getScoredGoals() > 0)
                player = p;
            else
                i++;
        }
        return player;
    }

    //b
    public static Player findPlayerBinary(ArrayList<Player> list, int score) {
        Player player = null;
        int left = 0;
        int right = list.size() - 1;
        while (player == null && left <= right) {
            int middle = (left+right) / 2;
            Player p = list.get(middle);
            if (p.getScoredGoals() == score)
                player = p;
            else if (p.getScoredGoals() > 0)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return player;
    }

    //c
    public static Player smolPlayerName(ArrayList<Player> players) {
        Player player = null;
        int i = 0;
        while (player == null && i < players.size()) {
            Player p = players.get(i);
            if (p.getScoredGoals() >= 50 && p.getHeight() <= 170)
                player = p;
            else
                i++;
        }
        return player;
    }

    //opg 5
    public static ArrayList<Integer> findAllIndices(ArrayList<String> list, String target) {
        int index = -1;
        int i = 0;
        ArrayList<Integer> allIndices = new ArrayList<>();
        while (index == -1 && i < list.size()) {
            String g = list.get(i);
            if (g.equals(target)) {
                index = i;
                allIndices.add(i);
            }
            else
                allIndices.add(i);
                i++;
        }
        return allIndices;
    }

    //opg 6
    public static boolean repeatedChars(String s, int k) {
        boolean repeated = false;
        int i = 0;
        while (!repeated && i < s.length() + 1 - k) {
            boolean foundDiff = false;
            int value = s.charAt(i);
            int j = i + 1;
            while (!foundDiff && j < i + k) {
                if (s.charAt(j) != value)
                    foundDiff = true;
                else
                    j++;
            }
            if (!foundDiff)
                repeated = true;
            else
                i++;
        }
        return repeated;
    }

    //opg 7
    public static int searchSum(int[] t, int total) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < t.length - 1) {
            boolean found = false;
            int j = 0;
            int sum = 0;
            while (!found && j < t.length - i) {
                sum += t[i + j];
                if (sum == total)
                    found = true;
                else
                    j++;
            }
            if (found)
                index = i;
            else
                i++;
        }
        return index;
    }
}

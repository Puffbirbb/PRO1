import java.util.ArrayList;
import java.util.Random;

public class threeAmigos {
    public static void main(String[] args) {
        Random r = new Random();
        int[] ints = r.ints(5000, 1, 10000).toArray();
        ArrayList<Integer> numbersBubble = new ArrayList<>();
        ArrayList<Integer> numbersSelection = new ArrayList<>();
        ArrayList<Integer> numbersInsertion = new ArrayList<>();
        for (int e : ints) {
            numbersBubble.add(e);
            numbersSelection.add(e);
            numbersInsertion.add(e);
        }
        StopWatch timer = new StopWatch();
        System.out.println(numbersBubble);
        System.out.println(numbersSelection);
        System.out.println(numbersInsertion);
        System.out.println("");

        timer.start();
        bubbleSort(numbersBubble);
        timer.stop();

        System.out.printf("[BUBBLESORT] Elapsed milliseconds:%8d%n", timer.getElapsedTime());
        System.out.println(numbersBubble);
        timer.reset();

        timer.start();
        selectionSort(numbersSelection);
        timer.stop();

        System.out.printf("[SELECTIONSORT] Elapsed milliseconds:%8d%n", timer.getElapsedTime());
        System.out.println(numbersSelection);
        timer.reset();

        timer.start();
        insertionSort(numbersInsertion);
        timer.stop();

        System.out.printf("[INSERTIONSORT] Elapsed milliseconds:%8d%n", timer.getElapsedTime());
        System.out.println(numbersInsertion);
        timer.reset();
    }

    public static void bubbleSort(ArrayList<Integer> al) {
        // `arr` has an unsorted part followed by a sorted part,
        // `i` is the index of the last number in the unsorted part
        for (int i = al.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (al.get(j) > al.get(j+1)) {
                    int temp = al.get(j);
                    al.set(j, al.get(j + 1));
                    al.set(j + 1, temp);
                }
            }
        }
    }

    public static void selectionSort(ArrayList<Integer> al) {
        // `arr` consists of a sorted part followed by an unsorted part
        // `i` is the index of the first number in the unsorted part
        for (int i = 0; i < al.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < al.size(); j++) {
                if (al.get(j) < al.get(indexOfMin)) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                int temp = al.get(i);
                al.set(i, al.get(indexOfMin));
                al.set(indexOfMin, temp);
            }
        }
    }

    public static void insertionSort(ArrayList<Integer> al) {
        // 'arr' consists of a sorted part followed by an unsorted part
        // 'i' is the index of the first number in the unsorted part
        for (int i = 1; i < al.size(); i++) {
            int temp = al.get(i);
            int j = i;
            while (j > 0 && temp < al.get(j-1)) {
                al.set(j, al.get(j-1));
                j--;
            }
            al.set(j,temp);
        }
    }
}

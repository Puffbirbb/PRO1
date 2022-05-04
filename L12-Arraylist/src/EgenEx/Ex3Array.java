package EgenEx;

import java.util.Arrays;

public class Ex3Array {
    public static void main(String[] args) {
        int[] a = {4, 6, 7, 2, 3};
        int[] b = {4, 6, 8, 2, 6};
        System.out.println(Arrays.toString(sumArrays(a, b)));
    }
    public static int[] sumArrays(int[] a, int[] b){
        int[] ab = new int[a.length];
        for (int i = 0; i < a.length; i++){
            ab[i] = a[i] + b[i];
        }
        return ab;
    }
}
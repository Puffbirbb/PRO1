package EgenEx;

public class Ex2Array {
    public static void main(String[] args) {
        int[] t = new int[]{4, 6, 7, 2, 3};
        System.out.println(sum(t));
    }
    public static int sum(int[] t){
        int sum = 0;
        for (int e : t){
            sum += e;
        }
        return sum;
    }
}
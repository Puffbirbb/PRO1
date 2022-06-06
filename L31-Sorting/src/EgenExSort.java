import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EgenExSort {
    public static void main(String[] args) {

        //opg 1
        ArrayList<String> Galaxies = new ArrayList<>(List.of("Milky Way", "Andromeda", "Cigar", "Sombrero", "NGC 1300"));
        System.out.println(Galaxies);
        bubbleSortArrayList(Galaxies);
        System.out.println(Galaxies);

        //opg 2
        Customer c1 = new Customer("Julie Schultz Knudsen", 20, "Female", 2_420_000);
        Customer c2 = new Customer("Gwion Matias Hvelplund-Cunnington", 21, "Male", 169_420_000);
        Customer c3 = new Customer("Anne Hvelplund", 43, "Female", 2_420_000);
        Customer c4 = new Customer("Kevin Cunnington", 50, "Male", 69_000_420);

        String[] customer = {c1.getName(), c2.getName(), c3.getName(), c4.getName()};
        System.out.println("\n"+Arrays.toString(customer));
        selectionSortArrayCustomer(customer);
        System.out.println(Arrays.toString(customer));

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        System.out.println(customers);
        selectionSortArrayListCustomer(customers);
        System.out.println(customers);

        //opg 3
        Customer cu1 = new Customer("Anne", 43, "Female", 2_420_000);
        Customer cu2 = new Customer("Gwion", 21, "Male", 169_420_000);
        Customer cu3 = new Customer("Julieeee", 20, "Female", 2_420_000);
        Customer cu4 = new Customer("Kevinn", 50, "Male", 69_000_420);

        String[] customer1 = {cu1.getName(), cu2.getName(), cu3.getName(), cu4.getName()};
        System.out.println("\n"+Arrays.toString(customer1));
        insertionSortArrayCustomer(customer1);
        System.out.println(Arrays.toString(customer1));

        ArrayList<Customer> customers1 = new ArrayList<>();
        customers1.add(cu1);
        customers1.add(cu2);
        customers1.add(cu3);
        customers1.add(cu4);
        System.out.println(customers1);
        insertionSortArrayListCustomer(customers1);
        System.out.println(customers1);
    }

    //opg 1
    public static void bubbleSortArrayList(ArrayList<String> al) {
        for (int i = al.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (al.get(j).length() > al.get(j + 1).length()) {
                    String temp = al.get(j);
                    al.set(j, al.get(j + 1));
                    al.set(j + 1, temp);
                }
            }
        }
    }

    //opg 2
    public static void selectionSortArrayCustomer(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].length() < arr[indexOfMin].length()) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                String temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
    }

    public static void selectionSortArrayListCustomer(ArrayList<Customer> al) {
        for (int i = 0; i < al.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < al.size(); j++) {
                if (al.get(j).getNetWorth() < al.get(indexOfMin).getNetWorth()) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                Customer temp = al.get(i);
                al.set(i, al.get(indexOfMin));
                al.set(indexOfMin, temp);
            }
        }
    }

    //opg 3
    public static void insertionSortArrayCustomer(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String temp = arr[i];
            int j = i;
            while (j > 0 && temp.length() < arr[j-1].length()) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void insertionSortArrayListCustomer(ArrayList<Customer> al) {
        for (int i = 1; i < al.size(); i++) {
            Customer temp = al.get(i);
            int j = i;
            while (j > 0 && temp.getAge() < al.get(j-1).getAge()) {
                al.set(j, al.get(j-1));
                j--;
            }
            al.set(j,temp);
        }
    }
}

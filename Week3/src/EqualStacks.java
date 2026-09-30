import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EqualStacks {

    public static int equalStacks(
            List<Integer> h1,
            List<Integer> h2,
            List<Integer> h3) {

        int tong1 = 0;
        int tong2 = 0;
        int tong3 = 0;

        for (int x : h1) {
            tong1 += x;
        }

        for (int x : h2) {
            tong2 += x;
        }

        for (int x : h3) {
            tong3 += x;
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (true) {

            if (tong1 == tong2 && tong2 == tong3) {
                return tong1;
            }

            if (tong1 >= tong2 && tong1 >= tong3) {
                tong1 -= h1.get(i);
                i++;
            }

            else if (tong2 >= tong1 && tong2 >= tong3) {
                tong2 -= h2.get(j);
                j++;
            }

            else {
                tong3 -= h3.get(k);
                k++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            h1.add(sc.nextInt());
        }

        for (int i = 0; i < n2; i++) {
            h2.add(sc.nextInt());
        }

        for (int i = 0; i < n3; i++) {
            h3.add(sc.nextInt());
        }

        int ketQua = equalStacks(h1, h2, h3);

        System.out.println(ketQua);

        sc.close();
    }
}
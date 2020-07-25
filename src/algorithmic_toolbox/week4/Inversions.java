package algorithmic_toolbox.week4;

import java.util.Scanner;

public class Inversions {
    private static long merge(int[] a, int[] b, int l, int ave, int r) {
        int i = l, j = ave, k = l;
        long inv_count = 0;
        while (i <= ave - 1 && j <= r) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                inv_count += ave - i;
                j++;
            }
            k++;
        }
        while (i <= ave - 1) {
            b[k] = a[i];
            i++;
            k++;
        }
        while (j <= r) {
            b[k] = a[j];
            j++;
            k++;
        }
        for (i = l; i <= r; i++) {
            a[i] = b[i];
        }
        return inv_count;
    }

    private static long countInversions(int[] a, int[] b, int l, int r) {
        long inv_count = 0;
        if (r <= l) {
            return inv_count;
        }
        int ave = l + (r - l) / 2;
        inv_count += countInversions(a, b, l, ave);
        inv_count += countInversions(a, b, ave + 1, r);
        inv_count += merge(a, b, l, ave + 1, r);
        return inv_count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int[] b=new int[n];
        System.out.println(countInversions(a, b, 0, a.length-1));
    }
}
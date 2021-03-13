/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eigen;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Quicksort {

    public static int[] arr;

    public static int[] sort(int l, int r) {
        int q;
        if (l < r) {
            q = partition(l, r);
            sort(l, q);
            sort(q + 1, r);
        }
        return arr;
    }

    static int partition(int l, int r) {

        int i, j, x = arr[(l + r) / 2];
        i = l - 1;
        j = r + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < x);

            do {
                j--;
            } while (arr[j] > x);

            if (i < j) {
                int k = arr[i];
                arr[i] = arr[j];
                arr[j] = k;
            } else {
                return j;
            }
        }
    }

    public static void main(String[] args) {

        Scanner ein = new Scanner(System.in);
        Random zufall = new Random();
        System.out.println("Quicksort");
        System.out.println("----------");
        System.out.print("Anzahl an Werten für Array's (ganze Zahl): ");
        int arrlength = ein.nextInt();
        System.out.println("");
        arr = new int[arrlength];

        System.out.print("Werte: ");
        System.out.println("");
        for (int i = 0; i < arrlength; i++) {
            arr[i] = zufall.nextInt((99 - 1) + 1) + 1;
            System.out.print(arr[i] + " ");
        }

        int[] sort_arr = sort(0, arrlength - 1);

        System.out.println("");
        System.out.println("Sortiert: ");
        for (int i = 0; i < arrlength; i++) {
            System.out.print(sort_arr[i] + " ");
        }
    }
}

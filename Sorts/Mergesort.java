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
public class Mergesort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ein = new Scanner(System.in);
        Random zufall = new Random();
        Random zufallChar = new Random();
        System.out.println("Mergesort");
        System.out.println("----------");
        System.out.print("Anzahl an Werten für Array's (ganze Zahl): ");
        int arrlength = ein.nextInt();
        int[] arrchar = new int[arrlength];
        int[] arr = new int[arrlength];

        for (int i = 0; i < arrlength; i++) {
            arrchar[i] = (zufallChar.nextInt((122 - 97) + 1) + 97);
            arr[i] = zufall.nextInt((9 - 1) + 1) + 1;
        }
        System.out.println("Char Array: ");
        for (int i = 0; i < arrlength; i++) {
            System.out.print((char) arrchar[i] + " ");
        }
        System.out.println("");
        System.out.println("Int Array: ");
        for (int i = 0; i < arrlength; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Verarbeiten nach Mergesort");
        System.out.println("--------------------------");
        System.out.println("Char Array: ");
        for (int x : merge_sort(arrchar)) {
            System.out.print((char) x + " ");
        }
        System.out.println("");
        System.out.println("Int Array: ");
        for (int x : merge_sort(arr)) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }

    public static int[] merge_sort(int[] a) {
        if (a.length > 1) {
            int mitte = (int) (a.length / 2);
            int[] l = new int[mitte];
            for (int i = 0; i <= mitte - 1; i++) {
                l[i] = a[i];
            }

            int[] r = new int[a.length - mitte];
            for (int i = mitte; i <= a.length - 1; i++) {
                r[i - mitte] = a[i];
            }
            l = merge_sort(l);
            r = merge_sort(r);
            return verschmelze(l, r);
        } else {
            return a;
        }
    }

    private static int[] verschmelze(int[] l, int[] r) {
        int[] neul = new int[l.length + r.length];
        int indexl = 0;
        int indexr = 0;
        int indexergebnis = 0;
        while (indexl < l.length && indexr < r.length) {
            if (l[indexl] < r[indexr]) {
                neul[indexergebnis] = l[indexl];
                indexl += 1;
            } else {
                neul[indexergebnis] = r[indexr];
                indexr += 1;
            }
            indexergebnis += 1;
        }
        while (indexl < l.length) {
            neul[indexergebnis] = l[indexl];
            indexl += 1;
            indexergebnis += 1;
        }
        while (indexr < r.length) {
            neul[indexergebnis] = r[indexr];
            indexr += 1;
            indexergebnis += 1;
        }
        return neul;
    }

}

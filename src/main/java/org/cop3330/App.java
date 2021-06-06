/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Justin Parrondo
 */

package org.cop3330;

import java.util.Scanner;

// This special quicksort will return false if any duplicate is found
public class App {
    static boolean quicksort_recursive(int[] arr, int start, int end) {
        if (start >= end)
            return true;

        int j = end;
        int i;
        for (i = start + 1; i <= j; i++) {
            if (arr[i] > arr[start]) {
                while (j >= i && arr[j] >= arr[start]) {
                    if (i != j && arr[j] == arr[start])
                        return false;
                    j--;
                }
                if (j >= i) {
                    if (j != i && arr[j] == arr[i])
                        return false;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            } else if (arr[i] == arr[start]) {
                return false;
            }
        }
        int temp = arr[j];
        arr[j] = arr[start];
        arr[start] = temp;
        return quicksort_recursive(arr, start, j - 1) && quicksort_recursive(arr, j + 1, end);
    }

    static boolean quicksort(int[] arr) {
        return quicksort_recursive(arr, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[3];

        System.out.print("Enter the first number: ");
        nums[0] = in.nextInt();
        System.out.print("Enter the second number: ");
        nums[1] = in.nextInt();
        System.out.print("Enter the third number: ");
        nums[2] = in.nextInt();

        if (quicksort(nums)) {
            System.out.printf("The largest number is %d.\n", nums[2]);
        } else {
            System.out.println("Some numbers are duplicates!");
        }
    }
}

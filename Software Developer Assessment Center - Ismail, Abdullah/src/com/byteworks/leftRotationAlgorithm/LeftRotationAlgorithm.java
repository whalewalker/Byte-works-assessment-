package com.byteworks.leftRotationAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * A left rotation operation on an array shifts each of the array's elements 1 unit to the left. For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2]. Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.
 */
public class LeftRotationAlgorithm {

    /**
     * Rotates the elements of the given list to the left by a specified number of positions.
     * The rotation is performed in-place and modifies the original list.
     *
     * @param a the list to rotate
     * @param d the number of positions to rotate the elements to the left
     * @return the rotated list
     */
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        if (a.isEmpty()) return new ArrayList<>();
        if (d == 0) return a;

        int n = a.size();
        d %= n;

        reverse(a, 0, d - 1);
        reverse(a, d, n - 1);
        reverse(a, 0, n - 1);

        return a;
    }

    /**
     * Reverses the elements of the specified list between the start and end indices (inclusive).
     *
     * @param a     the list to reverse
     * @param start the index of the first element to be reversed
     * @param end   the index of the last element to be reversed
     */
    private static void reverse(List<Integer> a, int start, int end) {
        while (start < end) {
            int temp = a.get(start);
            a.set(start, a.get(end));
            a.set(end, temp);
            start++;
            end--;
        }
    }

}

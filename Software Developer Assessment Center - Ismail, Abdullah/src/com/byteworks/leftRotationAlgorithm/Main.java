package com.byteworks.leftRotationAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example usage of rotLeft method
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int rotation = 2;
        List<Integer> rotatedList = LeftRotationAlgorithm.rotLeft(list, rotation);
        System.out.println("Original List: " + List.of(1, 2, 3,4,5));
        System.out.println("Rotated List: " + rotatedList);
    }
}

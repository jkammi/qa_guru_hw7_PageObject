package com.demoqa.utils;

import com.demoqa.tests.FakeData;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandonString(10));
    }

    static FakeData fakeData = new FakeData();

    public static String getRandonString(int length) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();

    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }

    public static String[] getRandomItemListFromArray(String[] arr) {
        Random rand = new Random();
        int n = rand.nextInt(arr.length + 1); // generate a random number between 0 and the length of the array
        HashSet<String> set = new HashSet<String>();
        while (set.size() < n) {
            int index = rand.nextInt(arr.length); // generate a random index to select an element from the original array
            set.add(arr[index]);
        }
        String[] subset = set.toArray(new String[0]);
        return subset;
    }

}

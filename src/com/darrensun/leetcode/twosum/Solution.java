package com.darrensun.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode - Two Sum
 * Created by Darren on 14-7-28.
 * O(n) time and O(n) space, assuming O(1) average time for the containsKey() method of HashMap.
 * Use a hash table to keep track of numbers desired to appear and the indices of corresponding
 * earlier numbers. That is, if k is a key in the hash table t given an array a, k+a[t[k]] = sum.
 * For each number a[i], if a[i] is already a key of the hash table,
 * that means a[i]+a[t[a[i]]]=sum and we have found the solution (t[a[i]],i).
 * Otherwise, we add an item to the hash table using sum-a[i] as the key and i as the value.
 * In case a pair of numbers, instead of their indices, are what the problem asks for,
 * we can adapt this solution to a set-based one with the same complexities,
 * or implement a new one based on sorting, with O(n*logn) time and O(1) space.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2)
            return null;

        int[] result = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(numbers[i])) {  // Encounter a desired number
                result[0] = hashMap.get(numbers[i]);
                result[1] = i+1;    // 1-based indexing
                break;
            } else {    // Put the desired number w.r.t. numbers[i] into the hash table
                hashMap.put(target-numbers[i], i+1);    // 1-based indexing
            }
        }
        return result;
    }
}
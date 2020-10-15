package com.neo.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * create by xiaocai on 2020/10/12 16:00
 **/
public class RemoveDuplicates {
    private static int[] arrays = new int[]{0,0,1,1,1,2,2,3,3,4};
    public static void main(String[] args) {
        System.out.println("myMap "+myMap(arrays));
        System.out.println("myRemoveDuplicates "+myRemoveDuplicates(arrays));
        System.out.println("removeDuplicates "+removeDuplicates(arrays));
        System.out.println("aa "+aa(arrays));

    }

    public static int myMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<nums.length;i++){
            map.put(nums[i],nums[i]);
        }
        return map.size();
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int myRemoveDuplicates(int[] nums){
        if (nums.length==0) return 0;
        int i=0;
        for (int j=1;j<nums.length;j++){
            if (nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static int aa(int[] nums){
        if (nums.length==0) return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if (nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.dslab1;

/**
 *
 * @author Dell
 */
public class Task1 {
    public static void main(String[] args){
        // A program to print all the elements of Array index wise:s
        int[] nums={5,15,25,35,45,55};
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+ " ");
    }
        System.out.println(" ");
        
        System.out.println("Element at index 0: " + (nums[0]));
        System.out.println("Element at index 1: " + (nums[1]));
        System.out.println("Element at index 2: " + (nums[2]));
        System.out.println("Element at index 3: " + (nums[3]));
        System.out.println("Element at index 4: " + (nums[4]));
        System.out.println("Element at index 5: " + (nums[5]));
    }
}

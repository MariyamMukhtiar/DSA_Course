/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.dslab1;

import java.util.Arrays;

/**
 *
 * @author Dell
 */
public class Task4 {
    public static void main(String[] args){
        // A program to do different searching:
        
        // Search for an element by its index.
        int[] Arr={13,26,39,52,65};
        int Index=4;
        int Element=Arr[Index];
        System.out.println("Element at index " + Index + " : " + Element);
        
        
        // Implement linear search to find an element by its value.
        int[]Arr2={4,6,2,8,10};
        int Lin_Target=8;
        boolean found=false;
        for(int i=0; i<Arr2.length; i++){
            if(Arr2[i]==Lin_Target){
                System.out.println("Element " + Lin_Target + " found at index " + i);
                found=true;
                break;
            }
        }
        //  Implement binary search on a sorted array.
        int[] Arr3={11,22,33,44,55};
        int Bin_Target=33;
        Arrays.sort(Arr3);
        int left=0;
        int right = Arr3.length-1;
        int middle;
        boolean bool=false;
        while(left<=right){
           middle=left+(right-left)/2;
           if(Arr3[middle]==Bin_Target){
               System.out.println("Element "+Bin_Target +" found at index "+middle);
               bool=true;
               break;
           }
           if(Arr3[middle]<Bin_Target){
             left=middle+1;  
           }else{
               right=middle-1;
           }
        }
      }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.dslab1;
        
/**
 *
 * @author Dell
 */
public class Task5 {
        static int[] reverseArray(int[] arr){
        int[] reverse= new int[arr.length];
       for(int i=0;i<arr.length;i++){
           reverse[i]=arr[arr.length-1-i];
       }
       return reverse;
}
             public static void main(String[] args){
                 int[] arr={1,3,5,7,9};
                int[] reverse= reverseArray(arr);
                 System.out.println("The elements of reversed Array: ");
                 for(int i=0;i<arr.length;i++){
                     System.out.print( reverse[i]+ " ");
                 }
                 }}

       

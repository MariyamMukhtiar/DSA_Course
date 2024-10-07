/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techwebdocs.sortstrings;

/**
 *
 * @author Dell
 */
public class SortStrings {
// Sort a list of strings by length:
      public void SortString(String arr[]){
     for(int i=0; i<arr.length-1; i++){
     for(int j=0; j<arr.length-1; j++){
         if(arr[j].length()>arr[j+1].length()){
             String temp=arr[j];
             arr[j]=arr[j+1];
             arr[j+1]=temp;
         }
     }
     }
   }
    public static void main(String[] args) {
       SortStrings sort = new SortStrings();
       String[] arr = {"apple","pie","Banana","cat"};
        System.out.println("Original string unsorted elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
           }
        System.out.println("\n");
        sort.SortString(arr);
        System.out.println("Original string sorted elements of array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" "); 
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techwebdocs.earlystopbubblesort;

/**
 *
 * @author Dell
 */
public class EarlyStopBubbleSort {
   //Impelement optimized bubble sort with early stopping:
 public void EarlyStopBubbleSort(int[] arr){
     boolean swapped=false;
     for(int i=0; i<arr.length-1; i++){
     for(int j=0; j<arr.length-1; j++){
         if(arr[j]>arr[j+1]){
             int temp=arr[j];
             arr[j]=arr[j+1];
             arr[j+1]=temp;
             swapped=true;
         }
     }
     if(!swapped){
         break;
     }
     }
   } 
    public static void main(String[] args) {
      EarlyStopBubbleSort sort = new EarlyStopBubbleSort();
      int[] arr= {50,45,55,60,65,70};
        System.out.println("UnSorted Array Elements: ");
      for(int i=0; i<arr.length; i++){
          System.out.print(arr[i]+" ");  
      }
       System.out.println("\n");
        System.out.println("Sorted Array Elements: ");
        sort.EarlyStopBubbleSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

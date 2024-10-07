/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techwebdocs.bubblesort;

/**
 *
 * @author Dell
 */
import java.util.Scanner;
public class BubbleSort{
  //Implement bubble sort algorithm and sorting elements of array in ascending order: 
    //Bubble sort Method:
    public void BubbleSort(int[] arr){
     for(int i=0; i<arr.length-1; i++){
     for(int j=0; j<arr.length-1; j++){
         if(arr[j]>arr[j+1]){
             int temp=arr[j];
             arr[j]=arr[j+1];
             arr[j+1]=temp;
         }
     }
     }
   } 
    public static void main(String[] args) {
       Scanner s1= new Scanner(System.in);
   BubbleSort sort = new BubbleSort();
        System.out.println("Enter an array size: ");
        int size = s1.nextInt();
        
        int[] arr = new int [size];
        System.out.println("Enter the elements of an array: ");
        for(int i=0; i<arr.length; i++){
            arr[i]= s1.nextInt();
        }
        sort.BubbleSort(arr);
        System.out.println("Elements of an array: ");
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+" ");  
        }
    }
    }

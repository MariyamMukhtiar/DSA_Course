/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.dslab1;

/**
 *
 * @author Dell
 */
public class Task2 {
    public static void main(String[] args){
        // A program to do insertions on different positions:
        int[] Arr=new int[6];
        Arr[0]=12;
        Arr[1]=24;
        Arr[2]=36;
        Arr[3]=48;
        Arr[4]=60;
         // Insert an element at the start of the array
        System.out.println("Array before start insertion");
        for(int i=0; i<Arr.length; i++){
            System.out.print(Arr[i] + " ");
        }
        System.out.println(" ");
        int newElement=6;
        for(int i=Arr.length-1; i>0; i--){
            Arr[i]=Arr[i-1];
        }
        Arr[0]=newElement;
        System.out.println("Array after start insertion");
        for(int i=0; i<Arr.length; i++){
            System.out.print(Arr[i] + " ");
        }
        System.out.println(" ");
        
        int[] Arr1=new int[6];
        Arr1[0]=100;
        Arr1[1]=200;
        Arr1[2]=300;
        Arr1[3]=400;
        Arr1[4]=500;
        // Insert an element in the middle of the array.
        System.out.println("Array before middle insertion");
        for(int i=0; i<Arr1.length; i++){
            System.out.print(Arr1[i] + " ");
        }
        System.out.println(" ");
        int newPos=2;
        int Element=250;
        for(int i=Arr1.length-1; i>newPos; i--){
            Arr1[i]=Arr1[i-1];     
                    }
        Arr1[newPos]=Element;
        System.out.println("Array after middle insertion");
        for(int i=0; i<Arr1.length; i++){
            System.out.print(Arr1[i] + " ");
        }
        System.out.println(" ");
        
        int[] Arr2=new int[6];
        Arr2[0]=3;
        Arr2[1]=6;
        Arr2[2]=9;
        Arr2[3]=12;
        Arr2[4]=15;
        // Insert an element at the end of the array.
        System.out.println("Array before end insertion");
        for(int i=0; i<Arr2.length; i++){
            System.out.print(Arr2[i] + " ");
        }
        System.out.println(" ");
        Arr2[Arr2.length-1]=18;
        System.out.println("Array after end insertion");
        for(int i=0; i<Arr2.length; i++){
            System.out.print(Arr2[i]+ " ");
        }
    }
}

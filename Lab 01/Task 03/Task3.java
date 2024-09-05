/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.dslab1;

/**
 *
 * @author Dell
 */
public class Task3 {
    public static void main(String[] args){
        // A program to Delete an element from a specific position:
        int[] Arrdel={8,16,24,32,40};
        int DeleteIndex=2;
        System.out.println("Array before deletion");
        for(int i=0; i<Arrdel.length; i++){
            System.out.print(Arrdel[i] + " ");
        }
        System.out.println(" ");
        
        for(int i=DeleteIndex; i<Arrdel.length-1; i++){
            Arrdel[i]=Arrdel[i+1];
        }
       Arrdel[Arrdel.length-1]=0;
        System.out.println("Array after deletion");
        for(int i=0; i<Arrdel.length; i++){
            System.out.print(Arrdel[i]+ " ");
        }
    }
}

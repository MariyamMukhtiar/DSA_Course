/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.dslab1;

/**
 *
 * @author Dell
 */
public class Task6 {
    static boolean palindrome(String word){
     int left=0;
       int right=word.length()-1;
        while(left<=right){
    if(word.charAt(right)!= word.charAt(left)){
    return false;}
             left++;
     right--;
    }return true;
}
             public static void main(String[] args){
           String str="radar";
                if(palindrome(str)){
                    System.out.println("This is a Palindorme");}
                else{
                    System.out.println("This is not a Palindrome");}
                 
                 }}

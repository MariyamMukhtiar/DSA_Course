/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.dsalab5;

/**
 *
 * @author Dell
 */
public class StackArray {
    //Part1: Implementation of stack using an Array:
    private int[] array;
    private int top;
    private int maxsize;
    public StackArray(int size){
       array = new int[size]; 
       top=-1;
       maxsize=size;
    }
    //Push Method:
    public void Push(int data){
        if(top==maxsize-1){
            System.out.println("stack overflow");
                return;
        }
        array[++top]=data;
    }
    //Pop Method:
    public int pop(){
        if(top==-1){
            System.out.println("stack overflow");
            return -1;
        }
        return array [top--];
    }
    //Peek Method:
    public int Peek(){
        if(top==-1){
            System.out.println("stack is empty");
            return -1;
        }
        return array [top];
    }
    //IsEmpty Method:
    public boolean IsEmpty(){
       return top== -1; 
    }
    //IsFull Method:
    public boolean IsFull(){
        return top==maxsize-1;
    }
    //get stack size:
    public int Size(){
        return top+1;
    }
    //print stack:
    public void PrintStack(){
        for(int i=0; i<=top; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        StackArray stack=new StackArray(5);
        System.out.println("stack empty: "+stack.IsEmpty());
        stack.Push(10);
        stack.Push(20);
        stack.Push(30);
        System.out.println("Print elements of stack before pop");
        stack.PrintStack();
        System.out.println("stack top value :"+stack.Peek());
        System.out.println("stack size: "+stack.Size());
        System.out.println("Deleted element of stack: "+stack.pop());
        System.out.println("stack empty: "+stack.IsEmpty());
        System.out.println("stack size: "+stack.Size());
        System.out.println("Print elements of stack after pop");
        stack.PrintStack();
    }
}

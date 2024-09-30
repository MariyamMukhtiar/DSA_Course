/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.dsalab5;

/**
 *
 * @author Dell
 */
public class StackLinkedList {
    //Part2: Implementation of stack using linkedlist:
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private Node top;
    private int size;
    StackLinkedList(){
     top = null;   
    }
    //Push Method:
    public void Push(int data){
        Node newnode = new Node(data);
        if(top==null){
            top=newnode;
            return;
        }
        newnode.next=top;
        top=newnode;
        size++;
    }
    //Pop Method;
    public int Pop(){
      int pop_data=top.data;
      top=top.next;
      size--;
      return pop_data;
    }
    //Peek Method:
    public void Peek(){
        System.out.println(top.data);
    }
    //Is Empty Method:
    public boolean IsEmpty(){
        return top==null;
    }
    //Get stack size
    public int Size(){
        return size;
    }
    
    public static void main(String args[]){
     StackLinkedList stack=new StackLinkedList();
        System.out.println("stack empty: "+stack.IsEmpty());
     stack.Push(10);
     stack.Push(20);
        System.out.println("Deleted element of stack: "+stack.Pop());
        stack.Peek();
        stack.Push(20);
        stack.Push(30);
        stack.Push(40);
        System.out.println("Stack size: "+stack.Size());
        System.out.println("Deleted element of stack: "+stack.Pop());
        stack.Peek();
        System.out.println("Stack empty: "+stack.IsEmpty());
        System.out.println("stack size:"+stack.Size());
    }
}

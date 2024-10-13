/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.queuedatastructure;

/**
 *
 * @author Dell
 */
public class ArrayQueue {
    private int[] Array;
    private int Front;
    private int Rear;
    private int Maxsize;
    public ArrayQueue(int size){
        Array = new int[size]; 
       Front=-1;
       Maxsize=size;
    }
    public void Enqueue(int data){
        if(Rear==Maxsize-1){
            System.out.println("Queue is empty");
        }
        Array[++Rear]=data;
        System.out.println("Enqueued: "+data);
    }
    public int Dequeue(){
        if(Front==-1){
           // System.out.println("Queue is empty")
           return -1;
}
           else{
               return Array[--Front];        
                   }
    }
        // Peek operation
    public int peek() {
        int size=0;
        if (size == 0) {
            System.out.println("Queue is empty");
           // or throw an exception
        }
        return Array[Front];
    }

    public static void main(String[] args){
      ArrayQueue queue = new ArrayQueue(5);
      queue.Enqueue(10);
      queue.Enqueue(20);
      queue.Enqueue(30);
      queue.Enqueue(40);
        System.out.println("Dequeue element: "+queue.Dequeue() );
        System.out.println("Peek element: "+queue.peek());
    }
}

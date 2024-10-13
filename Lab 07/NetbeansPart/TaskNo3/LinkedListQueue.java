/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.queuedatastructure;

/**
 *
 * @author Dell
 */
public class LinkedListQueue {
    public class Node{
       int data;
       Node next;
       public Node(int data){
           this.data=data;
           this.next=null;
       }
   }
   private Node Front;
   private Node Rear;
    LinkedListQueue(){
       this.Front=null;
       this.Rear=null;
   }
   public void Enqueue(int data){
     Node newNode = new Node(data);
     if(Rear==null){
         Front=Rear=newNode;
         return;
     }
     Rear.next=newNode;
       System.out.println("Enqueued:"+data);
   }
   public int Dequeue(){
       if(Front==null){
           System.out.println("Queue is empty");
           Front=Rear=null;
           return -1;
       }
       int value=Front.data;
       Front=Front.next;
       return value;
   }
       // Peek operation
    public int peek() {
        if (Front == null) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        return Front.data;
    }

    public static void main(String args[]){
      LinkedListQueue queue = new LinkedListQueue();
       queue.Enqueue(10);
       queue.Enqueue(20);
       queue.Enqueue(30);
        System.out.println("Dequeue element: "+queue.Dequeue());
        System.out.println("Front element: "+queue.peek());
    }
}

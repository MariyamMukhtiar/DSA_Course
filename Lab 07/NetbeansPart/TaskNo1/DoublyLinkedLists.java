/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techwebdocs.doublylinkedlists;

/**
 *
 * @author Dell
 */
public class DoublyLinkedLists {
public class Node{
    int data;
    Node next;
    Node previous;
    public Node(int data){
        this.data=data;
        this.next=null;
        this.previous=null;
    }
}
   private Node head;
   private Node tail;
   public DoublyLinkedLists(){
       this.head=null;
       this.tail=null;
   }
   //Insertion at start:
   public void InsertionAtStart(int data){
    Node newNode = new Node(data);
    if(head==null){
        head=tail=newNode;
    }
    else{
        newNode.next=head;
        head.previous=newNode;
        head=newNode;
    }
   }
   //Insertion at position:
   public void InsertionAtPosition(int data,int position){
     Node newNode = new Node(data);
     if(head==null){
         head=tail=newNode;
     }
  else {
            Node current = head;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous.next = newNode;
            current.previous = newNode;
        }
    }

   //Insertion at end:
   public void InsertionAtEnd(int data){
    Node newNode = new Node(data);
    if(head==null){
        head=tail=null;
    }
    else{
        tail.next=newNode;
        newNode.previous=tail;
        tail=newNode;
    }
   }
   //Display from start:
   public void DisplayFromStart(){
       Node current=head;
       while(current!=null){
           System.out.print(current.data+"->");
           current=current.next;
       }
       System.out.println("null");
   }
   //Display from end
     public void DisplayFromEnd(){
       Node Current = tail;
       while(Current!=null){
           System.out.print(Current.data+"->");
           Current=Current.previous;
       }
         System.out.println("null");
     }
      //Delete from start
     public void DeleteFromStart(){
       if(head==null){
           System.out.println("The list is empty");
       }
       else{
           head=head.next;
       }
     }
     //Delete from position:
     public void DeleteByPosition(){
         
     }
     //Delete from end
     public void DeletefromEnd(){
        if(head==null){ 
            System.out.println("The list is empty");
        } 
        else{
           Node current=head;
           while(current.next.next!=null){
               current=current.next;
           }
           current.next=null;
        }
     }
     //Delete by value
     public void DeleteByValue(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current.previous != null) {
                    current.previous.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    tail = current.previous;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Value not found");
    }
    // Search Operation
    public void SearchByValue(int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Value found at position: " + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Value not found");
    }
     //reverse method
      public void ReverseList(){
        Node Current = tail;
       while(Current!=null){
           System.out.print(Current.data+"->");
           Current=Current.previous;
       }
         System.out.println("null");
     }

      //count nodes:
     public int CountNodes(){
         int count=0;
         Node current=head;
         while(current!=null){
             count++;
             current=current.next;
         }
         return count;
     }
     public int Size(){
         int size=0;
         Node current=head;
         while(current!=null){
             size++;
             current=current.next;
         }
         return size;
     }
    public static void main(String[] args) {
      DoublyLinkedLists list = new DoublyLinkedLists();  
     list.InsertionAtStart(20);
     list.InsertionAtEnd(40);
     list.InsertionAtEnd(50);
     list.InsertionAtEnd(60);
     list.InsertionAtEnd(70);
     list.InsertionAtEnd(80);
     list.InsertionAtEnd(90);
     list.InsertionAtEnd(100);
     list.InsertionAtStart(10);
      System.out.println("Display from start");
     list.DisplayFromStart();
      System.out.println("Display from end");
      list.DisplayFromEnd();
        System.out.println("Display after insertion from position");
        list.InsertionAtPosition(30, 2);
        list.DisplayFromStart();
         System.out.println("Reverse display");
        list.ReverseList();
      list.DeleteFromStart();
      System.out.println("Display after delete from start");
      list.DisplayFromStart();
      System.out.println("Display after delete from end");
      list.DeletefromEnd();
      list.DisplayFromStart();
        System.out.println("Display after delete by value");
        list.DeleteByValue(50);
        list.DisplayFromStart();
        list.SearchByValue(60);
        System.out.println("Reverse display");
        list.ReverseList();
        System.out.println("Count nodes: "+list.CountNodes());
         System.out.println("Size: "+list.Size());
    }
}

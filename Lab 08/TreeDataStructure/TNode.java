/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.tree;

/**
 *
 * @author Dell
 */
public class TNode {
     String data;
    TNode[] children;
    int childcount;
    TNode(String value, int Treesize){
        this.data=value;
          this.children= new TNode[Treesize]; 
          this.childcount=0;
    }
 public void Addchild(TNode child){
 if(childcount<children.length){
     children[childcount++] = child;
     System.out.println(child.data+ " have been added ");
 }else{
     System.out.println("Node is already filled");
 }
  }
    
 public void DisplayNode(TNode node, int level){
    if(node==null){
        System.out.println("Tree is empty");
        return;
    } 
     System.out.println( " ".repeat(level*2)+node.data);
     for(int i=0; i<node.childcount; i++){
         DisplayNode(node.children[i],level+1);
     }
 }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techwebdocs.tree;

/**
 *
 * @author Dell
 */
public class Tree {

TNode root;

public Tree(String value, int Totalchild){
    root=new TNode(value, Totalchild);
    System.out.println("Node " + value + " have been created");
}
    public static void main(String[] args){
     Tree tree = new Tree("A", 2);
     TNode B = new TNode("B",3);
     TNode C = new TNode("C",2);
     tree.root.Addchild(B);
     tree.root.Addchild(C);
     tree.root.DisplayNode(B,3);
     tree.root.DisplayNode(C, 2);
     }
}
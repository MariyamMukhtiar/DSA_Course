/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techwebdocs.binarysearchtree;

/**
 *
 * @author Dell
 */
import java.util.LinkedList;
import java.util.Queue;
class BTNode{
    //Btnode class
    int data;
    BTNode right;
    BTNode left;

  BTNode(int data){
   this.data=data;
   right = null;
   left = null;
}
}


public class BinarySearchTree {
    //Binary Search Tree class
    BTNode root;
    
    BinarySearchTree(){
        root = null;
    }
    
  // Insert method to add a node into the tree
    public void Insert(int data) {
        root = InsertRec(root, data);
    }

    // Recursive helper function to insert a new node
    private BTNode InsertRec(BTNode root, int data) {
        if (root == null) {
         root = new BTNode(data);
        }

        if (data < root.data) {
            root.left = InsertRec(root.left, data);
        } else if (data > root.data) {
            root.right = InsertRec(root.right, data);
        }

        return root;
    }

    // Method to traverse the tree in-order (left-root-right)
    public void InorderTraversal() {
        InorderTraversalRec(root);
        System.out.println();
    }

    // Recursive helper function for in-order traversal
    private void InorderTraversalRec(BTNode root) {
        if (root != null) {
            InorderTraversalRec(root.left);
            System.out.print(root.data + " ");
            InorderTraversalRec(root.right);
        }
    }
    
    // Pre-order traversal (root, left, right)
    public void PreorderTraversal() {
        PreorderRec(root);
        System.out.println();
    }

    private void PreorderRec(BTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            PreorderRec(root.left);
            PreorderRec(root.right);
        }
    }
    
    // Post-order traversal (left, right, root)
    public void PostorderTraversal() {
        PostorderRec(root);
        System.out.println();
    }

    private void PostorderRec(BTNode root) {
        if (root != null) {
            PostorderRec(root.left);
            PostorderRec(root.right);
            System.out.print(root.data+ " ");
        }
    }

    // Level-order traversal (breadth-first) using a queue
    // Level-order traversal: Level by level from left to right
    public void LevelOrderTraversal() {
        if (root == null) return;

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BTNode current = queue.poll();
            System.out.print(current.data + " ");

            // Enqueue the left child
            if (current.left != null) {
                queue.add(current.left);
            }

            // Enqueue the right child
            if (current.right != null) {
                queue.add(current.right);
            }
    }
        System.out.println("");
    }

     // Search method to check if a value exists in the tree
    public boolean Search(int data) {
       return SearchRec(root, data);
    }

    // Recursive helper function to search for a value
    private boolean SearchRec(BTNode root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        }

           return data < root.data
            ? SearchRec(root.left, data)
            : SearchRec(root.right, data);
    }
   
    // Method to count the total number of nodes in the tree
    public int CountNodes() {
        return CountNodesRec(root);
    }

    // Recursive helper function to count the nodes
    private int CountNodesRec(BTNode root) {
   // Base case: If the current node is null, return 0
        if (root == null) {
            return 0;
        }

  // Recursive case: Count the current node and add the count of left and right subtrees
        return 1 + CountNodesRec(root.left) + CountNodesRec(root.right);
    }
   
   
    public static void main(String[] args) {
     BinarySearchTree bst = new BinarySearchTree();
      // Insert values into the BST
        bst.Insert(50);
        bst.Insert(30);
        bst.Insert(20);
        bst.Insert(40);
        bst.Insert(70);
        bst.Insert(60);
        bst.Insert(80);
         // In-order traversal
        System.out.println("In-order traversal:");
        bst.InorderTraversal();
        // Pre-order traversal
        System.out.println("Pre-order traversal:");
        bst.PreorderTraversal();   
        // Post-order traversal
        System.out.println("Post-order traversal:");
        bst.PostorderTraversal();
        // Level-order traversal
        System.out.println("Level-order traversal:");
        bst.LevelOrderTraversal();
        
        // Search for a value
        System.out.println("Search for 40: " + bst.Search(40)); 
        System.out.println("Search for 100: " + bst.Search(100));  

        // Count the number of nodes
        int nodeCount = bst.CountNodes();
        System.out.println("Total number of nodes in the tree: " + nodeCount);  
    }
}

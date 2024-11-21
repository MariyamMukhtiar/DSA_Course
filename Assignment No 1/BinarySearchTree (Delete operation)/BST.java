/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */class BTNode{
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
public class BST {
     BTNode root;

    // Constructor
    public BST() {
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
    
    
    // Public method to delete a node
    public void Delete(int key) {
        root = DeleteRec(root, key);
    }

    // Recursive delete method
    private BTNode DeleteRec(BTNode root, int key) {
        // Base case: If the tree is empty
        if (root == null) {
            return root;
        }
        //Case 1: If the deleted node is leaf node just directly delete it
        // Find the node to delete
        if (key < root.data) {
            root.left = DeleteRec(root.left, key); // If the key is smaller, go left
        } else if (key > root.data) {
            root.right = DeleteRec(root.right, key); // If the key is greater, go right
        } else {
            // If key is the same as root's data, then this is the node to be deleted
            // Case 2: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node with two children
            // Get the inorder successor (smallest in the right subtree)
            root.data = MinValue(root.right);

            // Delete the inorder successor
            root.right = DeleteRec(root.right, root.data);
        }

        return root;
    }

    // Helper function to find the smallest node in a given tree
    private int MinValue(BTNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Utility function to perform inorder traversal
    public void Inorder() {
        InorderRec(root);
    }

    // Recursive inorder traversal
    private void InorderRec(BTNode root) {
        if (root != null) {
            InorderRec(root.left);
            System.out.print(root.data + " ");
            InorderRec(root.right);
        }
    }

    // Main method to test the BinarySearchTree class
    public static void main(String[] args) {
        BST bst = new BST();

        // Insert nodes to create the tree
        bst.Insert(50);
        bst.Insert(30);
        bst.Insert(20);
        bst.Insert(40);
        bst.Insert(70);
        bst.Insert(60);
        bst.Insert(80);
        System.out.println("Inorder traversal of the tree:");
        bst.Inorder(); // Output: 20 30 40 50 60 70 80

        System.out.println("\nDelete 20:");
        bst.Delete(20); // Deleting a leaf node
        bst.Inorder(); // Output: 30 40 50 60 70 80
        
        System.out.println("\nDelete 30:");
        bst.Delete(30); // Deleting a node with one child
        bst.Inorder(); // Output: 40 50 60 70 80

        System.out.println("\nDelete 50:");
        bst.Delete(50); // Deleting a node with two children
        bst.Inorder(); // Output: 40 60 70 80
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techwebdocs.binarytreedatastructure;

/**
 *
 * @author Dell
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
public class BinaryTree {

    // Root of the binary tree
     Node root;

    public BinaryTree() {
        root = null;
    }

    // Insert a node into the tree (Iterative)
    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (key < current.data) {
                current = current.left;
            } else if (key > current.data) {
                current = current.right;
            } else {
                return; // Duplicate values are not allowed
            }
        }

        if (key < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }
      // Traverse tree
  public void TraverseTree(Node node) {
    if (node != null) {
      TraverseTree(node.left);
      System.out.print(" " + node.data);
      TraverseTree(node.right);
    }
  }
      // Method to count nodes in the binary tree
    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        // Stack to simulate the DFS traversal
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        int count = 0;

        // Process nodes in a depth-first manner
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            count++;

            // Push right child to the stack if it exists
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            // Push left child to the stack if it exists
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }

        
        return count;
    }

   public void levelOrder() {
    if (root == null) {
        return;
    }

    // Create an empty queue for level order traversal
    java.util.Queue<Node> queue = new java.util.LinkedList<>();

    // Enqueue the root node
    queue.add(root);

    // Loop until the queue is empty
    while (!queue.isEmpty()) {
        // Dequeue a node from the queue and print its data
        Node current = queue.poll();
        System.out.print(current.data + " ");

        // If the left child exists, enqueue it
        if (current.left != null) {
            queue.add(current.left);
        }

        // If the right child exists, enqueue it
        if (current.right != null) {
            queue.add(current.right);
        }
    }
}

    // In-order Traversal (Iterative)
    public void inorder() {
        if (root == null) return;

        Node current = root;
        java.util.Stack<Node> stack = new java.util.Stack<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    // Pre-order Traversal (Iterative)
    public void preorder() {
        if (root == null) return;

        java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            // Push right child first, so left child is processed first
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // Post-order Traversal (Iterative)
    public void postorder() {
        if (root == null) return;

        java.util.Stack<Node> stack1 = new java.util.Stack<>();
        java.util.Stack<Node> stack2 = new java.util.Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
     // Traversals
         // create nodes of the tree
    tree.root = new Node(20);
    tree.root.left = new Node(30);
    tree.root.right = new Node(40);
    tree.root.left.left = new Node(50);
    System.out.print("\nBinary Tree: ");
    tree.TraverseTree(tree.root);
    System.out.println("\nTraversing of nodes with different types:");
     // Insert nodes
        tree.insert(60);
        tree.insert(70);
        tree.insert(80);
         // Level order traversal
    System.out.print("Level order traversal: ");
    tree.levelOrder();  // Expected output: 50 30 70 20 40 60 80
    System.out.println();
        System.out.print("In-order traversal: ");
        tree.inorder(); // Should print: 20 30 40 50 60 70 80
        System.out.println();

        System.out.print("Pre-order traversal: ");
        tree.preorder(); // Should print: 50 30 20 40 70 60 80
        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.postorder(); // Should print: 20 40 30 60 80 70 50
        System.out.println();
    // System.out.println("Number of nodes: " + tree.countNodes(root)); 
       
    }
}
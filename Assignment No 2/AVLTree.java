/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techwebdocs.avltree;

/**
 *
 * @author Dell
 */
  class Node {
    int key;
    Node left, right;
    int height;

    public Node(int key) {
        this.key = key;
        this.left = this.right = null;
        this.height = 1;  // Initially, height of node is 1
    }
}

public class AVLTree {
    private Node root;

    public AVLTree() {
        root = null;
    }

    // Get height of the node
    private int Height(Node node) {
        if (node == null) return 0;
        return node.height;
    }


// Get balance factor of the node
    private int GetBalance(Node node) {
        if (node == null) return 0;
        return Height(node.left) - Height(node.right);
    }

    // Right rotation
    private Node RightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(Height(y.left), Height(y.right)) + 1;
        x.height = Math.max(Height(x.left), Height(x.right)) + 1;

        return x;
    }

    // Left rotation
    private Node LeftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(Height(x.left), Height(x.right)) + 1;
        y.height = Math.max(Height(y.left), Height(y.right)) + 1;

        return y;
    }

    // Insert node into the tree
    public Node Insertrec(Node node, int key) {
        // Step 1: Perform normal BST insert
        if (node == null) return new Node(key);

        if (key < node.key) {
            node.left = Insertrec(node.left, key);
        } else if (key > node.key) {
            node.right = Insertrec(node.right, key);
        } else {
            return node;  // Duplicate keys are not allowed
        }

        // Step 2: Update the height of this node
        node.height = Math.max(Height(node.left), Height(node.right)) + 1;

        // Step 3: Get balance factor to check if this node became unbalanced
        int balance = GetBalance(node);

        // Step 4: If the node is unbalanced, perform rotations

        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return RightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return LeftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = LeftRotate(node.left);
            return RightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = RightRotate(node.right);
            return LeftRotate(node);
        }

        return node;
    }

    // Wrapper for insert function
    public void Insert(int key) {
        root = Insertrec(root, key);
    }

    // Search for a key in the tree
    public boolean Searchrec(Node node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.key) {
            return true;
        }

        if (key < node.key) {
            return Searchrec(node.left, key);
        } else {
            return Searchrec(node.right, key);
        }
    }

    // Wrapper for search function
    public boolean Search(int key) {
        return Searchrec(root, key);
    }

    // Inorder traversal to print the tree
    public void Inorderrec(Node root) {
        if (root != null) {
            Inorderrec(root.left);
            System.out.print(root.key + " ");
            Inorderrec(root.right);
        }
    }

    // Wrapper for inorder traversal
    public void Inorder() {
        Inorderrec(root);
    }

      // Function to find the node with the minimum value
    private Node MinValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    
    // Delete a node and rebalance the tree
    public Node Deleterec(Node root, int key) {
        // Step 1: Perform normal BST delete
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = Deleterec(root.left, key);
        } else if (key > root.key) {
            root.right = Deleterec(root.right, key);
        } else {  // This is the node to be deleted
            // Node with only one child or no child
            if (root.left == null || root.right == null) {
                Node temp = root.left != null ? root.left : root.right;
                root = temp;  // Copy the non-null child
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = MinValueNode(root.right);

                // Copy the inorder successor's content to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = Deleterec(root.right, temp.key);
            }
        }

        // If the tree only had one node, return it
        if (root == null) {
            return root;
        }

        // Step 2: Update the height of the current node
        root.height = Math.max(Height(root.left), Height(root.right)) + 1;

        // Step 3: Get the balance factor of this node
        int balance = GetBalance(root);

        // Step 4: Perform rotations to balance the tree
        // Left Left Case
        if (balance > 1 && GetBalance(root.left) >= 0) {
            return RightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && GetBalance(root.right) <= 0) {
            return LeftRotate(root);
        }

        // Left Right Case
        if (balance > 1 && GetBalance(root.left) < 0) {
            root.left = LeftRotate(root.left);
            return RightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && GetBalance(root.right) > 0) {
            root.right = RightRotate(root.right);
            return LeftRotate(root);
        }

        return root;
    }

    // Wrapper for delete function
    public void Delete(int key) {
        root = Deleterec(root, key);
    }
    
    public static void main(String[] args){
        AVLTree tree = new AVLTree();
        tree.Insert(10);
        tree.Insert(20);
        tree.Insert(30);
        tree.Insert(25);
        tree.Insert(15);

        System.out.println("Inorder traversal of the AVL tree:");
        tree.Inorder(); // Output will be sorted in ascending order

        System.out.println("\nSearching for 25: " + tree.Search(25)); // Should return true
        System.out.println("Searching for 50: " + tree.Search(50)); // Should return false
        tree.Delete(20); // Deleting a node
        System.out.println("Inorder traversal after deletion of 20:");
        tree.Inorder();
    }
}

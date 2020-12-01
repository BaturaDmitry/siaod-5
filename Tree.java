package com.company;

public class Tree {
    private class Node {
        int data;
        Node left;
        Node right;


        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public Node head = null;

    public void add(int data) {
        Node node = new Node(data, null, null);
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;

        while (true) {
            if (data < current.data && current.left != null) {
                current = current.left;
                continue;
            }
            if (data >= current.data && current.right != null) {
                current = current.right;
                continue;
            }

            if (data < current.data) {
                current.left = node;
            } else current.right = node;
            return;
        }
    }

    public void straightPrint() {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        System.out.println("Прямой обход дерева.");
        straight(head);
        System.out.println();
    }

    private void straight(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            straight(node.left);
            straight(node.right);
        }
    }
    public void reversePrint() {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        System.out.println("Обратный обход дерева.");
        reverse(head);
        System.out.println();
    }


    private void reverse(Node node) {
        if (node != null) {
            reverse(node.left);
            reverse(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void simmetricPrint() {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        System.out.println("Симметричный обход дерева.");
        symmetric(head);
        System.out.println();
    }

    private void symmetric(Node node) {
        if (node != null) {
            symmetric(node.left);
            System.out.print(node.data + " ");
            symmetric(node.right);
        }
    }
    public void search(int key) {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        if (srch(head, key) != null) {
            System.out.println("Такой элемент есть.");
        } else {
            System.out.println("Такого элемента нет.");
        }
    }

    private Node srch(Node current, int key) {
        if (current == null) return null;
        if (key == current.data) return current;
        if (key < current.data) return srch(current.left, key);
        return srch(current.right, key);
    }

    public void delete(int key) {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        remove(head, key);
    }


    private Node remove(Node current, int key) {
        if (current == null) return null;
        if (key < current.data) current.left = remove(current.left, key);
        else if (key > current.data) current.right = remove(current.right, key);
        else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;
            current.data = min(current.right);
            current.right = remove(current.right, current.data);
        }
        return current;
    }

    private int min(Node current) {
        int min = current.data;
        while (current.left != null) {
            min = current.left.data;
            current = current.left;
        }
        return min;
    }

}
package com.company;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.xml.namespace.QName;

/**
 * Created by Jorge Reina on 10/25/15.
 */
public class ExpressionTree
{
    static String expression = "a b + c d e+ **";


    public static void main(String[] args)
    {
        Scanner input = new Scanner(expression);
        Stack<Node> stack = new Stack<Node>();

        while(input.hasNext())
        {
            String symbol = input.next();
            Node node = new Node(symbol);

            if((isOperator(symbol)))
            {
                node.right = stack.pop();
                node.left = stack.pop();

            }
            stack.push(node);

        }

        if(stack.size() != 1)
        {
            throw new IllegalStateException("invalid stack");
        }

        Node expressionTreeRoot = stack.pop();
        printPostfix(expressionTreeRoot);
    }

    private static void insert(int newData)
    {
        Node node = new Node(String.valueOf(newData));
        Node root = new Node(String.valueOf(newData));


        if(root == null)
        {
            root = node;
            return;
        }
        Node current = root;
        int currentData = asInt(current.symbol);
        if(currentData > newData) {
            current = current.right;
        }
        else if(newData < currentData) {
            current = current.left;
        }
        else {
            throw new IllegalArgumentException("no duplicates allowed");
        }
    }

//    private void insert_recurse(Node root, Node node){
//        if()
//    }

    private static int findMin(Node node)
    {
        if(node.left == null) {
            throw new IllegalArgumentException("null node");
        }
        if(node.left == null) {
            return asInt(node.symbol);
        }
        return findMin(node.left);
    }

    private static int findMax(Node root)
    {
        return 0;
    }

    private static boolean exists(Node node, int data)
    {

        if(node == null)
        {
            return false;
        }

        int symbol = asInt(node.symbol);

        if(data < symbol)
        {
            return exists(node.left, data);
        }
        else if(data > symbol)
        {
            return exists(node.right, data);
        }
        else
        {
            return true;
        }


    }

    private static int asInt(String s)
    {
        return Integer.parseInt(s);
    }

    private static Node formBST()
    {
        Node ten = new Node("10");
        Node five = new Node("5");
        Node twelve = new Node("12");
        Node two = new Node("2");
        Node six = new Node("6");
        Node three = new Node("3");
        Node four = new Node("4");

        three.right = four;
        two.right = three;
        five.left = two;
        five.right = six;
        ten.left = five;
        ten.right = twelve;


        return ten;
    }

    private static void printBreadth(Node root)
    {
        if(root == null)
        {
            return;
        }

        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while(! queue.isEmpty())
        {
            Node node = queue.remove();
            System.out.println(node.symbol + " ");
            if(node.left != null)
            {
                queue.add(node.left);
            }
            if(node.right != null)
            {
                queue.add(node.right);
            }

        }

    }

    private static void printPostfix(Node node)
    {
        if(node.left != null)
        {
            return;
        }

        printPostfix(node.left);
        printPostfix(node.right);
        System.out.println(node.symbol + " ");
    }

    private static void printPrefix(Node node)
    {
        if(node.left != null)
        {
            return;
        }

        System.out.println(node.symbol + " ");
        printPostfix(node.left);
        printPostfix(node.right);
    }

    private static void printInfix(Node node)
    {
        if(node.left != null)
        {
            return;
        }

        printPostfix(node.left);
        System.out.println(node.symbol + " ");
        printPostfix(node.right);
    }


    private static boolean isOperator(String symbol)
    {
        return false;
    }
}

class Node
{
    Node   left;
    Node   right;
    String symbol;

    public Node(String s)
    {
        this.symbol = s;
    }
}
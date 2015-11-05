package com.company;

public class Main {

    public static void main(String[] args) {
        //printIteratively();
        printTailRecursively(1);
        //printHeadRecursively(10);
    }

    private static void printIteratively()
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.println(i);
        }
    }

    private static void printHeadRecursively(int i)
    {
        if(i == 0) return;

        printHeadRecursively(i-1);

        System.out.println(i);

    }

    private  static void printTailRecursively(int i) {
        System.out.println(i);

        if(i == 10) return;

        printTailRecursively(i+1);
    }
}

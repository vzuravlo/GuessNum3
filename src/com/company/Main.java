package com.company;

import java.util.Random;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Random randNum = new Random(45);
        Random randSeed = new Random();
        randNum.setSeed(randSeed.nextLong());
        int myNum = randNum.nextInt(100) + 1;

        String userName = "Simple player";

        System.out.println("It`s the game Guess number.");

        do {
            String startMessage = """
                    Enter Your choice:
                    1 - new player
                    2 - play game
                    3 - Exit
                    """;
            System.out.print(startMessage);
            String answer = scanner.next();
            switch (answer) {
                case "1":
                    System.out.println("Enter Your name");
                    userName = scanner.next();
                    System.out.println("Hi " + userName);
                    break;
                case "2":
                    randSeed.nextLong();
                    randNum.setSeed(randSeed.nextLong());
                    myNum = randNum.nextInt(100) + 1;
                    break;
                case "3":
                    System.out.println("Good bue! " + userName);
                    System.exit(1);
                    break;
                default:
            }


            if (gameProcess(myNum)) {
                System.out.println("You lost, " + userName);
            } else {
                System.out.println("You win!");
            }

        }
        while (true);


    }

    public static boolean gameProcess(int myNum) {

        System.out.printf("Cheat: %d\n", myNum);

        boolean userLost = true;
//        myNum = randNum.nextInt(100) + 1;


        for (int i = 0; i < 10; i++) {

            System.out.printf("Try #%d. Guess my number. \n", (i + 1));
            int userNum = scanner.nextInt();
            System.out.printf("You entered %d\n", userNum);
            String greaterMSG = "My number is greater than yours";
            String lessMSG = "My number is less than yours";

            if (myNum > userNum) {
                System.out.println(greaterMSG);
            } else if (myNum < userNum) {
                System.out.println(lessMSG);
            } else {
                userLost = false;
                break;
            }

        }
        return userLost;


    }

}

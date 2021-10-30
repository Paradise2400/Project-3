package main;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        String stringInput;

        while (!quit) {
            System.out.println("Choose\n" +
                    "1 to enter a start\n" +
                    "0 to exit: \n");
            boolean hasNextInt = scanner.hasNextInt(); //returns true if the scanner's input is an integer
            if (hasNextInt) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        System.out.println("You have left the program.");
                        quit = true;
                        break;
                    case 1:
                        BinaryTree<String> aTree = new BinaryTree<>();
                        DriverBT.createTree2(aTree);
                        System.out.print("Choose an option below:\n" +
                                "\n1. PostorderTraversal()" +
                                "\n2. Get Height of Tree" +
                                "\n3. Get number of Nodes of Tree: \n");
                        hasNextInt = scanner.hasNextInt();
                        if (hasNextInt) {
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            if (choice == 1) {
                                System.out.println("Postorder: " + aTree.postorderTraverse_callBinaryNodeMethod() + "\n1");
                                break;
                            } else if (choice == 2) {
                                System.out.println("Height: " + aTree.getHeight() + "\n");
                                break;
                            } else if (choice == 3) {
                                System.out.println("Nodes: " + aTree.getNumberOfNodes() + "\n");
                                break;
                            }
                            else {
                                throw new IllegalArgumentException("Please enter an integer: 1,2 or 3");
                            }
                        } else {
                            throw new IllegalArgumentException("Please enter an integer: 1,2 or 3");
                        }

                }
            } else {
                System.out.println("Unable to parse choice: Please enter an integer of choice");
                throw new IllegalArgumentException("Please enter an integer of choice");
            }
        }
    }


}
    


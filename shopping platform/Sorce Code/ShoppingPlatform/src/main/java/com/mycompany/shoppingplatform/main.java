/**@author malithranasinghe*/

package com.mycompany.shoppingplatform;

import javax.swing.*;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        System.out.println("\n\n\n---------- Welcome to the Westminster Shopping Manager ----------");
        systemManager();
    }

    private static void customer(WestminsterShoppingManager westminsterShoppingManager) {

        SwingUtilities.invokeLater(() -> {
            ShoppingGUI shoppingGUI = new ShoppingGUI(westminsterShoppingManager);
            shoppingGUI.setVisible(true);
            });


    }

    private static void systemManager() {
        WestminsterShoppingManager shoppingManager =new WestminsterShoppingManager();
        Scanner input=new Scanner(System.in);
        int option=1;
        ( shoppingManager).readFromFile();
        while (option !=0){
            System.out.println("\n................................................");
            System.out.println("Please Select an option: ");
            System.out.println("1) Add a Product");
            System.out.println("2) Delete a Product");
            System.out.println("3) Print products");
            System.out.println("4) Save  ");
            System.out.println("5) GUI");
            System.out.println("0) Quit ");
            System.out.println("................................................");
            do{ //option validation
                System.out.print("Enter option: ");
                if (input.hasNextInt()){
                    option= input.nextInt();
                    if (option<6 && option>-1){
                        break;
                    }
                }input.nextLine();
                System.out.println("Sorry.Invalid input.");
            }while (true);
            switch (option) {
                case 1 -> shoppingManager.addProductToSystem();
                case 2 -> shoppingManager.removeProduct();
                case 3 -> shoppingManager.printProductList();
                case 4 -> shoppingManager.saveToFile();
                case 5 -> customer(shoppingManager);
            }
        }
    }
}

/**@author malithranasignhe*/
package com.mycompany.shoppingplatform;


import java.io.*;
import java.util.*;


public class WestminsterShoppingManager implements ShoppingManager{
    
    private final List<Product> productList;

    /*public List<Product> getProductList() {
        return productList;
    }*/

    public WestminsterShoppingManager() {

        this.productList = new ArrayList<>();
    }

    @Override
    public void addProductToSystem() {
      
        Scanner input =new Scanner(System.in);
        int option;
        if (productList.size()<50){  //cant be equal to 50 because there have to be one space left to add
            while (true){
                System.out.print("Enter 1 for Electronics \nEnter 2 for Clothing\n----> ");
                try{
                    option= input.nextInt();
                    if (option ==1 || option == 2){
                        break;
                    } else {
                        System.out.println("Sorry.Invalid Input.");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Sorry. Invalid Input. please enter a valid input.");
                }
            }
            if (option == 1){
                addElectronic(input);
            }else {
                addClothing(input);
            }
            
//                -----------------------------------------------------
        }else {
            System.out.println("No space");
        }


    }

    private void addClothing(Scanner input) {
        String colour;
        int AvailableProducts;
        double size;
        double price;
        String productID;
        String productName;

        System.out.println("------Add Clothing ------");

        System.out.print("Enter Product ID: ");
        productID= input.next();

        System.out.print("Enter Product Name: ");
        productName= input.next();

        do {
            System.out.print("Enter Available items: ");
            while (!input.hasNextInt()){
                System.out.println("Please enter a valid input for available items.");
                input.next();
            }
            AvailableProducts = input.nextInt();
            if (AvailableProducts<=0){
                System.out.println("Available items must be greater than 0. Please enter a valid number.");
            }
        }while (AvailableProducts<=0);

        do {
            System.out.print("Enter the Price: ");
            while (!input.hasNextDouble()){
                System.out.println("Sorry enter a valid input.");
                input.next();
            }
            price= input.nextDouble();
            if (price<=0){
                System.out.println("Price must be greater than 0. Please enter a valid price.");
            }
        }while (price<=0);

        do {
            System.out.print("Enter the Size: ");
            while (!input.hasNextDouble()) {
                System.out.println("Please enter a valid input for the size.");
                input.next(); // consume the invalid input
            }
            size = input.nextDouble();
            if (size <= 0) {
                System.out.println("Size must be greater than 0. Please enter a valid size.");
            }
        } while (size <= 0);

        System.out.print("Enter the colour: ");
        colour= input.next();

        Clothing clothing =new Clothing(productID,productName,AvailableProducts,price,size,colour);
        productList.add(clothing);
    }

    private void addElectronic(Scanner input) {
        double price;
        String brand;
        String productID;
        int warrantyPeriod;
        String productName;
        int AvailableProducts;
        System.out.println("------ Add Electronic items--------");

        System.out.print("Enter Product ID: ");
        productID= input.next();

        System.out.print("Enter Product Name: ");
        productName= input.next();

        do {
            System.out.print("Enter Available items: ");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid input.");
                input.next(); //  invalid input
            }
            AvailableProducts = input.nextInt();
            if (AvailableProducts <= 0) {
                System.out.println("Number of available items must be greater than 0. Please enter a valid number.");
            }
        } while (AvailableProducts <= 0);

        do {
            System.out.print("Enter the Price: ");
            while (!input.hasNextDouble()) {
                System.out.println("Please enter a valid input.");
                input.next(); //  invalid input
            }
            price = input.nextDouble();
            if (price <= 0) {
                System.out.println("Price must be greater than 0. Please enter a valid price.");
            }
        } while (price <= 0);

        System.out.print("Enter the Brand: ");
        brand= input.next();

        do {
            System.out.print("Enter the warranty period (in Months): ");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid input.");
                input.next(); // invalid input
            }
            warrantyPeriod = input.nextInt();
            if (warrantyPeriod <= 0) {
                System.out.println("Warranty period must be greater than 0. Please enter a valid number.");
            }
        } while (warrantyPeriod <= 0);

        Electronics electronics = new Electronics(productID,productName,AvailableProducts,price,brand,warrantyPeriod);
        productList.add(electronics);
    }

    @Override
    public void removeProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Product ID: ");
        String productIdToRemove = input.next();

        boolean found = false;
        for (Product product : productList) {
            if (product.getProductId().equals(productIdToRemove)) {
                productList.remove(product);
                found = true;
                System.out.println("Product removed Successfully");
                System.out.println("Total Number of products left: " + productList.size());
                break; // Exit the loop after removing the product
            }
        }

        if (!found) {
            System.out.println("Product Not Found! Check if the Product ID is Correct or not.");
        }

//        delete---------------------------------

        for (Product product : productList) {
            System.out.println(product);
        }
//        -------------------------------------



    }

    @Override
    public void printProductList() {
        System.out.println("Products in the list:");
        productList.sort(Comparator.comparing(Product::getProductId));
        for (Product product : productList) {
            System.out.println("Product Type: " + product.getProductType());
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Available Items: " + product.getAvailableItems());
            System.out.println("Price: " + product.getPrice());

            if (product instanceof Electronics) {
                System.out.println("Brand: " + ((Electronics) product).getBrand());
                System.out.println("Warranty Period: " + ((Electronics) product).getWarrantyPeriod() + " months\n");

            } else if (product instanceof Clothing) {
                System.out.println("Size: " + ((Clothing) product).getSize());
                System.out.println("Color: " + ((Clothing) product).getColour() +"\n" );
            }

            System.out.println();
        }

    }

    @Override
    public void saveToFile() {
        try (BufferedWriter writer =new BufferedWriter(new FileWriter("saveData.txt"))) {
            for (Product product : productList){
                writer.write(product.toString());
                writer.newLine();
            }
            System.out.println("Product list saved to file saveData.txt Successfully.");


        } catch (FileNotFoundException e){
            System.out.println("File not found : saveData.txt");
        } catch (IOException e) {
            System.out.print("Error " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("saveData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming toString() method in Product class returns a formatted string
                updateProductListFromFile(line);


//
//
            }
            System.out.println("Product list loaded from file successfully");
        } catch (FileNotFoundException e){
            System.out.println("saveData.txt File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProductListFromFile(String line) {
        try {

            String[] parts = line.split(",\\s*");


            if (parts.length < 6) {
                System.out.println("Invalid product format: " + line);
                return;
            }

            String productIdFromFile = parts[0];

            String productNameFromFile = parts[1];


            int availableItemsFromFile = Integer.parseInt(parts[2]);


            double priceFromFile  = Double.parseDouble(parts[3]);


            //determine the product type according to the data type  in the 5th place
            if (parts[4].matches("\\d*\\.?\\d+")){   //if the 5th place is a double it is a Clothing product (size)


                double sizeFromFile = Double.parseDouble(parts[4]);


                String colorFromFile = parts[5];


                Clothing clothing=new Clothing(productIdFromFile, productNameFromFile, availableItemsFromFile, priceFromFile, sizeFromFile, colorFromFile);
                productList.add(clothing);

            }else {

                String brandFromFile = parts[4];


                int warrantyFormFile = Integer.parseInt(parts[5]);

                Electronics electronics=new Electronics(productIdFromFile, productNameFromFile, availableItemsFromFile, priceFromFile, brandFromFile, warrantyFormFile);
                productList.add(electronics);
            }
        }catch (NumberFormatException e){
            System.out.println("Error passing numeric value from line" );
        }

    }
    
}

/**@author malithranasinghe*/
package com.mycompany.shoppingplatform;


public class Electronics extends Product {
    
    private final String brand;
    private final int warrantyPeriod;



    public Electronics(String productId, String productName, int AvailableItems, double price , String brand, int warrantyPeriod) {
        super(productId, productName, AvailableItems, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }


    @Override
    public String getProductType() {
        return "Electronics";
    }


    public String getBrand() {

        return brand;
    }

   /* public void setBrand(String brand) {

        this.brand = brand;
    }*/

    public int getWarrantyPeriod() {

        return warrantyPeriod;
    }

   /* public void setWarrantyPeriod(int warrantyPeriod) {

        this.warrantyPeriod = warrantyPeriod;
    }*/

    @Override
    public String toString() {
        return String.format("%s, %s, %d, %.2f, %s, %d",
                getProductId(), getProductName(), getAvailableItems(), getPrice(), getBrand(), getWarrantyPeriod());
    }
    
}

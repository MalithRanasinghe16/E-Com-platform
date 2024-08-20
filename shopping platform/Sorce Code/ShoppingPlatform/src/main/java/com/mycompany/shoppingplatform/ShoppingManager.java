/**@author malithranasinghe*/
package com.mycompany.shoppingplatform;


public interface ShoppingManager {
    
    public abstract void addProductToSystem();

    void removeProduct();

    public abstract void printProductList();
    public abstract void saveToFile();
    
}

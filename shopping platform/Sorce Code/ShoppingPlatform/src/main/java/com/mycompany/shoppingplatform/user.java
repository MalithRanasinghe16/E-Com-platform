/**@author malithranasinghe*/
package com.mycompany.shoppingplatform;

public class user {
    private String userName;
    private String passWord;

    public void User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassWord(){
        return passWord;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
}

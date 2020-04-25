/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.UserAccount;
import StudentIO.LoginIO;
import java.util.ArrayList;

public class AccountList extends UserAccount{
    private final String DEFAULT_USERNAME = "admin";
    private final String DEFALUT_PASSWORD = "admin";
    ArrayList<UserAccount> userList = new ArrayList<>();
    LoginIO loginIO = new LoginIO();
    public AccountList(){
        
    }
    
    public AccountList(int accountID, String userName, String password, boolean status) {
        super(accountID, userName, password, status);
    }
    
    public String getDefaultUserName(){
        return DEFAULT_USERNAME;
    }
    
    public String getDefaultPassword(){
        return DEFALUT_PASSWORD;
    }
    
    public ArrayList getUserList(){
        return userList;
    }
    
    public void addUser(int accountID, String userName, String password, boolean status){
        UserAccount userAccount = new UserAccount(accountID, userName, password, status);
        userList.add(userAccount);
        loginIO.writeUserFile(userList);
    }
}

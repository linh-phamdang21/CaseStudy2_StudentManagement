
package Model;

import java.io.Serializable;

public class UserAccount implements Serializable{
    private int accountID;
    private String userName;
    private String password;
    private boolean status;
    
    public UserAccount(){
        
    }

    public UserAccount(int accountID, String userName, String password, boolean status){
        this.accountID = accountID;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }
    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ("ID: " + this.accountID +
                ", username: " + this.userName +
                ", password" + this.password + 
                ", status: " + this.status);
    }
}

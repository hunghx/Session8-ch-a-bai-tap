package service;

import model.Account;
import util.InputMethods;

import java.util.regex.Pattern;

public class AccountService {
    // co 2 chuc nang dang nhap dang ky
    private static Account[] accounts = new Account[100];
    static  {
        accounts[0] = new Account("Ken", "ken123@gmail.com", "123456");
     }
    public Account login(String username, String password){
        for (Account acc:accounts
             ) {
            if (acc!=null && acc.getUserName().equalsIgnoreCase(username)&&
                    acc.getPassword().equalsIgnoreCase(password)){
                return acc;
            }
        }
        return null;
    }
    public boolean register(Account account){
        // đã xác thực dữ liệu
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i]==null){
                accounts[i] = account;
                break;
            }
        }
        return true;
    }

    public boolean existByUserName (String username){
        for (Account acc:accounts
        ) {
            if (acc!=null && acc.getUserName().equalsIgnoreCase(username)){
                return true;
            }
        }
        return false;
    }
    public boolean existByEmail (String email){
        for (Account acc:accounts
        ) {
            if (acc!=null && acc.getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }

}

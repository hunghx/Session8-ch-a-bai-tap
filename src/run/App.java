package run;

import model.Account;
import service.AccountService;
import util.InputMethods;

public class App {
    private static AccountService accountService = new AccountService();
    public static void main(String[] args) {
        while (true){
            System.out.println("===============Menu===============");
            System.out.println("1.             Login");
            System.out.println("2.            Register");
            System.out.println("3.             Exit");
            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Không đúng giá trị");
            }
        }


    }

    public static void login() {
            // hiển thị form đăng nhập
        System.out.println("==========LOGIN==============");
        System.out.println("Nhập username :");
        String username = InputMethods.getString();
        System.out.println();
        System.out.println("Nhập password :");
        String password=InputMethods.getString();
        Account acc = accountService.login(username,password);
       if(acc==null){
           System.err.println("Sai tên đăng nhập hoặc mật khẩu");
           System.out.println("Bạn muốn tiếp tục đăng nhập ?");
           System.out.println("1. login");
           System.out.println("other. register");
           byte choose = InputMethods.getByte();
           if(choose==1){
               login();
           }else {
               register();
           }
       }else {
           // đăng nhập thành công
           System.out.println("CHào mừng bạn "+acc.getUserName()+" đến trang chủ");
           System.out.println("Nhấn phím bất kì để thoát");
           InputMethods.pressAnyKey();

       }
    }
    public static void register() {
        System.out.println("==============REGISTER=============");
        Account account =new Account();
        while (true){
            System.out.println("Nhập username :");
            String username = InputMethods.getString();
            if (accountService.existByUserName(username)){
                System.err.println("Tên đăng nhập đã tồn tại");
            }else {
                account.setUserName(username);
                break;
            }
        }

        while (true) {
            System.out.print("Nhập email :");
            String email = InputMethods.getString();
            if (accountService.existByEmail(email)){
                System.err.println("email đã tồn tại");
            }else {
                account.setEmail(email);
                break;
            }
        }
        System.out.print("Nhập password :");
        String pass = InputMethods.getString();
        while (true){
            System.out.print("Xác nhận mật khẩu :");
            String rePass = InputMethods.getString();
            if(pass.equals(rePass)){
                account.setPassword(pass);
                break;
            }
            System.err.println("mât khẩu không trùng khớp");
        }

        accountService.register(account);
        System.out.println("Đăng kí thành công");
        login();

    }

}

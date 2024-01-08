package views;

import dao.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Welcome {
    public void welcomeScreen(){
        Scanner sc=new Scanner(System.in);
        System.out.println("welcome to the Application");
        System.out.println("Press 1 to Login");
        System.out.println("Press 2 to Signup");
        System.out.println("Press 0 to exit");
        int choice=0;
        choice=sc.nextInt();
        switch(choice){
            case 1-> login();
            case 2-> signUp();
            case 0-> System.exit(0);
        }

    }

    private void signUp() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter email");
        String email=sc.nextLine();
        //verify user's email
        String genOTP= GenerateOTP.getOTP();
        SendOTPService.sendOTP(email,genOTP);
        System.out.println("Enter the otp");
        String otp=sc.nextLine();

        if(otp.equals(genOTP)){
            User user=new User(name,email);
            int response= UserService.saveUser(user);
            switch (response){
                case 0 -> System.out.println("user registered");
                case 1-> System.out.println("User already exists");
            }
        }
        else{
            System.out.println("Wrong OTP");
        }
    }

    private void login() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your email address");
        String email=sc.nextLine();
        try{
            if(UserDAO.isExists(email)){
                String genOTP= GenerateOTP.getOTP();
                SendOTPService.sendOTP(email,genOTP);
                System.out.println("Enter the otp");
                String otp=sc.nextLine();
                if(otp.equals(genOTP)){
                    System.out.println("Welcome");
                }
                else{
                    System.out.println("Wrong OTP");
                }

            }
            else{
                System.out.println("User not found");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

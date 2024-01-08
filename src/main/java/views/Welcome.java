package views;

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
    }

    private void login() {
        
    }
}

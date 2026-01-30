

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
class InvalidUser_nameException extends Exception{
    public InvalidUser_nameException(String s){
        super(s);
    }
}
class InvalidAgeException extends Exception{
    public InvalidAgeException(String m){
        super(m);
    }
}
class InvalidEmailException extends Exception{
    public InvalidEmailException(String m){
        super(m);
    }
}
public class Problem3 {
    private static final Logger logger = Logger.getLogger(Problem3.class.getName());
    
    public static void validate_username(String s) throws InvalidUser_nameException{
        if(!validate(s) || s.length()>=64){
            throw new InvalidUser_nameException("Invalid username. Don't use the special characters like @,!,# ...");
        }
    }
    public static void validate_email(String s) throws InvalidEmailException{
        int cnt=0,idx=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='@'){
                cnt++;
                idx=i;
            }
        }
        boolean flag = false;
        if(idx<s.length()-1 && cnt==1){
            String local = s.substring(0,idx);
            String domain =s.substring(idx+1,s.length());
            if(Domain(domain) && Local(local)){
                flag = true;
            }
        }
        if(!flag){
            throw new InvalidEmailException("Invalid Email");
        }
    }
    public static boolean Domain(String s){
        int cnt=0,idx=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='.'){
                cnt++;
                idx=i;
            }
        }
        if(idx<s.length() && cnt==1){
            s = s.substring(idx+1,s.length());
            if(s.length()<=2) return false;
        }
        return true;
    }
    public static boolean Local(String s){
        return s.matches("[a-zA-Z0-9_.]+");
    }
    public static void validate_age(int age) throws InvalidAgeException{
        if(age<0 || age>110){
            throw new InvalidAgeException("Invalid age");
        }
    }
    public static boolean validate(String s){
        return s.matches("[a-zA-Z0-9_]+");
    }
    public static void main(String[] args) throws IOException{
        FileHandler handler = new FileHandler("app.log", true);
        logger.addHandler(handler);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username");
        String user_name = sc.nextLine();
        try{
            validate_username(user_name);   
            System.out.println("Valid Username");
            logger.info("Username is Validated");
            System.out.println("Enter the Age");
            String Age = sc.nextLine();
            try{
                int age = Integer.parseInt(Age);
                validate_age(age);
                System.out.println("Valid Age");
                logger.info("Age is Validated");
                System.out.println("Enter the Mail");
                String email = sc.nextLine();
                try{
                    validate_email(email);
                    logger.info("Email is Validated");
                }
                catch(InvalidEmailException e){
                    System.out.println(e.getMessage());
                }
            }
            catch(InvalidAgeException e){
                System.out.println(e.getMessage());
                System.out.println("Enter the Correct Age");
            }
            catch(NumberFormatException e){
                logger.severe("Input is Wrong");
                System.out.println(e.getMessage());
                System.out.println("Enter the Number");
            }
        }
        catch(InvalidUser_nameException e){
            logger.severe("Input is wrong");
            System.out.println("Enter the valid username "+e.getMessage());
        }
    }
}
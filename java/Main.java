import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String...args){

        Scanner input = new Scanner(System.in);
        CreditCardValidator validator = new CreditCardValidator();
        

        String instruct= "-==| Hello, kindly Enter Card details to verify: ";
        System.out.println(instruct);
        long creditDetail = input.nextLong();
        long[] creditNumber = validator.convertToArray(creditDetail);

        String cardType = validator.checkCreditType(creditNumber);
        int length = validator.lengthOf(creditDetail);
        String validity = validator.checkValidity(creditNumber);
        
        if(validator.validateLength(creditNumber)){
             System.out.println("======= CREDIT CARD VALIDATOR =========="); 
             System.out.println("----------------------------------------"); 
             System.out.println("----Credit Card Type:\t "+        cardType); 
             System.out.println("----Credit Card Number:\t "+       creditDetail); 
             System.out.println("----Credit Card Digit Length:\t "+ length);
             System.out.println("----Credit Card validity:\t "+     validity);  
             System.out.println("=========================================");  
    
        }else{System.out.println("Invalid Card Input\nCheck and try again!!");}

        



    }
}

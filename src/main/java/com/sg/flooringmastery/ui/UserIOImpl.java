package com.sg.flooringmastery.ui;
import java.math.BigDecimal;
import java.util.Scanner;
/**
 * This class implements all the methods in UserIO interface
 * @author Yi Yang
 *
 */
public class UserIOImpl implements UserIO {
    Scanner myScanner = new Scanner(System.in);
    /**
     * A very simple method that takes in a message to display on the console 
     * and then waits for a integer answer from the user to return.
     * @param msg String of information to display to the user.
     */
    @Override
    public void print(String msg) {
        System.out.println(msg);   
    }    
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as double
     */
    @Override
    public double readDouble(String prompt) throws NumberFormatException{
        Double a = null;
        boolean loop = true;
        do{
            try{
                System.out.println(prompt);
                a = Double.parseDouble(myScanner.nextLine());
                loop = false;
            }catch(NumberFormatException e){   
            }
        }while(loop);
        return a;
    }
    /**
     *
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an double value as an answer to the message prompt within the min/max range
     */
    @Override
    public double readDouble(String prompt, double min, double max) throws NumberFormatException{
        Double a = null;
        boolean loop = true;
        do{
            try{
                do{
                    System.out.println(prompt);
                    a = Double.parseDouble(myScanner.nextLine());
                    loop = false;
                    if (a > max || a< min){
                        System.out.println("Your entry was not within the specified bounds."); 
                        loop = true;
                    }
                }while(a > max || a< min);
            }catch(NumberFormatException e){
                print("Incorrect data type");
            }
        }while(loop);
        return a;
    }
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an integer
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as integer
     */
    @Override
    public int readInt(String prompt) throws NumberFormatException{
        int a = 0;
        boolean loop = true;
        do{
            try{
                System.out.println(prompt);
                a = Integer.parseInt(myScanner.nextLine());
                loop = false;
            }catch(NumberFormatException e){
                print("Incorrect data type");
            }
        }while(loop);
        return a;
    }
    /**
     *
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an integer
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an integer value as an answer to the message prompt within the min/max range
     */
    @Override
    public int readInt(String prompt, int min, int max) throws NumberFormatException{
        int a = 0;
        boolean loop = true;       
        do{
            try{
                do{
                   System.out.println(prompt);
                   a= Integer.parseInt(myScanner.nextLine());
                   if (a > max || a< min){
                       System.out.println("Your entry was not within the specified bounds."); 
                   }
                }while(a > max || a< min);
                loop = false;
            }catch(NumberFormatException e){
                print("Incorrect data type");
            }
        }while(loop);
         return a;
    }
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and then waits for an answer from the user to return.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as string
     */
    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        String a = myScanner.nextLine();
        return a;
    }
    /**
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an string
     * that can be compared to the current string to be returned as the answer to that message.
     * @param prompt - String explaining what information you want from the user.
     * @param compare - The string to be used as comparison
     * @param toThis - The string entered
     * @return  the answer to the message as string
     */
    @Override
    public String readString(String prompt, String compare, String toThis){
        System.out.println(prompt);
        String a = myScanner.nextLine();
        if(a.equals(toThis)){
            a = compare;
        }        
        return a;
    }
    /**
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * within the specified min/max range to be returned as the answer to that message.
     * @param prompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param compare - String to be compared
     * @param toThis -  The string entered
     * @return the answer to the message as string
     * @throws NumberFormatException 
     */
    @Override
    public double readDouble(String prompt, double min, Double compare, String toThis) throws NumberFormatException {
        Double a = null;
        boolean loop = true;
        do{
            try{
                do{
                    System.out.println(prompt);
                    String b = myScanner.nextLine();                    
                    if(b.equals(toThis)){
                        a = compare;
                    }else{
                        a = Double.parseDouble(b);
                    }
                    loop = false;
                    if (a< min){
                        System.out.println("Your entry was not within the specified bounds."); 
                        loop = true;
                    }
                }while(a< min);
            }catch(NumberFormatException e){
                print("Incorrect data type");
            }
        }while(loop);
        return a;
    }
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an BigDecimal
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as BigDecimal
     */
    @Override
    public BigDecimal readBigDecimal(String prompt) throws NumberFormatException {
        BigDecimal a = null;
        boolean loop = true;
        do{
            try{
                System.out.println(prompt);
                a = new BigDecimal(myScanner.nextLine());
                loop = false;
            }catch(NumberFormatException e){
                print("Incorrect data type");
            }
        }while(loop);        
        return a;
    }
    /**
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an BigDecimal
     * within the old value to be returned as the answer to that message.
     * @param prompt - String explaining what information you want from the user.
     * @param oldValue - BigDecimal to be compared with what is entered
     * @return the answer to the message as BigDecimal
     * @throws NumberFormatException 
     */
    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal oldValue) throws NumberFormatException{
        BigDecimal temp = null;
        boolean loop =true;
        System.out.println(prompt);
        String a = myScanner.nextLine();
        do{
            try{
                if(a.equals("")){
                    temp = oldValue;
                }else{
                    temp = new BigDecimal (a);
                }                
            }catch(NumberFormatException e){
                print("Incorrect data type");
            }
            loop = false;
        }while(loop);        
        return temp;
    }  
}

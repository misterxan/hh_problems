/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Феликс on 17.10.2015.
 */
public class Series {
    private static String inputLine;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        setInputData();
        String series = "";
        BigInteger step = BigInteger.valueOf(1);
        BigInteger position = BigInteger.valueOf(1);
        String pure;
        while (true){
            while (series.length() < inputLine.length()){
                series += step.toString();
                step = step.add(BigInteger.ONE);
            }
            pure = series.substring(0, inputLine.length());
            //System.out.println(position+" "+pure);
            if (pure.equals(inputLine)){
                break;
            }
            position = position.add(BigInteger.ONE);
            series = series.substring(1);
        }
        System.out.println("Congratulations! First enter in position equal "+position+"! Thank you very match!");
    }
    private static void setInputData(){
        System.out.println("Enter string (example format 12345)");
        inputLine = in.nextLine().trim();
        if(inputLine.isEmpty()){
            System.out.println("Empty input line!");
            setInputData();
        }
        try {
            Long temp = new Long(inputLine);
            if(temp < 0 ){
                throw new NumberFormatException();
            }
        }catch (NumberFormatException e){
            System.out.println("Incorrect input line!");
            setInputData();
        }
    }
}

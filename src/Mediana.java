/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javafx.scene.paint.Stop;

import java.util.*;

/**
 * Created by Феликс on 11.10.2015.
 */
public class Mediana {
    private static Map<String, String> inputStrings = new HashMap<String, String>();
    private static Map<String,List<Double>> integerLists = new HashMap<String, List<Double>>();
    private static List<Double> generalInputIntegers;
    private static Integer dimension;
    private static Scanner in = new Scanner(System.in);
    private static Double median;
    public static void main(String[] args){
        sugarInputData();
        //connectInputData(); //Альтернативный вариант сортировки (Расскомментировать если данные будут вводится несортированные)
        connectInputDataAlternative(); // Закомментировать при не сортированных данных
        calculateMedian();
        System.out.println("Median = "+median);
    }
    private static void sugarInputData(){
        setInputData("first");
        setInputData("second");
        if(!detect()){
            sugarInputData();
        }
    }
    private static void setInputData(String id){
        System.out.println("Enter "+id+" string, dimension N (example format) 1 2 3 4 5 6 7 8 9");
        inputStrings.put(id, in.nextLine().trim());
        integerLists.put(id, new ArrayList<Double>());
        String[] arrayOfString = inputStrings.get(id).split(" ");
        try{
            Double oldNumber = .0;

            // Заккоментировать если будут вводится несортированные данные
            for (String anArrayOfStringFirst : arrayOfString) {
                Double newNumber = new Double(anArrayOfStringFirst);
                if(oldNumber>newNumber){
                    System.out.println(id+" string non sorted!");
                    throw new NumberFormatException();
                }
                integerLists.get(id).add(newNumber);
                oldNumber = newNumber;
            }
            //Расскомментировать если будут вводится несортированные данные
            /*for (String anArrayOfStringFirst : arrayOfString) {
                Double newNumber = new Double(anArrayOfStringFirst);
                integerLists.get(id).add(newNumber);
            }*/
        }catch (NumberFormatException err){
            System.out.println("Incorrect format "+id+" string");
            setInputData(id);
        }
    }
    private static boolean detect(){
        if(integerLists.get("first").size() != integerLists.get("second").size()){
            System.out.println("Different length of string!");
            return false;
        }
        return true;
    }
    private static void calculateMedian(){
        System.out.println("First of median number = "+generalInputIntegers.get(dimension-1)+" in position = " + dimension);
        System.out.println("Second of median number = "+generalInputIntegers.get(dimension)+" in position = " + (dimension+1));
        median = (generalInputIntegers.get(dimension)+generalInputIntegers.get(dimension-1))/2.0;

    }
    private static void connectInputData(){
        generalInputIntegers = new ArrayList<Double>(integerLists.get("first"));
        generalInputIntegers.addAll(integerLists.get("second"));
        sortGeneralIntegers();
        System.out.println("Input data: " + generalInputIntegers);
        dimension = integerLists.get("first").size();
        inputStrings = null;
        integerLists = null;
    }

    private static void connectInputDataAlternative(){
        dimension = integerLists.get("first").size();
        generalInputIntegers = new ArrayList<Double>();
        int i=0;
        while(true){
            if(integerLists.get("first").size() == 0){
                generalInputIntegers.addAll(integerLists.get("second"));
                break;
            }
            if(integerLists.get("second").size() == 0){
                generalInputIntegers.addAll(integerLists.get("first"));
                break;
            }
            if(integerLists.get("first").get(i)<=integerLists.get("second").get(i)){
                generalInputIntegers.add(integerLists.get("first").get(i));
                integerLists.get("first").remove(i);
            }else{
                generalInputIntegers.add(integerLists.get("second").get(i));
                integerLists.get("second").remove(i);
            }
        }
        System.out.println("Input data: " + generalInputIntegers);
        inputStrings = null;
        integerLists = null;
    }
    private static void sortGeneralIntegers(){
        Collections.sort(generalInputIntegers, new Comparator<Double>() {
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });
    }
}

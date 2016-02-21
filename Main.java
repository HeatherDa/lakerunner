package com.Heather;
import java.util.*;
public class Main {
static Scanner scan;
static Scanner scandoub;
    public static void main(String[] args) {
        // receive lake and duration of run from user and calculate the fastest time for each lake in turn.
        //arrange as hash of arrays.  Key to hash is lake name, array's contain times.
        scan = new Scanner(System.in);
        scandoub = new Scanner(System.in);
        HashMap<String,ArrayList<Double>>lakes= new HashMap<>();
        HashMap<Double, String> runstats = new HashMap<>();

        System.out.println("Please enter the name of the lake.");
        String lake = scan.nextLine();
        System.out.println("Please enter the time for the run.");
        double time = scan.nextDouble();
        ArrayList<Double>times=new ArrayList<>();
        if (lakes.containsKey(lake)){//check for existence of key
            times=lakes.get(lake);//get array from hash
            times.add(time);//add new time to the array for the lake
            lakes.put(lake,times);//update hash with new value
        }else{
            times.add(time);
            lakes.put(lake,times);
        }
        System.out.println("What is in my hash? "+lakes+" What is in my array? "+ times);

    }
}

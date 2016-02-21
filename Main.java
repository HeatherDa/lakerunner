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
        HashMap<String, ArrayList<Double>> lakes = makelakes();
        //System.out.println(lakes);
        for(String lake:lakes.keySet()){
            Double min=minvalue(lakes.get(lake));
            System.out.println("The shortest time for lake "+lake+" was "+min+".");
        }

    }
    private static HashMap<String, ArrayList<Double>>makelakes(){
        HashMap<String,ArrayList<Double>>lakes= new HashMap<>();
        System.out.println("How many entries do you wish to make?");
        Double number = scandoub.nextDouble();
        for(int i=0;i<number;i++) {

            ArrayList<Double> times = new ArrayList<>();
            System.out.println("Please enter the name of the lake.");
            String lake = scan.nextLine();
            lake=lake.toLowerCase();
            System.out.println("Please enter the time for the run.");
            double time = scandoub.nextDouble();

            if (lakes.containsKey(lake)) {//check for existence of key
                times = lakes.get(lake);//get array from hash
                times.add(time);//add new time to the array for the lake
                lakes.put(lake, times);//update hash with new value
            } else {
                times.add(time);
                lakes.put(lake, times);
            }
            //System.out.println("What is in my hash? " + lakes + " What is in my array? " + times);
        }
        return lakes;
    }
    private static double minvalue(ArrayList<Double>times){
        double minimum=1440;//number of minutes in a day.  Certainly longer than a run!
        for(double time:times){
            if(time<minimum){
                minimum=time;
            }
        }
        return minimum;
    }
}

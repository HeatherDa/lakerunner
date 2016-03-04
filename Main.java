package com.Heather;
import java.util.*;
public class Main {
static Scanner scan;
static Scanner scandoub;
    public static void main(String[] args) {
        // receive input for lake and duration of run from user and calculate the fastest time for each lake in turn.
        scan = new Scanner(System.in);
        scandoub = new Scanner(System.in);
        HashMap<String, ArrayList<Double>> lakes = makelakes();
        for(String lake:lakes.keySet()){
            Double min=minvalue(lakes.get(lake));
            System.out.println("The shortest time for lake "+lake+" was "+min+" minutes.");
        }
    }
    private static HashMap<String, ArrayList<Double>>makelakes(){
        HashMap<String,ArrayList<Double>>lakes= new HashMap<>();
        String lake="Hit Enter an extra time to finish inputting data.";
        System.out.println(lake);

        while(!lake.equals("")) {

            ArrayList<Double> times = new ArrayList<>();
            System.out.println("Please enter the name of the lake.");
            lake = scan.nextLine();
            lake=lake.toLowerCase();
            if (lake.equals("")) {//test for end of data input
                break;
            }
            double time=0;
            boolean isdouble;
            do {  //I saw someone using this construction when I was researching how to do this, but I don't remember where I found it!
                // I think it was probably on stackoverflow because that's where I do lots of research.
                // I've been really frustrated about while loops and wanting to check at the bottom, so I'm glad I found out how.
                //I suppose I could have error checked with try and catch, couldn't I?
                //more info on Do While here https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html
                System.out.println("Please enter the time for the run.");
                if (scandoub.hasNextDouble()) { //this is so cool!  I guess we won't use it much if we're not going to be using scanners though.
                    time = scandoub.nextDouble();
                    isdouble = true;
                } else {
                    System.out.println("Please type minutes and seconds as a decimal number.");
                    isdouble = false;
                    scandoub.next();
                }
            }while(!(isdouble));

            if (lakes.containsKey(lake)) {//check for existence of key
                times = lakes.get(lake);//get array from hash
                times.add(time);//add new time to the array for the lake
                lakes.put(lake, times);//update hash with new value
            } else {
                times.add(time);
                lakes.put(lake, times);
            }
        }
        scan.close();
        scandoub.close();
        return lakes;
    }
    private static double minvalue(ArrayList<Double>times){
        double minimum=1440;//number of minutes in a day.  Certainly longer than a run!
        for(double time:times){//access entry in array
            if(time<minimum){ //test entry to see if less than minimum
                minimum=time; //update minimum
            }
        }
        return minimum;
    }
}

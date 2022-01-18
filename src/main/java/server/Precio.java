package server;

import java.util.ArrayList;

public class Precio {
        public static double age;
        public static double average;
        public static double counter;
        public static double coordin;

        public static ArrayList<String> members = new ArrayList<String>();
        //public static ArrayList<Double> coordin = new ArrayList<Double>();

        public void add_member(String member){
            if(!members.contains(member)){
                System.out.println(member);
                System.out.println("Perfect, you are more than 18: " + this.age);

                this.members.add(member);
            }
        }

        public void change_coordinates(String x, String y){
            String dou = x +"."+ y;

            this.coordin = Double.valueOf(dou);
        }

        public String show_coo(){
        	String result = "Cordinates: " + this.coordin;
            System.out.println(result);
        	return result;
        }

        public double avr(){

        	this.average = this.age/this.counter;
        	return this.average;
        }

        public double da(){
            return this.age;
        }
        public void pone(double x, String member){
            if(!members.contains(member)){
                this.age = this.age + x;
                this.counter = this.counter + 1;
            }
        }
    }
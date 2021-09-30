package server;

import java.util.ArrayList;

public class Precio {
        public static double age;
        public static double average;
        public static double counter;

        public static ArrayList<String> members = new ArrayList<String>();
        public static ArrayList<Double> coordin = new ArrayList<Double>();

        public void add_member(String member){
        	System.out.println(member);
            if(!members.contains(member)){
                this.members.add(member);
            }
        }

        public void change_coordinates(double x, double y){
        	this.coordin.add(0, x);
        	this.coordin.add(1, y);
        }

        public String show_coo(){
        	String result = "Cordinates: " + this.coordin;
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
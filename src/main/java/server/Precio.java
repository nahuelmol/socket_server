package server;

import java.util.ArrayList;

public class Precio {
        public static double age;
        public static double average;
        public static double counter;
        public static ArrayList<String> members = new ArrayList<String>();

        public void add_member(String member){
        	System.out.println(member);
        	this.members.add(member);
        }

        public double avr(){

        	this.average = this.age/this.counter;
        	return this.average;
        }

        public double da(){
            return this.age;
        }
        public void pone(double x){
            this.age = this.age + x;
            this.counter = this.counter + 1;
        }
    }
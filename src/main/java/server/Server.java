package server;

import org.json.*;

import java.net.*;
import java.io.*;
import java.util.Date;

import server.Precio;

public class Server {
    public static Precio p;

	public static void start(){
		final Integer port = 3333;
        System.out.println("Running socket server-side in port: "+port.toString());
        String line;
        Integer in_age;

        try {

            ServerSocket ss = new ServerSocket(port);
            try {
                p = new Precio();
                while(true){
                    Socket s = ss.accept();
                    System.out.println(s);

                    InputStream value   = s.getInputStream();
                    DataInputStream din = new DataInputStream(value);

                    try {
                        String received = (String)din.readUTF();  
                        JSONObject received_json = new JSONObject(received);
                        
                        String age_str  = (String)received_json.get("age");
                        String f_name   = (String)received_json.get("name");
                        String l_name   = (String)received_json.get("lastname");

                        in_age      = Integer.valueOf(age_str);

                        if(in_age > 18){
                            p.pone(in_age);
                            System.out.println("It matches: " + p.da());
                            p.add_member(f_name);
                        }else{
                            System.out.println("The Age has to be more than 18");
                            }}
                    catch(Exception e){
                        System.out.println("Error in while: "+e);
                        }
                    finally {
                        s.close();
                    }
                }
            }finally {
                ss.close();
            }

        }catch(Exception e){
            System.out.println("In class Server: "+ e);
            }

	}
}
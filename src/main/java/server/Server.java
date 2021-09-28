package server;

import org.json.*;

import java.net.*;
import java.io.*;
import java.util.Date;

import server.Precio;
import myinterface.Interface;

public class Server {
    public static Precio p;

	public static void start(){
		final Integer port = 3333;
        System.out.println("Running socket server-side in port: "+port.toString());
        String line;
        Integer in_age;
        Double in_x;
        Double in_y;

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

                        JSONObject user = received_json.getJSONObject("user");
                        JSONObject coo  = received_json.getJSONObject("coordinates");

                        String example_json = (String) received_json.get("example");
                        
                        String f_name   = (String) user.get("name");
                        String age_str  = (String) user.get("age");
                        String l_name   = (String) user.get("lastname");

                        String x    = (String) coo.get("x");
                        String y    = (String) coo.get("y");

                        in_age      = Integer.valueOf(age_str);
                        in_x        = Double.valueOf(x);
                        in_y        = Double.valueOf(y);

                        if(in_age > 18){
                            p.pone(in_age);
                            System.out.println("Perfect, you are more than 18: " + p.da());
                            p.add_member(f_name);
                        }else{
                            System.out.println("The Age has to be more than 18");
                            }
                    }
                    catch(Exception e){
                        System.out.println("Error in while: "+e);
                        }
                }
            }catch(Exception e){
                System.out.println(e);
            }
            finally {
                ss.close();
            }

        }catch(Exception e){
            System.out.println("In class Server: "+ e);
            }

	}
}
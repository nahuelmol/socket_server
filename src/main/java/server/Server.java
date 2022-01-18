package server;

import org.json.*;

import java.net.*;
import java.io.*;
import java.util.Date;

import server.Precio;
import myinterface.Interface;

import db.Conn;
import db.Check;

public class Server {
    public static Precio p;

	public static void start(){

		final Integer port = 3333;
        System.out.println("Running socket server-side in port: "+port.toString());

        
        Check checking = new Check(Conn.handle());
        checking.forTables();

        String line;
        Integer in_age;
        String aux;

        try {

            ServerSocket ss = new ServerSocket(port);
            try {
                p = new Precio();
                while(true){
                    Socket s = ss.accept();

                    InputStream value   = s.getInputStream();
                    DataInputStream din = new DataInputStream(value);

                    try {
                        String received = (String)din.readUTF();  
                        JSONObject received_json = new JSONObject(received);

                        JSONObject user = received_json.getJSONObject("user");
                        JSONObject coo  = received_json.getJSONObject("coordinates");

                        String f_name   = (String) user.get("name");
                        String age_str  = (String) user.get("age");
                        String l_name   = (String) user.get("lastname");

                        aux = f_name + " "+ l_name;

                        String x    = (String) coo.get("x");
                        String y    = (String) coo.get("y");

                        in_age      = Integer.valueOf(age_str);

                        if(in_age > 18){
                            p.pone(in_age, f_name);
                            p.add_member(f_name);
                            p.change_coordinates(x, y);
                            p.show_coo();
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
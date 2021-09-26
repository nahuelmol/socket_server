package com.mkyong.hashing;

import org.json.*;

import java.net.*;
import java.io.*;
import java.util.Date;

import server.Server;
import myinterface.Interface;

public class App {
    public static void main( String[] args ){	
    	
        Interface.main();

        Server.start();
    }
}

package threaded;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.Color;
import java.net.Socket;
import java.io.Serializable;
class HandleAClient implements Runnable  {
	
	
	
	
	private Socket socket; // A connected socket
 
   	private ObjectInputStream inputFromClient;
   
   	private ObjectOutputStream outputToClient;
   
 
   	public HandleAClient(Socket socket) {
         	this.socket = socket;
   	}
 
  
 
   	public void run() {
         	try {
                	// Create data input and output streams
         		inputFromClient = new  ObjectInputStream(socket.getInputStream()); //input stream
         		
         	    outputToClient = new ObjectOutputStream(socket.getOutputStream()); //output stream
                
         	
         	
// Continuously serve the client
                	while (true) {
                   
                		// Receive radius from the client
                	
						try {
							Machine machine = (Machine) inputFromClient.readObject();
							//send to client the resault
							outputToClient.writeObject(machine.averageColor(machine));
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
          
            
                	
 
                	}
         	} catch (IOException e) {
                	System.err.println(e);
         	}
   	}
}
 


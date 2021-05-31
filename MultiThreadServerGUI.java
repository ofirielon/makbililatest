package threaded;

import java.io.*;
import java.io.Serializable;
import java.net.*;

import java.util.*;
import java.awt.*;
import javax.swing.*;
 
public class MultiThreadServerGUI extends JFrame {
 
   	private JTextArea jta = new JTextArea();
   	// private Server server = new Server();
   	private ServerSocket serverSocket;
   	Socket socket;
 
   	public static void main(String[] args) {
         	new MultiThreadServerGUI();
   	}
 
   	public MultiThreadServerGUI() {
         	// Place text area on the frame
         	setLayout(new BorderLayout());
         	add(new JScrollPane(jta), BorderLayout.CENTER);
         	setTitle("MultiThreadServer");
         	setSize(500, 300);
         	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         	setVisible(true); // It is necessary to show the frame here!
 
         	jta.append("MultiThreadServer started at " + new Date() + '\n');
 
         	int clientNo = 1;
         	try {
                	serverSocket = new ServerSocket(8000);
         	} catch (IOException e1) {
                	// TODO Auto-generated catch block
                	e1.printStackTrace();
         	}
         	while (true) {
                	// Listen for a new connection request
                	try {
 
                       	socket = serverSocket.accept();
                	} catch (IOException e) {
                       	// TODO Auto-generated catch block
                       	e.printStackTrace();
                	}
 
                	// Display the client number
                	jta.append("Starting thread for client " + clientNo + " at " + new Date() + '\n');
 
                	// Find the client's host name, and IP address
                	InetAddress inetAddress = socket.getInetAddress();
                	jta.append("Client " + clientNo + "'s host name is " + inetAddress.getHostName() + "\n");
                	jta.append("Client " + clientNo + "'s IP Address is " + inetAddress.getHostAddress() + "\n");
 
                	// Create a new task for the connection
                	Thread task = new Thread(new HandleAClient(socket));
                	task.start();
                	clientNo++;
         	}
   	}
}


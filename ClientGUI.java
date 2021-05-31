package threaded;
import java.io.Serializable;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 import java.util.*;
public class ClientGUI extends JFrame {
 	private JTextArea jta2 = new JTextArea();
   	private Client client = new Client();
   	Machine machinel;
   	private JTextField textField;
   	private JTextField textField_1;
 private  	JPanel panel_3 = new JPanel();
 private JScrollPane scrollPane = new JScrollPane();

   	public static void main(String[] args) {
   		
         	new ClientGUI();
         	
        
   	}
 
   	public ClientGUI() {
         String color1;
         String color2;
   		JPanel p = new JPanel();
         	p.setLayout(new BorderLayout());
         	getContentPane().setLayout(new BorderLayout());
         	getContentPane().add(p, BorderLayout.NORTH);
         	
         	JPanel panel = new JPanel();
         	p.add(panel, BorderLayout.SOUTH);
         	
         	JLabel lblNewLabel = new JLabel("ENTERCOLOR1");
         	panel.add(lblNewLabel);
         	
         	textField = new JTextField();
         	panel.add(textField);
         	textField.setColumns(10);

         
         	getContentPane().add(scrollPane, BorderLayout.CENTER);
         	
         	JPanel panel_1 = new JPanel();
         	scrollPane.setColumnHeaderView(panel_1);
         	
         	JLabel lblNewLabel_1 = new JLabel("ENTER COLOR2");
         	panel_1.add(lblNewLabel_1);
         	
         	textField_1 = new JTextField();
         	panel_1.add(textField_1);
         	textField_1.setColumns(10);
         	
         	JButton btnNewButton_1 = new JButton("SEND");
         	panel_1.add(btnNewButton_1);
         	btnNewButton_1.addActionListener(new ButtonListener());

         	JPanel panel_2 = new JPanel();
         	scrollPane.setRowHeaderView(panel_2);
         	
         	JLabel lblNewLabel_3 = new JLabel("YOUR COLOR IS");
         	panel_2.add(lblNewLabel_3);
         	
         	JLabel lblNewLabel_2 = new JLabel("THE COLOR");
         	panel_2.add(lblNewLabel_2);
         	
         	
         	setTitle("Client");
         	setSize(500, 300);
         	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         	setVisible(true);
         	
        	
   	}

 	private class ButtonListener implements ActionListener {
 

		public void actionPerformed(ActionEvent e) {
          String 	color1 =(String)textField.getText();
          String	color2 =(String)textField_1.getText();
     if (color1.equals("red")|color1.equals("yellow")||color1.equals("green")||color1.equals("white")||color1.equals("purple")||color1.equals("pink")||color1.equals("orange")||color1.equals("gray")||color1.equals("green")||color1.equals("cyan")||color1.equals("pink")||color1.equals("brown")||color1.equals("maroon")||color1.equals("blue")||color1.equals("black")) {
    	 if (color2.equals("red")|color1.equals("yellow")||color2.equals("green")||color2.equals("white")||color2.equals("purple")||color2.equals("pink")||color2.equals("orange")||color2.equals("gray")||color2.equals("green")||color2.equals("cyan")||color2.equals("pink")||color2.equals("brown")||color2.equals("maroon")||color2.equals("blue")||color2.equals("black")) {
    	 Machine machine1=new Machine(color1,color2); 

		//send user data to server
            	client.writeToServer(machine1);

//Get resault from the server
            Machine resault =(Machine) client.readFromServer();
          
           //update the resault color
            panel_3.setBackground(resault.c3);
            scrollPane.setViewportView(panel_3);
    	 }
    	 else {
    		 new Eror ();
    	 }
     }
     else {
		 new Eror ();
	 }
     	}
	}

}
 


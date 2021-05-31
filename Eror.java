package threaded;

import javax.swing.JFrame;
import java.io.Serializable;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 import java.util.*;
public class Eror extends JFrame {
	public Eror( ) {
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  unsuported color");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(10, 11, 408, 239);
		getContentPane().add(lblNewLabel);
		setVisible(true);
		
	}
}

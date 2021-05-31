package threaded;
import java.io.Serializable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
 
class Client {
 
   	// IO streams
   	private static  ObjectOutputStream toServer;
   	private static ObjectInputStream fromServer;
 
   	private Socket socket;
   	public Client() {
 
         	try {
                	// Create a socket to connect to the server
                	socket = new Socket("localhost", 8000);
                	// Create an output stream to send data
                	// to the server
                	toServer = new ObjectOutputStream(socket.getOutputStream());
 
                	// Create an input stream to receive data
                	// from the server
                	fromServer = new ObjectInputStream(socket.getInputStream());
 
         	} catch (IOException ex) {
         	}
   	}
 
   	public void writeToServer(Machine machine )  {
   		try {

                	toServer.writeObject(machine);
                	toServer.flush();
   		} catch (IOException e) {
        	e.printStackTrace();
 	}

         	} 
   	
 
   	public Object readFromServer() {
   		try {
                	
						try {
							return fromServer.readObject();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
   		}catch (IOException e) {
        	e.printStackTrace();
 	}
		return socket;
					
}
}

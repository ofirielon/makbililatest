package threaded;

import java.awt.Color;
import java.io.Serializable;

public  class Machine implements Serializable {
	
public	Color c1;
public 	Color c2;
public Color c3;
	public  Machine(String color1,String color2) { //constructor recive to strings

	

c1= SetbColor(color1);
c2=SetbColor(color2);
	};

	
public void setcolor(String color1,String color2) { //color mix method

}
synchronized Machine averageColor(Machine machine ) {
	int c1r =this.c1.getRed(), c1g = this.c1.getGreen(), c1b = this.c1.getBlue();
	int c2r = this.c2.getRed(), c2g = this.c2.getGreen(), c2b = this.c2.getBlue();

this.c3= new Color((int) ((c1r + c2r) / 2), (int) ((c1g + c2g) / 2), (int) ((c1b + c2b) / 2));
return machine;

	

}
public Color SetbColor(String color) { //return the right color by user input
	if(color.equals("red")) {
		return new Color(255,0,0);
					}


				
	 if(color.equals("yellow")) {
	return new Color(255,255,0);
				}


	 if(color.equals("green")) {
	return new Color(0,128,0);
				}


			


	 if(color.equals("white")) {
return new Color(255,255,255);
			}


 if(color.equals("purple")) {
	return new Color(128,0,128);
			}


	 if(color.equals("pink")) {
	return new Color(255,192,203);
			}


	 if(color.equals("orange")) {
	return new Color(255,165,0);
			}


	 if(color.equals("gray")) {
	return new Color(128,128,128);
			}


	 if(color.equals("cyan")) {
	return new Color(0,255,255);
			}


	 if(color.equals("brown")) {
	return new Color(165,42,42);
			}


	 if(color.equals("maroon")) {
	return new Color(128,0,0);
			}


	 if(color.equals("blue")) {
	return new Color(0,0,255);
			}


	 if(color.equals("black")) {
	return new Color(0,0,0);
			}

	return null;

};
}


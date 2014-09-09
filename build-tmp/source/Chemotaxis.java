import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 Bacteria edward;//declare bacteria variables here   
 Food poop = new Food();
 boolean bacteriaChangeColor = false;
 public void setup()   
 {     
 	size(500,500);//initialize bacteria variables here   
 	background(0);
 	edward = new Bacteria(250,250,255,255,255);
 }   
 public void draw()   
 {
 	frameRate(10);
 	background(0);
 	poop.show();
 	edward.move();//move and show the bacteria 
 	edward.show();  
 }  
 public void mouseClicked()
 {
 	poop.newFoodLocation();
 }
 class Bacteria    
 {     
 	int myX;
 	int myY;
 	int r;
 	int g;
 	int b;
 	Bacteria(int x, int y, int c1, int c2, int c3)
 	{
 		myX = x;
 		myY = y;
 		r = c1;
 		g = c2;
 		b = c3;
 	}
 	public void move()
 	{
 		if (myX < poop.foodx)
 		{
 			myX = myX + (int)(Math.random()*6-2);
 			if (myY < poop.foody)
 			{
 				myY = myY + (int)(Math.random()*6-2);
 			}
 			else
 			{
 				myY = myY + (int)(Math.random()*6-4);
 			}
 		}
 		else if (myX > poop.foodx)
 		{
 			myX = myX + (int)(Math.random()*6-4);
 			if (myY < poop.foody)
 			{
 				myY = myY + (int)(Math.random()*6-2);
 			}
 			else
 			{
 				myY = myY + (int)(Math.random()*6-4);
 			}
 		}
 		else
 		{
 			myX = myX + (int)(Math.random()*6-3);
 			myY = myY + (int)(Math.random()*6-3);
 		}

 	}
 	public void show()
 	{
 		noStroke();
 		if (bacteriaChangeColor == true)
 		{
 			r = poop.r;
 			g = poop.g;
 			b = poop.b;
 			bacteriaChangeColor = false;
 		}
 		fill(r,g,b);
 		ellipse(myX,myY,20,20);
 		int myX2 = myX+(int)(Math.random()*30-15);
 		int myY2 = myY+(int)(Math.random()*30-15);
 		ellipse(myX2,myY2,20,20);
 		ellipse(myX2+(int)(Math.random()*30-15),myY2+(int)(Math.random()*30-15),20,20);
 	}    
 }
 class Food
 {
 	int foodx;
 	int foody;
 	int r,g,b;
 	Food()
 	{
 		foodx = 250;
 		foody = 250;
 		r = 0;
 		g = 0;
 		b = 0;
 	}
 	public void newFoodLocation()
 	{
 		foodx = mouseX;
 		foody = mouseY;
 		r = (int)(Math.random()*256);
 		g = (int)(Math.random()*256);
 		b = (int)(Math.random()*256);
 	}
 	public void show()
 	{
 		noStroke();
 		fill(r,g,b);
 		ellipse(foodx, foody, 10, 10);
 		if ((edward.myX == foodx) && (edward.myY == foody))
 		{
 			foodx = 250;
 			foody = 250;
 			bacteriaChangeColor = true;
 			r = 255;
 			g = 255;
 			b = 255;
 		}
 	}
 }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

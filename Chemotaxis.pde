 Bacteria edward;//declare bacteria variables here   
 Food poop = new Food();
 boolean bacteriaChangeColor = false;
 boolean foodReset = false;
 void setup()   
 {     
 	size(500,500);//initialize bacteria variables here   
 	background(0);
 	edward = new Bacteria(250,250,255,255,255);
 }   
 void draw()   
 {
 	frameRate(10);
 	background(0);
 	poop.show();
 	edward.move();//move and show the bacteria 
 	edward.show();  
 }  
 void mouseClicked()
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
 	void move()
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
 	void show()
 	{
 		noStroke();
 		if (bacteriaChangeColor == true)
 		{
 			r = poop.r;
 			g = poop.g;
 			b = poop.b;
 			bacteriaChangeColor = false;
 			foodReset = true;
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
 	void newFoodLocation()
 	{
 		foodx = mouseX;
 		foody = mouseY;
 		r = (int)(Math.random()*256);
 		g = (int)(Math.random()*256);
 		b = (int)(Math.random()*256);
 	}
 	void show()
 	{
 		noStroke();
 		fill(r,g,b);
 		ellipse(foodx, foody, 10, 10);
 		if ((edward.myX == foodx) && (edward.myY == foody))
 		{
 			foodx = -500;
 			foody = -500;
 			bacteriaChangeColor = true;
 		}
 		if (foodReset == true)
 		{
 			foodx = 250;
 			foody = 250;
 			
 		}
 	}
 }
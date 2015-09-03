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

public class Lightning extends PApplet {

TheLightning l[] = new TheLightning[9001];
int count = 0;
int boltCount = 1;

public void setup()
{
	size(500, 500);
	background(0);
	frameRate(10);
}

public void draw()
{
	for (int i = 0; i < l.length; i++)
	{
		if (l[i] != null)
		{
			while(l[i].startY < height && l[i].startX < width && l[i].startX > 0)
			{
				l[i].show();
			}
		}
	}
	fill(0, 0, 0, 50);
	rect(-100, -100, 700, 700);
}

public void mouseClicked()
{
	for (int i = 0; i < boltCount; i++)
	{
		stroke(random(256), random(256), random(256));
		l[count] = new TheLightning(mouseX, 0, mouseX + ((int)(Math.random()*20)-10), (int)(Math.random()*10));
		count++;
		if (count >= l.length)
		{
			count = 0;
		}
	}
}

public void keyPressed()
{
	if (key == ' ')
	{
		boltCount++;
		if (boltCount > 100)
		{
			boltCount = 1;
		}
	}
}

class TheLightning
{
	int startX, startY, endX, endY;
	TheLightning(int startX, int startY, int endX, int endY)
	{
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY; 
	}
	public void show()
	{
		line(startX, startY, endX, endY);
		startX = endX;
		startY = endY;
		endX += ((int)(Math.random()*20)-10);
		endY += (int)(Math.random()*10);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightning" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

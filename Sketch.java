import processing.core.PApplet;

public class Sketch extends PApplet {

  boolean sunMouse = false;
  char screenLetter = ' ';


  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(173, 216, 230);
    textSize(30);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
    if (sunMouse == false) {
      background(173, 216, 230);
    }
    else if (mouseY <= 150 && sunMouse == true) {
      background(173, 216, 230);
    }
    else if (mouseY > 150 && mouseY < 300 && sunMouse == true) {
      background(254, 102, 7);
    }
    else if (mouseY > 300 && sunMouse == true) {
      background(0);
    }

    
     // sun mouse
    if (mouseX >= 50 && mouseY >= 0 && mouseX <= 150 && mouseY <= 100 && sunMouse == false) 
    {
      if (mousePressed == true) {
        sunMouse = true;
        System.out.println("sunMouse " + sunMouse);
        mousePressed = false;
      }
      else {}
    }
    else {}
    
    
     // sun mouse reversion
    if (sunMouse == true && mousePressed == true)
    {
      sunMouse = false;
      System.out.println("sunMouse " + sunMouse);
    }

    
     // sun method
    if (sunMouse == false) {
      sun(100, 50, 255, 233, 0);
    }
    else if (sunMouse == true) {
      sun(mouseX, mouseY, 255, 233, 0);
    }

    
     // house method 1
    house(100, 50, 400);

    
    if (keyPressed) 
    {
      if (key == ' ')
      {
        System.out.println("keyPressed");
        if (sunMouse == false) {
           // Rectangle for grass
          fill(218, 160, 109); // Brown
          rect(0, 300, 400, 100);
        }
        else if (mouseY <= 150 && sunMouse == true) {
           // Rectangle for grass
          fill(218, 160, 109); // Brown
          rect(0, 300, 400, 100);
        }
        else if (mouseY > 150 && mouseY < 300 && sunMouse == true) {
           // Rectangle for grass
          fill(255); // White
          rect(0, 300, 400, 100);
        }
        else if (mouseY > 300 && sunMouse == true) {
          background(218, 112, 214);
        }
      }
      
    }
    else {
       // Rectangle for grass
      fill(86, 125, 70); // Green
      rect(0, 300, 400, 100);
    }

     // Text on screen
    fill(0); // Black
    text(screenLetter, 5, height/2);


  }

  
   // defining methods.
  /**
  * Depiction of a house at the coordinates and custom scaled
  *
  * @param housex  The x coordinate of the house (default: 100)
  * @param housey  The y coordinate of the house (default: 50)
  * @param scale  The scale of the house (default: 400)
  *
  */
  private void house(int housex, int housey, int scale) 
  {
     // Base square for house
    fill(255, 248, 220); // White
    rect(housex, housey+(scale/8), (scale/2), (scale/2));

     // Triangle for roof
    fill(170, 1, 20); // Red
    triangle(housex, housey+(scale/8), housex+(scale/4), housey, housex+(scale/2), housey+(scale/8));

     // Rectangle for door
    fill(196, 164, 132); // Light brown
    rect(housex+(scale/4), housey+((scale/4)+(scale/8)), (scale/8), (scale/4));
  }

  
  /**
  * Depiction of the sun at the coordinates and custom scaled and custom colour
  *
  * @param sunx  The x coordinate of the ssun (default: 100)
  * @param suny  The y coordinate of the sun (default: 50)
  * @param scale  The scale of the sun (default: 400)
  * @param sunRed  The red value for the colour of the sun (default: 255)
  * @param sunGreen  The green value for the colour of the sun (default: 233)
  * @param sunBlue  The blue value for the colour of the sun (default: 0)
  *
  */
  private void sun(int sunx, int suny, int sunRed, int sunGreen, int sunBlue) 
  {
     // Circle to repersent the sun
    fill(sunRed, sunGreen, sunBlue); // Yellow
    ellipse(sunx, suny, (width/4), (height/4));
  }

  
  public void mouseWheel() {
    System.out.println("mouseWheel");
    background(0);
  }

  public void keyTyped() {
    System.out.println("keyTyped");
    screenLetter += key;
  }


}
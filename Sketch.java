import processing.core.PApplet;

public class Sketch extends PApplet {

  float fltCellWidth = 20;
  float fltCellHeight = 20;
  float fltCellMargin = 5;

  int intRowCount = 10;
  int intColumnCount = 10;

  float fltScreenWidth = fltCellWidth * intColumnCount + (fltCellMargin * (intColumnCount+1));
  float fltScreenHeight = fltCellHeight* intRowCount + (fltCellMargin * (intRowCount+1));

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(500, 600);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0, 0, 0);

    for(int column = 0; column < intColumnCount; column++){
      rect(column * fltCellWidth + fltCellMargin, 0, fltCellWidth, fltCellHeight);
    }







  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

	  
  }

  public void mousePressed(){
    
  }
}

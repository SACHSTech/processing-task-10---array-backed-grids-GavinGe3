import processing.core.PApplet;

public class Sketch extends PApplet {


  float fltCellWidth = 20;
  float fltCellHeight = 20;
  float fltCellMargin = 5;

  int intRowCount = 10;
  int intColumnCount = 10;

  float fltScreenWidth = fltCellWidth * intColumnCount + (fltCellMargin * (intColumnCount+1));
  float fltScreenHeight = fltCellHeight* intRowCount + (fltCellMargin * (intRowCount+1));

  int intmouseXInGrid = 0;
  int intmouseYInGrid = 0; 

  int [][] intGrid = new int[intRowCount][intColumnCount];

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(255, 255);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    intGrid[5][1] = 1;
    background(0, 0, 0);
    

   
    }



  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    for(int column = 0; column < intColumnCount; column++){
      for (int row = 0; row < intRowCount; row++){

        intGrid[intmouseXInGrid][intmouseYInGrid] = 1;
        if (intGrid[column][row] == 1){
          fill(0,128,0);
        }
        else{
          fill(255,255,255);
        }
        rect(fltCellMargin + column * (fltCellWidth + fltCellMargin), fltCellMargin + row * (fltCellHeight + fltCellMargin), fltCellWidth, fltCellHeight);
      }
    }
      
    
    


	  
  }

  public void mousePressed(){
    if (mousePressed){
      System.out.println("click");
      System.out.println(mouseX + mouseY);
      intmouseXInGrid = mouseX / (int)(fltCellWidth + fltCellMargin);
      intmouseYInGrid = mouseY / (int)(fltCellHeight + fltCellMargin);
    }
    

    
  }
}

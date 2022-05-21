import org.w3c.dom.events.MouseEvent;

import processing.core.PApplet;

/**
 * Draw 10 by 10 grid using 2d array, with color change functionality determined by mouse pressed
 * @author: G. Ge
 */

public class Sketch extends PApplet {

  // Cell variables
  int intCellWidth = 20;
  int intCellHeight = 20;
  int intCellMargin = 5;

  int intRowCount = 10;
  int intColumnCount = 10;

  // Screen size variables
  int fltScreenWidth = intCellWidth * intColumnCount + (intCellMargin * (intColumnCount+1));
  int fltScreenHeight = intCellHeight* intRowCount + (intCellMargin * (intRowCount+1));

  // Variables for mouse grid location 
  int intmouseXInGrid;
  int intmouseYInGrid; 
  // Number of cells turned green
  int cellsSelected;

  // Variables for determining number of cells selected in columns, rows, and continues blocks in rows
  int intColumnSelectedCount;
  int intRowSelectedCount;
  int intContinuousCellCount;
  int intRowCellSelectedMax;
  
  
  // bool for mousepressed
  boolean boolIfPressed = false;

  // 2d array for grid
  int [][] intGrid = new int[intColumnCount][intRowCount];

  /**
   * Setup screen size
   */
  public void settings() {
    // put your size call here
    size(fltScreenWidth, fltScreenHeight );
  }

  /** 
   * Setup background color to be black
   */
  public void setup() {
    background(0, 0, 0);
    }

  /**
   * Draws 10 x 10 grid to the screen, and prints number of selected blocks in rows, columns, and continuous blocks in rows
   */
  public void draw() {

    // Draws a 10 x 10 grid to the screen, determines the cell color by the cells value of either 1 for green or 0 for white
    for(int column = 0; column < intColumnCount; column++){
      for (int row = 0; row < intRowCount; row++){
        // if cell value is 1 draw green cell
        if (intGrid[column][row] == 1){
          fill(0,128,0);
          rect(intCellMargin + column * (intCellWidth + intCellMargin), intCellMargin + row * (intCellHeight + intCellMargin), intCellWidth, intCellHeight);
        }
        // if cell value is 0 draw white cell
        else {
          fill(255,255,255);
          rect(intCellMargin + column * (intCellWidth + intCellMargin), intCellMargin + row * (intCellHeight + intCellMargin), intCellWidth, intCellHeight);
        }
      }
  }

  // If user presses grid
  if (boolIfPressed){
    // Prints number of selected blocks in columns
    for(int column = 0; column < intColumnCount; column++){
      for (int row = 0; row < intRowCount; row++){
        // For each green cell add 1 to the column count
        if (intGrid[column][row] == 1){
          intColumnSelectedCount++;
        }
      }
      // Prints # of green cells in column and resets count
      System.out.println("Column " + (column + 1) + " has " + intColumnSelectedCount + " cells selected.");
      intColumnSelectedCount = 0;
    }
    // Determines number of selected blocks and continuous blocks in rows
    for (int row = 0; row < intRowCount; row++){

        int intRowSelectedCount = 0;
        int intContinuousCellCount = 0 ;
        int intRowCellSelectedMax = 0;

      for (int column = 0; column < intColumnCount; column++){
        // For each green cell add 1 to the row count and continuous rowcount
        if (intGrid[column][row] == 1){
          intRowSelectedCount++;
          intContinuousCellCount++;
          // if Current continuous cell row count is greater than the max, replace the max
          if (intContinuousCellCount > intRowCellSelectedMax){
            intRowCellSelectedMax = intContinuousCellCount;
          }
        }
        // if grid is white, then reset the continuous cell count
        else {
          intContinuousCellCount = 0;
        }
        
        // Note: This code is for if we are counting all continuous chains of blocks not the longest chain of blocks in a row

        /**
        if (column < intColumnCount - 1){
          if (intGrid[column][row] == 1 && intGrid[column+1][row] == 1){
            intContinuousCellCount++;
          }
        if (column > 0 && column < intColumnCount){
          if(intGrid[column][row] == 1 && intGrid[column-1][row] == 1 && column == intColumnCount - 1){
            intContinuousCellCount++;
          }
          else if (intGrid[column][row] == 1 && intGrid[column-1][row] == 1 && intGrid[column+1][row] == 0 && column < intColumnCount - 1 ){
            intContinuousCellCount++;
          }
          if (intGrid[column][row] == 1 && intGrid[column-1][row] == 1 && intGrid[column+1][row] == 0  )
         */
        
      }

    // prints number of selected blocks and continuous blocks in rows
    if (intRowCellSelectedMax > 2){
      System.out.println("There are " + intRowCellSelectedMax + " continuous cells selected in row " + (row+1) + ".");
      intRowCellSelectedMax = 0;
      intContinuousCellCount = 0;
    }
    System.out.println("Row " + (row + 1) + " has " + intRowSelectedCount + " cells selected.");
    intRowSelectedCount = 0;
    }
    // Changes pressed variable to false
    boolIfPressed = false;
  }
}


  /** 
   * Detects if mouse is pressed and changes cell colors of array backged grid based on presses
   */
  public void mousePressed(){
    
      // converts mouse location to grid coordinates and prints it out
      intmouseXInGrid = mouseX / (int)(intCellWidth + intCellMargin);
      intmouseYInGrid = mouseY / (int)(intCellHeight + intCellMargin);
      System.out.println("click");
      System.out.println("The Grid coordinates are (" + (intmouseXInGrid+1) + ", " + (intmouseYInGrid+1) + ").");
      System.out.println("The mouse coordinates are (" + mouseX + ", " + mouseY + ").");

      // Variable to determine if mouse is pressed

      boolIfPressed = true;
      
      // Changes the color of cell based on mousepressed location
      for(int row = 0; row < intColumnCount; row++){
        for (int column = 0; column < intRowCount; column++){
          if (intmouseXInGrid == column && intmouseYInGrid == row){

            // Center Cell
            if (intGrid[column][row] == 0){
              intGrid[column][row] = 1;
              cellsSelected ++;
            }

            else if (intGrid[column][row] == 1){
              intGrid[column][row] = 0;
              cellsSelected --;
            }

            // Right Cell
            if (column < (intColumnCount-1) && intGrid[column+1][row] == 0 ){
              intGrid[column+1][row] = 1;
              cellsSelected ++;
            }

            else if (column < (intColumnCount -1) && intGrid[column+1][row] == 1){
              intGrid[column+1][row] = 0;
              cellsSelected --;
            }

            // Left Cell
            if (column > 0 &&intGrid[column-1][row] == 0 ){
              intGrid[column-1][row] = 1;
              cellsSelected ++;
            }

            else if (column > 0 && intGrid[column-1][row] == 1 ){
              intGrid[column-1][row] = 0;
              cellsSelected --;
            }

            // Top Cell
            if (row > 0 && intGrid[column][row-1] == 0){
              intGrid[column][row - 1] = 1;
              cellsSelected ++;
            }

            else if (row  > 0 && intGrid[column][row-1] == 1){
              intGrid[column][row - 1] = 0;
              cellsSelected --;
            }

            // Bottom Cell
            if (row < (intRowCount-1) && intGrid[column][row+1] == 0){
              intGrid[column][row + 1] = 1;
              cellsSelected ++;

            }
            else if (row < (intRowCount-1) && intGrid[column][row+1] == 1 ){
              intGrid[column][row + 1] = 0;
              cellsSelected --;

            }
            // Print out the # of cells selected
            System.out.println("There are " + cellsSelected + " cells selected.");
          }
        }
      }
    }
}
    
  
    
    

    

    
  



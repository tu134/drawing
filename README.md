# Simple Console Drawing Program #

### Description of Test Assignment ###

You're given the task of writing a simple console version of a drawing program. At this time, the functionality of the program is quite limited but this might change in the future.
 
In a nutshell, the program should work as follows:

* Create a new canvas
* Start drawing on the canvas by issuing various commands
* Quit  

| Command 		      | Description
----------------------|------------------------------------------------------------------------------
| C w h               | Should create a new spread sheet of width w and height h (i.e. the spreadsheet can hold w * h amount of cells).  
| L x1 y1 x2 y2       | Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.
| R x1 y1 x2 y2       | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.
| B x y c             | Should fill the entire area connected to (x,y) with "colour" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs.
| Q                   | Should quit the program. 

Assume each cell will allocate at most 3 characters, thus numbers given here should be right justified accordingly.

### The Solution ###

I was using `IDEA` to build and run main app and unit-tests.

The main code having no much complexity which may call for extra comments or documentation and usage is illustrated by unit-tests and main app itself. 
I was trying to balance and not to slip to over-design and over-commenting.  

Assumptions. The application does not prompt the user when lines (wholly or partially) are drawn beyond the visible area. The visible part only will be drawn in this case.     
 
### Build and run ###

You can use IDEA or Maven to run main app and unit-tests. (I was using Java 12)
*  IDEA. The main app and unit-tests can be built and ran in the usual way in IDEA
*  Maven run main app: `mvn exec:java`, unit-tests: `mvn test`, create JAR: `mvn package`
*  Run pre-built jar from command line `java -jar console-drawing-1.0.jar`

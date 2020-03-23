# Simple Console Drawing Program #

### Description of Test Assignment ###

You're given the task of writing a simple console version of a drawing program. At this time, the functionality of the program is quite limited but this might change in the future.
 
In a nutshell, the program should work as follows:

* Create a new canvas
* Start drawing on the canvas by issuing various commands
* Quit  

| Command 		      | Description
----------------------|------------------------------------------------------------------------------
| C w h               | Should create a new canvas of width w and height h.
| L x1 y1 x2 y2       | Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.
| R x1 y1 x2 y2       | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.
| B x y c             | Should fill the entire area connected to (x,y) with "colour" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs.
| Q                   | Should quit the program. 

### The Solution ###

The main code having no much complexity which may call for extra comments or documentation and usage is illustrated by unit-tests and main app itself. I was using `Java 12` and `JUnit 4`.

Assumptions. The application does not prompt the user when lines (wholly or partially) are beyond the visible area. Only visible part will be drawn in this case.
 
### Build and run ###

*  `mvn package` to build jar and run unit-tests in one go
*  `java -jar target\console-drawing-1.0.jar` to run interactive console app 

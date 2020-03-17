package com.company.drawing;

import com.company.drawing.commands.*;
import com.company.drawing.canvas.TextCanvas;
import com.company.drawing.exceptions.CommandArgumentsException;
import com.company.drawing.exceptions.CommandInvalidException;
import com.company.drawing.exceptions.ExitCommandException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TextCanvas textCanvas = new TextCanvas();
        CommandFactory commandFactory = new CommandFactory(textCanvas);
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.print("enter command: ");
            String line = in.nextLine();
            if(line == null) break;
            try {
                Command command = commandFactory.getCommand(line);
                if(command == null) continue;
                command.execute();

                System.out.println(textCanvas.toString());
            } catch (CommandInvalidException e) {
                System.out.println(String.format("You entered invalid command."));
            } catch (CommandArgumentsException e) {
                System.out.println(String.format("Invalid arguments for command."));
            } catch (ExitCommandException e) {
                System.out.println(String.format("Exiting..."));
                break;
            } catch (Exception e) {
                System.out.println(String.format("exception: %s", e.getMessage()));
            }
        }
    }
}

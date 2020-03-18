package com.company.drawing;

import com.company.drawing.canvas.TextGraphics;
import com.company.drawing.commands.*;
import com.company.drawing.drawables.Drawable;
import com.company.drawing.exceptions.CommandArgumentsException;
import com.company.drawing.exceptions.CommandInvalidException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TextGraphics textGraphics = null;
        CommandFactory commandFactory = new CommandFactory();
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.print("enter command: ");
            String line = in.nextLine();
            if(line == null || line.trim().length() == 0) continue;

            Command command;

            try {
                command = commandFactory.getCommand(line);
                if(command instanceof ExitCommand) {
                    System.out.println(String.format("Exiting..."));
                    break;
                }
                if(command instanceof CreateCommand) {
                    CreateCommand createCommand = (CreateCommand)command;
                    textGraphics = new TextGraphics(createCommand.getWidth(), createCommand.getHeight());
                }
                if(command instanceof DrawCommand) {
                    if(textGraphics == null) {
                        System.out.println(String.format("Canvas not created yet."));
                        continue;
                    }
                    DrawCommand drawCommand = (DrawCommand)command;
                    Drawable drawable = drawCommand.getDrawable();
                    textGraphics.addDrawable(drawable);
                }

                System.out.println(textGraphics.toString());
            } catch (CommandInvalidException e) {
                System.out.println(String.format("You entered invalid command."));
            } catch (CommandArgumentsException e) {
                System.out.println(String.format("Invalid arguments for command."));
            } catch (Exception e) {
                System.out.println(String.format("exception: %s", e.getMessage()));
            }
        }
    }
}

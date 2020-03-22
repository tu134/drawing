package com.company.drawing;

import com.company.drawing.canvas.TextCanvas;
import com.company.drawing.canvas.Graphics;
import com.company.drawing.commands.*;
import com.company.drawing.drawables.Drawable;
import com.company.drawing.exceptions.CommandArgumentsException;
import com.company.drawing.exceptions.CommandInvalidException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graphics graphics = null;
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
                    graphics = new Graphics(new TextCanvas(createCommand.getWidth(), createCommand.getHeight()));
                }
                if(command instanceof DrawCommand) {
                    if(graphics == null) {
                        System.out.println(String.format("Canvas not created yet."));
                        continue;
                    }
                    DrawCommand drawCommand = (DrawCommand)command;
                    Drawable drawable = drawCommand.getDrawable();
                    graphics.addDrawable(drawable);
                }

                System.out.println(graphics.toString());
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

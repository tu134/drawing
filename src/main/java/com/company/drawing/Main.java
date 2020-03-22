package com.company.drawing;

import com.company.drawing.canvas.Graphics;
import com.company.drawing.canvas.TextCanvas;
import com.company.drawing.commands.*;
import com.company.drawing.drawables.Drawable;
import com.company.drawing.exceptions.CommandArgumentsException;
import com.company.drawing.exceptions.CommandInvalidException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


    public static void loop(InputStream inputStream, PrintStream out, boolean prompt) {

        Graphics graphics = null;
        CommandFactory commandFactory = new CommandFactory();
        Scanner in = new Scanner(inputStream);

        while(true) {

            if(prompt) {
                out.print("enter command: ");
                out.flush();
            }

            if(!in.hasNextLine()) break;
            String line = in.nextLine();
            if(line == null || line.trim().length() == 0) continue;

            Command command;

            try {
                command = commandFactory.getCommand(line);
                if(command instanceof ExitCommand) {
                    break;
                }
                if(command instanceof CreateCommand) {
                    CreateCommand createCommand = (CreateCommand)command;
                    graphics = new Graphics(new TextCanvas(createCommand.getWidth(), createCommand.getHeight()));
                }
                if(command instanceof DrawCommand) {
                    if(graphics == null) {
                        out.println(String.format("Canvas not created yet."));
                        continue;
                    }
                    DrawCommand drawCommand = (DrawCommand)command;
                    Drawable drawable = drawCommand.getDrawable();
                    graphics.addDrawable(drawable);
                }

                out.println(graphics.toString());
            } catch (CommandInvalidException e) {
                out.println(String.format("You entered invalid command."));
            } catch (CommandArgumentsException e) {
                out.println(String.format("Invalid arguments for command."));
            } catch (Exception e) {
                out.println(String.format("exception: %s", e.getMessage()));
            }
        }
    }

    public static void main(String[] args) {
        loop(System.in, System.out, true);
    }
}

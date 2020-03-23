package com.company.drawing;

import com.company.drawing.canvas.Graphics;
import com.company.drawing.canvas.TextCanvas;
import com.company.drawing.commands.*;
import com.company.drawing.exceptions.CommandArgumentsException;
import com.company.drawing.exceptions.CommandInvalidException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void loop(InputStream inputStream, PrintStream out, boolean prompt) {

        Graphics graphics = null;
        Scanner in = new Scanner(inputStream);

        mainLoop: while(true) {

            if(prompt) {
                out.print("enter command: ");
                out.flush();
            }

            if(!in.hasNextLine()) break;
            String line = in.nextLine();
            if(line == null || line.trim().length() == 0) continue;

            try {
                String[] args = line.split("\\s+");
                String command = args[0];
                args = Arrays.copyOfRange(args, 1, args.length);

                switch (command) {
                    case "C":
                        CreateCommand createCommand = new CreateCommand(args);
                        graphics = new Graphics(new TextCanvas(createCommand.getWidth(), createCommand.getHeight()));
                        break;
                    case "L":
                    case "R":
                    case "B":
                        if(graphics == null) {
                            out.println("Canvas not created yet.");
                            continue mainLoop;
                        }
                        DrawCommand drawCommand = new DrawCommand(command, args);
                        graphics.addDrawable(drawCommand.getDrawable());
                        break;
                    case "Q":
                        break mainLoop;
                    default:
                        throw new CommandInvalidException();
                }

                out.println(graphics.toString());

            } catch (CommandInvalidException e) {
                out.println("You entered invalid command.");
            } catch (CommandArgumentsException e) {
                out.println("Invalid arguments for command.");
            } catch (Exception e) {
                out.println(String.format("exception: %s", e.getMessage()));
            }
        }
    }

    public static void main(String[] args) {
        loop(System.in, System.out, true);
    }
}

package com.company.drawing;

import com.company.drawing.commands.Command;
import com.company.drawing.commands.CommandFactory;
import com.company.drawing.commands.ExitCommand;
import com.company.drawing.canvas.TextCanvas;

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
                if(command instanceof ExitCommand) {
                    break;
                }
                command.execute();

                System.out.println(textCanvas.toString());
            } catch (Exception e) {
                System.out.println(String.format("exception: %s", e.getMessage()));
            }
        }
    }
}

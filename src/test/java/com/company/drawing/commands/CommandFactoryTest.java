package com.company.drawing.commands;

import com.company.drawing.exceptions.CommandInvalidException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandFactoryTest {
    CommandFactory commandFactory;

    @Before
    public void setUp() throws Exception {
        commandFactory = new CommandFactory();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCommandCreate() {
        Command command = commandFactory.getCommand("C 1 2");
        Assert.assertTrue(command instanceof CreateCommand);
    }

    @Test
    public void getCommandLine() {
        Command command = commandFactory.getCommand("L 1 2 2 3");
        Assert.assertTrue(command instanceof LineCommand);
    }

    @Test
    public void getCommandRectangle() {
        Command command = commandFactory.getCommand("R 1 2 2 3");
        Assert.assertTrue(command instanceof RectangleCommand);
    }

    @Test
    public void getCommandFill() {
        Command command = commandFactory.getCommand("B 1 2 x");
        Assert.assertTrue(command instanceof FillCommand);
    }

    @Test
    public void getCommandExit() {
        Command command = commandFactory.getCommand("Q");
        Assert.assertTrue(command instanceof ExitCommand);
    }

    @Test(expected = CommandInvalidException.class)
    public void getCommandUnknown() {
        Command command = commandFactory.getCommand("T 1 2 4");
        Assert.assertTrue(command instanceof ExitCommand);
    }

}
package com.company.drawing.commands;

import org.junit.Assert;
import org.junit.Test;

public class CreateCommandTest {
    @Test
    public void execute() {
        CreateCommand createCommand = new CreateCommand(new String[]{"20", "4"});
        Assert.assertEquals(20, createCommand.getWidth());
        Assert.assertEquals(4, createCommand.getHeight());
    }
}
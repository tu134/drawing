package com.company.drawing.commands;

import com.company.drawing.exceptions.ExitCommandException;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        throw new ExitCommandException();
    }
}


package com.futing.javalib.patterns.action.command.command;

import com.futing.javalib.patterns.action.command.Command;
import com.futing.javalib.patterns.action.command.handler.NewerHandler;

public class NewerCommand extends Command {
    private NewerHandler handler = new NewerHandler();

    @Override
    public String execute() {
        return handler.getNewers();
    }
}

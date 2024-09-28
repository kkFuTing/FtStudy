package com.futing.javalib.patterns.action.command.command;

import com.futing.javalib.patterns.action.command.Command;
import com.futing.javalib.patterns.action.command.handler.HotHandler;

public class HotCommand extends Command {
    private HotHandler handler = new HotHandler();

    @Override
    public String execute() {
        return handler.getHots();
    }
}

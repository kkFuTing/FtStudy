package com.futing.javalib.patterns.action.command.command;

import com.futing.javalib.patterns.action.command.Command;
import com.futing.javalib.patterns.action.command.handler.DiscountHandler;

public class DiscountCommand extends Command {

    private DiscountHandler handler = new DiscountHandler();

    @Override
    public String execute() {
        return handler.getDiscounts();
    }
}

package org.manu.commands;

import org.springframework.stereotype.Component;

@Component("hello")
public class HelloCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Hello world !");
    }
}

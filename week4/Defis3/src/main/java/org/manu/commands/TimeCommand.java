package org.manu.commands;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("time")
public class TimeCommand implements Command{
    @Override
    public void execute() {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(s.format(date));
    }
}

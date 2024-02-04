package com.example.products;

import java.util.Date;

public class HpPrinter implements Printer
{
    @Override
    public void print(final String msg)
    {
        Date start = new Date();

        System.out.println("HP Printer: is running.");

        Date end = new Date();

        long time = end.getTime() - start.getTime();
        System.out.println("It takes " + time + " m(s) to run.");
    }

}

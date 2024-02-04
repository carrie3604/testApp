package com.example.products;

import org.springframework.stereotype.Component;

@Component
public class CanonPrinter implements Printer
{

    @Override
    public void print(final String msg)
    {
        System.out.println("Canon Printer: " + msg);

    }

}

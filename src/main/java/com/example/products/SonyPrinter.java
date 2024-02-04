package com.example.products;

import org.springframework.stereotype.Component;

@Component
public class SonyPrinter implements Printer
{

    @Override
    public void print(final String msg)
    {

        System.out.println("Sony 列印機運行: ");

    }

}

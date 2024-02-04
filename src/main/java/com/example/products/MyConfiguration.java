package com.example.products;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration
{
    @Bean
    public Printer hpPrinter()
    {
        return new HpPrinter();
    }
}

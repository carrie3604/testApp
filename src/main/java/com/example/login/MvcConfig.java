package com.example.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer
{
    /**
     * Configure spring resource-handler to serve custom template resources.
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/js/*.js", "/resources/*.js", "/resources/*.css",
                "/resources/img/*.jpg", "/resources/img/*.png", "/resources/img/*.svg")
                .addResourceLocations("classpath:/templates/default/resources/",
                        "classpath:/templates/default/resources/js/",
                        "classpath:/templates/default/resources/img/",
                        "classpath:/templates/default/resources/fonts/");
    }
}

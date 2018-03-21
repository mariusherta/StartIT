/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.startit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marius.Herta
 */
@Configuration
@ComponentScan(basePackages = "com.orange.startit.*",
        excludeFilters={@Filter(Component.class)})
public class ProjectConfig {
    
}

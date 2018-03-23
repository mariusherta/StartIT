/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.startit.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Alin Preda
 */
public class DirScan {

    private static List<Path> paths = null;
    private static String dirPath = null;
    
    @Bean
    public static void setPath(String dirPath) {
        DirScan.dirPath = dirPath;
    }

    public static Path getTxtPaths() throws IOException {

        paths = Files.walk(Paths.get(dirPath), 1)
                .filter(p -> p.toString().endsWith(".txt"))
                .collect(Collectors.toList());
        return (Path) paths.get(0);
    }

}

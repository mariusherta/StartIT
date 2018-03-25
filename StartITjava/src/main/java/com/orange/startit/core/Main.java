/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.startit.core;

import com.orange.startit.beans.WikiSearch;
import com.orange.startit.config.ProjectConfig;
import com.orange.startit.filemanager.DirScan;
import com.orange.startit.filemanager.FileContent;
import com.orange.startit.filemanager.SearchSubject;
import com.orange.startit.filemanager.exceptions.InvalidFormatException;
import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Marius.Herta
 */
public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
//        DirScan.setPath("C:\\");
//        SearchSubject ss = FileContent.getFileContent(DirScan.getTxtPaths());
        // put(ss);
        
        WikiSearch wikiSearch = new WikiSearch();
        wikiSearch.searchByString("race car");
    }
}

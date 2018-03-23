/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.startit.filemanager;

import com.orange.startit.filemanager.exceptions.InvalidFormatException;
import java.io.IOException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Alin Preda
 */
public class MainTest {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        DirScan.setPath("C:\\");
        SearchSubject ss = FileContent.getFileContent(DirScan.getTxtPaths());
        // put(ss);
    }

}

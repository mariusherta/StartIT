/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.startit.filemanager;

import com.orange.startit.filemanager.exceptions.InvalidFormatException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author Alin Preda
 */
public class FileContent {

    public static SearchSubject getFileContent(Path path) throws IOException, InvalidFormatException {
        Scanner scan = new Scanner(path);
        if (scan.hasNext("[0-9a-zA-Z]*,[0-9a-zA-Z]*")) {
            String line = scan.next();
            scan.close();
            return lineParser(line);
        } else {
            scan.close();
            throw new InvalidFormatException("Continutul fisierului nu corespunde formatului asteptat");

        }
    }

    private static SearchSubject lineParser(String line) {
        String[] lineParts = line.split(",");
        return new SearchSubject(lineParts[0], lineParts[1]);

    }

}

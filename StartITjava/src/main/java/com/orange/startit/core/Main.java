package com.orange.startit.core;

import com.orange.startit.beans.SearchTask;
import com.orange.startit.beans.WikiSearch;
import com.orange.startit.config.ProjectConfig;
import com.orange.startit.executor.TaskExecutor;
import com.orange.startit.filemanager.DirScan;
import com.orange.startit.filemanager.FileContent;
import com.orange.startit.filemanager.SearchSubject;
import com.orange.startit.filemanager.exceptions.InvalidFormatException;
import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
//        DirScan.setPath("C:\\");
//        SearchSubject ss = FileContent.getFileContent(DirScan.getTxtPaths());
//        put(ss);
        
        SearchSubject searchSubject = new SearchSubject("race car", "Wikipedia");
        SearchSubject searchSubject1 = new SearchSubject("ship", "Wikipedia");
        SearchSubject searchSubject2 = new SearchSubject("wreckage", "Wikipedia");
        SearchTask searchTask = new SearchTask(searchSubject);
        SearchTask searchTask1 = new SearchTask(searchSubject1);
        SearchTask searchTask2 = new SearchTask(searchSubject2);
        TaskExecutor taskExecutor = new TaskExecutor();
        taskExecutor.addTask(searchTask);
        taskExecutor.addTask(searchTask1);
        taskExecutor.addTask(searchTask2);
        taskExecutor.executeTasks();
        
    }
}

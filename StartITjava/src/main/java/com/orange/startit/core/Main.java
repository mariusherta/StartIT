package com.orange.startit.core;

import com.orange.startit.beans.WikiSearch;
import com.orange.startit.config.ProjectConfig;
import com.orange.startit.executor.ProcessExecutor;
import com.orange.startit.filemanager.DirScan;
import com.orange.startit.filemanager.FileContent;
import com.orange.startit.beans.SearchSubject;
import com.orange.startit.filemanager.exceptions.InvalidFormatException;
import com.orange.startit.taskFactory.TaskFactory;
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
        SearchSubject searchSubject2 = new SearchSubject("aircraft", "Wikipedia");
        TaskFactory taskFactory = new TaskFactory();
        ProcessExecutor taskExecutor = new ProcessExecutor();
        taskExecutor.addTask(taskFactory.getInstance(searchSubject));
        taskExecutor.addTask(taskFactory.getInstance(searchSubject1));
        taskExecutor.addTask(taskFactory.getInstance(searchSubject2));
        taskExecutor.executeTasks();
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.startit.executor;

import com.orange.startit.beanInterface.Task;
import com.orange.startit.beans.TaskChecker;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProcessExecutor {
    private List<Task> taskList= Collections.synchronizedList(new LinkedList<>());;
    ExecutorService service = Executors.newCachedThreadPool();
    
    public void addTask(Task task){
        taskList.add(task);
    }
    
    @Autowired
    private boolean verifyTask(Task task){
        TaskChecker taskChecker = new TaskChecker();        
        return taskChecker.checkTask(task); 
    }
    
    public void executeTasks(){
        try {
            service.submit(() -> taskExecution());           
        }finally {
            service.shutdown();
        }
    }     
    
    @Autowired
    private void taskExecution(){
        taskList.stream()
                .filter(task -> verifyTask(task))
                .forEach(task -> task.execute());
        taskList.clear();       
    }       
}

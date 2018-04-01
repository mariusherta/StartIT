
package com.orange.startit.beans;

import com.orange.startit.beanInterface.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskChecker {
    
    @Autowired
    public boolean checkTask(Task task){
        if(task instanceof SearchTask){
            if(((SearchTask) task).getCONTENT_PROVIDERS().contains(((SearchTask) task).getSearchSubject().getSearchAt())){
                return true;
            }
        }
        System.out.println("Task check failed!");
        return false;
    }
}


package com.orange.startit.beans;

import com.orange.startit.beanInterface.Task;
import com.orange.startit.taskFactory.TaskFactory.WikiSearch;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskChecker {
    private final List<String> CONTENT_PROVIDERS = Arrays.asList("Wikipedia","Google","Pinterest");
    
    @Autowired
    public boolean checkTask(Task task){
        if(task instanceof WikiSearch){
            if(CONTENT_PROVIDERS.contains(((WikiSearch) task).getSearchSubject().getSearchAt())){
                return true;
            }
        }
        System.out.println("Task check failed!");
        return false;
    }
}

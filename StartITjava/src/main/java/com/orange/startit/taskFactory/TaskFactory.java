/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.startit.taskFactory;

import com.orange.startit.beanInterface.Task;
import com.orange.startit.beans.SearchSubject;
import com.orange.startit.beans.WikiSearch;

/**
 *
 * @author Marius.Herta
 */
public class TaskFactory {
        
    public Task getInstance(SearchSubject searchSubject) {
        switch (searchSubject.getSearchAt()) {
            case "Wikipedia":
                return new WikiSearch(searchSubject);
            case "Google":
                break;
            case "Pinterest":
                break;
            default:
                System.out.println("Factory cannot provide requested object.");                   
        }
        return null;
    }     
}

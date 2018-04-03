/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.startit.taskFactory;

import com.orange.startit.beanInterface.Task;
import com.orange.startit.beans.SearchSubject;
import com.orange.startit.restClient.RestClient;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    
    @Component
    public class WikiSearch implements Serializable,Task{
        
    private final String URL1 = "https://en.wikipedia.org/w/api.php?action=opensearch&search=";
    private final String URL2 = "&limit=1&namespace=0&redirects=resolve&format=json";   
    private RestClient restClient = new RestClient();
    private SearchSubject searchSubject;
    
    private WikiSearch(SearchSubject searchSubject) {
        this.searchSubject = searchSubject;
    }
    
    @Autowired
    public void execute(){
        String searchUrl = URL1+searchSubject.getSubject()+URL2;
        String result = restClient.get(searchUrl); 
        postResultToFile(result);
    }
    
    private void postResultToFile(String result){
        System.out.println(result);        
    }

    public SearchSubject getSearchSubject() {
        return searchSubject;
    }

    private void setSearchSubject(SearchSubject searchSubject) {
        this.searchSubject = searchSubject;
    }
    
    
}
}

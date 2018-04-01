package com.orange.startit.beans;

import com.orange.startit.beanInterface.Task;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchTask implements Task { 
    private SearchSubject searchSubject;
    private final List<String> CONTENT_PROVIDERS = Arrays.asList("Wikipedia","Google");

    public SearchTask(SearchSubject searchSubject) {
        this.searchSubject = searchSubject;
    }   
    
    @Override
    @Autowired
    public void execute(){
        if(searchSubject.getSearchAt().equals("Wikipedia")){
            WikiSearch wikiSearch = new WikiSearch();
            wikiSearch.searchByString(searchSubject.getSubject());
        }else{
            return;
        }
    }

    public SearchSubject getSearchSubject() {
        return searchSubject;
    }

    public void setSearchSubject(SearchSubject searchSubject) {
        this.searchSubject = searchSubject;
    }

    public List<String> getCONTENT_PROVIDERS() {
        return CONTENT_PROVIDERS;
    }
    
    
}

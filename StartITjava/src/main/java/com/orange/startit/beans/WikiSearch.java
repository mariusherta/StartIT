package com.orange.startit.beans;

import com.orange.startit.restClient.RestClient;
import java.io.Serializable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class WikiSearch implements Serializable{
    private final String URL1 = "https://en.wikipedia.org/w/api.php?action=opensearch&search=";
    private final String URL2 = "&limit=1&namespace=0&redirects=resolve&format=json";   
    private RestClient restClient = new RestClient();
    String searchWord = "";

    public WikiSearch() {
    }
    
    @Autowired
    public void searchByString(String searchWord){
        this.searchWord = searchWord;
        String searchUrl = URL1+searchWord+URL2;
        String result = restClient.get(searchUrl); 
        postResultToFile(result);
    }
    
    private void postResultToFile(String result){
        System.out.println(result);        
    }
}

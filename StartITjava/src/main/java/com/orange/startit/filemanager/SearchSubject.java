/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.startit.filemanager;

/**
 *
 * @author Alin Preda
 */
public class SearchSubject {
    private String subject;
    private String searchAt;
    
    
    public SearchSubject(String subject, String searchAt)
    {
        this.searchAt = searchAt;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSearchAt() {
        return searchAt;
    }

    public void setSearchAt(String searchAt) {
        this.searchAt = searchAt;
    }
    
    
    
    public String toString(){
        return this.subject + " " + this.searchAt;
    }
    
}

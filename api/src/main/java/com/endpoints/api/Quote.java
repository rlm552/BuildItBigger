package com.endpoints.api;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Quote {

    @Id
    Long id;
    String what;
    public Quote() {}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getWhat() {
        return what;
    }
    public void setWhat(String what) {
        this.what = what;
    }
}

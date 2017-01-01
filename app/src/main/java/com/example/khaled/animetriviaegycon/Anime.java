package com.example.khaled.animetriviaegycon;

import java.io.Serializable;

/**
 * Created by hyhae on 12/31/2016.
 */

public class Anime implements Serializable {
    private String name;
    private String url;

    public Anime(){
    }

    public String getname(){return name;}
    public void setname(String Name){name=Name;}
    public String geturl(){return url;}
    public void seturl(String URL){url=URL;}
}

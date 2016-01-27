package com.fexco.testhello.model;

public class Model
{
    private int id;
    private String message;


    public Model()
    {
    }

    public Model(int id, String message)
    {
        this.message = message;
        this.id = id;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


}
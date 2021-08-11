package com.example.Springbootservices.restfulwebservices.helloworld;

public class HelloWorldBean {

    private String HelloWorld;

    HelloWorldBean(String name){
        this.HelloWorld = name;
    }

    public String getName() {
        return HelloWorld;
    }

    public void setName(String name) {
        this.HelloWorld = name;
    }

    @Override
    public String toString(){
        return String.format("HelloWorldBean %s", HelloWorld);
    }
}

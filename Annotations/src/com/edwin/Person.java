package com.edwin;

@Description("I am interface")
public interface Person {

    @Description("I am interface method")
    public String name();

    public int age();

    @Deprecated
    public void sing();
}

package ru.javawebinar.basejava.model;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SectionImpl extends AbstractSection{

    private List<String> stringList = new ArrayList<>();

    private List<Expire> expireList = new ArrayList<>();

    public SectionImpl(SectionType type, String name) {
        super(type, name);
    }

    public void addSting(String str){
        stringList.add(str);
    }

    public void addExpire(Expire expire){
        expireList.add(expire);
    }

    @Override
    public void print() {
        if (stringList != null){
            for(String srt:stringList){
                System.out.println(srt);
            }
        }
        if (expireList!=null){
            for (Expire exp: expireList){
                System.out.println(exp);
            }
        }
    }

    @Override
    public String toString() {
        return "SectionImpl{" +
                "stringList=" + stringList +
                ", expireList=" + expireList +
                '}';
    }
}

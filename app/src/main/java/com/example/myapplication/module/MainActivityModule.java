package com.example.myapplication.module;

/**
 * Created on 2020-09-18
 *
 * @author zsp
 * @desc 主页 module
 */
public class MainActivityModule {
    private final String name;
    private final String commentate;

    /**
     * constructor
     *
     * @param name       名称
     * @param commentate 注释
     */
    public MainActivityModule(String name, String commentate) {
        this.name = name;
        this.commentate = commentate;
    }

    public String getName() {
        return name;
    }

    public String getCommentate() {
        return commentate;
    }
}

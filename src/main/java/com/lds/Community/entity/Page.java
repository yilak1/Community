package com.lds.Community.entity;

public class Page {

    //当前页
    private int current = 1;
    //用于计算总页数
    private int rows = 0;
    //显示行数
    private int limit = 10;
    //查询路径(分页链接)
    private String path;


    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current > 0){
            this.current = current;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0){
            this.rows = rows;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit > 0 && limit <= 100){
            this.limit = limit;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //起始行
    public int getOffset(){
        return current * limit - limit;
    }

    //总页数
    public int getTotal(){
        if (rows % limit == 0){
            return rows/limit;
        }else {
            return rows/limit + 1;
        }
    }


    //页码的起始页
    public int getFrom(){
        return current - 2 > 0? current - 2 : 1;
    }

    //页码的最终范围
    public int getTo(){
        return current + 2 > getTotal()? getTotal(): current + 2;
    }
}

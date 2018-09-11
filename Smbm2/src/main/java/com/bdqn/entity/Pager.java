package com.bdqn.entity;
import java.util.List;

public class Pager<T>{

    private int pageNo;
    private int pageSize;
    private int totalRow;
    private int totalPage;
    private List<T> dates;

    public Pager() {

    }
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDates() {
        return dates;
    }

    public void setDates(List<T> dates) {
        this.dates = dates;
    }
}


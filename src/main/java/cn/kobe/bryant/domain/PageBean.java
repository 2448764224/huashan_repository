package cn.kobe.bryant.domain;

import java.util.List;
import java.util.Map;

public class PageBean {
    private int totalCount; //总个数
    private int totalPage;  //总页数
    private int count;  //每页的个数
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", count=" + count +
                ", currentPage=" + currentPage +
                ", list=" + list +
                '}';
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    private int currentPage;    //当前页数
    private List list;   //每页的数据
}

package cn.kobe.bryant.domain;

import java.util.Arrays;
import java.util.List;

public class Comments {

    @Override
    public String toString() {
        return "Comments{" +
                "list=" + list +
                ", isDelete=" + Arrays.toString(isDelete) +
                '}';
    }

    public List<Comment> getList() {
        return list;
    }

    public void setList(List<Comment> list) {
        this.list = list;
    }

    public boolean[] getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean[] isDelete) {
        this.isDelete = isDelete;
    }

    private List<Comment> list;
    private boolean[] isDelete;
}

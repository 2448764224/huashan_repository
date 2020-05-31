package cn.kobe.bryant.domain;

public class ResultInfo {
    private boolean flag;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private String errorMsg;
}

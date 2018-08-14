package com.westos.web01.bean;

public class Haohan {
    private Integer xuhao;
    private String xingming;


    public Integer getXuhao() {
        return xuhao;
    }

    public void setXuhao(Integer xuhao) {
        this.xuhao = xuhao;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Haohan haohan = (Haohan) o;

        if (xuhao != null ? !xuhao.equals(haohan.xuhao) : haohan.xuhao != null) return false;
        return xingming != null ? xingming.equals(haohan.xingming) : haohan.xingming == null;
    }

    @Override
    public int hashCode() {
        int result = xuhao != null ? xuhao.hashCode() : 0;
        result = 31 * result + (xingming != null ? xingming.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Haohan{" +
                "xuhao=" + xuhao +
                ", xingming='" + xingming + '\'' +
                '}';
    }
}

package com.finra.assessment.model;


import java.util.List;

public class CombinationDTO {
    private List<String> data;
    private int totalCount;
    private int defalutSize = 20;

    public CombinationDTO() {
    }

    public CombinationDTO(List<String> data, int count) {
        this.data = data;
        this.totalCount = count;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public int getCount() {
        return totalCount;
    }

    public void setCount(int count) {
        this.totalCount = count;
    }

    public int getDefalutSize() { return this.defalutSize; }
}
package com.asn.nestedrecyclerdemo;

import java.util.List;

public class MyData {

    private String title;
    private List<NestedData> nestData;

    public MyData(String title, List<NestedData> nestData) {
        this.title = title;
        this.nestData = nestData;
    }


    public List<NestedData> getNestData() {
        return nestData;
    }

    public void setNestData(List<NestedData> nestData) {
        this.nestData = nestData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    static class NestedData {
        private String nestTitle;

        public String getNestTitle() {
            return nestTitle;
        }

        public void setNestTitle(String nestTitle) {
            this.nestTitle = nestTitle;
        }

        public NestedData(String nestTitle) {
            this.nestTitle = nestTitle;
        }
    }
}

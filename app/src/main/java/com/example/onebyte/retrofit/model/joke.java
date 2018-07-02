package com.example.onebyte.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class joke {
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("value")
        @Expose
        private List<value> value = null;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<value> getValue() {
            return value;
        }

        public void setValue(List<value> value) {
            this.value = value;
        }

}
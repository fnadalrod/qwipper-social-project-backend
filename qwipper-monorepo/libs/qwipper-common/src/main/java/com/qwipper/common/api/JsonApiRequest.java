package com.qwipper.common.api;

public class JsonApiRequest<T> {
    private Data<T> data;

    public Data<T> getData() {
        return data;
    }

    public void setData(Data<T> data) {
        this.data = data;
    }

    public static class Data<T> {
        private String type;
        private T attributes;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public T getAttributes() {
            return attributes;
        }

        public void setAttributes(T attributes) {
            this.attributes = attributes;
        }
    }
}

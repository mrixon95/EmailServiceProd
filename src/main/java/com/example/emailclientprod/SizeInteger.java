package com.example.emailclientprod;

public class SizeInteger implements Comparable<SizeInteger>{

    private int size;

    public SizeInteger(int size) {
        this.size = size;
    }

    @Override
    public String toString() {

        if (size <= 0) {
            return "0";
        } else if (size < 1024) {
            return size + " B";
        } else if (size < (1024*1024)) {
            return size / 1024 + "KB";
        } else {
            return size / (1024*1024) + "MB";
        }

    }

    @Override
    public int compareTo(SizeInteger o) {
        return Integer.compare(o.size,size);
    }
}

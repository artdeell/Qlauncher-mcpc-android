package com.tonicsystems.jarjar;

public class PathClass {
    private String className;
    private String classPath;

    public PathClass(String str, String str2) {
        String str3 = str2;
        this.classPath = str;
        this.className = str3;
    }

    public String getClassName() {
        return this.className;
    }

    public String getClassPath() {
        return this.classPath;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(this.classPath).append("!").append(this.className).toString();
    }
}

package net.zhuoweizhang.boardwalk;

import dalvik.system.DexClassLoader;
import java.net.URL;
import java.util.Enumeration;

public class ResourceFilterClassLoader extends DexClassLoader {
    public ResourceFilterClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    private String filterName(String str) {
        String str2 = str;
        System.out.println(str2);
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    public URL findResource(String str) {
        return super.findResource(filterName(str));
    }

    /* access modifiers changed from: protected */
    public Enumeration<URL> findResources(String str) {
        return super.findResources(filterName(str));
    }
}

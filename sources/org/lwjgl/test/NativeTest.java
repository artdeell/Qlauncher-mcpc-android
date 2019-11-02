package org.lwjgl.test;

import java.awt.Toolkit;
import org.lwjgl.Sys;

public class NativeTest {
    public NativeTest() {
    }

    public static void main(String[] strArr) {
        NativeTest nativeTest;
        String[] strArr2 = strArr;
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        NativeTest nativeTest2 = nativeTest;
        NativeTest nativeTest3 = new NativeTest();
        nativeTest2.invokeSys();
        System.out.println("OK");
    }

    public void invokeSys() {
        String version = Sys.getVersion();
    }
}

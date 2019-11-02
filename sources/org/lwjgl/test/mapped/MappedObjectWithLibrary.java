package org.lwjgl.test.mapped;

import java.io.File;
import java.io.PrintStream;
import org.lwjgl.opengl.Display;

public class MappedObjectWithLibrary {
    public MappedObjectWithLibrary() {
    }

    public static void testLWJGL() throws Exception {
        File file;
        PrintStream printStream = System.out;
        File file2 = file;
        File file3 = new File(System.getProperty("java.library.path"));
        printStream.println(file2.getCanonicalPath());
        Display.create();
    }
}

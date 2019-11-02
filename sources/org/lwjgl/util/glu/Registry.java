package org.lwjgl.util.glu;

public class Registry extends Util {
    private static final String extensionString = "GLU_EXT_nurbs_tessellator GLU_EXT_object_space_tess ";
    private static final String versionString = "1.3";

    public Registry() {
    }

    public static boolean gluCheckExtension(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        return (str4 == null || str3 == null || str4.indexOf(str3) == -1) ? false : true;
    }

    public static String gluGetString(int i) {
        int i2 = i;
        if (i2 == 100800) {
            return versionString;
        }
        if (i2 == 100801) {
            return extensionString;
        }
        return null;
    }
}

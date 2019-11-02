package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.RuntimeIOException;
import java.io.IOException;
import java.util.Map;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingClassAdapter;

class DepFindVisitor extends RemappingClassAdapter {

    private static class DepFindRemapper extends Remapper {
        private final Map<String, String> classes;
        private PathClass curPathClass;
        private final DepHandler handler;
        private final String source;

        public DepFindRemapper(Map<String, String> map, String str, DepHandler depHandler) throws IOException {
            String str2 = str;
            DepHandler depHandler2 = depHandler;
            this.classes = map;
            this.source = str2;
            this.handler = depHandler2;
        }

        public String map(String str) {
            RuntimeIOException runtimeIOException;
            PathClass pathClass;
            String str2 = str;
            try {
                if (this.classes.containsKey(str2)) {
                    String str3 = (String) this.classes.get(str2);
                    if (!this.source.equals(str3)) {
                        DepHandler depHandler = this.handler;
                        PathClass pathClass2 = this.curPathClass;
                        PathClass pathClass3 = pathClass;
                        PathClass pathClass4 = new PathClass(str3, str2);
                        depHandler.handle(pathClass2, pathClass3);
                    }
                }
                return null;
            } catch (IOException e) {
                IOException iOException = e;
                RuntimeIOException runtimeIOException2 = runtimeIOException;
                RuntimeIOException runtimeIOException3 = new RuntimeIOException(iOException);
                throw runtimeIOException2;
            }
        }

        public void setClassName(String str) {
            PathClass pathClass;
            PathClass pathClass2 = pathClass;
            PathClass pathClass3 = new PathClass(this.source, str);
            this.curPathClass = pathClass2;
        }
    }

    public DepFindVisitor(Map<String, String> map, String str, DepHandler depHandler) throws IOException {
        DepFindRemapper depFindRemapper;
        DepFindRemapper depFindRemapper2 = depFindRemapper;
        DepFindRemapper depFindRemapper3 = new DepFindRemapper(map, str, depHandler);
        super(null, depFindRemapper2);
    }

    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        int i3 = i;
        int i4 = i2;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        ((DepFindRemapper) this.remapper).setClassName(str4);
        super.visit(i3, i4, str4, str5, str6, strArr2);
    }
}

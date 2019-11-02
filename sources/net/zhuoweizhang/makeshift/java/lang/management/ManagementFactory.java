package net.zhuoweizhang.makeshift.java.lang.management;

import java.util.Collections;
import java.util.List;

public class ManagementFactory {
    private static RuntimeMXBean runtimeMXBeanInstance;

    private static class RuntimeMXBeanImpl implements RuntimeMXBean {
        private RuntimeMXBeanImpl() {
        }

        /* synthetic */ RuntimeMXBeanImpl(C07381 r4) {
            C07381 r1 = r4;
            this();
        }

        public List<String> getInputArguments() {
            return Collections.emptyList();
        }
    }

    static {
        RuntimeMXBeanImpl runtimeMXBeanImpl;
        RuntimeMXBeanImpl runtimeMXBeanImpl2 = runtimeMXBeanImpl;
        RuntimeMXBeanImpl runtimeMXBeanImpl3 = new RuntimeMXBeanImpl(null);
        runtimeMXBeanInstance = runtimeMXBeanImpl2;
    }

    public ManagementFactory() {
    }

    public static RuntimeMXBean getRuntimeMXBean() {
        return runtimeMXBeanInstance;
    }
}

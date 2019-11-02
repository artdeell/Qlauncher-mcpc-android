package android.support.p000v4.net;

import android.os.Build.VERSION;
import java.net.Socket;
import java.net.SocketException;

/* renamed from: android.support.v4.net.TrafficStatsCompat */
public class TrafficStatsCompat {
    private static final TrafficStatsCompatImpl IMPL;

    /* renamed from: android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl */
    static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        private ThreadLocal<SocketTags> mThreadSocketTags;

        /* renamed from: android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags */
        private static class SocketTags {
            public int statsTag;

            private SocketTags() {
                this.statsTag = -1;
            }

            /* synthetic */ SocketTags(C00841 r4) {
                C00841 r1 = r4;
                this();
            }
        }

        BaseTrafficStatsCompatImpl() {
            C00851 r5;
            C00851 r2 = r5;
            C00851 r3 = new ThreadLocal<SocketTags>(this) {
                final /* synthetic */ BaseTrafficStatsCompatImpl this$0;

                {
                    this.this$0 = r5;
                }

                /* access modifiers changed from: protected */
                public SocketTags initialValue() {
                    SocketTags socketTags;
                    SocketTags socketTags2 = socketTags;
                    SocketTags socketTags3 = new SocketTags(null);
                    return socketTags2;
                }
            };
            this.mThreadSocketTags = r2;
        }

        public void clearThreadStatsTag() {
            ((SocketTags) this.mThreadSocketTags.get()).statsTag = -1;
        }

        public int getThreadStatsTag() {
            return ((SocketTags) this.mThreadSocketTags.get()).statsTag;
        }

        public void incrementOperationCount(int i) {
        }

        public void incrementOperationCount(int i, int i2) {
        }

        public void setThreadStatsTag(int i) {
            int i2 = i;
            ((SocketTags) this.mThreadSocketTags.get()).statsTag = i2;
        }

        public void tagSocket(Socket socket) {
        }

        public void untagSocket(Socket socket) {
        }
    }

    /* renamed from: android.support.v4.net.TrafficStatsCompat$IcsTrafficStatsCompatImpl */
    static class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
        }

        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        public void incrementOperationCount(int i) {
            TrafficStatsCompatIcs.incrementOperationCount(i);
        }

        public void incrementOperationCount(int i, int i2) {
            TrafficStatsCompatIcs.incrementOperationCount(i, i2);
        }

        public void setThreadStatsTag(int i) {
            TrafficStatsCompatIcs.setThreadStatsTag(i);
        }

        public void tagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.tagSocket(socket);
        }

        public void untagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.untagSocket(socket);
        }
    }

    /* renamed from: android.support.v4.net.TrafficStatsCompat$TrafficStatsCompatImpl */
    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();

        int getThreadStatsTag();

        void incrementOperationCount(int i);

        void incrementOperationCount(int i, int i2);

        void setThreadStatsTag(int i);

        void tagSocket(Socket socket) throws SocketException;

        void untagSocket(Socket socket) throws SocketException;
    }

    static {
        BaseTrafficStatsCompatImpl baseTrafficStatsCompatImpl;
        IcsTrafficStatsCompatImpl icsTrafficStatsCompatImpl;
        if (VERSION.SDK_INT >= 14) {
            IcsTrafficStatsCompatImpl icsTrafficStatsCompatImpl2 = icsTrafficStatsCompatImpl;
            IcsTrafficStatsCompatImpl icsTrafficStatsCompatImpl3 = new IcsTrafficStatsCompatImpl();
            IMPL = icsTrafficStatsCompatImpl2;
            return;
        }
        BaseTrafficStatsCompatImpl baseTrafficStatsCompatImpl2 = baseTrafficStatsCompatImpl;
        BaseTrafficStatsCompatImpl baseTrafficStatsCompatImpl3 = new BaseTrafficStatsCompatImpl();
        IMPL = baseTrafficStatsCompatImpl2;
    }

    public TrafficStatsCompat() {
    }

    public static void clearThreadStatsTag() {
        IMPL.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return IMPL.getThreadStatsTag();
    }

    public static void incrementOperationCount(int i) {
        IMPL.incrementOperationCount(i);
    }

    public static void incrementOperationCount(int i, int i2) {
        IMPL.incrementOperationCount(i, i2);
    }

    public static void setThreadStatsTag(int i) {
        IMPL.setThreadStatsTag(i);
    }

    public static void tagSocket(Socket socket) throws SocketException {
        IMPL.tagSocket(socket);
    }

    public static void untagSocket(Socket socket) throws SocketException {
        IMPL.untagSocket(socket);
    }
}

package com.google.ads;

@Deprecated
public final class AdRequest {
    public static final String LOGTAG = "Ads";
    public static final String TEST_EMULATOR = com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR;
    public static final String VERSION = "0.0.0";

    public enum ErrorCode {
        ;
        
        private final String description;

        private ErrorCode(String str) {
            String str2 = r8;
            int i = r9;
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    public enum Gender {
    }

    private AdRequest() {
    }
}

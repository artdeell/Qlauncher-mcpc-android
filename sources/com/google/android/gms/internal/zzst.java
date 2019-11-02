package com.google.android.gms.internal;

import java.io.IOException;

public class zzst extends IOException {
    public zzst(String str) {
        super(str);
    }

    static zzst zzJs() {
        zzst zzst;
        zzst zzst2 = zzst;
        zzst zzst3 = new zzst("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        return zzst2;
    }

    static zzst zzJt() {
        zzst zzst;
        zzst zzst2 = zzst;
        zzst zzst3 = new zzst("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return zzst2;
    }

    static zzst zzJu() {
        zzst zzst;
        zzst zzst2 = zzst;
        zzst zzst3 = new zzst("CodedInputStream encountered a malformed varint.");
        return zzst2;
    }

    static zzst zzJv() {
        zzst zzst;
        zzst zzst2 = zzst;
        zzst zzst3 = new zzst("Protocol message contained an invalid tag (zero).");
        return zzst2;
    }

    static zzst zzJw() {
        zzst zzst;
        zzst zzst2 = zzst;
        zzst zzst3 = new zzst("Protocol message end-group tag did not match expected tag.");
        return zzst2;
    }

    static zzst zzJx() {
        zzst zzst;
        zzst zzst2 = zzst;
        zzst zzst3 = new zzst("Protocol message tag had invalid wire type.");
        return zzst2;
    }

    static zzst zzJy() {
        zzst zzst;
        zzst zzst2 = zzst;
        zzst zzst3 = new zzst("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        return zzst2;
    }
}

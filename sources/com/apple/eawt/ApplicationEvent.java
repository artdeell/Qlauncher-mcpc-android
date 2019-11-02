package com.apple.eawt;

import java.util.EventObject;

public class ApplicationEvent extends EventObject {
    ApplicationEvent(Object obj) {
        super(obj);
    }

    ApplicationEvent(Object obj, String str) {
        String str2 = str;
        super(obj);
    }

    public String getFilename() {
        return null;
    }

    public boolean isHandled() {
        return false;
    }

    public void setHandled(boolean z) {
    }
}

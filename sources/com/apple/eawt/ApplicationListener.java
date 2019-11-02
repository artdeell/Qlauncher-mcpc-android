package com.apple.eawt;

import java.util.EventListener;

public interface ApplicationListener extends EventListener {
    void handleAbout(ApplicationEvent applicationEvent);

    void handleOpenApplication(ApplicationEvent applicationEvent);

    void handleOpenFile(ApplicationEvent applicationEvent);

    void handlePreferences(ApplicationEvent applicationEvent);

    void handlePrintFile(ApplicationEvent applicationEvent);

    void handleQuit(ApplicationEvent applicationEvent);

    void handleReOpenApplication(ApplicationEvent applicationEvent);
}

package net.zhuoweizhang.boardwalk.model.vanillalauncher;

import java.util.Map;
import java.util.UUID;

public class LauncherProfiles {
    public Map<String, LauncherAuth> authenticationDatabase;
    public UUID clientToken;
    public String selectedProfile;
    public String selectedUser;

    public LauncherProfiles() {
    }
}

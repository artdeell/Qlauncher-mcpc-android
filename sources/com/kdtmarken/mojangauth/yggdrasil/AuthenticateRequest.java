package com.kdtmarken.mojangauth.yggdrasil;

import java.util.UUID;

public class AuthenticateRequest {
    public AgentInfo agent;
    public UUID clientToken;
    public String password;
    public String username;

    public static class AgentInfo {
        public String name;
        public int version;

        public AgentInfo() {
        }
    }

    public AuthenticateRequest(String str, String str2, UUID uuid, String str3, int i) {
        AgentInfo agentInfo;
        String str4 = str;
        String str5 = str2;
        UUID uuid2 = uuid;
        String str6 = str3;
        int i2 = i;
        AgentInfo agentInfo2 = agentInfo;
        AgentInfo agentInfo3 = new AgentInfo();
        this.agent = agentInfo2;
        this.username = str4;
        this.password = str5;
        this.clientToken = uuid2;
        this.agent.name = str6;
        this.agent.version = i2;
    }
}

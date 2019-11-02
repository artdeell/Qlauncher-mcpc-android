package net.java.games.input;

final class SetupAPIDevice {
    private final String device_instance_id;
    private final String device_name;

    public SetupAPIDevice(String str, String str2) {
        String str3 = str2;
        this.device_instance_id = str;
        this.device_name = str3;
    }

    public final String getInstanceId() {
        return this.device_instance_id;
    }

    public final String getName() {
        return this.device_name;
    }
}

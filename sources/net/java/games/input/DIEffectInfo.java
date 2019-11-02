package net.java.games.input;

final class DIEffectInfo {
    private final IDirectInputDevice device;
    private final int dynamic_params;
    private final int effect_type;
    private final byte[] guid;
    private final int guid_id;
    private final String name;
    private final int static_params;

    public DIEffectInfo(IDirectInputDevice iDirectInputDevice, byte[] bArr, int i, int i2, int i3, int i4, String str) {
        byte[] bArr2 = bArr;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        String str2 = str;
        this.device = iDirectInputDevice;
        this.guid = bArr2;
        this.guid_id = i5;
        this.effect_type = i6;
        this.static_params = i7;
        this.dynamic_params = i8;
        this.name = str2;
    }

    public final int getDynamicParams() {
        return this.dynamic_params;
    }

    public final int getEffectType() {
        return this.effect_type;
    }

    public final byte[] getGUID() {
        return this.guid;
    }

    public final int getGUIDId() {
        return this.guid_id;
    }

    public final String getName() {
        return this.name;
    }
}

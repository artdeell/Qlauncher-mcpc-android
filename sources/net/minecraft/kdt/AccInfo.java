package net.minecraft.kdt;

public class AccInfo {
    private String content;

    public static AccInfo create(String str) {
        AccInfo accInfo;
        AccInfo accInfo2 = accInfo;
        AccInfo accInfo3 = new AccInfo(str);
        return accInfo2;
    }

    AccInfo(String str) {
        RuntimeException runtimeException;
        try {
            this.content = FileAccess.read(str);
        } catch (Exception e) {
            Exception exc = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(exc);
            throw runtimeException2;
        }
    }

    public String getUuid() {
        return null;
    }
}

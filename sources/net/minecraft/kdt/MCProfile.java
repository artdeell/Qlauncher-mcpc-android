package net.minecraft.kdt;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import com.kdtmarken.mojangauth.RefreshListener;
import com.kdtmarken.mojangauth.RefreshTokenTask;
import java.io.ByteArrayOutputStream;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.MainActivity;

public class MCProfile {
    /* access modifiers changed from: private */
    public static String[] emptyBuilder;

    public static class Builder {
        private String TAG;
        private String[] fullArgs;
        private boolean isAccount;

        public Builder() {
            this.TAG = "MCProfile.Builder";
            this.fullArgs = new String[6];
            this.isAccount = true;
            this.fullArgs = MCProfile.emptyBuilder;
            String[] generate = FakeAccount.generate();
            setClientID(generate[0]);
            setProfileID(FakeAccount.generate()[0].replaceAll("-", LibrariesRepository.MOJANG_MAVEN_REPO));
            setAccessToken(generate[1]);
        }

        public boolean getIsAccount() {
            return this.isAccount;
        }

        public String getVersion() {
            return this.fullArgs[0];
        }

        public String getClientID() {
            return this.fullArgs[1];
        }

        public String getProfileID() {
            return this.fullArgs[2];
        }

        public String getAccessToken() {
            return this.fullArgs[3];
        }

        public String getNickname() {
            return this.fullArgs[4];
        }

        public void setIsAccount(boolean z) {
            boolean z2 = z;
            this.isAccount = z2;
        }

        public void setVersion(String str) {
            String str2 = str;
            this.fullArgs[0] = str2;
        }

        public void setClientID(String str) {
            String str2 = str;
            this.fullArgs[1] = str2;
        }

        public void setProfileID(String str) {
            String str2 = str;
            this.fullArgs[2] = str2;
        }

        public void setAccessToken(String str) {
            String str2 = str;
            this.fullArgs[3] = str2;
        }

        public void setNickname(String str) {
            String str2 = str;
            this.fullArgs[4] = str2;
        }
    }

    static {
        String[] strArr = new String[5];
        String[] strArr2 = strArr;
        strArr[0] = MainActivity.VERSION_TO_LAUNCH;
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "ProfileIDEmpty";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "AccessToken";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = "AccessTokenEmpty";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = "NicknameEmpty";
        emptyBuilder = strArr10;
    }

    public static void launchWithProfile(Activity activity, String str) {
        NoClassDefFoundError noClassDefFoundError;
        Activity activity2 = activity;
        String str2 = str;
        Intent intent = r7;
        Intent intent2 = intent;
        r7 = intent;
        try {
            Intent intent3 = new Intent(activity2, Class.forName("net.minecraft.kdt.MCLauncherActivity"));
            Intent intent4 = intent2;
            Intent putExtra = intent4.putExtra("POFfilepath", str2);
            activity2.startActivityForResult(intent4, UserStatus.REQUEST_USER);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    public static void updateTokens(Activity activity, String str) throws Exception {
        RefreshTokenTask refreshTokenTask;
        AnonymousClass100000000 r9;
        String str2 = str;
        RefreshTokenTask refreshTokenTask2 = refreshTokenTask;
        AnonymousClass100000000 r6 = r9;
        AnonymousClass100000000 r7 = new RefreshListener(activity) {
            private final Activity val$ctx;

            {
                this.val$ctx = r6;
            }

            @Override
            public void onRefreshDone(boolean z, String str) {
            }

            @Override
            public void onException(Exception exc) {
                Exception exc2 = exc;
                MCClassPath.throwError(this.val$ctx, exc2);
            }
        };
        RefreshTokenTask refreshTokenTask3 = new RefreshTokenTask(r6);
        String[] strArr = new String[1];
        String[] strArr2 = strArr;
        strArr[0] = str2;
        AsyncTask execute = refreshTokenTask2.execute(strArr2);
    }

    public static String build(Builder builder) {
        ByteArrayOutputStream byteArrayOutputStream;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        Builder builder2 = builder;
        byte[] bArr = new byte[1];
        byte[] bArr2 = bArr;
        bArr[0] = (byte) -128;
        byte[] combineByte = combineByte(bArr2, builder2.getClientID().getBytes());
        byte[] combineByte2 = combineByte("¶".getBytes(), builder2.getProfileID().getBytes());
        byte[] combineByte3 = combineByte("∆".getBytes(), builder2.getAccessToken().getBytes());
        byte[] combineByte4 = combineByte("€".getBytes(), builder2.getNickname().getBytes());
        byte[] combineByte5 = combineByte("$".getBytes(), builder2.getVersion().getBytes());
        byte[] combineByte6 = combineByte("©".getBytes(), Boolean.toString(builder2.getIsAccount()).getBytes());
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
        try {
            byteArrayOutputStream4.write(combineByte);
            byteArrayOutputStream4.write(combineByte2);
            byteArrayOutputStream4.write(combineByte3);
            byteArrayOutputStream4.write(combineByte4);
            byteArrayOutputStream4.write(combineByte5);
            byteArrayOutputStream4.write(combineByte6);
        } catch (Exception e) {
            Exception exc = e;
        }
        try {
            StringBuffer stringBuffer5 = stringBuffer3;
            StringBuffer stringBuffer6 = new StringBuffer();
            StringBuffer stringBuffer7 = stringBuffer4;
            StringBuffer stringBuffer8 = new StringBuffer();
            FileAccess.write(stringBuffer5.append(stringBuffer7.append(MCClassPath.mpProfiles).append("/").toString()).append(builder2.getNickname()).toString(), byteArrayOutputStream4.toByteArray());
        } catch (Exception e2) {
            Exception exc2 = e2;
        }
        StringBuffer stringBuffer9 = stringBuffer;
        StringBuffer stringBuffer10 = new StringBuffer();
        StringBuffer stringBuffer11 = stringBuffer2;
        StringBuffer stringBuffer12 = new StringBuffer();
        return stringBuffer9.append(stringBuffer11.append(MCClassPath.mpProfiles).append("/").toString()).append(builder2.getNickname()).toString();
    }

    public static Builder load(String str) throws Exception {
        String str2;
        Builder builder;
        String str3 = str;
        String str4 = str2;
        byte[] bArr = new byte[1];
        byte[] bArr2 = bArr;
        bArr[0] = (byte) -128;
        String str5 = new String(bArr2);
        String str6 = str4;
        String read = FileAccess.read(str3);
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        Builder builder4 = builder2;
        String substring = read.substring(read.indexOf(str6) + 1, read.indexOf("¶"));
        String substring2 = read.substring(read.indexOf("¶") + 1, read.indexOf("∆"));
        String substring3 = read.substring(read.indexOf("∆") + 1, read.indexOf("€"));
        String substring4 = read.substring(read.indexOf("€") + 1, read.indexOf("$"));
        String substring5 = read.substring(read.indexOf("$") + 1, read.indexOf("©"));
        String substring6 = read.substring(read.indexOf("©") + 1);
        builder4.setClientID(substring);
        builder4.setProfileID(substring2);
        builder4.setAccessToken(substring3);
        builder4.setNickname(substring4);
        builder4.setVersion(substring5);
        builder4.setIsAccount(Boolean.parseBoolean(substring6));
        return builder4;
    }

    private static byte[] combineByte(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        byte[] bArr5 = new byte[(bArr3.length + bArr4.length)];
        System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
        System.arraycopy(bArr4, 0, bArr5, bArr3.length, bArr4.length);
        return bArr5;
    }

    public MCProfile() {
    }
}

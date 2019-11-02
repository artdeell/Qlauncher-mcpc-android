package net.minecraft.kdt;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class FakeAccount {

    private static class RandomString {
        public static final String alphanum;
        public static final String digits = "0123456789";
        public static final String lower = upper.toLowerCase(Locale.ROOT);
        public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private final char[] buf;
        private final Random random;
        private final char[] symbols;

        static {
            StringBuffer stringBuffer;
            StringBuffer stringBuffer2;
            StringBuffer stringBuffer3 = stringBuffer;
            StringBuffer stringBuffer4 = new StringBuffer();
            StringBuffer stringBuffer5 = stringBuffer2;
            StringBuffer stringBuffer6 = new StringBuffer();
            alphanum = stringBuffer3.append(stringBuffer5.append(upper).append(lower).toString()).append(digits).toString();
        }

        public String nextString() {
            String str;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.buf.length) {
                    String str2 = str;
                    String str3 = new String(this.buf);
                    return str2;
                }
                this.buf[i2] = this.symbols[this.random.nextInt(this.symbols.length)];
                i = i2 + 1;
            }
        }

        public RandomString(int i, Random random2, String str) {
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            int i2 = i;
            Random random3 = random2;
            String str2 = str;
            if (i2 < 1) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException();
                throw illegalArgumentException3;
            } else if (str2.length() < 2) {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException();
                throw illegalArgumentException5;
            } else {
                this.random = (Random) Objects.requireNonNull(random3);
                this.symbols = str2.toCharArray();
                this.buf = new char[i2];
            }
        }

        public RandomString(int i, Random random2) {
            this(i, random2, alphanum);
        }

        public RandomString(int i) {
            SecureRandom secureRandom;
            int i2 = i;
            SecureRandom secureRandom2 = secureRandom;
            SecureRandom secureRandom3 = new SecureRandom();
            this(i2, secureRandom2);
        }

        public RandomString() {
            this(21);
        }
    }

    public static String[] generate() {
        RandomString randomString;
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = UUID.randomUUID().toString();
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        String[] strArr5 = strArr3;
        RandomString randomString2 = randomString;
        RandomString randomString3 = new RandomString(32);
        strArr5[1] = randomString2.nextString();
        return strArr4;
    }

    public FakeAccount() {
    }
}

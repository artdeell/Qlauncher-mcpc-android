package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import java.util.HashMap;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.AddressMap */
public final class AddressMap {
    private final HashMap<Integer, Integer> map;

    public AddressMap() {
        HashMap<Integer, Integer> hashMap;
        HashMap<Integer, Integer> hashMap2 = hashMap;
        HashMap<Integer, Integer> hashMap3 = new HashMap<>();
        this.map = hashMap2;
    }

    public int get(int i) {
        Integer num = (Integer) this.map.get(Integer.valueOf(i));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public void put(int i, int i2) {
        Object put = this.map.put(Integer.valueOf(i), Integer.valueOf(i2));
    }
}

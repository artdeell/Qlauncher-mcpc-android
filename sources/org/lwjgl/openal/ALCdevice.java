package org.lwjgl.openal;

import java.util.HashMap;

public final class ALCdevice {
    private final HashMap<Long, ALCcontext> contexts;
    final long device;
    private boolean valid = true;

    ALCdevice(long j) {
        HashMap<Long, ALCcontext> hashMap;
        long j2 = j;
        HashMap<Long, ALCcontext> hashMap2 = hashMap;
        HashMap<Long, ALCcontext> hashMap3 = new HashMap<>();
        this.contexts = hashMap2;
        this.device = j2;
    }

    /* access modifiers changed from: 0000 */
    public void addContext(ALCcontext aLCcontext) {
        ALCcontext aLCcontext2 = aLCcontext;
        HashMap<Long, ALCcontext> hashMap = this.contexts;
        synchronized (hashMap) {
            try {
                Object put = this.contexts.put(Long.valueOf(aLCcontext2.context), aLCcontext2);
            } catch (Throwable th) {
                Throwable th2 = th;
                HashMap<Long, ALCcontext> hashMap2 = hashMap;
                throw th2;
            }
        }
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return obj2 instanceof ALCdevice ? ((ALCdevice) obj2).device == this.device : super.equals(obj2);
    }

    public boolean isValid() {
        return this.valid;
    }

    /* access modifiers changed from: 0000 */
    public void removeContext(ALCcontext aLCcontext) {
        ALCcontext aLCcontext2 = aLCcontext;
        HashMap<Long, ALCcontext> hashMap = this.contexts;
        synchronized (hashMap) {
            try {
                Object remove = this.contexts.remove(Long.valueOf(aLCcontext2.context));
            } catch (Throwable th) {
                Throwable th2 = th;
                HashMap<Long, ALCcontext> hashMap2 = hashMap;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setInvalid() {
        this.valid = false;
        HashMap<Long, ALCcontext> hashMap = this.contexts;
        synchronized (hashMap) {
            try {
                for (ALCcontext invalid : this.contexts.values()) {
                    invalid.setInvalid();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                HashMap<Long, ALCcontext> hashMap2 = hashMap;
                throw th2;
            }
        }
        this.contexts.clear();
    }
}

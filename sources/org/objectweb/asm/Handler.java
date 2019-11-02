package org.objectweb.asm;

class Handler {

    /* renamed from: a */
    Label f350a;

    /* renamed from: b */
    Label f351b;

    /* renamed from: c */
    Label f352c;

    /* renamed from: d */
    String f353d;

    /* renamed from: e */
    int f354e;

    /* renamed from: f */
    Handler f355f;

    Handler() {
    }

    /* renamed from: a */
    static Handler m112a(Handler handler, Label label, Label label2) {
        Handler handler2;
        Handler handler3 = handler;
        Label label3 = label;
        Label label4 = label2;
        if (handler3 == null) {
            handler3 = null;
        } else {
            handler3.f355f = m112a(handler3.f355f, label3, label4);
            int i = handler3.f350a.f367c;
            int i2 = handler3.f351b.f367c;
            int i3 = label3.f367c;
            int i4 = label4 == null ? Integer.MAX_VALUE : label4.f367c;
            if (i3 < i2 && i4 > i) {
                if (i3 <= i) {
                    if (i4 >= i2) {
                        return handler3.f355f;
                    }
                    handler3.f350a = label4;
                    return handler3;
                } else if (i4 >= i2) {
                    handler3.f351b = label3;
                    return handler3;
                } else {
                    Handler handler4 = handler2;
                    Handler handler5 = new Handler();
                    Handler handler6 = handler4;
                    handler6.f350a = label4;
                    handler6.f351b = handler3.f351b;
                    handler6.f352c = handler3.f352c;
                    handler6.f353d = handler3.f353d;
                    handler6.f354e = handler3.f354e;
                    handler6.f355f = handler3.f355f;
                    handler3.f351b = label3;
                    handler3.f355f = handler6;
                    return handler3;
                }
            }
        }
        return handler3;
    }
}

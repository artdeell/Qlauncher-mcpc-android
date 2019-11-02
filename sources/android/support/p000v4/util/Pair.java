package android.support.p000v4.util;

/* renamed from: android.support.v4.util.Pair */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s) {
        S s2 = s;
        this.first = f;
        this.second = s2;
    }

    public static <A, B> Pair<A, B> create(A a, B b) {
        Pair pair;
        Pair pair2 = pair;
        Pair pair3 = new Pair(a, b);
        return pair2;
    }

    private static boolean objectsEqual(Object obj, Object obj2) {
        Object obj3 = obj;
        Object obj4 = obj2;
        return obj3 == obj4 || (obj3 != null && obj3.equals(obj4));
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof Pair) {
            Pair pair = (Pair) obj2;
            if (objectsEqual(pair.first, this.first) && objectsEqual(pair.second, this.second)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.first == null ? 0 : this.first.hashCode();
        int i = 0;
        if (this.second != null) {
            i = this.second.hashCode();
        }
        return hashCode ^ i;
    }
}

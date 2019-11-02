package org.lwjgl.util.mapped;

import java.util.Iterator;
import org.lwjgl.util.mapped.MappedObject;

final class MappedForeach<T extends MappedObject> implements Iterable<T> {
    final int elementCount;
    final T mapped;

    MappedForeach(T t, int i) {
        int i2 = i;
        this.mapped = t;
        this.elementCount = i2;
    }

    public Iterator<T> iterator() {
        C08501 r4;
        C08501 r1 = r4;
        C08501 r2 = new Iterator<T>(this) {
            private int index;
            final /* synthetic */ MappedForeach this$0;

            {
                this.this$0 = r5;
            }

            public boolean hasNext() {
                return this.index < this.this$0.elementCount;
            }

            public T next() {
                T t = this.this$0.mapped;
                T t2 = this.this$0.mapped;
                int i = this.index;
                this.index = i + 1;
                t.setViewAddress(t2.getViewAddress(i));
                return this.this$0.mapped;
            }

            public void remove() {
                UnsupportedOperationException unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
                throw unsupportedOperationException2;
            }
        };
        return r1;
    }
}

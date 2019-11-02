package org.lwjgl.opengl;

import java.nio.IntBuffer;

final class StateTracker {
    private final StateStack attrib_stack;
    private boolean insideBeginEnd;
    private ReferencesStack references_stack;
    private final FastIntMap<VAOState> vaoMap;

    private static class VAOState {
        int elementArrayBuffer;

        private VAOState() {
        }

        /* synthetic */ VAOState(C08051 r4) {
            C08051 r1 = r4;
            this();
        }
    }

    StateTracker() {
        FastIntMap<VAOState> fastIntMap;
        StateStack stateStack;
        FastIntMap<VAOState> fastIntMap2 = fastIntMap;
        FastIntMap<VAOState> fastIntMap3 = new FastIntMap<>();
        this.vaoMap = fastIntMap2;
        StateStack stateStack2 = stateStack;
        StateStack stateStack3 = new StateStack(0);
        this.attrib_stack = stateStack2;
    }

    static void bindBuffer(ContextCapabilities contextCapabilities, int i, int i2) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        int i3 = i;
        int i4 = i2;
        References references = getReferences(contextCapabilities2);
        switch (i3) {
            case 34962:
                references.arrayBuffer = i4;
                return;
            case 34963:
                if (references.vertexArrayObject != 0) {
                    ((VAOState) contextCapabilities2.tracker.vaoMap.get(references.vertexArrayObject)).elementArrayBuffer = i4;
                    return;
                }
                references.elementArrayBuffer = i4;
                return;
            case 35051:
                references.pixelPackBuffer = i4;
                return;
            case 35052:
                references.pixelUnpackBuffer = i4;
                return;
            case 36671:
                references.indirectBuffer = i4;
                return;
            default:
                return;
        }
    }

    static void bindVAO(ContextCapabilities contextCapabilities, int i) {
        VAOState vAOState;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        int i2 = i;
        FastIntMap<VAOState> fastIntMap = contextCapabilities2.tracker.vaoMap;
        if (!fastIntMap.containsKey(i2)) {
            FastIntMap<VAOState> fastIntMap2 = fastIntMap;
            int i3 = i2;
            VAOState vAOState2 = vAOState;
            VAOState vAOState3 = new VAOState(null);
            Object put = fastIntMap2.put(i3, vAOState2);
        }
        getReferences(contextCapabilities2).vertexArrayObject = i2;
    }

    static void deleteVAO(ContextCapabilities contextCapabilities, int i) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        int i2 = i;
        Object remove = contextCapabilities2.tracker.vaoMap.remove(i2);
        References references = getReferences(contextCapabilities2);
        if (references.vertexArrayObject == i2) {
            references.vertexArrayObject = 0;
        }
    }

    static void deleteVAO(ContextCapabilities contextCapabilities, IntBuffer intBuffer) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        IntBuffer intBuffer2 = intBuffer;
        for (int position = intBuffer2.position(); position < intBuffer2.limit(); position++) {
            deleteVAO(contextCapabilities2, intBuffer2.get(position));
        }
    }

    private void doPopAttrib() {
        References popState = this.references_stack.popState(this.attrib_stack.popState());
    }

    private void doPushAttrib(int i) {
        this.attrib_stack.pushState(i);
        this.references_stack.pushState();
    }

    static int getElementArrayBufferBound(ContextCapabilities contextCapabilities) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        References references = getReferences(contextCapabilities2);
        return references.vertexArrayObject == 0 ? references.elementArrayBuffer : ((VAOState) contextCapabilities2.tracker.vaoMap.get(references.vertexArrayObject)).elementArrayBuffer;
    }

    static References getReferences(ContextCapabilities contextCapabilities) {
        return contextCapabilities.tracker.references_stack.getReferences();
    }

    static void popAttrib(ContextCapabilities contextCapabilities) {
        contextCapabilities.tracker.doPopAttrib();
    }

    static void pushAttrib(ContextCapabilities contextCapabilities, int i) {
        contextCapabilities.tracker.doPushAttrib(i);
    }

    static void setBeginEnd(ContextCapabilities contextCapabilities, boolean z) {
        contextCapabilities.tracker.insideBeginEnd = z;
    }

    /* access modifiers changed from: 0000 */
    public void init() {
        ReferencesStack referencesStack;
        ReferencesStack referencesStack2 = referencesStack;
        ReferencesStack referencesStack3 = new ReferencesStack();
        this.references_stack = referencesStack2;
    }

    /* access modifiers changed from: 0000 */
    public boolean isBeginEnd() {
        return this.insideBeginEnd;
    }
}

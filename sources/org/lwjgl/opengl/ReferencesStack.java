package org.lwjgl.opengl;

class ReferencesStack {
    private References[] references_stack = new References[1];
    private int stack_pos = 0;

    ReferencesStack() {
        References references;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        for (int i = 0; i < this.references_stack.length; i++) {
            References[] referencesArr = this.references_stack;
            int i2 = i;
            References references2 = references;
            References references3 = new References(capabilities);
            referencesArr[i2] = references2;
        }
    }

    private void growStack() {
        References references;
        References[] referencesArr = new References[(1 + this.references_stack.length)];
        System.arraycopy(this.references_stack, 0, referencesArr, 0, this.references_stack.length);
        this.references_stack = referencesArr;
        References[] referencesArr2 = this.references_stack;
        int length = -1 + this.references_stack.length;
        References references2 = references;
        References references3 = new References(GLContext.getCapabilities());
        referencesArr2[length] = references2;
    }

    public References getReferences() {
        return this.references_stack[this.stack_pos];
    }

    public References popState(int i) {
        int i2 = i;
        References[] referencesArr = this.references_stack;
        int i3 = this.stack_pos;
        this.stack_pos = i3 - 1;
        References references = referencesArr[i3];
        this.references_stack[this.stack_pos].copy(references, i2 ^ -1);
        references.clear();
        return references;
    }

    public void pushState() {
        int i = 1 + this.stack_pos;
        this.stack_pos = i;
        if (i == this.references_stack.length) {
            growStack();
        }
        this.references_stack[i].copy(this.references_stack[i - 1], -1);
    }
}

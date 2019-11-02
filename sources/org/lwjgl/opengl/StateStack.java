package org.lwjgl.opengl;

class StateStack {
    private int stack_pos = 0;
    private int[] state_stack = new int[1];

    StateStack(int i) {
        int i2 = i;
        this.state_stack[this.stack_pos] = i2;
    }

    public int getState() {
        return this.state_stack[this.stack_pos];
    }

    public void growState() {
        int[] iArr = new int[(1 + this.state_stack.length)];
        System.arraycopy(this.state_stack, 0, iArr, 0, this.state_stack.length);
        this.state_stack = iArr;
    }

    public int popState() {
        int[] iArr = this.state_stack;
        int i = this.stack_pos;
        this.stack_pos = i - 1;
        return iArr[i];
    }

    public void pushState(int i) {
        int i2 = i;
        int i3 = 1 + this.stack_pos;
        this.stack_pos = i3;
        if (i3 == this.state_stack.length) {
            growState();
        }
        this.state_stack[i3] = i2;
    }
}

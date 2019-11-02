package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier;

class OSXComponent extends AbstractComponent {
    private final OSXHIDElement element;

    public OSXComponent(Identifier identifier, OSXHIDElement oSXHIDElement) {
        Identifier identifier2 = identifier;
        OSXHIDElement oSXHIDElement2 = oSXHIDElement;
        super(identifier2.getName(), identifier2);
        this.element = oSXHIDElement2;
    }

    public final OSXHIDElement getElement() {
        return this.element;
    }

    public boolean isAnalog() {
        return this.element.isAnalog();
    }

    public final boolean isRelative() {
        return this.element.isRelative();
    }

    /* access modifiers changed from: protected */
    public float poll() throws IOException {
        return OSXControllers.poll(this.element);
    }
}

package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier;

public abstract class AbstractComponent implements Component {
    private float event_value;
    private boolean has_polled;

    /* renamed from: id */
    private final Identifier f27id;
    private final String name;
    private float value;

    protected AbstractComponent(String str, Identifier identifier) {
        Identifier identifier2 = identifier;
        this.name = str;
        this.f27id = identifier2;
    }

    public float getDeadZone() {
        return 0.0f;
    }

    /* access modifiers changed from: 0000 */
    public final float getEventValue() {
        return this.event_value;
    }

    public Identifier getIdentifier() {
        return this.f27id;
    }

    public String getName() {
        return this.name;
    }

    public final float getPollData() {
        StringBuffer stringBuffer;
        if (!this.has_polled && !isRelative()) {
            this.has_polled = true;
            try {
                setPollData(poll());
            } catch (IOException e) {
                IOException iOException = e;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                ControllerEnvironment.log(stringBuffer2.append("Failed to poll component: ").append(iOException).toString());
            }
        }
        return this.value;
    }

    public boolean isAnalog() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract float poll() throws IOException;

    /* access modifiers changed from: 0000 */
    public final void resetHasPolled() {
        this.has_polled = false;
    }

    /* access modifiers changed from: 0000 */
    public final void setEventValue(float f) {
        float f2 = f;
        this.event_value = f2;
    }

    /* access modifiers changed from: 0000 */
    public final void setPollData(float f) {
        float f2 = f;
        this.value = f2;
    }

    public String toString() {
        return this.name;
    }
}

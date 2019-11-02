package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Component.Identifier.Button;
import net.java.games.input.Component.Identifier.Key;

final class IDirectInputDevice {
    public static final int DI8DEVTYPE_1STPERSON = 24;
    public static final int DI8DEVTYPE_DEVICE = 17;
    public static final int DI8DEVTYPE_DEVICECTRL = 25;
    public static final int DI8DEVTYPE_DRIVING = 22;
    public static final int DI8DEVTYPE_FLIGHT = 23;
    public static final int DI8DEVTYPE_GAMEPAD = 21;
    public static final int DI8DEVTYPE_JOYSTICK = 20;
    public static final int DI8DEVTYPE_KEYBOARD = 19;
    public static final int DI8DEVTYPE_MOUSE = 18;
    public static final int DI8DEVTYPE_REMOTE = 27;
    public static final int DI8DEVTYPE_SCREENPOINTER = 26;
    public static final int DI8DEVTYPE_SUPPLEMENTAL = 28;
    public static final int DIDFT_ABSAXIS = 2;
    public static final int DIDFT_ALIAS = 134217728;
    public static final int DIDFT_ALL = 0;
    public static final int DIDFT_AXIS = 3;
    public static final int DIDFT_BUTTON = 12;
    public static final int DIDFT_COLLECTION = 64;
    public static final int DIDFT_FFACTUATOR = 16777216;
    public static final int DIDFT_FFEFFECTTRIGGER = 33554432;
    public static final int DIDFT_NOCOLLECTION = 16776960;
    public static final int DIDFT_NODATA = 128;
    public static final int DIDFT_OPTIONAL = Integer.MIN_VALUE;
    public static final int DIDFT_OUTPUT = 268435456;
    public static final int DIDFT_POV = 16;
    public static final int DIDFT_PSHBUTTON = 4;
    public static final int DIDFT_RELAXIS = 1;
    public static final int DIDFT_TGLBUTTON = 8;
    public static final int DIDFT_VENDORDEFINED = 67108864;
    public static final int DIDF_ABSAXIS = 1;
    public static final int DIDF_RELAXIS = 2;
    public static final int DIDOI_ASPECTACCEL = 768;
    public static final int DIDOI_ASPECTFORCE = 1024;
    public static final int DIDOI_ASPECTMASK = 3840;
    public static final int DIDOI_ASPECTPOSITION = 256;
    public static final int DIDOI_ASPECTVELOCITY = 512;
    public static final int DIDOI_FFACTUATOR = 1;
    public static final int DIDOI_FFEFFECTTRIGGER = 2;
    public static final int DIDOI_GUIDISUSAGE = 65536;
    public static final int DIDOI_POLLED = 32768;
    public static final int DIEB_NOTRIGGER = -1;
    public static final int DIEFF_CARTESIAN = 16;
    public static final int DIEFF_OBJECTIDS = 1;
    public static final int DIEFF_OBJECTOFFSETS = 2;
    public static final int DIEFF_POLAR = 32;
    public static final int DIEFF_SPHERICAL = 64;
    public static final int DIEFT_ALL = 0;
    public static final int DIEFT_CONDITION = 4;
    public static final int DIEFT_CONSTANTFORCE = 1;
    public static final int DIEFT_CUSTOMFORCE = 5;
    public static final int DIEFT_DEADBAND = 16384;
    public static final int DIEFT_FFATTACK = 512;
    public static final int DIEFT_FFFADE = 1024;
    public static final int DIEFT_HARDWARE = 255;
    public static final int DIEFT_PERIODIC = 3;
    public static final int DIEFT_POSNEGCOEFFICIENTS = 4096;
    public static final int DIEFT_POSNEGSATURATION = 8192;
    public static final int DIEFT_RAMPFORCE = 2;
    public static final int DIEFT_SATURATION = 2048;
    public static final int DIEFT_STARTDELAY = 32768;
    public static final int DIEP_ALLPARAMS = 1023;
    public static final int DIEP_ALLPARAMS_DX5 = 511;
    public static final int DIEP_AXES = 32;
    public static final int DIEP_DIRECTION = 64;
    public static final int DIEP_DURATION = 1;
    public static final int DIEP_ENVELOPE = 128;
    public static final int DIEP_GAIN = 4;
    public static final int DIEP_NODOWNLOAD = Integer.MIN_VALUE;
    public static final int DIEP_NORESTART = 1073741824;
    public static final int DIEP_SAMPLEPERIOD = 2;
    public static final int DIEP_START = 536870912;
    public static final int DIEP_STARTDELAY = 512;
    public static final int DIEP_TRIGGERBUTTON = 8;
    public static final int DIEP_TRIGGERREPEATINTERVAL = 16;
    public static final int DIEP_TYPESPECIFICPARAMS = 256;
    public static final int DIERR_INPUTLOST = -2147024866;
    public static final int DIERR_NOTACQUIRED = -2147024868;
    public static final int DIERR_OTHERAPPHASPRIO = -2147024891;
    public static final int DIPROPRANGE_NOMAX = Integer.MAX_VALUE;
    public static final int DIPROPRANGE_NOMIN = Integer.MIN_VALUE;
    public static final int DISCL_BACKGROUND = 8;
    public static final int DISCL_EXCLUSIVE = 1;
    public static final int DISCL_FOREGROUND = 4;
    public static final int DISCL_NONEXCLUSIVE = 2;
    public static final int DISCL_NOWINKEY = 16;
    public static final int DI_BUFFEROVERFLOW = 1;
    public static final int DI_DEGREES = 100;
    public static final int DI_DOWNLOADSKIPPED = 3;
    public static final int DI_EFFECTRESTARTED = 4;
    public static final int DI_FFNOMINALMAX = 10000;
    public static final int DI_NOEFFECT = 1;
    public static final int DI_OK = 0;
    public static final int DI_POLLEDDEVICE = 2;
    public static final int DI_PROPNOEFFECT = 1;
    public static final int DI_SECONDS = 1000000;
    public static final int DI_SETTINGSNOTSAVED = 11;
    public static final int DI_TRUNCATED = 8;
    public static final int DI_TRUNCATEDANDRESTARTED = 12;
    public static final int GUID_Button = 8;
    public static final int GUID_ConstantForce = 12;
    public static final int GUID_CustomForce = 23;
    public static final int GUID_Damper = 20;
    public static final int GUID_Friction = 22;
    public static final int GUID_Inertia = 21;
    public static final int GUID_Key = 9;
    public static final int GUID_POV = 10;
    public static final int GUID_RampForce = 13;
    public static final int GUID_RxAxis = 4;
    public static final int GUID_RyAxis = 5;
    public static final int GUID_RzAxis = 6;
    public static final int GUID_SawtoothDown = 18;
    public static final int GUID_SawtoothUp = 17;
    public static final int GUID_Sine = 15;
    public static final int GUID_Slider = 7;
    public static final int GUID_Spring = 19;
    public static final int GUID_Square = 14;
    public static final int GUID_Triangle = 16;
    public static final int GUID_Unknown = 11;
    public static final int GUID_XAxis = 1;
    public static final int GUID_YAxis = 2;
    public static final int GUID_ZAxis = 3;
    public static final int INFINITE = -1;
    static Class class$net$java$games$input$DIDeviceObjectData;
    private final long address;
    private final boolean axes_in_relative_mode;
    private int button_counter;
    private int current_format_offset;
    private final int dev_subtype;
    private final int dev_type;
    private final int[] device_state;
    private final List effects;
    private final String instance_name;
    private final Map object_to_component;
    private final List objects;
    private final String product_name;
    private DataQueue queue;
    private boolean released;
    private final List rumblers;
    private final DummyWindow window;

    public IDirectInputDevice(DummyWindow dummyWindow, long j, byte[] bArr, byte[] bArr2, int i, int i2, String str, String str2) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashMap hashMap;
        StringBuffer stringBuffer;
        DummyWindow dummyWindow2 = dummyWindow;
        long j2 = j;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i3 = i;
        int i4 = i2;
        String str3 = str;
        String str4 = str2;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = new ArrayList();
        this.objects = arrayList4;
        ArrayList arrayList6 = arrayList2;
        ArrayList arrayList7 = new ArrayList();
        this.effects = arrayList6;
        ArrayList arrayList8 = arrayList3;
        ArrayList arrayList9 = new ArrayList();
        this.rumblers = arrayList8;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.object_to_component = hashMap2;
        this.window = dummyWindow2;
        this.address = j2;
        this.product_name = str4;
        this.instance_name = str3;
        this.dev_type = i3;
        this.dev_subtype = i4;
        enumObjects();
        try {
            enumEffects();
            List createRumblers = createRumblers();
        } catch (IOException e) {
            IOException iOException = e;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            DirectInputEnvironmentPlugin.logln(stringBuffer2.append("Failed to create rumblers: ").append(iOException.getMessage()).toString());
        }
        boolean z = true;
        boolean z2 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= this.objects.size()) {
                break;
            }
            DIDeviceObject dIDeviceObject = (DIDeviceObject) this.objects.get(i5);
            if (dIDeviceObject.isAxis()) {
                z2 = true;
                if (!dIDeviceObject.isRelative()) {
                    z = false;
                    break;
                }
            }
            i5++;
        }
        this.axes_in_relative_mode = z && z2;
        setDataFormat(z ? 2 : 1);
        if (this.rumblers.size() > 0) {
            try {
                setCooperativeLevel(9);
            } catch (IOException e2) {
                IOException iOException2 = e2;
                setCooperativeLevel(10);
            }
        } else {
            setCooperativeLevel(10);
        }
        setBufferSize(32);
        acquire();
        this.device_state = new int[this.objects.size()];
    }

    private final void acquire() throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int nAcquire = nAcquire(this.address);
        if (nAcquire != 0 && nAcquire != -2147024891 && nAcquire != 1) {
            IOException iOException2 = iOException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            IOException iOException3 = new IOException(stringBuffer2.append("Failed to acquire device (").append(Integer.toHexString(nAcquire)).append(")").toString());
            throw iOException2;
        }
    }

    private final void addEffect(byte[] bArr, int i, int i2, int i3, int i4, String str) {
        DIEffectInfo dIEffectInfo;
        byte[] bArr2 = bArr;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        String str2 = str;
        List list = this.effects;
        DIEffectInfo dIEffectInfo2 = dIEffectInfo;
        DIEffectInfo dIEffectInfo3 = new DIEffectInfo(this, bArr2, i5, i6, i7, i8, str2);
        boolean add = list.add(dIEffectInfo2);
    }

    private final void addObject(byte[] bArr, int i, int i2, int i3, int i4, int i5, String str) throws IOException {
        DIDeviceObject dIDeviceObject;
        byte[] bArr2 = bArr;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        String str2 = str;
        Identifier identifier = getIdentifier(i6, i8, i9);
        int i11 = this.current_format_offset;
        this.current_format_offset = i11 + 1;
        DIDeviceObject dIDeviceObject2 = dIDeviceObject;
        DIDeviceObject dIDeviceObject3 = new DIDeviceObject(this, identifier, bArr2, i6, i7, i8, i9, i10, str2, i11);
        boolean add = this.objects.add(dIDeviceObject2);
    }

    private final void checkReleased() throws IOException {
        IOException iOException;
        if (this.released) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException("Device is released");
            throw iOException2;
        }
    }

    static Class class$(String str) {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError();
            throw noClassDefFoundError2.initCause(classNotFoundException);
        }
    }

    private final Rumbler createPeriodicRumbler(DIDeviceObject[] dIDeviceObjectArr, long[] jArr, DIEffectInfo dIEffectInfo) throws IOException {
        IDirectInputEffect iDirectInputEffect;
        DIDeviceObject[] dIDeviceObjectArr2 = dIDeviceObjectArr;
        long[] jArr2 = jArr;
        DIEffectInfo dIEffectInfo2 = dIEffectInfo;
        int[] iArr = new int[dIDeviceObjectArr2.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = dIDeviceObjectArr2[i].getDIIdentifier();
        }
        IDirectInputEffect iDirectInputEffect2 = iDirectInputEffect;
        IDirectInputEffect iDirectInputEffect3 = new IDirectInputEffect(nCreatePeriodicEffect(this.address, dIEffectInfo2.getGUID(), 17, -1, 0, DI_FFNOMINALMAX, -1, 0, iArr, jArr2, 0, 0, 0, 0, DI_FFNOMINALMAX, 0, 0, 50000, 0), dIEffectInfo2);
        return iDirectInputEffect2;
    }

    private final List createRumblers() throws IOException {
        DIDeviceObject lookupObjectByGUID = lookupObjectByGUID(1);
        if (lookupObjectByGUID == null) {
            return this.rumblers;
        }
        DIDeviceObject[] dIDeviceObjectArr = new DIDeviceObject[1];
        DIDeviceObject[] dIDeviceObjectArr2 = dIDeviceObjectArr;
        dIDeviceObjectArr[0] = lookupObjectByGUID;
        DIDeviceObject[] dIDeviceObjectArr3 = dIDeviceObjectArr2;
        long[] jArr = new long[1];
        long[] jArr2 = jArr;
        jArr[0] = 0;
        long[] jArr3 = jArr2;
        for (int i = 0; i < this.effects.size(); i++) {
            DIEffectInfo dIEffectInfo = (DIEffectInfo) this.effects.get(i);
            if ((255 & dIEffectInfo.getEffectType()) == 3 && (4 & dIEffectInfo.getDynamicParams()) != 0) {
                boolean add = this.rumblers.add(createPeriodicRumbler(dIDeviceObjectArr3, jArr3, dIEffectInfo));
            }
        }
        return this.rumblers;
    }

    private final void enumEffects() throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int nEnumEffects = nEnumEffects(this.address, 0);
        if (nEnumEffects != 0) {
            IOException iOException2 = iOException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            IOException iOException3 = new IOException(stringBuffer2.append("Failed to enumerate effects (").append(Integer.toHexString(nEnumEffects)).append(")").toString());
            throw iOException2;
        }
    }

    private final void enumObjects() throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int nEnumObjects = nEnumObjects(this.address, 31);
        if (nEnumObjects != 0) {
            IOException iOException2 = iOException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            IOException iOException3 = new IOException(stringBuffer2.append("Failed to enumerate objects (").append(Integer.toHexString(nEnumObjects)).append(")").toString());
            throw iOException2;
        }
    }

    private final boolean getDeviceData(DataQueue dataQueue) throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        DataQueue dataQueue2 = dataQueue;
        int nGetDeviceData = nGetDeviceData(this.address, 0, dataQueue2, dataQueue2.getElements(), dataQueue2.position(), dataQueue2.remaining());
        if (nGetDeviceData == 0 || nGetDeviceData == 1) {
            return true;
        }
        if (nGetDeviceData == -2147024868) {
            acquire();
            return false;
        }
        IOException iOException2 = iOException;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        IOException iOException3 = new IOException(stringBuffer2.append("Failed to get device data (").append(Integer.toHexString(nGetDeviceData)).append(")").toString());
        throw iOException2;
    }

    private final void getDeviceState(int[] iArr) throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int[] iArr2 = iArr;
        int nGetDeviceState = nGetDeviceState(this.address, iArr2);
        if (nGetDeviceState == 0) {
            return;
        }
        if (nGetDeviceState == -2147024868) {
            Arrays.fill(iArr2, 0);
            acquire();
            return;
        }
        IOException iOException2 = iOException;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        IOException iOException3 = new IOException(stringBuffer2.append("Failed to get device state (").append(Integer.toHexString(nGetDeviceState)).append(")").toString());
        throw iOException2;
    }

    private final Identifier getIdentifier(int i, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        switch (i) {
            case 1:
                return Axis.f31X;
            case 2:
                return Axis.f32Y;
            case 3:
                return Axis.f33Z;
            case 4:
                return Axis.f28RX;
            case 5:
                return Axis.f29RY;
            case 6:
                return Axis.f30RZ;
            case 7:
                return Axis.SLIDER;
            case 8:
                return getNextButtonIdentifier();
            case 9:
                return getKeyIdentifier(i5);
            case 10:
                return Axis.POV;
            default:
                return Axis.UNKNOWN;
        }
    }

    private static final Key getKeyIdentifier(int i) {
        return DIIdentifierMap.getKeyIdentifier(i);
    }

    private final Button getNextButtonIdentifier() {
        int i = this.button_counter;
        this.button_counter = i + 1;
        return DIIdentifierMap.getButtonIdentifier(i);
    }

    private final DIDeviceObject lookupObjectByGUID(int i) {
        int i2 = i;
        for (int i3 = 0; i3 < this.objects.size(); i3++) {
            DIDeviceObject dIDeviceObject = (DIDeviceObject) this.objects.get(i3);
            if (i2 == dIDeviceObject.getGUIDType()) {
                return dIDeviceObject;
            }
        }
        return null;
    }

    private static final native int nAcquire(long j);

    private static final native long nCreatePeriodicEffect(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, long[] jArr, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) throws IOException;

    private final native int nEnumEffects(long j, int i);

    private final native int nEnumObjects(long j, int i);

    private static final native int nGetDeadzoneProperty(long j, int i) throws IOException;

    private static final native int nGetDeviceData(long j, int i, DataQueue dataQueue, Object[] objArr, int i2, int i3);

    private static final native int nGetDeviceState(long j, int[] iArr);

    private static final native int nGetRangeProperty(long j, int i, long[] jArr);

    private static final native int nPoll(long j) throws IOException;

    private static final native void nRelease(long j);

    private static final native int nSetBufferSize(long j, int i);

    private static final native int nSetCooperativeLevel(long j, long j2, int i);

    private static final native int nSetDataFormat(long j, int i, DIDeviceObject[] dIDeviceObjectArr);

    private static final native int nUnacquire(long j);

    private final void poll() throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int nPoll = nPoll(this.address);
        if (nPoll != 0 && nPoll != 1) {
            if (nPoll == -2147024868) {
                acquire();
                return;
            }
            IOException iOException2 = iOException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            IOException iOException3 = new IOException(stringBuffer2.append("Failed to poll device (").append(Integer.toHexString(nPoll)).append(")").toString());
            throw iOException2;
        }
    }

    private final void setDataFormat(int i) throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int i2 = i;
        DIDeviceObject[] dIDeviceObjectArr = new DIDeviceObject[this.objects.size()];
        Object[] array = this.objects.toArray(dIDeviceObjectArr);
        int nSetDataFormat = nSetDataFormat(this.address, i2, dIDeviceObjectArr);
        if (nSetDataFormat != 0) {
            IOException iOException2 = iOException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            IOException iOException3 = new IOException(stringBuffer2.append("Failed to set data format (").append(Integer.toHexString(nSetDataFormat)).append(")").toString());
            throw iOException2;
        }
    }

    private final void unacquire() throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int nUnacquire = nUnacquire(this.address);
        if (nUnacquire != 0 && nUnacquire != 1) {
            IOException iOException2 = iOException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            IOException iOException3 = new IOException(stringBuffer2.append("Failed to unAcquire device (").append(Integer.toHexString(nUnacquire)).append(")").toString());
            throw iOException2;
        }
    }

    public final boolean areAxesRelative() {
        return this.axes_in_relative_mode;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        release();
    }

    public final int getDeadzoneProperty(int i) throws IOException {
        int i2;
        int i3 = i;
        synchronized (this) {
            try {
                checkReleased();
                th = nGetDeadzoneProperty(this.address, i3);
            } finally {
                i2 = th;
                Throwable th = i2;
            }
        }
        return i2;
    }

    public final boolean getNextEvent(DIDeviceObjectData dIDeviceObjectData) {
        boolean z;
        DIDeviceObjectData dIDeviceObjectData2 = dIDeviceObjectData;
        synchronized (this) {
            try {
                th = (DIDeviceObjectData) this.queue.get();
                if (this == null) {
                    z = false;
                } else {
                    dIDeviceObjectData2.set(this);
                    z = true;
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return z;
    }

    public final List getObjects() {
        return this.objects;
    }

    public final int getPollData(DIDeviceObject dIDeviceObject) {
        return this.device_state[dIDeviceObject.getFormatOffset()];
    }

    public final String getProductName() {
        return this.product_name;
    }

    public final long[] getRangeProperty(int i) throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int i2 = i;
        synchronized (this) {
            try {
                checkReleased();
                th = new long[2];
                int nGetRangeProperty = nGetRangeProperty(this.address, i2, th);
                if (nGetRangeProperty != 0) {
                    IOException iOException2 = iOException;
                    StringBuffer stringBuffer2 = stringBuffer;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    IOException iOException3 = new IOException(stringBuffer2.append("Failed to get object range (").append(nGetRangeProperty).append(")").toString());
                    throw iOException2;
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public final Rumbler[] getRumblers() {
        return (Rumbler[]) this.rumblers.toArray(new Rumbler[0]);
    }

    public final int getType() {
        return this.dev_type;
    }

    public final DIDeviceObject mapEvent(DIDeviceObjectData dIDeviceObjectData) {
        return (DIDeviceObject) this.objects.get(dIDeviceObjectData.getFormatOffset() / 4);
    }

    public final DIComponent mapObject(DIDeviceObject dIDeviceObject) {
        return (DIComponent) this.object_to_component.get(dIDeviceObject);
    }

    public final void pollAll() throws IOException {
        synchronized (this) {
            try {
                checkReleased();
                poll();
                getDeviceState(this.device_state);
                this.queue.compact();
                boolean deviceData = getDeviceData(this.queue);
                this.queue.flip();
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final void registerComponent(DIDeviceObject dIDeviceObject, DIComponent dIComponent) {
        DIDeviceObject dIDeviceObject2 = dIDeviceObject;
        DIComponent dIComponent2 = dIComponent;
        Object put = this.object_to_component.put(dIDeviceObject2, dIComponent2);
    }

    /* JADX INFO: finally extract failed */
    public final void release() {
        synchronized (this) {
            try {
                if (!this.released) {
                    this.released = true;
                    for (int i = 0; i < this.rumblers.size(); i++) {
                        ((IDirectInputEffect) this.rumblers.get(i)).release();
                    }
                    nRelease(this.address);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void setBufferSize(int i) throws IOException {
        Class cls;
        DataQueue dataQueue;
        IOException iOException;
        StringBuffer stringBuffer;
        int i2 = i;
        synchronized (this) {
            try {
                checkReleased();
                unacquire();
                int nSetBufferSize = nSetBufferSize(this.address, i2);
                if (nSetBufferSize == 0 || nSetBufferSize == 1 || nSetBufferSize == 2) {
                    if (class$net$java$games$input$DIDeviceObjectData == null) {
                        cls = class$("net.java.games.input.DIDeviceObjectData");
                        class$net$java$games$input$DIDeviceObjectData = cls;
                    } else {
                        cls = class$net$java$games$input$DIDeviceObjectData;
                    }
                    DataQueue dataQueue2 = dataQueue;
                    DataQueue dataQueue3 = new DataQueue(i2, cls);
                    this.queue = dataQueue2;
                    this.queue.position(this.queue.limit());
                    acquire();
                } else {
                    IOException iOException2 = iOException;
                    StringBuffer stringBuffer2 = stringBuffer;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    IOException iOException3 = new IOException(stringBuffer2.append("Failed to set buffer size (").append(Integer.toHexString(nSetBufferSize)).append(")").toString());
                    throw iOException2;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final void setCooperativeLevel(int i) throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int i2 = i;
        synchronized (this) {
            try {
                checkReleased();
                int nSetCooperativeLevel = nSetCooperativeLevel(this.address, this.window.getHwnd(), i2);
                if (nSetCooperativeLevel != 0) {
                    IOException iOException2 = iOException;
                    StringBuffer stringBuffer2 = stringBuffer;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    IOException iOException3 = new IOException(stringBuffer2.append("Failed to set cooperative level (").append(Integer.toHexString(nSetCooperativeLevel)).append(")").toString());
                    throw iOException2;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}

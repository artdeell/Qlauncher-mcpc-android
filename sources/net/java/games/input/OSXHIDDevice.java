package net.java.games.input;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.java.games.input.Controller.PortType;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

final class OSXHIDDevice {
    private static final int AXIS_DEFAULT_MAX_VALUE = 65536;
    private static final int AXIS_DEFAULT_MIN_VALUE = 0;
    private static final String kIOHIDCountryCodeKey = "CountryCode";
    private static final String kIOHIDDeviceUsageKey = "DeviceUsage";
    private static final String kIOHIDDeviceUsagePageKey = "DeviceUsagePage";
    private static final String kIOHIDDeviceUsagePairsKey = "DeviceUsagePairs";
    private static final String kIOHIDElementCollectionTypeKey = "CollectionType";
    private static final String kIOHIDElementCookieKey = "ElementCookie";
    private static final String kIOHIDElementDuplicateIndexKey = "DuplicateIndex";
    private static final String kIOHIDElementHasNullStateKey = "HasNullState";
    private static final String kIOHIDElementHasPreferredStateKey = "HasPreferredState";
    private static final String kIOHIDElementIsArrayKey = "IsArray";
    private static final String kIOHIDElementIsNonLinearKey = "IsNonLinear";
    private static final String kIOHIDElementIsRelativeKey = "IsRelative";
    private static final String kIOHIDElementIsWrappingKey = "IsWrapping";
    private static final String kIOHIDElementKey = "Elements";
    private static final String kIOHIDElementMaxKey = "Max";
    private static final String kIOHIDElementMinKey = "Min";
    private static final String kIOHIDElementNameKey = "Name";
    private static final String kIOHIDElementParentCollectionKey = "ParentCollection";
    private static final String kIOHIDElementReportCountKey = "ReportCount";
    private static final String kIOHIDElementReportIDKey = "ReportID";
    private static final String kIOHIDElementReportSizeKey = "ReportSize";
    private static final String kIOHIDElementScaledMaxKey = "ScaledMax";
    private static final String kIOHIDElementScaledMinKey = "ScaledMin";
    private static final String kIOHIDElementSizeKey = "Size";
    private static final String kIOHIDElementTypeKey = "Type";
    private static final String kIOHIDElementUnitExponentKey = "UnitExponent";
    private static final String kIOHIDElementUnitKey = "Unit";
    private static final String kIOHIDElementUsageKey = "Usage";
    private static final String kIOHIDElementUsagePageKey = "UsagePage";
    private static final String kIOHIDElementValueLocationKey = "ValueLocation";
    private static final String kIOHIDLocationIDKey = "LocationID";
    private static final String kIOHIDManufacturerKey = "Manufacturer";
    private static final String kIOHIDMaxFeatureReportSizeKey = "MaxFeatureReportSize";
    private static final String kIOHIDMaxInputReportSizeKey = "MaxInputReportSize";
    private static final String kIOHIDMaxOutputReportSizeKey = "MaxOutputReportSize";
    private static final String kIOHIDPrimaryUsageKey = "PrimaryUsage";
    private static final String kIOHIDPrimaryUsagePageKey = "PrimaryUsagePage";
    private static final String kIOHIDProductIDKey = "ProductID";
    private static final String kIOHIDProductKey = "Product";
    private static final String kIOHIDSerialNumberKey = "SerialNumber";
    private static final String kIOHIDTransportKey = "Transport";
    private static final String kIOHIDVendorIDKey = "VendorID";
    private static final String kIOHIDVendorIDSourceKey = "VendorIDSource";
    private static final String kIOHIDVersionNumberKey = "VersionNumber";
    private final long device_address;
    private final long device_interface_address;
    private final Map properties = getDeviceProperties();
    private boolean released;

    public OSXHIDDevice(long j, long j2) throws IOException {
        long j3 = j2;
        this.device_address = j;
        this.device_interface_address = j3;
        open();
    }

    private final void addElements(List list, Map map) {
        List list2 = list;
        Object[] objArr = (Object[]) map.get(kIOHIDElementKey);
        if (objArr != null) {
            for (int i = 0; i < objArr.length; i++) {
                Map map2 = (Map) objArr[i];
                OSXHIDElement createElementFromElementProperties = createElementFromElementProperties(map2);
                if (createElementFromElementProperties != null) {
                    boolean add = list2.add(createElementFromElementProperties);
                }
                addElements(list2, map2);
            }
        }
    }

    private final void checkReleased() throws IOException {
        IOException iOException;
        if (this.released) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException();
            throw iOException2;
        }
    }

    private final void close() throws IOException {
        nClose(this.device_interface_address);
    }

    private final OSXHIDElement createElementFromElementProperties(Map map) {
        OSXHIDElement oSXHIDElement;
        Map map2 = map;
        long longFromProperties = getLongFromProperties(map2, kIOHIDElementCookieKey);
        ElementType map3 = ElementType.map(getIntFromProperties(map2, kIOHIDElementTypeKey));
        int longFromProperties2 = (int) getLongFromProperties(map2, kIOHIDElementMinKey, 0);
        int longFromProperties3 = (int) getLongFromProperties(map2, kIOHIDElementMaxKey, 65536);
        UsagePair usagePair = getUsagePair();
        boolean booleanFromProperties = getBooleanFromProperties(map2, kIOHIDElementIsRelativeKey, usagePair != null && (usagePair.getUsage() == GenericDesktopUsage.POINTER || usagePair.getUsage() == GenericDesktopUsage.MOUSE));
        UsagePair createUsagePair = createUsagePair(getIntFromProperties(map2, kIOHIDElementUsagePageKey), getIntFromProperties(map2, kIOHIDElementUsageKey));
        if (createUsagePair == null || (map3 != ElementType.INPUT_MISC && map3 != ElementType.INPUT_BUTTON && map3 != ElementType.INPUT_AXIS)) {
            return null;
        }
        OSXHIDElement oSXHIDElement2 = oSXHIDElement;
        OSXHIDElement oSXHIDElement3 = new OSXHIDElement(this, createUsagePair, longFromProperties, map3, longFromProperties2, longFromProperties3, booleanFromProperties);
        return oSXHIDElement2;
    }

    private static final UsagePair createUsagePair(int i, int i2) {
        UsagePair usagePair;
        int i3 = i2;
        UsagePage map = UsagePage.map(i);
        if (map != null) {
            Usage mapUsage = map.mapUsage(i3);
            if (mapUsage != null) {
                UsagePair usagePair2 = usagePair;
                UsagePair usagePair3 = new UsagePair(map, mapUsage);
                return usagePair2;
            }
        }
        return null;
    }

    private static final void dumpArray(String str, Object[] objArr) {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        String str2 = str;
        Object[] objArr2 = objArr;
        PrintStream printStream = System.out;
        StringBuffer stringBuffer5 = stringBuffer;
        StringBuffer stringBuffer6 = new StringBuffer();
        printStream.println(stringBuffer5.append(str2).append("{").toString());
        for (int i = 0; i < objArr2.length; i++) {
            StringBuffer stringBuffer7 = stringBuffer3;
            StringBuffer stringBuffer8 = new StringBuffer();
            dumpObject(stringBuffer7.append(str2).append("\t").toString(), objArr2[i]);
            PrintStream printStream2 = System.out;
            StringBuffer stringBuffer9 = stringBuffer4;
            StringBuffer stringBuffer10 = new StringBuffer();
            printStream2.println(stringBuffer9.append(str2).append(",").toString());
        }
        PrintStream printStream3 = System.out;
        StringBuffer stringBuffer11 = stringBuffer2;
        StringBuffer stringBuffer12 = new StringBuffer();
        printStream3.println(stringBuffer11.append(str2).append("}").toString());
    }

    private static final void dumpMap(String str, Map map) {
        StringBuffer stringBuffer;
        String str2 = str;
        Map map2 = map;
        for (Object next : map2.keySet()) {
            Object obj = map2.get(next);
            dumpObject(str2, next);
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            dumpObject(stringBuffer2.append(str2).append("\t").toString(), obj);
        }
    }

    private static final void dumpObject(String str, Object obj) {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        String str2 = str;
        Object obj2 = obj;
        if (obj2 instanceof Long) {
            Long l = (Long) obj2;
            PrintStream printStream = System.out;
            StringBuffer stringBuffer3 = stringBuffer2;
            StringBuffer stringBuffer4 = new StringBuffer();
            printStream.println(stringBuffer3.append(str2).append("0x").append(Long.toHexString(l.longValue())).toString());
        } else if (obj2 instanceof Map) {
            dumpMap(str2, (Map) obj2);
        } else if (obj2.getClass().isArray()) {
            dumpArray(str2, (Object[]) obj2);
        } else {
            PrintStream printStream2 = System.out;
            StringBuffer stringBuffer5 = stringBuffer;
            StringBuffer stringBuffer6 = new StringBuffer();
            printStream2.println(stringBuffer5.append(str2).append(obj2).toString());
        }
    }

    private final void dumpProperties() {
        System.out.println(toString());
        dumpMap(LibrariesRepository.MOJANG_MAVEN_REPO, this.properties);
    }

    private static final boolean getBooleanFromProperties(Map map, String str, boolean z) {
        return getLongFromProperties(map, str, z ? 1 : 0) != 0;
    }

    private final Map getDeviceProperties() throws IOException {
        return nGetDeviceProperties(this.device_address);
    }

    private static final int getIntFromProperties(Map map, String str) {
        return (int) getLongFromProperties(map, str);
    }

    private static final long getLongFromProperties(Map map, String str) {
        return ((Long) map.get(str)).longValue();
    }

    private static final long getLongFromProperties(Map map, String str, long j) {
        Long l = (Long) map.get(str);
        return l == null ? j : l.longValue();
    }

    private static final native void nClose(long j) throws IOException;

    private static final native long nCreateQueue(long j) throws IOException;

    private static final native Map nGetDeviceProperties(long j) throws IOException;

    private static final native void nGetElementValue(long j, long j2, OSXEvent oSXEvent) throws IOException;

    private static final native void nOpen(long j) throws IOException;

    private static final native void nReleaseDevice(long j, long j2);

    private final void open() throws IOException {
        nOpen(this.device_interface_address);
    }

    public final OSXHIDQueue createQueue(int i) throws IOException {
        OSXHIDQueue oSXHIDQueue;
        OSXHIDQueue oSXHIDQueue2;
        int i2 = i;
        synchronized (this) {
            try {
                checkReleased();
                th = oSXHIDQueue2;
                OSXHIDQueue oSXHIDQueue3 = new OSXHIDQueue(nCreateQueue(this.device_interface_address), i2);
            } finally {
                oSXHIDQueue = th;
                Throwable th = oSXHIDQueue;
            }
        }
        return oSXHIDQueue;
    }

    public final void getElementValue(long j, OSXEvent oSXEvent) throws IOException {
        long j2 = j;
        OSXEvent oSXEvent2 = oSXEvent;
        synchronized (this) {
            try {
                checkReleased();
                nGetElementValue(this.device_interface_address, j2, oSXEvent2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final List getElements() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        addElements(arrayList4, this.properties);
        return arrayList4;
    }

    public final PortType getPortType() {
        String str = (String) this.properties.get(kIOHIDTransportKey);
        return str == null ? PortType.UNKNOWN : str.equals("USB") ? PortType.USB : PortType.UNKNOWN;
    }

    public final String getProductName() {
        return (String) this.properties.get(kIOHIDProductKey);
    }

    public final UsagePair getUsagePair() {
        return createUsagePair(getIntFromProperties(this.properties, kIOHIDPrimaryUsagePageKey), getIntFromProperties(this.properties, kIOHIDPrimaryUsageKey));
    }

    public final void release() throws IOException {
        synchronized (this) {
            try {
                close();
                this.released = true;
                nReleaseDevice(this.device_address, this.device_interface_address);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}

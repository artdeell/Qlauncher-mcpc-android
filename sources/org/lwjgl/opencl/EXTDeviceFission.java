package org.lwjgl.opencl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class EXTDeviceFission {
    public static final int CL_AFFINITY_DOMAIN_L1_CACHE_EXT = 1;
    public static final int CL_AFFINITY_DOMAIN_L2_CACHE_EXT = 2;
    public static final int CL_AFFINITY_DOMAIN_L3_CACHE_EXT = 3;
    public static final int CL_AFFINITY_DOMAIN_L4_CACHE_EXT = 4;
    public static final int CL_AFFINITY_DOMAIN_NEXT_FISSIONABLE_EXT = 256;
    public static final int CL_AFFINITY_DOMAIN_NUMA_EXT = 16;
    public static final int CL_DEVICE_AFFINITY_DOMAINS_EXT = 16470;
    public static final int CL_DEVICE_PARENT_DEVICE_EXT = 16468;
    public static final int CL_DEVICE_PARITION_TYPES_EXT = 16469;
    public static final int CL_DEVICE_PARTITION_BY_AFFINITY_DOMAIN_EXT = 16467;
    public static final int CL_DEVICE_PARTITION_BY_COUNTS_EXT = 16465;
    public static final int CL_DEVICE_PARTITION_BY_NAMES_EXT = 16466;
    public static final int CL_DEVICE_PARTITION_EQUALLY_EXT = 16464;
    public static final int CL_DEVICE_PARTITION_FAILED_EXT = -1057;
    public static final int CL_DEVICE_PARTITION_STYLE_EXT = 16472;
    public static final int CL_DEVICE_REFERENCE_COUNT_EXT = 16471;
    public static final int CL_INVALID_PARTITION_COUNT_EXT = -1058;
    public static final int CL_INVALID_PARTITION_NAME_EXT = -1059;
    public static final int CL_PARTITION_BY_COUNTS_LIST_END_EXT = 0;
    public static final int CL_PARTITION_BY_NAMES_LIST_END_EXT = -1;
    public static final int CL_PROPERTIES_LIST_END_EXT = 0;

    private EXTDeviceFission() {
    }

    public static int clCreateSubDevicesEXT(CLDevice cLDevice, LongBuffer longBuffer, PointerBuffer pointerBuffer, IntBuffer intBuffer) {
        CLDevice cLDevice2 = cLDevice;
        LongBuffer longBuffer2 = longBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateSubDevicesEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        BufferChecks.checkNullTerminated(longBuffer2);
        if (pointerBuffer2 != null) {
            BufferChecks.checkDirect(pointerBuffer2);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        int nclCreateSubDevicesEXT = nclCreateSubDevicesEXT(cLDevice2.getPointer(), MemoryUtil.getAddress(longBuffer2), pointerBuffer2 == null ? 0 : pointerBuffer2.remaining(), MemoryUtil.getAddressSafe(pointerBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j);
        if (nclCreateSubDevicesEXT == 0 && pointerBuffer2 != null) {
            cLDevice2.registerSubCLDevices(pointerBuffer2);
        }
        return nclCreateSubDevicesEXT;
    }

    public static int clReleaseDeviceEXT(CLDevice cLDevice) {
        CLDevice cLDevice2 = cLDevice;
        long j = CLCapabilities.clReleaseDeviceEXT;
        BufferChecks.checkFunctionAddress(j);
        APIUtil.releaseObjects(cLDevice2);
        int nclReleaseDeviceEXT = nclReleaseDeviceEXT(cLDevice2.getPointer(), j);
        if (nclReleaseDeviceEXT == 0) {
            int release = cLDevice2.release();
        }
        return nclReleaseDeviceEXT;
    }

    public static int clRetainDeviceEXT(CLDevice cLDevice) {
        CLDevice cLDevice2 = cLDevice;
        long j = CLCapabilities.clRetainDeviceEXT;
        BufferChecks.checkFunctionAddress(j);
        int nclRetainDeviceEXT = nclRetainDeviceEXT(cLDevice2.getPointer(), j);
        if (nclRetainDeviceEXT == 0) {
            int retain = cLDevice2.retain();
        }
        return nclRetainDeviceEXT;
    }

    static native int nclCreateSubDevicesEXT(long j, long j2, int i, long j3, long j4, long j5);

    static native int nclReleaseDeviceEXT(long j, long j2);

    static native int nclRetainDeviceEXT(long j, long j2);
}

package org.lwjgl.test.opencl;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.List;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.C0774CL;
import org.lwjgl.opencl.CL10;
import org.lwjgl.opencl.CL11;
import org.lwjgl.opencl.CLCapabilities;
import org.lwjgl.opencl.CLCommandQueue;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLContextCallback;
import org.lwjgl.opencl.CLDevice;
import org.lwjgl.opencl.CLDeviceCapabilities;
import org.lwjgl.opencl.CLEvent;
import org.lwjgl.opencl.CLEventCallback;
import org.lwjgl.opencl.CLMem;
import org.lwjgl.opencl.CLMemObjectDestructorCallback;
import org.lwjgl.opencl.CLNativeKernel;
import org.lwjgl.opencl.CLPlatform;
import org.lwjgl.opencl.api.CLBufferRegion;

public class HelloOpenCL {
    public HelloOpenCL() {
    }

    private static void die(String str, String str2) {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append(str3).append(" error ").append(str4).append(" occured").toString());
    }

    protected static void execute() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        StringBuilder sb9;
        StringBuilder sb10;
        StringBuilder sb11;
        C08151 r32;
        C08195 r322;
        C08206 r323;
        StringBuilder sb12;
        StringBuilder sb13;
        CLBufferRegion cLBufferRegion;
        C08184 r324;
        C08162 r325;
        C08173 r326;
        RuntimeException runtimeException;
        try {
            C0774CL.create();
            List<CLPlatform> platforms = CLPlatform.getPlatforms();
            if (platforms == null) {
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("No OpenCL platforms found.");
                throw runtimeException2;
            }
            for (CLPlatform cLPlatform : platforms) {
                System.out.println("\n-------------------------");
                PrintStream printStream = System.out;
                StringBuilder sb14 = sb;
                StringBuilder sb15 = new StringBuilder();
                printStream.println(sb14.append("NEW PLATFORM: ").append(cLPlatform.getPointer()).toString());
                System.out.println(CLCapabilities.getPlatformCapabilities(cLPlatform));
                System.out.println("-------------------------");
                printPlatformInfo(cLPlatform, "CL_PLATFORM_PROFILE", 2304);
                printPlatformInfo(cLPlatform, "CL_PLATFORM_VERSION", 2305);
                printPlatformInfo(cLPlatform, "CL_PLATFORM_NAME", CL10.CL_PLATFORM_NAME);
                printPlatformInfo(cLPlatform, "CL_PLATFORM_VENDOR", CL10.CL_PLATFORM_VENDOR);
                printPlatformInfo(cLPlatform, "CL_PLATFORM_EXTENSIONS", CL10.CL_PLATFORM_EXTENSIONS);
                System.out.println(LibrariesRepository.MOJANG_MAVEN_REPO);
                PointerBuffer createPointerBuffer = BufferUtils.createPointerBuffer(3);
                PointerBuffer flip = createPointerBuffer.put(4228).put(cLPlatform.getPointer()).put(0).flip();
                for (CLDevice cLDevice : cLPlatform.getDevices(-1)) {
                    CLDeviceCapabilities deviceCapabilities = CLCapabilities.getDeviceCapabilities(cLDevice);
                    PrintStream printStream2 = System.out;
                    StringBuilder sb16 = sb2;
                    StringBuilder sb17 = new StringBuilder();
                    printStream2.println(sb16.append("\n\tNEW DEVICE: ").append(cLDevice.getPointer()).toString());
                    System.out.println(deviceCapabilities);
                    System.out.println("\t-------------------------");
                    PrintStream printStream3 = System.out;
                    StringBuilder sb18 = sb3;
                    StringBuilder sb19 = new StringBuilder();
                    printStream3.println(sb18.append("\tCL_DEVICE_TYPE = ").append(cLDevice.getInfoLong(4096)).toString());
                    PrintStream printStream4 = System.out;
                    StringBuilder sb20 = sb4;
                    StringBuilder sb21 = new StringBuilder();
                    printStream4.println(sb20.append("\tCL_DEVICE_VENDOR_ID = ").append(cLDevice.getInfoInt(4097)).toString());
                    PrintStream printStream5 = System.out;
                    StringBuilder sb22 = sb5;
                    StringBuilder sb23 = new StringBuilder();
                    printStream5.println(sb22.append("\tCL_DEVICE_MAX_COMPUTE_UNITS = ").append(cLDevice.getInfoInt(4098)).toString());
                    PrintStream printStream6 = System.out;
                    StringBuilder sb24 = sb6;
                    StringBuilder sb25 = new StringBuilder();
                    printStream6.println(sb24.append("\tCL_DEVICE_MAX_WORK_ITEM_DIMENSIONS = ").append(cLDevice.getInfoInt(4099)).toString());
                    PrintStream printStream7 = System.out;
                    StringBuilder sb26 = sb7;
                    StringBuilder sb27 = new StringBuilder();
                    printStream7.println(sb26.append("\tCL_DEVICE_MAX_WORK_GROUP_SIZE = ").append(cLDevice.getInfoSize(4100)).toString());
                    PrintStream printStream8 = System.out;
                    StringBuilder sb28 = sb8;
                    StringBuilder sb29 = new StringBuilder();
                    printStream8.println(sb28.append("\tCL_DEVICE_MAX_CLOCK_FREQUENCY = ").append(cLDevice.getInfoInt(CL10.CL_DEVICE_MAX_CLOCK_FREQUENCY)).toString());
                    PrintStream printStream9 = System.out;
                    StringBuilder sb30 = sb9;
                    StringBuilder sb31 = new StringBuilder();
                    printStream9.println(sb30.append("\tCL_DEVICE_ADDRESS_BITS = ").append(cLDevice.getInfoInt(4109)).toString());
                    PrintStream printStream10 = System.out;
                    StringBuilder sb32 = sb10;
                    StringBuilder sb33 = new StringBuilder();
                    printStream10.println(sb32.append("\tCL_DEVICE_AVAILABLE = ").append(cLDevice.getInfoBoolean(4135)).toString());
                    PrintStream printStream11 = System.out;
                    StringBuilder sb34 = sb11;
                    StringBuilder sb35 = new StringBuilder();
                    printStream11.println(sb34.append("\tCL_DEVICE_COMPILER_AVAILABLE = ").append(cLDevice.getInfoBoolean(4136)).toString());
                    printDeviceInfo(cLDevice, "CL_DEVICE_NAME", CL10.CL_DEVICE_NAME);
                    printDeviceInfo(cLDevice, "CL_DEVICE_VENDOR", CL10.CL_DEVICE_VENDOR);
                    printDeviceInfo(cLDevice, "CL_DRIVER_VERSION", CL10.CL_DRIVER_VERSION);
                    printDeviceInfo(cLDevice, "CL_DEVICE_PROFILE", CL10.CL_DEVICE_PROFILE);
                    printDeviceInfo(cLDevice, "CL_DEVICE_VERSION", CL10.CL_DEVICE_VERSION);
                    printDeviceInfo(cLDevice, "CL_DEVICE_EXTENSIONS", 4144);
                    if (deviceCapabilities.OpenCL11) {
                        printDeviceInfo(cLDevice, "CL_DEVICE_OPENCL_C_VERSION", CL11.CL_DEVICE_OPENCL_C_VERSION);
                    }
                    PointerBuffer pointerBuffer = createPointerBuffer;
                    CLDevice cLDevice2 = cLDevice;
                    C08151 r26 = r32;
                    C08151 r27 = new CLContextCallback() {
                        /* access modifiers changed from: protected */
                        public void handleMessage(String str, ByteBuffer byteBuffer) {
                            StringBuilder sb;
                            String str2 = str;
                            ByteBuffer byteBuffer2 = byteBuffer;
                            PrintStream printStream = System.out;
                            StringBuilder sb2 = sb;
                            StringBuilder sb3 = new StringBuilder();
                            printStream.println(sb2.append("IN CLContextCallback :: ").append(str2).toString());
                        }
                    };
                    CLContext clCreateContext = CL10.clCreateContext(pointerBuffer, cLDevice2, (CLContextCallback) r26, (IntBuffer) null);
                    CLMem clCreateBuffer = CL10.clCreateBuffer(clCreateContext, 4, 128, (IntBuffer) null);
                    if (deviceCapabilities.OpenCL11) {
                        CLMem cLMem = clCreateBuffer;
                        C08162 r25 = r325;
                        C08162 r262 = new CLMemObjectDestructorCallback() {
                            /* access modifiers changed from: protected */
                            public void handleMessage(long j) {
                                StringBuilder sb;
                                long j2 = j;
                                PrintStream printStream = System.out;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                printStream.println(sb2.append("FIRST Buffer destructed: ").append(j2).toString());
                            }
                        };
                        int clSetMemObjectDestructorCallback = CL11.clSetMemObjectDestructorCallback(cLMem, r25);
                        CLMem cLMem2 = clCreateBuffer;
                        C08173 r252 = r326;
                        C08173 r263 = new CLMemObjectDestructorCallback() {
                            /* access modifiers changed from: protected */
                            public void handleMessage(long j) {
                                StringBuilder sb;
                                long j2 = j;
                                PrintStream printStream = System.out;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                printStream.println(sb2.append("SECOND Buffer destructed: ").append(j2).toString());
                            }
                        };
                        int clSetMemObjectDestructorCallback2 = CL11.clSetMemObjectDestructorCallback(cLMem2, r252);
                    }
                    if (deviceCapabilities.OpenCL11) {
                        CLMem cLMem3 = clCreateBuffer;
                        CLBufferRegion cLBufferRegion2 = cLBufferRegion;
                        CLBufferRegion cLBufferRegion3 = new CLBufferRegion(0, 64);
                        CLMem createSubBuffer = cLMem3.createSubBuffer(4, CL11.CL_BUFFER_CREATE_TYPE_REGION, cLBufferRegion2, null);
                        C08184 r253 = r324;
                        C08184 r264 = new CLMemObjectDestructorCallback() {
                            /* access modifiers changed from: protected */
                            public void handleMessage(long j) {
                                StringBuilder sb;
                                long j2 = j;
                                PrintStream printStream = System.out;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                printStream.println(sb2.append("Sub Buffer destructed: ").append(j2).toString());
                            }
                        };
                        int clSetMemObjectDestructorCallback3 = CL11.clSetMemObjectDestructorCallback(createSubBuffer, r253);
                    }
                    int clRetainMemObject = CL10.clRetainMemObject(clCreateBuffer);
                    if (LWJGLUtil.getPlatform() != 2 && (2 & cLDevice.getInfoLong(4137)) == 2) {
                        System.out.println("-TRYING TO EXEC NATIVE KERNEL-");
                        CLCommandQueue clCreateCommandQueue = CL10.clCreateCommandQueue(clCreateContext, cLDevice, 0, null);
                        PointerBuffer createPointerBuffer2 = BufferUtils.createPointerBuffer(1);
                        CLCommandQueue cLCommandQueue = clCreateCommandQueue;
                        C08195 r254 = r322;
                        C08195 r265 = new CLNativeKernel() {
                            /* access modifiers changed from: protected */
                            public void execute(ByteBuffer[] byteBufferArr) {
                                StringBuilder sb;
                                StringBuilder sb2;
                                ByteBuffer[] byteBufferArr2 = byteBufferArr;
                                PrintStream printStream = System.out;
                                StringBuilder sb3 = sb;
                                StringBuilder sb4 = new StringBuilder();
                                printStream.println(sb3.append("\tmemobjs.length = ").append(byteBufferArr2.length).toString());
                                for (int i = 0; i < byteBufferArr2.length; i++) {
                                    PrintStream printStream2 = System.out;
                                    StringBuilder sb5 = sb2;
                                    StringBuilder sb6 = new StringBuilder();
                                    printStream2.println(sb5.append("\tmemobjs[").append(i).append("].remaining() = ").append(byteBufferArr2[i].remaining()).toString());
                                    for (int position = byteBufferArr2[i].position(); position < byteBufferArr2[i].limit(); position++) {
                                        ByteBuffer put = byteBufferArr2[i].put(position, (byte) position);
                                    }
                                }
                                System.out.println("\tNative kernel done.");
                            }
                        };
                        CLMem[] cLMemArr = new CLMem[1];
                        CLMem[] cLMemArr2 = cLMemArr;
                        cLMemArr[0] = clCreateBuffer;
                        long[] jArr = new long[1];
                        long[] jArr2 = jArr;
                        jArr[0] = 128;
                        int clEnqueueNativeKernel = CL10.clEnqueueNativeKernel(cLCommandQueue, r254, cLMemArr2, jArr2, null, createPointerBuffer2);
                        CLEvent cLEvent = clCreateCommandQueue.getCLEvent(createPointerBuffer2.get(0));
                        CLEvent cLEvent2 = cLEvent;
                        C08206 r266 = r323;
                        C08206 r272 = new CLEventCallback() {
                            /* access modifiers changed from: protected */
                            public void handleMessage(CLEvent cLEvent, int i) {
                                StringBuilder sb;
                                CLEvent cLEvent2 = cLEvent;
                                int i2 = i;
                                PrintStream printStream = System.out;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                printStream.println(sb2.append("\t\tEvent callback status: ").append(HelloOpenCL.getEventStatusName(i2)).toString());
                            }
                        };
                        int clSetEventCallback = CL11.clSetEventCallback(cLEvent2, 0, r266);
                        int infoInt = cLEvent.getInfoInt(CL10.CL_EVENT_COMMAND_EXECUTION_STATUS);
                        PrintStream printStream12 = System.out;
                        StringBuilder sb36 = sb12;
                        StringBuilder sb37 = new StringBuilder();
                        printStream12.println(sb36.append("NATIVE KERNEL STATUS: ").append(getEventStatusName(infoInt)).toString());
                        int clFlush = CL10.clFlush(clCreateCommandQueue);
                        do {
                            int infoInt2 = cLEvent.getInfoInt(CL10.CL_EVENT_COMMAND_EXECUTION_STATUS);
                            if (infoInt2 != infoInt) {
                                infoInt = infoInt2;
                                PrintStream printStream13 = System.out;
                                StringBuilder sb38 = sb13;
                                StringBuilder sb39 = new StringBuilder();
                                printStream13.println(sb38.append("NATIVE KERNEL STATUS: ").append(getEventStatusName(infoInt)).toString());
                            }
                        } while (infoInt != 0);
                        int clReleaseEvent = CL10.clReleaseEvent(cLEvent);
                    }
                    int clReleaseMemObject = CL10.clReleaseMemObject(clCreateBuffer);
                    int clReleaseContext = CL10.clReleaseContext(clCreateContext);
                }
            }
            C0774CL.destroy();
        } catch (LWJGLException e) {
            die("Init", e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public static String getEventStatusName(int i) {
        switch (i) {
            case 1:
                return "CL_RUNNING";
            case 2:
                return "CL_SUBMITTED";
            case 3:
                return "CL_QUEUED";
            default:
                return "CL_COMPLETE";
        }
    }

    public static void main(String[] strArr) {
        HelloOpenCL helloOpenCL;
        String[] strArr2 = strArr;
        HelloOpenCL helloOpenCL2 = helloOpenCL;
        HelloOpenCL helloOpenCL3 = new HelloOpenCL();
        execute();
    }

    private static void printDeviceInfo(CLDevice cLDevice, String str, int i) {
        StringBuilder sb;
        CLDevice cLDevice2 = cLDevice;
        String str2 = str;
        int i2 = i;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("\t").append(str2).append(" = ").append(cLDevice2.getInfoString(i2)).toString());
    }

    private static void printPlatformInfo(CLPlatform cLPlatform, String str, int i) {
        StringBuilder sb;
        CLPlatform cLPlatform2 = cLPlatform;
        String str2 = str;
        int i2 = i;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("\t").append(str2).append(" = ").append(cLPlatform2.getInfoString(i2)).toString());
    }
}

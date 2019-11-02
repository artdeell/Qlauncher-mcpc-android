package org.lwjgl.opencl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.BufferChecks;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.PointerWrapper;
import org.lwjgl.opencl.api.CLBufferRegion;
import org.lwjgl.opencl.api.CLImageFormat;
import org.lwjgl.opencl.api.Filter;
import org.lwjgl.opengl.Drawable;

final class InfoUtilFactory {
    static final InfoUtil<CLCommandQueue> CL_COMMAND_QUEUE_UTIL;
    static final CLContextUtil CL_CONTEXT_UTIL;
    static final InfoUtil<CLDevice> CL_DEVICE_UTIL;
    static final CLEventUtil CL_EVENT_UTIL;
    static final CLKernelUtil CL_KERNEL_UTIL;
    static final CLMemUtil CL_MEM_UTIL;
    static final CLPlatformUtil CL_PLATFORM_UTIL;
    static final CLProgramUtil CL_PROGRAM_UTIL;
    static final InfoUtil<CLSampler> CL_SAMPLER_UTIL;

    private static final class CLContextUtil extends InfoUtilAbstract<CLContext> implements CLContextUtil {
        private CLContextUtil() {
        }

        /* synthetic */ CLContextUtil(C07751 r4) {
            C07751 r1 = r4;
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:47:0x0139  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.lwjgl.opencl.CLContext create(org.lwjgl.opencl.CLPlatform r46, java.util.List<org.lwjgl.opencl.CLDevice> r47, org.lwjgl.opencl.CLContextCallback r48, org.lwjgl.opengl.Drawable r49, java.nio.IntBuffer r50) throws org.lwjgl.LWJGLException {
            /*
                r45 = this;
                r0 = r45
                r1 = r46
                r2 = r47
                r3 = r48
                r4 = r49
                r5 = r50
                r29 = r4
                if (r29 != 0) goto L_0x0078
                r29 = 0
                r6 = r29
            L_0x0014:
                r29 = 1
                r30 = r6
                r31 = 2
                int r30 = r30 + 2
                int r29 = r29 + r30
                r7 = r29
                r29 = r7
                r30 = r2
                int r30 = r30.size()
                int r29 = r29 + r30
                org.lwjgl.PointerBuffer r29 = org.lwjgl.opencl.APIUtil.getBufferPointer(r29)
                r8 = r29
                r29 = r8
                r30 = 4228(0x1084, double:2.089E-320)
                org.lwjgl.PointerBuffer r29 = r29.put(r30)
                r30 = r1
                org.lwjgl.PointerBuffer r29 = r29.put(r30)
                r29 = r4
                if (r29 == 0) goto L_0x0049
                r29 = r4
                r30 = r8
                r29.setCLSharingProperties(r30)
            L_0x0049:
                r29 = r8
                r30 = 0
                org.lwjgl.PointerBuffer r29 = r29.put(r30)
                r29 = r8
                r30 = r7
                org.lwjgl.PointerBuffer r29 = r29.position(r30)
                r29 = r2
                java.util.Iterator r29 = r29.iterator()
                r12 = r29
            L_0x0061:
                r29 = r12
                boolean r29 = r29.hasNext()
                if (r29 == 0) goto L_0x007d
                r29 = r8
                r30 = r12
                java.lang.Object r30 = r30.next()
                org.lwjgl.opencl.CLDevice r30 = (org.lwjgl.opencl.CLDevice) r30
                org.lwjgl.PointerBuffer r29 = r29.put(r30)
                goto L_0x0061
            L_0x0078:
                r29 = 4
                r6 = r29
                goto L_0x0014
            L_0x007d:
                long r29 = org.lwjgl.opencl.CLCapabilities.clCreateContext
                r13 = r29
                r29 = r13
                org.lwjgl.BufferChecks.checkFunctionAddress(r29)
                r29 = r5
                if (r29 == 0) goto L_0x010f
                r29 = r5
                r30 = 1
                org.lwjgl.BufferChecks.checkBuffer(r29, r30)
            L_0x0091:
                r29 = r3
                if (r29 == 0) goto L_0x009d
                r29 = r3
                boolean r29 = r29.isCustom()
                if (r29 == 0) goto L_0x011b
            L_0x009d:
                r29 = 0
                r15 = r29
            L_0x00a1:
                r29 = 0
                r17 = r29
                r29 = r8
                java.nio.ByteBuffer r29 = r29.getBuffer()     // Catch:{ all -> 0x0132 }
                long r29 = org.lwjgl.MemoryUtil.getAddress0(r29)     // Catch:{ all -> 0x0132 }
                r19 = r29
                r29 = r2
                int r29 = r29.size()     // Catch:{ all -> 0x0132 }
                r21 = r29
                r29 = r8
                r30 = r7
                long r29 = org.lwjgl.MemoryUtil.getAddress(r29, r30)     // Catch:{ all -> 0x0132 }
                r22 = r29
                r29 = r3
                if (r29 != 0) goto L_0x0125
                r29 = 0
                r26 = r29
            L_0x00cb:
                org.lwjgl.opencl.CLContext r29 = new org.lwjgl.opencl.CLContext     // Catch:{ all -> 0x0132 }
                r44 = r29
                r29 = r44
                r30 = r44
                r31 = r19
                r33 = r21
                r34 = r22
                r36 = r26
                r38 = r15
                r40 = r5
                long r40 = org.lwjgl.MemoryUtil.getAddressSafe(r40)     // Catch:{ all -> 0x0132 }
                r42 = r13
                long r31 = org.lwjgl.opencl.CL10.nclCreateContext(r31, r33, r34, r36, r38, r40, r42)     // Catch:{ all -> 0x0132 }
                r33 = r1
                r30.<init>(r31, r33)     // Catch:{ all -> 0x0132 }
                r28 = r29
                boolean r29 = org.lwjgl.LWJGLUtil.DEBUG     // Catch:{ all -> 0x0143 }
                if (r29 == 0) goto L_0x00ff
                r29 = r5
                r30 = 0
                int r29 = r29.get(r30)     // Catch:{ all -> 0x0143 }
                org.lwjgl.opencl.Util.checkCLError(r29)     // Catch:{ all -> 0x0143 }
            L_0x00ff:
                r29 = r28
                if (r29 == 0) goto L_0x010a
                r29 = r28
                r30 = r15
                r29.setContextCallback(r30)
            L_0x010a:
                r29 = r28
                r0 = r29
                return r0
            L_0x010f:
                boolean r29 = org.lwjgl.LWJGLUtil.DEBUG
                if (r29 == 0) goto L_0x0091
                java.nio.IntBuffer r29 = org.lwjgl.opencl.APIUtil.getBufferInt()
                r5 = r29
                goto L_0x0091
            L_0x011b:
                r29 = r3
                long r29 = org.lwjgl.opencl.CallbackUtil.createGlobalRef(r29)
                r15 = r29
                goto L_0x00a1
            L_0x0125:
                r29 = r3
                long r29 = r29.getPointer()     // Catch:{ all -> 0x0132 }
                r24 = r29
                r29 = r24
                r26 = r29
                goto L_0x00cb
            L_0x0132:
                r29 = move-exception
                r18 = r29
            L_0x0135:
                r29 = r17
                if (r29 == 0) goto L_0x0140
                r29 = r17
                r30 = r15
                r29.setContextCallback(r30)
            L_0x0140:
                r29 = r18
                throw r29
            L_0x0143:
                r29 = move-exception
                r18 = r29
                r29 = r28
                r17 = r29
                goto L_0x0135
            */
            throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opencl.InfoUtilFactory.CLContextUtil.create(org.lwjgl.opencl.CLPlatform, java.util.List, org.lwjgl.opencl.CLContextCallback, org.lwjgl.opengl.Drawable, java.nio.IntBuffer):org.lwjgl.opencl.CLContext");
        }

        public CLContext createFromType(CLPlatform cLPlatform, long j, CLContextCallback cLContextCallback, Drawable drawable, IntBuffer intBuffer) throws LWJGLException {
            CLPlatform cLPlatform2 = cLPlatform;
            long j2 = j;
            CLContextCallback cLContextCallback2 = cLContextCallback;
            Drawable drawable2 = drawable;
            IntBuffer intBuffer2 = intBuffer;
            PointerBuffer bufferPointer = APIUtil.getBufferPointer(1 + (drawable2 == null ? 0 : 4) + 2);
            PointerBuffer put = bufferPointer.put(4228).put((PointerWrapper) cLPlatform2);
            if (drawable2 != null) {
                drawable2.setCLSharingProperties(bufferPointer);
            }
            PointerBuffer put2 = bufferPointer.put(0);
            PointerBuffer flip = bufferPointer.flip();
            return CL10.clCreateContextFromType(bufferPointer, j2, cLContextCallback2, intBuffer2);
        }

        /* access modifiers changed from: protected */
        public int getInfo(CLContext cLContext, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
            return CL10.clGetContextInfo(cLContext, i, byteBuffer, pointerBuffer);
        }

        public List<CLDevice> getInfoDevices(CLContext cLContext) {
            int pointerSize;
            ArrayList arrayList;
            CLContext cLContext2 = cLContext;
            cLContext2.checkValid();
            if (CLCapabilities.getPlatformCapabilities((CLPlatform) cLContext2.getParent()).OpenCL11) {
                pointerSize = getInfoInt(cLContext2, CL11.CL_CONTEXT_NUM_DEVICES);
            } else {
                PointerBuffer bufferPointer = APIUtil.getBufferPointer();
                int clGetContextInfo = CL10.clGetContextInfo(cLContext2, CL10.CL_CONTEXT_DEVICES, null, bufferPointer);
                pointerSize = (int) (bufferPointer.get(0) / ((long) PointerBuffer.getPointerSize()));
            }
            PointerBuffer bufferPointer2 = APIUtil.getBufferPointer(pointerSize);
            int clGetContextInfo2 = CL10.clGetContextInfo(cLContext2, CL10.CL_CONTEXT_DEVICES, bufferPointer2.getBuffer(), null);
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(pointerSize);
            ArrayList arrayList4 = arrayList2;
            for (int i = 0; i < pointerSize; i++) {
                boolean add = arrayList4.add(((CLPlatform) cLContext2.getParent()).getCLDevice(bufferPointer2.get(i)));
            }
            if (arrayList4.size() == 0) {
                arrayList4 = null;
            }
            return arrayList4;
        }

        public List<CLImageFormat> getSupportedImageFormats(CLContext cLContext, long j, int i, Filter<CLImageFormat> filter) {
            ArrayList arrayList;
            ArrayList arrayList2;
            CLImageFormat cLImageFormat;
            CLContext cLContext2 = cLContext;
            long j2 = j;
            int i2 = i;
            Filter<CLImageFormat> filter2 = filter;
            IntBuffer bufferInt = APIUtil.getBufferInt();
            int clGetSupportedImageFormats = CL10.clGetSupportedImageFormats(cLContext2, j2, i2, null, bufferInt);
            int i3 = bufferInt.get(0);
            if (i3 == 0) {
                arrayList2 = null;
            } else {
                ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(i3 * 8);
                int clGetSupportedImageFormats2 = CL10.clGetSupportedImageFormats(cLContext2, j2, i2, createByteBuffer, null);
                ArrayList arrayList3 = arrayList;
                ArrayList arrayList4 = new ArrayList(i3);
                arrayList2 = arrayList3;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = i3 * 8;
                    CLImageFormat cLImageFormat2 = cLImageFormat;
                    CLImageFormat cLImageFormat3 = new CLImageFormat(createByteBuffer.getInt(i5), createByteBuffer.getInt(i5 + 4));
                    CLImageFormat cLImageFormat4 = cLImageFormat2;
                    if (filter2 == null || filter2.accept(cLImageFormat4)) {
                        boolean add = arrayList2.add(cLImageFormat4);
                    }
                }
                if (arrayList2.size() == 0) {
                    return null;
                }
            }
            return arrayList2;
        }
    }

    private static final class CLDeviceUtil extends InfoUtilAbstract<CLDevice> {
        private CLDeviceUtil() {
        }

        /* synthetic */ CLDeviceUtil(C07751 r4) {
            C07751 r1 = r4;
            this();
        }

        /* access modifiers changed from: protected */
        public int getInfo(CLDevice cLDevice, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
            return CL10.clGetDeviceInfo(cLDevice, i, byteBuffer, pointerBuffer);
        }

        /* access modifiers changed from: protected */
        public int getInfoSizeArraySize(CLDevice cLDevice, int i) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            CLDevice cLDevice2 = cLDevice;
            int i2 = i;
            switch (i2) {
                case 4101:
                    return getInfoInt(cLDevice2, 4099);
                default:
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unsupported parameter: ").append(LWJGLUtil.toHexString(i2)).toString());
                    throw illegalArgumentException2;
            }
        }
    }

    private static final class CLEventUtil extends InfoUtilAbstract<CLEvent> implements CLEventUtil {
        private CLEventUtil() {
        }

        /* synthetic */ CLEventUtil(C07751 r4) {
            C07751 r1 = r4;
            this();
        }

        /* access modifiers changed from: protected */
        public int getInfo(CLEvent cLEvent, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
            return CL10.clGetEventInfo(cLEvent, i, byteBuffer, pointerBuffer);
        }

        public long getProfilingInfoLong(CLEvent cLEvent, int i) {
            CLEvent cLEvent2 = cLEvent;
            int i2 = i;
            cLEvent2.checkValid();
            ByteBuffer bufferByte = APIUtil.getBufferByte(8);
            int clGetEventProfilingInfo = CL10.clGetEventProfilingInfo(cLEvent2, i2, bufferByte, null);
            return bufferByte.getLong(0);
        }
    }

    private static final class CLKernelUtil extends InfoUtilAbstract<CLKernel> implements CLKernelUtil {
        private CLKernelUtil() {
        }

        /* synthetic */ CLKernelUtil(C07751 r4) {
            C07751 r1 = r4;
            this();
        }

        /* access modifiers changed from: protected */
        public int getInfo(CLKernel cLKernel, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
            return CL10.clGetKernelInfo(cLKernel, i, byteBuffer, pointerBuffer);
        }

        public long getWorkGroupInfoLong(CLKernel cLKernel, CLDevice cLDevice, int i) {
            CLKernel cLKernel2 = cLKernel;
            CLDevice cLDevice2 = cLDevice;
            int i2 = i;
            cLDevice2.checkValid();
            ByteBuffer bufferByte = APIUtil.getBufferByte(8);
            int clGetKernelWorkGroupInfo = CL10.clGetKernelWorkGroupInfo(cLKernel2, cLDevice2, i2, bufferByte, null);
            return bufferByte.getLong(0);
        }

        public long getWorkGroupInfoSize(CLKernel cLKernel, CLDevice cLDevice, int i) {
            CLKernel cLKernel2 = cLKernel;
            CLDevice cLDevice2 = cLDevice;
            int i2 = i;
            cLDevice2.checkValid();
            PointerBuffer bufferPointer = APIUtil.getBufferPointer();
            int clGetKernelWorkGroupInfo = CL10.clGetKernelWorkGroupInfo(cLKernel2, cLDevice2, i2, bufferPointer.getBuffer(), null);
            return bufferPointer.get(0);
        }

        public long[] getWorkGroupInfoSizeArray(CLKernel cLKernel, CLDevice cLDevice, int i) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            CLKernel cLKernel2 = cLKernel;
            CLDevice cLDevice2 = cLDevice;
            int i2 = i;
            cLDevice2.checkValid();
            switch (i2) {
                case CL10.CL_KERNEL_COMPILE_WORK_GROUP_SIZE /*4529*/:
                    PointerBuffer bufferPointer = APIUtil.getBufferPointer(3);
                    int clGetKernelWorkGroupInfo = CL10.clGetKernelWorkGroupInfo(cLKernel2, cLDevice2, i2, bufferPointer.getBuffer(), null);
                    long[] jArr = new long[3];
                    for (int i3 = 0; i3 < 3; i3++) {
                        jArr[i3] = bufferPointer.get(i3);
                    }
                    return jArr;
                default:
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unsupported parameter: ").append(LWJGLUtil.toHexString(i2)).toString());
                    throw illegalArgumentException2;
            }
        }

        public void setArg(CLKernel cLKernel, int i, byte b) {
            int clSetKernelArg = CL10.clSetKernelArg(cLKernel, i, 1, APIUtil.getBufferByte(1).put(0, b));
        }

        public void setArg(CLKernel cLKernel, int i, double d) {
            int clSetKernelArg = CL10.clSetKernelArg(cLKernel, i, 8, APIUtil.getBufferDouble().put(0, d));
        }

        public void setArg(CLKernel cLKernel, int i, float f) {
            int clSetKernelArg = CL10.clSetKernelArg(cLKernel, i, 4, APIUtil.getBufferFloat().put(0, f));
        }

        public void setArg(CLKernel cLKernel, int i, int i2) {
            int clSetKernelArg = CL10.clSetKernelArg(cLKernel, i, 4, APIUtil.getBufferInt().put(0, i2));
        }

        public void setArg(CLKernel cLKernel, int i, long j) {
            int clSetKernelArg = CL10.clSetKernelArg(cLKernel, i, 8, APIUtil.getBufferLong().put(0, j));
        }

        public void setArg(CLKernel cLKernel, int i, CLObject cLObject) {
            int clSetKernelArg = CL10.clSetKernelArg(cLKernel, i, cLObject);
        }

        public void setArg(CLKernel cLKernel, int i, short s) {
            int clSetKernelArg = CL10.clSetKernelArg(cLKernel, i, 2, APIUtil.getBufferShort().put(0, s));
        }

        public void setArgSize(CLKernel cLKernel, int i, long j) {
            int clSetKernelArg = CL10.clSetKernelArg(cLKernel, i, j);
        }
    }

    private static final class CLMemUtil extends InfoUtilAbstract<CLMem> implements CLMemUtil {
        private CLMemUtil() {
        }

        /* synthetic */ CLMemUtil(C07751 r4) {
            C07751 r1 = r4;
            this();
        }

        public CLMem createImage2D(CLContext cLContext, long j, CLImageFormat cLImageFormat, long j2, long j3, long j4, Buffer buffer, IntBuffer intBuffer) {
            CLMem cLMem;
            CLContext cLContext2 = cLContext;
            long j5 = j;
            CLImageFormat cLImageFormat2 = cLImageFormat;
            long j6 = j2;
            long j7 = j3;
            long j8 = j4;
            Buffer buffer2 = buffer;
            IntBuffer intBuffer2 = intBuffer;
            ByteBuffer bufferByte = APIUtil.getBufferByte(8);
            ByteBuffer putInt = bufferByte.putInt(0, cLImageFormat2.getChannelOrder());
            ByteBuffer putInt2 = bufferByte.putInt(4, cLImageFormat2.getChannelType());
            long j9 = CLCapabilities.clCreateImage2D;
            BufferChecks.checkFunctionAddress(j9);
            if (intBuffer2 != null) {
                BufferChecks.checkBuffer(intBuffer2, 1);
            } else if (LWJGLUtil.DEBUG) {
                intBuffer2 = APIUtil.getBufferInt();
            }
            CLMem cLMem2 = cLMem;
            CLMem cLMem3 = new CLMem(CL10.nclCreateImage2D(cLContext2.getPointer(), j5, MemoryUtil.getAddress(bufferByte, 0), j6, j7, j8, MemoryUtil.getAddress0Safe(buffer2) + ((long) (buffer2 != null ? BufferChecks.checkBuffer(buffer2, CLChecks.calculateImage2DSize(bufferByte, j6, j7, j8)) : 0)), MemoryUtil.getAddressSafe(intBuffer2), j9), cLContext2);
            CLMem cLMem4 = cLMem2;
            if (LWJGLUtil.DEBUG) {
                Util.checkCLError(intBuffer2.get(0));
            }
            return cLMem4;
        }

        public CLMem createImage3D(CLContext cLContext, long j, CLImageFormat cLImageFormat, long j2, long j3, long j4, long j5, long j6, Buffer buffer, IntBuffer intBuffer) {
            CLMem cLMem;
            CLContext cLContext2 = cLContext;
            long j7 = j;
            CLImageFormat cLImageFormat2 = cLImageFormat;
            long j8 = j2;
            long j9 = j3;
            long j10 = j4;
            long j11 = j5;
            long j12 = j6;
            Buffer buffer2 = buffer;
            IntBuffer intBuffer2 = intBuffer;
            ByteBuffer bufferByte = APIUtil.getBufferByte(8);
            ByteBuffer putInt = bufferByte.putInt(0, cLImageFormat2.getChannelOrder());
            ByteBuffer putInt2 = bufferByte.putInt(4, cLImageFormat2.getChannelType());
            long j13 = CLCapabilities.clCreateImage3D;
            BufferChecks.checkFunctionAddress(j13);
            if (intBuffer2 != null) {
                BufferChecks.checkBuffer(intBuffer2, 1);
            } else if (LWJGLUtil.DEBUG) {
                intBuffer2 = APIUtil.getBufferInt();
            }
            CLMem cLMem2 = cLMem;
            CLMem cLMem3 = new CLMem(CL10.nclCreateImage3D(cLContext2.getPointer(), j7, MemoryUtil.getAddress(bufferByte, 0), j8, j9, j10, j11, j12, MemoryUtil.getAddress0Safe(buffer2) + ((long) (buffer2 != null ? BufferChecks.checkBuffer(buffer2, CLChecks.calculateImage3DSize(bufferByte, j8, j9, j10, j11, j12)) : 0)), MemoryUtil.getAddressSafe(intBuffer2), j13), cLContext2);
            CLMem cLMem4 = cLMem2;
            if (LWJGLUtil.DEBUG) {
                Util.checkCLError(intBuffer2.get(0));
            }
            return cLMem4;
        }

        public CLMem createSubBuffer(CLMem cLMem, long j, int i, CLBufferRegion cLBufferRegion, IntBuffer intBuffer) {
            CLMem cLMem2 = cLMem;
            long j2 = j;
            int i2 = i;
            CLBufferRegion cLBufferRegion2 = cLBufferRegion;
            IntBuffer intBuffer2 = intBuffer;
            PointerBuffer bufferPointer = APIUtil.getBufferPointer(2);
            PointerBuffer put = bufferPointer.put((long) cLBufferRegion2.getOrigin());
            PointerBuffer put2 = bufferPointer.put((long) cLBufferRegion2.getSize());
            return CL11.clCreateSubBuffer(cLMem2, j2, i2, bufferPointer.getBuffer(), intBuffer2);
        }

        public int getGLObjectName(CLMem cLMem) {
            CLMem cLMem2 = cLMem;
            cLMem2.checkValid();
            IntBuffer bufferInt = APIUtil.getBufferInt();
            int clGetGLObjectInfo = CL10GL.clGetGLObjectInfo(cLMem2, null, bufferInt);
            return bufferInt.get(0);
        }

        public int getGLObjectType(CLMem cLMem) {
            CLMem cLMem2 = cLMem;
            cLMem2.checkValid();
            IntBuffer bufferInt = APIUtil.getBufferInt();
            int clGetGLObjectInfo = CL10GL.clGetGLObjectInfo(cLMem2, bufferInt, null);
            return bufferInt.get(0);
        }

        public int getGLTextureInfoInt(CLMem cLMem, int i) {
            CLMem cLMem2 = cLMem;
            int i2 = i;
            cLMem2.checkValid();
            ByteBuffer bufferByte = APIUtil.getBufferByte(4);
            int clGetGLTextureInfo = CL10GL.clGetGLTextureInfo(cLMem2, i2, bufferByte, null);
            return bufferByte.getInt(0);
        }

        public int getImageInfoFormat(CLMem cLMem, int i) {
            CLMem cLMem2 = cLMem;
            int i2 = i;
            cLMem2.checkValid();
            ByteBuffer bufferByte = APIUtil.getBufferByte(8);
            int clGetImageInfo = CL10.clGetImageInfo(cLMem2, CL10.CL_IMAGE_FORMAT, bufferByte, null);
            return bufferByte.getInt(i2 << 2);
        }

        public CLImageFormat getImageInfoFormat(CLMem cLMem) {
            CLImageFormat cLImageFormat;
            CLMem cLMem2 = cLMem;
            cLMem2.checkValid();
            ByteBuffer bufferByte = APIUtil.getBufferByte(8);
            int clGetImageInfo = CL10.clGetImageInfo(cLMem2, CL10.CL_IMAGE_FORMAT, bufferByte, null);
            CLImageFormat cLImageFormat2 = cLImageFormat;
            CLImageFormat cLImageFormat3 = new CLImageFormat(bufferByte.getInt(0), bufferByte.getInt(4));
            return cLImageFormat2;
        }

        public long getImageInfoSize(CLMem cLMem, int i) {
            CLMem cLMem2 = cLMem;
            int i2 = i;
            cLMem2.checkValid();
            PointerBuffer bufferPointer = APIUtil.getBufferPointer();
            int clGetImageInfo = CL10.clGetImageInfo(cLMem2, i2, bufferPointer.getBuffer(), null);
            return bufferPointer.get(0);
        }

        /* access modifiers changed from: protected */
        public int getInfo(CLMem cLMem, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
            return CL10.clGetMemObjectInfo(cLMem, i, byteBuffer, pointerBuffer);
        }

        public ByteBuffer getInfoHostBuffer(CLMem cLMem) {
            IllegalArgumentException illegalArgumentException;
            CLMem cLMem2 = cLMem;
            cLMem2.checkValid();
            if (!LWJGLUtil.DEBUG || (8 & getInfoLong(cLMem2, 4353)) == 8) {
                long infoSize = getInfoSize(cLMem2, 4354);
                if (infoSize == 0) {
                    return null;
                }
                return C0774CL.getHostBuffer(getInfoSize(cLMem2, 4355), (int) infoSize);
            }
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The specified CLMem object does not use host memory.");
            throw illegalArgumentException2;
        }
    }

    private static final class CLPlatformUtil extends InfoUtilAbstract<CLPlatform> implements CLPlatformUtil {
        private CLPlatformUtil() {
        }

        /* synthetic */ CLPlatformUtil(C07751 r4) {
            C07751 r1 = r4;
            this();
        }

        public List<CLDevice> getDevices(CLPlatform cLPlatform, int i, Filter<CLDevice> filter) {
            ArrayList arrayList;
            CLPlatform cLPlatform2 = cLPlatform;
            int i2 = i;
            Filter<CLDevice> filter2 = filter;
            cLPlatform2.checkValid();
            IntBuffer bufferInt = APIUtil.getBufferInt();
            int clGetDeviceIDs = CL10.clGetDeviceIDs(cLPlatform2, (long) i2, null, bufferInt);
            int i3 = bufferInt.get(0);
            if (i3 == 0) {
                return null;
            }
            PointerBuffer bufferPointer = APIUtil.getBufferPointer(i3);
            int clGetDeviceIDs2 = CL10.clGetDeviceIDs(cLPlatform2, (long) i2, bufferPointer, null);
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(i3);
            ArrayList arrayList4 = arrayList2;
            for (int i4 = 0; i4 < i3; i4++) {
                CLDevice cLDevice = cLPlatform2.getCLDevice(bufferPointer.get(i4));
                if (filter2 == null || filter2.accept(cLDevice)) {
                    boolean add = arrayList4.add(cLDevice);
                }
            }
            if (arrayList4.size() == 0) {
                arrayList4 = null;
            }
            return arrayList4;
        }

        /* access modifiers changed from: protected */
        public int getInfo(CLPlatform cLPlatform, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
            return CL10.clGetPlatformInfo(cLPlatform, i, byteBuffer, pointerBuffer);
        }

        public List<CLPlatform> getPlatforms(Filter<CLPlatform> filter) {
            ArrayList arrayList;
            Filter<CLPlatform> filter2 = filter;
            IntBuffer bufferInt = APIUtil.getBufferInt();
            int clGetPlatformIDs = CL10.clGetPlatformIDs(null, bufferInt);
            int i = bufferInt.get(0);
            if (i == 0) {
                return null;
            }
            PointerBuffer bufferPointer = APIUtil.getBufferPointer(i);
            int clGetPlatformIDs2 = CL10.clGetPlatformIDs(bufferPointer, null);
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(i);
            ArrayList arrayList4 = arrayList2;
            for (int i2 = 0; i2 < i; i2++) {
                CLPlatform cLPlatform = CLPlatform.getCLPlatform(bufferPointer.get(i2));
                if (filter2 == null || filter2.accept(cLPlatform)) {
                    boolean add = arrayList4.add(cLPlatform);
                }
            }
            if (arrayList4.size() == 0) {
                arrayList4 = null;
            }
            return arrayList4;
        }
    }

    private static final class CLProgramUtil extends InfoUtilAbstract<CLProgram> implements CLProgramUtil {
        private CLProgramUtil() {
        }

        /* synthetic */ CLProgramUtil(C07751 r4) {
            C07751 r1 = r4;
            this();
        }

        private static int getBuildSizeRet(CLProgram cLProgram, CLDevice cLDevice, int i) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            CLProgram cLProgram2 = cLProgram;
            CLDevice cLDevice2 = cLDevice;
            int i2 = i;
            PointerBuffer bufferPointer = APIUtil.getBufferPointer();
            if (CL10.clGetProgramBuildInfo(cLProgram2, cLDevice2, i2, null, bufferPointer) == 0) {
                return (int) bufferPointer.get(0);
            }
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid parameter specified: ").append(LWJGLUtil.toHexString(i2)).toString());
            throw illegalArgumentException2;
        }

        public CLKernel[] createKernelsInProgram(CLProgram cLProgram) {
            CLProgram cLProgram2 = cLProgram;
            IntBuffer bufferInt = APIUtil.getBufferInt();
            int clCreateKernelsInProgram = CL10.clCreateKernelsInProgram(cLProgram2, null, bufferInt);
            int i = bufferInt.get(0);
            CLKernel[] cLKernelArr = null;
            if (i != 0) {
                PointerBuffer bufferPointer = APIUtil.getBufferPointer(i);
                int clCreateKernelsInProgram2 = CL10.clCreateKernelsInProgram(cLProgram2, bufferPointer, null);
                cLKernelArr = new CLKernel[i];
                for (int i2 = 0; i2 < i; i2++) {
                    cLKernelArr[i2] = cLProgram2.getCLKernel(bufferPointer.get(i2));
                }
            }
            return cLKernelArr;
        }

        public int getBuildInfoInt(CLProgram cLProgram, CLDevice cLDevice, int i) {
            CLProgram cLProgram2 = cLProgram;
            CLDevice cLDevice2 = cLDevice;
            int i2 = i;
            cLProgram2.checkValid();
            ByteBuffer bufferByte = APIUtil.getBufferByte(4);
            int clGetProgramBuildInfo = CL10.clGetProgramBuildInfo(cLProgram2, cLDevice2, i2, bufferByte, null);
            return bufferByte.getInt(0);
        }

        public String getBuildInfoString(CLProgram cLProgram, CLDevice cLDevice, int i) {
            CLProgram cLProgram2 = cLProgram;
            CLDevice cLDevice2 = cLDevice;
            int i2 = i;
            cLProgram2.checkValid();
            int buildSizeRet = getBuildSizeRet(cLProgram2, cLDevice2, i2);
            if (buildSizeRet <= 1) {
                return null;
            }
            ByteBuffer bufferByte = APIUtil.getBufferByte(buildSizeRet);
            int clGetProgramBuildInfo = CL10.clGetProgramBuildInfo(cLProgram2, cLDevice2, i2, bufferByte, null);
            Buffer limit = bufferByte.limit(buildSizeRet - 1);
            return APIUtil.getString(bufferByte);
        }

        /* access modifiers changed from: protected */
        public int getInfo(CLProgram cLProgram, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
            return CL10.clGetProgramInfo(cLProgram, i, byteBuffer, pointerBuffer);
        }

        public ByteBuffer getInfoBinaries(CLProgram cLProgram, ByteBuffer byteBuffer) {
            CLProgram cLProgram2 = cLProgram;
            ByteBuffer byteBuffer2 = byteBuffer;
            cLProgram2.checkValid();
            PointerBuffer sizesBuffer = getSizesBuffer(cLProgram2, CL10.CL_PROGRAM_BINARY_SIZES);
            int i = 0;
            for (int i2 = 0; i2 < sizesBuffer.limit(); i2++) {
                i = (int) (((long) i) + sizesBuffer.get(i2));
            }
            if (byteBuffer2 == null) {
                byteBuffer2 = BufferUtils.createByteBuffer(i);
            } else if (LWJGLUtil.DEBUG) {
                BufferChecks.checkBuffer(byteBuffer2, i);
            }
            int clGetProgramInfo = CL10.clGetProgramInfo(cLProgram2, sizesBuffer, byteBuffer2, (PointerBuffer) null);
            return byteBuffer2;
        }

        public ByteBuffer[] getInfoBinaries(CLProgram cLProgram, ByteBuffer[] byteBufferArr) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            CLProgram cLProgram2 = cLProgram;
            ByteBuffer[] byteBufferArr2 = byteBufferArr;
            cLProgram2.checkValid();
            if (byteBufferArr2 == null) {
                PointerBuffer sizesBuffer = getSizesBuffer(cLProgram2, CL10.CL_PROGRAM_BINARY_SIZES);
                byteBufferArr2 = new ByteBuffer[sizesBuffer.remaining()];
                for (int i = 0; i < sizesBuffer.remaining(); i++) {
                    byteBufferArr2[i] = BufferUtils.createByteBuffer((int) sizesBuffer.get(i));
                }
            } else if (LWJGLUtil.DEBUG) {
                PointerBuffer sizesBuffer2 = getSizesBuffer(cLProgram2, CL10.CL_PROGRAM_BINARY_SIZES);
                if (byteBufferArr2.length < sizesBuffer2.remaining()) {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("The target array is not big enough: ").append(sizesBuffer2.remaining()).append(" buffers are required.").toString());
                    throw illegalArgumentException2;
                }
                for (int i2 = 0; i2 < byteBufferArr2.length; i2++) {
                    BufferChecks.checkBuffer(byteBufferArr2[i2], (int) sizesBuffer2.get(i2));
                }
            }
            int clGetProgramInfo = CL10.clGetProgramInfo(cLProgram2, byteBufferArr2, null);
            return byteBufferArr2;
        }

        public CLDevice[] getInfoDevices(CLProgram cLProgram) {
            CLProgram cLProgram2 = cLProgram;
            cLProgram2.checkValid();
            int infoInt = getInfoInt(cLProgram2, CL10.CL_PROGRAM_NUM_DEVICES);
            PointerBuffer bufferPointer = APIUtil.getBufferPointer(infoInt);
            int clGetProgramInfo = CL10.clGetProgramInfo(cLProgram2, (int) CL10.CL_PROGRAM_DEVICES, bufferPointer.getBuffer(), (PointerBuffer) null);
            CLPlatform cLPlatform = (CLPlatform) ((CLContext) cLProgram2.getParent()).getParent();
            CLDevice[] cLDeviceArr = new CLDevice[infoInt];
            for (int i = 0; i < infoInt; i++) {
                cLDeviceArr[i] = cLPlatform.getCLDevice(bufferPointer.get(i));
            }
            return cLDeviceArr;
        }

        /* access modifiers changed from: protected */
        public int getInfoSizeArraySize(CLProgram cLProgram, int i) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            CLProgram cLProgram2 = cLProgram;
            int i2 = i;
            switch (i2) {
                case CL10.CL_PROGRAM_BINARY_SIZES /*4453*/:
                    return getInfoInt(cLProgram2, CL10.CL_PROGRAM_NUM_DEVICES);
                default:
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unsupported parameter: ").append(LWJGLUtil.toHexString(i2)).toString());
                    throw illegalArgumentException2;
            }
        }
    }

    static {
        C07751 r3;
        CLContextUtil cLContextUtil;
        CLDeviceUtil cLDeviceUtil;
        CLEventUtil cLEventUtil;
        CLKernelUtil cLKernelUtil;
        CLMemUtil cLMemUtil;
        CLPlatformUtil cLPlatformUtil;
        CLProgramUtil cLProgramUtil;
        C07762 r32;
        C07751 r0 = r3;
        C07751 r1 = new InfoUtilAbstract<CLCommandQueue>() {
            /* access modifiers changed from: protected */
            public int getInfo(CLCommandQueue cLCommandQueue, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
                PointerBuffer pointerBuffer2 = pointerBuffer;
                return CL10.clGetCommandQueueInfo(cLCommandQueue, i, byteBuffer, null);
            }
        };
        CL_COMMAND_QUEUE_UTIL = r0;
        CLContextUtil cLContextUtil2 = cLContextUtil;
        CLContextUtil cLContextUtil3 = new CLContextUtil(null);
        CL_CONTEXT_UTIL = cLContextUtil2;
        CLDeviceUtil cLDeviceUtil2 = cLDeviceUtil;
        CLDeviceUtil cLDeviceUtil3 = new CLDeviceUtil(null);
        CL_DEVICE_UTIL = cLDeviceUtil2;
        CLEventUtil cLEventUtil2 = cLEventUtil;
        CLEventUtil cLEventUtil3 = new CLEventUtil(null);
        CL_EVENT_UTIL = cLEventUtil2;
        CLKernelUtil cLKernelUtil2 = cLKernelUtil;
        CLKernelUtil cLKernelUtil3 = new CLKernelUtil(null);
        CL_KERNEL_UTIL = cLKernelUtil2;
        CLMemUtil cLMemUtil2 = cLMemUtil;
        CLMemUtil cLMemUtil3 = new CLMemUtil(null);
        CL_MEM_UTIL = cLMemUtil2;
        CLPlatformUtil cLPlatformUtil2 = cLPlatformUtil;
        CLPlatformUtil cLPlatformUtil3 = new CLPlatformUtil(null);
        CL_PLATFORM_UTIL = cLPlatformUtil2;
        CLProgramUtil cLProgramUtil2 = cLProgramUtil;
        CLProgramUtil cLProgramUtil3 = new CLProgramUtil(null);
        CL_PROGRAM_UTIL = cLProgramUtil2;
        C07762 r02 = r32;
        C07762 r12 = new InfoUtilAbstract<CLSampler>() {
            /* access modifiers changed from: protected */
            public int getInfo(CLSampler cLSampler, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
                return CL10.clGetSamplerInfo(cLSampler, i, byteBuffer, pointerBuffer);
            }
        };
        CL_SAMPLER_UTIL = r02;
    }

    private InfoUtilFactory() {
    }
}

package org.lwjgl.opencl;

public final class CLCapabilities {
    static final boolean CL_APPLE_ContextLoggingFunctions = isAPPLE_ContextLoggingFunctionsSupported();
    static final boolean CL_APPLE_SetMemObjectDestructor = isAPPLE_SetMemObjectDestructorSupported();
    static final boolean CL_APPLE_gl_sharing = isAPPLE_gl_sharingSupported();
    static final boolean CL_EXT_device_fission = isEXT_device_fissionSupported();
    static final boolean CL_EXT_migrate_memobject = isEXT_migrate_memobjectSupported();
    static final boolean CL_KHR_gl_event = isKHR_gl_eventSupported();
    static final boolean CL_KHR_gl_sharing = isKHR_gl_sharingSupported();
    static final boolean CL_KHR_icd = isKHR_icdSupported();
    static final boolean CL_KHR_subgroups = isKHR_subgroupsSupported();
    static final boolean CL_KHR_terminate_context = isKHR_terminate_contextSupported();
    static final boolean OpenCL10 = isCL10Supported();
    static final boolean OpenCL10GL = isCL10GLSupported();
    static final boolean OpenCL11 = isCL11Supported();
    static final boolean OpenCL12 = isCL12Supported();
    static final boolean OpenCL12GL = isCL12GLSupported();
    static final long clBuildProgram = C0774CL.getFunctionAddress("clBuildProgram");
    static final long clCompileProgram = C0774CL.getFunctionAddress("clCompileProgram");
    static final long clCreateBuffer = C0774CL.getFunctionAddress("clCreateBuffer");
    static final long clCreateCommandQueue = C0774CL.getFunctionAddress("clCreateCommandQueue");
    static final long clCreateContext = C0774CL.getFunctionAddress("clCreateContext");
    static final long clCreateContextFromType = C0774CL.getFunctionAddress("clCreateContextFromType");
    static final long clCreateEventFromGLsyncKHR = C0774CL.getFunctionAddress("clCreateEventFromGLsyncKHR");
    static final long clCreateFromGLBuffer = C0774CL.getFunctionAddress("clCreateFromGLBuffer");
    static final long clCreateFromGLRenderbuffer = C0774CL.getFunctionAddress("clCreateFromGLRenderbuffer");
    static final long clCreateFromGLTexture = C0774CL.getFunctionAddress("clCreateFromGLTexture");
    static final long clCreateFromGLTexture2D = C0774CL.getFunctionAddress("clCreateFromGLTexture2D");
    static final long clCreateFromGLTexture3D = C0774CL.getFunctionAddress("clCreateFromGLTexture3D");
    static final long clCreateImage = C0774CL.getFunctionAddress("clCreateImage");
    static final long clCreateImage2D = C0774CL.getFunctionAddress("clCreateImage2D");
    static final long clCreateImage3D = C0774CL.getFunctionAddress("clCreateImage3D");
    static final long clCreateKernel = C0774CL.getFunctionAddress("clCreateKernel");
    static final long clCreateKernelsInProgram = C0774CL.getFunctionAddress("clCreateKernelsInProgram");
    static final long clCreateProgramWithBinary = C0774CL.getFunctionAddress("clCreateProgramWithBinary");
    static final long clCreateProgramWithBuiltInKernels = C0774CL.getFunctionAddress("clCreateProgramWithBuiltInKernels");
    static final long clCreateProgramWithSource = C0774CL.getFunctionAddress("clCreateProgramWithSource");
    static final long clCreateSampler = C0774CL.getFunctionAddress("clCreateSampler");
    static final long clCreateSubBuffer = C0774CL.getFunctionAddress("clCreateSubBuffer");
    static final long clCreateSubDevices = C0774CL.getFunctionAddress("clCreateSubDevices");
    static final long clCreateSubDevicesEXT = C0774CL.getFunctionAddress("clCreateSubDevicesEXT");
    static final long clCreateUserEvent = C0774CL.getFunctionAddress("clCreateUserEvent");
    static final long clEnqueueAcquireGLObjects = C0774CL.getFunctionAddress("clEnqueueAcquireGLObjects");
    static final long clEnqueueBarrier = C0774CL.getFunctionAddress("clEnqueueBarrier");
    static final long clEnqueueBarrierWithWaitList = C0774CL.getFunctionAddress("clEnqueueBarrierWithWaitList");
    static final long clEnqueueCopyBuffer = C0774CL.getFunctionAddress("clEnqueueCopyBuffer");
    static final long clEnqueueCopyBufferRect = C0774CL.getFunctionAddress("clEnqueueCopyBufferRect");
    static final long clEnqueueCopyBufferToImage = C0774CL.getFunctionAddress("clEnqueueCopyBufferToImage");
    static final long clEnqueueCopyImage = C0774CL.getFunctionAddress("clEnqueueCopyImage");
    static final long clEnqueueCopyImageToBuffer = C0774CL.getFunctionAddress("clEnqueueCopyImageToBuffer");
    static final long clEnqueueFillBuffer = C0774CL.getFunctionAddress("clEnqueueFillBuffer");
    static final long clEnqueueFillImage = C0774CL.getFunctionAddress("clEnqueueFillImage");
    static final long clEnqueueMapBuffer = C0774CL.getFunctionAddress("clEnqueueMapBuffer");
    static final long clEnqueueMapImage = C0774CL.getFunctionAddress("clEnqueueMapImage");
    static final long clEnqueueMarker = C0774CL.getFunctionAddress("clEnqueueMarker");
    static final long clEnqueueMarkerWithWaitList = C0774CL.getFunctionAddress("clEnqueueMarkerWithWaitList");
    static final long clEnqueueMigrateMemObjectEXT = C0774CL.getFunctionAddress("clEnqueueMigrateMemObjectEXT");
    static final long clEnqueueMigrateMemObjects = C0774CL.getFunctionAddress("clEnqueueMigrateMemObjects");
    static final long clEnqueueNDRangeKernel = C0774CL.getFunctionAddress("clEnqueueNDRangeKernel");
    static final long clEnqueueNativeKernel = C0774CL.getFunctionAddress("clEnqueueNativeKernel");
    static final long clEnqueueReadBuffer = C0774CL.getFunctionAddress("clEnqueueReadBuffer");
    static final long clEnqueueReadBufferRect = C0774CL.getFunctionAddress("clEnqueueReadBufferRect");
    static final long clEnqueueReadImage = C0774CL.getFunctionAddress("clEnqueueReadImage");
    static final long clEnqueueReleaseGLObjects = C0774CL.getFunctionAddress("clEnqueueReleaseGLObjects");
    static final long clEnqueueTask = C0774CL.getFunctionAddress("clEnqueueTask");
    static final long clEnqueueUnmapMemObject = C0774CL.getFunctionAddress("clEnqueueUnmapMemObject");
    static final long clEnqueueWaitForEvents = C0774CL.getFunctionAddress("clEnqueueWaitForEvents");
    static final long clEnqueueWriteBuffer = C0774CL.getFunctionAddress("clEnqueueWriteBuffer");
    static final long clEnqueueWriteBufferRect = C0774CL.getFunctionAddress("clEnqueueWriteBufferRect");
    static final long clEnqueueWriteImage = C0774CL.getFunctionAddress("clEnqueueWriteImage");
    static final long clFinish = C0774CL.getFunctionAddress("clFinish");
    static final long clFlush = C0774CL.getFunctionAddress("clFlush");
    static final long clGetCommandQueueInfo = C0774CL.getFunctionAddress("clGetCommandQueueInfo");
    static final long clGetContextInfo = C0774CL.getFunctionAddress("clGetContextInfo");
    static final long clGetDeviceIDs = C0774CL.getFunctionAddress("clGetDeviceIDs");
    static final long clGetDeviceInfo = C0774CL.getFunctionAddress("clGetDeviceInfo");
    static final long clGetEventInfo = C0774CL.getFunctionAddress("clGetEventInfo");
    static final long clGetEventProfilingInfo = C0774CL.getFunctionAddress("clGetEventProfilingInfo");
    static final long clGetExtensionFunctionAddress = C0774CL.getFunctionAddress("clGetExtensionFunctionAddress");
    static final long clGetExtensionFunctionAddressForPlatform = C0774CL.getFunctionAddress("clGetExtensionFunctionAddressForPlatform");
    static final long clGetGLContextInfoAPPLE = C0774CL.getFunctionAddress("clGetGLContextInfoAPPLE");
    static final long clGetGLContextInfoKHR = C0774CL.getFunctionAddress("clGetGLContextInfoKHR");
    static final long clGetGLObjectInfo = C0774CL.getFunctionAddress("clGetGLObjectInfo");
    static final long clGetGLTextureInfo = C0774CL.getFunctionAddress("clGetGLTextureInfo");
    static final long clGetImageInfo = C0774CL.getFunctionAddress("clGetImageInfo");
    static final long clGetKernelArgInfo = C0774CL.getFunctionAddress("clGetKernelArgInfo");
    static final long clGetKernelInfo = C0774CL.getFunctionAddress("clGetKernelInfo");
    static final long clGetKernelSubGroupInfoKHR = C0774CL.getFunctionAddress("clGetKernelSubGroupInfoKHR");
    static final long clGetKernelWorkGroupInfo = C0774CL.getFunctionAddress("clGetKernelWorkGroupInfo");
    static final long clGetMemObjectInfo = C0774CL.getFunctionAddress("clGetMemObjectInfo");
    static final long clGetPlatformIDs = C0774CL.getFunctionAddress("clGetPlatformIDs");
    static final long clGetPlatformInfo = C0774CL.getFunctionAddress("clGetPlatformInfo");
    static final long clGetProgramBuildInfo = C0774CL.getFunctionAddress("clGetProgramBuildInfo");
    static final long clGetProgramInfo = C0774CL.getFunctionAddress("clGetProgramInfo");
    static final long clGetSamplerInfo = C0774CL.getFunctionAddress("clGetSamplerInfo");
    static final long clGetSupportedImageFormats = C0774CL.getFunctionAddress("clGetSupportedImageFormats");
    static final long clIcdGetPlatformIDsKHR = C0774CL.getFunctionAddress("clIcdGetPlatformIDsKHR");
    static final long clLinkProgram = C0774CL.getFunctionAddress("clLinkProgram");
    static final long clLogMessagesToStderrAPPLE = C0774CL.getFunctionAddress("clLogMessagesToStderrAPPLE");
    static final long clLogMessagesToStdoutAPPLE = C0774CL.getFunctionAddress("clLogMessagesToStdoutAPPLE");
    static final long clLogMessagesToSystemLogAPPLE = C0774CL.getFunctionAddress("clLogMessagesToSystemLogAPPLE");
    static final long clReleaseCommandQueue = C0774CL.getFunctionAddress("clReleaseCommandQueue");
    static final long clReleaseContext = C0774CL.getFunctionAddress("clReleaseContext");
    static final long clReleaseDevice = C0774CL.getFunctionAddress("clReleaseDevice");
    static final long clReleaseDeviceEXT = C0774CL.getFunctionAddress("clReleaseDeviceEXT");
    static final long clReleaseEvent = C0774CL.getFunctionAddress("clReleaseEvent");
    static final long clReleaseKernel = C0774CL.getFunctionAddress("clReleaseKernel");
    static final long clReleaseMemObject = C0774CL.getFunctionAddress("clReleaseMemObject");
    static final long clReleaseProgram = C0774CL.getFunctionAddress("clReleaseProgram");
    static final long clReleaseSampler = C0774CL.getFunctionAddress("clReleaseSampler");
    static final long clRetainCommandQueue = C0774CL.getFunctionAddress("clRetainCommandQueue");
    static final long clRetainContext = C0774CL.getFunctionAddress("clRetainContext");
    static final long clRetainDevice = C0774CL.getFunctionAddress("clRetainDevice");
    static final long clRetainDeviceEXT = C0774CL.getFunctionAddress("clRetainDeviceEXT");
    static final long clRetainEvent = C0774CL.getFunctionAddress("clRetainEvent");
    static final long clRetainKernel = C0774CL.getFunctionAddress("clRetainKernel");
    static final long clRetainMemObject = C0774CL.getFunctionAddress("clRetainMemObject");
    static final long clRetainProgram = C0774CL.getFunctionAddress("clRetainProgram");
    static final long clRetainSampler = C0774CL.getFunctionAddress("clRetainSampler");
    static final long clSetEventCallback = C0774CL.getFunctionAddress("clSetEventCallback");
    static final long clSetKernelArg = C0774CL.getFunctionAddress("clSetKernelArg");
    static final long clSetMemObjectDestructorAPPLE = C0774CL.getFunctionAddress("clSetMemObjectDestructorAPPLE");
    static final long clSetMemObjectDestructorCallback = C0774CL.getFunctionAddress("clSetMemObjectDestructorCallback");
    static final long clSetPrintfCallback = C0774CL.getFunctionAddress("clSetPrintfCallback");
    static final long clSetUserEventStatus = C0774CL.getFunctionAddress("clSetUserEventStatus");
    static final long clTerminateContextKHR = C0774CL.getFunctionAddress("clTerminateContextKHR");
    static final long clUnloadCompiler = C0774CL.getFunctionAddress("clUnloadCompiler");
    static final long clUnloadPlatformCompiler = C0774CL.getFunctionAddress("clUnloadPlatformCompiler");
    static final long clWaitForEvents = C0774CL.getFunctionAddress("clWaitForEvents");

    private CLCapabilities() {
    }

    public static CLDeviceCapabilities getDeviceCapabilities(CLDevice cLDevice) {
        CLDeviceCapabilities cLDeviceCapabilities;
        CLDevice cLDevice2 = cLDevice;
        cLDevice2.checkValid();
        CLDeviceCapabilities cLDeviceCapabilities2 = (CLDeviceCapabilities) cLDevice2.getCapabilities();
        if (cLDeviceCapabilities2 == null) {
            CLDeviceCapabilities cLDeviceCapabilities3 = cLDeviceCapabilities;
            CLDeviceCapabilities cLDeviceCapabilities4 = new CLDeviceCapabilities(cLDevice2);
            cLDeviceCapabilities2 = cLDeviceCapabilities3;
            cLDevice2.setCapabilities(cLDeviceCapabilities2);
        }
        return cLDeviceCapabilities2;
    }

    public static CLPlatformCapabilities getPlatformCapabilities(CLPlatform cLPlatform) {
        CLPlatformCapabilities cLPlatformCapabilities;
        CLPlatform cLPlatform2 = cLPlatform;
        cLPlatform2.checkValid();
        CLPlatformCapabilities cLPlatformCapabilities2 = (CLPlatformCapabilities) cLPlatform2.getCapabilities();
        if (cLPlatformCapabilities2 == null) {
            CLPlatformCapabilities cLPlatformCapabilities3 = cLPlatformCapabilities;
            CLPlatformCapabilities cLPlatformCapabilities4 = new CLPlatformCapabilities(cLPlatform2);
            cLPlatformCapabilities2 = cLPlatformCapabilities3;
            cLPlatform2.setCapabilities(cLPlatformCapabilities2);
        }
        return cLPlatformCapabilities2;
    }

    private static boolean isAPPLE_ContextLoggingFunctionsSupported() {
        boolean z = true;
        boolean z2 = (clLogMessagesToSystemLogAPPLE != 0) & (clLogMessagesToStdoutAPPLE != 0);
        if (clLogMessagesToStderrAPPLE == 0) {
            z = false;
        }
        return z2 & z;
    }

    private static boolean isAPPLE_SetMemObjectDestructorSupported() {
        return clSetMemObjectDestructorAPPLE != 0;
    }

    private static boolean isAPPLE_gl_sharingSupported() {
        return clGetGLContextInfoAPPLE != 0;
    }

    private static boolean isCL10GLSupported() {
        boolean z = true;
        boolean z2 = (clEnqueueAcquireGLObjects != 0) & (clCreateFromGLTexture2D != 0) & (clCreateFromGLBuffer != 0) & (clCreateFromGLTexture3D != 0) & (clCreateFromGLRenderbuffer != 0) & (clGetGLObjectInfo != 0) & (clGetGLTextureInfo != 0);
        if (clEnqueueReleaseGLObjects == 0) {
            z = false;
        }
        return z2 & z;
    }

    private static boolean isCL10Supported() {
        boolean z = true;
        boolean z2 = (clFinish != 0 ? 1 : false) & (clGetPlatformInfo != 0 ? 1 : false) & (clGetPlatformIDs != 0) & (clGetDeviceIDs != 0) & (clGetDeviceInfo != 0) & (clCreateContext != 0) & (clCreateContextFromType != 0) & (clRetainContext != 0) & (clReleaseContext != 0) & (clGetContextInfo != 0) & (clCreateCommandQueue != 0) & (clRetainCommandQueue != 0) & (clReleaseCommandQueue != 0) & (clGetCommandQueueInfo != 0) & (clCreateBuffer != 0) & (clEnqueueReadBuffer != 0) & (clEnqueueWriteBuffer != 0) & (clEnqueueCopyBuffer != 0) & (clEnqueueMapBuffer != 0) & (clCreateImage2D != 0) & (clCreateImage3D != 0) & (clGetSupportedImageFormats != 0) & (clEnqueueReadImage != 0) & (clEnqueueWriteImage != 0) & (clEnqueueCopyImage != 0) & (clEnqueueCopyImageToBuffer != 0) & (clEnqueueCopyBufferToImage != 0) & (clEnqueueMapImage != 0) & (clGetImageInfo != 0) & (clRetainMemObject != 0) & (clReleaseMemObject != 0) & (clEnqueueUnmapMemObject != 0) & (clGetMemObjectInfo != 0) & (clCreateSampler != 0) & (clRetainSampler != 0) & (clReleaseSampler != 0) & (clGetSamplerInfo != 0) & (clCreateProgramWithSource != 0) & (clCreateProgramWithBinary != 0) & (clRetainProgram != 0) & (clReleaseProgram != 0) & (clBuildProgram != 0) & (clUnloadCompiler != 0) & (clGetProgramInfo != 0) & (clGetProgramBuildInfo != 0) & (clCreateKernel != 0) & (clCreateKernelsInProgram != 0) & (clRetainKernel != 0) & (clReleaseKernel != 0) & (clSetKernelArg != 0) & (clGetKernelInfo != 0) & (clGetKernelWorkGroupInfo != 0) & (clEnqueueNDRangeKernel != 0 ? true : 0) & (clEnqueueTask != 0) & (clEnqueueNativeKernel != 0 ? true : 0) & (clWaitForEvents != 0) & (clGetEventInfo != 0) & (clRetainEvent != 0) & (clReleaseEvent != 0) & (clEnqueueMarker != 0) & (clEnqueueBarrier != 0) & (clEnqueueWaitForEvents != 0) & (clGetEventProfilingInfo != 0) & (clFlush != 0);
        if (clGetExtensionFunctionAddress == 0) {
            z = false;
        }
        return z2 & z;
    }

    private static boolean isCL11Supported() {
        boolean z = true;
        boolean z2 = (clSetUserEventStatus != 0) & (clSetMemObjectDestructorCallback != 0) & (clCreateSubBuffer != 0) & (clEnqueueReadBufferRect != 0) & (clEnqueueWriteBufferRect != 0) & (clEnqueueCopyBufferRect != 0) & (clCreateUserEvent != 0);
        if (clSetEventCallback == 0) {
            z = false;
        }
        return z2 & z;
    }

    private static boolean isCL12GLSupported() {
        return clCreateFromGLTexture != 0;
    }

    private static boolean isCL12Supported() {
        boolean z = true;
        boolean z2 = (clEnqueueBarrierWithWaitList != 0) & (clReleaseDevice != 0) & (clRetainDevice != 0) & (clCreateSubDevices != 0) & (clCreateImage != 0) & (clCreateProgramWithBuiltInKernels != 0) & (clCompileProgram != 0) & (clLinkProgram != 0) & (clUnloadPlatformCompiler != 0) & (clGetKernelArgInfo != 0) & (clEnqueueFillBuffer != 0) & (clEnqueueFillImage != 0) & (clEnqueueMigrateMemObjects != 0) & (clEnqueueMarkerWithWaitList != 0);
        if (clSetPrintfCallback == 0) {
        }
        boolean z3 = z2 & true;
        if (clGetExtensionFunctionAddressForPlatform == 0) {
            z = false;
        }
        return z3 & z;
    }

    private static boolean isEXT_device_fissionSupported() {
        boolean z = true;
        boolean z2 = (clRetainDeviceEXT != 0) & (clReleaseDeviceEXT != 0);
        if (clCreateSubDevicesEXT == 0) {
            z = false;
        }
        return z2 & z;
    }

    private static boolean isEXT_migrate_memobjectSupported() {
        return clEnqueueMigrateMemObjectEXT != 0;
    }

    private static boolean isKHR_gl_eventSupported() {
        return clCreateEventFromGLsyncKHR != 0;
    }

    private static boolean isKHR_gl_sharingSupported() {
        return clGetGLContextInfoKHR != 0;
    }

    private static boolean isKHR_icdSupported() {
        if (clIcdGetPlatformIDsKHR == 0) {
        }
        return true;
    }

    private static boolean isKHR_subgroupsSupported() {
        return clGetKernelSubGroupInfoKHR != 0;
    }

    private static boolean isKHR_terminate_contextSupported() {
        return clTerminateContextKHR != 0;
    }
}

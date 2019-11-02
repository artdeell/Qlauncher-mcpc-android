package org.lwjgl.opencl;

public class CLDeviceCapabilities {
    public final boolean CL_AMD_device_attribute_query;
    public final boolean CL_AMD_device_memory_flags;
    public final boolean CL_AMD_fp64;
    public final boolean CL_AMD_media_ops;
    public final boolean CL_AMD_media_ops2;
    public final boolean CL_AMD_offline_devices;
    public final boolean CL_AMD_popcnt;
    public final boolean CL_AMD_printf;
    public final boolean CL_AMD_vec3;
    final boolean CL_APPLE_ContextLoggingFunctions;
    public final boolean CL_APPLE_SetMemObjectDestructor;
    public final boolean CL_APPLE_gl_sharing;
    public final boolean CL_EXT_atomic_counters_32;
    public final boolean CL_EXT_atomic_counters_64;
    public final boolean CL_EXT_device_fission;
    public final boolean CL_EXT_migrate_memobject;
    public final boolean CL_INTEL_immediate_execution;
    public final boolean CL_INTEL_printf;
    public final boolean CL_INTEL_thread_local_exec;
    public final boolean CL_KHR_3d_image_writes;
    public final boolean CL_KHR_byte_addressable_store;
    public final boolean CL_KHR_depth_images;
    public final boolean CL_KHR_fp16;
    public final boolean CL_KHR_fp64;
    public final boolean CL_KHR_gl_depth_images;
    public final boolean CL_KHR_gl_event;
    public final boolean CL_KHR_gl_msaa_sharing;
    public final boolean CL_KHR_gl_sharing;
    public final boolean CL_KHR_global_int32_base_atomics;
    public final boolean CL_KHR_global_int32_extended_atomics;
    public final boolean CL_KHR_image2d_from_buffer;
    public final boolean CL_KHR_initialize_memory;
    public final boolean CL_KHR_int64_base_atomics;
    public final boolean CL_KHR_int64_extended_atomics;
    public final boolean CL_KHR_local_int32_base_atomics;
    public final boolean CL_KHR_local_int32_extended_atomics;
    public final boolean CL_KHR_mipmap_image;
    public final boolean CL_KHR_mipmap_image_writes;
    public final boolean CL_KHR_select_fprounding_mode;
    public final boolean CL_KHR_spir;
    public final boolean CL_KHR_srgb_image_writes;
    public final boolean CL_KHR_subgroups;
    public final boolean CL_KHR_terminate_context;
    public final boolean CL_NV_compiler_options;
    public final boolean CL_NV_device_attribute_query;
    public final boolean CL_NV_pragma_unroll;
    public final boolean OpenCL11;
    public final boolean OpenCL12;
    public final int majorVersion;
    public final int minorVersion;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00bb, code lost:
        if (1 <= r2.minorVersion) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00f9, code lost:
        if (2 <= r2.minorVersion) goto L_0x00fb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00db A[Catch:{ RuntimeException -> 0x0466 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x03ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CLDeviceCapabilities(org.lwjgl.opencl.CLDevice r26) {
        /*
            r25 = this;
            r2 = r25
            r3 = r26
            r20 = 1
            r4 = r20
            r20 = r2
            r20.<init>()
            r20 = r3
            r21 = 4144(0x1030, float:5.807E-42)
            java.lang.String r20 = r20.getInfoString(r21)
            r5 = r20
            r20 = r3
            r21 = 4143(0x102f, float:5.806E-42)
            java.lang.String r20 = r20.getInfoString(r21)
            r6 = r20
            r20 = r6
            java.lang.String r21 = "OpenCL "
            boolean r20 = r20.startsWith(r21)
            if (r20 != 0) goto L_0x0052
            java.lang.RuntimeException r20 = new java.lang.RuntimeException
            r24 = r20
            r20 = r24
            r21 = r24
            java.lang.StringBuilder r22 = new java.lang.StringBuilder
            r24 = r22
            r22 = r24
            r23 = r24
            r23.<init>()
            java.lang.String r23 = "Invalid OpenCL version string: "
            java.lang.StringBuilder r22 = r22.append(r23)
            r23 = r6
            java.lang.StringBuilder r22 = r22.append(r23)
            java.lang.String r22 = r22.toString()
            r21.<init>(r22)
            throw r20
        L_0x0052:
            java.util.StringTokenizer r20 = new java.util.StringTokenizer     // Catch:{ RuntimeException -> 0x0466 }
            r24 = r20
            r20 = r24
            r21 = r24
            r22 = r6
            r23 = 7
            java.lang.String r22 = r22.substring(r23)     // Catch:{ RuntimeException -> 0x0466 }
            java.lang.String r23 = ". "
            r21.<init>(r22, r23)     // Catch:{ RuntimeException -> 0x0466 }
            r7 = r20
            r20 = r2
            r21 = r7
            java.lang.String r21 = r21.nextToken()     // Catch:{ RuntimeException -> 0x0466 }
            int r21 = java.lang.Integer.parseInt(r21)     // Catch:{ RuntimeException -> 0x0466 }
            r0 = r21
            r1 = r20
            r1.majorVersion = r0     // Catch:{ RuntimeException -> 0x0466 }
            r20 = r2
            r21 = r7
            java.lang.String r21 = r21.nextToken()     // Catch:{ RuntimeException -> 0x0466 }
            int r21 = java.lang.Integer.parseInt(r21)     // Catch:{ RuntimeException -> 0x0466 }
            r0 = r21
            r1 = r20
            r1.minorVersion = r0     // Catch:{ RuntimeException -> 0x0466 }
            r20 = r4
            r21 = r2
            r0 = r21
            int r0 = r0.majorVersion     // Catch:{ RuntimeException -> 0x0466 }
            r21 = r0
            r0 = r20
            r1 = r21
            if (r0 < r1) goto L_0x00bd
            r20 = r4
            r21 = r2
            r0 = r21
            int r0 = r0.majorVersion     // Catch:{ RuntimeException -> 0x0466 }
            r21 = r0
            r0 = r20
            r1 = r21
            if (r0 != r1) goto L_0x045a
            r20 = r4
            r21 = r2
            r0 = r21
            int r0 = r0.minorVersion     // Catch:{ RuntimeException -> 0x0466 }
            r21 = r0
            r0 = r20
            r1 = r21
            if (r0 > r1) goto L_0x045a
        L_0x00bd:
            r20 = r4
            r9 = r20
        L_0x00c1:
            r20 = r2
            r21 = r9
            r0 = r21
            r1 = r20
            r1.OpenCL11 = r0     // Catch:{ RuntimeException -> 0x0466 }
            r20 = r4
            r21 = r2
            r0 = r21
            int r0 = r0.majorVersion     // Catch:{ RuntimeException -> 0x0466 }
            r21 = r0
            r0 = r20
            r1 = r21
            if (r0 < r1) goto L_0x00fb
            r20 = r4
            r21 = r2
            r0 = r21
            int r0 = r0.majorVersion     // Catch:{ RuntimeException -> 0x0466 }
            r21 = r0
            r0 = r20
            r1 = r21
            if (r0 != r1) goto L_0x0460
            r20 = 2
            r21 = r2
            r0 = r21
            int r0 = r0.minorVersion     // Catch:{ RuntimeException -> 0x0466 }
            r21 = r0
            r0 = r20
            r1 = r21
            if (r0 > r1) goto L_0x0460
        L_0x00fb:
            r20 = r4
            r10 = r20
        L_0x00ff:
            r20 = r2
            r21 = r10
            r0 = r21
            r1 = r20
            r1.OpenCL12 = r0     // Catch:{ RuntimeException -> 0x0466 }
            r20 = r5
            java.util.Set r20 = org.lwjgl.opencl.APIUtil.getExtensions(r20)
            r11 = r20
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_amd_device_attribute_query"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_AMD_device_attribute_query = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_amd_device_memory_flags"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_AMD_device_memory_flags = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_amd_fp64"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_AMD_fp64 = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_amd_media_ops"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_AMD_media_ops = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_amd_media_ops2"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_AMD_media_ops2 = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_amd_offline_devices"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_AMD_offline_devices = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_amd_popcnt"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_AMD_popcnt = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_amd_printf"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_AMD_printf = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_amd_vec3"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_AMD_vec3 = r0
            r20 = r11
            java.lang.String r21 = "cl_apple_contextloggingfunctions"
            boolean r20 = r20.contains(r21)
            if (r20 == 0) goto L_0x04a0
            boolean r20 = org.lwjgl.opencl.CLCapabilities.CL_APPLE_ContextLoggingFunctions
            if (r20 == 0) goto L_0x04a0
            r20 = r4
            r12 = r20
        L_0x01b3:
            r20 = r2
            r21 = r12
            r0 = r21
            r1 = r20
            r1.CL_APPLE_ContextLoggingFunctions = r0
            r20 = r11
            java.lang.String r21 = "cl_apple_setmemobjectdestructor"
            boolean r20 = r20.contains(r21)
            if (r20 == 0) goto L_0x04a6
            boolean r20 = org.lwjgl.opencl.CLCapabilities.CL_APPLE_SetMemObjectDestructor
            if (r20 == 0) goto L_0x04a6
            r20 = r4
            r13 = r20
        L_0x01cf:
            r20 = r2
            r21 = r13
            r0 = r21
            r1 = r20
            r1.CL_APPLE_SetMemObjectDestructor = r0
            r20 = r11
            java.lang.String r21 = "cl_apple_gl_sharing"
            boolean r20 = r20.contains(r21)
            if (r20 == 0) goto L_0x04ac
            boolean r20 = org.lwjgl.opencl.CLCapabilities.CL_APPLE_gl_sharing
            if (r20 == 0) goto L_0x04ac
            r20 = r4
            r14 = r20
        L_0x01eb:
            r20 = r2
            r21 = r14
            r0 = r21
            r1 = r20
            r1.CL_APPLE_gl_sharing = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_ext_atomic_counters_32"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_EXT_atomic_counters_32 = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_ext_atomic_counters_64"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_EXT_atomic_counters_64 = r0
            r20 = r11
            java.lang.String r21 = "cl_ext_device_fission"
            boolean r20 = r20.contains(r21)
            if (r20 == 0) goto L_0x04b2
            boolean r20 = org.lwjgl.opencl.CLCapabilities.CL_EXT_device_fission
            if (r20 == 0) goto L_0x04b2
            r20 = r4
            r15 = r20
        L_0x0227:
            r20 = r2
            r21 = r15
            r0 = r21
            r1 = r20
            r1.CL_EXT_device_fission = r0
            r20 = r11
            java.lang.String r21 = "cl_ext_migrate_memobject"
            boolean r20 = r20.contains(r21)
            if (r20 == 0) goto L_0x04b8
            boolean r20 = org.lwjgl.opencl.CLCapabilities.CL_EXT_migrate_memobject
            if (r20 == 0) goto L_0x04b8
            r20 = r4
            r16 = r20
        L_0x0243:
            r20 = r2
            r21 = r16
            r0 = r21
            r1 = r20
            r1.CL_EXT_migrate_memobject = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_intel_immediate_execution"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_INTEL_immediate_execution = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_intel_printf"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_INTEL_printf = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_intel_thread_local_exec"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_INTEL_thread_local_exec = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_3d_image_writes"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_3d_image_writes = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_byte_addressable_store"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_byte_addressable_store = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_depth_images"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_depth_images = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_fp16"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_fp16 = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_fp64"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_fp64 = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_gl_depth_images"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_gl_depth_images = r0
            r20 = r11
            java.lang.String r21 = "cl_khr_gl_event"
            boolean r20 = r20.contains(r21)
            if (r20 == 0) goto L_0x04be
            boolean r20 = org.lwjgl.opencl.CLCapabilities.CL_KHR_gl_event
            if (r20 == 0) goto L_0x04be
            r20 = r4
            r17 = r20
        L_0x02ef:
            r20 = r2
            r21 = r17
            r0 = r21
            r1 = r20
            r1.CL_KHR_gl_event = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_gl_msaa_sharing"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_gl_msaa_sharing = r0
            r20 = r11
            java.lang.String r21 = "cl_khr_gl_sharing"
            boolean r20 = r20.contains(r21)
            if (r20 == 0) goto L_0x04c4
            boolean r20 = org.lwjgl.opencl.CLCapabilities.CL_KHR_gl_sharing
            if (r20 == 0) goto L_0x04c4
            r20 = r4
            r18 = r20
        L_0x031b:
            r20 = r2
            r21 = r18
            r0 = r21
            r1 = r20
            r1.CL_KHR_gl_sharing = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_global_int32_base_atomics"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_global_int32_base_atomics = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_global_int32_extended_atomics"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_global_int32_extended_atomics = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_image2d_from_buffer"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_image2d_from_buffer = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_initialize_memory"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_initialize_memory = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_int64_base_atomics"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_int64_base_atomics = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_int64_extended_atomics"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_int64_extended_atomics = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_local_int32_base_atomics"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_local_int32_base_atomics = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_local_int32_extended_atomics"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_local_int32_extended_atomics = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_mipmap_image"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_mipmap_image = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_mipmap_image_writes"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_mipmap_image_writes = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_select_fprounding_mode"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_select_fprounding_mode = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_spir"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_spir = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_khr_srgb_image_writes"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_KHR_srgb_image_writes = r0
            r20 = r11
            java.lang.String r21 = "cl_khr_subgroups"
            boolean r20 = r20.contains(r21)
            if (r20 == 0) goto L_0x04ca
            boolean r20 = org.lwjgl.opencl.CLCapabilities.CL_KHR_subgroups
            if (r20 == 0) goto L_0x04ca
            r20 = r4
            r19 = r20
        L_0x0407:
            r20 = r2
            r21 = r19
            r0 = r21
            r1 = r20
            r1.CL_KHR_subgroups = r0
            r20 = r11
            java.lang.String r21 = "cl_khr_terminate_context"
            boolean r20 = r20.contains(r21)
            if (r20 == 0) goto L_0x04d0
            boolean r20 = org.lwjgl.opencl.CLCapabilities.CL_KHR_terminate_context
            if (r20 == 0) goto L_0x04d0
        L_0x041f:
            r20 = r2
            r21 = r4
            r0 = r21
            r1 = r20
            r1.CL_KHR_terminate_context = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_nv_compiler_options"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_NV_compiler_options = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_nv_device_attribute_query"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_NV_device_attribute_query = r0
            r20 = r2
            r21 = r11
            java.lang.String r22 = "cl_nv_pragma_unroll"
            boolean r21 = r21.contains(r22)
            r0 = r21
            r1 = r20
            r1.CL_NV_pragma_unroll = r0
            return
        L_0x045a:
            r20 = 0
            r9 = r20
            goto L_0x00c1
        L_0x0460:
            r20 = 0
            r10 = r20
            goto L_0x00ff
        L_0x0466:
            r20 = move-exception
            r8 = r20
            java.lang.RuntimeException r20 = new java.lang.RuntimeException
            r24 = r20
            r20 = r24
            r21 = r24
            java.lang.StringBuilder r22 = new java.lang.StringBuilder
            r24 = r22
            r22 = r24
            r23 = r24
            r23.<init>()
            java.lang.String r23 = "The major and/or minor OpenCL version \""
            java.lang.StringBuilder r22 = r22.append(r23)
            r23 = r6
            java.lang.StringBuilder r22 = r22.append(r23)
            java.lang.String r23 = "\" is malformed: "
            java.lang.StringBuilder r22 = r22.append(r23)
            r23 = r8
            java.lang.String r23 = r23.getMessage()
            java.lang.StringBuilder r22 = r22.append(r23)
            java.lang.String r22 = r22.toString()
            r21.<init>(r22)
            throw r20
        L_0x04a0:
            r20 = 0
            r12 = r20
            goto L_0x01b3
        L_0x04a6:
            r20 = 0
            r13 = r20
            goto L_0x01cf
        L_0x04ac:
            r20 = 0
            r14 = r20
            goto L_0x01eb
        L_0x04b2:
            r20 = 0
            r15 = r20
            goto L_0x0227
        L_0x04b8:
            r20 = 0
            r16 = r20
            goto L_0x0243
        L_0x04be:
            r20 = 0
            r17 = r20
            goto L_0x02ef
        L_0x04c4:
            r20 = 0
            r18 = r20
            goto L_0x031b
        L_0x04ca:
            r20 = 0
            r19 = r20
            goto L_0x0407
        L_0x04d0:
            r20 = 0
            r4 = r20
            goto L_0x041f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opencl.CLDeviceCapabilities.<init>(org.lwjgl.opencl.CLDevice):void");
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("OpenCL ").append(this.majorVersion).append('.').append(this.minorVersion);
        StringBuilder append2 = sb4.append(" - Extensions: ");
        if (this.CL_AMD_device_attribute_query) {
            StringBuilder append3 = sb4.append("cl_amd_device_attribute_query ");
        }
        if (this.CL_AMD_device_memory_flags) {
            StringBuilder append4 = sb4.append("cl_amd_device_memory_flags ");
        }
        if (this.CL_AMD_fp64) {
            StringBuilder append5 = sb4.append("cl_amd_fp64 ");
        }
        if (this.CL_AMD_media_ops) {
            StringBuilder append6 = sb4.append("cl_amd_media_ops ");
        }
        if (this.CL_AMD_media_ops2) {
            StringBuilder append7 = sb4.append("cl_amd_media_ops2 ");
        }
        if (this.CL_AMD_offline_devices) {
            StringBuilder append8 = sb4.append("cl_amd_offline_devices ");
        }
        if (this.CL_AMD_popcnt) {
            StringBuilder append9 = sb4.append("cl_amd_popcnt ");
        }
        if (this.CL_AMD_printf) {
            StringBuilder append10 = sb4.append("cl_amd_printf ");
        }
        if (this.CL_AMD_vec3) {
            StringBuilder append11 = sb4.append("cl_amd_vec3 ");
        }
        if (this.CL_APPLE_ContextLoggingFunctions) {
            StringBuilder append12 = sb4.append("cl_apple_contextloggingfunctions ");
        }
        if (this.CL_APPLE_SetMemObjectDestructor) {
            StringBuilder append13 = sb4.append("cl_apple_setmemobjectdestructor ");
        }
        if (this.CL_APPLE_gl_sharing) {
            StringBuilder append14 = sb4.append("cl_apple_gl_sharing ");
        }
        if (this.CL_EXT_atomic_counters_32) {
            StringBuilder append15 = sb4.append("cl_ext_atomic_counters_32 ");
        }
        if (this.CL_EXT_atomic_counters_64) {
            StringBuilder append16 = sb4.append("cl_ext_atomic_counters_64 ");
        }
        if (this.CL_EXT_device_fission) {
            StringBuilder append17 = sb4.append("cl_ext_device_fission ");
        }
        if (this.CL_EXT_migrate_memobject) {
            StringBuilder append18 = sb4.append("cl_ext_migrate_memobject ");
        }
        if (this.CL_INTEL_immediate_execution) {
            StringBuilder append19 = sb4.append("cl_intel_immediate_execution ");
        }
        if (this.CL_INTEL_printf) {
            StringBuilder append20 = sb4.append("cl_intel_printf ");
        }
        if (this.CL_INTEL_thread_local_exec) {
            StringBuilder append21 = sb4.append("cl_intel_thread_local_exec ");
        }
        if (this.CL_KHR_3d_image_writes) {
            StringBuilder append22 = sb4.append("cl_khr_3d_image_writes ");
        }
        if (this.CL_KHR_byte_addressable_store) {
            StringBuilder append23 = sb4.append("cl_khr_byte_addressable_store ");
        }
        if (this.CL_KHR_depth_images) {
            StringBuilder append24 = sb4.append("cl_khr_depth_images ");
        }
        if (this.CL_KHR_fp16) {
            StringBuilder append25 = sb4.append("cl_khr_fp16 ");
        }
        if (this.CL_KHR_fp64) {
            StringBuilder append26 = sb4.append("cl_khr_fp64 ");
        }
        if (this.CL_KHR_gl_depth_images) {
            StringBuilder append27 = sb4.append("cl_khr_gl_depth_images ");
        }
        if (this.CL_KHR_gl_event) {
            StringBuilder append28 = sb4.append("cl_khr_gl_event ");
        }
        if (this.CL_KHR_gl_msaa_sharing) {
            StringBuilder append29 = sb4.append("cl_khr_gl_msaa_sharing ");
        }
        if (this.CL_KHR_gl_sharing) {
            StringBuilder append30 = sb4.append("cl_khr_gl_sharing ");
        }
        if (this.CL_KHR_global_int32_base_atomics) {
            StringBuilder append31 = sb4.append("cl_khr_global_int32_base_atomics ");
        }
        if (this.CL_KHR_global_int32_extended_atomics) {
            StringBuilder append32 = sb4.append("cl_khr_global_int32_extended_atomics ");
        }
        if (this.CL_KHR_image2d_from_buffer) {
            StringBuilder append33 = sb4.append("cl_khr_image2d_from_buffer ");
        }
        if (this.CL_KHR_initialize_memory) {
            StringBuilder append34 = sb4.append("cl_khr_initialize_memory ");
        }
        if (this.CL_KHR_int64_base_atomics) {
            StringBuilder append35 = sb4.append("cl_khr_int64_base_atomics ");
        }
        if (this.CL_KHR_int64_extended_atomics) {
            StringBuilder append36 = sb4.append("cl_khr_int64_extended_atomics ");
        }
        if (this.CL_KHR_local_int32_base_atomics) {
            StringBuilder append37 = sb4.append("cl_khr_local_int32_base_atomics ");
        }
        if (this.CL_KHR_local_int32_extended_atomics) {
            StringBuilder append38 = sb4.append("cl_khr_local_int32_extended_atomics ");
        }
        if (this.CL_KHR_mipmap_image) {
            StringBuilder append39 = sb4.append("cl_khr_mipmap_image ");
        }
        if (this.CL_KHR_mipmap_image_writes) {
            StringBuilder append40 = sb4.append("cl_khr_mipmap_image_writes ");
        }
        if (this.CL_KHR_select_fprounding_mode) {
            StringBuilder append41 = sb4.append("cl_khr_select_fprounding_mode ");
        }
        if (this.CL_KHR_spir) {
            StringBuilder append42 = sb4.append("cl_khr_spir ");
        }
        if (this.CL_KHR_srgb_image_writes) {
            StringBuilder append43 = sb4.append("cl_khr_srgb_image_writes ");
        }
        if (this.CL_KHR_subgroups) {
            StringBuilder append44 = sb4.append("cl_khr_subgroups ");
        }
        if (this.CL_KHR_terminate_context) {
            StringBuilder append45 = sb4.append("cl_khr_terminate_context ");
        }
        if (this.CL_NV_compiler_options) {
            StringBuilder append46 = sb4.append("cl_nv_compiler_options ");
        }
        if (this.CL_NV_device_attribute_query) {
            StringBuilder append47 = sb4.append("cl_nv_device_attribute_query ");
        }
        if (this.CL_NV_pragma_unroll) {
            StringBuilder append48 = sb4.append("cl_nv_pragma_unroll ");
        }
        return sb4.toString();
    }
}

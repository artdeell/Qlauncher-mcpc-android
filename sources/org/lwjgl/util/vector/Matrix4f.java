package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Matrix4f extends Matrix implements Serializable {
    private static final long serialVersionUID = 1;
    public float m00;
    public float m01;
    public float m02;
    public float m03;
    public float m10;
    public float m11;
    public float m12;
    public float m13;
    public float m20;
    public float m21;
    public float m22;
    public float m23;
    public float m30;
    public float m31;
    public float m32;
    public float m33;

    public Matrix4f() {
        Matrix identity = setIdentity();
    }

    public Matrix4f(Matrix4f matrix4f) {
        Matrix4f load = load(matrix4f);
    }

    public static Matrix4f add(Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3) {
        Matrix4f matrix4f4;
        Matrix4f matrix4f5 = matrix4f;
        Matrix4f matrix4f6 = matrix4f2;
        Matrix4f matrix4f7 = matrix4f3;
        if (matrix4f7 == null) {
            Matrix4f matrix4f8 = matrix4f4;
            Matrix4f matrix4f9 = new Matrix4f();
            matrix4f7 = matrix4f8;
        }
        matrix4f7.m00 = matrix4f5.m00 + matrix4f6.m00;
        matrix4f7.m01 = matrix4f5.m01 + matrix4f6.m01;
        matrix4f7.m02 = matrix4f5.m02 + matrix4f6.m02;
        matrix4f7.m03 = matrix4f5.m03 + matrix4f6.m03;
        matrix4f7.m10 = matrix4f5.m10 + matrix4f6.m10;
        matrix4f7.m11 = matrix4f5.m11 + matrix4f6.m11;
        matrix4f7.m12 = matrix4f5.m12 + matrix4f6.m12;
        matrix4f7.m13 = matrix4f5.m13 + matrix4f6.m13;
        matrix4f7.m20 = matrix4f5.m20 + matrix4f6.m20;
        matrix4f7.m21 = matrix4f5.m21 + matrix4f6.m21;
        matrix4f7.m22 = matrix4f5.m22 + matrix4f6.m22;
        matrix4f7.m23 = matrix4f5.m23 + matrix4f6.m23;
        matrix4f7.m30 = matrix4f5.m30 + matrix4f6.m30;
        matrix4f7.m31 = matrix4f5.m31 + matrix4f6.m31;
        matrix4f7.m32 = matrix4f5.m32 + matrix4f6.m32;
        matrix4f7.m33 = matrix4f5.m33 + matrix4f6.m33;
        return matrix4f7;
    }

    private static float determinant3x3(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f4;
        float f11 = f5;
        float f12 = f6;
        float f13 = f7;
        float f14 = f8;
        float f15 = f9;
        return (f * ((f11 * f15) - (f12 * f14))) + (f2 * ((f12 * f13) - (f10 * f15))) + (f3 * ((f10 * f14) - (f11 * f13)));
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r38v8 */
    /* JADX WARNING: type inference failed for: r39v2 */
    /* JADX WARNING: type inference failed for: r40v0 */
    /* JADX WARNING: type inference failed for: r41v0 */
    /* JADX WARNING: type inference failed for: r42v0 */
    /* JADX WARNING: type inference failed for: r43v0 */
    /* JADX WARNING: type inference failed for: r44v0 */
    /* JADX WARNING: type inference failed for: r45v0 */
    /* JADX WARNING: type inference failed for: r46v0 */
    /* JADX WARNING: type inference failed for: r38v11 */
    /* JADX WARNING: type inference failed for: r39v4 */
    /* JADX WARNING: type inference failed for: r40v2 */
    /* JADX WARNING: type inference failed for: r41v2 */
    /* JADX WARNING: type inference failed for: r42v2 */
    /* JADX WARNING: type inference failed for: r43v2 */
    /* JADX WARNING: type inference failed for: r44v2 */
    /* JADX WARNING: type inference failed for: r45v2 */
    /* JADX WARNING: type inference failed for: r46v2 */
    /* JADX WARNING: type inference failed for: r38v15 */
    /* JADX WARNING: type inference failed for: r39v6 */
    /* JADX WARNING: type inference failed for: r40v4 */
    /* JADX WARNING: type inference failed for: r41v4 */
    /* JADX WARNING: type inference failed for: r42v4 */
    /* JADX WARNING: type inference failed for: r43v4 */
    /* JADX WARNING: type inference failed for: r44v4 */
    /* JADX WARNING: type inference failed for: r45v4 */
    /* JADX WARNING: type inference failed for: r46v4 */
    /* JADX WARNING: type inference failed for: r38v18 */
    /* JADX WARNING: type inference failed for: r39v8 */
    /* JADX WARNING: type inference failed for: r40v6 */
    /* JADX WARNING: type inference failed for: r41v6 */
    /* JADX WARNING: type inference failed for: r42v6 */
    /* JADX WARNING: type inference failed for: r43v6 */
    /* JADX WARNING: type inference failed for: r44v6 */
    /* JADX WARNING: type inference failed for: r45v6 */
    /* JADX WARNING: type inference failed for: r46v6 */
    /* JADX WARNING: type inference failed for: r38v22 */
    /* JADX WARNING: type inference failed for: r39v10 */
    /* JADX WARNING: type inference failed for: r40v8 */
    /* JADX WARNING: type inference failed for: r41v8 */
    /* JADX WARNING: type inference failed for: r42v8 */
    /* JADX WARNING: type inference failed for: r43v8 */
    /* JADX WARNING: type inference failed for: r44v8 */
    /* JADX WARNING: type inference failed for: r45v8 */
    /* JADX WARNING: type inference failed for: r46v8 */
    /* JADX WARNING: type inference failed for: r38v26 */
    /* JADX WARNING: type inference failed for: r39v12 */
    /* JADX WARNING: type inference failed for: r40v10 */
    /* JADX WARNING: type inference failed for: r41v10 */
    /* JADX WARNING: type inference failed for: r42v10 */
    /* JADX WARNING: type inference failed for: r43v10 */
    /* JADX WARNING: type inference failed for: r44v10 */
    /* JADX WARNING: type inference failed for: r45v10 */
    /* JADX WARNING: type inference failed for: r46v10 */
    /* JADX WARNING: type inference failed for: r38v29 */
    /* JADX WARNING: type inference failed for: r39v14 */
    /* JADX WARNING: type inference failed for: r40v12 */
    /* JADX WARNING: type inference failed for: r41v12 */
    /* JADX WARNING: type inference failed for: r42v12 */
    /* JADX WARNING: type inference failed for: r43v12 */
    /* JADX WARNING: type inference failed for: r44v12 */
    /* JADX WARNING: type inference failed for: r45v12 */
    /* JADX WARNING: type inference failed for: r46v12 */
    /* JADX WARNING: type inference failed for: r38v33 */
    /* JADX WARNING: type inference failed for: r39v16 */
    /* JADX WARNING: type inference failed for: r40v14 */
    /* JADX WARNING: type inference failed for: r41v14 */
    /* JADX WARNING: type inference failed for: r42v14 */
    /* JADX WARNING: type inference failed for: r43v14 */
    /* JADX WARNING: type inference failed for: r44v14 */
    /* JADX WARNING: type inference failed for: r45v14 */
    /* JADX WARNING: type inference failed for: r46v14 */
    /* JADX WARNING: type inference failed for: r38v36 */
    /* JADX WARNING: type inference failed for: r39v18 */
    /* JADX WARNING: type inference failed for: r40v16 */
    /* JADX WARNING: type inference failed for: r41v16 */
    /* JADX WARNING: type inference failed for: r42v16 */
    /* JADX WARNING: type inference failed for: r43v16 */
    /* JADX WARNING: type inference failed for: r44v16 */
    /* JADX WARNING: type inference failed for: r45v16 */
    /* JADX WARNING: type inference failed for: r46v16 */
    /* JADX WARNING: type inference failed for: r38v39 */
    /* JADX WARNING: type inference failed for: r39v20 */
    /* JADX WARNING: type inference failed for: r40v18 */
    /* JADX WARNING: type inference failed for: r41v18 */
    /* JADX WARNING: type inference failed for: r42v18 */
    /* JADX WARNING: type inference failed for: r43v18 */
    /* JADX WARNING: type inference failed for: r44v18 */
    /* JADX WARNING: type inference failed for: r45v18 */
    /* JADX WARNING: type inference failed for: r46v18 */
    /* JADX WARNING: type inference failed for: r38v43 */
    /* JADX WARNING: type inference failed for: r39v22 */
    /* JADX WARNING: type inference failed for: r40v20 */
    /* JADX WARNING: type inference failed for: r41v20 */
    /* JADX WARNING: type inference failed for: r42v20 */
    /* JADX WARNING: type inference failed for: r43v20 */
    /* JADX WARNING: type inference failed for: r44v20 */
    /* JADX WARNING: type inference failed for: r45v20 */
    /* JADX WARNING: type inference failed for: r46v20 */
    /* JADX WARNING: type inference failed for: r38v46 */
    /* JADX WARNING: type inference failed for: r39v24 */
    /* JADX WARNING: type inference failed for: r40v22 */
    /* JADX WARNING: type inference failed for: r41v22 */
    /* JADX WARNING: type inference failed for: r42v22 */
    /* JADX WARNING: type inference failed for: r43v22 */
    /* JADX WARNING: type inference failed for: r44v22 */
    /* JADX WARNING: type inference failed for: r45v22 */
    /* JADX WARNING: type inference failed for: r46v22 */
    /* JADX WARNING: type inference failed for: r38v50 */
    /* JADX WARNING: type inference failed for: r39v26 */
    /* JADX WARNING: type inference failed for: r40v24 */
    /* JADX WARNING: type inference failed for: r41v24 */
    /* JADX WARNING: type inference failed for: r42v24 */
    /* JADX WARNING: type inference failed for: r43v24 */
    /* JADX WARNING: type inference failed for: r44v24 */
    /* JADX WARNING: type inference failed for: r45v24 */
    /* JADX WARNING: type inference failed for: r46v24 */
    /* JADX WARNING: type inference failed for: r38v54 */
    /* JADX WARNING: type inference failed for: r39v28 */
    /* JADX WARNING: type inference failed for: r40v26 */
    /* JADX WARNING: type inference failed for: r41v26 */
    /* JADX WARNING: type inference failed for: r42v26 */
    /* JADX WARNING: type inference failed for: r43v26 */
    /* JADX WARNING: type inference failed for: r44v26 */
    /* JADX WARNING: type inference failed for: r45v26 */
    /* JADX WARNING: type inference failed for: r46v26 */
    /* JADX WARNING: type inference failed for: r38v57 */
    /* JADX WARNING: type inference failed for: r39v30 */
    /* JADX WARNING: type inference failed for: r40v28 */
    /* JADX WARNING: type inference failed for: r41v28 */
    /* JADX WARNING: type inference failed for: r42v28 */
    /* JADX WARNING: type inference failed for: r43v28 */
    /* JADX WARNING: type inference failed for: r44v28 */
    /* JADX WARNING: type inference failed for: r45v28 */
    /* JADX WARNING: type inference failed for: r46v28 */
    /* JADX WARNING: type inference failed for: r38v61 */
    /* JADX WARNING: type inference failed for: r39v32 */
    /* JADX WARNING: type inference failed for: r40v30 */
    /* JADX WARNING: type inference failed for: r41v30 */
    /* JADX WARNING: type inference failed for: r42v30 */
    /* JADX WARNING: type inference failed for: r43v30 */
    /* JADX WARNING: type inference failed for: r44v30 */
    /* JADX WARNING: type inference failed for: r45v30 */
    /* JADX WARNING: type inference failed for: r46v30 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 145 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.lwjgl.util.vector.Matrix4f invert(org.lwjgl.util.vector.Matrix4f r48, org.lwjgl.util.vector.Matrix4f r49) {
        /*
            r2 = r48
            r3 = r49
            r38 = r2
            float r38 = r38.determinant()
            r4 = r38
            r38 = r4
            r39 = 0
            int r38 = (r38 > r39 ? 1 : (r38 == r39 ? 0 : -1))
            if (r38 == 0) goto L_0x065a
            r38 = r3
            if (r38 != 0) goto L_0x0025
            org.lwjgl.util.vector.Matrix4f r38 = new org.lwjgl.util.vector.Matrix4f
            r47 = r38
            r38 = r47
            r39 = r47
            r39.<init>()
            r3 = r38
        L_0x0025:
            r38 = 1065353216(0x3f800000, float:1.0)
            r39 = r4
            float r38 = r38 / r39
            r5 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m11
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m12
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m13
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m21
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m22
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m23
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m31
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m32
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m33
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r6 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m10
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m12
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m13
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m20
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m22
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m23
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m30
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m32
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m33
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r0 = r38
            float r0 = -r0
            r38 = r0
            r7 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m10
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m11
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m13
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m20
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m21
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m23
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m30
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m31
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m33
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r8 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m10
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m11
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m12
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m20
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m21
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m22
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m30
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m31
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m32
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r0 = r38
            float r0 = -r0
            r38 = r0
            r9 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m01
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m02
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m03
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m21
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m22
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m23
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m31
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m32
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m33
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r0 = r38
            float r0 = -r0
            r38 = r0
            r10 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m00
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m02
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m03
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m20
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m22
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m23
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m30
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m32
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m33
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r11 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m00
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m01
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m03
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m20
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m21
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m23
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m30
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m31
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m33
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r0 = r38
            float r0 = -r0
            r38 = r0
            r12 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m00
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m01
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m02
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m20
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m21
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m22
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m30
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m31
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m32
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r13 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m01
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m02
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m03
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m11
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m12
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m13
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m31
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m32
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m33
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r14 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m00
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m02
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m03
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m10
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m12
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m13
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m30
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m32
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m33
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r0 = r38
            float r0 = -r0
            r38 = r0
            r15 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m00
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m01
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m03
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m10
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m11
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m13
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m30
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m31
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m33
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r16 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m00
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m01
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m02
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m10
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m11
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m12
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m30
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m31
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m32
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r0 = r38
            float r0 = -r0
            r38 = r0
            r17 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m01
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m02
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m03
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m11
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m12
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m13
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m21
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m22
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m23
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r0 = r38
            float r0 = -r0
            r38 = r0
            r18 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m00
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m02
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m03
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m10
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m12
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m13
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m20
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m22
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m23
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r19 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m00
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m01
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m03
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m10
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m11
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m13
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m20
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m21
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m23
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r0 = r38
            float r0 = -r0
            r38 = r0
            r20 = r38
            r38 = r2
            r0 = r38
            float r0 = r0.m00
            r38 = r0
            r39 = r2
            r0 = r39
            float r0 = r0.m01
            r39 = r0
            r40 = r2
            r0 = r40
            float r0 = r0.m02
            r40 = r0
            r41 = r2
            r0 = r41
            float r0 = r0.m10
            r41 = r0
            r42 = r2
            r0 = r42
            float r0 = r0.m11
            r42 = r0
            r43 = r2
            r0 = r43
            float r0 = r0.m12
            r43 = r0
            r44 = r2
            r0 = r44
            float r0 = r0.m20
            r44 = r0
            r45 = r2
            r0 = r45
            float r0 = r0.m21
            r45 = r0
            r46 = r2
            r0 = r46
            float r0 = r0.m22
            r46 = r0
            float r38 = determinant3x3(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            r21 = r38
            r38 = r6
            r39 = r5
            float r38 = r38 * r39
            r22 = r38
            r38 = r3
            r39 = r22
            r0 = r39
            r1 = r38
            r1.m00 = r0
            r38 = r11
            r39 = r5
            float r38 = r38 * r39
            r23 = r38
            r38 = r3
            r39 = r23
            r0 = r39
            r1 = r38
            r1.m11 = r0
            r38 = r16
            r39 = r5
            float r38 = r38 * r39
            r24 = r38
            r38 = r3
            r39 = r24
            r0 = r39
            r1 = r38
            r1.m22 = r0
            r38 = r21
            r39 = r5
            float r38 = r38 * r39
            r25 = r38
            r38 = r3
            r39 = r25
            r0 = r39
            r1 = r38
            r1.m33 = r0
            r38 = r10
            r39 = r5
            float r38 = r38 * r39
            r26 = r38
            r38 = r3
            r39 = r26
            r0 = r39
            r1 = r38
            r1.m01 = r0
            r38 = r7
            r39 = r5
            float r38 = r38 * r39
            r27 = r38
            r38 = r3
            r39 = r27
            r0 = r39
            r1 = r38
            r1.m10 = r0
            r38 = r8
            r39 = r5
            float r38 = r38 * r39
            r28 = r38
            r38 = r3
            r39 = r28
            r0 = r39
            r1 = r38
            r1.m20 = r0
            r38 = r14
            r39 = r5
            float r38 = r38 * r39
            r29 = r38
            r38 = r3
            r39 = r29
            r0 = r39
            r1 = r38
            r1.m02 = r0
            r38 = r15
            r39 = r5
            float r38 = r38 * r39
            r30 = r38
            r38 = r3
            r39 = r30
            r0 = r39
            r1 = r38
            r1.m12 = r0
            r38 = r12
            r39 = r5
            float r38 = r38 * r39
            r31 = r38
            r38 = r3
            r39 = r31
            r0 = r39
            r1 = r38
            r1.m21 = r0
            r38 = r18
            r39 = r5
            float r38 = r38 * r39
            r32 = r38
            r38 = r3
            r39 = r32
            r0 = r39
            r1 = r38
            r1.m03 = r0
            r38 = r9
            r39 = r5
            float r38 = r38 * r39
            r33 = r38
            r38 = r3
            r39 = r33
            r0 = r39
            r1 = r38
            r1.m30 = r0
            r38 = r19
            r39 = r5
            float r38 = r38 * r39
            r34 = r38
            r38 = r3
            r39 = r34
            r0 = r39
            r1 = r38
            r1.m13 = r0
            r38 = r13
            r39 = r5
            float r38 = r38 * r39
            r35 = r38
            r38 = r3
            r39 = r35
            r0 = r39
            r1 = r38
            r1.m31 = r0
            r38 = r17
            r39 = r5
            float r38 = r38 * r39
            r36 = r38
            r38 = r3
            r39 = r36
            r0 = r39
            r1 = r38
            r1.m32 = r0
            r38 = r20
            r39 = r5
            float r38 = r38 * r39
            r37 = r38
            r38 = r3
            r39 = r37
            r0 = r39
            r1 = r38
            r1.m23 = r0
            r38 = r3
            r2 = r38
        L_0x0659:
            return r2
        L_0x065a:
            r38 = 0
            r2 = r38
            goto L_0x0659
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.vector.Matrix4f.invert(org.lwjgl.util.vector.Matrix4f, org.lwjgl.util.vector.Matrix4f):org.lwjgl.util.vector.Matrix4f");
    }

    public static Matrix4f load(Matrix4f matrix4f, Matrix4f matrix4f2) {
        Matrix4f matrix4f3;
        Matrix4f matrix4f4 = matrix4f;
        Matrix4f matrix4f5 = matrix4f2;
        if (matrix4f5 == null) {
            Matrix4f matrix4f6 = matrix4f3;
            Matrix4f matrix4f7 = new Matrix4f();
            matrix4f5 = matrix4f6;
        }
        matrix4f5.m00 = matrix4f4.m00;
        matrix4f5.m01 = matrix4f4.m01;
        matrix4f5.m02 = matrix4f4.m02;
        matrix4f5.m03 = matrix4f4.m03;
        matrix4f5.m10 = matrix4f4.m10;
        matrix4f5.m11 = matrix4f4.m11;
        matrix4f5.m12 = matrix4f4.m12;
        matrix4f5.m13 = matrix4f4.m13;
        matrix4f5.m20 = matrix4f4.m20;
        matrix4f5.m21 = matrix4f4.m21;
        matrix4f5.m22 = matrix4f4.m22;
        matrix4f5.m23 = matrix4f4.m23;
        matrix4f5.m30 = matrix4f4.m30;
        matrix4f5.m31 = matrix4f4.m31;
        matrix4f5.m32 = matrix4f4.m32;
        matrix4f5.m33 = matrix4f4.m33;
        return matrix4f5;
    }

    public static Matrix4f mul(Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3) {
        Matrix4f matrix4f4;
        Matrix4f matrix4f5 = matrix4f;
        Matrix4f matrix4f6 = matrix4f2;
        Matrix4f matrix4f7 = matrix4f3;
        if (matrix4f7 == null) {
            Matrix4f matrix4f8 = matrix4f4;
            Matrix4f matrix4f9 = new Matrix4f();
            matrix4f7 = matrix4f8;
        }
        float f = (matrix4f5.m01 * matrix4f6.m00) + (matrix4f5.m11 * matrix4f6.m01) + (matrix4f5.m21 * matrix4f6.m02) + (matrix4f5.m31 * matrix4f6.m03);
        float f2 = (matrix4f5.m02 * matrix4f6.m00) + (matrix4f5.m12 * matrix4f6.m01) + (matrix4f5.m22 * matrix4f6.m02) + (matrix4f5.m32 * matrix4f6.m03);
        float f3 = (matrix4f5.m03 * matrix4f6.m00) + (matrix4f5.m13 * matrix4f6.m01) + (matrix4f5.m23 * matrix4f6.m02) + (matrix4f5.m33 * matrix4f6.m03);
        float f4 = (matrix4f5.m00 * matrix4f6.m10) + (matrix4f5.m10 * matrix4f6.m11) + (matrix4f5.m20 * matrix4f6.m12) + (matrix4f5.m30 * matrix4f6.m13);
        float f5 = (matrix4f5.m01 * matrix4f6.m10) + (matrix4f5.m11 * matrix4f6.m11) + (matrix4f5.m21 * matrix4f6.m12) + (matrix4f5.m31 * matrix4f6.m13);
        float f6 = (matrix4f5.m02 * matrix4f6.m10) + (matrix4f5.m12 * matrix4f6.m11) + (matrix4f5.m22 * matrix4f6.m12) + (matrix4f5.m32 * matrix4f6.m13);
        float f7 = (matrix4f5.m03 * matrix4f6.m10) + (matrix4f5.m13 * matrix4f6.m11) + (matrix4f5.m23 * matrix4f6.m12) + (matrix4f5.m33 * matrix4f6.m13);
        float f8 = (matrix4f5.m00 * matrix4f6.m20) + (matrix4f5.m10 * matrix4f6.m21) + (matrix4f5.m20 * matrix4f6.m22) + (matrix4f5.m30 * matrix4f6.m23);
        float f9 = (matrix4f5.m01 * matrix4f6.m20) + (matrix4f5.m11 * matrix4f6.m21) + (matrix4f5.m21 * matrix4f6.m22) + (matrix4f5.m31 * matrix4f6.m23);
        float f10 = (matrix4f5.m02 * matrix4f6.m20) + (matrix4f5.m12 * matrix4f6.m21) + (matrix4f5.m22 * matrix4f6.m22) + (matrix4f5.m32 * matrix4f6.m23);
        float f11 = (matrix4f5.m03 * matrix4f6.m20) + (matrix4f5.m13 * matrix4f6.m21) + (matrix4f5.m23 * matrix4f6.m22) + (matrix4f5.m33 * matrix4f6.m23);
        float f12 = (matrix4f5.m00 * matrix4f6.m30) + (matrix4f5.m10 * matrix4f6.m31) + (matrix4f5.m20 * matrix4f6.m32) + (matrix4f5.m30 * matrix4f6.m33);
        float f13 = (matrix4f5.m01 * matrix4f6.m30) + (matrix4f5.m11 * matrix4f6.m31) + (matrix4f5.m21 * matrix4f6.m32) + (matrix4f5.m31 * matrix4f6.m33);
        float f14 = (matrix4f5.m02 * matrix4f6.m30) + (matrix4f5.m12 * matrix4f6.m31) + (matrix4f5.m22 * matrix4f6.m32) + (matrix4f5.m32 * matrix4f6.m33);
        float f15 = (matrix4f5.m03 * matrix4f6.m30) + (matrix4f5.m13 * matrix4f6.m31) + (matrix4f5.m23 * matrix4f6.m32) + (matrix4f5.m33 * matrix4f6.m33);
        matrix4f7.m00 = (matrix4f5.m00 * matrix4f6.m00) + (matrix4f5.m10 * matrix4f6.m01) + (matrix4f5.m20 * matrix4f6.m02) + (matrix4f5.m30 * matrix4f6.m03);
        matrix4f7.m01 = f;
        matrix4f7.m02 = f2;
        matrix4f7.m03 = f3;
        matrix4f7.m10 = f4;
        matrix4f7.m11 = f5;
        matrix4f7.m12 = f6;
        matrix4f7.m13 = f7;
        matrix4f7.m20 = f8;
        matrix4f7.m21 = f9;
        matrix4f7.m22 = f10;
        matrix4f7.m23 = f11;
        matrix4f7.m30 = f12;
        matrix4f7.m31 = f13;
        matrix4f7.m32 = f14;
        matrix4f7.m33 = f15;
        return matrix4f7;
    }

    public static Matrix4f negate(Matrix4f matrix4f, Matrix4f matrix4f2) {
        Matrix4f matrix4f3;
        Matrix4f matrix4f4 = matrix4f;
        Matrix4f matrix4f5 = matrix4f2;
        if (matrix4f5 == null) {
            Matrix4f matrix4f6 = matrix4f3;
            Matrix4f matrix4f7 = new Matrix4f();
            matrix4f5 = matrix4f6;
        }
        matrix4f5.m00 = -matrix4f4.m00;
        matrix4f5.m01 = -matrix4f4.m01;
        matrix4f5.m02 = -matrix4f4.m02;
        matrix4f5.m03 = -matrix4f4.m03;
        matrix4f5.m10 = -matrix4f4.m10;
        matrix4f5.m11 = -matrix4f4.m11;
        matrix4f5.m12 = -matrix4f4.m12;
        matrix4f5.m13 = -matrix4f4.m13;
        matrix4f5.m20 = -matrix4f4.m20;
        matrix4f5.m21 = -matrix4f4.m21;
        matrix4f5.m22 = -matrix4f4.m22;
        matrix4f5.m23 = -matrix4f4.m23;
        matrix4f5.m30 = -matrix4f4.m30;
        matrix4f5.m31 = -matrix4f4.m31;
        matrix4f5.m32 = -matrix4f4.m32;
        matrix4f5.m33 = -matrix4f4.m33;
        return matrix4f5;
    }

    public static Matrix4f rotate(float f, Vector3f vector3f, Matrix4f matrix4f, Matrix4f matrix4f2) {
        Matrix4f matrix4f3;
        float f2 = f;
        Vector3f vector3f2 = vector3f;
        Matrix4f matrix4f4 = matrix4f;
        Matrix4f matrix4f5 = matrix4f2;
        if (matrix4f5 == null) {
            Matrix4f matrix4f6 = matrix4f3;
            Matrix4f matrix4f7 = new Matrix4f();
            matrix4f5 = matrix4f6;
        }
        float cos = (float) Math.cos((double) f2);
        float sin = (float) Math.sin((double) f2);
        float f3 = 1.0f - cos;
        float f4 = vector3f2.f261x * vector3f2.f262y;
        float f5 = vector3f2.f262y * vector3f2.f263z;
        float f6 = vector3f2.f261x * vector3f2.f263z;
        float f7 = sin * vector3f2.f261x;
        float f8 = sin * vector3f2.f262y;
        float f9 = sin * vector3f2.f263z;
        float f10 = cos + (f3 * vector3f2.f261x * vector3f2.f261x);
        float f11 = f9 + (f4 * f3);
        float f12 = (f6 * f3) - f8;
        float f13 = (f4 * f3) - f9;
        float f14 = cos + (f3 * vector3f2.f262y * vector3f2.f262y);
        float f15 = f7 + (f5 * f3);
        float f16 = f8 + (f6 * f3);
        float f17 = (f5 * f3) - f7;
        float f18 = cos + (f3 * vector3f2.f263z * vector3f2.f263z);
        float f19 = (f10 * matrix4f4.m00) + (f11 * matrix4f4.m10) + (f12 * matrix4f4.m20);
        float f20 = (f10 * matrix4f4.m01) + (f11 * matrix4f4.m11) + (f12 * matrix4f4.m21);
        float f21 = (f10 * matrix4f4.m02) + (f11 * matrix4f4.m12) + (f12 * matrix4f4.m22);
        float f22 = (f10 * matrix4f4.m03) + (f11 * matrix4f4.m13) + (f12 * matrix4f4.m23);
        float f23 = (f13 * matrix4f4.m00) + (f14 * matrix4f4.m10) + (f15 * matrix4f4.m20);
        float f24 = (f13 * matrix4f4.m01) + (f14 * matrix4f4.m11) + (f15 * matrix4f4.m21);
        float f25 = (f13 * matrix4f4.m02) + (f14 * matrix4f4.m12) + (f15 * matrix4f4.m22);
        float f26 = (f13 * matrix4f4.m03) + (f14 * matrix4f4.m13) + (f15 * matrix4f4.m23);
        matrix4f5.m20 = (f16 * matrix4f4.m00) + (f17 * matrix4f4.m10) + (f18 * matrix4f4.m20);
        matrix4f5.m21 = (f16 * matrix4f4.m01) + (f17 * matrix4f4.m11) + (f18 * matrix4f4.m21);
        matrix4f5.m22 = (f16 * matrix4f4.m02) + (f17 * matrix4f4.m12) + (f18 * matrix4f4.m22);
        matrix4f5.m23 = (f16 * matrix4f4.m03) + (f17 * matrix4f4.m13) + (f18 * matrix4f4.m23);
        matrix4f5.m00 = f19;
        matrix4f5.m01 = f20;
        matrix4f5.m02 = f21;
        matrix4f5.m03 = f22;
        matrix4f5.m10 = f23;
        matrix4f5.m11 = f24;
        matrix4f5.m12 = f25;
        matrix4f5.m13 = f26;
        return matrix4f5;
    }

    public static Matrix4f scale(Vector3f vector3f, Matrix4f matrix4f, Matrix4f matrix4f2) {
        Matrix4f matrix4f3;
        Vector3f vector3f2 = vector3f;
        Matrix4f matrix4f4 = matrix4f;
        Matrix4f matrix4f5 = matrix4f2;
        if (matrix4f5 == null) {
            Matrix4f matrix4f6 = matrix4f3;
            Matrix4f matrix4f7 = new Matrix4f();
            matrix4f5 = matrix4f6;
        }
        matrix4f5.m00 = matrix4f4.m00 * vector3f2.f261x;
        matrix4f5.m01 = matrix4f4.m01 * vector3f2.f261x;
        matrix4f5.m02 = matrix4f4.m02 * vector3f2.f261x;
        matrix4f5.m03 = matrix4f4.m03 * vector3f2.f261x;
        matrix4f5.m10 = matrix4f4.m10 * vector3f2.f262y;
        matrix4f5.m11 = matrix4f4.m11 * vector3f2.f262y;
        matrix4f5.m12 = matrix4f4.m12 * vector3f2.f262y;
        matrix4f5.m13 = matrix4f4.m13 * vector3f2.f262y;
        matrix4f5.m20 = matrix4f4.m20 * vector3f2.f263z;
        matrix4f5.m21 = matrix4f4.m21 * vector3f2.f263z;
        matrix4f5.m22 = matrix4f4.m22 * vector3f2.f263z;
        matrix4f5.m23 = matrix4f4.m23 * vector3f2.f263z;
        return matrix4f5;
    }

    public static Matrix4f setIdentity(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        matrix4f2.m00 = 1.0f;
        matrix4f2.m01 = 0.0f;
        matrix4f2.m02 = 0.0f;
        matrix4f2.m03 = 0.0f;
        matrix4f2.m10 = 0.0f;
        matrix4f2.m11 = 1.0f;
        matrix4f2.m12 = 0.0f;
        matrix4f2.m13 = 0.0f;
        matrix4f2.m20 = 0.0f;
        matrix4f2.m21 = 0.0f;
        matrix4f2.m22 = 1.0f;
        matrix4f2.m23 = 0.0f;
        matrix4f2.m30 = 0.0f;
        matrix4f2.m31 = 0.0f;
        matrix4f2.m32 = 0.0f;
        matrix4f2.m33 = 1.0f;
        return matrix4f2;
    }

    public static Matrix4f setZero(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        matrix4f2.m00 = 0.0f;
        matrix4f2.m01 = 0.0f;
        matrix4f2.m02 = 0.0f;
        matrix4f2.m03 = 0.0f;
        matrix4f2.m10 = 0.0f;
        matrix4f2.m11 = 0.0f;
        matrix4f2.m12 = 0.0f;
        matrix4f2.m13 = 0.0f;
        matrix4f2.m20 = 0.0f;
        matrix4f2.m21 = 0.0f;
        matrix4f2.m22 = 0.0f;
        matrix4f2.m23 = 0.0f;
        matrix4f2.m30 = 0.0f;
        matrix4f2.m31 = 0.0f;
        matrix4f2.m32 = 0.0f;
        matrix4f2.m33 = 0.0f;
        return matrix4f2;
    }

    public static Matrix4f sub(Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3) {
        Matrix4f matrix4f4;
        Matrix4f matrix4f5 = matrix4f;
        Matrix4f matrix4f6 = matrix4f2;
        Matrix4f matrix4f7 = matrix4f3;
        if (matrix4f7 == null) {
            Matrix4f matrix4f8 = matrix4f4;
            Matrix4f matrix4f9 = new Matrix4f();
            matrix4f7 = matrix4f8;
        }
        matrix4f7.m00 = matrix4f5.m00 - matrix4f6.m00;
        matrix4f7.m01 = matrix4f5.m01 - matrix4f6.m01;
        matrix4f7.m02 = matrix4f5.m02 - matrix4f6.m02;
        matrix4f7.m03 = matrix4f5.m03 - matrix4f6.m03;
        matrix4f7.m10 = matrix4f5.m10 - matrix4f6.m10;
        matrix4f7.m11 = matrix4f5.m11 - matrix4f6.m11;
        matrix4f7.m12 = matrix4f5.m12 - matrix4f6.m12;
        matrix4f7.m13 = matrix4f5.m13 - matrix4f6.m13;
        matrix4f7.m20 = matrix4f5.m20 - matrix4f6.m20;
        matrix4f7.m21 = matrix4f5.m21 - matrix4f6.m21;
        matrix4f7.m22 = matrix4f5.m22 - matrix4f6.m22;
        matrix4f7.m23 = matrix4f5.m23 - matrix4f6.m23;
        matrix4f7.m30 = matrix4f5.m30 - matrix4f6.m30;
        matrix4f7.m31 = matrix4f5.m31 - matrix4f6.m31;
        matrix4f7.m32 = matrix4f5.m32 - matrix4f6.m32;
        matrix4f7.m33 = matrix4f5.m33 - matrix4f6.m33;
        return matrix4f7;
    }

    public static Vector4f transform(Matrix4f matrix4f, Vector4f vector4f, Vector4f vector4f2) {
        Vector4f vector4f3;
        Matrix4f matrix4f2 = matrix4f;
        Vector4f vector4f4 = vector4f;
        Vector4f vector4f5 = vector4f2;
        if (vector4f5 == null) {
            Vector4f vector4f6 = vector4f3;
            Vector4f vector4f7 = new Vector4f();
            vector4f5 = vector4f6;
        }
        float f = (matrix4f2.m01 * vector4f4.f265x) + (matrix4f2.m11 * vector4f4.f266y) + (matrix4f2.m21 * vector4f4.f267z) + (matrix4f2.m31 * vector4f4.f264w);
        float f2 = (matrix4f2.m02 * vector4f4.f265x) + (matrix4f2.m12 * vector4f4.f266y) + (matrix4f2.m22 * vector4f4.f267z) + (matrix4f2.m32 * vector4f4.f264w);
        float f3 = (matrix4f2.m03 * vector4f4.f265x) + (matrix4f2.m13 * vector4f4.f266y) + (matrix4f2.m23 * vector4f4.f267z) + (matrix4f2.m33 * vector4f4.f264w);
        vector4f5.f265x = (matrix4f2.m00 * vector4f4.f265x) + (matrix4f2.m10 * vector4f4.f266y) + (matrix4f2.m20 * vector4f4.f267z) + (matrix4f2.m30 * vector4f4.f264w);
        vector4f5.f266y = f;
        vector4f5.f267z = f2;
        vector4f5.f264w = f3;
        return vector4f5;
    }

    public static Matrix4f translate(Vector2f vector2f, Matrix4f matrix4f, Matrix4f matrix4f2) {
        Matrix4f matrix4f3;
        Vector2f vector2f2 = vector2f;
        Matrix4f matrix4f4 = matrix4f;
        Matrix4f matrix4f5 = matrix4f2;
        if (matrix4f5 == null) {
            Matrix4f matrix4f6 = matrix4f3;
            Matrix4f matrix4f7 = new Matrix4f();
            matrix4f5 = matrix4f6;
        }
        matrix4f5.m30 += (matrix4f4.m00 * vector2f2.f259x) + (matrix4f4.m10 * vector2f2.f260y);
        matrix4f5.m31 += (matrix4f4.m01 * vector2f2.f259x) + (matrix4f4.m11 * vector2f2.f260y);
        matrix4f5.m32 += (matrix4f4.m02 * vector2f2.f259x) + (matrix4f4.m12 * vector2f2.f260y);
        matrix4f5.m33 += (matrix4f4.m03 * vector2f2.f259x) + (matrix4f4.m13 * vector2f2.f260y);
        return matrix4f5;
    }

    public static Matrix4f translate(Vector3f vector3f, Matrix4f matrix4f, Matrix4f matrix4f2) {
        Matrix4f matrix4f3;
        Vector3f vector3f2 = vector3f;
        Matrix4f matrix4f4 = matrix4f;
        Matrix4f matrix4f5 = matrix4f2;
        if (matrix4f5 == null) {
            Matrix4f matrix4f6 = matrix4f3;
            Matrix4f matrix4f7 = new Matrix4f();
            matrix4f5 = matrix4f6;
        }
        matrix4f5.m30 += (matrix4f4.m00 * vector3f2.f261x) + (matrix4f4.m10 * vector3f2.f262y) + (matrix4f4.m20 * vector3f2.f263z);
        matrix4f5.m31 += (matrix4f4.m01 * vector3f2.f261x) + (matrix4f4.m11 * vector3f2.f262y) + (matrix4f4.m21 * vector3f2.f263z);
        matrix4f5.m32 += (matrix4f4.m02 * vector3f2.f261x) + (matrix4f4.m12 * vector3f2.f262y) + (matrix4f4.m22 * vector3f2.f263z);
        matrix4f5.m33 += (matrix4f4.m03 * vector3f2.f261x) + (matrix4f4.m13 * vector3f2.f262y) + (matrix4f4.m23 * vector3f2.f263z);
        return matrix4f5;
    }

    public static Matrix4f transpose(Matrix4f matrix4f, Matrix4f matrix4f2) {
        Matrix4f matrix4f3;
        Matrix4f matrix4f4 = matrix4f;
        Matrix4f matrix4f5 = matrix4f2;
        if (matrix4f5 == null) {
            Matrix4f matrix4f6 = matrix4f3;
            Matrix4f matrix4f7 = new Matrix4f();
            matrix4f5 = matrix4f6;
        }
        float f = matrix4f4.m00;
        float f2 = matrix4f4.m10;
        float f3 = matrix4f4.m20;
        float f4 = matrix4f4.m30;
        float f5 = matrix4f4.m01;
        float f6 = matrix4f4.m11;
        float f7 = matrix4f4.m21;
        float f8 = matrix4f4.m31;
        float f9 = matrix4f4.m02;
        float f10 = matrix4f4.m12;
        float f11 = matrix4f4.m22;
        float f12 = matrix4f4.m32;
        float f13 = matrix4f4.m03;
        float f14 = matrix4f4.m13;
        float f15 = matrix4f4.m23;
        float f16 = matrix4f4.m33;
        matrix4f5.m00 = f;
        matrix4f5.m01 = f2;
        matrix4f5.m02 = f3;
        matrix4f5.m03 = f4;
        matrix4f5.m10 = f5;
        matrix4f5.m11 = f6;
        matrix4f5.m12 = f7;
        matrix4f5.m13 = f8;
        matrix4f5.m20 = f9;
        matrix4f5.m21 = f10;
        matrix4f5.m22 = f11;
        matrix4f5.m23 = f12;
        matrix4f5.m30 = f13;
        matrix4f5.m31 = f14;
        matrix4f5.m32 = f15;
        matrix4f5.m33 = f16;
        return matrix4f5;
    }

    public float determinant() {
        return (((this.m00 * (((((((this.m11 * this.m22) * this.m33) + ((this.m12 * this.m23) * this.m31)) + ((this.m13 * this.m21) * this.m32)) - ((this.m13 * this.m22) * this.m31)) - ((this.m11 * this.m23) * this.m32)) - ((this.m12 * this.m21) * this.m33))) - (this.m01 * (((((((this.m10 * this.m22) * this.m33) + ((this.m12 * this.m23) * this.m30)) + ((this.m13 * this.m20) * this.m32)) - ((this.m13 * this.m22) * this.m30)) - ((this.m10 * this.m23) * this.m32)) - ((this.m12 * this.m20) * this.m33)))) + (this.m02 * (((((((this.m10 * this.m21) * this.m33) + ((this.m11 * this.m23) * this.m30)) + ((this.m13 * this.m20) * this.m31)) - ((this.m13 * this.m21) * this.m30)) - ((this.m10 * this.m23) * this.m31)) - ((this.m11 * this.m20) * this.m33)))) - (this.m03 * (((((((this.m10 * this.m21) * this.m32) + ((this.m11 * this.m22) * this.m30)) + ((this.m12 * this.m20) * this.m31)) - ((this.m12 * this.m21) * this.m30)) - ((this.m10 * this.m22) * this.m31)) - ((this.m11 * this.m20) * this.m32)));
    }

    public Matrix invert() {
        return invert(this, this);
    }

    public Matrix4f load(Matrix4f matrix4f) {
        return load(matrix4f, this);
    }

    public Matrix load(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.m00 = floatBuffer2.get();
        this.m01 = floatBuffer2.get();
        this.m02 = floatBuffer2.get();
        this.m03 = floatBuffer2.get();
        this.m10 = floatBuffer2.get();
        this.m11 = floatBuffer2.get();
        this.m12 = floatBuffer2.get();
        this.m13 = floatBuffer2.get();
        this.m20 = floatBuffer2.get();
        this.m21 = floatBuffer2.get();
        this.m22 = floatBuffer2.get();
        this.m23 = floatBuffer2.get();
        this.m30 = floatBuffer2.get();
        this.m31 = floatBuffer2.get();
        this.m32 = floatBuffer2.get();
        this.m33 = floatBuffer2.get();
        return this;
    }

    public Matrix loadTranspose(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.m00 = floatBuffer2.get();
        this.m10 = floatBuffer2.get();
        this.m20 = floatBuffer2.get();
        this.m30 = floatBuffer2.get();
        this.m01 = floatBuffer2.get();
        this.m11 = floatBuffer2.get();
        this.m21 = floatBuffer2.get();
        this.m31 = floatBuffer2.get();
        this.m02 = floatBuffer2.get();
        this.m12 = floatBuffer2.get();
        this.m22 = floatBuffer2.get();
        this.m32 = floatBuffer2.get();
        this.m03 = floatBuffer2.get();
        this.m13 = floatBuffer2.get();
        this.m23 = floatBuffer2.get();
        this.m33 = floatBuffer2.get();
        return this;
    }

    public Matrix4f negate(Matrix4f matrix4f) {
        return negate(this, matrix4f);
    }

    public Matrix negate() {
        return negate(this);
    }

    public Matrix4f rotate(float f, Vector3f vector3f) {
        return rotate(f, vector3f, this);
    }

    public Matrix4f rotate(float f, Vector3f vector3f, Matrix4f matrix4f) {
        return rotate(f, vector3f, this, matrix4f);
    }

    public Matrix4f scale(Vector3f vector3f) {
        return scale(vector3f, this, this);
    }

    public Matrix setIdentity() {
        return setIdentity(this);
    }

    public Matrix setZero() {
        return setZero(this);
    }

    public Matrix store(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.m00);
        FloatBuffer put2 = floatBuffer2.put(this.m01);
        FloatBuffer put3 = floatBuffer2.put(this.m02);
        FloatBuffer put4 = floatBuffer2.put(this.m03);
        FloatBuffer put5 = floatBuffer2.put(this.m10);
        FloatBuffer put6 = floatBuffer2.put(this.m11);
        FloatBuffer put7 = floatBuffer2.put(this.m12);
        FloatBuffer put8 = floatBuffer2.put(this.m13);
        FloatBuffer put9 = floatBuffer2.put(this.m20);
        FloatBuffer put10 = floatBuffer2.put(this.m21);
        FloatBuffer put11 = floatBuffer2.put(this.m22);
        FloatBuffer put12 = floatBuffer2.put(this.m23);
        FloatBuffer put13 = floatBuffer2.put(this.m30);
        FloatBuffer put14 = floatBuffer2.put(this.m31);
        FloatBuffer put15 = floatBuffer2.put(this.m32);
        FloatBuffer put16 = floatBuffer2.put(this.m33);
        return this;
    }

    public Matrix store3f(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.m00);
        FloatBuffer put2 = floatBuffer2.put(this.m01);
        FloatBuffer put3 = floatBuffer2.put(this.m02);
        FloatBuffer put4 = floatBuffer2.put(this.m10);
        FloatBuffer put5 = floatBuffer2.put(this.m11);
        FloatBuffer put6 = floatBuffer2.put(this.m12);
        FloatBuffer put7 = floatBuffer2.put(this.m20);
        FloatBuffer put8 = floatBuffer2.put(this.m21);
        FloatBuffer put9 = floatBuffer2.put(this.m22);
        return this;
    }

    public Matrix storeTranspose(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.m00);
        FloatBuffer put2 = floatBuffer2.put(this.m10);
        FloatBuffer put3 = floatBuffer2.put(this.m20);
        FloatBuffer put4 = floatBuffer2.put(this.m30);
        FloatBuffer put5 = floatBuffer2.put(this.m01);
        FloatBuffer put6 = floatBuffer2.put(this.m11);
        FloatBuffer put7 = floatBuffer2.put(this.m21);
        FloatBuffer put8 = floatBuffer2.put(this.m31);
        FloatBuffer put9 = floatBuffer2.put(this.m02);
        FloatBuffer put10 = floatBuffer2.put(this.m12);
        FloatBuffer put11 = floatBuffer2.put(this.m22);
        FloatBuffer put12 = floatBuffer2.put(this.m32);
        FloatBuffer put13 = floatBuffer2.put(this.m03);
        FloatBuffer put14 = floatBuffer2.put(this.m13);
        FloatBuffer put15 = floatBuffer2.put(this.m23);
        FloatBuffer put16 = floatBuffer2.put(this.m33);
        return this;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(this.m00).append(' ').append(this.m10).append(' ').append(this.m20).append(' ').append(this.m30).append(10);
        StringBuilder append2 = sb4.append(this.m01).append(' ').append(this.m11).append(' ').append(this.m21).append(' ').append(this.m31).append(10);
        StringBuilder append3 = sb4.append(this.m02).append(' ').append(this.m12).append(' ').append(this.m22).append(' ').append(this.m32).append(10);
        StringBuilder append4 = sb4.append(this.m03).append(' ').append(this.m13).append(' ').append(this.m23).append(' ').append(this.m33).append(10);
        return sb4.toString();
    }

    public Matrix4f translate(Vector2f vector2f) {
        return translate(vector2f, this);
    }

    public Matrix4f translate(Vector2f vector2f, Matrix4f matrix4f) {
        return translate(vector2f, this, matrix4f);
    }

    public Matrix4f translate(Vector3f vector3f) {
        return translate(vector3f, this);
    }

    public Matrix4f translate(Vector3f vector3f, Matrix4f matrix4f) {
        return translate(vector3f, this, matrix4f);
    }

    public Matrix4f transpose(Matrix4f matrix4f) {
        return transpose(this, matrix4f);
    }

    public Matrix transpose() {
        return transpose(this);
    }
}

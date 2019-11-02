package org.lwjgl.opengl;

import java.nio.Buffer;

class References extends BaseReferences {
    Buffer ARB_matrix_palette_glMatrixIndexPointerARB_pPointer;
    Buffer ARB_vertex_blend_glWeightPointerARB_pPointer;
    Buffer EXT_fog_coord_glFogCoordPointerEXT_data;
    Buffer EXT_secondary_color_glSecondaryColorPointerEXT_pPointer;
    Buffer EXT_vertex_shader_glVariantPointerEXT_pAddr;
    Buffer EXT_vertex_weighting_glVertexWeightPointerEXT_pPointer;
    Buffer GL11_glColorPointer_pointer;
    Buffer GL11_glEdgeFlagPointer_pointer;
    Buffer GL11_glNormalPointer_pointer;
    Buffer GL11_glVertexPointer_pointer;
    Buffer GL14_glFogCoordPointer_data;

    References(ContextCapabilities contextCapabilities) {
        super(contextCapabilities);
    }

    /* access modifiers changed from: 0000 */
    public void clear() {
        super.clear();
        this.ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = null;
        this.ARB_vertex_blend_glWeightPointerARB_pPointer = null;
        this.EXT_fog_coord_glFogCoordPointerEXT_data = null;
        this.EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = null;
        this.EXT_vertex_shader_glVariantPointerEXT_pAddr = null;
        this.EXT_vertex_weighting_glVertexWeightPointerEXT_pPointer = null;
        this.GL11_glColorPointer_pointer = null;
        this.GL11_glEdgeFlagPointer_pointer = null;
        this.GL11_glNormalPointer_pointer = null;
        this.GL11_glVertexPointer_pointer = null;
        this.GL14_glFogCoordPointer_data = null;
    }

    /* access modifiers changed from: 0000 */
    public void copy(References references, int i) {
        References references2 = references;
        int i2 = i;
        super.copy(references2, i2);
        if ((i2 & 2) != 0) {
            this.ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = references2.ARB_matrix_palette_glMatrixIndexPointerARB_pPointer;
            this.ARB_vertex_blend_glWeightPointerARB_pPointer = references2.ARB_vertex_blend_glWeightPointerARB_pPointer;
            this.EXT_fog_coord_glFogCoordPointerEXT_data = references2.EXT_fog_coord_glFogCoordPointerEXT_data;
            this.EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = references2.EXT_secondary_color_glSecondaryColorPointerEXT_pPointer;
            this.EXT_vertex_shader_glVariantPointerEXT_pAddr = references2.EXT_vertex_shader_glVariantPointerEXT_pAddr;
            this.EXT_vertex_weighting_glVertexWeightPointerEXT_pPointer = references2.EXT_vertex_weighting_glVertexWeightPointerEXT_pPointer;
            this.GL11_glColorPointer_pointer = references2.GL11_glColorPointer_pointer;
            this.GL11_glEdgeFlagPointer_pointer = references2.GL11_glEdgeFlagPointer_pointer;
            this.GL11_glNormalPointer_pointer = references2.GL11_glNormalPointer_pointer;
            this.GL11_glVertexPointer_pointer = references2.GL11_glVertexPointer_pointer;
            this.GL14_glFogCoordPointer_data = references2.GL14_glFogCoordPointer_data;
        }
    }
}

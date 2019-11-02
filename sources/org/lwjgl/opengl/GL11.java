package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class GL11 {
    public static final int GL_2D = 1536;
    public static final int GL_2_BYTES = 5127;
    public static final int GL_3D = 1537;
    public static final int GL_3D_COLOR = 1538;
    public static final int GL_3D_COLOR_TEXTURE = 1539;
    public static final int GL_3_BYTES = 5128;
    public static final int GL_4D_COLOR_TEXTURE = 1540;
    public static final int GL_4_BYTES = 5129;
    public static final int GL_ACCUM = 256;
    public static final int GL_ACCUM_ALPHA_BITS = 3419;
    public static final int GL_ACCUM_BLUE_BITS = 3418;
    public static final int GL_ACCUM_BUFFER_BIT = 512;
    public static final int GL_ACCUM_CLEAR_VALUE = 2944;
    public static final int GL_ACCUM_GREEN_BITS = 3417;
    public static final int GL_ACCUM_RED_BITS = 3416;
    public static final int GL_ADD = 260;
    public static final int GL_ALL_ATTRIB_BITS = 1048575;
    public static final int GL_ALL_CLIENT_ATTRIB_BITS = -1;
    public static final int GL_ALPHA = 6406;
    public static final int GL_ALPHA12 = 32829;
    public static final int GL_ALPHA16 = 32830;
    public static final int GL_ALPHA4 = 32827;
    public static final int GL_ALPHA8 = 32828;
    public static final int GL_ALPHA_BIAS = 3357;
    public static final int GL_ALPHA_BITS = 3413;
    public static final int GL_ALPHA_SCALE = 3356;
    public static final int GL_ALPHA_TEST = 3008;
    public static final int GL_ALPHA_TEST_FUNC = 3009;
    public static final int GL_ALPHA_TEST_REF = 3010;
    public static final int GL_ALWAYS = 519;
    public static final int GL_AMBIENT = 4608;
    public static final int GL_AMBIENT_AND_DIFFUSE = 5634;
    public static final int GL_AND = 5377;
    public static final int GL_AND_INVERTED = 5380;
    public static final int GL_AND_REVERSE = 5378;
    public static final int GL_ATTRIB_STACK_DEPTH = 2992;
    public static final int GL_AUTO_NORMAL = 3456;
    public static final int GL_AUX0 = 1033;
    public static final int GL_AUX1 = 1034;
    public static final int GL_AUX2 = 1035;
    public static final int GL_AUX3 = 1036;
    public static final int GL_AUX_BUFFERS = 3072;
    public static final int GL_BACK = 1029;
    public static final int GL_BACK_LEFT = 1026;
    public static final int GL_BACK_RIGHT = 1027;
    public static final int GL_BITMAP = 6656;
    public static final int GL_BITMAP_TOKEN = 1796;
    public static final int GL_BLEND = 3042;
    public static final int GL_BLEND_DST = 3040;
    public static final int GL_BLEND_SRC = 3041;
    public static final int GL_BLUE = 6405;
    public static final int GL_BLUE_BIAS = 3355;
    public static final int GL_BLUE_BITS = 3412;
    public static final int GL_BLUE_SCALE = 3354;
    public static final int GL_BYTE = 5120;
    public static final int GL_C3F_V3F = 10788;
    public static final int GL_C4F_N3F_V3F = 10790;
    public static final int GL_C4UB_V2F = 10786;
    public static final int GL_C4UB_V3F = 10787;
    public static final int GL_CCW = 2305;
    public static final int GL_CLAMP = 10496;
    public static final int GL_CLEAR = 5376;
    public static final int GL_CLIENT_ATTRIB_STACK_DEPTH = 2993;
    public static final int GL_CLIENT_PIXEL_STORE_BIT = 1;
    public static final int GL_CLIENT_VERTEX_ARRAY_BIT = 2;
    public static final int GL_CLIP_PLANE0 = 12288;
    public static final int GL_CLIP_PLANE1 = 12289;
    public static final int GL_CLIP_PLANE2 = 12290;
    public static final int GL_CLIP_PLANE3 = 12291;
    public static final int GL_CLIP_PLANE4 = 12292;
    public static final int GL_CLIP_PLANE5 = 12293;
    public static final int GL_COEFF = 2560;
    public static final int GL_COLOR = 6144;
    public static final int GL_COLOR_ARRAY = 32886;
    public static final int GL_COLOR_ARRAY_POINTER = 32912;
    public static final int GL_COLOR_ARRAY_SIZE = 32897;
    public static final int GL_COLOR_ARRAY_STRIDE = 32899;
    public static final int GL_COLOR_ARRAY_TYPE = 32898;
    public static final int GL_COLOR_BUFFER_BIT = 16384;
    public static final int GL_COLOR_CLEAR_VALUE = 3106;
    public static final int GL_COLOR_INDEX = 6400;
    public static final int GL_COLOR_INDEXES = 5635;
    public static final int GL_COLOR_LOGIC_OP = 3058;
    public static final int GL_COLOR_MATERIAL = 2903;
    public static final int GL_COLOR_MATERIAL_FACE = 2901;
    public static final int GL_COLOR_MATERIAL_PARAMETER = 2902;
    public static final int GL_COLOR_WRITEMASK = 3107;
    public static final int GL_COMPILE = 4864;
    public static final int GL_COMPILE_AND_EXECUTE = 4865;
    public static final int GL_CONSTANT_ALPHA = 32771;
    public static final int GL_CONSTANT_ATTENUATION = 4615;
    public static final int GL_CONSTANT_COLOR = 32769;
    public static final int GL_COPY = 5379;
    public static final int GL_COPY_INVERTED = 5388;
    public static final int GL_COPY_PIXEL_TOKEN = 1798;
    public static final int GL_CULL_FACE = 2884;
    public static final int GL_CULL_FACE_MODE = 2885;
    public static final int GL_CURRENT_BIT = 1;
    public static final int GL_CURRENT_COLOR = 2816;
    public static final int GL_CURRENT_INDEX = 2817;
    public static final int GL_CURRENT_NORMAL = 2818;
    public static final int GL_CURRENT_RASTER_COLOR = 2820;
    public static final int GL_CURRENT_RASTER_DISTANCE = 2825;
    public static final int GL_CURRENT_RASTER_INDEX = 2821;
    public static final int GL_CURRENT_RASTER_POSITION = 2823;
    public static final int GL_CURRENT_RASTER_POSITION_VALID = 2824;
    public static final int GL_CURRENT_RASTER_TEXTURE_COORDS = 2822;
    public static final int GL_CURRENT_TEXTURE_COORDS = 2819;
    public static final int GL_CW = 2304;
    public static final int GL_DECAL = 8449;
    public static final int GL_DECR = 7683;
    public static final int GL_DEPTH = 6145;
    public static final int GL_DEPTH_BIAS = 3359;
    public static final int GL_DEPTH_BITS = 3414;
    public static final int GL_DEPTH_BUFFER_BIT = 256;
    public static final int GL_DEPTH_CLEAR_VALUE = 2931;
    public static final int GL_DEPTH_COMPONENT = 6402;
    public static final int GL_DEPTH_FUNC = 2932;
    public static final int GL_DEPTH_RANGE = 2928;
    public static final int GL_DEPTH_SCALE = 3358;
    public static final int GL_DEPTH_TEST = 2929;
    public static final int GL_DEPTH_WRITEMASK = 2930;
    public static final int GL_DIFFUSE = 4609;
    public static final int GL_DITHER = 3024;
    public static final int GL_DOMAIN = 2562;
    public static final int GL_DONT_CARE = 4352;
    public static final int GL_DOUBLE = 5130;
    public static final int GL_DOUBLEBUFFER = 3122;
    public static final int GL_DRAW_BUFFER = 3073;
    public static final int GL_DRAW_PIXEL_TOKEN = 1797;
    public static final int GL_DST_ALPHA = 772;
    public static final int GL_DST_COLOR = 774;
    public static final int GL_EDGE_FLAG = 2883;
    public static final int GL_EDGE_FLAG_ARRAY = 32889;
    public static final int GL_EDGE_FLAG_ARRAY_POINTER = 32915;
    public static final int GL_EDGE_FLAG_ARRAY_STRIDE = 32908;
    public static final int GL_EMISSION = 5632;
    public static final int GL_ENABLE_BIT = 8192;
    public static final int GL_EQUAL = 514;
    public static final int GL_EQUIV = 5385;
    public static final int GL_EVAL_BIT = 65536;
    public static final int GL_EXP = 2048;
    public static final int GL_EXP2 = 2049;
    public static final int GL_EXTENSIONS = 7939;
    public static final int GL_EYE_LINEAR = 9216;
    public static final int GL_EYE_PLANE = 9474;
    public static final int GL_FALSE = 0;
    public static final int GL_FASTEST = 4353;
    public static final int GL_FEEDBACK = 7169;
    public static final int GL_FEEDBACK_BUFFER_POINTER = 3568;
    public static final int GL_FEEDBACK_BUFFER_SIZE = 3569;
    public static final int GL_FEEDBACK_BUFFER_TYPE = 3570;
    public static final int GL_FILL = 6914;
    public static final int GL_FLAT = 7424;
    public static final int GL_FLOAT = 5126;
    public static final int GL_FOG = 2912;
    public static final int GL_FOG_BIT = 128;
    public static final int GL_FOG_COLOR = 2918;
    public static final int GL_FOG_DENSITY = 2914;
    public static final int GL_FOG_END = 2916;
    public static final int GL_FOG_HINT = 3156;
    public static final int GL_FOG_INDEX = 2913;
    public static final int GL_FOG_MODE = 2917;
    public static final int GL_FOG_START = 2915;
    public static final int GL_FRONT = 1028;
    public static final int GL_FRONT_AND_BACK = 1032;
    public static final int GL_FRONT_FACE = 2886;
    public static final int GL_FRONT_LEFT = 1024;
    public static final int GL_FRONT_RIGHT = 1025;
    public static final int GL_GEQUAL = 518;
    public static final int GL_GREATER = 516;
    public static final int GL_GREEN = 6404;
    public static final int GL_GREEN_BIAS = 3353;
    public static final int GL_GREEN_BITS = 3411;
    public static final int GL_GREEN_SCALE = 3352;
    public static final int GL_HINT_BIT = 32768;
    public static final int GL_INCR = 7682;
    public static final int GL_INDEX_ARRAY = 32887;
    public static final int GL_INDEX_ARRAY_POINTER = 32913;
    public static final int GL_INDEX_ARRAY_STRIDE = 32902;
    public static final int GL_INDEX_ARRAY_TYPE = 32901;
    public static final int GL_INDEX_BITS = 3409;
    public static final int GL_INDEX_CLEAR_VALUE = 3104;
    public static final int GL_INDEX_LOGIC_OP = 3057;
    public static final int GL_INDEX_MODE = 3120;
    public static final int GL_INDEX_OFFSET = 3347;
    public static final int GL_INDEX_SHIFT = 3346;
    public static final int GL_INDEX_WRITEMASK = 3105;
    public static final int GL_INT = 5124;
    public static final int GL_INTENSITY = 32841;
    public static final int GL_INTENSITY12 = 32844;
    public static final int GL_INTENSITY16 = 32845;
    public static final int GL_INTENSITY4 = 32842;
    public static final int GL_INTENSITY8 = 32843;
    public static final int GL_INVALID_ENUM = 1280;
    public static final int GL_INVALID_OPERATION = 1282;
    public static final int GL_INVALID_VALUE = 1281;
    public static final int GL_INVERT = 5386;
    public static final int GL_KEEP = 7680;
    public static final int GL_LEFT = 1030;
    public static final int GL_LEQUAL = 515;
    public static final int GL_LESS = 513;
    public static final int GL_LIGHT0 = 16384;
    public static final int GL_LIGHT1 = 16385;
    public static final int GL_LIGHT2 = 16386;
    public static final int GL_LIGHT3 = 16387;
    public static final int GL_LIGHT4 = 16388;
    public static final int GL_LIGHT5 = 16389;
    public static final int GL_LIGHT6 = 16390;
    public static final int GL_LIGHT7 = 16391;
    public static final int GL_LIGHTING = 2896;
    public static final int GL_LIGHTING_BIT = 64;
    public static final int GL_LIGHT_MODEL_AMBIENT = 2899;
    public static final int GL_LIGHT_MODEL_LOCAL_VIEWER = 2897;
    public static final int GL_LIGHT_MODEL_TWO_SIDE = 2898;
    public static final int GL_LINE = 6913;
    public static final int GL_LINEAR = 9729;
    public static final int GL_LINEAR_ATTENUATION = 4616;
    public static final int GL_LINEAR_MIPMAP_LINEAR = 9987;
    public static final int GL_LINEAR_MIPMAP_NEAREST = 9985;
    public static final int GL_LINES = 1;
    public static final int GL_LINE_BIT = 4;
    public static final int GL_LINE_LOOP = 2;
    public static final int GL_LINE_RESET_TOKEN = 1799;
    public static final int GL_LINE_SMOOTH = 2848;
    public static final int GL_LINE_SMOOTH_HINT = 3154;
    public static final int GL_LINE_STIPPLE = 2852;
    public static final int GL_LINE_STIPPLE_PATTERN = 2853;
    public static final int GL_LINE_STIPPLE_REPEAT = 2854;
    public static final int GL_LINE_STRIP = 3;
    public static final int GL_LINE_TOKEN = 1794;
    public static final int GL_LINE_WIDTH = 2849;
    public static final int GL_LINE_WIDTH_GRANULARITY = 2851;
    public static final int GL_LINE_WIDTH_RANGE = 2850;
    public static final int GL_LIST_BASE = 2866;
    public static final int GL_LIST_BIT = 131072;
    public static final int GL_LIST_INDEX = 2867;
    public static final int GL_LIST_MODE = 2864;
    public static final int GL_LOAD = 257;
    public static final int GL_LOGIC_OP = 3057;
    public static final int GL_LOGIC_OP_MODE = 3056;
    public static final int GL_LUMINANCE = 6409;
    public static final int GL_LUMINANCE12 = 32833;
    public static final int GL_LUMINANCE12_ALPHA12 = 32839;
    public static final int GL_LUMINANCE12_ALPHA4 = 32838;
    public static final int GL_LUMINANCE16 = 32834;
    public static final int GL_LUMINANCE16_ALPHA16 = 32840;
    public static final int GL_LUMINANCE4 = 32831;
    public static final int GL_LUMINANCE4_ALPHA4 = 32835;
    public static final int GL_LUMINANCE6_ALPHA2 = 32836;
    public static final int GL_LUMINANCE8 = 32832;
    public static final int GL_LUMINANCE8_ALPHA8 = 32837;
    public static final int GL_LUMINANCE_ALPHA = 6410;
    public static final int GL_MAP1_COLOR_4 = 3472;
    public static final int GL_MAP1_GRID_DOMAIN = 3536;
    public static final int GL_MAP1_GRID_SEGMENTS = 3537;
    public static final int GL_MAP1_INDEX = 3473;
    public static final int GL_MAP1_NORMAL = 3474;
    public static final int GL_MAP1_TEXTURE_COORD_1 = 3475;
    public static final int GL_MAP1_TEXTURE_COORD_2 = 3476;
    public static final int GL_MAP1_TEXTURE_COORD_3 = 3477;
    public static final int GL_MAP1_TEXTURE_COORD_4 = 3478;
    public static final int GL_MAP1_VERTEX_3 = 3479;
    public static final int GL_MAP1_VERTEX_4 = 3480;
    public static final int GL_MAP2_COLOR_4 = 3504;
    public static final int GL_MAP2_GRID_DOMAIN = 3538;
    public static final int GL_MAP2_GRID_SEGMENTS = 3539;
    public static final int GL_MAP2_INDEX = 3505;
    public static final int GL_MAP2_NORMAL = 3506;
    public static final int GL_MAP2_TEXTURE_COORD_1 = 3507;
    public static final int GL_MAP2_TEXTURE_COORD_2 = 3508;
    public static final int GL_MAP2_TEXTURE_COORD_3 = 3509;
    public static final int GL_MAP2_TEXTURE_COORD_4 = 3510;
    public static final int GL_MAP2_VERTEX_3 = 3511;
    public static final int GL_MAP2_VERTEX_4 = 3512;
    public static final int GL_MAP_COLOR = 3344;
    public static final int GL_MAP_STENCIL = 3345;
    public static final int GL_MATRIX_MODE = 2976;
    public static final int GL_MAX_ATTRIB_STACK_DEPTH = 3381;
    public static final int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 3387;
    public static final int GL_MAX_CLIP_PLANES = 3378;
    public static final int GL_MAX_EVAL_ORDER = 3376;
    public static final int GL_MAX_LIGHTS = 3377;
    public static final int GL_MAX_LIST_NESTING = 2865;
    public static final int GL_MAX_MODELVIEW_STACK_DEPTH = 3382;
    public static final int GL_MAX_NAME_STACK_DEPTH = 3383;
    public static final int GL_MAX_PIXEL_MAP_TABLE = 3380;
    public static final int GL_MAX_PROJECTION_STACK_DEPTH = 3384;
    public static final int GL_MAX_TEXTURE_SIZE = 3379;
    public static final int GL_MAX_TEXTURE_STACK_DEPTH = 3385;
    public static final int GL_MAX_VIEWPORT_DIMS = 3386;
    public static final int GL_MODELVIEW = 5888;
    public static final int GL_MODELVIEW_MATRIX = 2982;
    public static final int GL_MODELVIEW_STACK_DEPTH = 2979;
    public static final int GL_MODULATE = 8448;
    public static final int GL_MULT = 259;
    public static final int GL_N3F_V3F = 10789;
    public static final int GL_NAME_STACK_DEPTH = 3440;
    public static final int GL_NAND = 5390;
    public static final int GL_NEAREST = 9728;
    public static final int GL_NEAREST_MIPMAP_LINEAR = 9986;
    public static final int GL_NEAREST_MIPMAP_NEAREST = 9984;
    public static final int GL_NEVER = 512;
    public static final int GL_NICEST = 4354;
    public static final int GL_NONE = 0;
    public static final int GL_NOOP = 5381;
    public static final int GL_NOR = 5384;
    public static final int GL_NORMALIZE = 2977;
    public static final int GL_NORMAL_ARRAY = 32885;
    public static final int GL_NORMAL_ARRAY_POINTER = 32911;
    public static final int GL_NORMAL_ARRAY_STRIDE = 32895;
    public static final int GL_NORMAL_ARRAY_TYPE = 32894;
    public static final int GL_NOTEQUAL = 517;
    public static final int GL_NO_ERROR = 0;
    public static final int GL_OBJECT_LINEAR = 9217;
    public static final int GL_OBJECT_PLANE = 9473;
    public static final int GL_ONE = 1;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
    public static final int GL_ONE_MINUS_DST_ALPHA = 773;
    public static final int GL_ONE_MINUS_DST_COLOR = 775;
    public static final int GL_ONE_MINUS_SRC_ALPHA = 771;
    public static final int GL_ONE_MINUS_SRC_COLOR = 769;
    public static final int GL_OR = 5383;
    public static final int GL_ORDER = 2561;
    public static final int GL_OR_INVERTED = 5389;
    public static final int GL_OR_REVERSE = 5387;
    public static final int GL_OUT_OF_MEMORY = 1285;
    public static final int GL_PACK_ALIGNMENT = 3333;
    public static final int GL_PACK_LSB_FIRST = 3329;
    public static final int GL_PACK_ROW_LENGTH = 3330;
    public static final int GL_PACK_SKIP_PIXELS = 3332;
    public static final int GL_PACK_SKIP_ROWS = 3331;
    public static final int GL_PACK_SWAP_BYTES = 3328;
    public static final int GL_PASS_THROUGH_TOKEN = 1792;
    public static final int GL_PERSPECTIVE_CORRECTION_HINT = 3152;
    public static final int GL_PIXEL_MAP_A_TO_A = 3193;
    public static final int GL_PIXEL_MAP_A_TO_A_SIZE = 3257;
    public static final int GL_PIXEL_MAP_B_TO_B = 3192;
    public static final int GL_PIXEL_MAP_B_TO_B_SIZE = 3256;
    public static final int GL_PIXEL_MAP_G_TO_G = 3191;
    public static final int GL_PIXEL_MAP_G_TO_G_SIZE = 3255;
    public static final int GL_PIXEL_MAP_I_TO_A = 3189;
    public static final int GL_PIXEL_MAP_I_TO_A_SIZE = 3253;
    public static final int GL_PIXEL_MAP_I_TO_B = 3188;
    public static final int GL_PIXEL_MAP_I_TO_B_SIZE = 3252;
    public static final int GL_PIXEL_MAP_I_TO_G = 3187;
    public static final int GL_PIXEL_MAP_I_TO_G_SIZE = 3251;
    public static final int GL_PIXEL_MAP_I_TO_I = 3184;
    public static final int GL_PIXEL_MAP_I_TO_I_SIZE = 3248;
    public static final int GL_PIXEL_MAP_I_TO_R = 3186;
    public static final int GL_PIXEL_MAP_I_TO_R_SIZE = 3250;
    public static final int GL_PIXEL_MAP_R_TO_R = 3190;
    public static final int GL_PIXEL_MAP_R_TO_R_SIZE = 3254;
    public static final int GL_PIXEL_MAP_S_TO_S = 3185;
    public static final int GL_PIXEL_MAP_S_TO_S_SIZE = 3249;
    public static final int GL_PIXEL_MODE_BIT = 32;
    public static final int GL_POINT = 6912;
    public static final int GL_POINTS = 0;
    public static final int GL_POINT_BIT = 2;
    public static final int GL_POINT_SIZE = 2833;
    public static final int GL_POINT_SIZE_GRANULARITY = 2835;
    public static final int GL_POINT_SIZE_RANGE = 2834;
    public static final int GL_POINT_SMOOTH = 2832;
    public static final int GL_POINT_SMOOTH_HINT = 3153;
    public static final int GL_POINT_TOKEN = 1793;
    public static final int GL_POLYGON = 9;
    public static final int GL_POLYGON_BIT = 8;
    public static final int GL_POLYGON_MODE = 2880;
    public static final int GL_POLYGON_OFFSET_FACTOR = 32824;
    public static final int GL_POLYGON_OFFSET_FILL = 32823;
    public static final int GL_POLYGON_OFFSET_LINE = 10754;
    public static final int GL_POLYGON_OFFSET_POINT = 10753;
    public static final int GL_POLYGON_OFFSET_UNITS = 10752;
    public static final int GL_POLYGON_SMOOTH = 2881;
    public static final int GL_POLYGON_SMOOTH_HINT = 3155;
    public static final int GL_POLYGON_STIPPLE = 2882;
    public static final int GL_POLYGON_STIPPLE_BIT = 16;
    public static final int GL_POLYGON_TOKEN = 1795;
    public static final int GL_POSITION = 4611;
    public static final int GL_PROJECTION = 5889;
    public static final int GL_PROJECTION_MATRIX = 2983;
    public static final int GL_PROJECTION_STACK_DEPTH = 2980;
    public static final int GL_PROXY_TEXTURE_1D = 32867;
    public static final int GL_PROXY_TEXTURE_2D = 32868;
    public static final int GL_Q = 8195;
    public static final int GL_QUADRATIC_ATTENUATION = 4617;
    public static final int GL_QUADS = 7;
    public static final int GL_QUAD_STRIP = 8;
    public static final int GL_R = 8194;
    public static final int GL_R3_G3_B2 = 10768;
    public static final int GL_READ_BUFFER = 3074;
    public static final int GL_RED = 6403;
    public static final int GL_RED_BIAS = 3349;
    public static final int GL_RED_BITS = 3410;
    public static final int GL_RED_SCALE = 3348;
    public static final int GL_RENDER = 7168;
    public static final int GL_RENDERER = 7937;
    public static final int GL_RENDER_MODE = 3136;
    public static final int GL_REPEAT = 10497;
    public static final int GL_REPLACE = 7681;
    public static final int GL_RETURN = 258;
    public static final int GL_RGB = 6407;
    public static final int GL_RGB10 = 32850;
    public static final int GL_RGB10_A2 = 32857;
    public static final int GL_RGB12 = 32851;
    public static final int GL_RGB16 = 32852;
    public static final int GL_RGB4 = 32847;
    public static final int GL_RGB5 = 32848;
    public static final int GL_RGB5_A1 = 32855;
    public static final int GL_RGB8 = 32849;
    public static final int GL_RGBA = 6408;
    public static final int GL_RGBA12 = 32858;
    public static final int GL_RGBA16 = 32859;
    public static final int GL_RGBA2 = 32853;
    public static final int GL_RGBA4 = 32854;
    public static final int GL_RGBA8 = 32856;
    public static final int GL_RGBA_MODE = 3121;
    public static final int GL_RIGHT = 1031;
    public static final int GL_S = 8192;
    public static final int GL_SCISSOR_BIT = 524288;
    public static final int GL_SCISSOR_BOX = 3088;
    public static final int GL_SCISSOR_TEST = 3089;
    public static final int GL_SELECT = 7170;
    public static final int GL_SELECTION_BUFFER_POINTER = 3571;
    public static final int GL_SELECTION_BUFFER_SIZE = 3572;
    public static final int GL_SET = 5391;
    public static final int GL_SHADE_MODEL = 2900;
    public static final int GL_SHININESS = 5633;
    public static final int GL_SHORT = 5122;
    public static final int GL_SMOOTH = 7425;
    public static final int GL_SPECULAR = 4610;
    public static final int GL_SPHERE_MAP = 9218;
    public static final int GL_SPOT_CUTOFF = 4614;
    public static final int GL_SPOT_DIRECTION = 4612;
    public static final int GL_SPOT_EXPONENT = 4613;
    public static final int GL_SRC_ALPHA = 770;
    public static final int GL_SRC_ALPHA_SATURATE = 776;
    public static final int GL_SRC_COLOR = 768;
    public static final int GL_STACK_OVERFLOW = 1283;
    public static final int GL_STACK_UNDERFLOW = 1284;
    public static final int GL_STENCIL = 6146;
    public static final int GL_STENCIL_BITS = 3415;
    public static final int GL_STENCIL_BUFFER_BIT = 1024;
    public static final int GL_STENCIL_CLEAR_VALUE = 2961;
    public static final int GL_STENCIL_FAIL = 2964;
    public static final int GL_STENCIL_FUNC = 2962;
    public static final int GL_STENCIL_INDEX = 6401;
    public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965;
    public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966;
    public static final int GL_STENCIL_REF = 2967;
    public static final int GL_STENCIL_TEST = 2960;
    public static final int GL_STENCIL_VALUE_MASK = 2963;
    public static final int GL_STENCIL_WRITEMASK = 2968;
    public static final int GL_STEREO = 3123;
    public static final int GL_SUBPIXEL_BITS = 3408;
    public static final int GL_T = 8193;
    public static final int GL_T2F_C3F_V3F = 10794;
    public static final int GL_T2F_C4F_N3F_V3F = 10796;
    public static final int GL_T2F_C4UB_V3F = 10793;
    public static final int GL_T2F_N3F_V3F = 10795;
    public static final int GL_T2F_V3F = 10791;
    public static final int GL_T4F_C4F_N3F_V4F = 10797;
    public static final int GL_T4F_V4F = 10792;
    public static final int GL_TEXTURE = 5890;
    public static final int GL_TEXTURE_1D = 3552;
    public static final int GL_TEXTURE_2D = 3553;
    public static final int GL_TEXTURE_ALPHA_SIZE = 32863;
    public static final int GL_TEXTURE_BINDING_1D = 32872;
    public static final int GL_TEXTURE_BINDING_2D = 32873;
    public static final int GL_TEXTURE_BIT = 262144;
    public static final int GL_TEXTURE_BLUE_SIZE = 32862;
    public static final int GL_TEXTURE_BORDER = 4101;
    public static final int GL_TEXTURE_BORDER_COLOR = 4100;
    public static final int GL_TEXTURE_COMPONENTS = 4099;
    public static final int GL_TEXTURE_COORD_ARRAY = 32888;
    public static final int GL_TEXTURE_COORD_ARRAY_POINTER = 32914;
    public static final int GL_TEXTURE_COORD_ARRAY_SIZE = 32904;
    public static final int GL_TEXTURE_COORD_ARRAY_STRIDE = 32906;
    public static final int GL_TEXTURE_COORD_ARRAY_TYPE = 32905;
    public static final int GL_TEXTURE_ENV = 8960;
    public static final int GL_TEXTURE_ENV_COLOR = 8705;
    public static final int GL_TEXTURE_ENV_MODE = 8704;
    public static final int GL_TEXTURE_GEN_MODE = 9472;
    public static final int GL_TEXTURE_GEN_Q = 3171;
    public static final int GL_TEXTURE_GEN_R = 3170;
    public static final int GL_TEXTURE_GEN_S = 3168;
    public static final int GL_TEXTURE_GEN_T = 3169;
    public static final int GL_TEXTURE_GREEN_SIZE = 32861;
    public static final int GL_TEXTURE_HEIGHT = 4097;
    public static final int GL_TEXTURE_INTENSITY_SIZE = 32865;
    public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099;
    public static final int GL_TEXTURE_LUMINANCE_SIZE = 32864;
    public static final int GL_TEXTURE_MAG_FILTER = 10240;
    public static final int GL_TEXTURE_MATRIX = 2984;
    public static final int GL_TEXTURE_MIN_FILTER = 10241;
    public static final int GL_TEXTURE_PRIORITY = 32870;
    public static final int GL_TEXTURE_RED_SIZE = 32860;
    public static final int GL_TEXTURE_RESIDENT = 32871;
    public static final int GL_TEXTURE_STACK_DEPTH = 2981;
    public static final int GL_TEXTURE_WIDTH = 4096;
    public static final int GL_TEXTURE_WRAP_S = 10242;
    public static final int GL_TEXTURE_WRAP_T = 10243;
    public static final int GL_TRANSFORM_BIT = 4096;
    public static final int GL_TRIANGLES = 4;
    public static final int GL_TRIANGLE_FAN = 6;
    public static final int GL_TRIANGLE_STRIP = 5;
    public static final int GL_TRUE = 1;
    public static final int GL_UNPACK_ALIGNMENT = 3317;
    public static final int GL_UNPACK_LSB_FIRST = 3313;
    public static final int GL_UNPACK_ROW_LENGTH = 3314;
    public static final int GL_UNPACK_SKIP_PIXELS = 3316;
    public static final int GL_UNPACK_SKIP_ROWS = 3315;
    public static final int GL_UNPACK_SWAP_BYTES = 3312;
    public static final int GL_UNSIGNED_BYTE = 5121;
    public static final int GL_UNSIGNED_INT = 5125;
    public static final int GL_UNSIGNED_SHORT = 5123;
    public static final int GL_V2F = 10784;
    public static final int GL_V3F = 10785;
    public static final int GL_VENDOR = 7936;
    public static final int GL_VERSION = 7938;
    public static final int GL_VERTEX_ARRAY = 32884;
    public static final int GL_VERTEX_ARRAY_POINTER = 32910;
    public static final int GL_VERTEX_ARRAY_SIZE = 32890;
    public static final int GL_VERTEX_ARRAY_STRIDE = 32892;
    public static final int GL_VERTEX_ARRAY_TYPE = 32891;
    public static final int GL_VIEWPORT = 2978;
    public static final int GL_VIEWPORT_BIT = 2048;
    public static final int GL_XOR = 5382;
    public static final int GL_ZERO = 0;
    public static final int GL_ZOOM_X = 3350;
    public static final int GL_ZOOM_Y = 3351;

    private GL11() {
    }

    public static void glAccum(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glAccum;
        BufferChecks.checkFunctionAddress(j);
        nglAccum(i2, f2, j);
    }

    public static void glAlphaFunc(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glAlphaFunc;
        BufferChecks.checkFunctionAddress(j);
        nglAlphaFunc(i2, f2, j);
    }

    public static boolean glAreTexturesResident(IntBuffer intBuffer, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glAreTexturesResident;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkBuffer(byteBuffer2, intBuffer2.remaining());
        return nglAreTexturesResident(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glArrayElement(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glArrayElement;
        BufferChecks.checkFunctionAddress(j);
        nglArrayElement(i2, j);
    }

    public static void glBegin(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBegin;
        BufferChecks.checkFunctionAddress(j);
        nglBegin(i2, j);
    }

    public static void glBindTexture(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindTexture;
        BufferChecks.checkFunctionAddress(j);
        nglBindTexture(i3, i4, j);
    }

    public static void glBitmap(int i, int i2, float f, float f2, float f3, float f4, long j) {
        int i3 = i;
        int i4 = i2;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glBitmap;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglBitmapBO(i3, i4, f5, f6, f7, f8, j2, j3);
    }

    public static void glBitmap(int i, int i2, float f, float f2, float f3, float f4, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glBitmap;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, i4 * ((i3 + 7) / 8));
        }
        nglBitmap(i3, i4, f5, f6, f7, f8, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glBlendFunc(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBlendFunc;
        BufferChecks.checkFunctionAddress(j);
        nglBlendFunc(i3, i4, j);
    }

    public static void glCallList(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glCallList;
        BufferChecks.checkFunctionAddress(j);
        nglCallList(i2, j);
    }

    public static void glCallLists(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glCallLists;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglCallLists(byteBuffer2.remaining(), GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCallLists(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glCallLists;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglCallLists(intBuffer2.remaining(), GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glCallLists(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glCallLists;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglCallLists(shortBuffer2.remaining(), GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glClear(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glClear;
        BufferChecks.checkFunctionAddress(j);
        nglClear(i2, j);
    }

    public static void glClearAccum(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glClearAccum;
        BufferChecks.checkFunctionAddress(j);
        nglClearAccum(f5, f6, f7, f8, j);
    }

    public static void glClearColor(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glClearColor;
        BufferChecks.checkFunctionAddress(j);
        nglClearColor(f5, f6, f7, f8, j);
    }

    public static void glClearDepth(double d) {
        double d2 = d;
        long j = GLContext.getCapabilities().glClearDepth;
        BufferChecks.checkFunctionAddress(j);
        nglClearDepth(d2, j);
    }

    public static void glClearStencil(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glClearStencil;
        BufferChecks.checkFunctionAddress(j);
        nglClearStencil(i2, j);
    }

    public static void glClipPlane(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glClipPlane;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglClipPlane(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glColor3b(byte b, byte b2, byte b3) {
        byte b4 = b;
        byte b5 = b2;
        byte b6 = b3;
        long j = GLContext.getCapabilities().glColor3b;
        BufferChecks.checkFunctionAddress(j);
        nglColor3b(b4, b5, b6, j);
    }

    public static void glColor3d(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glColor3d;
        BufferChecks.checkFunctionAddress(j);
        nglColor3d(d4, d5, d6, j);
    }

    public static void glColor3f(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glColor3f;
        BufferChecks.checkFunctionAddress(j);
        nglColor3f(f4, f5, f6, j);
    }

    public static void glColor3ub(byte b, byte b2, byte b3) {
        byte b4 = b;
        byte b5 = b2;
        byte b6 = b3;
        long j = GLContext.getCapabilities().glColor3ub;
        BufferChecks.checkFunctionAddress(j);
        nglColor3ub(b4, b5, b6, j);
    }

    public static void glColor4b(byte b, byte b2, byte b3, byte b4) {
        byte b5 = b;
        byte b6 = b2;
        byte b7 = b3;
        byte b8 = b4;
        long j = GLContext.getCapabilities().glColor4b;
        BufferChecks.checkFunctionAddress(j);
        nglColor4b(b5, b6, b7, b8, j);
    }

    public static void glColor4d(double d, double d2, double d3, double d4) {
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glColor4d;
        BufferChecks.checkFunctionAddress(j);
        nglColor4d(d5, d6, d7, d8, j);
    }

    public static void glColor4f(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glColor4f;
        BufferChecks.checkFunctionAddress(j);
        nglColor4f(f5, f6, f7, f8, j);
    }

    public static void glColor4ub(byte b, byte b2, byte b3, byte b4) {
        byte b5 = b;
        byte b6 = b2;
        byte b7 = b3;
        byte b8 = b4;
        long j = GLContext.getCapabilities().glColor4ub;
        BufferChecks.checkFunctionAddress(j);
        nglColor4ub(b5, b6, b7, b8, j);
    }

    public static void glColorMask(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = z;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        long j = GLContext.getCapabilities().glColorMask;
        BufferChecks.checkFunctionAddress(j);
        nglColorMask(z5, z6, z7, z8, j);
    }

    public static void glColorMaterial(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glColorMaterial;
        BufferChecks.checkFunctionAddress(j);
        nglColorMaterial(i3, i4, j);
    }

    public static void glColorPointer(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glColorPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglColorPointerBO(i4, i5, i6, j2, j3);
    }

    public static void glColorPointer(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glColorPointer_pointer = byteBuffer2;
        }
        nglColorPointer(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glColorPointer(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glColorPointer_pointer = doubleBuffer2;
        }
        nglColorPointer(i3, 5130, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glColorPointer(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glColorPointer_pointer = floatBuffer2;
        }
        nglColorPointer(i3, GL_FLOAT, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glColorPointer(int i, boolean z, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glColorPointer_pointer = byteBuffer2;
        }
        nglColorPointer(i3, z2 ? 5121 : 5120, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCopyPixels(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glCopyPixels;
        BufferChecks.checkFunctionAddress(j);
        nglCopyPixels(i6, i7, i8, i9, i10, j);
    }

    public static void glCopyTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j = GLContext.getCapabilities().glCopyTexImage1D;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTexImage1D(i8, i9, i10, i11, i12, i13, i14, j);
    }

    public static void glCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j = GLContext.getCapabilities().glCopyTexImage2D;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTexImage2D(i9, i10, i11, i12, i13, i14, i15, i16, j);
    }

    public static void glCopyTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glCopyTexSubImage1D;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTexSubImage1D(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j = GLContext.getCapabilities().glCopyTexSubImage2D;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTexSubImage2D(i9, i10, i11, i12, i13, i14, i15, i16, j);
    }

    public static void glCullFace(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glCullFace;
        BufferChecks.checkFunctionAddress(j);
        nglCullFace(i2, j);
    }

    public static void glDeleteLists(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDeleteLists;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteLists(i3, i4, j);
    }

    public static void glDeleteTextures(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteTextures;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteTextures(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteTextures(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteTextures;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteTextures(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDepthFunc(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDepthFunc;
        BufferChecks.checkFunctionAddress(j);
        nglDepthFunc(i2, j);
    }

    public static void glDepthMask(boolean z) {
        boolean z2 = z;
        long j = GLContext.getCapabilities().glDepthMask;
        BufferChecks.checkFunctionAddress(j);
        nglDepthMask(z2, j);
    }

    public static void glDepthRange(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glDepthRange;
        BufferChecks.checkFunctionAddress(j);
        nglDepthRange(d3, d4, j);
    }

    public static void glDisable(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDisable;
        BufferChecks.checkFunctionAddress(j);
        nglDisable(i2, j);
    }

    public static void glDisableClientState(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDisableClientState;
        BufferChecks.checkFunctionAddress(j);
        nglDisableClientState(i2, j);
    }

    public static void glDrawArrays(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glDrawArrays;
        BufferChecks.checkFunctionAddress(j);
        nglDrawArrays(i4, i5, i6, j);
    }

    public static void glDrawBuffer(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDrawBuffer;
        BufferChecks.checkFunctionAddress(j);
        nglDrawBuffer(i2, j);
    }

    public static void glDrawElements(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawElements;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureElementVBOenabled(capabilities);
        nglDrawElementsBO(i4, i5, i6, j2, j3);
    }

    public static void glDrawElements(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElements;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, i5);
        nglDrawElements(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glDrawElements(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElements;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglDrawElements(i2, byteBuffer2.remaining(), GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glDrawElements(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElements;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawElements(i2, intBuffer2.remaining(), GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDrawElements(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElements;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglDrawElements(i2, shortBuffer2.remaining(), GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glDrawPixels(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawPixels;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglDrawPixelsBO(i5, i6, i7, i8, j2, j3);
    }

    public static void glDrawPixels(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawPixels;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i7, i8, i5, i6, 1));
        nglDrawPixels(i5, i6, i7, i8, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glDrawPixels(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawPixels;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i7, i8, i5, i6, 1));
        nglDrawPixels(i5, i6, i7, i8, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDrawPixels(int i, int i2, int i3, int i4, ShortBuffer shortBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawPixels;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i7, i8, i5, i6, 1));
        nglDrawPixels(i5, i6, i7, i8, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glEdgeFlag(boolean z) {
        boolean z2 = z;
        long j = GLContext.getCapabilities().glEdgeFlag;
        BufferChecks.checkFunctionAddress(j);
        nglEdgeFlag(z2, j);
    }

    public static void glEdgeFlagPointer(int i, long j) {
        int i2 = i;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glEdgeFlagPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglEdgeFlagPointerBO(i2, j2, j3);
    }

    public static void glEdgeFlagPointer(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glEdgeFlagPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glEdgeFlagPointer_pointer = byteBuffer2;
        }
        nglEdgeFlagPointer(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glEnable(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEnable;
        BufferChecks.checkFunctionAddress(j);
        nglEnable(i2, j);
    }

    public static void glEnableClientState(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEnableClientState;
        BufferChecks.checkFunctionAddress(j);
        nglEnableClientState(i2, j);
    }

    public static void glEnd() {
        long j = GLContext.getCapabilities().glEnd;
        BufferChecks.checkFunctionAddress(j);
        nglEnd(j);
    }

    public static void glEndList() {
        long j = GLContext.getCapabilities().glEndList;
        BufferChecks.checkFunctionAddress(j);
        nglEndList(j);
    }

    public static void glEvalCoord1d(double d) {
        double d2 = d;
        long j = GLContext.getCapabilities().glEvalCoord1d;
        BufferChecks.checkFunctionAddress(j);
        nglEvalCoord1d(d2, j);
    }

    public static void glEvalCoord1f(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glEvalCoord1f;
        BufferChecks.checkFunctionAddress(j);
        nglEvalCoord1f(f2, j);
    }

    public static void glEvalCoord2d(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glEvalCoord2d;
        BufferChecks.checkFunctionAddress(j);
        nglEvalCoord2d(d3, d4, j);
    }

    public static void glEvalCoord2f(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glEvalCoord2f;
        BufferChecks.checkFunctionAddress(j);
        nglEvalCoord2f(f3, f4, j);
    }

    public static void glEvalMesh1(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glEvalMesh1;
        BufferChecks.checkFunctionAddress(j);
        nglEvalMesh1(i4, i5, i6, j);
    }

    public static void glEvalMesh2(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glEvalMesh2;
        BufferChecks.checkFunctionAddress(j);
        nglEvalMesh2(i6, i7, i8, i9, i10, j);
    }

    public static void glEvalPoint1(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEvalPoint1;
        BufferChecks.checkFunctionAddress(j);
        nglEvalPoint1(i2, j);
    }

    public static void glEvalPoint2(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEvalPoint2;
        BufferChecks.checkFunctionAddress(j);
        nglEvalPoint2(i3, i4, j);
    }

    public static void glFeedbackBuffer(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glFeedbackBuffer;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglFeedbackBuffer(floatBuffer2.remaining(), i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glFinish() {
        long j = GLContext.getCapabilities().glFinish;
        BufferChecks.checkFunctionAddress(j);
        nglFinish(j);
    }

    public static void glFlush() {
        long j = GLContext.getCapabilities().glFlush;
        BufferChecks.checkFunctionAddress(j);
        nglFlush(j);
    }

    public static void glFog(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glFogfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglFogfv(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glFog(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glFogiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglFogiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glFogf(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glFogf;
        BufferChecks.checkFunctionAddress(j);
        nglFogf(i2, f2, j);
    }

    public static void glFogi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glFogi;
        BufferChecks.checkFunctionAddress(j);
        nglFogi(i3, i4, j);
    }

    public static void glFrontFace(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glFrontFace;
        BufferChecks.checkFunctionAddress(j);
        nglFrontFace(i2, j);
    }

    public static void glFrustum(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d;
        double d8 = d2;
        double d9 = d3;
        double d10 = d4;
        double d11 = d5;
        double d12 = d6;
        long j = GLContext.getCapabilities().glFrustum;
        BufferChecks.checkFunctionAddress(j);
        nglFrustum(d7, d8, d9, d10, d11, d12, j);
    }

    public static int glGenLists(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGenLists;
        BufferChecks.checkFunctionAddress(j);
        return nglGenLists(i2, j);
    }

    public static int glGenTextures() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenTextures;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenTextures(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenTextures(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenTextures;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenTextures(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetBoolean(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetBooleanv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 16);
        nglGetBooleanv(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static boolean glGetBoolean(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetBooleanv;
        BufferChecks.checkFunctionAddress(j);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, 1);
        nglGetBooleanv(i2, MemoryUtil.getAddress(bufferByte), j);
        return bufferByte.get(0) == 1;
    }

    public static void glGetClipPlane(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetClipPlane;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetClipPlane(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static double glGetDouble(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetDoublev;
        BufferChecks.checkFunctionAddress(j);
        DoubleBuffer bufferDouble = APIUtil.getBufferDouble(capabilities);
        nglGetDoublev(i2, MemoryUtil.getAddress(bufferDouble), j);
        return bufferDouble.get(0);
    }

    public static void glGetDouble(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetDoublev;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglGetDoublev(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static int glGetError() {
        long j = GLContext.getCapabilities().glGetError;
        BufferChecks.checkFunctionAddress(j);
        return nglGetError(j);
    }

    public static float glGetFloat(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFloatv;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetFloatv(i2, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static void glGetFloat(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetFloatv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglGetFloatv(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static int glGetInteger(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetIntegerv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetIntegerv(i2, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetInteger(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetIntegerv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 16);
        nglGetIntegerv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetLight(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetLightfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetLightfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetLight(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetLightiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetLightiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetMap(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetMapdv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 256);
        nglGetMapdv(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetMap(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMapfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 256);
        nglGetMapfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMap(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMapiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 256);
        nglGetMapiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetMaterial(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMaterialfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetMaterialfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMaterial(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMaterialiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMaterialiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetPixelMap(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPixelMapfv;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, 256);
        nglGetPixelMapfv(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetPixelMapfv(int i, long j) {
        int i2 = i;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetPixelMapfv;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetPixelMapfvBO(i2, j2, j3);
    }

    public static void glGetPixelMapu(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPixelMapuiv;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, 256);
        nglGetPixelMapuiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetPixelMapu(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPixelMapusv;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, 256);
        nglGetPixelMapusv(i2, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetPixelMapuiv(int i, long j) {
        int i2 = i;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetPixelMapuiv;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetPixelMapuivBO(i2, j2, j3);
    }

    public static void glGetPixelMapusv(int i, long j) {
        int i2 = i;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetPixelMapusv;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetPixelMapusvBO(i2, j2, j3);
    }

    public static ByteBuffer glGetPointer(int i, long j) {
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetPointerv;
        BufferChecks.checkFunctionAddress(j3);
        ByteBuffer nglGetPointerv = nglGetPointerv(i2, j2, j3);
        if (!LWJGLUtil.CHECKS || nglGetPointerv != null) {
            return nglGetPointerv.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glGetPolygonStipple(long j) {
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetPolygonStipple;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetPolygonStippleBO(j2, j3);
    }

    public static void glGetPolygonStipple(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPolygonStipple;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, 128);
        nglGetPolygonStipple(MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static String glGetString(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGetString;
        BufferChecks.checkFunctionAddress(j);
        return nglGetString(i2, j);
    }

    public static void glGetTexEnv(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetTexEnvfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetTexEnvfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTexEnv(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTexEnviv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTexEnviv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetTexEnvf(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexEnvfv;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetTexEnvfv(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetTexEnvi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexEnviv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTexEnviv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetTexGen(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetTexGendv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetTexGendv(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetTexGen(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetTexGenfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetTexGenfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTexGen(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTexGeniv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTexGeniv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static double glGetTexGend(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexGendv;
        BufferChecks.checkFunctionAddress(j);
        DoubleBuffer bufferDouble = APIUtil.getBufferDouble(capabilities);
        nglGetTexGendv(i3, i4, MemoryUtil.getAddress(bufferDouble), j);
        return bufferDouble.get(0);
    }

    public static float glGetTexGenf(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexGenfv;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetTexGenfv(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetTexGeni(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexGeniv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTexGeniv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetTexImage(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetTexImage;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetTexImageBO(i5, i6, i7, i8, j2, j3);
    }

    public static void glGetTexImage(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexImage;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i7, i8, 1, 1, 1));
        nglGetTexImage(i5, i6, i7, i8, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetTexImage(int i, int i2, int i3, int i4, DoubleBuffer doubleBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexImage;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i7, i8, 1, 1, 1));
        nglGetTexImage(i5, i6, i7, i8, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetTexImage(int i, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexImage;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i7, i8, 1, 1, 1));
        nglGetTexImage(i5, i6, i7, i8, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTexImage(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexImage;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i7, i8, 1, 1, 1));
        nglGetTexImage(i5, i6, i7, i8, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetTexImage(int i, int i2, int i3, int i4, ShortBuffer shortBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexImage;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i7, i8, 1, 1, 1));
        nglGetTexImage(i5, i6, i7, i8, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetTexLevelParameter(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetTexLevelParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetTexLevelParameterfv(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTexLevelParameter(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTexLevelParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTexLevelParameteriv(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetTexLevelParameterf(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexLevelParameterfv;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetTexLevelParameterfv(i4, i5, i6, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetTexLevelParameteri(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexLevelParameteriv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTexLevelParameteriv(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetTexParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetTexParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetTexParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTexParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTexParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTexParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetTexParameterf(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexParameterfv;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetTexParameterfv(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetTexParameteri(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexParameteriv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTexParameteriv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glHint(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glHint;
        BufferChecks.checkFunctionAddress(j);
        nglHint(i3, i4, j);
    }

    public static void glInitNames() {
        long j = GLContext.getCapabilities().glInitNames;
        BufferChecks.checkFunctionAddress(j);
        nglInitNames(j);
    }

    public static void glInterleavedArrays(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glInterleavedArrays;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglInterleavedArraysBO(i3, i4, j2, j3);
    }

    public static void glInterleavedArrays(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glInterleavedArrays;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglInterleavedArrays(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glInterleavedArrays(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glInterleavedArrays;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        nglInterleavedArrays(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glInterleavedArrays(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glInterleavedArrays;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglInterleavedArrays(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glInterleavedArrays(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glInterleavedArrays;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglInterleavedArrays(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glInterleavedArrays(int i, int i2, ShortBuffer shortBuffer) {
        int i3 = i;
        int i4 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glInterleavedArrays;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglInterleavedArrays(i3, i4, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static boolean glIsEnabled(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsEnabled;
        BufferChecks.checkFunctionAddress(j);
        return nglIsEnabled(i2, j);
    }

    public static boolean glIsList(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsList;
        BufferChecks.checkFunctionAddress(j);
        return nglIsList(i2, j);
    }

    public static boolean glIsTexture(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsTexture;
        BufferChecks.checkFunctionAddress(j);
        return nglIsTexture(i2, j);
    }

    public static void glLight(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glLightfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglLightfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glLight(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glLightiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglLightiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glLightModel(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glLightModelfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglLightModelfv(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glLightModel(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glLightModeliv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglLightModeliv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glLightModelf(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glLightModelf;
        BufferChecks.checkFunctionAddress(j);
        nglLightModelf(i2, f2, j);
    }

    public static void glLightModeli(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glLightModeli;
        BufferChecks.checkFunctionAddress(j);
        nglLightModeli(i3, i4, j);
    }

    public static void glLightf(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glLightf;
        BufferChecks.checkFunctionAddress(j);
        nglLightf(i3, i4, f2, j);
    }

    public static void glLighti(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glLighti;
        BufferChecks.checkFunctionAddress(j);
        nglLighti(i4, i5, i6, j);
    }

    public static void glLineStipple(int i, short s) {
        int i2 = i;
        short s2 = s;
        long j = GLContext.getCapabilities().glLineStipple;
        BufferChecks.checkFunctionAddress(j);
        nglLineStipple(i2, s2, j);
    }

    public static void glLineWidth(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glLineWidth;
        BufferChecks.checkFunctionAddress(j);
        nglLineWidth(f2, j);
    }

    public static void glListBase(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glListBase;
        BufferChecks.checkFunctionAddress(j);
        nglListBase(i2, j);
    }

    public static void glLoadIdentity() {
        long j = GLContext.getCapabilities().glLoadIdentity;
        BufferChecks.checkFunctionAddress(j);
        nglLoadIdentity(j);
    }

    public static void glLoadMatrix(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glLoadMatrixd;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglLoadMatrixd(MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glLoadMatrix(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glLoadMatrixf;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglLoadMatrixf(MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glLoadName(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glLoadName;
        BufferChecks.checkFunctionAddress(j);
        nglLoadName(i2, j);
    }

    public static void glLogicOp(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glLogicOp;
        BufferChecks.checkFunctionAddress(j);
        nglLogicOp(i2, j);
    }

    public static void glMap1d(int i, double d, double d2, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        double d3 = d;
        double d4 = d2;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMap1d;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglMap1d(i4, d3, d4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMap1f(int i, float f, float f2, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        float f3 = f;
        float f4 = f2;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMap1f;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglMap1f(i4, f3, f4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMap2d(int i, double d, double d2, int i2, int i3, double d3, double d4, int i4, int i5, DoubleBuffer doubleBuffer) {
        int i6 = i;
        double d5 = d;
        double d6 = d2;
        int i7 = i2;
        int i8 = i3;
        double d7 = d3;
        double d8 = d4;
        int i9 = i4;
        int i10 = i5;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMap2d;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglMap2d(i6, d5, d6, i7, i8, d7, d8, i9, i10, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMap2f(int i, float f, float f2, int i2, int i3, float f3, float f4, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        float f5 = f;
        float f6 = f2;
        int i7 = i2;
        int i8 = i3;
        float f7 = f3;
        float f8 = f4;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMap2f;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglMap2f(i6, f5, f6, i7, i8, f7, f8, i9, i10, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMapGrid1d(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glMapGrid1d;
        BufferChecks.checkFunctionAddress(j);
        nglMapGrid1d(i2, d3, d4, j);
    }

    public static void glMapGrid1f(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glMapGrid1f;
        BufferChecks.checkFunctionAddress(j);
        nglMapGrid1f(i2, f3, f4, j);
    }

    public static void glMapGrid2d(int i, double d, double d2, int i2, double d3, double d4) {
        int i3 = i;
        double d5 = d;
        double d6 = d2;
        int i4 = i2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glMapGrid2d;
        BufferChecks.checkFunctionAddress(j);
        nglMapGrid2d(i3, d5, d6, i4, d7, d8, j);
    }

    public static void glMapGrid2f(int i, float f, float f2, int i2, float f3, float f4) {
        int i3 = i;
        float f5 = f;
        float f6 = f2;
        int i4 = i2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glMapGrid2f;
        BufferChecks.checkFunctionAddress(j);
        nglMapGrid2f(i3, f5, f6, i4, f7, f8, j);
    }

    public static void glMaterial(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMaterialfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglMaterialfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMaterial(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMaterialiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglMaterialiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMaterialf(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glMaterialf;
        BufferChecks.checkFunctionAddress(j);
        nglMaterialf(i3, i4, f2, j);
    }

    public static void glMateriali(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glMateriali;
        BufferChecks.checkFunctionAddress(j);
        nglMateriali(i4, i5, i6, j);
    }

    public static void glMatrixMode(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glMatrixMode;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixMode(i2, j);
    }

    public static void glMultMatrix(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMultMatrixd;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglMultMatrixd(MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMultMatrix(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMultMatrixf;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglMultMatrixf(MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glNewList(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNewList;
        BufferChecks.checkFunctionAddress(j);
        nglNewList(i3, i4, j);
    }

    public static void glNormal3b(byte b, byte b2, byte b3) {
        byte b4 = b;
        byte b5 = b2;
        byte b6 = b3;
        long j = GLContext.getCapabilities().glNormal3b;
        BufferChecks.checkFunctionAddress(j);
        nglNormal3b(b4, b5, b6, j);
    }

    public static void glNormal3d(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glNormal3d;
        BufferChecks.checkFunctionAddress(j);
        nglNormal3d(d4, d5, d6, j);
    }

    public static void glNormal3f(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glNormal3f;
        BufferChecks.checkFunctionAddress(j);
        nglNormal3f(f4, f5, f6, j);
    }

    public static void glNormal3i(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glNormal3i;
        BufferChecks.checkFunctionAddress(j);
        nglNormal3i(i4, i5, i6, j);
    }

    public static void glNormalPointer(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glNormalPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglNormalPointerBO(i3, i4, j2, j3);
    }

    public static void glNormalPointer(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glNormalPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glNormalPointer_pointer = byteBuffer2;
        }
        nglNormalPointer(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glNormalPointer(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glNormalPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glNormalPointer_pointer = byteBuffer2;
        }
        nglNormalPointer(GL_BYTE, i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glNormalPointer(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glNormalPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glNormalPointer_pointer = doubleBuffer2;
        }
        nglNormalPointer(5130, i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glNormalPointer(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glNormalPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glNormalPointer_pointer = floatBuffer2;
        }
        nglNormalPointer(GL_FLOAT, i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glNormalPointer(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glNormalPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glNormalPointer_pointer = intBuffer2;
        }
        nglNormalPointer(GL_INT, i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glOrtho(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d;
        double d8 = d2;
        double d9 = d3;
        double d10 = d4;
        double d11 = d5;
        double d12 = d6;
        long j = GLContext.getCapabilities().glOrtho;
        BufferChecks.checkFunctionAddress(j);
        nglOrtho(d7, d8, d9, d10, d11, d12, j);
    }

    public static void glPassThrough(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glPassThrough;
        BufferChecks.checkFunctionAddress(j);
        nglPassThrough(f2, j);
    }

    public static void glPixelMap(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glPixelMapfv;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglPixelMapfv(i2, floatBuffer2.remaining(), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glPixelMapfv(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glPixelMapfv;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglPixelMapfvBO(i3, i4, j2, j3);
    }

    public static void glPixelMapu(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glPixelMapuiv;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglPixelMapuiv(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glPixelMapu(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glPixelMapusv;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglPixelMapusv(i2, shortBuffer2.remaining(), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glPixelMapuiv(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glPixelMapuiv;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglPixelMapuivBO(i3, i4, j2, j3);
    }

    public static void glPixelMapusv(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glPixelMapusv;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglPixelMapusvBO(i3, i4, j2, j3);
    }

    public static void glPixelStoref(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glPixelStoref;
        BufferChecks.checkFunctionAddress(j);
        nglPixelStoref(i2, f2, j);
    }

    public static void glPixelStorei(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glPixelStorei;
        BufferChecks.checkFunctionAddress(j);
        nglPixelStorei(i3, i4, j);
    }

    public static void glPixelTransferf(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glPixelTransferf;
        BufferChecks.checkFunctionAddress(j);
        nglPixelTransferf(i2, f2, j);
    }

    public static void glPixelTransferi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glPixelTransferi;
        BufferChecks.checkFunctionAddress(j);
        nglPixelTransferi(i3, i4, j);
    }

    public static void glPixelZoom(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glPixelZoom;
        BufferChecks.checkFunctionAddress(j);
        nglPixelZoom(f3, f4, j);
    }

    public static void glPointSize(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glPointSize;
        BufferChecks.checkFunctionAddress(j);
        nglPointSize(f2, j);
    }

    public static void glPolygonMode(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glPolygonMode;
        BufferChecks.checkFunctionAddress(j);
        nglPolygonMode(i3, i4, j);
    }

    public static void glPolygonOffset(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glPolygonOffset;
        BufferChecks.checkFunctionAddress(j);
        nglPolygonOffset(f3, f4, j);
    }

    public static void glPolygonStipple(long j) {
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glPolygonStipple;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglPolygonStippleBO(j2, j3);
    }

    public static void glPolygonStipple(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glPolygonStipple;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, 128);
        nglPolygonStipple(MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glPopAttrib() {
        long j = GLContext.getCapabilities().glPopAttrib;
        BufferChecks.checkFunctionAddress(j);
        nglPopAttrib(j);
    }

    public static void glPopClientAttrib() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glPopClientAttrib;
        BufferChecks.checkFunctionAddress(j);
        StateTracker.popAttrib(capabilities);
        nglPopClientAttrib(j);
    }

    public static void glPopMatrix() {
        long j = GLContext.getCapabilities().glPopMatrix;
        BufferChecks.checkFunctionAddress(j);
        nglPopMatrix(j);
    }

    public static void glPopName() {
        long j = GLContext.getCapabilities().glPopName;
        BufferChecks.checkFunctionAddress(j);
        nglPopName(j);
    }

    public static void glPrioritizeTextures(IntBuffer intBuffer, FloatBuffer floatBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glPrioritizeTextures;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkBuffer(floatBuffer2, intBuffer2.remaining());
        nglPrioritizeTextures(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glPushAttrib(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glPushAttrib;
        BufferChecks.checkFunctionAddress(j);
        nglPushAttrib(i2, j);
    }

    public static void glPushClientAttrib(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glPushClientAttrib;
        BufferChecks.checkFunctionAddress(j);
        StateTracker.pushAttrib(capabilities, i2);
        nglPushClientAttrib(i2, j);
    }

    public static void glPushMatrix() {
        long j = GLContext.getCapabilities().glPushMatrix;
        BufferChecks.checkFunctionAddress(j);
        nglPushMatrix(j);
    }

    public static void glPushName(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glPushName;
        BufferChecks.checkFunctionAddress(j);
        nglPushName(i2, j);
    }

    public static void glRasterPos2d(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glRasterPos2d;
        BufferChecks.checkFunctionAddress(j);
        nglRasterPos2d(d3, d4, j);
    }

    public static void glRasterPos2f(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glRasterPos2f;
        BufferChecks.checkFunctionAddress(j);
        nglRasterPos2f(f3, f4, j);
    }

    public static void glRasterPos2i(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glRasterPos2i;
        BufferChecks.checkFunctionAddress(j);
        nglRasterPos2i(i3, i4, j);
    }

    public static void glRasterPos3d(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glRasterPos3d;
        BufferChecks.checkFunctionAddress(j);
        nglRasterPos3d(d4, d5, d6, j);
    }

    public static void glRasterPos3f(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glRasterPos3f;
        BufferChecks.checkFunctionAddress(j);
        nglRasterPos3f(f4, f5, f6, j);
    }

    public static void glRasterPos3i(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glRasterPos3i;
        BufferChecks.checkFunctionAddress(j);
        nglRasterPos3i(i4, i5, i6, j);
    }

    public static void glRasterPos4d(double d, double d2, double d3, double d4) {
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glRasterPos4d;
        BufferChecks.checkFunctionAddress(j);
        nglRasterPos4d(d5, d6, d7, d8, j);
    }

    public static void glRasterPos4f(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glRasterPos4f;
        BufferChecks.checkFunctionAddress(j);
        nglRasterPos4f(f5, f6, f7, f8, j);
    }

    public static void glRasterPos4i(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glRasterPos4i;
        BufferChecks.checkFunctionAddress(j);
        nglRasterPos4i(i5, i6, i7, i8, j);
    }

    public static void glReadBuffer(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glReadBuffer;
        BufferChecks.checkFunctionAddress(j);
        nglReadBuffer(i2, j);
    }

    public static void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glReadPixels;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglReadPixelsBO(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadPixels;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i11, i12, i9, i10, 1));
        nglReadPixels(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, DoubleBuffer doubleBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadPixels;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i11, i12, i9, i10, 1));
        nglReadPixels(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, FloatBuffer floatBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadPixels;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i11, i12, i9, i10, 1));
        nglReadPixels(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, IntBuffer intBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadPixels;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i11, i12, i9, i10, 1));
        nglReadPixels(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, ShortBuffer shortBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadPixels;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i11, i12, i9, i10, 1));
        nglReadPixels(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glRectd(double d, double d2, double d3, double d4) {
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glRectd;
        BufferChecks.checkFunctionAddress(j);
        nglRectd(d5, d6, d7, d8, j);
    }

    public static void glRectf(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glRectf;
        BufferChecks.checkFunctionAddress(j);
        nglRectf(f5, f6, f7, f8, j);
    }

    public static void glRecti(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glRecti;
        BufferChecks.checkFunctionAddress(j);
        nglRecti(i5, i6, i7, i8, j);
    }

    public static int glRenderMode(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glRenderMode;
        BufferChecks.checkFunctionAddress(j);
        return nglRenderMode(i2, j);
    }

    public static void glRotated(double d, double d2, double d3, double d4) {
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glRotated;
        BufferChecks.checkFunctionAddress(j);
        nglRotated(d5, d6, d7, d8, j);
    }

    public static void glRotatef(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glRotatef;
        BufferChecks.checkFunctionAddress(j);
        nglRotatef(f5, f6, f7, f8, j);
    }

    public static void glScaled(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glScaled;
        BufferChecks.checkFunctionAddress(j);
        nglScaled(d4, d5, d6, j);
    }

    public static void glScalef(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glScalef;
        BufferChecks.checkFunctionAddress(j);
        nglScalef(f4, f5, f6, j);
    }

    public static void glScissor(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glScissor;
        BufferChecks.checkFunctionAddress(j);
        nglScissor(i5, i6, i7, i8, j);
    }

    public static void glSelectBuffer(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glSelectBuffer;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglSelectBuffer(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glShadeModel(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glShadeModel;
        BufferChecks.checkFunctionAddress(j);
        nglShadeModel(i2, j);
    }

    public static void glStencilFunc(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glStencilFunc;
        BufferChecks.checkFunctionAddress(j);
        nglStencilFunc(i4, i5, i6, j);
    }

    public static void glStencilMask(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glStencilMask;
        BufferChecks.checkFunctionAddress(j);
        nglStencilMask(i2, j);
    }

    public static void glStencilOp(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glStencilOp;
        BufferChecks.checkFunctionAddress(j);
        nglStencilOp(i4, i5, i6, j);
    }

    public static void glTexCoord1d(double d) {
        double d2 = d;
        long j = GLContext.getCapabilities().glTexCoord1d;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord1d(d2, j);
    }

    public static void glTexCoord1f(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glTexCoord1f;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord1f(f2, j);
    }

    public static void glTexCoord2d(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glTexCoord2d;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord2d(d3, d4, j);
    }

    public static void glTexCoord2f(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glTexCoord2f;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord2f(f3, f4, j);
    }

    public static void glTexCoord3d(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glTexCoord3d;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord3d(d4, d5, d6, j);
    }

    public static void glTexCoord3f(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glTexCoord3f;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord3f(f4, f5, f6, j);
    }

    public static void glTexCoord4d(double d, double d2, double d3, double d4) {
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glTexCoord4d;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord4d(d5, d6, d7, d8, j);
    }

    public static void glTexCoord4f(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glTexCoord4f;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord4f(f5, f6, f7, f8, j);
    }

    public static void glTexCoordPointer(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glTexCoordPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglTexCoordPointerBO(i4, i5, i6, j2, j3);
    }

    public static void glTexCoordPointer(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexCoordPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glTexCoordPointer_buffer[StateTracker.getReferences(capabilities).glClientActiveTexture] = byteBuffer2;
        }
        nglTexCoordPointer(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glTexCoordPointer(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexCoordPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glTexCoordPointer_buffer[StateTracker.getReferences(capabilities).glClientActiveTexture] = doubleBuffer2;
        }
        nglTexCoordPointer(i3, 5130, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glTexCoordPointer(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexCoordPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glTexCoordPointer_buffer[StateTracker.getReferences(capabilities).glClientActiveTexture] = floatBuffer2;
        }
        nglTexCoordPointer(i3, GL_FLOAT, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTexCoordPointer(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexCoordPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glTexCoordPointer_buffer[StateTracker.getReferences(capabilities).glClientActiveTexture] = intBuffer2;
        }
        nglTexCoordPointer(i3, GL_INT, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexCoordPointer(int i, int i2, ShortBuffer shortBuffer) {
        int i3 = i;
        int i4 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexCoordPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glTexCoordPointer_buffer[StateTracker.getReferences(capabilities).glClientActiveTexture] = shortBuffer2;
        }
        nglTexCoordPointer(i3, GL_SHORT, i4, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glTexEnv(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glTexEnvfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglTexEnvfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTexEnv(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexEnviv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTexEnviv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexEnvf(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glTexEnvf;
        BufferChecks.checkFunctionAddress(j);
        nglTexEnvf(i3, i4, f2, j);
    }

    public static void glTexEnvi(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTexEnvi;
        BufferChecks.checkFunctionAddress(j);
        nglTexEnvi(i4, i5, i6, j);
    }

    public static void glTexGen(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glTexGendv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglTexGendv(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glTexGen(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glTexGenfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglTexGenfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTexGen(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexGeniv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTexGeniv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexGend(int i, int i2, double d) {
        int i3 = i;
        int i4 = i2;
        double d2 = d;
        long j = GLContext.getCapabilities().glTexGend;
        BufferChecks.checkFunctionAddress(j);
        nglTexGend(i3, i4, d2, j);
    }

    public static void glTexGenf(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glTexGenf;
        BufferChecks.checkFunctionAddress(j);
        nglTexGenf(i3, i4, f2, j);
    }

    public static void glTexGeni(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTexGeni;
        BufferChecks.checkFunctionAddress(j);
        nglTexGeni(i4, i5, i6, j);
    }

    public static void glTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glTexImage1D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTexImage1DBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateTexImage1DStorage(byteBuffer2, i13, i14, i11));
        }
        nglTexImage1D(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, int i7, DoubleBuffer doubleBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateTexImage1DStorage(doubleBuffer2, i13, i14, i11));
        }
        nglTexImage1D(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, int i7, FloatBuffer floatBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTexImage1DStorage(floatBuffer2, i13, i14, i11));
        }
        nglTexImage1D(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, int i7, IntBuffer intBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateTexImage1DStorage(intBuffer2, i13, i14, i11));
        }
        nglTexImage1D(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, int i7, ShortBuffer shortBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateTexImage1DStorage(shortBuffer2, i13, i14, i11));
        }
        nglTexImage1D(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glTexImage2D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTexImage2DBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ByteBuffer byteBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateTexImage2DStorage(byteBuffer2, i15, i16, i12, i13));
        }
        nglTexImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, DoubleBuffer doubleBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateTexImage2DStorage(doubleBuffer2, i15, i16, i12, i13));
        }
        nglTexImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, FloatBuffer floatBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTexImage2DStorage(floatBuffer2, i15, i16, i12, i13));
        }
        nglTexImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, IntBuffer intBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateTexImage2DStorage(intBuffer2, i15, i16, i12, i13));
        }
        nglTexImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ShortBuffer shortBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateTexImage2DStorage(shortBuffer2, i15, i16, i12, i13));
        }
        nglTexImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glTexParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glTexParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglTexParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTexParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTexParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexParameterf(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glTexParameterf;
        BufferChecks.checkFunctionAddress(j);
        nglTexParameterf(i3, i4, f2, j);
    }

    public static void glTexParameteri(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTexParameteri;
        BufferChecks.checkFunctionAddress(j);
        nglTexParameteri(i4, i5, i6, j);
    }

    public static void glTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glTexSubImage1D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTexSubImage1DBO(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i11, i12, i10, 1, 1));
        nglTexSubImage1D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, DoubleBuffer doubleBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i11, i12, i10, 1, 1));
        nglTexSubImage1D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, FloatBuffer floatBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i11, i12, i10, 1, 1));
        nglTexSubImage1D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, IntBuffer intBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i11, i12, i10, 1, 1));
        nglTexSubImage1D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, ShortBuffer shortBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i11, i12, i10, 1, 1));
        nglTexSubImage1D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glTexSubImage2D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTexSubImage2DBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ByteBuffer byteBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i15, i16, i13, i14, 1));
        nglTexSubImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, DoubleBuffer doubleBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i15, i16, i13, i14, 1));
        nglTexSubImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, FloatBuffer floatBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i15, i16, i13, i14, 1));
        nglTexSubImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, IntBuffer intBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i15, i16, i13, i14, 1));
        nglTexSubImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ShortBuffer shortBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexSubImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i15, i16, i13, i14, 1));
        nglTexSubImage2D(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glTranslated(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glTranslated;
        BufferChecks.checkFunctionAddress(j);
        nglTranslated(d4, d5, d6, j);
    }

    public static void glTranslatef(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glTranslatef;
        BufferChecks.checkFunctionAddress(j);
        nglTranslatef(f4, f5, f6, j);
    }

    public static void glVertex2d(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glVertex2d;
        BufferChecks.checkFunctionAddress(j);
        nglVertex2d(d3, d4, j);
    }

    public static void glVertex2f(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glVertex2f;
        BufferChecks.checkFunctionAddress(j);
        nglVertex2f(f3, f4, j);
    }

    public static void glVertex2i(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertex2i;
        BufferChecks.checkFunctionAddress(j);
        nglVertex2i(i3, i4, j);
    }

    public static void glVertex3d(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glVertex3d;
        BufferChecks.checkFunctionAddress(j);
        nglVertex3d(d4, d5, d6, j);
    }

    public static void glVertex3f(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glVertex3f;
        BufferChecks.checkFunctionAddress(j);
        nglVertex3f(f4, f5, f6, j);
    }

    public static void glVertex3i(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertex3i;
        BufferChecks.checkFunctionAddress(j);
        nglVertex3i(i4, i5, i6, j);
    }

    public static void glVertex4d(double d, double d2, double d3, double d4) {
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glVertex4d;
        BufferChecks.checkFunctionAddress(j);
        nglVertex4d(d5, d6, d7, d8, j);
    }

    public static void glVertex4f(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glVertex4f;
        BufferChecks.checkFunctionAddress(j);
        nglVertex4f(f5, f6, f7, f8, j);
    }

    public static void glVertex4i(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertex4i;
        BufferChecks.checkFunctionAddress(j);
        nglVertex4i(i5, i6, i7, i8, j);
    }

    public static void glVertexPointer(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVertexPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVertexPointerBO(i4, i5, i6, j2, j3);
    }

    public static void glVertexPointer(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glVertexPointer_pointer = byteBuffer2;
        }
        nglVertexPointer(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexPointer(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glVertexPointer_pointer = doubleBuffer2;
        }
        nglVertexPointer(i3, 5130, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexPointer(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glVertexPointer_pointer = floatBuffer2;
        }
        nglVertexPointer(i3, GL_FLOAT, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexPointer(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glVertexPointer_pointer = intBuffer2;
        }
        nglVertexPointer(i3, GL_INT, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexPointer(int i, int i2, ShortBuffer shortBuffer) {
        int i3 = i;
        int i4 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL11_glVertexPointer_pointer = shortBuffer2;
        }
        nglVertexPointer(i3, GL_SHORT, i4, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glViewport(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glViewport;
        BufferChecks.checkFunctionAddress(j);
        nglViewport(i5, i6, i7, i8, j);
    }

    static native void nglAccum(int i, float f, long j);

    static native void nglAlphaFunc(int i, float f, long j);

    static native boolean nglAreTexturesResident(int i, long j, long j2, long j3);

    static native void nglArrayElement(int i, long j);

    static native void nglBegin(int i, long j);

    static native void nglBindTexture(int i, int i2, long j);

    static native void nglBitmap(int i, int i2, float f, float f2, float f3, float f4, long j, long j2);

    static native void nglBitmapBO(int i, int i2, float f, float f2, float f3, float f4, long j, long j2);

    static native void nglBlendFunc(int i, int i2, long j);

    static native void nglCallList(int i, long j);

    static native void nglCallLists(int i, int i2, long j, long j2);

    static native void nglClear(int i, long j);

    static native void nglClearAccum(float f, float f2, float f3, float f4, long j);

    static native void nglClearColor(float f, float f2, float f3, float f4, long j);

    static native void nglClearDepth(double d, long j);

    static native void nglClearStencil(int i, long j);

    static native void nglClipPlane(int i, long j, long j2);

    static native void nglColor3b(byte b, byte b2, byte b3, long j);

    static native void nglColor3d(double d, double d2, double d3, long j);

    static native void nglColor3f(float f, float f2, float f3, long j);

    static native void nglColor3ub(byte b, byte b2, byte b3, long j);

    static native void nglColor4b(byte b, byte b2, byte b3, byte b4, long j);

    static native void nglColor4d(double d, double d2, double d3, double d4, long j);

    static native void nglColor4f(float f, float f2, float f3, float f4, long j);

    static native void nglColor4ub(byte b, byte b2, byte b3, byte b4, long j);

    static native void nglColorMask(boolean z, boolean z2, boolean z3, boolean z4, long j);

    static native void nglColorMaterial(int i, int i2, long j);

    static native void nglColorPointer(int i, int i2, int i3, long j, long j2);

    static native void nglColorPointerBO(int i, int i2, int i3, long j, long j2);

    static native void nglCopyPixels(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglCopyTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);

    static native void nglCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    static native void nglCopyTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    static native void nglCullFace(int i, long j);

    static native void nglDeleteLists(int i, int i2, long j);

    static native void nglDeleteTextures(int i, long j, long j2);

    static native void nglDepthFunc(int i, long j);

    static native void nglDepthMask(boolean z, long j);

    static native void nglDepthRange(double d, double d2, long j);

    static native void nglDisable(int i, long j);

    static native void nglDisableClientState(int i, long j);

    static native void nglDrawArrays(int i, int i2, int i3, long j);

    static native void nglDrawBuffer(int i, long j);

    static native void nglDrawElements(int i, int i2, int i3, long j, long j2);

    static native void nglDrawElementsBO(int i, int i2, int i3, long j, long j2);

    static native void nglDrawPixels(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglDrawPixelsBO(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglEdgeFlag(boolean z, long j);

    static native void nglEdgeFlagPointer(int i, long j, long j2);

    static native void nglEdgeFlagPointerBO(int i, long j, long j2);

    static native void nglEnable(int i, long j);

    static native void nglEnableClientState(int i, long j);

    static native void nglEnd(long j);

    static native void nglEndList(long j);

    static native void nglEvalCoord1d(double d, long j);

    static native void nglEvalCoord1f(float f, long j);

    static native void nglEvalCoord2d(double d, double d2, long j);

    static native void nglEvalCoord2f(float f, float f2, long j);

    static native void nglEvalMesh1(int i, int i2, int i3, long j);

    static native void nglEvalMesh2(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglEvalPoint1(int i, long j);

    static native void nglEvalPoint2(int i, int i2, long j);

    static native void nglFeedbackBuffer(int i, int i2, long j, long j2);

    static native void nglFinish(long j);

    static native void nglFlush(long j);

    static native void nglFogf(int i, float f, long j);

    static native void nglFogfv(int i, long j, long j2);

    static native void nglFogi(int i, int i2, long j);

    static native void nglFogiv(int i, long j, long j2);

    static native void nglFrontFace(int i, long j);

    static native void nglFrustum(double d, double d2, double d3, double d4, double d5, double d6, long j);

    static native int nglGenLists(int i, long j);

    static native void nglGenTextures(int i, long j, long j2);

    static native void nglGetBooleanv(int i, long j, long j2);

    static native void nglGetClipPlane(int i, long j, long j2);

    static native void nglGetDoublev(int i, long j, long j2);

    static native int nglGetError(long j);

    static native void nglGetFloatv(int i, long j, long j2);

    static native void nglGetIntegerv(int i, long j, long j2);

    static native void nglGetLightfv(int i, int i2, long j, long j2);

    static native void nglGetLightiv(int i, int i2, long j, long j2);

    static native void nglGetMapdv(int i, int i2, long j, long j2);

    static native void nglGetMapfv(int i, int i2, long j, long j2);

    static native void nglGetMapiv(int i, int i2, long j, long j2);

    static native void nglGetMaterialfv(int i, int i2, long j, long j2);

    static native void nglGetMaterialiv(int i, int i2, long j, long j2);

    static native void nglGetPixelMapfv(int i, long j, long j2);

    static native void nglGetPixelMapfvBO(int i, long j, long j2);

    static native void nglGetPixelMapuiv(int i, long j, long j2);

    static native void nglGetPixelMapuivBO(int i, long j, long j2);

    static native void nglGetPixelMapusv(int i, long j, long j2);

    static native void nglGetPixelMapusvBO(int i, long j, long j2);

    static native ByteBuffer nglGetPointerv(int i, long j, long j2);

    static native void nglGetPolygonStipple(long j, long j2);

    static native void nglGetPolygonStippleBO(long j, long j2);

    static native String nglGetString(int i, long j);

    static native void nglGetTexEnvfv(int i, int i2, long j, long j2);

    static native void nglGetTexEnviv(int i, int i2, long j, long j2);

    static native void nglGetTexGendv(int i, int i2, long j, long j2);

    static native void nglGetTexGenfv(int i, int i2, long j, long j2);

    static native void nglGetTexGeniv(int i, int i2, long j, long j2);

    static native void nglGetTexImage(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetTexImageBO(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetTexLevelParameterfv(int i, int i2, int i3, long j, long j2);

    static native void nglGetTexLevelParameteriv(int i, int i2, int i3, long j, long j2);

    static native void nglGetTexParameterfv(int i, int i2, long j, long j2);

    static native void nglGetTexParameteriv(int i, int i2, long j, long j2);

    static native void nglHint(int i, int i2, long j);

    static native void nglInitNames(long j);

    static native void nglInterleavedArrays(int i, int i2, long j, long j2);

    static native void nglInterleavedArraysBO(int i, int i2, long j, long j2);

    static native boolean nglIsEnabled(int i, long j);

    static native boolean nglIsList(int i, long j);

    static native boolean nglIsTexture(int i, long j);

    static native void nglLightModelf(int i, float f, long j);

    static native void nglLightModelfv(int i, long j, long j2);

    static native void nglLightModeli(int i, int i2, long j);

    static native void nglLightModeliv(int i, long j, long j2);

    static native void nglLightf(int i, int i2, float f, long j);

    static native void nglLightfv(int i, int i2, long j, long j2);

    static native void nglLighti(int i, int i2, int i3, long j);

    static native void nglLightiv(int i, int i2, long j, long j2);

    static native void nglLineStipple(int i, short s, long j);

    static native void nglLineWidth(float f, long j);

    static native void nglListBase(int i, long j);

    static native void nglLoadIdentity(long j);

    static native void nglLoadMatrixd(long j, long j2);

    static native void nglLoadMatrixf(long j, long j2);

    static native void nglLoadName(int i, long j);

    static native void nglLogicOp(int i, long j);

    static native void nglMap1d(int i, double d, double d2, int i2, int i3, long j, long j2);

    static native void nglMap1f(int i, float f, float f2, int i2, int i3, long j, long j2);

    static native void nglMap2d(int i, double d, double d2, int i2, int i3, double d3, double d4, int i4, int i5, long j, long j2);

    static native void nglMap2f(int i, float f, float f2, int i2, int i3, float f3, float f4, int i4, int i5, long j, long j2);

    static native void nglMapGrid1d(int i, double d, double d2, long j);

    static native void nglMapGrid1f(int i, float f, float f2, long j);

    static native void nglMapGrid2d(int i, double d, double d2, int i2, double d3, double d4, long j);

    static native void nglMapGrid2f(int i, float f, float f2, int i2, float f3, float f4, long j);

    static native void nglMaterialf(int i, int i2, float f, long j);

    static native void nglMaterialfv(int i, int i2, long j, long j2);

    static native void nglMateriali(int i, int i2, int i3, long j);

    static native void nglMaterialiv(int i, int i2, long j, long j2);

    static native void nglMatrixMode(int i, long j);

    static native void nglMultMatrixd(long j, long j2);

    static native void nglMultMatrixf(long j, long j2);

    static native void nglNewList(int i, int i2, long j);

    static native void nglNormal3b(byte b, byte b2, byte b3, long j);

    static native void nglNormal3d(double d, double d2, double d3, long j);

    static native void nglNormal3f(float f, float f2, float f3, long j);

    static native void nglNormal3i(int i, int i2, int i3, long j);

    static native void nglNormalPointer(int i, int i2, long j, long j2);

    static native void nglNormalPointerBO(int i, int i2, long j, long j2);

    static native void nglOrtho(double d, double d2, double d3, double d4, double d5, double d6, long j);

    static native void nglPassThrough(float f, long j);

    static native void nglPixelMapfv(int i, int i2, long j, long j2);

    static native void nglPixelMapfvBO(int i, int i2, long j, long j2);

    static native void nglPixelMapuiv(int i, int i2, long j, long j2);

    static native void nglPixelMapuivBO(int i, int i2, long j, long j2);

    static native void nglPixelMapusv(int i, int i2, long j, long j2);

    static native void nglPixelMapusvBO(int i, int i2, long j, long j2);

    static native void nglPixelStoref(int i, float f, long j);

    static native void nglPixelStorei(int i, int i2, long j);

    static native void nglPixelTransferf(int i, float f, long j);

    static native void nglPixelTransferi(int i, int i2, long j);

    static native void nglPixelZoom(float f, float f2, long j);

    static native void nglPointSize(float f, long j);

    static native void nglPolygonMode(int i, int i2, long j);

    static native void nglPolygonOffset(float f, float f2, long j);

    static native void nglPolygonStipple(long j, long j2);

    static native void nglPolygonStippleBO(long j, long j2);

    static native void nglPopAttrib(long j);

    static native void nglPopClientAttrib(long j);

    static native void nglPopMatrix(long j);

    static native void nglPopName(long j);

    static native void nglPrioritizeTextures(int i, long j, long j2, long j3);

    static native void nglPushAttrib(int i, long j);

    static native void nglPushClientAttrib(int i, long j);

    static native void nglPushMatrix(long j);

    static native void nglPushName(int i, long j);

    static native void nglRasterPos2d(double d, double d2, long j);

    static native void nglRasterPos2f(float f, float f2, long j);

    static native void nglRasterPos2i(int i, int i2, long j);

    static native void nglRasterPos3d(double d, double d2, double d3, long j);

    static native void nglRasterPos3f(float f, float f2, float f3, long j);

    static native void nglRasterPos3i(int i, int i2, int i3, long j);

    static native void nglRasterPos4d(double d, double d2, double d3, double d4, long j);

    static native void nglRasterPos4f(float f, float f2, float f3, float f4, long j);

    static native void nglRasterPos4i(int i, int i2, int i3, int i4, long j);

    static native void nglReadBuffer(int i, long j);

    static native void nglReadPixels(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglReadPixelsBO(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglRectd(double d, double d2, double d3, double d4, long j);

    static native void nglRectf(float f, float f2, float f3, float f4, long j);

    static native void nglRecti(int i, int i2, int i3, int i4, long j);

    static native int nglRenderMode(int i, long j);

    static native void nglRotated(double d, double d2, double d3, double d4, long j);

    static native void nglRotatef(float f, float f2, float f3, float f4, long j);

    static native void nglScaled(double d, double d2, double d3, long j);

    static native void nglScalef(float f, float f2, float f3, long j);

    static native void nglScissor(int i, int i2, int i3, int i4, long j);

    static native void nglSelectBuffer(int i, long j, long j2);

    static native void nglShadeModel(int i, long j);

    static native void nglStencilFunc(int i, int i2, int i3, long j);

    static native void nglStencilMask(int i, long j);

    static native void nglStencilOp(int i, int i2, int i3, long j);

    static native void nglTexCoord1d(double d, long j);

    static native void nglTexCoord1f(float f, long j);

    static native void nglTexCoord2d(double d, double d2, long j);

    static native void nglTexCoord2f(float f, float f2, long j);

    static native void nglTexCoord3d(double d, double d2, double d3, long j);

    static native void nglTexCoord3f(float f, float f2, float f3, long j);

    static native void nglTexCoord4d(double d, double d2, double d3, double d4, long j);

    static native void nglTexCoord4f(float f, float f2, float f3, float f4, long j);

    static native void nglTexCoordPointer(int i, int i2, int i3, long j, long j2);

    static native void nglTexCoordPointerBO(int i, int i2, int i3, long j, long j2);

    static native void nglTexEnvf(int i, int i2, float f, long j);

    static native void nglTexEnvfv(int i, int i2, long j, long j2);

    static native void nglTexEnvi(int i, int i2, int i3, long j);

    static native void nglTexEnviv(int i, int i2, long j, long j2);

    static native void nglTexGend(int i, int i2, double d, long j);

    static native void nglTexGendv(int i, int i2, long j, long j2);

    static native void nglTexGenf(int i, int i2, float f, long j);

    static native void nglTexGenfv(int i, int i2, long j, long j2);

    static native void nglTexGeni(int i, int i2, int i3, long j);

    static native void nglTexGeniv(int i, int i2, long j, long j2);

    static native void nglTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglTexImage1DBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglTexImage2DBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglTexParameterf(int i, int i2, float f, long j);

    static native void nglTexParameterfv(int i, int i2, long j, long j2);

    static native void nglTexParameteri(int i, int i2, int i3, long j);

    static native void nglTexParameteriv(int i, int i2, long j, long j2);

    static native void nglTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglTexSubImage1DBO(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglTexSubImage2DBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglTranslated(double d, double d2, double d3, long j);

    static native void nglTranslatef(float f, float f2, float f3, long j);

    static native void nglVertex2d(double d, double d2, long j);

    static native void nglVertex2f(float f, float f2, long j);

    static native void nglVertex2i(int i, int i2, long j);

    static native void nglVertex3d(double d, double d2, double d3, long j);

    static native void nglVertex3f(float f, float f2, float f3, long j);

    static native void nglVertex3i(int i, int i2, int i3, long j);

    static native void nglVertex4d(double d, double d2, double d3, double d4, long j);

    static native void nglVertex4f(float f, float f2, float f3, float f4, long j);

    static native void nglVertex4i(int i, int i2, int i3, int i4, long j);

    static native void nglVertexPointer(int i, int i2, int i3, long j, long j2);

    static native void nglVertexPointerBO(int i, int i2, int i3, long j, long j2);

    static native void nglViewport(int i, int i2, int i3, int i4, long j);
}

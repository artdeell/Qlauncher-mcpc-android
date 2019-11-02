package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rops */
public final class Rops {
    public static final Rop ADD_CONST_DOUBLE;
    public static final Rop ADD_CONST_FLOAT;
    public static final Rop ADD_CONST_INT;
    public static final Rop ADD_CONST_LONG;
    public static final Rop ADD_DOUBLE;
    public static final Rop ADD_FLOAT;
    public static final Rop ADD_INT;
    public static final Rop ADD_LONG;
    public static final Rop AGET_BOOLEAN;
    public static final Rop AGET_BYTE;
    public static final Rop AGET_CHAR;
    public static final Rop AGET_DOUBLE;
    public static final Rop AGET_FLOAT;
    public static final Rop AGET_INT;
    public static final Rop AGET_LONG;
    public static final Rop AGET_OBJECT;
    public static final Rop AGET_SHORT;
    public static final Rop AND_CONST_INT;
    public static final Rop AND_CONST_LONG;
    public static final Rop AND_INT;
    public static final Rop AND_LONG;
    public static final Rop APUT_BOOLEAN;
    public static final Rop APUT_BYTE;
    public static final Rop APUT_CHAR;
    public static final Rop APUT_DOUBLE;
    public static final Rop APUT_FLOAT;
    public static final Rop APUT_INT;
    public static final Rop APUT_LONG;
    public static final Rop APUT_OBJECT;
    public static final Rop APUT_SHORT;
    public static final Rop ARRAY_LENGTH;
    public static final Rop CHECK_CAST;
    public static final Rop CMPG_DOUBLE;
    public static final Rop CMPG_FLOAT;
    public static final Rop CMPL_DOUBLE;
    public static final Rop CMPL_FLOAT;
    public static final Rop CMPL_LONG;
    public static final Rop CONST_DOUBLE;
    public static final Rop CONST_FLOAT;
    public static final Rop CONST_INT;
    public static final Rop CONST_LONG;
    public static final Rop CONST_OBJECT;
    public static final Rop CONST_OBJECT_NOTHROW;
    public static final Rop CONV_D2F;
    public static final Rop CONV_D2I;
    public static final Rop CONV_D2L;
    public static final Rop CONV_F2D;
    public static final Rop CONV_F2I;
    public static final Rop CONV_F2L;
    public static final Rop CONV_I2D;
    public static final Rop CONV_I2F;
    public static final Rop CONV_I2L;
    public static final Rop CONV_L2D;
    public static final Rop CONV_L2F;
    public static final Rop CONV_L2I;
    public static final Rop DIV_CONST_DOUBLE;
    public static final Rop DIV_CONST_FLOAT;
    public static final Rop DIV_CONST_INT;
    public static final Rop DIV_CONST_LONG;
    public static final Rop DIV_DOUBLE;
    public static final Rop DIV_FLOAT;
    public static final Rop DIV_INT;
    public static final Rop DIV_LONG;
    public static final Rop FILL_ARRAY_DATA;
    public static final Rop GET_FIELD_BOOLEAN;
    public static final Rop GET_FIELD_BYTE;
    public static final Rop GET_FIELD_CHAR;
    public static final Rop GET_FIELD_DOUBLE;
    public static final Rop GET_FIELD_FLOAT;
    public static final Rop GET_FIELD_INT;
    public static final Rop GET_FIELD_LONG;
    public static final Rop GET_FIELD_OBJECT;
    public static final Rop GET_FIELD_SHORT;
    public static final Rop GET_STATIC_BOOLEAN;
    public static final Rop GET_STATIC_BYTE;
    public static final Rop GET_STATIC_CHAR;
    public static final Rop GET_STATIC_DOUBLE;
    public static final Rop GET_STATIC_FLOAT;
    public static final Rop GET_STATIC_INT;
    public static final Rop GET_STATIC_LONG;
    public static final Rop GET_STATIC_OBJECT;
    public static final Rop GET_STATIC_SHORT;
    public static final Rop GOTO;
    public static final Rop IF_EQZ_INT;
    public static final Rop IF_EQZ_OBJECT;
    public static final Rop IF_EQ_INT;
    public static final Rop IF_EQ_OBJECT;
    public static final Rop IF_GEZ_INT;
    public static final Rop IF_GE_INT;
    public static final Rop IF_GTZ_INT;
    public static final Rop IF_GT_INT;
    public static final Rop IF_LEZ_INT;
    public static final Rop IF_LE_INT;
    public static final Rop IF_LTZ_INT;
    public static final Rop IF_LT_INT;
    public static final Rop IF_NEZ_INT;
    public static final Rop IF_NEZ_OBJECT;
    public static final Rop IF_NE_INT;
    public static final Rop IF_NE_OBJECT;
    public static final Rop INSTANCE_OF;
    public static final Rop MARK_LOCAL_DOUBLE;
    public static final Rop MARK_LOCAL_FLOAT;
    public static final Rop MARK_LOCAL_INT;
    public static final Rop MARK_LOCAL_LONG;
    public static final Rop MARK_LOCAL_OBJECT;
    public static final Rop MONITOR_ENTER;
    public static final Rop MONITOR_EXIT;
    public static final Rop MOVE_DOUBLE;
    public static final Rop MOVE_FLOAT;
    public static final Rop MOVE_INT;
    public static final Rop MOVE_LONG;
    public static final Rop MOVE_OBJECT;
    public static final Rop MOVE_PARAM_DOUBLE;
    public static final Rop MOVE_PARAM_FLOAT;
    public static final Rop MOVE_PARAM_INT;
    public static final Rop MOVE_PARAM_LONG;
    public static final Rop MOVE_PARAM_OBJECT;
    public static final Rop MOVE_RETURN_ADDRESS;
    public static final Rop MUL_CONST_DOUBLE;
    public static final Rop MUL_CONST_FLOAT;
    public static final Rop MUL_CONST_INT;
    public static final Rop MUL_CONST_LONG;
    public static final Rop MUL_DOUBLE;
    public static final Rop MUL_FLOAT;
    public static final Rop MUL_INT;
    public static final Rop MUL_LONG;
    public static final Rop NEG_DOUBLE;
    public static final Rop NEG_FLOAT;
    public static final Rop NEG_INT;
    public static final Rop NEG_LONG;
    public static final Rop NEW_ARRAY_BOOLEAN;
    public static final Rop NEW_ARRAY_BYTE;
    public static final Rop NEW_ARRAY_CHAR;
    public static final Rop NEW_ARRAY_DOUBLE;
    public static final Rop NEW_ARRAY_FLOAT;
    public static final Rop NEW_ARRAY_INT;
    public static final Rop NEW_ARRAY_LONG;
    public static final Rop NEW_ARRAY_SHORT;
    public static final Rop NEW_INSTANCE;
    public static final Rop NOP;
    public static final Rop NOT_INT;
    public static final Rop NOT_LONG;
    public static final Rop OR_CONST_INT;
    public static final Rop OR_CONST_LONG;
    public static final Rop OR_INT;
    public static final Rop OR_LONG;
    public static final Rop PUT_FIELD_BOOLEAN;
    public static final Rop PUT_FIELD_BYTE;
    public static final Rop PUT_FIELD_CHAR;
    public static final Rop PUT_FIELD_DOUBLE;
    public static final Rop PUT_FIELD_FLOAT;
    public static final Rop PUT_FIELD_INT;
    public static final Rop PUT_FIELD_LONG;
    public static final Rop PUT_FIELD_OBJECT;
    public static final Rop PUT_FIELD_SHORT;
    public static final Rop PUT_STATIC_BOOLEAN;
    public static final Rop PUT_STATIC_BYTE;
    public static final Rop PUT_STATIC_CHAR;
    public static final Rop PUT_STATIC_DOUBLE;
    public static final Rop PUT_STATIC_FLOAT;
    public static final Rop PUT_STATIC_INT;
    public static final Rop PUT_STATIC_LONG;
    public static final Rop PUT_STATIC_OBJECT;
    public static final Rop PUT_STATIC_SHORT;
    public static final Rop REM_CONST_DOUBLE;
    public static final Rop REM_CONST_FLOAT;
    public static final Rop REM_CONST_INT;
    public static final Rop REM_CONST_LONG;
    public static final Rop REM_DOUBLE;
    public static final Rop REM_FLOAT;
    public static final Rop REM_INT;
    public static final Rop REM_LONG;
    public static final Rop RETURN_DOUBLE;
    public static final Rop RETURN_FLOAT;
    public static final Rop RETURN_INT;
    public static final Rop RETURN_LONG;
    public static final Rop RETURN_OBJECT;
    public static final Rop RETURN_VOID;
    public static final Rop SHL_CONST_INT;
    public static final Rop SHL_CONST_LONG;
    public static final Rop SHL_INT;
    public static final Rop SHL_LONG;
    public static final Rop SHR_CONST_INT;
    public static final Rop SHR_CONST_LONG;
    public static final Rop SHR_INT;
    public static final Rop SHR_LONG;
    public static final Rop SUB_CONST_DOUBLE;
    public static final Rop SUB_CONST_FLOAT;
    public static final Rop SUB_CONST_INT;
    public static final Rop SUB_CONST_LONG;
    public static final Rop SUB_DOUBLE;
    public static final Rop SUB_FLOAT;
    public static final Rop SUB_INT;
    public static final Rop SUB_LONG;
    public static final Rop SWITCH;
    public static final Rop THROW;
    public static final Rop TO_BYTE;
    public static final Rop TO_CHAR;
    public static final Rop TO_SHORT;
    public static final Rop USHR_CONST_INT;
    public static final Rop USHR_CONST_LONG;
    public static final Rop USHR_INT;
    public static final Rop USHR_LONG;
    public static final Rop XOR_CONST_INT;
    public static final Rop XOR_CONST_LONG;
    public static final Rop XOR_INT;
    public static final Rop XOR_LONG;

    static {
        Rop rop;
        Rop rop2;
        Rop rop3;
        Rop rop4;
        Rop rop5;
        Rop rop6;
        Rop rop7;
        Rop rop8;
        Rop rop9;
        Rop rop10;
        Rop rop11;
        Rop rop12;
        Rop rop13;
        Rop rop14;
        Rop rop15;
        Rop rop16;
        Rop rop17;
        Rop rop18;
        Rop rop19;
        Rop rop20;
        Rop rop21;
        Rop rop22;
        Rop rop23;
        Rop rop24;
        Rop rop25;
        Rop rop26;
        Rop rop27;
        Rop rop28;
        Rop rop29;
        Rop rop30;
        Rop rop31;
        Rop rop32;
        Rop rop33;
        Rop rop34;
        Rop rop35;
        Rop rop36;
        Rop rop37;
        Rop rop38;
        Rop rop39;
        Rop rop40;
        Rop rop41;
        Rop rop42;
        Rop rop43;
        Rop rop44;
        Rop rop45;
        Rop rop46;
        Rop rop47;
        Rop rop48;
        Rop rop49;
        Rop rop50;
        Rop rop51;
        Rop rop52;
        Rop rop53;
        Rop rop54;
        Rop rop55;
        Rop rop56;
        Rop rop57;
        Rop rop58;
        Rop rop59;
        Rop rop60;
        Rop rop61;
        Rop rop62;
        Rop rop63;
        Rop rop64;
        Rop rop65;
        Rop rop66;
        Rop rop67;
        Rop rop68;
        Rop rop69;
        Rop rop70;
        Rop rop71;
        Rop rop72;
        Rop rop73;
        Rop rop74;
        Rop rop75;
        Rop rop76;
        Rop rop77;
        Rop rop78;
        Rop rop79;
        Rop rop80;
        Rop rop81;
        Rop rop82;
        Rop rop83;
        Rop rop84;
        Rop rop85;
        Rop rop86;
        Rop rop87;
        Rop rop88;
        Rop rop89;
        Rop rop90;
        Rop rop91;
        Rop rop92;
        Rop rop93;
        Rop rop94;
        Rop rop95;
        Rop rop96;
        Rop rop97;
        Rop rop98;
        Rop rop99;
        Rop rop100;
        Rop rop101;
        Rop rop102;
        Rop rop103;
        Rop rop104;
        Rop rop105;
        Rop rop106;
        Rop rop107;
        Rop rop108;
        Rop rop109;
        Rop rop110;
        Rop rop111;
        Rop rop112;
        Rop rop113;
        Rop rop114;
        Rop rop115;
        Rop rop116;
        Rop rop117;
        Rop rop118;
        Rop rop119;
        Rop rop120;
        Rop rop121;
        Rop rop122;
        Rop rop123;
        Rop rop124;
        Rop rop125;
        Rop rop126;
        Rop rop127;
        Rop rop128;
        Rop rop129;
        Rop rop130;
        Rop rop131;
        Rop rop132;
        Rop rop133;
        Rop rop134;
        Rop rop135;
        Rop rop136;
        Rop rop137;
        Rop rop138;
        Rop rop139;
        Rop rop140;
        Rop rop141;
        Rop rop142;
        Rop rop143;
        Rop rop144;
        Rop rop145;
        Rop rop146;
        Rop rop147;
        Rop rop148;
        Rop rop149;
        Rop rop150;
        Rop rop151;
        Rop rop152;
        Rop rop153;
        Rop rop154;
        Rop rop155;
        Rop rop156;
        Rop rop157;
        Rop rop158;
        Rop rop159;
        Rop rop160;
        Rop rop161;
        Rop rop162;
        Rop rop163;
        Rop rop164;
        Rop rop165;
        Rop rop166;
        Rop rop167;
        Rop rop168;
        Rop rop169;
        Rop rop170;
        Rop rop171;
        Rop rop172;
        Rop rop173;
        Rop rop174;
        Rop rop175;
        Rop rop176;
        Rop rop177;
        Rop rop178;
        Rop rop179;
        Rop rop180;
        Rop rop181;
        Rop rop182;
        Rop rop183;
        Rop rop184;
        Rop rop185;
        Rop rop186;
        Rop rop187;
        Rop rop188;
        Rop rop189;
        Rop rop190;
        Rop rop191;
        Rop rop192;
        Rop rop193;
        Rop rop194;
        Rop rop195;
        Rop rop196;
        Rop rop197;
        Rop rop198;
        Rop rop199;
        Rop rop200;
        Rop rop201;
        Rop rop202;
        Rop rop203;
        Rop rop204;
        Rop rop205;
        Rop rop206;
        Rop rop207;
        Rop rop208 = rop;
        Rop rop209 = new Rop(1, Type.VOID, StdTypeList.EMPTY, "nop");
        NOP = rop208;
        Rop rop210 = rop2;
        Rop rop211 = new Rop(2, Type.INT, StdTypeList.INT, "move-int");
        MOVE_INT = rop210;
        Rop rop212 = rop3;
        Rop rop213 = new Rop(2, Type.LONG, StdTypeList.LONG, "move-long");
        MOVE_LONG = rop212;
        Rop rop214 = rop4;
        Rop rop215 = new Rop(2, Type.FLOAT, StdTypeList.FLOAT, "move-float");
        MOVE_FLOAT = rop214;
        Rop rop216 = rop5;
        Rop rop217 = new Rop(2, Type.DOUBLE, StdTypeList.DOUBLE, "move-double");
        MOVE_DOUBLE = rop216;
        Rop rop218 = rop6;
        Rop rop219 = new Rop(2, Type.OBJECT, StdTypeList.OBJECT, "move-object");
        MOVE_OBJECT = rop218;
        Rop rop220 = rop7;
        Rop rop221 = new Rop(2, Type.RETURN_ADDRESS, StdTypeList.RETURN_ADDRESS, "move-return-address");
        MOVE_RETURN_ADDRESS = rop220;
        Rop rop222 = rop8;
        Rop rop223 = new Rop(3, Type.INT, StdTypeList.EMPTY, "move-param-int");
        MOVE_PARAM_INT = rop222;
        Rop rop224 = rop9;
        Rop rop225 = new Rop(3, Type.LONG, StdTypeList.EMPTY, "move-param-long");
        MOVE_PARAM_LONG = rop224;
        Rop rop226 = rop10;
        Rop rop227 = new Rop(3, Type.FLOAT, StdTypeList.EMPTY, "move-param-float");
        MOVE_PARAM_FLOAT = rop226;
        Rop rop228 = rop11;
        Rop rop229 = new Rop(3, Type.DOUBLE, StdTypeList.EMPTY, "move-param-double");
        MOVE_PARAM_DOUBLE = rop228;
        Rop rop230 = rop12;
        Rop rop231 = new Rop(3, Type.OBJECT, StdTypeList.EMPTY, "move-param-object");
        MOVE_PARAM_OBJECT = rop230;
        Rop rop232 = rop13;
        Rop rop233 = new Rop(5, Type.INT, StdTypeList.EMPTY, "const-int");
        CONST_INT = rop232;
        Rop rop234 = rop14;
        Rop rop235 = new Rop(5, Type.LONG, StdTypeList.EMPTY, "const-long");
        CONST_LONG = rop234;
        Rop rop236 = rop15;
        Rop rop237 = new Rop(5, Type.FLOAT, StdTypeList.EMPTY, "const-float");
        CONST_FLOAT = rop236;
        Rop rop238 = rop16;
        Rop rop239 = new Rop(5, Type.DOUBLE, StdTypeList.EMPTY, "const-double");
        CONST_DOUBLE = rop238;
        Rop rop240 = rop17;
        Rop rop241 = new Rop(5, Type.OBJECT, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "const-object");
        CONST_OBJECT = rop240;
        Rop rop242 = rop18;
        Rop rop243 = new Rop(5, Type.OBJECT, StdTypeList.EMPTY, "const-object-nothrow");
        CONST_OBJECT_NOTHROW = rop242;
        Rop rop244 = rop19;
        Rop rop245 = new Rop(6, Type.VOID, (TypeList) StdTypeList.EMPTY, 3, "goto");
        GOTO = rop244;
        Rop rop246 = rop20;
        Rop rop247 = new Rop(7, Type.VOID, (TypeList) StdTypeList.INT, 4, "if-eqz-int");
        IF_EQZ_INT = rop246;
        Rop rop248 = rop21;
        Rop rop249 = new Rop(8, Type.VOID, (TypeList) StdTypeList.INT, 4, "if-nez-int");
        IF_NEZ_INT = rop248;
        Rop rop250 = rop22;
        Rop rop251 = new Rop(9, Type.VOID, (TypeList) StdTypeList.INT, 4, "if-ltz-int");
        IF_LTZ_INT = rop250;
        Rop rop252 = rop23;
        Rop rop253 = new Rop(10, Type.VOID, (TypeList) StdTypeList.INT, 4, "if-gez-int");
        IF_GEZ_INT = rop252;
        Rop rop254 = rop24;
        Rop rop255 = new Rop(11, Type.VOID, (TypeList) StdTypeList.INT, 4, "if-lez-int");
        IF_LEZ_INT = rop254;
        Rop rop256 = rop25;
        Rop rop257 = new Rop(12, Type.VOID, (TypeList) StdTypeList.INT, 4, "if-gtz-int");
        IF_GTZ_INT = rop256;
        Rop rop258 = rop26;
        Rop rop259 = new Rop(7, Type.VOID, (TypeList) StdTypeList.OBJECT, 4, "if-eqz-object");
        IF_EQZ_OBJECT = rop258;
        Rop rop260 = rop27;
        Rop rop261 = new Rop(8, Type.VOID, (TypeList) StdTypeList.OBJECT, 4, "if-nez-object");
        IF_NEZ_OBJECT = rop260;
        Rop rop262 = rop28;
        Rop rop263 = new Rop(7, Type.VOID, (TypeList) StdTypeList.INT_INT, 4, "if-eq-int");
        IF_EQ_INT = rop262;
        Rop rop264 = rop29;
        Rop rop265 = new Rop(8, Type.VOID, (TypeList) StdTypeList.INT_INT, 4, "if-ne-int");
        IF_NE_INT = rop264;
        Rop rop266 = rop30;
        Rop rop267 = new Rop(9, Type.VOID, (TypeList) StdTypeList.INT_INT, 4, "if-lt-int");
        IF_LT_INT = rop266;
        Rop rop268 = rop31;
        Rop rop269 = new Rop(10, Type.VOID, (TypeList) StdTypeList.INT_INT, 4, "if-ge-int");
        IF_GE_INT = rop268;
        Rop rop270 = rop32;
        Rop rop271 = new Rop(11, Type.VOID, (TypeList) StdTypeList.INT_INT, 4, "if-le-int");
        IF_LE_INT = rop270;
        Rop rop272 = rop33;
        Rop rop273 = new Rop(12, Type.VOID, (TypeList) StdTypeList.INT_INT, 4, "if-gt-int");
        IF_GT_INT = rop272;
        Rop rop274 = rop34;
        Rop rop275 = new Rop(7, Type.VOID, (TypeList) StdTypeList.OBJECT_OBJECT, 4, "if-eq-object");
        IF_EQ_OBJECT = rop274;
        Rop rop276 = rop35;
        Rop rop277 = new Rop(8, Type.VOID, (TypeList) StdTypeList.OBJECT_OBJECT, 4, "if-ne-object");
        IF_NE_OBJECT = rop276;
        Rop rop278 = rop36;
        Rop rop279 = new Rop(13, Type.VOID, (TypeList) StdTypeList.INT, 5, "switch");
        SWITCH = rop278;
        Rop rop280 = rop37;
        Rop rop281 = new Rop(14, Type.INT, StdTypeList.INT_INT, "add-int");
        ADD_INT = rop280;
        Rop rop282 = rop38;
        Rop rop283 = new Rop(14, Type.LONG, StdTypeList.LONG_LONG, "add-long");
        ADD_LONG = rop282;
        Rop rop284 = rop39;
        Rop rop285 = new Rop(14, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "add-float");
        ADD_FLOAT = rop284;
        Rop rop286 = rop40;
        Rop rop287 = new Rop(14, Type.DOUBLE, (TypeList) StdTypeList.DOUBLE_DOUBLE, 1, "add-double");
        ADD_DOUBLE = rop286;
        Rop rop288 = rop41;
        Rop rop289 = new Rop(15, Type.INT, StdTypeList.INT_INT, "sub-int");
        SUB_INT = rop288;
        Rop rop290 = rop42;
        Rop rop291 = new Rop(15, Type.LONG, StdTypeList.LONG_LONG, "sub-long");
        SUB_LONG = rop290;
        Rop rop292 = rop43;
        Rop rop293 = new Rop(15, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "sub-float");
        SUB_FLOAT = rop292;
        Rop rop294 = rop44;
        Rop rop295 = new Rop(15, Type.DOUBLE, (TypeList) StdTypeList.DOUBLE_DOUBLE, 1, "sub-double");
        SUB_DOUBLE = rop294;
        Rop rop296 = rop45;
        Rop rop297 = new Rop(16, Type.INT, StdTypeList.INT_INT, "mul-int");
        MUL_INT = rop296;
        Rop rop298 = rop46;
        Rop rop299 = new Rop(16, Type.LONG, StdTypeList.LONG_LONG, "mul-long");
        MUL_LONG = rop298;
        Rop rop300 = rop47;
        Rop rop301 = new Rop(16, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "mul-float");
        MUL_FLOAT = rop300;
        Rop rop302 = rop48;
        Rop rop303 = new Rop(16, Type.DOUBLE, (TypeList) StdTypeList.DOUBLE_DOUBLE, 1, "mul-double");
        MUL_DOUBLE = rop302;
        Rop rop304 = rop49;
        Rop rop305 = new Rop(17, Type.INT, (TypeList) StdTypeList.INT_INT, (TypeList) Exceptions.LIST_Error_ArithmeticException, "div-int");
        DIV_INT = rop304;
        Rop rop306 = rop50;
        Rop rop307 = new Rop(17, Type.LONG, (TypeList) StdTypeList.LONG_LONG, (TypeList) Exceptions.LIST_Error_ArithmeticException, "div-long");
        DIV_LONG = rop306;
        Rop rop308 = rop51;
        Rop rop309 = new Rop(17, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "div-float");
        DIV_FLOAT = rop308;
        Rop rop310 = rop52;
        Rop rop311 = new Rop(17, Type.DOUBLE, StdTypeList.DOUBLE_DOUBLE, "div-double");
        DIV_DOUBLE = rop310;
        Rop rop312 = rop53;
        Rop rop313 = new Rop(18, Type.INT, (TypeList) StdTypeList.INT_INT, (TypeList) Exceptions.LIST_Error_ArithmeticException, "rem-int");
        REM_INT = rop312;
        Rop rop314 = rop54;
        Rop rop315 = new Rop(18, Type.LONG, (TypeList) StdTypeList.LONG_LONG, (TypeList) Exceptions.LIST_Error_ArithmeticException, "rem-long");
        REM_LONG = rop314;
        Rop rop316 = rop55;
        Rop rop317 = new Rop(18, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "rem-float");
        REM_FLOAT = rop316;
        Rop rop318 = rop56;
        Rop rop319 = new Rop(18, Type.DOUBLE, StdTypeList.DOUBLE_DOUBLE, "rem-double");
        REM_DOUBLE = rop318;
        Rop rop320 = rop57;
        Rop rop321 = new Rop(19, Type.INT, StdTypeList.INT, "neg-int");
        NEG_INT = rop320;
        Rop rop322 = rop58;
        Rop rop323 = new Rop(19, Type.LONG, StdTypeList.LONG, "neg-long");
        NEG_LONG = rop322;
        Rop rop324 = rop59;
        Rop rop325 = new Rop(19, Type.FLOAT, StdTypeList.FLOAT, "neg-float");
        NEG_FLOAT = rop324;
        Rop rop326 = rop60;
        Rop rop327 = new Rop(19, Type.DOUBLE, StdTypeList.DOUBLE, "neg-double");
        NEG_DOUBLE = rop326;
        Rop rop328 = rop61;
        Rop rop329 = new Rop(20, Type.INT, StdTypeList.INT_INT, "and-int");
        AND_INT = rop328;
        Rop rop330 = rop62;
        Rop rop331 = new Rop(20, Type.LONG, StdTypeList.LONG_LONG, "and-long");
        AND_LONG = rop330;
        Rop rop332 = rop63;
        Rop rop333 = new Rop(21, Type.INT, StdTypeList.INT_INT, "or-int");
        OR_INT = rop332;
        Rop rop334 = rop64;
        Rop rop335 = new Rop(21, Type.LONG, StdTypeList.LONG_LONG, "or-long");
        OR_LONG = rop334;
        Rop rop336 = rop65;
        Rop rop337 = new Rop(22, Type.INT, StdTypeList.INT_INT, "xor-int");
        XOR_INT = rop336;
        Rop rop338 = rop66;
        Rop rop339 = new Rop(22, Type.LONG, StdTypeList.LONG_LONG, "xor-long");
        XOR_LONG = rop338;
        Rop rop340 = rop67;
        Rop rop341 = new Rop(23, Type.INT, StdTypeList.INT_INT, "shl-int");
        SHL_INT = rop340;
        Rop rop342 = rop68;
        Rop rop343 = new Rop(23, Type.LONG, StdTypeList.LONG_INT, "shl-long");
        SHL_LONG = rop342;
        Rop rop344 = rop69;
        Rop rop345 = new Rop(24, Type.INT, StdTypeList.INT_INT, "shr-int");
        SHR_INT = rop344;
        Rop rop346 = rop70;
        Rop rop347 = new Rop(24, Type.LONG, StdTypeList.LONG_INT, "shr-long");
        SHR_LONG = rop346;
        Rop rop348 = rop71;
        Rop rop349 = new Rop(25, Type.INT, StdTypeList.INT_INT, "ushr-int");
        USHR_INT = rop348;
        Rop rop350 = rop72;
        Rop rop351 = new Rop(25, Type.LONG, StdTypeList.LONG_INT, "ushr-long");
        USHR_LONG = rop350;
        Rop rop352 = rop73;
        Rop rop353 = new Rop(26, Type.INT, StdTypeList.INT, "not-int");
        NOT_INT = rop352;
        Rop rop354 = rop74;
        Rop rop355 = new Rop(26, Type.LONG, StdTypeList.LONG, "not-long");
        NOT_LONG = rop354;
        Rop rop356 = rop75;
        Rop rop357 = new Rop(14, Type.INT, StdTypeList.INT, "add-const-int");
        ADD_CONST_INT = rop356;
        Rop rop358 = rop76;
        Rop rop359 = new Rop(14, Type.LONG, StdTypeList.LONG, "add-const-long");
        ADD_CONST_LONG = rop358;
        Rop rop360 = rop77;
        Rop rop361 = new Rop(14, Type.FLOAT, StdTypeList.FLOAT, "add-const-float");
        ADD_CONST_FLOAT = rop360;
        Rop rop362 = rop78;
        Rop rop363 = new Rop(14, Type.DOUBLE, StdTypeList.DOUBLE, "add-const-double");
        ADD_CONST_DOUBLE = rop362;
        Rop rop364 = rop79;
        Rop rop365 = new Rop(15, Type.INT, StdTypeList.INT, "sub-const-int");
        SUB_CONST_INT = rop364;
        Rop rop366 = rop80;
        Rop rop367 = new Rop(15, Type.LONG, StdTypeList.LONG, "sub-const-long");
        SUB_CONST_LONG = rop366;
        Rop rop368 = rop81;
        Rop rop369 = new Rop(15, Type.FLOAT, StdTypeList.FLOAT, "sub-const-float");
        SUB_CONST_FLOAT = rop368;
        Rop rop370 = rop82;
        Rop rop371 = new Rop(15, Type.DOUBLE, StdTypeList.DOUBLE, "sub-const-double");
        SUB_CONST_DOUBLE = rop370;
        Rop rop372 = rop83;
        Rop rop373 = new Rop(16, Type.INT, StdTypeList.INT, "mul-const-int");
        MUL_CONST_INT = rop372;
        Rop rop374 = rop84;
        Rop rop375 = new Rop(16, Type.LONG, StdTypeList.LONG, "mul-const-long");
        MUL_CONST_LONG = rop374;
        Rop rop376 = rop85;
        Rop rop377 = new Rop(16, Type.FLOAT, StdTypeList.FLOAT, "mul-const-float");
        MUL_CONST_FLOAT = rop376;
        Rop rop378 = rop86;
        Rop rop379 = new Rop(16, Type.DOUBLE, StdTypeList.DOUBLE, "mul-const-double");
        MUL_CONST_DOUBLE = rop378;
        Rop rop380 = rop87;
        Rop rop381 = new Rop(17, Type.INT, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_ArithmeticException, "div-const-int");
        DIV_CONST_INT = rop380;
        Rop rop382 = rop88;
        Rop rop383 = new Rop(17, Type.LONG, (TypeList) StdTypeList.LONG, (TypeList) Exceptions.LIST_Error_ArithmeticException, "div-const-long");
        DIV_CONST_LONG = rop382;
        Rop rop384 = rop89;
        Rop rop385 = new Rop(17, Type.FLOAT, StdTypeList.FLOAT, "div-const-float");
        DIV_CONST_FLOAT = rop384;
        Rop rop386 = rop90;
        Rop rop387 = new Rop(17, Type.DOUBLE, StdTypeList.DOUBLE, "div-const-double");
        DIV_CONST_DOUBLE = rop386;
        Rop rop388 = rop91;
        Rop rop389 = new Rop(18, Type.INT, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_ArithmeticException, "rem-const-int");
        REM_CONST_INT = rop388;
        Rop rop390 = rop92;
        Rop rop391 = new Rop(18, Type.LONG, (TypeList) StdTypeList.LONG, (TypeList) Exceptions.LIST_Error_ArithmeticException, "rem-const-long");
        REM_CONST_LONG = rop390;
        Rop rop392 = rop93;
        Rop rop393 = new Rop(18, Type.FLOAT, StdTypeList.FLOAT, "rem-const-float");
        REM_CONST_FLOAT = rop392;
        Rop rop394 = rop94;
        Rop rop395 = new Rop(18, Type.DOUBLE, StdTypeList.DOUBLE, "rem-const-double");
        REM_CONST_DOUBLE = rop394;
        Rop rop396 = rop95;
        Rop rop397 = new Rop(20, Type.INT, StdTypeList.INT, "and-const-int");
        AND_CONST_INT = rop396;
        Rop rop398 = rop96;
        Rop rop399 = new Rop(20, Type.LONG, StdTypeList.LONG, "and-const-long");
        AND_CONST_LONG = rop398;
        Rop rop400 = rop97;
        Rop rop401 = new Rop(21, Type.INT, StdTypeList.INT, "or-const-int");
        OR_CONST_INT = rop400;
        Rop rop402 = rop98;
        Rop rop403 = new Rop(21, Type.LONG, StdTypeList.LONG, "or-const-long");
        OR_CONST_LONG = rop402;
        Rop rop404 = rop99;
        Rop rop405 = new Rop(22, Type.INT, StdTypeList.INT, "xor-const-int");
        XOR_CONST_INT = rop404;
        Rop rop406 = rop100;
        Rop rop407 = new Rop(22, Type.LONG, StdTypeList.LONG, "xor-const-long");
        XOR_CONST_LONG = rop406;
        Rop rop408 = rop101;
        Rop rop409 = new Rop(23, Type.INT, StdTypeList.INT, "shl-const-int");
        SHL_CONST_INT = rop408;
        Rop rop410 = rop102;
        Rop rop411 = new Rop(23, Type.LONG, StdTypeList.INT, "shl-const-long");
        SHL_CONST_LONG = rop410;
        Rop rop412 = rop103;
        Rop rop413 = new Rop(24, Type.INT, StdTypeList.INT, "shr-const-int");
        SHR_CONST_INT = rop412;
        Rop rop414 = rop104;
        Rop rop415 = new Rop(24, Type.LONG, StdTypeList.INT, "shr-const-long");
        SHR_CONST_LONG = rop414;
        Rop rop416 = rop105;
        Rop rop417 = new Rop(25, Type.INT, StdTypeList.INT, "ushr-const-int");
        USHR_CONST_INT = rop416;
        Rop rop418 = rop106;
        Rop rop419 = new Rop(25, Type.LONG, StdTypeList.INT, "ushr-const-long");
        USHR_CONST_LONG = rop418;
        Rop rop420 = rop107;
        Rop rop421 = new Rop(27, Type.INT, StdTypeList.LONG_LONG, "cmpl-long");
        CMPL_LONG = rop420;
        Rop rop422 = rop108;
        Rop rop423 = new Rop(27, Type.INT, StdTypeList.FLOAT_FLOAT, "cmpl-float");
        CMPL_FLOAT = rop422;
        Rop rop424 = rop109;
        Rop rop425 = new Rop(27, Type.INT, StdTypeList.DOUBLE_DOUBLE, "cmpl-double");
        CMPL_DOUBLE = rop424;
        Rop rop426 = rop110;
        Rop rop427 = new Rop(28, Type.INT, StdTypeList.FLOAT_FLOAT, "cmpg-float");
        CMPG_FLOAT = rop426;
        Rop rop428 = rop111;
        Rop rop429 = new Rop(28, Type.INT, StdTypeList.DOUBLE_DOUBLE, "cmpg-double");
        CMPG_DOUBLE = rop428;
        Rop rop430 = rop112;
        Rop rop431 = new Rop(29, Type.INT, StdTypeList.LONG, "conv-l2i");
        CONV_L2I = rop430;
        Rop rop432 = rop113;
        Rop rop433 = new Rop(29, Type.INT, StdTypeList.FLOAT, "conv-f2i");
        CONV_F2I = rop432;
        Rop rop434 = rop114;
        Rop rop435 = new Rop(29, Type.INT, StdTypeList.DOUBLE, "conv-d2i");
        CONV_D2I = rop434;
        Rop rop436 = rop115;
        Rop rop437 = new Rop(29, Type.LONG, StdTypeList.INT, "conv-i2l");
        CONV_I2L = rop436;
        Rop rop438 = rop116;
        Rop rop439 = new Rop(29, Type.LONG, StdTypeList.FLOAT, "conv-f2l");
        CONV_F2L = rop438;
        Rop rop440 = rop117;
        Rop rop441 = new Rop(29, Type.LONG, StdTypeList.DOUBLE, "conv-d2l");
        CONV_D2L = rop440;
        Rop rop442 = rop118;
        Rop rop443 = new Rop(29, Type.FLOAT, StdTypeList.INT, "conv-i2f");
        CONV_I2F = rop442;
        Rop rop444 = rop119;
        Rop rop445 = new Rop(29, Type.FLOAT, StdTypeList.LONG, "conv-l2f");
        CONV_L2F = rop444;
        Rop rop446 = rop120;
        Rop rop447 = new Rop(29, Type.FLOAT, StdTypeList.DOUBLE, "conv-d2f");
        CONV_D2F = rop446;
        Rop rop448 = rop121;
        Rop rop449 = new Rop(29, Type.DOUBLE, StdTypeList.INT, "conv-i2d");
        CONV_I2D = rop448;
        Rop rop450 = rop122;
        Rop rop451 = new Rop(29, Type.DOUBLE, StdTypeList.LONG, "conv-l2d");
        CONV_L2D = rop450;
        Rop rop452 = rop123;
        Rop rop453 = new Rop(29, Type.DOUBLE, StdTypeList.FLOAT, "conv-f2d");
        CONV_F2D = rop452;
        Rop rop454 = rop124;
        Rop rop455 = new Rop(30, Type.INT, StdTypeList.INT, "to-byte");
        TO_BYTE = rop454;
        Rop rop456 = rop125;
        Rop rop457 = new Rop(31, Type.INT, StdTypeList.INT, "to-char");
        TO_CHAR = rop456;
        Rop rop458 = rop126;
        Rop rop459 = new Rop(32, Type.INT, StdTypeList.INT, "to-short");
        TO_SHORT = rop458;
        Rop rop460 = rop127;
        Rop rop461 = new Rop(33, Type.VOID, (TypeList) StdTypeList.EMPTY, 2, "return-void");
        RETURN_VOID = rop460;
        Rop rop462 = rop128;
        Rop rop463 = new Rop(33, Type.VOID, (TypeList) StdTypeList.INT, 2, "return-int");
        RETURN_INT = rop462;
        Rop rop464 = rop129;
        Rop rop465 = new Rop(33, Type.VOID, (TypeList) StdTypeList.LONG, 2, "return-long");
        RETURN_LONG = rop464;
        Rop rop466 = rop130;
        Rop rop467 = new Rop(33, Type.VOID, (TypeList) StdTypeList.FLOAT, 2, "return-float");
        RETURN_FLOAT = rop466;
        Rop rop468 = rop131;
        Rop rop469 = new Rop(33, Type.VOID, (TypeList) StdTypeList.DOUBLE, 2, "return-double");
        RETURN_DOUBLE = rop468;
        Rop rop470 = rop132;
        Rop rop471 = new Rop(33, Type.VOID, (TypeList) StdTypeList.OBJECT, 2, "return-object");
        RETURN_OBJECT = rop470;
        Rop rop472 = rop133;
        Rop rop473 = new Rop(34, Type.INT, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "array-length");
        ARRAY_LENGTH = rop472;
        Rop rop474 = rop134;
        Rop rop475 = new Rop(35, Type.VOID, (TypeList) StdTypeList.THROWABLE, (TypeList) StdTypeList.THROWABLE, "throw");
        THROW = rop474;
        Rop rop476 = rop135;
        Rop rop477 = new Rop(36, Type.VOID, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "monitor-enter");
        MONITOR_ENTER = rop476;
        Rop rop478 = rop136;
        Rop rop479 = new Rop(37, Type.VOID, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_Null_IllegalMonitorStateException, "monitor-exit");
        MONITOR_EXIT = rop478;
        Rop rop480 = rop137;
        Rop rop481 = new Rop(38, Type.INT, (TypeList) StdTypeList.INTARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-int");
        AGET_INT = rop480;
        Rop rop482 = rop138;
        Rop rop483 = new Rop(38, Type.LONG, (TypeList) StdTypeList.LONGARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-long");
        AGET_LONG = rop482;
        Rop rop484 = rop139;
        Rop rop485 = new Rop(38, Type.FLOAT, (TypeList) StdTypeList.FLOATARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-float");
        AGET_FLOAT = rop484;
        Rop rop486 = rop140;
        Rop rop487 = new Rop(38, Type.DOUBLE, (TypeList) StdTypeList.DOUBLEARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-double");
        AGET_DOUBLE = rop486;
        Rop rop488 = rop141;
        Rop rop489 = new Rop(38, Type.OBJECT, (TypeList) StdTypeList.OBJECTARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-object");
        AGET_OBJECT = rop488;
        Rop rop490 = rop142;
        Rop rop491 = new Rop(38, Type.INT, (TypeList) StdTypeList.BOOLEANARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-boolean");
        AGET_BOOLEAN = rop490;
        Rop rop492 = rop143;
        Rop rop493 = new Rop(38, Type.INT, (TypeList) StdTypeList.BYTEARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-byte");
        AGET_BYTE = rop492;
        Rop rop494 = rop144;
        Rop rop495 = new Rop(38, Type.INT, (TypeList) StdTypeList.CHARARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-char");
        AGET_CHAR = rop494;
        Rop rop496 = rop145;
        Rop rop497 = new Rop(38, Type.INT, (TypeList) StdTypeList.SHORTARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-short");
        AGET_SHORT = rop496;
        Rop rop498 = rop146;
        Rop rop499 = new Rop(39, Type.VOID, (TypeList) StdTypeList.INT_INTARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aput-int");
        APUT_INT = rop498;
        Rop rop500 = rop147;
        Rop rop501 = new Rop(39, Type.VOID, (TypeList) StdTypeList.LONG_LONGARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aput-long");
        APUT_LONG = rop500;
        Rop rop502 = rop148;
        Rop rop503 = new Rop(39, Type.VOID, (TypeList) StdTypeList.FLOAT_FLOATARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aput-float");
        APUT_FLOAT = rop502;
        Rop rop504 = rop149;
        Rop rop505 = new Rop(39, Type.VOID, (TypeList) StdTypeList.DOUBLE_DOUBLEARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aput-double");
        APUT_DOUBLE = rop504;
        Rop rop506 = rop150;
        Rop rop507 = new Rop(39, Type.VOID, (TypeList) StdTypeList.OBJECT_OBJECTARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-object");
        APUT_OBJECT = rop506;
        Rop rop508 = rop151;
        Rop rop509 = new Rop(39, Type.VOID, (TypeList) StdTypeList.INT_BOOLEANARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-boolean");
        APUT_BOOLEAN = rop508;
        Rop rop510 = rop152;
        Rop rop511 = new Rop(39, Type.VOID, (TypeList) StdTypeList.INT_BYTEARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-byte");
        APUT_BYTE = rop510;
        Rop rop512 = rop153;
        Rop rop513 = new Rop(39, Type.VOID, (TypeList) StdTypeList.INT_CHARARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-char");
        APUT_CHAR = rop512;
        Rop rop514 = rop154;
        Rop rop515 = new Rop(39, Type.VOID, (TypeList) StdTypeList.INT_SHORTARR_INT, (TypeList) Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-short");
        APUT_SHORT = rop514;
        Rop rop516 = rop155;
        Rop rop517 = new Rop(40, Type.OBJECT, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "new-instance");
        NEW_INSTANCE = rop516;
        Rop rop518 = rop156;
        Rop rop519 = new Rop(41, Type.INT_ARRAY, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_NegativeArraySizeException, "new-array-int");
        NEW_ARRAY_INT = rop518;
        Rop rop520 = rop157;
        Rop rop521 = new Rop(41, Type.LONG_ARRAY, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_NegativeArraySizeException, "new-array-long");
        NEW_ARRAY_LONG = rop520;
        Rop rop522 = rop158;
        Rop rop523 = new Rop(41, Type.FLOAT_ARRAY, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_NegativeArraySizeException, "new-array-float");
        NEW_ARRAY_FLOAT = rop522;
        Rop rop524 = rop159;
        Rop rop525 = new Rop(41, Type.DOUBLE_ARRAY, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_NegativeArraySizeException, "new-array-double");
        NEW_ARRAY_DOUBLE = rop524;
        Rop rop526 = rop160;
        Rop rop527 = new Rop(41, Type.BOOLEAN_ARRAY, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_NegativeArraySizeException, "new-array-boolean");
        NEW_ARRAY_BOOLEAN = rop526;
        Rop rop528 = rop161;
        Rop rop529 = new Rop(41, Type.BYTE_ARRAY, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_NegativeArraySizeException, "new-array-byte");
        NEW_ARRAY_BYTE = rop528;
        Rop rop530 = rop162;
        Rop rop531 = new Rop(41, Type.CHAR_ARRAY, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_NegativeArraySizeException, "new-array-char");
        NEW_ARRAY_CHAR = rop530;
        Rop rop532 = rop163;
        Rop rop533 = new Rop(41, Type.SHORT_ARRAY, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_NegativeArraySizeException, "new-array-short");
        NEW_ARRAY_SHORT = rop532;
        Rop rop534 = rop164;
        Rop rop535 = new Rop(43, Type.VOID, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_ClassCastException, "check-cast");
        CHECK_CAST = rop534;
        Rop rop536 = rop165;
        Rop rop537 = new Rop(44, Type.INT, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error, "instance-of");
        INSTANCE_OF = rop536;
        Rop rop538 = rop166;
        Rop rop539 = new Rop(45, Type.INT, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "get-field-int");
        GET_FIELD_INT = rop538;
        Rop rop540 = rop167;
        Rop rop541 = new Rop(45, Type.LONG, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "get-field-long");
        GET_FIELD_LONG = rop540;
        Rop rop542 = rop168;
        Rop rop543 = new Rop(45, Type.FLOAT, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "get-field-float");
        GET_FIELD_FLOAT = rop542;
        Rop rop544 = rop169;
        Rop rop545 = new Rop(45, Type.DOUBLE, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "get-field-double");
        GET_FIELD_DOUBLE = rop544;
        Rop rop546 = rop170;
        Rop rop547 = new Rop(45, Type.OBJECT, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "get-field-object");
        GET_FIELD_OBJECT = rop546;
        Rop rop548 = rop171;
        Rop rop549 = new Rop(45, Type.INT, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "get-field-boolean");
        GET_FIELD_BOOLEAN = rop548;
        Rop rop550 = rop172;
        Rop rop551 = new Rop(45, Type.INT, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "get-field-byte");
        GET_FIELD_BYTE = rop550;
        Rop rop552 = rop173;
        Rop rop553 = new Rop(45, Type.INT, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "get-field-char");
        GET_FIELD_CHAR = rop552;
        Rop rop554 = rop174;
        Rop rop555 = new Rop(45, Type.INT, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "get-field-short");
        GET_FIELD_SHORT = rop554;
        Rop rop556 = rop175;
        Rop rop557 = new Rop(46, Type.INT, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "get-static-int");
        GET_STATIC_INT = rop556;
        Rop rop558 = rop176;
        Rop rop559 = new Rop(46, Type.LONG, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "get-static-long");
        GET_STATIC_LONG = rop558;
        Rop rop560 = rop177;
        Rop rop561 = new Rop(46, Type.FLOAT, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "get-static-float");
        GET_STATIC_FLOAT = rop560;
        Rop rop562 = rop178;
        Rop rop563 = new Rop(46, Type.DOUBLE, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "get-static-double");
        GET_STATIC_DOUBLE = rop562;
        Rop rop564 = rop179;
        Rop rop565 = new Rop(46, Type.OBJECT, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "get-static-object");
        GET_STATIC_OBJECT = rop564;
        Rop rop566 = rop180;
        Rop rop567 = new Rop(46, Type.INT, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "get-field-boolean");
        GET_STATIC_BOOLEAN = rop566;
        Rop rop568 = rop181;
        Rop rop569 = new Rop(46, Type.INT, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "get-field-byte");
        GET_STATIC_BYTE = rop568;
        Rop rop570 = rop182;
        Rop rop571 = new Rop(46, Type.INT, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "get-field-char");
        GET_STATIC_CHAR = rop570;
        Rop rop572 = rop183;
        Rop rop573 = new Rop(46, Type.INT, (TypeList) StdTypeList.EMPTY, (TypeList) Exceptions.LIST_Error, "get-field-short");
        GET_STATIC_SHORT = rop572;
        Rop rop574 = rop184;
        Rop rop575 = new Rop(47, Type.VOID, (TypeList) StdTypeList.INT_OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "put-field-int");
        PUT_FIELD_INT = rop574;
        Rop rop576 = rop185;
        Rop rop577 = new Rop(47, Type.VOID, (TypeList) StdTypeList.LONG_OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "put-field-long");
        PUT_FIELD_LONG = rop576;
        Rop rop578 = rop186;
        Rop rop579 = new Rop(47, Type.VOID, (TypeList) StdTypeList.FLOAT_OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "put-field-float");
        PUT_FIELD_FLOAT = rop578;
        Rop rop580 = rop187;
        Rop rop581 = new Rop(47, Type.VOID, (TypeList) StdTypeList.DOUBLE_OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "put-field-double");
        PUT_FIELD_DOUBLE = rop580;
        Rop rop582 = rop188;
        Rop rop583 = new Rop(47, Type.VOID, (TypeList) StdTypeList.OBJECT_OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "put-field-object");
        PUT_FIELD_OBJECT = rop582;
        Rop rop584 = rop189;
        Rop rop585 = new Rop(47, Type.VOID, (TypeList) StdTypeList.INT_OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "put-field-boolean");
        PUT_FIELD_BOOLEAN = rop584;
        Rop rop586 = rop190;
        Rop rop587 = new Rop(47, Type.VOID, (TypeList) StdTypeList.INT_OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "put-field-byte");
        PUT_FIELD_BYTE = rop586;
        Rop rop588 = rop191;
        Rop rop589 = new Rop(47, Type.VOID, (TypeList) StdTypeList.INT_OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "put-field-char");
        PUT_FIELD_CHAR = rop588;
        Rop rop590 = rop192;
        Rop rop591 = new Rop(47, Type.VOID, (TypeList) StdTypeList.INT_OBJECT, (TypeList) Exceptions.LIST_Error_NullPointerException, "put-field-short");
        PUT_FIELD_SHORT = rop590;
        Rop rop592 = rop193;
        Rop rop593 = new Rop(48, Type.VOID, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error, "put-static-int");
        PUT_STATIC_INT = rop592;
        Rop rop594 = rop194;
        Rop rop595 = new Rop(48, Type.VOID, (TypeList) StdTypeList.LONG, (TypeList) Exceptions.LIST_Error, "put-static-long");
        PUT_STATIC_LONG = rop594;
        Rop rop596 = rop195;
        Rop rop597 = new Rop(48, Type.VOID, (TypeList) StdTypeList.FLOAT, (TypeList) Exceptions.LIST_Error, "put-static-float");
        PUT_STATIC_FLOAT = rop596;
        Rop rop598 = rop196;
        Rop rop599 = new Rop(48, Type.VOID, (TypeList) StdTypeList.DOUBLE, (TypeList) Exceptions.LIST_Error, "put-static-double");
        PUT_STATIC_DOUBLE = rop598;
        Rop rop600 = rop197;
        Rop rop601 = new Rop(48, Type.VOID, (TypeList) StdTypeList.OBJECT, (TypeList) Exceptions.LIST_Error, "put-static-object");
        PUT_STATIC_OBJECT = rop600;
        Rop rop602 = rop198;
        Rop rop603 = new Rop(48, Type.VOID, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error, "put-static-boolean");
        PUT_STATIC_BOOLEAN = rop602;
        Rop rop604 = rop199;
        Rop rop605 = new Rop(48, Type.VOID, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error, "put-static-byte");
        PUT_STATIC_BYTE = rop604;
        Rop rop606 = rop200;
        Rop rop607 = new Rop(48, Type.VOID, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error, "put-static-char");
        PUT_STATIC_CHAR = rop606;
        Rop rop608 = rop201;
        Rop rop609 = new Rop(48, Type.VOID, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error, "put-static-short");
        PUT_STATIC_SHORT = rop608;
        Rop rop610 = rop202;
        Rop rop611 = new Rop(54, Type.VOID, StdTypeList.INT, "mark-local-int");
        MARK_LOCAL_INT = rop610;
        Rop rop612 = rop203;
        Rop rop613 = new Rop(54, Type.VOID, StdTypeList.LONG, "mark-local-long");
        MARK_LOCAL_LONG = rop612;
        Rop rop614 = rop204;
        Rop rop615 = new Rop(54, Type.VOID, StdTypeList.FLOAT, "mark-local-float");
        MARK_LOCAL_FLOAT = rop614;
        Rop rop616 = rop205;
        Rop rop617 = new Rop(54, Type.VOID, StdTypeList.DOUBLE, "mark-local-double");
        MARK_LOCAL_DOUBLE = rop616;
        Rop rop618 = rop206;
        Rop rop619 = new Rop(54, Type.VOID, StdTypeList.OBJECT, "mark-local-object");
        MARK_LOCAL_OBJECT = rop618;
        Rop rop620 = rop207;
        Rop rop621 = new Rop(57, Type.VOID, StdTypeList.EMPTY, "fill-array-data");
        FILL_ARRAY_DATA = rop620;
    }

    private Rops() {
    }

    public static Rop opAdd(TypeList typeList) {
        return pickBinaryOp(typeList, ADD_CONST_INT, ADD_CONST_LONG, ADD_CONST_FLOAT, ADD_CONST_DOUBLE, ADD_INT, ADD_LONG, ADD_FLOAT, ADD_DOUBLE);
    }

    public static Rop opAget(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicType()) {
            case 1:
                return AGET_BOOLEAN;
            case 2:
                return AGET_BYTE;
            case 3:
                return AGET_CHAR;
            case 4:
                return AGET_DOUBLE;
            case 5:
                return AGET_FLOAT;
            case 6:
                return AGET_INT;
            case 7:
                return AGET_LONG;
            case 8:
                return AGET_SHORT;
            case 9:
                return AGET_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opAnd(TypeList typeList) {
        return pickBinaryOp(typeList, AND_CONST_INT, AND_CONST_LONG, null, null, AND_INT, AND_LONG, null, null);
    }

    public static Rop opAput(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicType()) {
            case 1:
                return APUT_BOOLEAN;
            case 2:
                return APUT_BYTE;
            case 3:
                return APUT_CHAR;
            case 4:
                return APUT_DOUBLE;
            case 5:
                return APUT_FLOAT;
            case 6:
                return APUT_INT;
            case 7:
                return APUT_LONG;
            case 8:
                return APUT_SHORT;
            case 9:
                return APUT_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opCmpg(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicType()) {
            case 4:
                return CMPG_DOUBLE;
            case 5:
                return CMPG_FLOAT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opCmpl(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicType()) {
            case 4:
                return CMPL_DOUBLE;
            case 5:
                return CMPL_FLOAT;
            case 7:
                return CMPL_LONG;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opConst(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        if (typeBearer2.getType() == Type.KNOWN_NULL) {
            return CONST_OBJECT_NOTHROW;
        }
        switch (typeBearer2.getBasicFrameType()) {
            case 4:
                return CONST_DOUBLE;
            case 5:
                return CONST_FLOAT;
            case 6:
                return CONST_INT;
            case 7:
                return CONST_LONG;
            case 9:
                return CONST_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        switch(r2) {
            case 5: goto L_0x0035;
            case 6: goto L_0x005d;
            case 7: goto L_0x0061;
            default: goto L_0x0034;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return throwBadTypes(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList.make(r0.getType(), r1.getType()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return CONV_D2F;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return CONV_L2I;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return CONV_L2F;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return CONV_L2D;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return CONV_F2I;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return CONV_F2L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return CONV_F2D;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return CONV_D2I;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return CONV_D2L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        switch(r2) {
            case 4: goto L_0x004d;
            case 5: goto L_0x0049;
            case 6: goto L_0x0045;
            default: goto L_0x002c;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        switch(r2) {
            case 4: goto L_0x0059;
            case 5: goto L_0x0030;
            case 6: goto L_0x0051;
            case 7: goto L_0x0055;
            default: goto L_0x0030;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop opConv(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer r5, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer r6) {
        /*
            r0 = r5
            r1 = r6
            r3 = r0
            int r3 = r3.getBasicFrameType()
            r2 = r3
            r3 = r1
            int r3 = r3.getBasicFrameType()
            switch(r3) {
                case 4: goto L_0x0030;
                case 5: goto L_0x002c;
                case 6: goto L_0x0024;
                case 7: goto L_0x0028;
                default: goto L_0x0010;
            }
        L_0x0010:
            r3 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r3 = r3.getType()
            r4 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r4 = r4.getType()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.StdTypeList r3 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList.make(r3, r4)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = throwBadTypes(r3)
            r0 = r3
        L_0x0023:
            return r0
        L_0x0024:
            r3 = r2
            switch(r3) {
                case 4: goto L_0x0041;
                case 5: goto L_0x003d;
                case 6: goto L_0x0028;
                case 7: goto L_0x0039;
                default: goto L_0x0028;
            }
        L_0x0028:
            r3 = r2
            switch(r3) {
                case 4: goto L_0x004d;
                case 5: goto L_0x0049;
                case 6: goto L_0x0045;
                default: goto L_0x002c;
            }
        L_0x002c:
            r3 = r2
            switch(r3) {
                case 4: goto L_0x0059;
                case 5: goto L_0x0030;
                case 6: goto L_0x0051;
                case 7: goto L_0x0055;
                default: goto L_0x0030;
            }
        L_0x0030:
            r3 = r2
            switch(r3) {
                case 5: goto L_0x0035;
                case 6: goto L_0x005d;
                case 7: goto L_0x0061;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x0010
        L_0x0035:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_D2F
            r0 = r3
            goto L_0x0023
        L_0x0039:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_I2L
            r0 = r3
            goto L_0x0023
        L_0x003d:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_I2F
            r0 = r3
            goto L_0x0023
        L_0x0041:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_I2D
            r0 = r3
            goto L_0x0023
        L_0x0045:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_L2I
            r0 = r3
            goto L_0x0023
        L_0x0049:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_L2F
            r0 = r3
            goto L_0x0023
        L_0x004d:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_L2D
            r0 = r3
            goto L_0x0023
        L_0x0051:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_F2I
            r0 = r3
            goto L_0x0023
        L_0x0055:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_F2L
            r0 = r3
            goto L_0x0023
        L_0x0059:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_F2D
            r0 = r3
            goto L_0x0023
        L_0x005d:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_D2I
            r0 = r3
            goto L_0x0023
        L_0x0061:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r3 = CONV_D2L
            r0 = r3
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opConv(net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer, net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer):net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop");
    }

    public static Rop opDiv(TypeList typeList) {
        return pickBinaryOp(typeList, DIV_CONST_INT, DIV_CONST_LONG, DIV_CONST_FLOAT, DIV_CONST_DOUBLE, DIV_INT, DIV_LONG, DIV_FLOAT, DIV_DOUBLE);
    }

    public static Rop opFilledNewArray(TypeBearer typeBearer, int i) {
        StdTypeList stdTypeList;
        Rop rop;
        IllegalArgumentException illegalArgumentException;
        TypeBearer typeBearer2 = typeBearer;
        int i2 = i;
        Type componentType = typeBearer2.getType().getComponentType();
        if (componentType.isCategory2()) {
            return throwBadType(typeBearer2);
        }
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("count < 0");
            throw illegalArgumentException2;
        }
        StdTypeList stdTypeList2 = stdTypeList;
        StdTypeList stdTypeList3 = new StdTypeList(i2);
        StdTypeList stdTypeList4 = stdTypeList2;
        for (int i3 = 0; i3 < i2; i3++) {
            stdTypeList4.set(i3, componentType);
        }
        Rop rop2 = rop;
        Rop rop3 = new Rop(42, stdTypeList4, Exceptions.LIST_Error);
        return rop2;
    }

    public static Rop opGetField(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicType()) {
            case 1:
                return GET_FIELD_BOOLEAN;
            case 2:
                return GET_FIELD_BYTE;
            case 3:
                return GET_FIELD_CHAR;
            case 4:
                return GET_FIELD_DOUBLE;
            case 5:
                return GET_FIELD_FLOAT;
            case 6:
                return GET_FIELD_INT;
            case 7:
                return GET_FIELD_LONG;
            case 8:
                return GET_FIELD_SHORT;
            case 9:
                return GET_FIELD_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opGetStatic(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicType()) {
            case 1:
                return GET_STATIC_BOOLEAN;
            case 2:
                return GET_STATIC_BYTE;
            case 3:
                return GET_STATIC_CHAR;
            case 4:
                return GET_STATIC_DOUBLE;
            case 5:
                return GET_STATIC_FLOAT;
            case 6:
                return GET_STATIC_INT;
            case 7:
                return GET_STATIC_LONG;
            case 8:
                return GET_STATIC_SHORT;
            case 9:
                return GET_STATIC_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opIfEq(TypeList typeList) {
        return pickIf(typeList, IF_EQZ_INT, IF_EQZ_OBJECT, IF_EQ_INT, IF_EQ_OBJECT);
    }

    public static Rop opIfGe(TypeList typeList) {
        return pickIf(typeList, IF_GEZ_INT, null, IF_GE_INT, null);
    }

    public static Rop opIfGt(TypeList typeList) {
        return pickIf(typeList, IF_GTZ_INT, null, IF_GT_INT, null);
    }

    public static Rop opIfLe(TypeList typeList) {
        return pickIf(typeList, IF_LEZ_INT, null, IF_LE_INT, null);
    }

    public static Rop opIfLt(TypeList typeList) {
        return pickIf(typeList, IF_LTZ_INT, null, IF_LT_INT, null);
    }

    public static Rop opIfNe(TypeList typeList) {
        return pickIf(typeList, IF_NEZ_INT, IF_NEZ_OBJECT, IF_NE_INT, IF_NE_OBJECT);
    }

    public static Rop opInvokeDirect(Prototype prototype) {
        Rop rop;
        Rop rop2 = rop;
        Rop rop3 = new Rop(52, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
        return rop2;
    }

    public static Rop opInvokeInterface(Prototype prototype) {
        Rop rop;
        Rop rop2 = rop;
        Rop rop3 = new Rop(53, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
        return rop2;
    }

    public static Rop opInvokeStatic(Prototype prototype) {
        Rop rop;
        Rop rop2 = rop;
        Rop rop3 = new Rop(49, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
        return rop2;
    }

    public static Rop opInvokeSuper(Prototype prototype) {
        Rop rop;
        Rop rop2 = rop;
        Rop rop3 = new Rop(51, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
        return rop2;
    }

    public static Rop opInvokeVirtual(Prototype prototype) {
        Rop rop;
        Rop rop2 = rop;
        Rop rop3 = new Rop(50, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
        return rop2;
    }

    public static Rop opMarkLocal(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicFrameType()) {
            case 4:
                return MARK_LOCAL_DOUBLE;
            case 5:
                return MARK_LOCAL_FLOAT;
            case 6:
                return MARK_LOCAL_INT;
            case 7:
                return MARK_LOCAL_LONG;
            case 9:
                return MARK_LOCAL_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opMove(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicFrameType()) {
            case 4:
                return MOVE_DOUBLE;
            case 5:
                return MOVE_FLOAT;
            case 6:
                return MOVE_INT;
            case 7:
                return MOVE_LONG;
            case 9:
                return MOVE_OBJECT;
            case 10:
                return MOVE_RETURN_ADDRESS;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opMoveException(TypeBearer typeBearer) {
        Rop rop;
        Rop rop2 = rop;
        Rop rop3 = new Rop(4, typeBearer.getType(), StdTypeList.EMPTY, null);
        return rop2;
    }

    public static Rop opMoveParam(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicFrameType()) {
            case 4:
                return MOVE_PARAM_DOUBLE;
            case 5:
                return MOVE_PARAM_FLOAT;
            case 6:
                return MOVE_PARAM_INT;
            case 7:
                return MOVE_PARAM_LONG;
            case 9:
                return MOVE_PARAM_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opMoveResult(TypeBearer typeBearer) {
        Rop rop;
        Rop rop2 = rop;
        Rop rop3 = new Rop(55, typeBearer.getType(), StdTypeList.EMPTY, null);
        return rop2;
    }

    public static Rop opMoveResultPseudo(TypeBearer typeBearer) {
        Rop rop;
        Rop rop2 = rop;
        Rop rop3 = new Rop(56, typeBearer.getType(), StdTypeList.EMPTY, null);
        return rop2;
    }

    public static Rop opMul(TypeList typeList) {
        return pickBinaryOp(typeList, MUL_CONST_INT, MUL_CONST_LONG, MUL_CONST_FLOAT, MUL_CONST_DOUBLE, MUL_INT, MUL_LONG, MUL_FLOAT, MUL_DOUBLE);
    }

    public static Rop opNeg(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicFrameType()) {
            case 4:
                return NEG_DOUBLE;
            case 5:
                return NEG_FLOAT;
            case 6:
                return NEG_INT;
            case 7:
                return NEG_LONG;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opNewArray(TypeBearer typeBearer) {
        Rop rop;
        Type type = typeBearer.getType();
        switch (type.getComponentType().getBasicType()) {
            case 1:
                return NEW_ARRAY_BOOLEAN;
            case 2:
                return NEW_ARRAY_BYTE;
            case 3:
                return NEW_ARRAY_CHAR;
            case 4:
                return NEW_ARRAY_DOUBLE;
            case 5:
                return NEW_ARRAY_FLOAT;
            case 6:
                return NEW_ARRAY_INT;
            case 7:
                return NEW_ARRAY_LONG;
            case 8:
                return NEW_ARRAY_SHORT;
            case 9:
                Rop rop2 = rop;
                Rop rop3 = new Rop(41, type, (TypeList) StdTypeList.INT, (TypeList) Exceptions.LIST_Error_NegativeArraySizeException, "new-array-object");
                return rop2;
            default:
                return throwBadType(type);
        }
    }

    public static Rop opNot(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicFrameType()) {
            case 6:
                return NOT_INT;
            case 7:
                return NOT_LONG;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opOr(TypeList typeList) {
        return pickBinaryOp(typeList, OR_CONST_INT, OR_CONST_LONG, null, null, OR_INT, OR_LONG, null, null);
    }

    public static Rop opPutField(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicType()) {
            case 1:
                return PUT_FIELD_BOOLEAN;
            case 2:
                return PUT_FIELD_BYTE;
            case 3:
                return PUT_FIELD_CHAR;
            case 4:
                return PUT_FIELD_DOUBLE;
            case 5:
                return PUT_FIELD_FLOAT;
            case 6:
                return PUT_FIELD_INT;
            case 7:
                return PUT_FIELD_LONG;
            case 8:
                return PUT_FIELD_SHORT;
            case 9:
                return PUT_FIELD_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opPutStatic(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicType()) {
            case 1:
                return PUT_STATIC_BOOLEAN;
            case 2:
                return PUT_STATIC_BYTE;
            case 3:
                return PUT_STATIC_CHAR;
            case 4:
                return PUT_STATIC_DOUBLE;
            case 5:
                return PUT_STATIC_FLOAT;
            case 6:
                return PUT_STATIC_INT;
            case 7:
                return PUT_STATIC_LONG;
            case 8:
                return PUT_STATIC_SHORT;
            case 9:
                return PUT_STATIC_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opRem(TypeList typeList) {
        return pickBinaryOp(typeList, REM_CONST_INT, REM_CONST_LONG, REM_CONST_FLOAT, REM_CONST_DOUBLE, REM_INT, REM_LONG, REM_FLOAT, REM_DOUBLE);
    }

    public static Rop opReturn(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        switch (typeBearer2.getBasicFrameType()) {
            case 0:
                return RETURN_VOID;
            case 4:
                return RETURN_DOUBLE;
            case 5:
                return RETURN_FLOAT;
            case 6:
                return RETURN_INT;
            case 7:
                return RETURN_LONG;
            case 9:
                return RETURN_OBJECT;
            default:
                return throwBadType(typeBearer2);
        }
    }

    public static Rop opShl(TypeList typeList) {
        return pickBinaryOp(typeList, SHL_CONST_INT, SHL_CONST_LONG, null, null, SHL_INT, SHL_LONG, null, null);
    }

    public static Rop opShr(TypeList typeList) {
        return pickBinaryOp(typeList, SHR_CONST_INT, SHR_CONST_LONG, null, null, SHR_INT, SHR_LONG, null, null);
    }

    public static Rop opSub(TypeList typeList) {
        return pickBinaryOp(typeList, SUB_CONST_INT, SUB_CONST_LONG, SUB_CONST_FLOAT, SUB_CONST_DOUBLE, SUB_INT, SUB_LONG, SUB_FLOAT, SUB_DOUBLE);
    }

    public static Rop opUshr(TypeList typeList) {
        return pickBinaryOp(typeList, USHR_CONST_INT, USHR_CONST_LONG, null, null, USHR_INT, USHR_LONG, null, null);
    }

    public static Rop opXor(TypeList typeList) {
        return pickBinaryOp(typeList, XOR_CONST_INT, XOR_CONST_LONG, null, null, XOR_INT, XOR_LONG, null, null);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop pickBinaryOp(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList r12, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r13, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r14, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r15, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r16, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r17, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r18, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r19, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r20) {
        /*
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r10 = r0
            r11 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r10 = r10.getType(r11)
            int r10 = r10.getBasicFrameType()
            r9 = r10
            r10 = r0
            int r10 = r10.size()
            switch(r10) {
                case 1: goto L_0x002f;
                case 2: goto L_0x003e;
                default: goto L_0x0021;
            }
        L_0x0021:
            r10 = 0
            r1 = r10
        L_0x0023:
            r10 = r1
            if (r10 != 0) goto L_0x002c
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r10 = throwBadTypes(r10)
            r1 = r10
        L_0x002c:
            r10 = r1
            r0 = r10
        L_0x002e:
            return r0
        L_0x002f:
            r10 = r9
            switch(r10) {
                case 4: goto L_0x003b;
                case 5: goto L_0x0035;
                case 6: goto L_0x002c;
                case 7: goto L_0x0038;
                default: goto L_0x0033;
            }
        L_0x0033:
            r10 = 0
            r3 = r10
        L_0x0035:
            r10 = r3
            r1 = r10
            goto L_0x0023
        L_0x0038:
            r10 = r2
            r0 = r10
            goto L_0x002e
        L_0x003b:
            r10 = r4
            r3 = r10
            goto L_0x0035
        L_0x003e:
            r10 = r9
            switch(r10) {
                case 4: goto L_0x0043;
                case 5: goto L_0x004c;
                case 6: goto L_0x0046;
                case 7: goto L_0x0049;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x0021
        L_0x0043:
            r10 = r8
            r1 = r10
            goto L_0x0023
        L_0x0046:
            r10 = r5
            r0 = r10
            goto L_0x002e
        L_0x0049:
            r10 = r6
            r0 = r10
            goto L_0x002e
        L_0x004c:
            r10 = r7
            r1 = r10
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.pickBinaryOp(net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop):net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop");
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop pickIf(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList r9, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r10, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r11, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r12, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop r13) {
        /*
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r6 = r0
            int r6 = r6.size()
            switch(r6) {
                case 1: goto L_0x0016;
                case 2: goto L_0x002a;
                default: goto L_0x000d;
            }
        L_0x000d:
            r6 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r6 = throwBadTypes(r6)
            r1 = r6
        L_0x0013:
            r6 = r1
            r0 = r6
        L_0x0015:
            return r0
        L_0x0016:
            r6 = r0
            r7 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r6 = r6.getType(r7)
            int r6 = r6.getBasicFrameType()
            switch(r6) {
                case 6: goto L_0x0013;
                case 7: goto L_0x0023;
                case 8: goto L_0x0023;
                case 9: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x000d
        L_0x0024:
            r6 = r2
            if (r6 == 0) goto L_0x000d
            r6 = r2
            r0 = r6
            goto L_0x0015
        L_0x002a:
            r6 = r0
            r7 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r6 = r6.getType(r7)
            int r6 = r6.getBasicFrameType()
            r5 = r6
            r6 = r5
            r7 = r0
            r8 = 1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r7 = r7.getType(r8)
            int r7 = r7.getBasicFrameType()
            if (r6 != r7) goto L_0x000d
            r6 = r5
            switch(r6) {
                case 6: goto L_0x0047;
                case 7: goto L_0x0046;
                case 8: goto L_0x0046;
                case 9: goto L_0x004a;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x000d
        L_0x0047:
            r6 = r3
            r0 = r6
            goto L_0x0015
        L_0x004a:
            r6 = r4
            if (r6 == 0) goto L_0x000d
            r6 = r4
            r0 = r6
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.pickIf(net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop):net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop");
    }

    public static Rop ropFor(int i, TypeBearer typeBearer, TypeList typeList, Constant constant) {
        RuntimeException runtimeException;
        StringBuilder sb;
        int i2 = i;
        TypeBearer typeBearer2 = typeBearer;
        TypeList typeList2 = typeList;
        Constant constant2 = constant;
        switch (i2) {
            case 1:
                return NOP;
            case 2:
                return opMove(typeBearer2);
            case 3:
                return opMoveParam(typeBearer2);
            case 4:
                return opMoveException(typeBearer2);
            case 5:
                return opConst(typeBearer2);
            case 6:
                return GOTO;
            case 7:
                return opIfEq(typeList2);
            case 8:
                return opIfNe(typeList2);
            case 9:
                return opIfLt(typeList2);
            case 10:
                return opIfGe(typeList2);
            case 11:
                return opIfLe(typeList2);
            case 12:
                return opIfGt(typeList2);
            case 13:
                return SWITCH;
            case 14:
                return opAdd(typeList2);
            case 15:
                return opSub(typeList2);
            case 16:
                return opMul(typeList2);
            case 17:
                return opDiv(typeList2);
            case 18:
                return opRem(typeList2);
            case 19:
                return opNeg(typeBearer2);
            case 20:
                return opAnd(typeList2);
            case 21:
                return opOr(typeList2);
            case 22:
                return opXor(typeList2);
            case 23:
                return opShl(typeList2);
            case 24:
                return opShr(typeList2);
            case 25:
                return opUshr(typeList2);
            case 26:
                return opNot(typeBearer2);
            case 27:
                return opCmpl(typeList2.getType(0));
            case 28:
                return opCmpg(typeList2.getType(0));
            case 29:
                return opConv(typeBearer2, typeList2.getType(0));
            case 30:
                return TO_BYTE;
            case 31:
                return TO_CHAR;
            case 32:
                return TO_SHORT;
            case 33:
                return typeList2.size() == 0 ? RETURN_VOID : opReturn(typeList2.getType(0));
            case 34:
                return ARRAY_LENGTH;
            case 35:
                return THROW;
            case 36:
                return MONITOR_ENTER;
            case 37:
                return MONITOR_EXIT;
            case 38:
                Type type = typeList2.getType(0);
                return opAget(type == Type.KNOWN_NULL ? typeBearer2.getType() : type.getComponentType());
            case 39:
                Type type2 = typeList2.getType(1);
                return opAput(type2 == Type.KNOWN_NULL ? typeList2.getType(0) : type2.getComponentType());
            case 40:
                return NEW_INSTANCE;
            case 41:
                return opNewArray(typeBearer2.getType());
            case 43:
                return CHECK_CAST;
            case 44:
                return INSTANCE_OF;
            case 45:
                return opGetField(typeBearer2);
            case 46:
                return opGetStatic(typeBearer2);
            case 47:
                return opPutField(typeList2.getType(0));
            case 48:
                return opPutStatic(typeList2.getType(0));
            case 49:
                return opInvokeStatic(((CstMethodRef) constant2).getPrototype());
            case 50:
                CstMethodRef cstMethodRef = (CstMethodRef) constant2;
                return opInvokeVirtual(cstMethodRef.getPrototype().withFirstParameter(cstMethodRef.getDefiningClass().getClassType()));
            case 51:
                CstMethodRef cstMethodRef2 = (CstMethodRef) constant2;
                return opInvokeSuper(cstMethodRef2.getPrototype().withFirstParameter(cstMethodRef2.getDefiningClass().getClassType()));
            case 52:
                CstMethodRef cstMethodRef3 = (CstMethodRef) constant2;
                return opInvokeDirect(cstMethodRef3.getPrototype().withFirstParameter(cstMethodRef3.getDefiningClass().getClassType()));
            case 53:
                CstMethodRef cstMethodRef4 = (CstMethodRef) constant2;
                return opInvokeInterface(cstMethodRef4.getPrototype().withFirstParameter(cstMethodRef4.getDefiningClass().getClassType()));
            default:
                RuntimeException runtimeException2 = runtimeException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                RuntimeException runtimeException3 = new RuntimeException(sb2.append("unknown opcode ").append(RegOps.opName(i2)).toString());
                throw runtimeException2;
        }
    }

    private static Rop throwBadType(TypeBearer typeBearer) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        TypeBearer typeBearer2 = typeBearer;
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("bad type: ").append(typeBearer2).toString());
        throw illegalArgumentException2;
    }

    private static Rop throwBadTypes(TypeList typeList) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        TypeList typeList2 = typeList;
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("bad types: ").append(typeList2).toString());
        throw illegalArgumentException2;
    }
}

package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.HashMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.ThrowingCstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.RopToDop */
public final class RopToDop {
    private static final HashMap<Rop, Dop> MAP;

    static {
        HashMap<Rop, Dop> hashMap;
        HashMap<Rop, Dop> hashMap2 = hashMap;
        HashMap<Rop, Dop> hashMap3 = new HashMap<>(NativeDefinitions.KEY_YELLOW);
        MAP = hashMap2;
        Object put = MAP.put(Rops.NOP, Dops.NOP);
        Object put2 = MAP.put(Rops.MOVE_INT, Dops.MOVE);
        Object put3 = MAP.put(Rops.MOVE_LONG, Dops.MOVE_WIDE);
        Object put4 = MAP.put(Rops.MOVE_FLOAT, Dops.MOVE);
        Object put5 = MAP.put(Rops.MOVE_DOUBLE, Dops.MOVE_WIDE);
        Object put6 = MAP.put(Rops.MOVE_OBJECT, Dops.MOVE_OBJECT);
        Object put7 = MAP.put(Rops.MOVE_PARAM_INT, Dops.MOVE);
        Object put8 = MAP.put(Rops.MOVE_PARAM_LONG, Dops.MOVE_WIDE);
        Object put9 = MAP.put(Rops.MOVE_PARAM_FLOAT, Dops.MOVE);
        Object put10 = MAP.put(Rops.MOVE_PARAM_DOUBLE, Dops.MOVE_WIDE);
        Object put11 = MAP.put(Rops.MOVE_PARAM_OBJECT, Dops.MOVE_OBJECT);
        Object put12 = MAP.put(Rops.CONST_INT, Dops.CONST_4);
        Object put13 = MAP.put(Rops.CONST_LONG, Dops.CONST_WIDE_16);
        Object put14 = MAP.put(Rops.CONST_FLOAT, Dops.CONST_4);
        Object put15 = MAP.put(Rops.CONST_DOUBLE, Dops.CONST_WIDE_16);
        Object put16 = MAP.put(Rops.CONST_OBJECT_NOTHROW, Dops.CONST_4);
        Object put17 = MAP.put(Rops.GOTO, Dops.GOTO);
        Object put18 = MAP.put(Rops.IF_EQZ_INT, Dops.IF_EQZ);
        Object put19 = MAP.put(Rops.IF_NEZ_INT, Dops.IF_NEZ);
        Object put20 = MAP.put(Rops.IF_LTZ_INT, Dops.IF_LTZ);
        Object put21 = MAP.put(Rops.IF_GEZ_INT, Dops.IF_GEZ);
        Object put22 = MAP.put(Rops.IF_LEZ_INT, Dops.IF_LEZ);
        Object put23 = MAP.put(Rops.IF_GTZ_INT, Dops.IF_GTZ);
        Object put24 = MAP.put(Rops.IF_EQZ_OBJECT, Dops.IF_EQZ);
        Object put25 = MAP.put(Rops.IF_NEZ_OBJECT, Dops.IF_NEZ);
        Object put26 = MAP.put(Rops.IF_EQ_INT, Dops.IF_EQ);
        Object put27 = MAP.put(Rops.IF_NE_INT, Dops.IF_NE);
        Object put28 = MAP.put(Rops.IF_LT_INT, Dops.IF_LT);
        Object put29 = MAP.put(Rops.IF_GE_INT, Dops.IF_GE);
        Object put30 = MAP.put(Rops.IF_LE_INT, Dops.IF_LE);
        Object put31 = MAP.put(Rops.IF_GT_INT, Dops.IF_GT);
        Object put32 = MAP.put(Rops.IF_EQ_OBJECT, Dops.IF_EQ);
        Object put33 = MAP.put(Rops.IF_NE_OBJECT, Dops.IF_NE);
        Object put34 = MAP.put(Rops.SWITCH, Dops.SPARSE_SWITCH);
        Object put35 = MAP.put(Rops.ADD_INT, Dops.ADD_INT_2ADDR);
        Object put36 = MAP.put(Rops.ADD_LONG, Dops.ADD_LONG_2ADDR);
        Object put37 = MAP.put(Rops.ADD_FLOAT, Dops.ADD_FLOAT_2ADDR);
        Object put38 = MAP.put(Rops.ADD_DOUBLE, Dops.ADD_DOUBLE_2ADDR);
        Object put39 = MAP.put(Rops.SUB_INT, Dops.SUB_INT_2ADDR);
        Object put40 = MAP.put(Rops.SUB_LONG, Dops.SUB_LONG_2ADDR);
        Object put41 = MAP.put(Rops.SUB_FLOAT, Dops.SUB_FLOAT_2ADDR);
        Object put42 = MAP.put(Rops.SUB_DOUBLE, Dops.SUB_DOUBLE_2ADDR);
        Object put43 = MAP.put(Rops.MUL_INT, Dops.MUL_INT_2ADDR);
        Object put44 = MAP.put(Rops.MUL_LONG, Dops.MUL_LONG_2ADDR);
        Object put45 = MAP.put(Rops.MUL_FLOAT, Dops.MUL_FLOAT_2ADDR);
        Object put46 = MAP.put(Rops.MUL_DOUBLE, Dops.MUL_DOUBLE_2ADDR);
        Object put47 = MAP.put(Rops.DIV_INT, Dops.DIV_INT_2ADDR);
        Object put48 = MAP.put(Rops.DIV_LONG, Dops.DIV_LONG_2ADDR);
        Object put49 = MAP.put(Rops.DIV_FLOAT, Dops.DIV_FLOAT_2ADDR);
        Object put50 = MAP.put(Rops.DIV_DOUBLE, Dops.DIV_DOUBLE_2ADDR);
        Object put51 = MAP.put(Rops.REM_INT, Dops.REM_INT_2ADDR);
        Object put52 = MAP.put(Rops.REM_LONG, Dops.REM_LONG_2ADDR);
        Object put53 = MAP.put(Rops.REM_FLOAT, Dops.REM_FLOAT_2ADDR);
        Object put54 = MAP.put(Rops.REM_DOUBLE, Dops.REM_DOUBLE_2ADDR);
        Object put55 = MAP.put(Rops.NEG_INT, Dops.NEG_INT);
        Object put56 = MAP.put(Rops.NEG_LONG, Dops.NEG_LONG);
        Object put57 = MAP.put(Rops.NEG_FLOAT, Dops.NEG_FLOAT);
        Object put58 = MAP.put(Rops.NEG_DOUBLE, Dops.NEG_DOUBLE);
        Object put59 = MAP.put(Rops.AND_INT, Dops.AND_INT_2ADDR);
        Object put60 = MAP.put(Rops.AND_LONG, Dops.AND_LONG_2ADDR);
        Object put61 = MAP.put(Rops.OR_INT, Dops.OR_INT_2ADDR);
        Object put62 = MAP.put(Rops.OR_LONG, Dops.OR_LONG_2ADDR);
        Object put63 = MAP.put(Rops.XOR_INT, Dops.XOR_INT_2ADDR);
        Object put64 = MAP.put(Rops.XOR_LONG, Dops.XOR_LONG_2ADDR);
        Object put65 = MAP.put(Rops.SHL_INT, Dops.SHL_INT_2ADDR);
        Object put66 = MAP.put(Rops.SHL_LONG, Dops.SHL_LONG_2ADDR);
        Object put67 = MAP.put(Rops.SHR_INT, Dops.SHR_INT_2ADDR);
        Object put68 = MAP.put(Rops.SHR_LONG, Dops.SHR_LONG_2ADDR);
        Object put69 = MAP.put(Rops.USHR_INT, Dops.USHR_INT_2ADDR);
        Object put70 = MAP.put(Rops.USHR_LONG, Dops.USHR_LONG_2ADDR);
        Object put71 = MAP.put(Rops.NOT_INT, Dops.NOT_INT);
        Object put72 = MAP.put(Rops.NOT_LONG, Dops.NOT_LONG);
        Object put73 = MAP.put(Rops.ADD_CONST_INT, Dops.ADD_INT_LIT8);
        Object put74 = MAP.put(Rops.SUB_CONST_INT, Dops.RSUB_INT_LIT8);
        Object put75 = MAP.put(Rops.MUL_CONST_INT, Dops.MUL_INT_LIT8);
        Object put76 = MAP.put(Rops.DIV_CONST_INT, Dops.DIV_INT_LIT8);
        Object put77 = MAP.put(Rops.REM_CONST_INT, Dops.REM_INT_LIT8);
        Object put78 = MAP.put(Rops.AND_CONST_INT, Dops.AND_INT_LIT8);
        Object put79 = MAP.put(Rops.OR_CONST_INT, Dops.OR_INT_LIT8);
        Object put80 = MAP.put(Rops.XOR_CONST_INT, Dops.XOR_INT_LIT8);
        Object put81 = MAP.put(Rops.SHL_CONST_INT, Dops.SHL_INT_LIT8);
        Object put82 = MAP.put(Rops.SHR_CONST_INT, Dops.SHR_INT_LIT8);
        Object put83 = MAP.put(Rops.USHR_CONST_INT, Dops.USHR_INT_LIT8);
        Object put84 = MAP.put(Rops.CMPL_LONG, Dops.CMP_LONG);
        Object put85 = MAP.put(Rops.CMPL_FLOAT, Dops.CMPL_FLOAT);
        Object put86 = MAP.put(Rops.CMPL_DOUBLE, Dops.CMPL_DOUBLE);
        Object put87 = MAP.put(Rops.CMPG_FLOAT, Dops.CMPG_FLOAT);
        Object put88 = MAP.put(Rops.CMPG_DOUBLE, Dops.CMPG_DOUBLE);
        Object put89 = MAP.put(Rops.CONV_L2I, Dops.LONG_TO_INT);
        Object put90 = MAP.put(Rops.CONV_F2I, Dops.FLOAT_TO_INT);
        Object put91 = MAP.put(Rops.CONV_D2I, Dops.DOUBLE_TO_INT);
        Object put92 = MAP.put(Rops.CONV_I2L, Dops.INT_TO_LONG);
        Object put93 = MAP.put(Rops.CONV_F2L, Dops.FLOAT_TO_LONG);
        Object put94 = MAP.put(Rops.CONV_D2L, Dops.DOUBLE_TO_LONG);
        Object put95 = MAP.put(Rops.CONV_I2F, Dops.INT_TO_FLOAT);
        Object put96 = MAP.put(Rops.CONV_L2F, Dops.LONG_TO_FLOAT);
        Object put97 = MAP.put(Rops.CONV_D2F, Dops.DOUBLE_TO_FLOAT);
        Object put98 = MAP.put(Rops.CONV_I2D, Dops.INT_TO_DOUBLE);
        Object put99 = MAP.put(Rops.CONV_L2D, Dops.LONG_TO_DOUBLE);
        Object put100 = MAP.put(Rops.CONV_F2D, Dops.FLOAT_TO_DOUBLE);
        Object put101 = MAP.put(Rops.TO_BYTE, Dops.INT_TO_BYTE);
        Object put102 = MAP.put(Rops.TO_CHAR, Dops.INT_TO_CHAR);
        Object put103 = MAP.put(Rops.TO_SHORT, Dops.INT_TO_SHORT);
        Object put104 = MAP.put(Rops.RETURN_VOID, Dops.RETURN_VOID);
        Object put105 = MAP.put(Rops.RETURN_INT, Dops.RETURN);
        Object put106 = MAP.put(Rops.RETURN_LONG, Dops.RETURN_WIDE);
        Object put107 = MAP.put(Rops.RETURN_FLOAT, Dops.RETURN);
        Object put108 = MAP.put(Rops.RETURN_DOUBLE, Dops.RETURN_WIDE);
        Object put109 = MAP.put(Rops.RETURN_OBJECT, Dops.RETURN_OBJECT);
        Object put110 = MAP.put(Rops.ARRAY_LENGTH, Dops.ARRAY_LENGTH);
        Object put111 = MAP.put(Rops.THROW, Dops.THROW);
        Object put112 = MAP.put(Rops.MONITOR_ENTER, Dops.MONITOR_ENTER);
        Object put113 = MAP.put(Rops.MONITOR_EXIT, Dops.MONITOR_EXIT);
        Object put114 = MAP.put(Rops.AGET_INT, Dops.AGET);
        Object put115 = MAP.put(Rops.AGET_LONG, Dops.AGET_WIDE);
        Object put116 = MAP.put(Rops.AGET_FLOAT, Dops.AGET);
        Object put117 = MAP.put(Rops.AGET_DOUBLE, Dops.AGET_WIDE);
        Object put118 = MAP.put(Rops.AGET_OBJECT, Dops.AGET_OBJECT);
        Object put119 = MAP.put(Rops.AGET_BOOLEAN, Dops.AGET_BOOLEAN);
        Object put120 = MAP.put(Rops.AGET_BYTE, Dops.AGET_BYTE);
        Object put121 = MAP.put(Rops.AGET_CHAR, Dops.AGET_CHAR);
        Object put122 = MAP.put(Rops.AGET_SHORT, Dops.AGET_SHORT);
        Object put123 = MAP.put(Rops.APUT_INT, Dops.APUT);
        Object put124 = MAP.put(Rops.APUT_LONG, Dops.APUT_WIDE);
        Object put125 = MAP.put(Rops.APUT_FLOAT, Dops.APUT);
        Object put126 = MAP.put(Rops.APUT_DOUBLE, Dops.APUT_WIDE);
        Object put127 = MAP.put(Rops.APUT_OBJECT, Dops.APUT_OBJECT);
        Object put128 = MAP.put(Rops.APUT_BOOLEAN, Dops.APUT_BOOLEAN);
        Object put129 = MAP.put(Rops.APUT_BYTE, Dops.APUT_BYTE);
        Object put130 = MAP.put(Rops.APUT_CHAR, Dops.APUT_CHAR);
        Object put131 = MAP.put(Rops.APUT_SHORT, Dops.APUT_SHORT);
        Object put132 = MAP.put(Rops.NEW_INSTANCE, Dops.NEW_INSTANCE);
        Object put133 = MAP.put(Rops.CHECK_CAST, Dops.CHECK_CAST);
        Object put134 = MAP.put(Rops.INSTANCE_OF, Dops.INSTANCE_OF);
        Object put135 = MAP.put(Rops.GET_FIELD_LONG, Dops.IGET_WIDE);
        Object put136 = MAP.put(Rops.GET_FIELD_FLOAT, Dops.IGET);
        Object put137 = MAP.put(Rops.GET_FIELD_DOUBLE, Dops.IGET_WIDE);
        Object put138 = MAP.put(Rops.GET_FIELD_OBJECT, Dops.IGET_OBJECT);
        Object put139 = MAP.put(Rops.GET_STATIC_LONG, Dops.SGET_WIDE);
        Object put140 = MAP.put(Rops.GET_STATIC_FLOAT, Dops.SGET);
        Object put141 = MAP.put(Rops.GET_STATIC_DOUBLE, Dops.SGET_WIDE);
        Object put142 = MAP.put(Rops.GET_STATIC_OBJECT, Dops.SGET_OBJECT);
        Object put143 = MAP.put(Rops.PUT_FIELD_LONG, Dops.IPUT_WIDE);
        Object put144 = MAP.put(Rops.PUT_FIELD_FLOAT, Dops.IPUT);
        Object put145 = MAP.put(Rops.PUT_FIELD_DOUBLE, Dops.IPUT_WIDE);
        Object put146 = MAP.put(Rops.PUT_FIELD_OBJECT, Dops.IPUT_OBJECT);
        Object put147 = MAP.put(Rops.PUT_STATIC_LONG, Dops.SPUT_WIDE);
        Object put148 = MAP.put(Rops.PUT_STATIC_FLOAT, Dops.SPUT);
        Object put149 = MAP.put(Rops.PUT_STATIC_DOUBLE, Dops.SPUT_WIDE);
        Object put150 = MAP.put(Rops.PUT_STATIC_OBJECT, Dops.SPUT_OBJECT);
    }

    private RopToDop() {
    }

    public static Dop dopFor(Insn insn) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        StringBuilder sb;
        Insn insn2 = insn;
        Rop opcode = insn2.getOpcode();
        Dop dop = (Dop) MAP.get(opcode);
        if (dop != null) {
            return dop;
        }
        switch (opcode.getOpcode()) {
            case 4:
                return Dops.MOVE_EXCEPTION;
            case 5:
                Constant constant = ((ThrowingCstInsn) insn2).getConstant();
                if (constant instanceof CstType) {
                    return Dops.CONST_CLASS;
                }
                if (constant instanceof CstString) {
                    return Dops.CONST_STRING;
                }
                break;
            case 41:
                return Dops.NEW_ARRAY;
            case 42:
                return Dops.FILLED_NEW_ARRAY;
            case 45:
                switch (((CstFieldRef) ((ThrowingCstInsn) insn2).getConstant()).getBasicType()) {
                    case 1:
                        return Dops.IGET_BOOLEAN;
                    case 2:
                        return Dops.IGET_BYTE;
                    case 3:
                        return Dops.IGET_CHAR;
                    case 6:
                        return Dops.IGET;
                    case 8:
                        return Dops.IGET_SHORT;
                }
            case 46:
                switch (((CstFieldRef) ((ThrowingCstInsn) insn2).getConstant()).getBasicType()) {
                    case 1:
                        return Dops.SGET_BOOLEAN;
                    case 2:
                        return Dops.SGET_BYTE;
                    case 3:
                        return Dops.SGET_CHAR;
                    case 6:
                        return Dops.SGET;
                    case 8:
                        return Dops.SGET_SHORT;
                }
            case 47:
                switch (((CstFieldRef) ((ThrowingCstInsn) insn2).getConstant()).getBasicType()) {
                    case 1:
                        return Dops.IPUT_BOOLEAN;
                    case 2:
                        return Dops.IPUT_BYTE;
                    case 3:
                        return Dops.IPUT_CHAR;
                    case 6:
                        return Dops.IPUT;
                    case 8:
                        return Dops.IPUT_SHORT;
                }
            case 48:
                switch (((CstFieldRef) ((ThrowingCstInsn) insn2).getConstant()).getBasicType()) {
                    case 1:
                        return Dops.SPUT_BOOLEAN;
                    case 2:
                        return Dops.SPUT_BYTE;
                    case 3:
                        return Dops.SPUT_CHAR;
                    case 6:
                        return Dops.SPUT;
                    case 8:
                        return Dops.SPUT_SHORT;
                }
            case 49:
                return Dops.INVOKE_STATIC;
            case 50:
                return Dops.INVOKE_VIRTUAL;
            case 51:
                return Dops.INVOKE_SUPER;
            case 52:
                return Dops.INVOKE_DIRECT;
            case 53:
                return Dops.INVOKE_INTERFACE;
            case 55:
                RegisterSpec result = insn2.getResult();
                if (result == null) {
                    return Dops.NOP;
                }
                switch (result.getBasicType()) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                        return Dops.MOVE_RESULT;
                    case 4:
                    case 7:
                        return Dops.MOVE_RESULT_WIDE;
                    case 9:
                        return Dops.MOVE_RESULT_OBJECT;
                    default:
                        RuntimeException runtimeException3 = runtimeException;
                        RuntimeException runtimeException4 = new RuntimeException("Unexpected basic type");
                        throw runtimeException3;
                }
            case 57:
                return Dops.FILL_ARRAY_DATA;
        }
        RuntimeException runtimeException5 = runtimeException2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        RuntimeException runtimeException6 = new RuntimeException(sb2.append("unknown rop: ").append(opcode).toString());
        throw runtimeException5;
    }
}

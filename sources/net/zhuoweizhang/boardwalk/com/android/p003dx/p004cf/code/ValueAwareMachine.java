package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ValueAwareMachine */
public class ValueAwareMachine extends BaseMachine {
    public ValueAwareMachine(Prototype prototype) {
        super(prototype);
    }

    public void run(Frame frame, int i, int i2) {
        ReturnAddress returnAddress;
        RuntimeException runtimeException;
        StringBuilder sb;
        Frame frame2 = frame;
        int i3 = i;
        int i4 = i2;
        switch (i4) {
            case 0:
            case 79:
            case 87:
            case 88:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 169:
            case 171:
            case 172:
            case 177:
            case 179:
            case 181:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                clearResult();
                break;
            case 18:
            case 20:
                setResult((TypeBearer) getAuxCst());
                break;
            case 21:
            case 54:
                setResult(arg(0));
                break;
            case 46:
            case 96:
            case 100:
            case 104:
            case 108:
            case 112:
            case 116:
            case 120:
            case 122:
            case 124:
            case 126:
            case 128:
            case 130:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 190:
                setResult(getAuxType());
                break;
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                clearResult();
                int auxInt = getAuxInt();
                while (true) {
                    int i5 = auxInt;
                    if (i5 == 0) {
                        break;
                    } else {
                        addResult(arg(-1 + (i5 & 15)));
                        auxInt = i5 >> 4;
                    }
                }
            case 168:
                ReturnAddress returnAddress2 = returnAddress;
                ReturnAddress returnAddress3 = new ReturnAddress(getAuxTarget());
                setResult(returnAddress2);
                break;
            case 178:
            case 180:
            case 182:
            case 184:
            case 185:
                Type type = ((TypeBearer) getAuxCst()).getType();
                if (type != Type.VOID) {
                    setResult(type);
                    break;
                } else {
                    clearResult();
                    break;
                }
            case 183:
                Type type2 = arg(0).getType();
                if (type2.isUninitialized()) {
                    frame2.makeInitialized(type2);
                }
                Type type3 = ((TypeBearer) getAuxCst()).getType();
                if (type3 != Type.VOID) {
                    setResult(type3);
                    break;
                } else {
                    clearResult();
                    break;
                }
            case 187:
                setResult(((CstType) getAuxCst()).getClassType().asUninitialized(i3));
                break;
            case 188:
            case 192:
            case 197:
                setResult(((CstType) getAuxCst()).getClassType());
                break;
            case 189:
                setResult(((CstType) getAuxCst()).getClassType().getArrayType());
                break;
            case 193:
                setResult(Type.INT);
                break;
            default:
                RuntimeException runtimeException2 = runtimeException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                RuntimeException runtimeException3 = new RuntimeException(sb2.append("shouldn't happen: ").append(Hex.m50u1(i4)).toString());
                throw runtimeException2;
        }
        storeResults(frame2);
    }
}

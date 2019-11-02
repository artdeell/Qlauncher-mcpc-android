package net.java.games.input;

import android.support.p000v4.p002os.EnvironmentCompat;

public interface Component {

    public static class Identifier {
        private final String name;

        public static class Axis extends Identifier {
            public static final Axis POV;

            /* renamed from: RX */
            public static final Axis f28RX;
            public static final Axis RX_ACCELERATION;
            public static final Axis RX_FORCE;
            public static final Axis RX_VELOCITY;

            /* renamed from: RY */
            public static final Axis f29RY;
            public static final Axis RY_ACCELERATION;
            public static final Axis RY_FORCE;
            public static final Axis RY_VELOCITY;

            /* renamed from: RZ */
            public static final Axis f30RZ;
            public static final Axis RZ_ACCELERATION;
            public static final Axis RZ_FORCE;
            public static final Axis RZ_VELOCITY;
            public static final Axis SLIDER;
            public static final Axis SLIDER_ACCELERATION;
            public static final Axis SLIDER_FORCE;
            public static final Axis SLIDER_VELOCITY;
            public static final Axis UNKNOWN;

            /* renamed from: X */
            public static final Axis f31X;
            public static final Axis X_ACCELERATION;
            public static final Axis X_FORCE;
            public static final Axis X_VELOCITY;

            /* renamed from: Y */
            public static final Axis f32Y;
            public static final Axis Y_ACCELERATION;
            public static final Axis Y_FORCE;
            public static final Axis Y_VELOCITY;

            /* renamed from: Z */
            public static final Axis f33Z;
            public static final Axis Z_ACCELERATION;
            public static final Axis Z_FORCE;
            public static final Axis Z_VELOCITY;

            static {
                Axis axis;
                Axis axis2;
                Axis axis3;
                Axis axis4;
                Axis axis5;
                Axis axis6;
                Axis axis7;
                Axis axis8;
                Axis axis9;
                Axis axis10;
                Axis axis11;
                Axis axis12;
                Axis axis13;
                Axis axis14;
                Axis axis15;
                Axis axis16;
                Axis axis17;
                Axis axis18;
                Axis axis19;
                Axis axis20;
                Axis axis21;
                Axis axis22;
                Axis axis23;
                Axis axis24;
                Axis axis25;
                Axis axis26;
                Axis axis27;
                Axis axis28;
                Axis axis29;
                Axis axis30;
                Axis axis31 = axis;
                Axis axis32 = new Axis("x");
                f31X = axis31;
                Axis axis33 = axis2;
                Axis axis34 = new Axis("y");
                f32Y = axis33;
                Axis axis35 = axis3;
                Axis axis36 = new Axis("z");
                f33Z = axis35;
                Axis axis37 = axis4;
                Axis axis38 = new Axis("rx");
                f28RX = axis37;
                Axis axis39 = axis5;
                Axis axis40 = new Axis("ry");
                f29RY = axis39;
                Axis axis41 = axis6;
                Axis axis42 = new Axis("rz");
                f30RZ = axis41;
                Axis axis43 = axis7;
                Axis axis44 = new Axis("slider");
                SLIDER = axis43;
                Axis axis45 = axis8;
                Axis axis46 = new Axis("slider-acceleration");
                SLIDER_ACCELERATION = axis45;
                Axis axis47 = axis9;
                Axis axis48 = new Axis("slider-force");
                SLIDER_FORCE = axis47;
                Axis axis49 = axis10;
                Axis axis50 = new Axis("slider-velocity");
                SLIDER_VELOCITY = axis49;
                Axis axis51 = axis11;
                Axis axis52 = new Axis("x-acceleration");
                X_ACCELERATION = axis51;
                Axis axis53 = axis12;
                Axis axis54 = new Axis("x-force");
                X_FORCE = axis53;
                Axis axis55 = axis13;
                Axis axis56 = new Axis("x-velocity");
                X_VELOCITY = axis55;
                Axis axis57 = axis14;
                Axis axis58 = new Axis("y-acceleration");
                Y_ACCELERATION = axis57;
                Axis axis59 = axis15;
                Axis axis60 = new Axis("y-force");
                Y_FORCE = axis59;
                Axis axis61 = axis16;
                Axis axis62 = new Axis("y-velocity");
                Y_VELOCITY = axis61;
                Axis axis63 = axis17;
                Axis axis64 = new Axis("z-acceleration");
                Z_ACCELERATION = axis63;
                Axis axis65 = axis18;
                Axis axis66 = new Axis("z-force");
                Z_FORCE = axis65;
                Axis axis67 = axis19;
                Axis axis68 = new Axis("z-velocity");
                Z_VELOCITY = axis67;
                Axis axis69 = axis20;
                Axis axis70 = new Axis("rx-acceleration");
                RX_ACCELERATION = axis69;
                Axis axis71 = axis21;
                Axis axis72 = new Axis("rx-force");
                RX_FORCE = axis71;
                Axis axis73 = axis22;
                Axis axis74 = new Axis("rx-velocity");
                RX_VELOCITY = axis73;
                Axis axis75 = axis23;
                Axis axis76 = new Axis("ry-acceleration");
                RY_ACCELERATION = axis75;
                Axis axis77 = axis24;
                Axis axis78 = new Axis("ry-force");
                RY_FORCE = axis77;
                Axis axis79 = axis25;
                Axis axis80 = new Axis("ry-velocity");
                RY_VELOCITY = axis79;
                Axis axis81 = axis26;
                Axis axis82 = new Axis("rz-acceleration");
                RZ_ACCELERATION = axis81;
                Axis axis83 = axis27;
                Axis axis84 = new Axis("rz-force");
                RZ_FORCE = axis83;
                Axis axis85 = axis28;
                Axis axis86 = new Axis("rz-velocity");
                RZ_VELOCITY = axis85;
                Axis axis87 = axis29;
                Axis axis88 = new Axis("pov");
                POV = axis87;
                Axis axis89 = axis30;
                Axis axis90 = new Axis(EnvironmentCompat.MEDIA_UNKNOWN);
                UNKNOWN = axis89;
            }

            protected Axis(String str) {
                super(str);
            }
        }

        public static class Button extends Identifier {

            /* renamed from: A */
            public static final Button f34A;

            /* renamed from: B */
            public static final Button f35B;
            public static final Button BACK;
            public static final Button BASE;
            public static final Button BASE2;
            public static final Button BASE3;
            public static final Button BASE4;
            public static final Button BASE5;
            public static final Button BASE6;

            /* renamed from: C */
            public static final Button f36C;
            public static final Button DEAD;
            public static final Button EXTRA;
            public static final Button FORWARD;
            public static final Button LEFT;
            public static final Button LEFT_THUMB;
            public static final Button LEFT_THUMB2;
            public static final Button LEFT_THUMB3;
            public static final Button MIDDLE;
            public static final Button MODE;
            public static final Button PINKIE;
            public static final Button RIGHT;
            public static final Button RIGHT_THUMB;
            public static final Button RIGHT_THUMB2;
            public static final Button RIGHT_THUMB3;
            public static final Button SELECT;
            public static final Button SIDE;
            public static final Button STYLUS;
            public static final Button STYLUS2;
            public static final Button THUMB;
            public static final Button THUMB2;
            public static final Button TOOL_AIRBRUSH;
            public static final Button TOOL_BRUSH;
            public static final Button TOOL_FINGER;
            public static final Button TOOL_LENS;
            public static final Button TOOL_MOUSE;
            public static final Button TOOL_PEN;
            public static final Button TOOL_PENCIL;
            public static final Button TOOL_RUBBER;
            public static final Button TOP;
            public static final Button TOP2;
            public static final Button TOUCH;
            public static final Button TRIGGER;
            public static final Button UNKNOWN;

            /* renamed from: X */
            public static final Button f37X;

            /* renamed from: Y */
            public static final Button f38Y;

            /* renamed from: Z */
            public static final Button f39Z;

            /* renamed from: _0 */
            public static final Button f40_0;

            /* renamed from: _1 */
            public static final Button f41_1;
            public static final Button _10;
            public static final Button _11;
            public static final Button _12;
            public static final Button _13;
            public static final Button _14;
            public static final Button _15;
            public static final Button _16;
            public static final Button _17;
            public static final Button _18;
            public static final Button _19;

            /* renamed from: _2 */
            public static final Button f42_2;
            public static final Button _20;
            public static final Button _21;
            public static final Button _22;
            public static final Button _23;
            public static final Button _24;
            public static final Button _25;
            public static final Button _26;
            public static final Button _27;
            public static final Button _28;
            public static final Button _29;

            /* renamed from: _3 */
            public static final Button f43_3;
            public static final Button _30;
            public static final Button _31;

            /* renamed from: _4 */
            public static final Button f44_4;

            /* renamed from: _5 */
            public static final Button f45_5;

            /* renamed from: _6 */
            public static final Button f46_6;

            /* renamed from: _7 */
            public static final Button f47_7;

            /* renamed from: _8 */
            public static final Button f48_8;

            /* renamed from: _9 */
            public static final Button f49_9;

            static {
                Button button;
                Button button2;
                Button button3;
                Button button4;
                Button button5;
                Button button6;
                Button button7;
                Button button8;
                Button button9;
                Button button10;
                Button button11;
                Button button12;
                Button button13;
                Button button14;
                Button button15;
                Button button16;
                Button button17;
                Button button18;
                Button button19;
                Button button20;
                Button button21;
                Button button22;
                Button button23;
                Button button24;
                Button button25;
                Button button26;
                Button button27;
                Button button28;
                Button button29;
                Button button30;
                Button button31;
                Button button32;
                Button button33;
                Button button34;
                Button button35;
                Button button36;
                Button button37;
                Button button38;
                Button button39;
                Button button40;
                Button button41;
                Button button42;
                Button button43;
                Button button44;
                Button button45;
                Button button46;
                Button button47;
                Button button48;
                Button button49;
                Button button50;
                Button button51;
                Button button52;
                Button button53;
                Button button54;
                Button button55;
                Button button56;
                Button button57;
                Button button58;
                Button button59;
                Button button60;
                Button button61;
                Button button62;
                Button button63;
                Button button64;
                Button button65;
                Button button66;
                Button button67;
                Button button68;
                Button button69;
                Button button70;
                Button button71;
                Button button72;
                Button button73;
                Button button74;
                Button button75;
                Button button76;
                Button button77;
                Button button78;
                Button button79 = button;
                Button button80 = new Button("0");
                f40_0 = button79;
                Button button81 = button2;
                Button button82 = new Button("1");
                f41_1 = button81;
                Button button83 = button3;
                Button button84 = new Button("2");
                f42_2 = button83;
                Button button85 = button4;
                Button button86 = new Button("3");
                f43_3 = button85;
                Button button87 = button5;
                Button button88 = new Button("4");
                f44_4 = button87;
                Button button89 = button6;
                Button button90 = new Button("5");
                f45_5 = button89;
                Button button91 = button7;
                Button button92 = new Button("6");
                f46_6 = button91;
                Button button93 = button8;
                Button button94 = new Button("7");
                f47_7 = button93;
                Button button95 = button9;
                Button button96 = new Button("8");
                f48_8 = button95;
                Button button97 = button10;
                Button button98 = new Button("9");
                f49_9 = button97;
                Button button99 = button11;
                Button button100 = new Button("10");
                _10 = button99;
                Button button101 = button12;
                Button button102 = new Button("11");
                _11 = button101;
                Button button103 = button13;
                Button button104 = new Button("12");
                _12 = button103;
                Button button105 = button14;
                Button button106 = new Button("13");
                _13 = button105;
                Button button107 = button15;
                Button button108 = new Button("14");
                _14 = button107;
                Button button109 = button16;
                Button button110 = new Button("15");
                _15 = button109;
                Button button111 = button17;
                Button button112 = new Button("16");
                _16 = button111;
                Button button113 = button18;
                Button button114 = new Button("17");
                _17 = button113;
                Button button115 = button19;
                Button button116 = new Button("18");
                _18 = button115;
                Button button117 = button20;
                Button button118 = new Button("19");
                _19 = button117;
                Button button119 = button21;
                Button button120 = new Button("20");
                _20 = button119;
                Button button121 = button22;
                Button button122 = new Button("21");
                _21 = button121;
                Button button123 = button23;
                Button button124 = new Button("22");
                _22 = button123;
                Button button125 = button24;
                Button button126 = new Button("23");
                _23 = button125;
                Button button127 = button25;
                Button button128 = new Button("24");
                _24 = button127;
                Button button129 = button26;
                Button button130 = new Button("25");
                _25 = button129;
                Button button131 = button27;
                Button button132 = new Button("26");
                _26 = button131;
                Button button133 = button28;
                Button button134 = new Button("27");
                _27 = button133;
                Button button135 = button29;
                Button button136 = new Button("28");
                _28 = button135;
                Button button137 = button30;
                Button button138 = new Button("29");
                _29 = button137;
                Button button139 = button31;
                Button button140 = new Button("30");
                _30 = button139;
                Button button141 = button32;
                Button button142 = new Button("31");
                _31 = button141;
                Button button143 = button33;
                Button button144 = new Button("Trigger");
                TRIGGER = button143;
                Button button145 = button34;
                Button button146 = new Button("Thumb");
                THUMB = button145;
                Button button147 = button35;
                Button button148 = new Button("Thumb 2");
                THUMB2 = button147;
                Button button149 = button36;
                Button button150 = new Button("Top");
                TOP = button149;
                Button button151 = button37;
                Button button152 = new Button("Top 2");
                TOP2 = button151;
                Button button153 = button38;
                Button button154 = new Button("Pinkie");
                PINKIE = button153;
                Button button155 = button39;
                Button button156 = new Button("Base");
                BASE = button155;
                Button button157 = button40;
                Button button158 = new Button("Base 2");
                BASE2 = button157;
                Button button159 = button41;
                Button button160 = new Button("Base 3");
                BASE3 = button159;
                Button button161 = button42;
                Button button162 = new Button("Base 4");
                BASE4 = button161;
                Button button163 = button43;
                Button button164 = new Button("Base 5");
                BASE5 = button163;
                Button button165 = button44;
                Button button166 = new Button("Base 6");
                BASE6 = button165;
                Button button167 = button45;
                Button button168 = new Button("Dead");
                DEAD = button167;
                Button button169 = button46;
                Button button170 = new Button("A");
                f34A = button169;
                Button button171 = button47;
                Button button172 = new Button("B");
                f35B = button171;
                Button button173 = button48;
                Button button174 = new Button("C");
                f36C = button173;
                Button button175 = button49;
                Button button176 = new Button("X");
                f37X = button175;
                Button button177 = button50;
                Button button178 = new Button("Y");
                f38Y = button177;
                Button button179 = button51;
                Button button180 = new Button("Z");
                f39Z = button179;
                Button button181 = button52;
                Button button182 = new Button("Left Thumb");
                LEFT_THUMB = button181;
                Button button183 = button53;
                Button button184 = new Button("Right Thumb");
                RIGHT_THUMB = button183;
                Button button185 = button54;
                Button button186 = new Button("Left Thumb 2");
                LEFT_THUMB2 = button185;
                Button button187 = button55;
                Button button188 = new Button("Right Thumb 2");
                RIGHT_THUMB2 = button187;
                Button button189 = button56;
                Button button190 = new Button("Select");
                SELECT = button189;
                Button button191 = button57;
                Button button192 = new Button("Mode");
                MODE = button191;
                Button button193 = button58;
                Button button194 = new Button("Left Thumb 3");
                LEFT_THUMB3 = button193;
                Button button195 = button59;
                Button button196 = new Button("Right Thumb 3");
                RIGHT_THUMB3 = button195;
                Button button197 = button60;
                Button button198 = new Button("Pen");
                TOOL_PEN = button197;
                Button button199 = button61;
                Button button200 = new Button("Rubber");
                TOOL_RUBBER = button199;
                Button button201 = button62;
                Button button202 = new Button("Brush");
                TOOL_BRUSH = button201;
                Button button203 = button63;
                Button button204 = new Button("Pencil");
                TOOL_PENCIL = button203;
                Button button205 = button64;
                Button button206 = new Button("Airbrush");
                TOOL_AIRBRUSH = button205;
                Button button207 = button65;
                Button button208 = new Button("Finger");
                TOOL_FINGER = button207;
                Button button209 = button66;
                Button button210 = new Button("Mouse");
                TOOL_MOUSE = button209;
                Button button211 = button67;
                Button button212 = new Button("Lens");
                TOOL_LENS = button211;
                Button button213 = button68;
                Button button214 = new Button("Touch");
                TOUCH = button213;
                Button button215 = button69;
                Button button216 = new Button("Stylus");
                STYLUS = button215;
                Button button217 = button70;
                Button button218 = new Button("Stylus 2");
                STYLUS2 = button217;
                Button button219 = button71;
                Button button220 = new Button("Unknown");
                UNKNOWN = button219;
                Button button221 = button72;
                Button button222 = new Button("Back");
                BACK = button221;
                Button button223 = button73;
                Button button224 = new Button("Extra");
                EXTRA = button223;
                Button button225 = button74;
                Button button226 = new Button("Forward");
                FORWARD = button225;
                Button button227 = button75;
                Button button228 = new Button("Left");
                LEFT = button227;
                Button button229 = button76;
                Button button230 = new Button("Middle");
                MIDDLE = button229;
                Button button231 = button77;
                Button button232 = new Button("Right");
                RIGHT = button231;
                Button button233 = button78;
                Button button234 = new Button("Side");
                SIDE = button233;
            }

            public Button(String str) {
                super(str);
            }
        }

        public static class Key extends Identifier {

            /* renamed from: A */
            public static final Key f50A;
            public static final Key ADD;
            public static final Key APOSTROPHE;
            public static final Key APPS;

            /* renamed from: AT */
            public static final Key f51AT;

            /* renamed from: AX */
            public static final Key f52AX;

            /* renamed from: B */
            public static final Key f53B;
            public static final Key BACK;
            public static final Key BACKSLASH;

            /* renamed from: C */
            public static final Key f54C;
            public static final Key CAPITAL;
            public static final Key CIRCUMFLEX;
            public static final Key COLON;
            public static final Key COMMA;
            public static final Key CONVERT;

            /* renamed from: D */
            public static final Key f55D;
            public static final Key DECIMAL;
            public static final Key DELETE;
            public static final Key DIVIDE;
            public static final Key DOWN;

            /* renamed from: E */
            public static final Key f56E;
            public static final Key END;
            public static final Key EQUALS;
            public static final Key ESCAPE;

            /* renamed from: F */
            public static final Key f57F;

            /* renamed from: F1 */
            public static final Key f58F1;
            public static final Key F10;
            public static final Key F11;
            public static final Key F12;
            public static final Key F13;
            public static final Key F14;
            public static final Key F15;

            /* renamed from: F2 */
            public static final Key f59F2;

            /* renamed from: F3 */
            public static final Key f60F3;

            /* renamed from: F4 */
            public static final Key f61F4;

            /* renamed from: F5 */
            public static final Key f62F5;

            /* renamed from: F6 */
            public static final Key f63F6;

            /* renamed from: F7 */
            public static final Key f64F7;

            /* renamed from: F8 */
            public static final Key f65F8;

            /* renamed from: F9 */
            public static final Key f66F9;

            /* renamed from: G */
            public static final Key f67G;
            public static final Key GRAVE;

            /* renamed from: H */
            public static final Key f68H;
            public static final Key HOME;

            /* renamed from: I */
            public static final Key f69I;
            public static final Key INSERT;

            /* renamed from: J */
            public static final Key f70J;

            /* renamed from: K */
            public static final Key f71K;
            public static final Key KANA;
            public static final Key KANJI;

            /* renamed from: L */
            public static final Key f72L;
            public static final Key LALT;
            public static final Key LBRACKET;
            public static final Key LCONTROL;
            public static final Key LEFT;
            public static final Key LSHIFT;
            public static final Key LWIN;

            /* renamed from: M */
            public static final Key f73M;
            public static final Key MINUS;
            public static final Key MULTIPLY;

            /* renamed from: N */
            public static final Key f74N;
            public static final Key NOCONVERT;
            public static final Key NUMLOCK;
            public static final Key NUMPAD0;
            public static final Key NUMPAD1;
            public static final Key NUMPAD2;
            public static final Key NUMPAD3;
            public static final Key NUMPAD4;
            public static final Key NUMPAD5;
            public static final Key NUMPAD6;
            public static final Key NUMPAD7;
            public static final Key NUMPAD8;
            public static final Key NUMPAD9;
            public static final Key NUMPADCOMMA;
            public static final Key NUMPADENTER;
            public static final Key NUMPADEQUAL;

            /* renamed from: O */
            public static final Key f75O;

            /* renamed from: P */
            public static final Key f76P;
            public static final Key PAGEDOWN;
            public static final Key PAGEUP;
            public static final Key PAUSE;
            public static final Key PERIOD;
            public static final Key POWER;

            /* renamed from: Q */
            public static final Key f77Q;

            /* renamed from: R */
            public static final Key f78R;
            public static final Key RALT;
            public static final Key RBRACKET;
            public static final Key RCONTROL;
            public static final Key RETURN;
            public static final Key RIGHT;
            public static final Key RSHIFT;
            public static final Key RWIN;

            /* renamed from: S */
            public static final Key f79S;
            public static final Key SCROLL;
            public static final Key SEMICOLON;
            public static final Key SLASH;
            public static final Key SLEEP;
            public static final Key SPACE;
            public static final Key STOP;
            public static final Key SUBTRACT;
            public static final Key SYSRQ;

            /* renamed from: T */
            public static final Key f80T;
            public static final Key TAB;

            /* renamed from: U */
            public static final Key f81U;
            public static final Key UNDERLINE;
            public static final Key UNKNOWN;
            public static final Key UNLABELED;

            /* renamed from: UP */
            public static final Key f82UP;

            /* renamed from: V */
            public static final Key f83V;
            public static final Key VOID;

            /* renamed from: W */
            public static final Key f84W;

            /* renamed from: X */
            public static final Key f85X;

            /* renamed from: Y */
            public static final Key f86Y;
            public static final Key YEN;

            /* renamed from: Z */
            public static final Key f87Z;

            /* renamed from: _0 */
            public static final Key f88_0;

            /* renamed from: _1 */
            public static final Key f89_1;

            /* renamed from: _2 */
            public static final Key f90_2;

            /* renamed from: _3 */
            public static final Key f91_3;

            /* renamed from: _4 */
            public static final Key f92_4;

            /* renamed from: _5 */
            public static final Key f93_5;

            /* renamed from: _6 */
            public static final Key f94_6;

            /* renamed from: _7 */
            public static final Key f95_7;

            /* renamed from: _8 */
            public static final Key f96_8;

            /* renamed from: _9 */
            public static final Key f97_9;

            static {
                Key key;
                Key key2;
                Key key3;
                Key key4;
                Key key5;
                Key key6;
                Key key7;
                Key key8;
                Key key9;
                Key key10;
                Key key11;
                Key key12;
                Key key13;
                Key key14;
                Key key15;
                Key key16;
                Key key17;
                Key key18;
                Key key19;
                Key key20;
                Key key21;
                Key key22;
                Key key23;
                Key key24;
                Key key25;
                Key key26;
                Key key27;
                Key key28;
                Key key29;
                Key key30;
                Key key31;
                Key key32;
                Key key33;
                Key key34;
                Key key35;
                Key key36;
                Key key37;
                Key key38;
                Key key39;
                Key key40;
                Key key41;
                Key key42;
                Key key43;
                Key key44;
                Key key45;
                Key key46;
                Key key47;
                Key key48;
                Key key49;
                Key key50;
                Key key51;
                Key key52;
                Key key53;
                Key key54;
                Key key55;
                Key key56;
                Key key57;
                Key key58;
                Key key59;
                Key key60;
                Key key61;
                Key key62;
                Key key63;
                Key key64;
                Key key65;
                Key key66;
                Key key67;
                Key key68;
                Key key69;
                Key key70;
                Key key71;
                Key key72;
                Key key73;
                Key key74;
                Key key75;
                Key key76;
                Key key77;
                Key key78;
                Key key79;
                Key key80;
                Key key81;
                Key key82;
                Key key83;
                Key key84;
                Key key85;
                Key key86;
                Key key87;
                Key key88;
                Key key89;
                Key key90;
                Key key91;
                Key key92;
                Key key93;
                Key key94;
                Key key95;
                Key key96;
                Key key97;
                Key key98;
                Key key99;
                Key key100;
                Key key101;
                Key key102;
                Key key103;
                Key key104;
                Key key105;
                Key key106;
                Key key107;
                Key key108;
                Key key109;
                Key key110;
                Key key111;
                Key key112;
                Key key113;
                Key key114;
                Key key115;
                Key key116;
                Key key117;
                Key key118;
                Key key119;
                Key key120;
                Key key121;
                Key key122;
                Key key123;
                Key key124;
                Key key125;
                Key key126 = key;
                Key key127 = new Key("Void");
                VOID = key126;
                Key key128 = key2;
                Key key129 = new Key("Escape");
                ESCAPE = key128;
                Key key130 = key3;
                Key key131 = new Key("1");
                f89_1 = key130;
                Key key132 = key4;
                Key key133 = new Key("2");
                f90_2 = key132;
                Key key134 = key5;
                Key key135 = new Key("3");
                f91_3 = key134;
                Key key136 = key6;
                Key key137 = new Key("4");
                f92_4 = key136;
                Key key138 = key7;
                Key key139 = new Key("5");
                f93_5 = key138;
                Key key140 = key8;
                Key key141 = new Key("6");
                f94_6 = key140;
                Key key142 = key9;
                Key key143 = new Key("7");
                f95_7 = key142;
                Key key144 = key10;
                Key key145 = new Key("8");
                f96_8 = key144;
                Key key146 = key11;
                Key key147 = new Key("9");
                f97_9 = key146;
                Key key148 = key12;
                Key key149 = new Key("0");
                f88_0 = key148;
                Key key150 = key13;
                Key key151 = new Key("-");
                MINUS = key150;
                Key key152 = key14;
                Key key153 = new Key("=");
                EQUALS = key152;
                Key key154 = key15;
                Key key155 = new Key("Back");
                BACK = key154;
                Key key156 = key16;
                Key key157 = new Key("Tab");
                TAB = key156;
                Key key158 = key17;
                Key key159 = new Key("Q");
                f77Q = key158;
                Key key160 = key18;
                Key key161 = new Key("W");
                f84W = key160;
                Key key162 = key19;
                Key key163 = new Key("E");
                f56E = key162;
                Key key164 = key20;
                Key key165 = new Key("R");
                f78R = key164;
                Key key166 = key21;
                Key key167 = new Key("T");
                f80T = key166;
                Key key168 = key22;
                Key key169 = new Key("Y");
                f86Y = key168;
                Key key170 = key23;
                Key key171 = new Key("U");
                f81U = key170;
                Key key172 = key24;
                Key key173 = new Key("I");
                f69I = key172;
                Key key174 = key25;
                Key key175 = new Key("O");
                f75O = key174;
                Key key176 = key26;
                Key key177 = new Key("P");
                f76P = key176;
                Key key178 = key27;
                Key key179 = new Key("[");
                LBRACKET = key178;
                Key key180 = key28;
                Key key181 = new Key("]");
                RBRACKET = key180;
                Key key182 = key29;
                Key key183 = new Key("Return");
                RETURN = key182;
                Key key184 = key30;
                Key key185 = new Key("Left Control");
                LCONTROL = key184;
                Key key186 = key31;
                Key key187 = new Key("A");
                f50A = key186;
                Key key188 = key32;
                Key key189 = new Key("S");
                f79S = key188;
                Key key190 = key33;
                Key key191 = new Key("D");
                f55D = key190;
                Key key192 = key34;
                Key key193 = new Key("F");
                f57F = key192;
                Key key194 = key35;
                Key key195 = new Key("G");
                f67G = key194;
                Key key196 = key36;
                Key key197 = new Key("H");
                f68H = key196;
                Key key198 = key37;
                Key key199 = new Key("J");
                f70J = key198;
                Key key200 = key38;
                Key key201 = new Key("K");
                f71K = key200;
                Key key202 = key39;
                Key key203 = new Key("L");
                f72L = key202;
                Key key204 = key40;
                Key key205 = new Key(";");
                SEMICOLON = key204;
                Key key206 = key41;
                Key key207 = new Key("'");
                APOSTROPHE = key206;
                Key key208 = key42;
                Key key209 = new Key("~");
                GRAVE = key208;
                Key key210 = key43;
                Key key211 = new Key("Left Shift");
                LSHIFT = key210;
                Key key212 = key44;
                Key key213 = new Key("\\");
                BACKSLASH = key212;
                Key key214 = key45;
                Key key215 = new Key("Z");
                f87Z = key214;
                Key key216 = key46;
                Key key217 = new Key("X");
                f85X = key216;
                Key key218 = key47;
                Key key219 = new Key("C");
                f54C = key218;
                Key key220 = key48;
                Key key221 = new Key("V");
                f83V = key220;
                Key key222 = key49;
                Key key223 = new Key("B");
                f53B = key222;
                Key key224 = key50;
                Key key225 = new Key("N");
                f74N = key224;
                Key key226 = key51;
                Key key227 = new Key("M");
                f73M = key226;
                Key key228 = key52;
                Key key229 = new Key(",");
                COMMA = key228;
                Key key230 = key53;
                Key key231 = new Key(".");
                PERIOD = key230;
                Key key232 = key54;
                Key key233 = new Key("/");
                SLASH = key232;
                Key key234 = key55;
                Key key235 = new Key("Right Shift");
                RSHIFT = key234;
                Key key236 = key56;
                Key key237 = new Key("Multiply");
                MULTIPLY = key236;
                Key key238 = key57;
                Key key239 = new Key("Left Alt");
                LALT = key238;
                Key key240 = key58;
                Key key241 = new Key(" ");
                SPACE = key240;
                Key key242 = key59;
                Key key243 = new Key("Caps Lock");
                CAPITAL = key242;
                Key key244 = key60;
                Key key245 = new Key("F1");
                f58F1 = key244;
                Key key246 = key61;
                Key key247 = new Key("F2");
                f59F2 = key246;
                Key key248 = key62;
                Key key249 = new Key("F3");
                f60F3 = key248;
                Key key250 = key63;
                Key key251 = new Key("F4");
                f61F4 = key250;
                Key key252 = key64;
                Key key253 = new Key("F5");
                f62F5 = key252;
                Key key254 = key65;
                Key key255 = new Key("F6");
                f63F6 = key254;
                Key key256 = key66;
                Key key257 = new Key("F7");
                f64F7 = key256;
                Key key258 = key67;
                Key key259 = new Key("F8");
                f65F8 = key258;
                Key key260 = key68;
                Key key261 = new Key("F9");
                f66F9 = key260;
                Key key262 = key69;
                Key key263 = new Key("F10");
                F10 = key262;
                Key key264 = key70;
                Key key265 = new Key("Num Lock");
                NUMLOCK = key264;
                Key key266 = key71;
                Key key267 = new Key("Scroll Lock");
                SCROLL = key266;
                Key key268 = key72;
                Key key269 = new Key("Num 7");
                NUMPAD7 = key268;
                Key key270 = key73;
                Key key271 = new Key("Num 8");
                NUMPAD8 = key270;
                Key key272 = key74;
                Key key273 = new Key("Num 9");
                NUMPAD9 = key272;
                Key key274 = key75;
                Key key275 = new Key("Num -");
                SUBTRACT = key274;
                Key key276 = key76;
                Key key277 = new Key("Num 4");
                NUMPAD4 = key276;
                Key key278 = key77;
                Key key279 = new Key("Num 5");
                NUMPAD5 = key278;
                Key key280 = key78;
                Key key281 = new Key("Num 6");
                NUMPAD6 = key280;
                Key key282 = key79;
                Key key283 = new Key("Num +");
                ADD = key282;
                Key key284 = key80;
                Key key285 = new Key("Num 1");
                NUMPAD1 = key284;
                Key key286 = key81;
                Key key287 = new Key("Num 2");
                NUMPAD2 = key286;
                Key key288 = key82;
                Key key289 = new Key("Num 3");
                NUMPAD3 = key288;
                Key key290 = key83;
                Key key291 = new Key("Num 0");
                NUMPAD0 = key290;
                Key key292 = key84;
                Key key293 = new Key("Num .");
                DECIMAL = key292;
                Key key294 = key85;
                Key key295 = new Key("F11");
                F11 = key294;
                Key key296 = key86;
                Key key297 = new Key("F12");
                F12 = key296;
                Key key298 = key87;
                Key key299 = new Key("F13");
                F13 = key298;
                Key key300 = key88;
                Key key301 = new Key("F14");
                F14 = key300;
                Key key302 = key89;
                Key key303 = new Key("F15");
                F15 = key302;
                Key key304 = key90;
                Key key305 = new Key("Kana");
                KANA = key304;
                Key key306 = key91;
                Key key307 = new Key("Convert");
                CONVERT = key306;
                Key key308 = key92;
                Key key309 = new Key("Noconvert");
                NOCONVERT = key308;
                Key key310 = key93;
                Key key311 = new Key("Yen");
                YEN = key310;
                Key key312 = key94;
                Key key313 = new Key("Num =");
                NUMPADEQUAL = key312;
                Key key314 = key95;
                Key key315 = new Key("Circumflex");
                CIRCUMFLEX = key314;
                Key key316 = key96;
                Key key317 = new Key("At");
                f51AT = key316;
                Key key318 = key97;
                Key key319 = new Key("Colon");
                COLON = key318;
                Key key320 = key98;
                Key key321 = new Key("Underline");
                UNDERLINE = key320;
                Key key322 = key99;
                Key key323 = new Key("Kanji");
                KANJI = key322;
                Key key324 = key100;
                Key key325 = new Key("Stop");
                STOP = key324;
                Key key326 = key101;
                Key key327 = new Key("Ax");
                f52AX = key326;
                Key key328 = key102;
                Key key329 = new Key("Unlabeled");
                UNLABELED = key328;
                Key key330 = key103;
                Key key331 = new Key("Num Enter");
                NUMPADENTER = key330;
                Key key332 = key104;
                Key key333 = new Key("Right Control");
                RCONTROL = key332;
                Key key334 = key105;
                Key key335 = new Key("Num ,");
                NUMPADCOMMA = key334;
                Key key336 = key106;
                Key key337 = new Key("Num /");
                DIVIDE = key336;
                Key key338 = key107;
                Key key339 = new Key("SysRq");
                SYSRQ = key338;
                Key key340 = key108;
                Key key341 = new Key("Right Alt");
                RALT = key340;
                Key key342 = key109;
                Key key343 = new Key("Pause");
                PAUSE = key342;
                Key key344 = key110;
                Key key345 = new Key("Home");
                HOME = key344;
                Key key346 = key111;
                Key key347 = new Key("Up");
                f82UP = key346;
                Key key348 = key112;
                Key key349 = new Key("Pg Up");
                PAGEUP = key348;
                Key key350 = key113;
                Key key351 = new Key("Left");
                LEFT = key350;
                Key key352 = key114;
                Key key353 = new Key("Right");
                RIGHT = key352;
                Key key354 = key115;
                Key key355 = new Key("End");
                END = key354;
                Key key356 = key116;
                Key key357 = new Key("Down");
                DOWN = key356;
                Key key358 = key117;
                Key key359 = new Key("Pg Down");
                PAGEDOWN = key358;
                Key key360 = key118;
                Key key361 = new Key("Insert");
                INSERT = key360;
                Key key362 = key119;
                Key key363 = new Key("Delete");
                DELETE = key362;
                Key key364 = key120;
                Key key365 = new Key("Left Windows");
                LWIN = key364;
                Key key366 = key121;
                Key key367 = new Key("Right Windows");
                RWIN = key366;
                Key key368 = key122;
                Key key369 = new Key("Apps");
                APPS = key368;
                Key key370 = key123;
                Key key371 = new Key("Power");
                POWER = key370;
                Key key372 = key124;
                Key key373 = new Key("Sleep");
                SLEEP = key372;
                Key key374 = key125;
                Key key375 = new Key("Unknown");
                UNKNOWN = key374;
            }

            protected Key(String str) {
                super(str);
            }
        }

        protected Identifier(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }

    public static class POV {
        public static final float CENTER = 0.0f;
        public static final float DOWN = 0.75f;
        public static final float DOWN_LEFT = 0.875f;
        public static final float DOWN_RIGHT = 0.625f;
        public static final float LEFT = 1.0f;
        public static final float OFF = 0.0f;
        public static final float RIGHT = 0.5f;

        /* renamed from: UP */
        public static final float f98UP = 0.25f;
        public static final float UP_LEFT = 0.125f;
        public static final float UP_RIGHT = 0.375f;

        public POV() {
        }
    }

    float getDeadZone();

    Identifier getIdentifier();

    String getName();

    float getPollData();

    boolean isAnalog();

    boolean isRelative();
}

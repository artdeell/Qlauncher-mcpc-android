package net.java.games.input;

import net.java.games.input.Component.Identifier;

public interface Controller {

    public static final class PortType {
        public static final PortType GAME;
        public static final PortType I8042;
        public static final PortType NETWORK;
        public static final PortType PARALLEL;
        public static final PortType SERIAL;
        public static final PortType UNKNOWN;
        public static final PortType USB;
        private final String name;

        static {
            PortType portType;
            PortType portType2;
            PortType portType3;
            PortType portType4;
            PortType portType5;
            PortType portType6;
            PortType portType7;
            PortType portType8 = portType;
            PortType portType9 = new PortType("Unknown");
            UNKNOWN = portType8;
            PortType portType10 = portType2;
            PortType portType11 = new PortType("USB port");
            USB = portType10;
            PortType portType12 = portType3;
            PortType portType13 = new PortType("Game port");
            GAME = portType12;
            PortType portType14 = portType4;
            PortType portType15 = new PortType("Network port");
            NETWORK = portType14;
            PortType portType16 = portType5;
            PortType portType17 = new PortType("Serial port");
            SERIAL = portType16;
            PortType portType18 = portType6;
            PortType portType19 = new PortType("i8042 (PS/2)");
            I8042 = portType18;
            PortType portType20 = portType7;
            PortType portType21 = new PortType("Parallel port");
            PARALLEL = portType20;
        }

        protected PortType(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public static class Type {
        public static final Type FINGERSTICK;
        public static final Type GAMEPAD;
        public static final Type HEADTRACKER;
        public static final Type KEYBOARD;
        public static final Type MOUSE;
        public static final Type RUDDER;
        public static final Type STICK;
        public static final Type TRACKBALL;
        public static final Type TRACKPAD;
        public static final Type UNKNOWN;
        public static final Type WHEEL;
        private final String name;

        static {
            Type type;
            Type type2;
            Type type3;
            Type type4;
            Type type5;
            Type type6;
            Type type7;
            Type type8;
            Type type9;
            Type type10;
            Type type11;
            Type type12 = type;
            Type type13 = new Type("Unknown");
            UNKNOWN = type12;
            Type type14 = type2;
            Type type15 = new Type("Mouse");
            MOUSE = type14;
            Type type16 = type3;
            Type type17 = new Type("Keyboard");
            KEYBOARD = type16;
            Type type18 = type4;
            Type type19 = new Type("Fingerstick");
            FINGERSTICK = type18;
            Type type20 = type5;
            Type type21 = new Type("Gamepad");
            GAMEPAD = type20;
            Type type22 = type6;
            Type type23 = new Type("Headtracker");
            HEADTRACKER = type22;
            Type type24 = type7;
            Type type25 = new Type("Rudder");
            RUDDER = type24;
            Type type26 = type8;
            Type type27 = new Type("Stick");
            STICK = type26;
            Type type28 = type9;
            Type type29 = new Type("Trackball");
            TRACKBALL = type28;
            Type type30 = type10;
            Type type31 = new Type("Trackpad");
            TRACKPAD = type30;
            Type type32 = type11;
            Type type33 = new Type("Wheel");
            WHEEL = type32;
        }

        protected Type(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    Component getComponent(Identifier identifier);

    Component[] getComponents();

    Controller[] getControllers();

    EventQueue getEventQueue();

    String getName();

    int getPortNumber();

    PortType getPortType();

    Rumbler[] getRumblers();

    Type getType();

    boolean poll();

    void setEventQueueSize(int i);
}

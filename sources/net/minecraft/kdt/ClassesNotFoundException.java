package net.minecraft.kdt;

public class ClassesNotFoundException extends ClassNotFoundException {
    public ClassesNotFoundException() {
        super("Failed to find a class from classes list");
    }

    public ClassesNotFoundException(String str) {
        super(str);
    }
}

package net.java.games.input;

import net.java.games.input.Component.Identifier;

public interface Rumbler {
    Identifier getAxisIdentifier();

    String getAxisName();

    void rumble(float f);
}

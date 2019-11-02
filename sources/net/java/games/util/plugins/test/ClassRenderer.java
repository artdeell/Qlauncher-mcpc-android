package net.java.games.util.plugins.test;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class ClassRenderer implements ListCellRenderer {
    JLabel label;

    ClassRenderer() {
        JLabel jLabel;
        JLabel jLabel2 = jLabel;
        JLabel jLabel3 = new JLabel();
        this.label = jLabel2;
    }

    public Component getListCellRendererComponent(JList jList, Object obj, int i, boolean z, boolean z2) {
        JList jList2 = jList;
        int i2 = i;
        boolean z3 = z;
        boolean z4 = z2;
        this.label.setText(((Class) obj).getName());
        this.label.setForeground(Color.BLACK);
        this.label.setBackground(Color.WHITE);
        return this.label;
    }
}

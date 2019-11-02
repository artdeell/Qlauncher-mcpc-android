package net.java.games.util.plugins.test;

import javax.swing.DefaultListModel;
import javax.swing.JList;

class ListUpdater implements Runnable {
    DefaultListModel mdl;
    Object[] objList;

    public ListUpdater(JList jList, Object[] objArr) {
        JList jList2 = jList;
        this.objList = objArr;
        this.mdl = jList2.getModel();
    }

    public void run() {
        this.mdl.clear();
        for (int i = 0; i < this.objList.length; i++) {
            this.mdl.addElement(this.objList[i]);
        }
    }
}

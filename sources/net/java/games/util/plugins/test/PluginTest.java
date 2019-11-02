package net.java.games.util.plugins.test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import net.java.games.util.plugins.Plugins;

public class PluginTest {
    static final boolean DEBUG = false;
    Class[] piList;
    JList plist;
    Plugins plugins;

    public PluginTest() {
        JFrame jFrame;
        JList jList;
        ListModel listModel;
        ListCellRenderer listCellRenderer;
        LayoutManager layoutManager;
        Component component;
        JPanel jPanel;
        LayoutManager layoutManager2;
        Plugins plugins2;
        File file;
        try {
            Plugins plugins3 = plugins2;
            File file2 = file;
            File file3 = new File("test_plugins");
            Plugins plugins4 = new Plugins(file2);
            this.plugins = plugins3;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        JFrame jFrame2 = jFrame;
        JFrame jFrame3 = new JFrame("PluginTest");
        JFrame jFrame4 = jFrame2;
        JList jList2 = jList;
        ListModel listModel2 = listModel;
        ListModel defaultListModel = new DefaultListModel();
        JList jList3 = new JList(listModel2);
        this.plist = jList2;
        JList jList4 = this.plist;
        ListCellRenderer listCellRenderer2 = listCellRenderer;
        ListCellRenderer classRenderer = new ClassRenderer();
        jList4.setCellRenderer(listCellRenderer2);
        Container contentPane = jFrame4.getContentPane();
        Container container = contentPane;
        LayoutManager layoutManager3 = layoutManager;
        LayoutManager borderLayout = new BorderLayout();
        container.setLayout(layoutManager3);
        Container container2 = contentPane;
        Component component2 = component;
        Component jScrollPane = new JScrollPane(this.plist);
        container2.add(component2, "Center");
        JPanel jPanel2 = jPanel;
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = jPanel2;
        contentPane.add(jPanel4, "South");
        JPanel jPanel5 = jPanel4;
        LayoutManager layoutManager4 = layoutManager2;
        LayoutManager flowLayout = new FlowLayout();
        jPanel5.setLayout(layoutManager4);
        jFrame4.pack();
        jFrame4.setDefaultCloseOperation(3);
        jFrame4.setVisible(true);
        doListAll();
    }

    private void doListAll() {
        ListUpdater listUpdater;
        ListUpdater listUpdater2 = listUpdater;
        ListUpdater listUpdater3 = new ListUpdater(this.plist, this.plugins.get());
        SwingUtilities.invokeLater(listUpdater2);
    }

    public static void main(String[] strArr) {
        PluginTest pluginTest;
        String[] strArr2 = strArr;
        PluginTest pluginTest2 = pluginTest;
        PluginTest pluginTest3 = new PluginTest();
    }
}

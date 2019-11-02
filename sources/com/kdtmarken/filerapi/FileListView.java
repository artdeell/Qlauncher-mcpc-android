package com.kdtmarken.filerapi;

import android.content.Context;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.Arrays;

public class FileListView extends LinearLayout {
    private Context context;
    private TextView emptyTv;
    private WindowManager emptyWm;
    private String fullPath;
    private FileSelectedListener listener;
    private ListView mainLv;
    private TextView mainTv;

    public FileListView(Context context2) {
        Context context3 = context2;
        super(context3);
        init(context3);
    }

    public FileListView(Context context2, AttributeSet attributeSet) {
        Context context3 = context2;
        super(context3, attributeSet);
        init(context3);
    }

    public FileListView(Context context2, AttributeSet attributeSet, int i) {
        Context context3 = context2;
        super(context3, attributeSet, i);
        init(context3);
    }

    public void init(Context context2) {
        LayoutParams layoutParams;
        TextView textView;
        LinearLayout.LayoutParams layoutParams2;
        TextView textView2;
        ListView listView;
        AnonymousClass100000000 r10;
        Context context3 = context2;
        LayoutParams layoutParams3 = layoutParams;
        LayoutParams layoutParams4 = new LayoutParams();
        LayoutParams layoutParams5 = layoutParams3;
        layoutParams5.width = -2;
        layoutParams5.height = -2;
        layoutParams5.gravity = 17;
        layoutParams5.format = -3;
        layoutParams5.type = 2;
        layoutParams5.flags = 8;
        this.emptyWm = (WindowManager) context3.getSystemService("window");
        TextView textView3 = textView;
        TextView textView4 = new TextView(context3);
        this.emptyTv = textView3;
        this.emptyTv.setText("This folder is empty");
        this.emptyWm.addView(this.emptyTv, layoutParams5);
        this.context = context3;
        LinearLayout.LayoutParams layoutParams6 = layoutParams2;
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams8 = layoutParams6;
        setOrientation(1);
        TextView textView5 = textView2;
        TextView textView6 = new TextView(context3);
        this.mainTv = textView5;
        this.mainTv.setText("Path: null");
        ListView listView2 = listView;
        ListView listView3 = new ListView(context3);
        this.mainLv = listView2;
        listFileAt(Environment.getExternalStorageDirectory().getPath());
        ListView listView4 = this.mainLv;
        AnonymousClass100000000 r7 = r10;
        AnonymousClass100000000 r8 = new OnItemClickListener(this) {
            private final FileListView this$0;

            {
                this.this$0 = r6;
            }

            static FileListView access$0(AnonymousClass100000000 r4) {
                return r4.this$0;
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                File file;
                View view2 = view;
                long j2 = j;
                File file2 = file;
                File file3 = new File(adapterView.getItemAtPosition(i).toString());
                File file4 = file2;
                if (file4.getName().equals("..           ")) {
                    this.this$0.parentDir();
                } else {
                    this.this$0.listFileAt(file4.getAbsolutePath());
                }
            }
        };
        listView4.setOnItemClickListener(r7);
        addView(this.mainTv, layoutParams8);
        addView(this.mainLv, layoutParams8);
    }

    public void setFileSelectedListener(FileSelectedListener fileSelectedListener) {
        FileSelectedListener fileSelectedListener2 = fileSelectedListener;
        this.listener = fileSelectedListener2;
    }

    public void listFileAt(String str) {
        File file;
        FileListAdapter fileListAdapter;
        File file2;
        StringBuffer stringBuffer;
        SortFileName sortFileName;
        String str2 = str;
        try {
            File file3 = file;
            File file4 = new File(str2);
            File file5 = file3;
            if (!file5.exists()) {
                Toast.makeText(this.context, "This folder (or file) doesn't exist", 0).show();
                refreshPath();
            } else if (file5.isDirectory()) {
                this.fullPath = str2;
                File[] listFiles = file5.listFiles();
                FileListAdapter fileListAdapter2 = fileListAdapter;
                FileListAdapter fileListAdapter3 = new FileListAdapter(this.context);
                FileListAdapter fileListAdapter4 = fileListAdapter2;
                FileListAdapter fileListAdapter5 = fileListAdapter4;
                File file6 = file2;
                File file7 = new File(str2, "..           ");
                fileListAdapter5.add(file6);
                if (listFiles.length != 0) {
                    File[] fileArr = listFiles;
                    SortFileName sortFileName2 = sortFileName;
                    SortFileName sortFileName3 = new SortFileName();
                    Arrays.sort(fileArr, sortFileName2);
                    File[] fileArr2 = listFiles;
                    for (int i = 0; i < fileArr2.length; i++) {
                        fileListAdapter4.add(fileArr2[i]);
                    }
                    this.emptyTv.setVisibility(8);
                } else {
                    this.emptyTv.setVisibility(0);
                }
                this.mainLv.setAdapter(fileListAdapter4);
                TextView textView = this.mainTv;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                textView.setText(stringBuffer2.append("Path: ").append(str2).toString());
            } else {
                this.listener.onFileSelected(file5, str2, file5.getName(), getExtension(str2));
            }
        } catch (Exception e) {
            Exception exc = e;
        }
    }

    public static String getExtension(String str) {
        File file;
        File file2 = file;
        File file3 = new File(str);
        return getExtension(file2);
    }

    public static String getExtension(File file) {
        File file2 = file;
        return file2.getAbsolutePath().substring(file2.getAbsolutePath().lastIndexOf("."));
    }

    public String getFullPath() {
        return this.fullPath;
    }

    public void refreshPath() {
        listFileAt(getFullPath());
    }

    public void parentDir() {
        File file;
        File file2 = file;
        File file3 = new File(this.fullPath);
        File file4 = file2;
        if (!file4.getAbsolutePath().equals(Environment.getExternalStorageDirectory().getAbsolutePath())) {
            listFileAt(file4.getParent());
        }
    }
}

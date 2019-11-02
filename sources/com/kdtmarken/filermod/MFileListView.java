package com.kdtmarken.filermod;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;
import java.io.File;
import java.util.Arrays;

public class MFileListView extends LinearLayout {
    private AlertDialog build;
    private Context context;
    private String fullPath;
    private String homePath;
    /* access modifiers changed from: private */
    public MFileSelectedListener listener;
    private boolean lockedHome = false;
    private ListView mainLv;

    public MFileListView(Context context2, AlertDialog alertDialog) {
        Context context3 = context2;
        AlertDialog alertDialog2 = alertDialog;
        super(context3);
        init(context3);
        this.build = alertDialog2;
    }

    public MFileListView(Context context2, AttributeSet attributeSet) {
        Context context3 = context2;
        super(context3, attributeSet);
        init(context3);
    }

    public MFileListView(Context context2, AttributeSet attributeSet, int i) {
        Context context3 = context2;
        super(context3, attributeSet, i);
        init(context3);
    }

    public void init(Context context2) {
        LayoutParams layoutParams;
        ListView listView;
        AnonymousClass100000000 r9;
        AnonymousClass100000001 r92;
        Context context3 = context2;
        this.context = context3;
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams(-1, -2);
        LayoutParams layoutParams4 = layoutParams2;
        setOrientation(1);
        ListView listView2 = listView;
        ListView listView3 = new ListView(context3);
        this.mainLv = listView2;
        ListView listView4 = this.mainLv;
        AnonymousClass100000000 r6 = r9;
        AnonymousClass100000000 r7 = new OnItemClickListener(this) {
            private final MFileListView this$0;

            {
                this.this$0 = r6;
            }

            static MFileListView access$0(AnonymousClass100000000 r4) {
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
        listView4.setOnItemClickListener(r6);
        ListView listView5 = this.mainLv;
        AnonymousClass100000001 r62 = r92;
        AnonymousClass100000001 r72 = new OnItemLongClickListener(this) {
            private final MFileListView this$0;

            {
                this.this$0 = r6;
            }

            static MFileListView access$0(AnonymousClass100000001 r4) {
                return r4.this$0;
            }

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                File file;
                View view2 = view;
                long j2 = j;
                File file2 = file;
                File file3 = new File(adapterView.getItemAtPosition(i).toString());
                File file4 = file2;
                String name = file4.getName();
                if (!file4.isFile()) {
                    return false;
                }
                this.this$0.listener.onFileLongClick(file4, file4.getAbsolutePath(), name, MFileListView.getExtension(file4.getAbsolutePath()));
                return true;
            }
        };
        listView5.setOnItemLongClickListener(r62);
        addView(this.mainLv, layoutParams4);
    }

    public void setFileSelectedListener(MFileSelectedListener mFileSelectedListener) {
        MFileSelectedListener mFileSelectedListener2 = mFileSelectedListener;
        this.listener = mFileSelectedListener2;
    }

    public void listFileAt(String str) {
        File file;
        MFileListAdapter mFileListAdapter;
        File file2;
        MSortFileName mSortFileName;
        File file3;
        String str2 = str;
        try {
            File file4 = file;
            File file5 = new File(str2);
            File file6 = file4;
            if (!file6.exists()) {
                Toast.makeText(this.context, "This folder (or file) doesn't exist", 0).show();
                refreshPath();
            } else if (file6.isDirectory()) {
                if (!this.lockedHome) {
                    this.homePath = str2;
                    this.lockedHome = true;
                }
                this.fullPath = str2;
                File[] listFiles = file6.listFiles();
                MFileListAdapter mFileListAdapter2 = mFileListAdapter;
                MFileListAdapter mFileListAdapter3 = new MFileListAdapter(this.context);
                MFileListAdapter mFileListAdapter4 = mFileListAdapter2;
                if (!str2.equals(this.homePath)) {
                    MFileListAdapter mFileListAdapter5 = mFileListAdapter4;
                    File file7 = file3;
                    File file8 = new File(str2, "..           ");
                    mFileListAdapter5.add(file7);
                }
                if (listFiles.length != 0) {
                    File[] fileArr = listFiles;
                    MSortFileName mSortFileName2 = mSortFileName;
                    MSortFileName mSortFileName3 = new MSortFileName();
                    Arrays.sort(fileArr, mSortFileName2);
                    File[] fileArr2 = listFiles;
                    for (int i = 0; i < fileArr2.length; i++) {
                        mFileListAdapter4.add(fileArr2[i]);
                    }
                }
                this.mainLv.setAdapter(mFileListAdapter4);
                AlertDialog alertDialog = this.build;
                File file9 = file2;
                File file10 = new File(str2);
                alertDialog.setTitle(file9.getName());
            } else {
                this.listener.onFileSelected(file6, str2, file6.getName(), getExtension(str2));
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

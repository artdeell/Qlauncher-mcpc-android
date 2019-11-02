package com.ipaulpro.afilechooser;

import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.ipaulpro.afilechooser.utils.FileUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class FileChooserActivity extends ListActivity {
    private static final String BREADCRUMB = "breadcrumb";
    private static final boolean DEBUG = true;
    private static final String HIDDEN_PREFIX = ".";
    public static final String MIME_TYPE_ALL = "*/*";
    private static final String PATH = "path";
    private static final String POSTIION = "position";
    public static final int REQUEST_CODE = 6384;
    private static final String TAG = "ChooserActivity";
    /* access modifiers changed from: private */
    public Set<String> extendedMimeTypes;
    private ArrayList<String> mBreadcrumb;
    private Comparator<File> mComparator;
    private FileFilter mDirFilter;
    private File mExternalDir;
    private boolean mExternalStorageAvailable = false;
    private BroadcastReceiver mExternalStorageReceiver;
    private boolean mExternalStorageWriteable = false;
    private FileFilter mFileFilter;
    private Comparator<File> mLastModifiedComparator;
    private ArrayList<File> mList;
    private String mPath;

    public FileChooserActivity() {
        ArrayList<String> arrayList;
        ArrayList<File> arrayList2;
        HashSet hashSet;
        C05341 r5;
        C05352 r52;
        C05363 r53;
        C05374 r54;
        C05385 r55;
        ArrayList<String> arrayList3 = arrayList;
        ArrayList<String> arrayList4 = new ArrayList<>();
        this.mBreadcrumb = arrayList3;
        ArrayList<File> arrayList5 = arrayList2;
        ArrayList<File> arrayList6 = new ArrayList<>();
        this.mList = arrayList5;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        this.extendedMimeTypes = hashSet2;
        C05341 r2 = r5;
        C05341 r3 = new FileFilter(this) {
            final /* synthetic */ FileChooserActivity this$0;

            {
                this.this$0 = r5;
            }

            public boolean accept(File file) {
                File file2 = file;
                String name = file2.getName();
                String mimeType = FileUtils.getMimeType(this.this$0, file2);
                return file2.isFile() && !name.startsWith(FileChooserActivity.HIDDEN_PREFIX) && (mimeType.equals(this.this$0.getIntent().getType()) || this.this$0.extendedMimeTypes.contains(mimeType));
            }
        };
        this.mFileFilter = r2;
        C05352 r22 = r52;
        C05352 r32 = new FileFilter(this) {
            final /* synthetic */ FileChooserActivity this$0;

            {
                this.this$0 = r5;
            }

            public boolean accept(File file) {
                File file2 = file;
                return file2.isDirectory() && !file2.getName().startsWith(FileChooserActivity.HIDDEN_PREFIX);
            }
        };
        this.mDirFilter = r22;
        C05363 r23 = r53;
        C05363 r33 = new Comparator<File>(this) {
            final /* synthetic */ FileChooserActivity this$0;

            {
                this.this$0 = r5;
            }

            public int compare(File file, File file2) {
                return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
            }
        };
        this.mComparator = r23;
        C05374 r24 = r54;
        C05374 r34 = new Comparator<File>(this) {
            final /* synthetic */ FileChooserActivity this$0;

            {
                this.this$0 = r5;
            }

            public int compare(File file, File file2) {
                File file3 = file2;
                long lastModified = file.lastModified();
                long lastModified2 = file3.lastModified();
                if (lastModified == lastModified2) {
                    return 0;
                }
                return lastModified < lastModified2 ? 1 : -1;
            }
        };
        this.mLastModifiedComparator = r24;
        C05385 r25 = r55;
        C05385 r35 = new BroadcastReceiver(this) {
            final /* synthetic */ FileChooserActivity this$0;

            {
                this.this$0 = r5;
            }

            public void onReceive(Context context, Intent intent) {
                StringBuilder sb;
                Context context2 = context;
                Intent intent2 = intent;
                String str = FileChooserActivity.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int d = Log.d(str, sb2.append("External storage broadcast recieved: ").append(intent2.getData()).toString());
                this.this$0.updateExternalStorageState();
            }
        };
        this.mExternalStorageReceiver = r25;
    }

    private void fillList(int i) {
        StringBuilder sb;
        File file;
        int i2 = i;
        String str = TAG;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        int d = Log.d(str, sb2.append("Current path: ").append(this.mPath).toString());
        setTitle(this.mPath);
        ((FileListAdapter) getListAdapter()).clear();
        File file2 = file;
        File file3 = new File(this.mPath);
        File file4 = file2;
        File[] listFiles = file4.listFiles(this.mDirFilter);
        if (listFiles != null) {
            Arrays.sort(listFiles, this.mComparator);
            int length = listFiles.length;
            for (int i3 = 0; i3 < length; i3++) {
                boolean add = this.mList.add(listFiles[i3]);
            }
        }
        File[] listFiles2 = file4.listFiles(this.mFileFilter);
        if (listFiles2 != null) {
            Arrays.sort(listFiles2, this.mComparator);
            int length2 = listFiles2.length;
            for (int i4 = 0; i4 < length2; i4++) {
                boolean add2 = this.mList.add(listFiles2[i4]);
            }
        }
        if (listFiles == null && listFiles2 == null) {
            int d2 = Log.d(TAG, "Directory is empty");
        }
        ((FileListAdapter) getListAdapter()).setListItems(this.mList);
        ((FileListAdapter) getListAdapter()).notifyDataSetChanged();
        getListView().setSelection(i2);
    }

    private void handleExternalStorageState(boolean z, boolean z2) {
        boolean z3 = z2;
        if (!z && isIntentGetContent()) {
            int d = Log.d(TAG, "External Storage was disconnected");
            onFileDisconnect();
            finish();
        }
    }

    private void restoreMe(Bundle bundle) {
        Bundle bundle2 = bundle;
        this.mPath = bundle2.containsKey(PATH) ? bundle2.getString(PATH) : this.mExternalDir.getAbsolutePath();
        this.mBreadcrumb = bundle2.getStringArrayList(BREADCRUMB);
        fillList(bundle2.getInt(POSTIION));
    }

    private void startWatchingExternalStorage() {
        IntentFilter intentFilter;
        IntentFilter intentFilter2 = intentFilter;
        IntentFilter intentFilter3 = new IntentFilter();
        IntentFilter intentFilter4 = intentFilter2;
        intentFilter4.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter4.addAction("android.intent.action.MEDIA_REMOVED");
        Intent registerReceiver = registerReceiver(this.mExternalStorageReceiver, intentFilter4);
        if (isIntentGetContent()) {
            updateExternalStorageState();
        }
    }

    private void stopWatchingExternalStorage() {
        unregisterReceiver(this.mExternalStorageReceiver);
    }

    private void updateBreadcrumb(boolean z) {
        if (z) {
            boolean add = this.mBreadcrumb.add(this.mPath);
        } else if (this.mExternalDir.getAbsolutePath().equals(this.mPath)) {
            onFileSelectCancel();
            finish();
        } else {
            int size = this.mBreadcrumb.size();
            if (size > 1) {
                Object remove = this.mBreadcrumb.remove(size - 1);
                this.mPath = (String) this.mBreadcrumb.get(size - 2);
                fillList(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateExternalStorageState() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.mExternalStorageWriteable = true;
            this.mExternalStorageAvailable = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.mExternalStorageAvailable = true;
            this.mExternalStorageWriteable = false;
        } else {
            this.mExternalStorageWriteable = false;
            this.mExternalStorageAvailable = false;
        }
        handleExternalStorageState(this.mExternalStorageAvailable, this.mExternalStorageWriteable);
    }

    /* access modifiers changed from: protected */
    public boolean isIntentGetContent() {
        StringBuilder sb;
        String action = getIntent().getAction();
        String str = TAG;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        int d = Log.d(str, sb2.append("Intent Action: ").append(action).toString());
        return "android.intent.action.GET_CONTENT".equals(action);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        File file;
        int i3 = i;
        int i4 = i2;
        Intent intent2 = intent;
        switch (i3) {
            case REQUEST_CODE /*6384*/:
                if (i4 != -1) {
                    if (i4 == 0) {
                        onFileSelectCancel();
                        break;
                    }
                } else {
                    try {
                        File file2 = file;
                        File file3 = new File(FileUtils.getPath(this, intent2.getData()));
                        onFileSelect(file2);
                        break;
                    } catch (Exception e) {
                        onFileError(e);
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i3, i4, intent2);
    }

    public void onBackPressed() {
        updateBreadcrumb(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        FileListAdapter fileListAdapter;
        Bundle bundle2 = bundle;
        super.onCreate(bundle2);
        String[] stringArrayExtra = getIntent().getStringArrayExtra(FileUtils.EXTRA_MIME_TYPES);
        this.extendedMimeTypes.clear();
        if (stringArrayExtra != null) {
            int length = stringArrayExtra.length;
            for (int i = 0; i < length; i++) {
                boolean add = this.extendedMimeTypes.add(stringArrayExtra[i]);
            }
        }
        this.mExternalDir = Environment.getExternalStorageDirectory();
        String stringExtra = getIntent().getStringExtra(FileUtils.EXTRA_SORT_METHOD);
        if (stringExtra != null && stringExtra.equals(FileUtils.SORT_LAST_MODIFIED)) {
            this.mComparator = this.mLastModifiedComparator;
        }
        if (getListAdapter() == null) {
            FileListAdapter fileListAdapter2 = fileListAdapter;
            FileListAdapter fileListAdapter3 = new FileListAdapter(this);
            setListAdapter(fileListAdapter2);
        }
        if (bundle2 != null) {
            restoreMe(bundle2);
            return;
        }
        this.mPath = this.mExternalDir.getAbsolutePath();
        String stringExtra2 = getIntent().getStringExtra("startPath");
        if (stringExtra2 != null) {
            this.mPath = stringExtra2;
        }
        updateBreadcrumb(true);
        if (isIntentGetContent()) {
            setContentView(C0539R.layout.explorer);
            fillList(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onFileDisconnect() {
        int d = Log.d(TAG, "External storage disconnected");
    }

    /* access modifiers changed from: protected */
    public void onFileError(Exception exc) {
        int e = Log.e(TAG, "Error selecting file", exc);
    }

    /* access modifiers changed from: protected */
    public void onFileSelect(File file) {
        StringBuilder sb;
        File file2 = file;
        String str = TAG;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        int d = Log.d(str, sb2.append("File selected: ").append(file2.getAbsolutePath()).toString());
    }

    /* access modifiers changed from: protected */
    public void onFileSelectCancel() {
        int d = Log.d(TAG, "File selection canceled");
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView listView, View view, int i, long j) {
        StringBuilder sb;
        Intent intent;
        int i2 = i;
        super.onListItemClick(listView, view, i2, j);
        File file = (File) this.mList.get(i2);
        this.mPath = file.getAbsolutePath();
        String str = TAG;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        int d = Log.d(str, sb2.append("Selected file: ").append(this.mPath).toString());
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            updateBreadcrumb(true);
            fillList(0);
            return;
        }
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        Intent data = intent4.setData(Uri.fromFile(file));
        setResult(-1, intent4);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        stopWatchingExternalStorage();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        startWatchingExternalStorage();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = bundle;
        super.onSaveInstanceState(bundle2);
        bundle2.putString(PATH, this.mPath);
        bundle2.putStringArrayList(BREADCRUMB, this.mBreadcrumb);
        bundle2.putInt(POSTIION, getListView().getFirstVisiblePosition());
    }

    /* access modifiers changed from: protected */
    public void showFileChooser() {
        showFileChooser(null, null);
    }

    /* access modifiers changed from: protected */
    public void showFileChooser(String str, String str2) {
        Intent intent;
        String str3 = str;
        String str4 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = getString(C0539R.string.select_file);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = MIME_TYPE_ALL;
        }
        Intent intent2 = intent;
        Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
        Intent intent4 = intent2;
        Intent type = intent4.setType(str4.toLowerCase());
        Intent addCategory = intent4.addCategory("android.intent.category.OPENABLE");
        try {
            startActivityForResult(Intent.createChooser(intent4, str3), REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            onFileError(e);
        }
    }
}

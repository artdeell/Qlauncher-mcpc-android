package com.ipaulpro.afilechooser.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import com.ipaulpro.afilechooser.C0539R;
import com.ipaulpro.afilechooser.FileChooserActivity;
import java.io.File;
import java.io.FileFilter;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public class FileUtils {
    private static final boolean DEBUG = false;
    public static final String EXTRA_MIME_TYPES = "net.zhuoweizhang.afilechooser.extra.MIME_TYPES";
    public static final String EXTRA_SORT_METHOD = "net.zhuoweizhang.afilechooser.extra.SORT_METHOD";
    private static final String HIDDEN_PREFIX = ".";
    public static final String MIME_TYPE_APP = "application/*";
    public static final String MIME_TYPE_AUDIO = "audio/*";
    public static final String MIME_TYPE_IMAGE = "image/*";
    public static final String MIME_TYPE_TEXT = "text/*";
    public static final String MIME_TYPE_VIDEO = "video/*";
    public static final String SORT_LAST_MODIFIED = "net.zhuoweizhang.afilechooser.extra.SORT_LAST_MODIFIED";
    static final String TAG = "FileUtils";
    private static Comparator<File> mComparator;
    private static FileFilter mDirFilter;
    private static FileFilter mFileFilter;

    static {
        C05421 r2;
        C05432 r22;
        C05443 r23;
        C05421 r0 = r2;
        C05421 r1 = new Comparator<File>() {
            public int compare(File file, File file2) {
                return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
            }
        };
        mComparator = r0;
        C05432 r02 = r22;
        C05432 r12 = new FileFilter() {
            public boolean accept(File file) {
                File file2 = file;
                return file2.isFile() && !file2.getName().startsWith(FileUtils.HIDDEN_PREFIX);
            }
        };
        mFileFilter = r02;
        C05443 r03 = r23;
        C05443 r13 = new FileFilter() {
            public boolean accept(File file) {
                File file2 = file;
                return file2.isDirectory() && !file2.getName().startsWith(FileUtils.HIDDEN_PREFIX);
            }
        };
        mDirFilter = r03;
    }

    public FileUtils() {
    }

    public static Intent createGetContentIntent() {
        Intent intent;
        Intent intent2 = intent;
        Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
        Intent intent4 = intent2;
        Intent type = intent4.setType(FileChooserActivity.MIME_TYPE_ALL);
        Intent addCategory = intent4.addCategory("android.intent.category.OPENABLE");
        return intent4;
    }

    public static String getExtension(String str) {
        String str2 = str;
        if (str2 == null) {
            return null;
        }
        int lastIndexOf = str2.lastIndexOf(HIDDEN_PREFIX);
        return lastIndexOf >= 0 ? str2.substring(lastIndexOf) : LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public static File getFile(Uri uri) {
        File file;
        Uri uri2 = uri;
        if (uri2 != null) {
            String path = uri2.getPath();
            if (path != null) {
                File file2 = file;
                File file3 = new File(path);
                return file2;
            }
        }
        return null;
    }

    public static File getFile(File file, String str) {
        return getFile(file.getAbsolutePath(), str);
    }

    public static File getFile(String str, String str2) {
        File file;
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        String str5 = "/";
        if (str3.endsWith("/")) {
            str5 = LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        File file2 = file;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        File file3 = new File(sb2.append(str3).append(str5).append(str4).toString());
        return file2;
    }

    public static List<File> getFileList(String str) {
        ArrayList arrayList;
        File file;
        String str2 = str;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        File file2 = file;
        File file3 = new File(str2);
        File file4 = file2;
        File[] listFiles = file4.listFiles(mDirFilter);
        if (listFiles != null) {
            Arrays.sort(listFiles, mComparator);
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                boolean add = arrayList4.add(listFiles[i]);
            }
        }
        File[] listFiles2 = file4.listFiles(mFileFilter);
        if (listFiles2 != null) {
            Arrays.sort(listFiles2, mComparator);
            int length2 = listFiles2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                boolean add2 = arrayList4.add(listFiles2[i2]);
            }
        }
        return arrayList4;
    }

    public static String getMimeType(Context context, File file) {
        File file2 = file;
        MimeTypes mimeTypes = getMimeTypes(context);
        String str = null;
        if (file2 != null) {
            str = mimeTypes.getMimeType(file2.getName());
        }
        return str;
    }

    private static MimeTypes getMimeTypes(Context context) {
        MimeTypeParser mimeTypeParser;
        Context context2 = context;
        MimeTypeParser mimeTypeParser2 = mimeTypeParser;
        MimeTypeParser mimeTypeParser3 = new MimeTypeParser();
        try {
            return mimeTypeParser2.fromXmlResource(context2.getResources().getXml(C0539R.xml.mimetypes));
        } catch (Exception e) {
            Exception exc = e;
            return null;
        }
    }

    public static String getPath(Context context, Uri uri) throws URISyntaxException {
        Context context2 = context;
        Uri uri2 = uri;
        if ("content".equalsIgnoreCase(uri2.getScheme())) {
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "_data";
            try {
                Cursor query = context2.getContentResolver().query(uri2, strArr2, null, null, null);
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                if (query.moveToFirst()) {
                    return query.getString(columnIndexOrThrow);
                }
            } catch (Exception e) {
                Exception exc = e;
            }
        } else if ("file".equalsIgnoreCase(uri2.getScheme())) {
            return uri2.getPath();
        }
        return null;
    }

    public static File getPathWithoutFilename(File file) {
        File file2;
        File file3 = file;
        if (file3 == null) {
            return null;
        }
        if (file3.isDirectory()) {
            return file3;
        }
        String name = file3.getName();
        String absolutePath = file3.getAbsolutePath();
        String substring = absolutePath.substring(0, absolutePath.length() - name.length());
        if (substring.endsWith("/")) {
            substring = substring.substring(0, -1 + substring.length());
        }
        File file4 = file2;
        File file5 = new File(substring);
        return file4;
    }

    public static String getReadableFileSize(int i) {
        DecimalFormat decimalFormat;
        StringBuilder sb;
        int i2 = i;
        DecimalFormat decimalFormat2 = decimalFormat;
        DecimalFormat decimalFormat3 = new DecimalFormat("###.#");
        DecimalFormat decimalFormat4 = decimalFormat2;
        String str = " KB";
        float f = 0.0f;
        if (i2 > 1024) {
            f = (float) (i2 / 1024);
            if (f > 1024.0f) {
                f /= 1024.0f;
                if (f > 1024.0f) {
                    f /= 1024.0f;
                    str = " GB";
                } else {
                    str = " MB";
                }
            }
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return String.valueOf(sb2.append(decimalFormat4.format((double) f)).append(str).toString());
    }

    public static Bitmap getThumbnail(Context context, Uri uri) {
        Context context2 = context;
        Uri uri2 = uri;
        return getThumbnail(context2, uri2, getMimeType(context2, getFile(uri2)));
    }

    public static Bitmap getThumbnail(Context context, Uri uri, String str) {
        Context context2 = context;
        Uri uri2 = uri;
        String str2 = str;
        Bitmap bitmap = null;
        if (isMediaUri(uri2)) {
            int e = Log.e(TAG, "You can only retrieve thumbnails for images and videos.");
        } else {
            bitmap = null;
            if (uri2 != null) {
                ContentResolver contentResolver = context2.getContentResolver();
                Cursor cursor = null;
                try {
                    cursor = contentResolver.query(uri2, null, null, null, null);
                    bitmap = null;
                    if (cursor.moveToFirst()) {
                        int i = cursor.getInt(0);
                        if (str2.contains("video")) {
                            bitmap = Thumbnails.getThumbnail(contentResolver, (long) i, 1, null);
                        } else {
                            bitmap = null;
                            if (str2.contains(MIME_TYPE_IMAGE)) {
                                bitmap = Images.Thumbnails.getThumbnail(contentResolver, (long) i, 1, null);
                            }
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                        return bitmap;
                    }
                } catch (Exception e2) {
                    Exception exc = e2;
                    bitmap = null;
                    if (cursor != null) {
                        cursor.close();
                        return null;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th2;
                }
            }
        }
        return bitmap;
    }

    public static Bitmap getThumbnail(Context context, File file) {
        Context context2 = context;
        File file2 = file;
        return getThumbnail(context2, getUri(file2), getMimeType(context2, file2));
    }

    public static Uri getUri(File file) {
        File file2 = file;
        if (file2 != null) {
            return Uri.fromFile(file2);
        }
        return null;
    }

    public static boolean isLocal(String str) {
        String str2 = str;
        return str2 != null && !str2.startsWith("http://");
    }

    public static boolean isMediaUri(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(Media.INTERNAL_CONTENT_URI.toString()) || uri2.startsWith(Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(Video.Media.INTERNAL_CONTENT_URI.toString()) || uri2.startsWith(Video.Media.EXTERNAL_CONTENT_URI.toString());
    }
}

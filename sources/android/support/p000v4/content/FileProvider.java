package android.support.p000v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v4.content.FileProvider */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS;
    private static final File DEVICE_ROOT;
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static HashMap<String, PathStrategy> sCache;
    private PathStrategy mStrategy;

    /* renamed from: android.support.v4.content.FileProvider$PathStrategy */
    interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    /* renamed from: android.support.v4.content.FileProvider$SimplePathStrategy */
    static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots;

        public SimplePathStrategy(String str) {
            HashMap<String, File> hashMap;
            String str2 = str;
            HashMap<String, File> hashMap2 = hashMap;
            HashMap<String, File> hashMap3 = new HashMap<>();
            this.mRoots = hashMap2;
            this.mAuthority = str2;
        }

        public void addRoot(String str, File file) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            IllegalArgumentException illegalArgumentException2;
            String str2 = str;
            File file2 = file;
            if (TextUtils.isEmpty(str2)) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Name must not be empty");
                throw illegalArgumentException3;
            }
            try {
                Object put = this.mRoots.put(str2, file2.getCanonicalFile());
            } catch (IOException e) {
                IOException iOException = e;
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb2.append("Failed to resolve canonical path for ").append(file2).toString(), iOException);
                throw illegalArgumentException5;
            }
        }

        public File getFileForUri(Uri uri) {
            File file;
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            SecurityException securityException;
            IllegalArgumentException illegalArgumentException2;
            StringBuilder sb2;
            Uri uri2 = uri;
            String encodedPath = uri2.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file2 = (File) this.mRoots.get(decode);
            if (file2 == null) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(sb3.append("Unable to find configured root for ").append(uri2).toString());
                throw illegalArgumentException3;
            }
            File file3 = file;
            File file4 = new File(file2, decode2);
            File file5 = file3;
            try {
                File canonicalFile = file5.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file2.getPath())) {
                    return canonicalFile;
                }
                SecurityException securityException2 = securityException;
                SecurityException securityException3 = new SecurityException("Resolved path jumped beyond configured root");
                throw securityException2;
            } catch (IOException e) {
                IOException iOException = e;
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb5.append("Failed to resolve canonical path for ").append(file5).toString());
                throw illegalArgumentException5;
            }
        }

        public Uri getUriForFile(File file) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            StringBuilder sb2;
            Builder builder;
            IllegalArgumentException illegalArgumentException2;
            StringBuilder sb3;
            File file2 = file;
            try {
                String canonicalPath = file2.getCanonicalPath();
                Entry entry = null;
                for (Entry entry2 : this.mRoots.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                    StringBuilder sb4 = sb3;
                    StringBuilder sb5 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(sb4.append("Failed to find configured root that contains ").append(canonicalPath).toString());
                    throw illegalArgumentException3;
                }
                String path2 = ((File) entry.getValue()).getPath();
                String substring = path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(1 + path2.length());
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                String sb8 = sb6.append(Uri.encode((String) entry.getKey())).append(ClassPathElement.SEPARATOR_CHAR).append(Uri.encode(substring, "/")).toString();
                Builder builder2 = builder;
                Builder builder3 = new Builder();
                return builder2.scheme("content").authority(this.mAuthority).encodedPath(sb8).build();
            } catch (IOException e) {
                IOException iOException = e;
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                StringBuilder sb9 = sb;
                StringBuilder sb10 = new StringBuilder();
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb9.append("Failed to resolve canonical path for ").append(file2).toString());
                throw illegalArgumentException5;
            }
        }
    }

    static {
        File file;
        HashMap<String, PathStrategy> hashMap;
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = "_display_name";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "_size";
        COLUMNS = strArr4;
        File file2 = file;
        File file3 = new File("/");
        DEVICE_ROOT = file2;
        HashMap<String, PathStrategy> hashMap2 = hashMap;
        HashMap<String, PathStrategy> hashMap3 = new HashMap<>();
        sCache = hashMap2;
    }

    public FileProvider() {
    }

    private static File buildPath(File file, String... strArr) {
        File file2;
        File file3;
        File file4 = file;
        String[] strArr2 = strArr;
        int length = strArr2.length;
        int i = 0;
        File file5 = file4;
        while (true) {
            File file6 = file5;
            if (i >= length) {
                return file6;
            }
            String str = strArr2[i];
            if (str != null) {
                file2 = file3;
                File file7 = new File(file6, str);
            } else {
                file2 = file6;
            }
            i++;
            file5 = file2;
        }
    }

    private static Object[] copyOf(Object[] objArr, int i) {
        int i2 = i;
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        return objArr2;
    }

    private static String[] copyOf(String[] strArr, int i) {
        int i2 = i;
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, i2);
        return strArr2;
    }

    private static PathStrategy getPathStrategy(Context context, String str) {
        PathStrategy pathStrategy;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        Context context2 = context;
        String str2 = str;
        HashMap<String, PathStrategy> hashMap = sCache;
        synchronized (hashMap) {
            try {
                pathStrategy = (PathStrategy) sCache.get(str2);
                if (pathStrategy == null) {
                    pathStrategy = parsePathStrategy(context2, str2);
                    Object put = sCache.put(str2, pathStrategy);
                }
            } catch (IOException e) {
                IOException iOException = e;
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", iOException);
                throw illegalArgumentException3;
            } catch (XmlPullParserException e2) {
                XmlPullParserException xmlPullParserException = e2;
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", xmlPullParserException);
                throw illegalArgumentException5;
            } catch (Throwable th) {
                Throwable th2 = th;
                HashMap<String, PathStrategy> hashMap2 = hashMap;
                throw th2;
            }
        }
        return pathStrategy;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return getPathStrategy(context, str).getUriForFile(file);
    }

    private static int modeToMode(String str) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        String str2 = str;
        if ("r".equals(str2)) {
            return 268435456;
        }
        if ("w".equals(str2) || "wt".equals(str2)) {
            return 738197504;
        }
        if ("wa".equals(str2)) {
            return 704643072;
        }
        if ("rw".equals(str2)) {
            return 939524096;
        }
        if ("rwt".equals(str2)) {
            return 1006632960;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid mode: ").append(str2).toString());
        throw illegalArgumentException2;
    }

    private static PathStrategy parsePathStrategy(Context context, String str) throws IOException, XmlPullParserException {
        SimplePathStrategy simplePathStrategy;
        File file;
        IllegalArgumentException illegalArgumentException;
        Context context2 = context;
        String str2 = str;
        SimplePathStrategy simplePathStrategy2 = simplePathStrategy;
        SimplePathStrategy simplePathStrategy3 = new SimplePathStrategy(str2);
        SimplePathStrategy simplePathStrategy4 = simplePathStrategy2;
        XmlResourceParser loadXmlMetaData = context2.getPackageManager().resolveContentProvider(str2, 128).loadXmlMetaData(context2.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (loadXmlMetaData == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            throw illegalArgumentException2;
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                return simplePathStrategy4;
            }
            if (next == 2) {
                String name = loadXmlMetaData.getName();
                String attributeValue = loadXmlMetaData.getAttributeValue(null, ATTR_NAME);
                String attributeValue2 = loadXmlMetaData.getAttributeValue(null, ATTR_PATH);
                if (TAG_ROOT_PATH.equals(name)) {
                    File file2 = DEVICE_ROOT;
                    String[] strArr = new String[1];
                    String[] strArr2 = strArr;
                    strArr[0] = attributeValue2;
                    file = buildPath(file2, strArr2);
                } else if (TAG_FILES_PATH.equals(name)) {
                    File filesDir = context2.getFilesDir();
                    String[] strArr3 = new String[1];
                    String[] strArr4 = strArr3;
                    strArr3[0] = attributeValue2;
                    file = buildPath(filesDir, strArr4);
                } else if (TAG_CACHE_PATH.equals(name)) {
                    File cacheDir = context2.getCacheDir();
                    String[] strArr5 = new String[1];
                    String[] strArr6 = strArr5;
                    strArr5[0] = attributeValue2;
                    file = buildPath(cacheDir, strArr6);
                } else {
                    file = null;
                    if (TAG_EXTERNAL.equals(name)) {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        String[] strArr7 = new String[1];
                        String[] strArr8 = strArr7;
                        strArr7[0] = attributeValue2;
                        file = buildPath(externalStorageDirectory, strArr8);
                    }
                }
                if (file != null) {
                    simplePathStrategy4.addRoot(attributeValue, file);
                }
            }
        }
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        SecurityException securityException;
        SecurityException securityException2;
        Context context2 = context;
        ProviderInfo providerInfo2 = providerInfo;
        super.attachInfo(context2, providerInfo2);
        if (providerInfo2.exported) {
            SecurityException securityException3 = securityException2;
            SecurityException securityException4 = new SecurityException("Provider must not be exported");
            throw securityException3;
        } else if (!providerInfo2.grantUriPermissions) {
            SecurityException securityException5 = securityException;
            SecurityException securityException6 = new SecurityException("Provider must grant uri permissions");
            throw securityException5;
        } else {
            this.mStrategy = getPathStrategy(context2, providerInfo2.authority);
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String str2 = str;
        String[] strArr2 = strArr;
        return this.mStrategy.getFileForUri(uri).delete() ? 1 : 0;
    }

    public String getType(Uri uri) {
        Uri uri2 = uri;
        File fileForUri = this.mStrategy.getFileForUri(uri2);
        int lastIndexOf = fileForUri.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        UnsupportedOperationException unsupportedOperationException;
        Uri uri2 = uri;
        ContentValues contentValues2 = contentValues;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("No external inserts");
        throw unsupportedOperationException2;
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(uri), modeToMode(str));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        MatrixCursor matrixCursor;
        int i;
        String[] strArr3 = strArr;
        String str3 = str;
        String[] strArr4 = strArr2;
        String str4 = str2;
        File fileForUri = this.mStrategy.getFileForUri(uri);
        if (strArr3 == null) {
            strArr3 = COLUMNS;
        }
        String[] strArr5 = new String[strArr3.length];
        Object[] objArr = new Object[strArr3.length];
        String[] strArr6 = strArr3;
        int length = strArr6.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 < length) {
                String str5 = strArr6[i2];
                if ("_display_name".equals(str5)) {
                    strArr5[i4] = "_display_name";
                    i = i4 + 1;
                    objArr[i4] = fileForUri.getName();
                } else if ("_size".equals(str5)) {
                    strArr5[i4] = "_size";
                    i = i4 + 1;
                    objArr[i4] = Long.valueOf(fileForUri.length());
                } else {
                    i = i4;
                }
                i2++;
                i3 = i;
            } else {
                String[] copyOf = copyOf(strArr5, i4);
                Object[] copyOf2 = copyOf(objArr, i4);
                MatrixCursor matrixCursor2 = matrixCursor;
                MatrixCursor matrixCursor3 = new MatrixCursor(copyOf, 1);
                MatrixCursor matrixCursor4 = matrixCursor2;
                matrixCursor4.addRow(copyOf2);
                return matrixCursor4;
            }
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        UnsupportedOperationException unsupportedOperationException;
        Uri uri2 = uri;
        ContentValues contentValues2 = contentValues;
        String str2 = str;
        String[] strArr2 = strArr;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("No external updates");
        throw unsupportedOperationException2;
    }
}

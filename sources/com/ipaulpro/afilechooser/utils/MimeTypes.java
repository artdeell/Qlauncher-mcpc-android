package com.ipaulpro.afilechooser.utils;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.ipaulpro.afilechooser.FileChooserActivity;
import java.util.HashMap;
import java.util.Map;

public class MimeTypes {
    private Map<String, String> mMimeTypes;

    public MimeTypes() {
        HashMap hashMap;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.mMimeTypes = hashMap2;
    }

    public String getMimeType(Uri uri) {
        return getMimeType(FileUtils.getFile(uri).getName());
    }

    public String getMimeType(String str) {
        String extension = FileUtils.getExtension(str);
        if (extension.length() > 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.substring(1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        String str2 = (String) this.mMimeTypes.get(extension.toLowerCase());
        if (str2 == null) {
            str2 = FileChooserActivity.MIME_TYPE_ALL;
        }
        return str2;
    }

    public void put(String str, String str2) {
        Object put = this.mMimeTypes.put(str, str2.toLowerCase());
    }
}

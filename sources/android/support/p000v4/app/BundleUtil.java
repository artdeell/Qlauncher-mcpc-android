package android.support.p000v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Arrays;

/* renamed from: android.support.v4.app.BundleUtil */
class BundleUtil {
    BundleUtil() {
    }

    public static Bundle[] getBundleArrayFromBundle(Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        String str2 = str;
        Parcelable[] parcelableArray = bundle2.getParcelableArray(str2);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle2.putParcelableArray(str2, bundleArr);
        return bundleArr;
    }
}

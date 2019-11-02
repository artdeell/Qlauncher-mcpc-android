package net.minecraft.kdt;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontChangeCrawler {
    private Typeface typeface;

    public FontChangeCrawler(Typeface typeface2) {
        this.typeface = typeface2;
    }

    public FontChangeCrawler(AssetManager assetManager, String str) {
        this.typeface = Typeface.createFromAsset(assetManager, str);
    }

    public void replaceFonts(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = viewGroup;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewGroup2.getChildCount()) {
                View childAt = viewGroup2.getChildAt(i2);
                if (childAt instanceof ViewGroup) {
                    replaceFonts((ViewGroup) childAt);
                } else if (childAt instanceof TextView) {
                    ((TextView) childAt).setTypeface(this.typeface);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}

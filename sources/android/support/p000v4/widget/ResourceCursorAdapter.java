package android.support.p000v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.ResourceCursorAdapter */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor) {
        Context context2 = context;
        int i2 = i;
        super(context2, cursor);
        this.mDropDownLayout = i2;
        this.mLayout = i2;
        this.mInflater = (LayoutInflater) context2.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, int i2) {
        Context context2 = context;
        int i3 = i;
        super(context2, cursor, i2);
        this.mDropDownLayout = i3;
        this.mLayout = i3;
        this.mInflater = (LayoutInflater) context2.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        Context context2 = context;
        int i2 = i;
        super(context2, cursor, z);
        this.mDropDownLayout = i2;
        this.mLayout = i2;
        this.mInflater = (LayoutInflater) context2.getSystemService("layout_inflater");
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        Context context2 = context;
        Cursor cursor2 = cursor;
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        Context context2 = context;
        Cursor cursor2 = cursor;
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int i) {
        int i2 = i;
        this.mDropDownLayout = i2;
    }

    public void setViewResource(int i) {
        int i2 = i;
        this.mLayout = i2;
    }
}

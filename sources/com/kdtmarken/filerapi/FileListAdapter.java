package com.kdtmarken.filerapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.kdt.C0634R;

public class FileListAdapter extends BaseAdapter {
    private static final int ICON_FILE = 2130837509;
    private static final int ICON_FOLDER = 2130837510;
    private List<File> mData;
    private final LayoutInflater mInflater;

    public /* bridge */ Object getItem(int i) {
        return getItem(i);
    }

    public FileListAdapter(Context context) {
        ArrayList arrayList;
        Context context2 = context;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.mData = arrayList2;
        this.mInflater = LayoutInflater.from(context2);
    }

    public void add(File file) {
        boolean add = this.mData.add(file);
        notifyDataSetChanged();
    }

    public void remove(File file) {
        boolean remove = this.mData.remove(file);
        notifyDataSetChanged();
    }

    public void insert(File file, int i) {
        int i2 = i;
        this.mData.add(i2, file);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mData.clear();
        notifyDataSetChanged();
    }

    @Override
    public File getItem(int i) {
        return (File) this.mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long) i;
    }

    @Override
    public int getCount() {
        return this.mData.size();
    }

    public List<File> getListItems() {
        return this.mData;
    }

    public void setListItems(List<File> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = i;
        ViewGroup viewGroup2 = viewGroup;
        View view2 = view;
        if (view2 == null) {
            view2 = this.mInflater.inflate(17367043, viewGroup2, false);
        }
        TextView textView = (TextView) view2;
        File item = getItem(i2);
        textView.setText(item.getName());
        textView.setCompoundDrawablesWithIntrinsicBounds(item.isDirectory() ? C0634R.C0635drawable.ic_folder : C0634R.C0635drawable.ic_file, 0, 0, 0);
        return view2;
    }
}

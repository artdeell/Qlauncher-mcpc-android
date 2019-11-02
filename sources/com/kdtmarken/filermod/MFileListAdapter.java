package com.kdtmarken.filermod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MFileListAdapter extends BaseAdapter {
    private List<File> mData;
    private final LayoutInflater mInflater;

    public /* bridge */ Object getItem(int i) {
        return getItem(i);
    }

    public MFileListAdapter(Context context) {
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
        ((TextView) view2).setText(getItem(i2).getName());
        return view2;
    }
}

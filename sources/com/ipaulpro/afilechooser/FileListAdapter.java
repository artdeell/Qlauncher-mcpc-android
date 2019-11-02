package com.ipaulpro.afilechooser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;

public class FileListAdapter extends BaseAdapter {
    private static final int ICON_FILE = C0539R.C0540drawable.ic_file;
    private static final int ICON_FOLDER = C0539R.C0540drawable.ic_folder;
    private ArrayList<File> mFiles;
    private LayoutInflater mInflater;

    static class ViewHolder {
        ImageView iconView;
        TextView nameView;

        ViewHolder(View view) {
            View view2 = view;
            this.nameView = (TextView) view2.findViewById(C0539R.C0541id.file_name);
            this.iconView = (ImageView) view2.findViewById(C0539R.C0541id.file_icon);
        }
    }

    public FileListAdapter(Context context) {
        ArrayList<File> arrayList;
        Context context2 = context;
        ArrayList<File> arrayList2 = arrayList;
        ArrayList<File> arrayList3 = new ArrayList<>();
        this.mFiles = arrayList2;
        this.mInflater = LayoutInflater.from(context2);
    }

    public void add(File file) {
        File file2 = file;
        boolean add = this.mFiles.add(file2);
    }

    public void clear() {
        this.mFiles.clear();
    }

    public int getCount() {
        return this.mFiles.size();
    }

    public Object getItem(int i) {
        return this.mFiles.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        ViewHolder viewHolder2;
        int i2 = i;
        ViewGroup viewGroup2 = viewGroup;
        View view2 = view;
        if (view2 == null) {
            view2 = this.mInflater.inflate(C0539R.layout.file, viewGroup2, false);
            ViewHolder viewHolder3 = viewHolder2;
            ViewHolder viewHolder4 = new ViewHolder(view2);
            viewHolder = viewHolder3;
            view2.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view2.getTag();
        }
        File file = (File) getItem(i2);
        viewHolder.nameView.setText(file.getName());
        viewHolder.iconView.setImageResource(file.isDirectory() ? ICON_FOLDER : ICON_FILE);
        return view2;
    }

    public void setListItems(ArrayList<File> arrayList) {
        ArrayList<File> arrayList2 = arrayList;
        this.mFiles = arrayList2;
    }
}

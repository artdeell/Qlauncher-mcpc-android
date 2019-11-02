package com.tonicsystems.jarjar.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.Jar;
import org.apache.tools.zip.JarMarker;
import org.apache.tools.zip.ZipExtraField;
import org.apache.tools.zip.ZipOutputStream;

public abstract class AntJarProcessor extends Jar {
    private static final ZipExtraField[] JAR_MARKER = {JarMarker.getInstance()};
    private byte[] buf = new byte[8192];
    private Set<String> dirs;
    private boolean filesOnly;
    private JarProcessor proc;
    private EntryStruct struct;
    protected boolean verbose;

    public AntJarProcessor() {
        EntryStruct entryStruct;
        HashSet hashSet;
        EntryStruct entryStruct2 = entryStruct;
        EntryStruct entryStruct3 = new EntryStruct();
        this.struct = entryStruct2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        this.dirs = hashSet2;
    }

    private void addParentDirs(String str, ZipOutputStream zipOutputStream) throws IOException {
        StringBuilder sb;
        String str2 = str;
        ZipOutputStream zipOutputStream2 = zipOutputStream;
        int lastIndexOf = str2.lastIndexOf(47);
        if (lastIndexOf >= 0) {
            String substring = str2.substring(0, lastIndexOf);
            if (this.dirs.add(substring)) {
                addParentDirs(substring, zipOutputStream2);
                File file = null;
                ZipOutputStream zipOutputStream3 = zipOutputStream2;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                AntJarProcessor.super.zipDir(file, zipOutputStream3, sb2.append(substring).append("/").toString(), 16877, JAR_MARKER);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void cleanHelper() {
        this.verbose = false;
        this.filesOnly = false;
        this.dirs.clear();
    }

    /* access modifiers changed from: protected */
    public void cleanUp() {
        AntJarProcessor.super.cleanUp();
        cleanHelper();
    }

    public abstract void execute() throws BuildException;

    public void execute(JarProcessor jarProcessor) throws BuildException {
        this.proc = jarProcessor;
        AntJarProcessor.super.execute();
    }

    public void reset() {
        AntJarProcessor.super.reset();
        cleanHelper();
    }

    public void setFilesonly(boolean z) {
        boolean z2 = z;
        AntJarProcessor.super.setFilesonly(z2);
        this.filesOnly = z2;
    }

    public void setVerbose(boolean z) {
        boolean z2 = z;
        this.verbose = z2;
    }

    /* access modifiers changed from: protected */
    public void zipDir(File file, ZipOutputStream zipOutputStream, String str, int i) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void zipFile(InputStream inputStream, ZipOutputStream zipOutputStream, String str, long j, File file, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream2 = inputStream;
        ZipOutputStream zipOutputStream2 = zipOutputStream;
        String str2 = str;
        long j2 = j;
        File file2 = file;
        int i2 = i;
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
        IoUtil.pipe(inputStream2, byteArrayOutputStream4, this.buf);
        this.struct.data = byteArrayOutputStream4.toByteArray();
        this.struct.name = str2;
        this.struct.time = j2;
        if (this.proc.process(this.struct)) {
            if (i2 == 0) {
                i2 = 33188;
            }
            if (!this.filesOnly) {
                addParentDirs(this.struct.name, zipOutputStream2);
            }
            ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(this.struct.data);
            AntJarProcessor.super.zipFile(byteArrayInputStream2, zipOutputStream2, this.struct.name, this.struct.time, file2, i2);
        }
    }
}

package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.AntJarProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.tools.ant.BuildException;

public class JarJarTask extends AntJarProcessor {
    private List<PatternElement> patterns;

    public JarJarTask() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.patterns = arrayList2;
    }

    public void addConfiguredKeep(Keep keep) {
        IllegalArgumentException illegalArgumentException;
        Keep keep2 = keep;
        if (keep2.getPattern() == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The <keep> element requires a \"pattern\" attribute.");
            throw illegalArgumentException2;
        }
        boolean add = this.patterns.add(keep2);
    }

    public void addConfiguredRule(Rule rule) {
        IllegalArgumentException illegalArgumentException;
        Rule rule2 = rule;
        if (rule2.getPattern() == null || rule2.getResult() == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The <rule> element requires both \"pattern\" and \"result\" attributes.");
            throw illegalArgumentException2;
        }
        boolean add = this.patterns.add(rule2);
    }

    public void addConfiguredZap(Zap zap) {
        IllegalArgumentException illegalArgumentException;
        Zap zap2 = zap;
        if (zap2.getPattern() == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The <zap> element requires a \"pattern\" attribute.");
            throw illegalArgumentException2;
        }
        boolean add = this.patterns.add(zap2);
    }

    /* access modifiers changed from: protected */
    public void cleanHelper() {
        super.cleanHelper();
        this.patterns.clear();
    }

    public void execute() throws BuildException {
        MainProcessor mainProcessor;
        Throwable th;
        MainProcessor mainProcessor2 = mainProcessor;
        MainProcessor mainProcessor3 = new MainProcessor(this.patterns, this.verbose, false);
        MainProcessor mainProcessor4 = mainProcessor2;
        execute(mainProcessor4);
        try {
            mainProcessor4.strip(getDestFile());
        } catch (IOException e) {
            IOException iOException = e;
            Throwable th2 = th;
            Throwable buildException = new BuildException(iOException);
            throw th2;
        }
    }
}

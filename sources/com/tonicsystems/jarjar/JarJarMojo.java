package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.StandaloneJarProcessor;
import java.io.File;
import java.io.IOException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

public class JarJarMojo extends AbstractMojo {
    private File fromJar;
    private String rules;
    private File rulesFile;
    private File toJar;
    private boolean verbose;

    public JarJarMojo() {
    }

    public void execute() throws MojoExecutionException {
        Throwable th;
        MainProcessor mainProcessor;
        Throwable th2;
        boolean z = true;
        boolean z2 = this.rulesFile == null || !this.rulesFile.exists();
        if (this.rules != null) {
            z = false;
        }
        if (!(z2 ^ z)) {
            Throwable th3 = th2;
            Throwable mojoExecutionException = new MojoExecutionException("Exactly one of rules or rulesFile is required");
            throw th3;
        }
        try {
            MainProcessor mainProcessor2 = mainProcessor;
            MainProcessor mainProcessor3 = new MainProcessor(this.rules != null ? RulesFileParser.parse(this.rules) : RulesFileParser.parse(this.rulesFile), this.verbose, true);
            MainProcessor mainProcessor4 = mainProcessor2;
            StandaloneJarProcessor.run(this.fromJar, this.toJar, mainProcessor4);
            mainProcessor4.strip(this.toJar);
        } catch (IOException e) {
            IOException iOException = e;
            Throwable th4 = th;
            Throwable mojoExecutionException2 = new MojoExecutionException(iOException.getMessage(), iOException);
            throw th4;
        }
    }
}

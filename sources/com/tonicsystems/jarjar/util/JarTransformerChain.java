package com.tonicsystems.jarjar.util;

import org.objectweb.asm.ClassVisitor;

public class JarTransformerChain extends JarTransformer {
    private final RemappingClassTransformer[] chain;

    public JarTransformerChain(RemappingClassTransformer[] remappingClassTransformerArr) {
        RemappingClassTransformer[] remappingClassTransformerArr2 = remappingClassTransformerArr;
        this.chain = (RemappingClassTransformer[]) remappingClassTransformerArr2.clone();
        for (int length = -1 + remappingClassTransformerArr2.length; length > 0; length--) {
            remappingClassTransformerArr2[length - 1].setTarget(remappingClassTransformerArr2[length]);
        }
    }

    /* access modifiers changed from: protected */
    public ClassVisitor transform(ClassVisitor classVisitor) {
        this.chain[-1 + this.chain.length].setTarget(classVisitor);
        return this.chain[0];
    }
}

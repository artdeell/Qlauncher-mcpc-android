package com.google.ads.mediation;

import com.google.android.gms.internal.zzin;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public abstract class MediationServerParameters {

    public static final class MappingException extends Exception {
        public MappingException(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Parameter {
        String name();

        boolean required() default true;
    }

    public MediationServerParameters() {
    }

    public void load(Map<String, String> map) throws MappingException {
        HashMap hashMap;
        StringBuilder sb;
        MappingException mappingException;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        Map<String, String> map2 = map;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        Field[] fields = getClass().getFields();
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            Field field = fields[i];
            Parameter parameter = (Parameter) field.getAnnotation(Parameter.class);
            if (parameter != null) {
                Object put = hashMap4.put(parameter.name(), field);
            }
        }
        if (hashMap4.isEmpty()) {
            zzin.zzaK("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Entry entry : map2.entrySet()) {
            Field field2 = (Field) hashMap4.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    IllegalAccessException illegalAccessException = e;
                    StringBuilder sb7 = sb6;
                    StringBuilder sb8 = new StringBuilder();
                    zzin.zzaK(sb7.append("Server option \"").append((String) entry.getKey()).append("\" could not be set: Illegal Access").toString());
                } catch (IllegalArgumentException e2) {
                    IllegalArgumentException illegalArgumentException = e2;
                    StringBuilder sb9 = sb5;
                    StringBuilder sb10 = new StringBuilder();
                    zzin.zzaK(sb9.append("Server option \"").append((String) entry.getKey()).append("\" could not be set: Bad Type").toString());
                }
            } else {
                StringBuilder sb11 = sb4;
                StringBuilder sb12 = new StringBuilder();
                zzin.zzaI(sb11.append("Unexpected server option: ").append((String) entry.getKey()).append(" = \"").append((String) entry.getValue()).append("\"").toString());
            }
        }
        StringBuilder sb13 = sb;
        StringBuilder sb14 = new StringBuilder();
        StringBuilder sb15 = sb13;
        for (Field field3 : hashMap4.values()) {
            if (((Parameter) field3.getAnnotation(Parameter.class)).required()) {
                StringBuilder sb16 = sb3;
                StringBuilder sb17 = new StringBuilder();
                zzin.zzaK(sb16.append("Required server option missing: ").append(((Parameter) field3.getAnnotation(Parameter.class)).name()).toString());
                if (sb15.length() > 0) {
                    StringBuilder append = sb15.append(", ");
                }
                StringBuilder append2 = sb15.append(((Parameter) field3.getAnnotation(Parameter.class)).name());
            }
        }
        if (sb15.length() > 0) {
            MappingException mappingException2 = mappingException;
            StringBuilder sb18 = sb2;
            StringBuilder sb19 = new StringBuilder();
            MappingException mappingException3 = new MappingException(sb18.append("Required server option(s) missing: ").append(sb15.toString()).toString());
            throw mappingException2;
        }
        zzA();
    }

    /* access modifiers changed from: protected */
    public void zzA() {
    }
}

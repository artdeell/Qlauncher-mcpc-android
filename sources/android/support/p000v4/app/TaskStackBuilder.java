package android.support.p000v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.app.TaskStackBuilder */
public class TaskStackBuilder implements Iterable<Intent> {
    private static final TaskStackBuilderImpl IMPL;
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents;
    private final Context mSourceContext;

    /* renamed from: android.support.v4.app.TaskStackBuilder$SupportParentable */
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$TaskStackBuilderImpl */
    interface TaskStackBuilderImpl {
        PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle);
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplBase */
    static class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        TaskStackBuilderImplBase() {
        }

        public PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            Intent intent;
            Context context2 = context;
            Intent[] intentArr2 = intentArr;
            int i3 = i;
            int i4 = i2;
            Bundle bundle2 = bundle;
            Intent intent2 = intent;
            Intent intent3 = new Intent(intentArr2[-1 + intentArr2.length]);
            Intent intent4 = intent2;
            Intent addFlags = intent4.addFlags(268435456);
            return PendingIntent.getActivity(context2, i3, intent4, i4);
        }
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplHoneycomb */
    static class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        TaskStackBuilderImplHoneycomb() {
        }

        public PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            Intent intent;
            Context context2 = context;
            Intent[] intentArr2 = intentArr;
            int i3 = i;
            int i4 = i2;
            Bundle bundle2 = bundle;
            Intent[] intentArr3 = intentArr2;
            Intent intent2 = intent;
            Intent intent3 = new Intent(intentArr2[0]);
            intentArr3[0] = intent2.addFlags(268484608);
            return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context2, i3, intentArr2, i4);
        }
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplJellybean */
    static class TaskStackBuilderImplJellybean implements TaskStackBuilderImpl {
        TaskStackBuilderImplJellybean() {
        }

        public PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            Intent intent;
            Context context2 = context;
            Intent[] intentArr2 = intentArr;
            int i3 = i;
            int i4 = i2;
            Bundle bundle2 = bundle;
            Intent[] intentArr3 = intentArr2;
            Intent intent2 = intent;
            Intent intent3 = new Intent(intentArr2[0]);
            intentArr3[0] = intent2.addFlags(268484608);
            return TaskStackBuilderJellybean.getActivitiesPendingIntent(context2, i3, intentArr2, i4, bundle2);
        }
    }

    static {
        TaskStackBuilderImplBase taskStackBuilderImplBase;
        TaskStackBuilderImplHoneycomb taskStackBuilderImplHoneycomb;
        if (VERSION.SDK_INT >= 11) {
            TaskStackBuilderImplHoneycomb taskStackBuilderImplHoneycomb2 = taskStackBuilderImplHoneycomb;
            TaskStackBuilderImplHoneycomb taskStackBuilderImplHoneycomb3 = new TaskStackBuilderImplHoneycomb();
            IMPL = taskStackBuilderImplHoneycomb2;
            return;
        }
        TaskStackBuilderImplBase taskStackBuilderImplBase2 = taskStackBuilderImplBase;
        TaskStackBuilderImplBase taskStackBuilderImplBase3 = new TaskStackBuilderImplBase();
        IMPL = taskStackBuilderImplBase2;
    }

    private TaskStackBuilder(Context context) {
        ArrayList<Intent> arrayList;
        Context context2 = context;
        ArrayList<Intent> arrayList2 = arrayList;
        ArrayList<Intent> arrayList3 = new ArrayList<>();
        this.mIntents = arrayList2;
        this.mSourceContext = context2;
    }

    public static TaskStackBuilder create(Context context) {
        TaskStackBuilder taskStackBuilder;
        TaskStackBuilder taskStackBuilder2 = taskStackBuilder;
        TaskStackBuilder taskStackBuilder3 = new TaskStackBuilder(context);
        return taskStackBuilder2;
    }

    public static TaskStackBuilder from(Context context) {
        return create(context);
    }

    public TaskStackBuilder addNextIntent(Intent intent) {
        boolean add = this.mIntents.add(intent);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent intent) {
        Intent intent2 = intent;
        ComponentName component = intent2.getComponent();
        if (component == null) {
            component = intent2.resolveActivity(this.mSourceContext.getPackageManager());
        }
        if (component != null) {
            TaskStackBuilder addParentStack = addParentStack(component);
        }
        TaskStackBuilder addNextIntent = addNextIntent(intent2);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity activity) {
        Activity activity2 = activity;
        Intent intent = null;
        if (activity2 instanceof SupportParentable) {
            intent = ((SupportParentable) activity2).getSupportParentActivityIntent();
        }
        if (intent == null) {
            intent = NavUtils.getParentActivityIntent(activity2);
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.mSourceContext.getPackageManager());
            }
            TaskStackBuilder addParentStack = addParentStack(component);
            TaskStackBuilder addNextIntent = addNextIntent(intent);
        }
        return this;
    }

    public TaskStackBuilder addParentStack(ComponentName componentName) {
        IllegalArgumentException illegalArgumentException;
        ComponentName componentName2 = componentName;
        int size = this.mIntents.size();
        try {
            Intent parentActivityIntent = NavUtils.getParentActivityIntent(this.mSourceContext, componentName2);
            while (true) {
                Intent intent = parentActivityIntent;
                if (intent != null) {
                    this.mIntents.add(size, intent);
                    parentActivityIntent = NavUtils.getParentActivityIntent(this.mSourceContext, intent.getComponent());
                } else {
                    return this;
                }
            }
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            int e2 = Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(nameNotFoundException);
            throw illegalArgumentException2;
        }
    }

    public TaskStackBuilder addParentStack(Class<?> cls) {
        ComponentName componentName;
        ComponentName componentName2 = componentName;
        ComponentName componentName3 = new ComponentName(this.mSourceContext, cls);
        return addParentStack(componentName2);
    }

    public Intent editIntentAt(int i) {
        return (Intent) this.mIntents.get(i);
    }

    public Intent getIntent(int i) {
        return editIntentAt(i);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public Intent[] getIntents() {
        Intent intent;
        Intent intent2;
        Intent[] intentArr = new Intent[this.mIntents.size()];
        if (intentArr.length != 0) {
            Intent[] intentArr2 = intentArr;
            Intent intent3 = intent;
            Intent intent4 = new Intent((Intent) this.mIntents.get(0));
            intentArr2[0] = intent3.addFlags(268484608);
            for (int i = 1; i < intentArr.length; i++) {
                Intent[] intentArr3 = intentArr;
                int i2 = i;
                Intent intent5 = intent2;
                Intent intent6 = new Intent((Intent) this.mIntents.get(i));
                intentArr3[i2] = intent5;
            }
        }
        return intentArr;
    }

    public PendingIntent getPendingIntent(int i, int i2) {
        return getPendingIntent(i, i2, null);
    }

    public PendingIntent getPendingIntent(int i, int i2, Bundle bundle) {
        Intent intent;
        IllegalStateException illegalStateException;
        int i3 = i;
        int i4 = i2;
        Bundle bundle2 = bundle;
        if (this.mIntents.isEmpty()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
            throw illegalStateException2;
        }
        Intent[] intentArr = (Intent[]) this.mIntents.toArray(new Intent[this.mIntents.size()]);
        Intent[] intentArr2 = intentArr;
        Intent intent2 = intent;
        Intent intent3 = new Intent(intentArr[0]);
        intentArr2[0] = intent2.addFlags(268484608);
        return IMPL.getPendingIntent(this.mSourceContext, intentArr, i3, i4, bundle2);
    }

    public Iterator<Intent> iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(Bundle bundle) {
        Intent intent;
        Intent intent2;
        IllegalStateException illegalStateException;
        Bundle bundle2 = bundle;
        if (this.mIntents.isEmpty()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            throw illegalStateException2;
        }
        Intent[] intentArr = (Intent[]) this.mIntents.toArray(new Intent[this.mIntents.size()]);
        Intent[] intentArr2 = intentArr;
        Intent intent3 = intent;
        Intent intent4 = new Intent(intentArr[0]);
        intentArr2[0] = intent3.addFlags(268484608);
        if (!ContextCompat.startActivities(this.mSourceContext, intentArr, bundle2)) {
            Intent intent5 = intent2;
            Intent intent6 = new Intent(intentArr[-1 + intentArr.length]);
            Intent intent7 = intent5;
            Intent addFlags = intent7.addFlags(268435456);
            this.mSourceContext.startActivity(intent7);
        }
    }
}

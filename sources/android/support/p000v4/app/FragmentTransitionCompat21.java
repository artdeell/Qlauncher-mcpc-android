package android.support.p000v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: android.support.v4.app.FragmentTransitionCompat21 */
class FragmentTransitionCompat21 {

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21$EpicenterView */
    public static class EpicenterView {
        public View epicenter;

        public EpicenterView() {
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21$ViewRetriever */
    public interface ViewRetriever {
        View getView();
    }

    FragmentTransitionCompat21() {
    }

    public static void addTargets(Object obj, ArrayList<View> arrayList) {
        ArrayList<View> arrayList2 = arrayList;
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                addTargets(transitionSet.getTransitionAt(i), arrayList2);
            }
        } else if (!hasSimpleTarget(transition) && isNullOrEmpty(transition.getTargets())) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                Transition addTarget = transition.addTarget((View) arrayList2.get(i2));
            }
        }
    }

    public static void addTransitionTargets(Object obj, Object obj2, View view, ViewRetriever viewRetriever, View view2, EpicenterView epicenterView, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList2) {
        C00252 r22;
        Object obj3 = obj;
        Object obj4 = obj2;
        View view3 = view;
        ViewRetriever viewRetriever2 = viewRetriever;
        View view4 = view2;
        EpicenterView epicenterView2 = epicenterView;
        Map<String, String> map4 = map;
        ArrayList<View> arrayList3 = arrayList;
        Map<String, View> map5 = map2;
        Map<String, View> map6 = map3;
        ArrayList<View> arrayList4 = arrayList2;
        if (obj3 != null || obj4 != null) {
            Transition transition = (Transition) obj3;
            if (transition != null) {
                Transition addTarget = transition.addTarget(view4);
            }
            if (obj4 != null) {
                setSharedElementTargets(obj4, view4, map5, arrayList4);
            }
            if (viewRetriever2 != null) {
                ViewTreeObserver viewTreeObserver = view3.getViewTreeObserver();
                C00252 r13 = r22;
                final View view5 = view3;
                final Transition transition2 = transition;
                final View view6 = view4;
                final ViewRetriever viewRetriever3 = viewRetriever2;
                final Map<String, String> map7 = map4;
                final Map<String, View> map8 = map6;
                final ArrayList<View> arrayList5 = arrayList3;
                C00252 r14 = new OnPreDrawListener() {
                    {
                        Transition transition = r12;
                        View view = r13;
                        ViewRetriever viewRetriever = r14;
                        Map map = r15;
                        Map map2 = r16;
                        ArrayList arrayList = r17;
                    }

                    public boolean onPreDraw() {
                        view5.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (transition2 != null) {
                            Transition removeTarget = transition2.removeTarget(view6);
                        }
                        View view = viewRetriever3.getView();
                        if (view != null) {
                            if (!map7.isEmpty()) {
                                FragmentTransitionCompat21.findNamedViews(map8, view);
                                boolean retainAll = map8.keySet().retainAll(map7.values());
                                for (Entry entry : map7.entrySet()) {
                                    View view2 = (View) map8.get((String) entry.getValue());
                                    if (view2 != null) {
                                        view2.setTransitionName((String) entry.getKey());
                                    }
                                }
                            }
                            if (transition2 != null) {
                                FragmentTransitionCompat21.captureTransitioningViews(arrayList5, view);
                                boolean removeAll = arrayList5.removeAll(map8.values());
                                boolean add = arrayList5.add(view6);
                                FragmentTransitionCompat21.addTargets(transition2, arrayList5);
                            }
                        }
                        return true;
                    }
                };
                viewTreeObserver.addOnPreDrawListener(r13);
            }
            setSharedElementEpicenter(transition, epicenterView2);
        }
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    private static void bfsAddViewChildren(List<View> list, View view) {
        List<View> list2 = list;
        View view2 = view;
        int size = list2.size();
        if (!containedBeforeIndex(list2, view2, size)) {
            boolean add = list2.add(view2);
            for (int i = size; i < list2.size(); i++) {
                View view3 = (View) list2.get(i);
                if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!containedBeforeIndex(list2, childAt, size)) {
                            boolean add2 = list2.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static Object captureExitingViews(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        Object obj2 = obj;
        View view3 = view;
        ArrayList<View> arrayList2 = arrayList;
        Map<String, View> map2 = map;
        View view4 = view2;
        if (obj2 != null) {
            captureTransitioningViews(arrayList2, view3);
            if (map2 != null) {
                boolean removeAll = arrayList2.removeAll(map2.values());
            }
            if (arrayList2.isEmpty()) {
                obj2 = null;
            } else {
                boolean add = arrayList2.add(view4);
                addTargets((Transition) obj2, arrayList2);
                return obj2;
            }
        }
        return obj2;
    }

    /* access modifiers changed from: private */
    public static void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = arrayList;
        View view2 = view;
        if (view2.getVisibility() != 0) {
            return;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            if (viewGroup.isTransitionGroup()) {
                boolean add = arrayList2.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                captureTransitioningViews(arrayList2, viewGroup.getChildAt(i));
            }
            return;
        }
        boolean add2 = arrayList2.add(view2);
    }

    public static void cleanupTransitions(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        C00274 r29;
        View view3 = view;
        View view4 = view2;
        ArrayList<View> arrayList5 = arrayList;
        ArrayList<View> arrayList6 = arrayList2;
        ArrayList<View> arrayList7 = arrayList3;
        ArrayList<View> arrayList8 = arrayList4;
        Map<String, View> map2 = map;
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            ViewTreeObserver viewTreeObserver = view3.getViewTreeObserver();
            C00274 r16 = r29;
            final View view5 = view3;
            final Transition transition5 = transition;
            final ArrayList<View> arrayList9 = arrayList5;
            final Transition transition6 = transition2;
            final ArrayList<View> arrayList10 = arrayList6;
            final Transition transition7 = transition3;
            final ArrayList<View> arrayList11 = arrayList7;
            final Map<String, View> map3 = map2;
            final ArrayList<View> arrayList12 = arrayList8;
            final Transition transition8 = transition4;
            final View view6 = view4;
            C00274 r17 = new OnPreDrawListener() {
                {
                    Transition transition = r16;
                    ArrayList arrayList = r17;
                    Transition transition2 = r18;
                    ArrayList arrayList2 = r19;
                    Transition transition3 = r20;
                    ArrayList arrayList3 = r21;
                    Map map = r22;
                    ArrayList arrayList4 = r23;
                    Transition transition4 = r24;
                    View view = r25;
                }

                public boolean onPreDraw() {
                    view5.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (transition5 != null) {
                        FragmentTransitionCompat21.removeTargets(transition5, arrayList9);
                    }
                    if (transition6 != null) {
                        FragmentTransitionCompat21.removeTargets(transition6, arrayList10);
                    }
                    if (transition7 != null) {
                        FragmentTransitionCompat21.removeTargets(transition7, arrayList11);
                    }
                    for (Entry entry : map3.entrySet()) {
                        ((View) entry.getValue()).setTransitionName((String) entry.getKey());
                    }
                    int size = arrayList12.size();
                    for (int i = 0; i < size; i++) {
                        Transition excludeTarget = transition8.excludeTarget((View) arrayList12.get(i), false);
                    }
                    Transition excludeTarget2 = transition8.excludeTarget(view6, false);
                    return true;
                }
            };
            viewTreeObserver.addOnPreDrawListener(r16);
        }
    }

    public static Object cloneTransition(Object obj) {
        Object obj2 = obj;
        if (obj2 != null) {
            obj2 = ((Transition) obj2).clone();
        }
        return obj2;
    }

    private static boolean containedBeforeIndex(List<View> list, View view, int i) {
        List<View> list2 = list;
        View view2 = view;
        int i2 = i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (list2.get(i3) == view2) {
                return true;
            }
        }
        return false;
    }

    public static void excludeTarget(Object obj, View view, boolean z) {
        Transition excludeTarget = ((Transition) obj).excludeTarget(view, z);
    }

    public static void findNamedViews(Map<String, View> map, View view) {
        Map<String, View> map2 = map;
        View view2 = view;
        if (view2.getVisibility() == 0) {
            String transitionName = view2.getTransitionName();
            if (transitionName != null) {
                Object put = map2.put(transitionName, view2);
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    findNamedViews(map2, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static Rect getBoundsOnScreen(View view) {
        Rect rect;
        View view2 = view;
        Rect rect2 = rect;
        Rect rect3 = new Rect();
        Rect rect4 = rect2;
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        rect4.set(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
        return rect4;
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    private static boolean hasSimpleTarget(Transition transition) {
        Transition transition2 = transition;
        return !isNullOrEmpty(transition2.getTargetIds()) || !isNullOrEmpty(transition2.getTargetNames()) || !isNullOrEmpty(transition2.getTargetTypes());
    }

    private static boolean isNullOrEmpty(List list) {
        List list2 = list;
        return list2 == null || list2.isEmpty();
    }

    public static Object mergeTransitions(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition;
        TransitionSet transitionSet;
        TransitionSet transitionSet2;
        TransitionSet transitionSet3;
        boolean z2 = z;
        boolean z3 = true;
        Transition transition2 = (Transition) obj;
        Transition transition3 = (Transition) obj2;
        Transition transition4 = (Transition) obj3;
        if (!(transition2 == null || transition3 == null)) {
            z3 = z2;
        }
        if (z3) {
            TransitionSet transitionSet4 = transitionSet3;
            TransitionSet transitionSet5 = new TransitionSet();
            TransitionSet transitionSet6 = transitionSet4;
            if (transition2 != null) {
                TransitionSet addTransition = transitionSet6.addTransition(transition2);
            }
            if (transition3 != null) {
                TransitionSet addTransition2 = transitionSet6.addTransition(transition3);
            }
            if (transition4 != null) {
                TransitionSet addTransition3 = transitionSet6.addTransition(transition4);
            }
            return transitionSet6;
        }
        if (transition3 != null && transition2 != null) {
            TransitionSet transitionSet7 = transitionSet2;
            TransitionSet transitionSet8 = new TransitionSet();
            transition = transitionSet7.addTransition(transition3).addTransition(transition2).setOrdering(1);
        } else if (transition3 != null) {
            transition = transition3;
        } else {
            transition = null;
            if (transition2 != null) {
                transition = transition2;
            }
        }
        if (transition4 == null) {
            return transition;
        }
        TransitionSet transitionSet9 = transitionSet;
        TransitionSet transitionSet10 = new TransitionSet();
        TransitionSet transitionSet11 = transitionSet9;
        if (transition != null) {
            TransitionSet addTransition4 = transitionSet11.addTransition(transition);
        }
        TransitionSet addTransition5 = transitionSet11.addTransition(transition4);
        return transitionSet11;
    }

    public static void removeTargets(Object obj, ArrayList<View> arrayList) {
        ArrayList<View> arrayList2 = arrayList;
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                removeTargets(transitionSet.getTransitionAt(i), arrayList2);
            }
        } else if (!hasSimpleTarget(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList2.size() && targets.containsAll(arrayList2)) {
                for (int size = -1 + arrayList2.size(); size >= 0; size--) {
                    Transition removeTarget = transition.removeTarget((View) arrayList2.get(size));
                }
            }
        }
    }

    public static void setEpicenter(Object obj, View view) {
        C00241 r6;
        Transition transition = (Transition) obj;
        C00241 r3 = r6;
        final Rect boundsOnScreen = getBoundsOnScreen(view);
        C00241 r4 = new EpicenterCallback() {
            public Rect onGetEpicenter(Transition transition) {
                Transition transition2 = transition;
                return boundsOnScreen;
            }
        };
        transition.setEpicenterCallback(r3);
    }

    private static void setSharedElementEpicenter(Transition transition, EpicenterView epicenterView) {
        C00263 r6;
        Transition transition2 = transition;
        EpicenterView epicenterView2 = epicenterView;
        if (transition2 != null) {
            Transition transition3 = transition2;
            C00263 r3 = r6;
            final EpicenterView epicenterView3 = epicenterView2;
            C00263 r4 = new EpicenterCallback() {
                private Rect mEpicenter;

                public Rect onGetEpicenter(Transition transition) {
                    Transition transition2 = transition;
                    if (this.mEpicenter == null && epicenterView3.epicenter != null) {
                        this.mEpicenter = FragmentTransitionCompat21.getBoundsOnScreen(epicenterView3.epicenter);
                    }
                    return this.mEpicenter;
                }
            };
            transition3.setEpicenterCallback(r3);
        }
    }

    public static void setSharedElementTargets(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        View view2 = view;
        Map<String, View> map2 = map;
        ArrayList<View> arrayList2 = arrayList;
        TransitionSet transitionSet = (TransitionSet) obj;
        arrayList2.clear();
        boolean addAll = arrayList2.addAll(map2.values());
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            bfsAddViewChildren(targets, (View) arrayList2.get(i));
        }
        boolean add = arrayList2.add(view2);
        addTargets(transitionSet, arrayList2);
    }

    public static Object wrapSharedElementTransition(Object obj) {
        TransitionSet transitionSet;
        Object obj2 = obj;
        if (obj2 != null) {
            Transition transition = (Transition) obj2;
            if (transition != null) {
                TransitionSet transitionSet2 = transitionSet;
                TransitionSet transitionSet3 = new TransitionSet();
                TransitionSet transitionSet4 = transitionSet2;
                TransitionSet addTransition = transitionSet4.addTransition(transition);
                return transitionSet4;
            }
        }
        return null;
    }
}

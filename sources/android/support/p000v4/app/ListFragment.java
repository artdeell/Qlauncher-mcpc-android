package android.support.p000v4.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* renamed from: android.support.v4.app.ListFragment */
public class ListFragment extends Fragment {
    static final int INTERNAL_EMPTY_ID = 16711681;
    static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    private final Handler mHandler;
    ListView mList;
    View mListContainer;
    boolean mListShown;
    private final OnItemClickListener mOnClickListener;
    View mProgressContainer;
    private final Runnable mRequestFocus;
    TextView mStandardEmptyView;

    public ListFragment() {
        Handler handler;
        C00281 r5;
        C00292 r52;
        Handler handler2 = handler;
        Handler handler3 = new Handler();
        this.mHandler = handler2;
        C00281 r2 = r5;
        C00281 r3 = new Runnable(this) {
            final /* synthetic */ ListFragment this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                this.this$0.mList.focusableViewAvailable(this.this$0.mList);
            }
        };
        this.mRequestFocus = r2;
        C00292 r22 = r52;
        C00292 r32 = new OnItemClickListener(this) {
            final /* synthetic */ ListFragment this$0;

            {
                this.this$0 = r5;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                View view2 = view;
                int i2 = i;
                long j2 = j;
                this.this$0.onListItemClick((ListView) adapterView, view2, i2, j2);
            }
        };
        this.mOnClickListener = r22;
    }

    private void ensureList() {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        IllegalStateException illegalStateException;
        if (this.mList == null) {
            View view = getView();
            if (view == null) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Content view not yet created");
                throw illegalStateException2;
            }
            if (view instanceof ListView) {
                this.mList = (ListView) view;
            } else {
                this.mStandardEmptyView = (TextView) view.findViewById(INTERNAL_EMPTY_ID);
                if (this.mStandardEmptyView == null) {
                    this.mEmptyView = view.findViewById(16908292);
                } else {
                    this.mStandardEmptyView.setVisibility(8);
                }
                this.mProgressContainer = view.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
                this.mListContainer = view.findViewById(INTERNAL_LIST_CONTAINER_ID);
                View findViewById = view.findViewById(16908298);
                if (findViewById instanceof ListView) {
                    this.mList = (ListView) findViewById;
                    if (this.mEmptyView != null) {
                        this.mList.setEmptyView(this.mEmptyView);
                    } else if (this.mEmptyText != null) {
                        this.mStandardEmptyView.setText(this.mEmptyText);
                        this.mList.setEmptyView(this.mStandardEmptyView);
                    }
                } else if (findViewById == null) {
                    RuntimeException runtimeException3 = runtimeException2;
                    RuntimeException runtimeException4 = new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    throw runtimeException3;
                } else {
                    RuntimeException runtimeException5 = runtimeException;
                    RuntimeException runtimeException6 = new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                    throw runtimeException5;
                }
            }
            this.mListShown = true;
            this.mList.setOnItemClickListener(this.mOnClickListener);
            if (this.mAdapter != null) {
                ListAdapter listAdapter = this.mAdapter;
                this.mAdapter = null;
                setListAdapter(listAdapter);
            } else if (this.mProgressContainer != null) {
                setListShown(false, false);
            }
            boolean post = this.mHandler.post(this.mRequestFocus);
        }
    }

    private void setListShown(boolean z, boolean z2) {
        IllegalStateException illegalStateException;
        boolean z3 = z;
        boolean z4 = z2;
        ensureList();
        if (this.mProgressContainer == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Can't be used with a custom content view");
            throw illegalStateException2;
        } else if (this.mListShown != z3) {
            this.mListShown = z3;
            if (z3) {
                if (z4) {
                    this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
                    this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                } else {
                    this.mProgressContainer.clearAnimation();
                    this.mListContainer.clearAnimation();
                }
                this.mProgressContainer.setVisibility(8);
                this.mListContainer.setVisibility(0);
                return;
            }
            if (z4) {
                this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
            } else {
                this.mProgressContainer.clearAnimation();
                this.mListContainer.clearAnimation();
            }
            this.mProgressContainer.setVisibility(0);
            this.mListContainer.setVisibility(8);
        }
    }

    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }

    public ListView getListView() {
        ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        ensureList();
        return this.mList.getSelectedItemPosition();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout;
        LinearLayout linearLayout;
        ProgressBar progressBar;
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        FrameLayout frameLayout2;
        TextView textView;
        LayoutParams layoutParams3;
        ListView listView;
        LayoutParams layoutParams4;
        LayoutParams layoutParams5;
        LayoutParams layoutParams6;
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        Bundle bundle2 = bundle;
        FragmentActivity activity = getActivity();
        FrameLayout frameLayout3 = frameLayout;
        FrameLayout frameLayout4 = new FrameLayout(activity);
        FrameLayout frameLayout5 = frameLayout3;
        LinearLayout linearLayout2 = linearLayout;
        LinearLayout linearLayout3 = new LinearLayout(activity);
        LinearLayout linearLayout4 = linearLayout2;
        linearLayout4.setId(INTERNAL_PROGRESS_CONTAINER_ID);
        linearLayout4.setOrientation(1);
        linearLayout4.setVisibility(8);
        linearLayout4.setGravity(17);
        LinearLayout linearLayout5 = linearLayout4;
        ProgressBar progressBar2 = progressBar;
        ProgressBar progressBar3 = new ProgressBar(activity, null, 16842874);
        LayoutParams layoutParams7 = layoutParams;
        LayoutParams layoutParams8 = new LayoutParams(-2, -2);
        linearLayout5.addView(progressBar2, layoutParams7);
        FrameLayout frameLayout6 = frameLayout5;
        LinearLayout linearLayout6 = linearLayout4;
        LayoutParams layoutParams9 = layoutParams2;
        LayoutParams layoutParams10 = new LayoutParams(-1, -1);
        frameLayout6.addView(linearLayout6, layoutParams9);
        FrameLayout frameLayout7 = frameLayout2;
        FrameLayout frameLayout8 = new FrameLayout(activity);
        FrameLayout frameLayout9 = frameLayout7;
        frameLayout9.setId(INTERNAL_LIST_CONTAINER_ID);
        TextView textView2 = textView;
        TextView textView3 = new TextView(getActivity());
        TextView textView4 = textView2;
        textView4.setId(INTERNAL_EMPTY_ID);
        textView4.setGravity(17);
        FrameLayout frameLayout10 = frameLayout9;
        TextView textView5 = textView4;
        LayoutParams layoutParams11 = layoutParams3;
        LayoutParams layoutParams12 = new LayoutParams(-1, -1);
        frameLayout10.addView(textView5, layoutParams11);
        ListView listView2 = listView;
        ListView listView3 = new ListView(getActivity());
        ListView listView4 = listView2;
        listView4.setId(16908298);
        listView4.setDrawSelectorOnTop(false);
        FrameLayout frameLayout11 = frameLayout9;
        ListView listView5 = listView4;
        LayoutParams layoutParams13 = layoutParams4;
        LayoutParams layoutParams14 = new LayoutParams(-1, -1);
        frameLayout11.addView(listView5, layoutParams13);
        FrameLayout frameLayout12 = frameLayout5;
        FrameLayout frameLayout13 = frameLayout9;
        LayoutParams layoutParams15 = layoutParams5;
        LayoutParams layoutParams16 = new LayoutParams(-1, -1);
        frameLayout12.addView(frameLayout13, layoutParams15);
        FrameLayout frameLayout14 = frameLayout5;
        LayoutParams layoutParams17 = layoutParams6;
        LayoutParams layoutParams18 = new LayoutParams(-1, -1);
        frameLayout14.setLayoutParams(layoutParams17);
        return frameLayout5;
    }

    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ensureList();
    }

    public void setEmptyText(CharSequence charSequence) {
        IllegalStateException illegalStateException;
        CharSequence charSequence2 = charSequence;
        ensureList();
        if (this.mStandardEmptyView == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Can't be used with a custom content view");
            throw illegalStateException2;
        }
        this.mStandardEmptyView.setText(charSequence2);
        if (this.mEmptyText == null) {
            this.mList.setEmptyView(this.mStandardEmptyView);
        }
        this.mEmptyText = charSequence2;
    }

    public void setListAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = listAdapter;
        boolean z = this.mAdapter != null;
        this.mAdapter = listAdapter2;
        if (this.mList != null) {
            this.mList.setAdapter(listAdapter2);
            if (!this.mListShown && !z) {
                boolean z2 = false;
                if (getView().getWindowToken() != null) {
                    z2 = true;
                }
                setListShown(true, z2);
            }
        }
    }

    public void setListShown(boolean z) {
        setListShown(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        setListShown(z, false);
    }

    public void setSelection(int i) {
        int i2 = i;
        ensureList();
        this.mList.setSelection(i2);
    }
}

package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
@zzhb
public class zzc extends zzi implements OnAudioFocusChangeListener, OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> zzDN;
    private final zzt zzDO;
    private int zzDP = 0;
    private int zzDQ = 0;
    private MediaPlayer zzDR;
    private Uri zzDS;
    private int zzDT;
    private int zzDU;
    private int zzDV;
    private int zzDW;
    private int zzDX;
    private float zzDY = 1.0f;
    private boolean zzDZ;
    private boolean zzEa;
    private int zzEb;
    /* access modifiers changed from: private */
    public zzh zzEc;

    static {
        HashMap hashMap;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        zzDN = hashMap2;
        Object put = zzDN.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
        Object put2 = zzDN.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
        Object put3 = zzDN.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
        Object put4 = zzDN.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
        Object put5 = zzDN.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        Object put6 = zzDN.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        Object put7 = zzDN.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        Object put8 = zzDN.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        Object put9 = zzDN.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        Object put10 = zzDN.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        Object put11 = zzDN.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        Object put12 = zzDN.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        Object put13 = zzDN.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        Object put14 = zzDN.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        Object put15 = zzDN.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        Object put16 = zzDN.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzc(Context context, zzt zzt) {
        zzt zzt2 = zzt;
        super(context);
        setSurfaceTextureListener(this);
        this.zzDO = zzt2;
        this.zzDO.zza((zzi) this);
    }

    private void zzb(float f) {
        float f2 = f;
        if (this.zzDR != null) {
            try {
                this.zzDR.setVolume(f2, f2);
            } catch (IllegalStateException e) {
                IllegalStateException illegalStateException = e;
            }
        } else {
            zzin.zzaK("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private void zzfa() {
        Throwable th;
        StringBuilder sb;
        MediaPlayer mediaPlayer;
        Surface surface;
        zzin.m20v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzDS != null && surfaceTexture != null) {
            zzv(false);
            try {
                MediaPlayer mediaPlayer2 = mediaPlayer;
                MediaPlayer mediaPlayer3 = new MediaPlayer();
                this.zzDR = mediaPlayer2;
                this.zzDR.setOnBufferingUpdateListener(this);
                this.zzDR.setOnCompletionListener(this);
                this.zzDR.setOnErrorListener(this);
                this.zzDR.setOnInfoListener(this);
                this.zzDR.setOnPreparedListener(this);
                this.zzDR.setOnVideoSizeChangedListener(this);
                this.zzDV = 0;
                this.zzDR.setDataSource(getContext(), this.zzDS);
                MediaPlayer mediaPlayer4 = this.zzDR;
                Surface surface2 = surface;
                Surface surface3 = new Surface(surfaceTexture);
                mediaPlayer4.setSurface(surface2);
                this.zzDR.setAudioStreamType(3);
                this.zzDR.setScreenOnWhilePlaying(true);
                this.zzDR.prepareAsync();
                zzw(1);
                return;
            } catch (IOException e) {
                th = e;
            } catch (IllegalArgumentException e2) {
                th = e2;
            }
        } else {
            return;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzd(sb2.append("Failed to initialize MediaPlayer at ").append(this.zzDS).toString(), th);
        boolean onError = onError(this.zzDR, 1, 0);
    }

    private void zzfb() {
        if (zzfe() && this.zzDR.getCurrentPosition() > 0 && this.zzDQ != 3) {
            zzin.m20v("AdMediaPlayerView nudging MediaPlayer");
            zzb(0.0f);
            this.zzDR.start();
            int currentPosition = this.zzDR.getCurrentPosition();
            long currentTimeMillis = zzr.zzbG().currentTimeMillis();
            while (zzfe() && this.zzDR.getCurrentPosition() == currentPosition) {
                if (zzr.zzbG().currentTimeMillis() - currentTimeMillis > 250) {
                    break;
                }
            }
            this.zzDR.pause();
            zzfj();
        }
    }

    private void zzfc() {
        AudioManager zzfk = zzfk();
        if (zzfk != null && !this.zzEa) {
            if (zzfk.requestAudioFocus(this, 3, 2) == 1) {
                zzfh();
            } else {
                zzin.zzaK("AdMediaPlayerView audio focus request failed");
            }
        }
    }

    private void zzfd() {
        zzin.m20v("AdMediaPlayerView abandon audio focus");
        AudioManager zzfk = zzfk();
        if (zzfk != null && this.zzEa) {
            if (zzfk.abandonAudioFocus(this) == 1) {
                this.zzEa = false;
            } else {
                zzin.zzaK("AdMediaPlayerView abandon audio focus failed");
            }
        }
    }

    private boolean zzfe() {
        return (this.zzDR == null || this.zzDP == -1 || this.zzDP == 0 || this.zzDP == 1) ? false : true;
    }

    private void zzfh() {
        zzin.m20v("AdMediaPlayerView audio focus gained");
        this.zzEa = true;
        zzfj();
    }

    private void zzfi() {
        zzin.m20v("AdMediaPlayerView audio focus lost");
        this.zzEa = false;
        zzfj();
    }

    private void zzfj() {
        if (this.zzDZ || !this.zzEa) {
            zzb(0.0f);
        } else {
            zzb(this.zzDY);
        }
    }

    private AudioManager zzfk() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    private void zzv(boolean z) {
        boolean z2 = z;
        zzin.m20v("AdMediaPlayerView release");
        if (this.zzDR != null) {
            this.zzDR.reset();
            this.zzDR.release();
            this.zzDR = null;
            zzw(0);
            if (z2) {
                this.zzDQ = 0;
                zzx(0);
            }
            zzfd();
        }
    }

    private void zzw(int i) {
        int i2 = i;
        if (i2 == 3) {
            this.zzDO.zzfO();
        } else if (this.zzDP == 3 && i2 != 3) {
            this.zzDO.zzfP();
        }
        this.zzDP = i2;
    }

    private void zzx(int i) {
        int i2 = i;
        this.zzDQ = i2;
    }

    public int getCurrentPosition() {
        if (zzfe()) {
            return this.zzDR.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (zzfe()) {
            return this.zzDR.getDuration();
        }
        return -1;
    }

    public int getVideoHeight() {
        if (this.zzDR != null) {
            return this.zzDR.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        if (this.zzDR != null) {
            return this.zzDR.getVideoWidth();
        }
        return 0;
    }

    public void onAudioFocusChange(int i) {
        int i2 = i;
        if (i2 > 0) {
            zzfh();
        } else if (i2 < 0) {
            zzfi();
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        MediaPlayer mediaPlayer2 = mediaPlayer;
        int i2 = i;
        this.zzDV = i2;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        C01742 r6;
        MediaPlayer mediaPlayer2 = mediaPlayer;
        zzin.m20v("AdMediaPlayerView completion");
        zzw(5);
        zzx(5);
        Handler handler = zzir.zzMc;
        C01742 r3 = r6;
        C01742 r4 = new Runnable(this) {
            final /* synthetic */ zzc zzEd;

            {
                this.zzEd = r5;
            }

            public void run() {
                if (this.zzEd.zzEc != null) {
                    this.zzEd.zzEc.zzfB();
                }
            }
        };
        boolean post = handler.post(r3);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb;
        C01753 r12;
        MediaPlayer mediaPlayer2 = mediaPlayer;
        String str = (String) zzDN.get(Integer.valueOf(i));
        String str2 = (String) zzDN.get(Integer.valueOf(i2));
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaK(sb2.append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        zzw(-1);
        zzx(-1);
        Handler handler = zzir.zzMc;
        C01753 r7 = r12;
        final String str3 = str;
        final String str4 = str2;
        C01753 r8 = new Runnable(this) {
            final /* synthetic */ zzc zzEd;

            {
                String str = r8;
                String str2 = r9;
                this.zzEd = r7;
            }

            public void run() {
                if (this.zzEd.zzEc != null) {
                    this.zzEd.zzEc.zzg(str3, str4);
                }
            }
        };
        boolean post = handler.post(r7);
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb;
        MediaPlayer mediaPlayer2 = mediaPlayer;
        String str = (String) zzDN.get(Integer.valueOf(i));
        String str2 = (String) zzDN.get(Integer.valueOf(i2));
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.m20v(sb2.append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int defaultSize = getDefaultSize(this.zzDT, i3);
        int defaultSize2 = getDefaultSize(this.zzDU, i4);
        if (this.zzDT > 0 && this.zzDU > 0) {
            int mode = MeasureSpec.getMode(i3);
            int size = MeasureSpec.getSize(i3);
            int mode2 = MeasureSpec.getMode(i4);
            defaultSize2 = MeasureSpec.getSize(i4);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (defaultSize2 * this.zzDT < size * this.zzDU) {
                    defaultSize = (defaultSize2 * this.zzDT) / this.zzDU;
                } else if (defaultSize2 * this.zzDT > size * this.zzDU) {
                    defaultSize2 = (size * this.zzDU) / this.zzDT;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i5 = (size * this.zzDU) / this.zzDT;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (defaultSize2 * this.zzDT) / this.zzDU;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i6 = this.zzDT;
                int i7 = this.zzDU;
                if (mode2 != Integer.MIN_VALUE || i7 <= defaultSize2) {
                    defaultSize2 = i7;
                    defaultSize = i6;
                } else {
                    defaultSize = (defaultSize2 * this.zzDT) / this.zzDU;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (size * this.zzDU) / this.zzDT;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (VERSION.SDK_INT == 16) {
            if ((this.zzDW > 0 && this.zzDW != defaultSize) || (this.zzDX > 0 && this.zzDX != defaultSize2)) {
                zzfb();
            }
            this.zzDW = defaultSize;
            this.zzDX = defaultSize2;
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        C01731 r6;
        StringBuilder sb;
        MediaPlayer mediaPlayer2 = mediaPlayer;
        zzin.m20v("AdMediaPlayerView prepared");
        zzw(2);
        this.zzDO.zzfz();
        Handler handler = zzir.zzMc;
        C01731 r3 = r6;
        C01731 r4 = new Runnable(this) {
            final /* synthetic */ zzc zzEd;

            {
                this.zzEd = r5;
            }

            public void run() {
                if (this.zzEd.zzEc != null) {
                    this.zzEd.zzEc.zzfz();
                }
            }
        };
        boolean post = handler.post(r3);
        this.zzDT = mediaPlayer2.getVideoWidth();
        this.zzDU = mediaPlayer2.getVideoHeight();
        if (this.zzEb != 0) {
            seekTo(this.zzEb);
        }
        zzfb();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaJ(sb2.append("AdMediaPlayerView stream dimensions: ").append(this.zzDT).append(" x ").append(this.zzDU).toString());
        if (this.zzDQ == 3) {
            play();
        }
        zzfc();
        zzfj();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        C01764 r8;
        SurfaceTexture surfaceTexture2 = surfaceTexture;
        int i3 = i;
        int i4 = i2;
        zzin.m20v("AdMediaPlayerView surface created");
        zzfa();
        Handler handler = zzir.zzMc;
        C01764 r5 = r8;
        C01764 r6 = new Runnable(this) {
            final /* synthetic */ zzc zzEd;

            {
                this.zzEd = r5;
            }

            public void run() {
                if (this.zzEd.zzEc != null) {
                    this.zzEd.zzEc.zzfy();
                }
            }
        };
        boolean post = handler.post(r5);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        C01775 r6;
        SurfaceTexture surfaceTexture2 = surfaceTexture;
        zzin.m20v("AdMediaPlayerView surface destroyed");
        if (this.zzDR != null && this.zzEb == 0) {
            this.zzEb = this.zzDR.getCurrentPosition();
        }
        Handler handler = zzir.zzMc;
        C01775 r3 = r6;
        C01775 r4 = new Runnable(this) {
            final /* synthetic */ zzc zzEd;

            {
                this.zzEd = r5;
            }

            public void run() {
                if (this.zzEd.zzEc != null) {
                    this.zzEd.zzEc.onPaused();
                    this.zzEd.zzEc.zzfC();
                }
            }
        };
        boolean post = handler.post(r3);
        zzv(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = surfaceTexture;
        int i3 = i;
        int i4 = i2;
        boolean z = true;
        zzin.m20v("AdMediaPlayerView surface changed");
        boolean z2 = this.zzDQ == 3;
        if (!(this.zzDT == i3 && this.zzDU == i4)) {
            z = false;
        }
        if (this.zzDR != null && z2 && z) {
            if (this.zzEb != 0) {
                seekTo(this.zzEb);
            }
            play();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = surfaceTexture;
        this.zzDO.zzb(this);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb;
        MediaPlayer mediaPlayer2 = mediaPlayer;
        int i3 = i;
        int i4 = i2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.m20v(sb2.append("AdMediaPlayerView size changed: ").append(i3).append(" x ").append(i4).toString());
        this.zzDT = mediaPlayer2.getVideoWidth();
        this.zzDU = mediaPlayer2.getVideoHeight();
        if (this.zzDT != 0 && this.zzDU != 0) {
            requestLayout();
        }
    }

    public void pause() {
        C01797 r5;
        zzin.m20v("AdMediaPlayerView pause");
        if (zzfe() && this.zzDR.isPlaying()) {
            this.zzDR.pause();
            zzw(4);
            Handler handler = zzir.zzMc;
            C01797 r2 = r5;
            C01797 r3 = new Runnable(this) {
                final /* synthetic */ zzc zzEd;

                {
                    this.zzEd = r5;
                }

                public void run() {
                    if (this.zzEd.zzEc != null) {
                        this.zzEd.zzEc.onPaused();
                    }
                }
            };
            boolean post = handler.post(r2);
        }
        zzx(4);
    }

    public void play() {
        C01786 r5;
        zzin.m20v("AdMediaPlayerView play");
        if (zzfe()) {
            this.zzDR.start();
            zzw(3);
            Handler handler = zzir.zzMc;
            C01786 r2 = r5;
            C01786 r3 = new Runnable(this) {
                final /* synthetic */ zzc zzEd;

                {
                    this.zzEd = r5;
                }

                public void run() {
                    if (this.zzEd.zzEc != null) {
                        this.zzEd.zzEc.zzfA();
                    }
                }
            };
            boolean post = handler.post(r2);
        }
        zzx(3);
    }

    public void seekTo(int i) {
        StringBuilder sb;
        int i2 = i;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.m20v(sb2.append("AdMediaPlayerView seek ").append(i2).toString());
        if (zzfe()) {
            this.zzDR.seekTo(i2);
            this.zzEb = 0;
            return;
        }
        this.zzEb = i2;
    }

    public void setMimeType(String str) {
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.zzDS = uri;
        this.zzEb = 0;
        zzfa();
        requestLayout();
        invalidate();
    }

    public void stop() {
        zzin.m20v("AdMediaPlayerView stop");
        if (this.zzDR != null) {
            this.zzDR.stop();
            this.zzDR.release();
            this.zzDR = null;
            zzw(0);
            zzx(0);
            zzfd();
        }
        this.zzDO.onStop();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).toString();
    }

    public void zza(float f) {
        this.zzDY = f;
        zzfj();
    }

    public void zza(zzh zzh) {
        zzh zzh2 = zzh;
        this.zzEc = zzh2;
    }

    public String zzeZ() {
        return "MediaPlayer";
    }

    public void zzff() {
        this.zzDZ = true;
        zzfj();
    }

    public void zzfg() {
        this.zzDZ = false;
        zzfj();
    }
}

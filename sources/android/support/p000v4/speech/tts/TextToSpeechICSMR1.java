package android.support.p000v4.speech.tts;

import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.speech.tts.UtteranceProgressListener;
import java.util.Locale;
import java.util.Set;

/* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1 */
class TextToSpeechICSMR1 {
    public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";

    /* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1$UtteranceProgressListenerICSMR1 */
    interface UtteranceProgressListenerICSMR1 {
        void onDone(String str);

        void onError(String str);

        void onStart(String str);
    }

    TextToSpeechICSMR1() {
    }

    static Set<String> getFeatures(TextToSpeech textToSpeech, Locale locale) {
        TextToSpeech textToSpeech2 = textToSpeech;
        Locale locale2 = locale;
        if (VERSION.SDK_INT >= 15) {
            return textToSpeech2.getFeatures(locale2);
        }
        return null;
    }

    static void setUtteranceProgressListener(TextToSpeech textToSpeech, UtteranceProgressListenerICSMR1 utteranceProgressListenerICSMR1) {
        C00952 r6;
        C00941 r62;
        TextToSpeech textToSpeech2 = textToSpeech;
        UtteranceProgressListenerICSMR1 utteranceProgressListenerICSMR12 = utteranceProgressListenerICSMR1;
        if (VERSION.SDK_INT >= 15) {
            TextToSpeech textToSpeech3 = textToSpeech2;
            C00941 r3 = r62;
            final UtteranceProgressListenerICSMR1 utteranceProgressListenerICSMR13 = utteranceProgressListenerICSMR12;
            C00941 r4 = new UtteranceProgressListener() {
                public void onDone(String str) {
                    String str2 = str;
                    utteranceProgressListenerICSMR13.onDone(str2);
                }

                public void onError(String str) {
                    String str2 = str;
                    utteranceProgressListenerICSMR13.onError(str2);
                }

                public void onStart(String str) {
                    String str2 = str;
                    utteranceProgressListenerICSMR13.onStart(str2);
                }
            };
            int onUtteranceProgressListener = textToSpeech3.setOnUtteranceProgressListener(r3);
            return;
        }
        TextToSpeech textToSpeech4 = textToSpeech2;
        C00952 r32 = r6;
        final UtteranceProgressListenerICSMR1 utteranceProgressListenerICSMR14 = utteranceProgressListenerICSMR12;
        C00952 r42 = new OnUtteranceCompletedListener() {
            public void onUtteranceCompleted(String str) {
                String str2 = str;
                utteranceProgressListenerICSMR14.onStart(str2);
                utteranceProgressListenerICSMR14.onDone(str2);
            }
        };
        int onUtteranceCompletedListener = textToSpeech4.setOnUtteranceCompletedListener(r32);
    }
}

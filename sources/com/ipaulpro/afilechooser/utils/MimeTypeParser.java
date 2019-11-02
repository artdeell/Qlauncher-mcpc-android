package com.ipaulpro.afilechooser.utils;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class MimeTypeParser {
    public static final String ATTR_EXTENSION = "extension";
    public static final String ATTR_MIMETYPE = "mimetype";
    public static final String TAG_MIMETYPES = "MimeTypes";
    public static final String TAG_TYPE = "type";
    private MimeTypes mMimeTypes;
    private XmlPullParser mXpp;

    public MimeTypeParser() {
    }

    private void addMimeTypeStart() {
        this.mMimeTypes.put(this.mXpp.getAttributeValue(null, ATTR_EXTENSION), this.mXpp.getAttributeValue(null, ATTR_MIMETYPE));
    }

    public MimeTypes fromXml(InputStream inputStream) throws XmlPullParserException, IOException {
        InputStreamReader inputStreamReader;
        InputStream inputStream2 = inputStream;
        this.mXpp = XmlPullParserFactory.newInstance().newPullParser();
        XmlPullParser xmlPullParser = this.mXpp;
        InputStreamReader inputStreamReader2 = inputStreamReader;
        InputStreamReader inputStreamReader3 = new InputStreamReader(inputStream2);
        xmlPullParser.setInput(inputStreamReader2);
        return parse();
    }

    public MimeTypes fromXmlResource(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        this.mXpp = xmlResourceParser;
        return parse();
    }

    public MimeTypes parse() throws XmlPullParserException, IOException {
        MimeTypes mimeTypes;
        MimeTypes mimeTypes2 = mimeTypes;
        MimeTypes mimeTypes3 = new MimeTypes();
        this.mMimeTypes = mimeTypes2;
        int eventType = this.mXpp.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return this.mMimeTypes;
            }
            String name = this.mXpp.getName();
            if (i == 2) {
                if (!name.equals(TAG_MIMETYPES) && name.equals(TAG_TYPE)) {
                    addMimeTypeStart();
                }
            } else if (i == 3 && name.equals(TAG_MIMETYPES)) {
            }
            eventType = this.mXpp.next();
        }
    }
}

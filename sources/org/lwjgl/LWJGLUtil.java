package org.lwjgl;

import android.support.p000v4.p002os.EnvironmentCompat;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class LWJGLUtil {
    public static final boolean CHECKS = (!getPrivilegedBoolean("org.lwjgl.util.NoChecks"));
    public static final boolean DEBUG = true;
    public static final ByteBuffer LWJGLIcon16x16 = loadIcon(LWJGL_ICON_DATA_16x16);
    public static final ByteBuffer LWJGLIcon32x32 = loadIcon(LWJGL_ICON_DATA_32x32);
    private static final String LWJGL_ICON_DATA_16x16 = "ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿþÿÿÿÂ×èÿt¤ËÿP½ÿT¿ÿ¯Òÿçïöÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿõõõÿÿvÿ}ÿªÿ·Õÿ:}µÿHºÿÚçñÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿôøûÿ ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿäääÿ­Ðÿ:}µÿ[Áÿüýþÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿ¶Õÿ___ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\"\"\"ÿÿÿÿÿèðöÿ9|µÿ:}µÿÄØéÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÆÙéÿ«Îÿ\u001d\u001d\u001dÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿfffÿÿÿÿÿÐàíÿ:}µÿ:}µÿ´Ôÿÿÿÿÿòòòÿ¥¥¥ÿßßßÿ¢ÁÜÿ°ÅÖÿ\n\n\nÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ¨¨¨ÿÿÿÿÿºØÿ:}µÿ:}µÿq¡Êÿÿÿÿÿ¡¡¡ÿ\u0000\u0000\u0000ÿ\u0001\u0001\u0001ÿ###ÿÌÌÌÿÐÐÐÿ¥¥¥ÿÿ\\\\\\ÿïïïÿÿÿÿÿ`Ãÿ:}µÿ:}µÿmÈÿÿÿÿÿ^^^ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÏÏÏÿ\u001f\u001f\u001fÿ\u0003\u0003\u0003ÿ+++ÿlllÿÆÆÆÿúüýÿ¿Úÿw¥ÌÿL¼ÿ|¨Îÿÿÿÿÿ\u001b\u001b\u001bÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0017\u0017\u0017ÿÖÖÖÿ\u0001\u0001\u0001ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿRRRÿåååÿ===ÿhhhÿ¦¦§ÿÚÞáÿÿÿÿÿtttÿ\u000e\u000e\u000eÿ\u0000\u0000\u0000ÿYYYÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0002\u0002\u0002ÿCCCÿÿÿÿÿîîîÿÿ¿¿¿ÿVVVÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÓÓÓÿXXXÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ333ÿÿÿÿÿÿÿÿÿüýþÿÿÿÿÿÀÀÀÿ@@@ÿ\u0002\u0002\u0002ÿ\u0000\u0000\u0000ÿ\u001b\u001b\u001bÿûûûÿ\u0017\u0017\u0017ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿxxxÿÿÿÿÿÿÿÿÿÒáîÿ~©ÎÿàêóÿÿÿÿÿÔÔÔÿmmmÿÿÓÓÓÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ½½½ÿÿÿÿÿÿÿÿÿþþþÿfÅÿ=¶ÿ¬Ðÿäíõÿÿÿÿÿÿÿÿÿåååÿ---ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\f\f\fÿöööÿÿÿÿÿÿÿÿÿÿÿÿÿâìôÿM¼ÿ:}µÿ>¶ÿ°Òÿçïöÿÿÿÿÿþþþÿ¼¼¼ÿOOOÿ\u0003\u0003\u0003ÿJJJÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿëòøÿ³ÔÿVÀÿP½ÿw¥Ìÿíóøÿÿÿÿÿÿÿÿÿÿÿÿÿßßßÿæææÿÿÿÿÿ";
    private static final String LWJGL_ICON_DATA_32x32 = "ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿúüýÿËÝìÿ·Öÿo Éÿ\\Âÿ`Ãÿz§Íÿ¬ÈàÿíóøÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿüýþÿµÎãÿZÁÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿE¹ÿ¡ÁÜÿüýþÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿüüüÿâêñÿ¸Ïãÿ®Éàÿ£ÂÜÿºØÿ³Óÿ¬ÏÿnÈÿ=¶ÿ:}µÿ:}µÿ:}µÿr¢ÊÿõøûÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿØØØÿ111ÿ$$$ÿ111ÿ@@@ÿRRRÿeeeÿtttÿÿ÷øøÿ¬Èßÿ;}µÿ:}µÿ:}µÿ:}µÿy§Íÿüýþÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿþþþÿhhhÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ¶¶¶ÿþþþÿ®Ñÿ:}µÿ:}µÿ:}µÿ:}µÿ®ÊáÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÓâîÿáêòÿ(((ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0002\u0002\u0002ÿÞÞÞÿÿÿÿÿõøûÿ[Áÿ:}µÿ:}µÿ:}µÿHºÿôøûÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿìóøÿdÅÿ×ÙÛÿ\u0005\u0005\u0005ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ$$$ÿþþþÿÿÿÿÿÿÿÿÿÀÕçÿ9|µÿ:}µÿ:}µÿ:}µÿ«Èàÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿþÿÿÿx¦Ìÿ{§Íÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿeeeÿÿÿÿÿÿÿÿÿÿÿÿÿâìôÿ7{´ÿ:}µÿ:}µÿ:}µÿfÅÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÃ×èÿ9}µÿ²ÌáÿXXXÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ©©©ÿÿÿÿÿÿÿÿÿÿÿÿÿ¼Òåÿ:}µÿ:}µÿ:}µÿ:}µÿ@·ÿîôùÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿúüýÿZÁÿ=¶ÿÝåíÿ\u001c\u001c\u001cÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0007\u0007\u0007ÿçççÿÿÿÿÿÿÿÿÿÿÿÿÿ®Ñÿ:}µÿ:}µÿ:}µÿ:}µÿ9}µÿÌÞìÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿþþþÿÿÿÿÿÿÿÿÿÿÿÿÿºÒåÿ:}µÿW¿ÿÐÑÑÿ\u0003\u0003\u0003ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ333ÿýýýÿÿÿÿÿÿÿÿÿûüýÿP½ÿ:}µÿ:}µÿ:}µÿ:}µÿ9}µÿ±ÌâÿÿÿÿÿÿÿÿÿÿÿÿÿÊÊÊÿ777ÿaaaÿ¢¢¢ÿÝÝÝÿäìóÿ±Ëáÿ´Íâÿæææÿ###ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿrrrÿÿÿÿÿÿÿÿÿÿÿÿÿØåðÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿ ÀÛÿÿÿÿÿÿÿÿÿÿÿÿÿfffÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0006\u0006\u0006ÿ'''ÿfffÿÔÔÔÿÿÿÿÿöööÿÐÐÐÿÿ^^^ÿ'''ÿ\u0004\u0004\u0004ÿ\u0000\u0000\u0000ÿ\u0003\u0003\u0003ÿÀÀÀÿÿÿÿÿÿÿÿÿÿÿÿÿ¢ÁÛÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿ¿Úÿÿÿÿÿÿÿÿÿûûûÿ%%%ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\\\\\\ÿÿÿÿÿêêêÿÿµµµÿéééÿýýýÿçççÿ²²²ÿ½½½ÿþþþÿÿÿÿÿÿÿÿÿÿÿÿÿkÇÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿ¡ÁÜÿÿÿÿÿÿÿÿÿÛÛÛÿ\u0003\u0003\u0003ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÿÿÿÿÿ___ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u000b\u000b\u000bÿ777ÿvvvÿ···ÿðððÿÿÿÿÿÿÿÿÿÿÿÿÿðõùÿK»ÿ=¶ÿ9|µÿ:}µÿ:}µÿ:}µÿ:}µÿ²Ìâÿÿÿÿÿÿÿÿÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÅÅÅÿ÷÷÷ÿ\u001d\u001d\u001dÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0007\u0007\u0007ÿ<<<ÿßßßÿÿÿÿÿûüýÿüýþÿó÷úÿÌÝëÿ¾Úÿr¡ÉÿL»ÿ:}µÿÉÜëÿÿÿÿÿÿÿÿÿVVVÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u000f\u000f\u000fÿùùùÿÑÑÑÿ\u0003\u0003\u0003ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÿÿÿÿÿùùùÿÿpppÿ°°°ÿêêêÿÿÿÿÿùûüÿÜèòÿöùüÿÿÿÿÿÿÿÿÿ\u0015\u0015\u0015ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿNNNÿÿÿÿÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ»»»ÿÿÿÿÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0004\u0004\u0004ÿ///ÿpppÿ°°°ÿæææÿþþþÿÿÿÿÿ999ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÿÿÿÿÿMMMÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0010\u0010\u0010ÿðððÿÿÿÿÿZZZÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\t\t\tÿ222ÿ±±±ÿöööÿ¡¡¡ÿ555ÿ\u0002\u0002\u0002ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0002\u0002\u0002ÿÑÑÑÿõõõÿ\u0013\u0013\u0013ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿEEEÿþþþÿøøøÿ\u001d\u001d\u001dÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ+++ÿÿÿÿÿÿÿÿÿüüüÿ¾¾¾ÿPPPÿ\u0005\u0005\u0005ÿ%%%ÿùùùÿÂÂÂÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÿÿÿÿÿÒÒÒÿ\u0001\u0001\u0001ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿCCCÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿþþþÿÜÜÜÿàààÿÿÿÿÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0001\u0001\u0001ÿÈÈÈÿÿÿÿÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿßßßÿ)))ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0018\u0018\u0018ÿõõõÿÿÿÿÿJJJÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÏÏÏÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿñöúÿÿÿÿÿÿÿÿÿÿÿÿÿùùùÿµµµÿKKKÿ\u0006\u0006\u0006ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿRRRÿÿÿÿÿøøøÿ\u0010\u0010\u0010ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u001c\u001c\u001cÿøøøÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿ¯ÑÿµÕÿêñ÷ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÛÛÛÿxxxÿ\u001b\u001b\u001bÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÿÿÿÿÿÆÆÆÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿZZZÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÃØéÿ:}µÿC¸ÿ¸Öÿíóøÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿôôôÿ§§§ÿÿôôôÿÿÿÿÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿúûýÿ]Âÿ:}µÿ:}µÿF¹ÿ»Øÿïôùÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0005\u0005\u0005ÿÝÝÝÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÅÙéÿ;~¶ÿ:}µÿ:}µÿ:}µÿHºÿ¾Úÿòöúÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿûûûÿÿ%%%ÿ\u0001\u0001\u0001ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ,,,ÿüüüÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿµÕÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿJ»ÿ£ÂÜÿó÷úÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿúúúÿ°°°ÿEEEÿ\u0004\u0004\u0004ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿ\u0000\u0000\u0000ÿnnnÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿüýþÿ¯Ñÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿM¼ÿ¨ÅÞÿöùüÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿþþþÿÒÒÒÿhhhÿ\u000e\u000e\u000eÿ\u0000\u0000\u0000ÿ\u0001\u0001\u0001ÿ¸¸¸ÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿþþÿÿ±ËâÿL¼ÿ9}µÿ:}µÿ:}µÿ:}µÿ:}µÿ:}µÿM¼ÿ¿Ôçÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿìììÿÿÿýýýÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿó÷úÿµÎãÿ¬ÐÿeÅÿaÄÿlÈÿµÕÿÅÙéÿ÷úüÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿ";
    private static final int PLATFORM = PLATFORM_ANDROID;
    public static final int PLATFORM_ANDROID = 1337;
    public static final String PLATFORM_ANDROID_NAME = "android";
    public static final int PLATFORM_LINUX = 1;
    public static final String PLATFORM_LINUX_NAME = "linux";
    public static final int PLATFORM_MACOSX = 2;
    public static final String PLATFORM_MACOSX_NAME = "macosx";
    public static final int PLATFORM_WINDOWS = 3;
    public static final String PLATFORM_WINDOWS_NAME = "windows";

    public interface TokenFilter {
        boolean accept(Field field, int i);
    }

    public LWJGLUtil() {
    }

    static void execPrivileged(String[] strArr) throws Exception {
        C07391 r6;
        try {
            C07391 r3 = r6;
            final String[] strArr2 = strArr;
            C07391 r4 = new PrivilegedExceptionAction<Process>() {
                public Process run() throws Exception {
                    return Runtime.getRuntime().exec(strArr2);
                }
            };
            Process process = (Process) AccessController.doPrivileged(r3);
            process.getInputStream().close();
            process.getOutputStream().close();
            process.getErrorStream().close();
        } catch (PrivilegedActionException e) {
            throw ((Exception) e.getCause());
        }
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Map<java.lang.Integer, java.lang.String>] */
    /* JADX WARNING: type inference failed for: r10v24, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r10v26, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r10v28, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r10v33 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.Integer, java.lang.String> getClassTokens(org.lwjgl.LWJGLUtil.TokenFilter r14, java.util.Map<java.lang.Integer, java.lang.String> r15, java.lang.Iterable<java.lang.Class> r16) {
        /*
            r0 = r14
            r1 = r15
            r2 = r16
            r10 = r1
            if (r10 != 0) goto L_0x0010
            java.util.HashMap r10 = new java.util.HashMap
            r13 = r10
            r10 = r13
            r11 = r13
            r11.<init>()
            r1 = r10
        L_0x0010:
            r10 = r2
            java.util.Iterator r10 = r10.iterator()
            r3 = r10
        L_0x0016:
            r10 = r3
            boolean r10 = r10.hasNext()
            if (r10 == 0) goto L_0x008e
            r10 = r3
            java.lang.Object r10 = r10.next()
            java.lang.Class r10 = (java.lang.Class) r10
            java.lang.reflect.Field[] r10 = r10.getDeclaredFields()
            r4 = r10
            r10 = r4
            int r10 = r10.length
            r5 = r10
            r10 = 0
            r6 = r10
        L_0x002e:
            r10 = r6
            r11 = r5
            if (r10 >= r11) goto L_0x0016
            r10 = r4
            r11 = r6
            r10 = r10[r11]
            r7 = r10
            r10 = 25
            r11 = r7
            int r11 = r11.getModifiers()
            r10 = r10 & r11
            r11 = 25
            if (r10 != r11) goto L_0x005f
            r10 = r7
            java.lang.Class r10 = r10.getType()
            java.lang.Class r11 = java.lang.Integer.TYPE
            if (r10 != r11) goto L_0x005f
            r10 = r7
            r11 = 0
            int r10 = r10.getInt(r11)     // Catch:{ IllegalAccessException -> 0x0091 }
            r9 = r10
            r10 = r0
            if (r10 == 0) goto L_0x0062
            r10 = r0
            r11 = r7
            r12 = r9
            boolean r10 = r10.accept(r11, r12)     // Catch:{ IllegalAccessException -> 0x0091 }
            if (r10 != 0) goto L_0x0062
        L_0x005f:
            int r6 = r6 + 1
            goto L_0x002e
        L_0x0062:
            r10 = r1
            r11 = r9
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ IllegalAccessException -> 0x0091 }
            boolean r10 = r10.containsKey(r11)     // Catch:{ IllegalAccessException -> 0x0091 }
            if (r10 == 0) goto L_0x007e
            r10 = r1
            r11 = r9
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ IllegalAccessException -> 0x0091 }
            r12 = r9
            java.lang.String r12 = toHexString(r12)     // Catch:{ IllegalAccessException -> 0x0091 }
            java.lang.Object r10 = r10.put(r11, r12)     // Catch:{ IllegalAccessException -> 0x0091 }
            goto L_0x005f
        L_0x007e:
            r10 = r1
            r11 = r9
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ IllegalAccessException -> 0x0091 }
            r12 = r7
            java.lang.String r12 = r12.getName()     // Catch:{ IllegalAccessException -> 0x0091 }
            java.lang.Object r10 = r10.put(r11, r12)     // Catch:{ IllegalAccessException -> 0x0091 }
            goto L_0x005f
        L_0x008e:
            r10 = r1
            r0 = r10
            return r0
        L_0x0091:
            r10 = move-exception
            r8 = r10
            goto L_0x005f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.LWJGLUtil.getClassTokens(org.lwjgl.LWJGLUtil$TokenFilter, java.util.Map, java.lang.Iterable):java.util.Map");
    }

    public static Map<Integer, String> getClassTokens(TokenFilter tokenFilter, Map<Integer, String> map, Class... clsArr) {
        return getClassTokens(tokenFilter, map, (Iterable<Class>) Arrays.asList(clsArr));
    }

    public static String[] getLibraryPaths(String str, String str2, ClassLoader classLoader) {
        ClassLoader classLoader2 = classLoader;
        String str3 = str;
        String[] strArr = new String[1];
        String[] strArr2 = strArr;
        strArr[0] = str2;
        return getLibraryPaths(str3, strArr2, classLoader2);
    }

    public static String[] getLibraryPaths(String str, String[] strArr, ClassLoader classLoader) {
        ArrayList arrayList;
        StringTokenizer stringTokenizer;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        String str2 = str;
        String[] strArr2 = strArr;
        ClassLoader classLoader2 = classLoader;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        String pathFromClassLoader = getPathFromClassLoader(str2, classLoader2);
        if (pathFromClassLoader != null) {
            StringBuilder sb7 = sb6;
            StringBuilder sb8 = new StringBuilder();
            log(sb7.append("getPathFromClassLoader: Path found: ").append(pathFromClassLoader).toString());
            boolean add = arrayList4.add(pathFromClassLoader);
        }
        int length = strArr2.length;
        for (int i = 0; i < length; i++) {
            String str3 = strArr2[i];
            String pathFromClassLoader2 = getPathFromClassLoader("lwjgl", classLoader2);
            if (pathFromClassLoader2 != null) {
                StringBuilder sb9 = sb4;
                StringBuilder sb10 = new StringBuilder();
                log(sb9.append("getPathFromClassLoader: Path found: ").append(pathFromClassLoader2).toString());
                ArrayList arrayList5 = arrayList4;
                StringBuilder sb11 = sb5;
                StringBuilder sb12 = new StringBuilder();
                boolean add2 = arrayList5.add(sb11.append(pathFromClassLoader2.substring(0, pathFromClassLoader2.lastIndexOf(File.separator))).append(File.separator).append(str3).toString());
            }
            String privilegedProperty = getPrivilegedProperty("org.lwjgl.librarypath");
            if (privilegedProperty != null) {
                ArrayList arrayList6 = arrayList4;
                StringBuilder sb13 = sb3;
                StringBuilder sb14 = new StringBuilder();
                boolean add3 = arrayList6.add(sb13.append(privilegedProperty).append(File.separator).append(str3).toString());
            }
            StringTokenizer stringTokenizer2 = stringTokenizer;
            StringTokenizer stringTokenizer3 = new StringTokenizer(getPrivilegedProperty("java.library.path"), File.pathSeparator);
            StringTokenizer stringTokenizer4 = stringTokenizer2;
            while (stringTokenizer4.hasMoreTokens()) {
                String nextToken = stringTokenizer4.nextToken();
                ArrayList arrayList7 = arrayList4;
                StringBuilder sb15 = sb2;
                StringBuilder sb16 = new StringBuilder();
                boolean add4 = arrayList7.add(sb15.append(nextToken).append(File.separator).append(str3).toString());
            }
            String privilegedProperty2 = getPrivilegedProperty("user.dir");
            ArrayList arrayList8 = arrayList4;
            StringBuilder sb17 = sb;
            StringBuilder sb18 = new StringBuilder();
            boolean add5 = arrayList8.add(sb17.append(privilegedProperty2).append(File.separator).append(str3).toString());
            boolean add6 = arrayList4.add(str3);
        }
        return (String[]) arrayList4.toArray(new String[arrayList4.size()]);
    }

    private static String getPathFromClassLoader(String str, ClassLoader classLoader) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        C07413 r14;
        String str2 = str;
        ClassLoader classLoader2 = classLoader;
        Class cls = null;
        try {
            StringBuilder sb4 = sb2;
            StringBuilder sb5 = new StringBuilder();
            log(sb4.append("getPathFromClassLoader: searching for: ").append(str2).toString());
            Class cls2 = classLoader2.getClass();
            while (true) {
                cls = cls2;
                if (cls == null) {
                    break;
                }
                try {
                    C07413 r9 = r14;
                    final Class cls3 = cls;
                    final ClassLoader classLoader3 = classLoader2;
                    final String str3 = str2;
                    C07413 r10 = new PrivilegedExceptionAction<String>() {
                        {
                            ClassLoader classLoader = r8;
                            String str = r9;
                        }

                        public String run() throws Exception {
                            Class[] clsArr = new Class[1];
                            Class[] clsArr2 = clsArr;
                            clsArr[0] = String.class;
                            Method declaredMethod = cls3.getDeclaredMethod("findLibrary", clsArr2);
                            declaredMethod.setAccessible(true);
                            return (String) declaredMethod.invoke(classLoader3, new Object[]{str3});
                        }
                    };
                    return (String) AccessController.doPrivileged(r9);
                } catch (PrivilegedActionException e) {
                    PrivilegedActionException privilegedActionException = e;
                    StringBuilder sb6 = sb3;
                    StringBuilder sb7 = new StringBuilder();
                    log(sb6.append("Failed to locate findLibrary method: ").append(privilegedActionException.getCause()).toString());
                    cls2 = cls.getSuperclass();
                }
            }
        } catch (Exception e2) {
            Exception exc = e2;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            log(sb8.append("Failure locating ").append(exc).append(" using classloader:").append(cls).toString());
        }
        return null;
    }

    public static int getPlatform() {
        return PLATFORM;
    }

    public static String getPlatformName() {
        switch (getPlatform()) {
            case 1:
                return PLATFORM_LINUX_NAME;
            case 2:
                return PLATFORM_MACOSX_NAME;
            case 3:
                return PLATFORM_WINDOWS_NAME;
            case PLATFORM_ANDROID /*1337*/:
                return PLATFORM_ANDROID_NAME;
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static boolean getPrivilegedBoolean(String str) {
        C07424 r4;
        C07424 r1 = r4;
        final String str2 = str;
        C07424 r2 = new PrivilegedAction<Boolean>() {
            public Boolean run() {
                return Boolean.valueOf(Boolean.getBoolean(str2));
            }
        };
        return ((Boolean) AccessController.doPrivileged(r1)).booleanValue();
    }

    public static Integer getPrivilegedInteger(String str) {
        C07435 r4;
        C07435 r1 = r4;
        final String str2 = str;
        C07435 r2 = new PrivilegedAction<Integer>() {
            public Integer run() {
                return Integer.getInteger(str2);
            }
        };
        return (Integer) AccessController.doPrivileged(r1);
    }

    public static Integer getPrivilegedInteger(String str, int i) {
        C07446 r6;
        C07446 r2 = r6;
        final String str2 = str;
        final int i2 = i;
        C07446 r3 = new PrivilegedAction<Integer>() {
            {
                int i = r7;
            }

            public Integer run() {
                return Integer.getInteger(str2, i2);
            }
        };
        return (Integer) AccessController.doPrivileged(r2);
    }

    private static String getPrivilegedProperty(String str) {
        C07402 r4;
        C07402 r1 = r4;
        final String str2 = str;
        C07402 r2 = new PrivilegedAction<String>() {
            public String run() {
                return System.getProperty(str2);
            }
        };
        return (String) AccessController.doPrivileged(r1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        if (r7 >= r1) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isMacOSXEqualsOrBetterThan(int r14, int r15) {
        /*
            r0 = r14
            r1 = r15
            java.util.StringTokenizer r9 = new java.util.StringTokenizer
            r13 = r9
            r9 = r13
            r10 = r13
            java.lang.String r11 = "os.version"
            java.lang.String r11 = getPrivilegedProperty(r11)
            java.lang.String r12 = "."
            r10.<init>(r11, r12)
            r2 = r9
            r9 = r2
            java.lang.String r9 = r9.nextToken()     // Catch:{ Exception -> 0x0040 }
            r4 = r9
            r9 = r2
            java.lang.String r9 = r9.nextToken()     // Catch:{ Exception -> 0x0040 }
            r5 = r9
            r9 = r4
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0040 }
            r6 = r9
            r9 = r5
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0040 }
            r7 = r9
            r9 = r6
            r10 = r0
            if (r9 > r10) goto L_0x003b
            r9 = 0
            r8 = r9
            r9 = r6
            r10 = r0
            if (r9 != r10) goto L_0x003d
            r9 = 0
            r8 = r9
            r9 = r7
            r10 = r1
            if (r9 < r10) goto L_0x003d
        L_0x003b:
            r9 = 1
            r8 = r9
        L_0x003d:
            r9 = r8
            r0 = r9
        L_0x003f:
            return r0
        L_0x0040:
            r9 = move-exception
            r3 = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r13 = r9
            r9 = r13
            r10 = r13
            r10.<init>()
            java.lang.String r10 = "Exception occurred while trying to determine OS version: "
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = r3
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            log(r9)
            r9 = 0
            r0 = r9
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.LWJGLUtil.isMacOSXEqualsOrBetterThan(int, int):boolean");
    }

    private static ByteBuffer loadIcon(String str) {
        String str2 = str;
        int length = str2.length();
        ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(length);
        for (int i = 0; i < length; i++) {
            ByteBuffer put = createByteBuffer.put(i, (byte) str2.charAt(i));
        }
        return createByteBuffer.asReadOnlyBuffer();
    }

    public static void log(CharSequence charSequence) {
        StringBuilder sb;
        CharSequence charSequence2 = charSequence;
        PrintStream printStream = System.err;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("[LWJGL] ").append(charSequence2).toString());
    }

    public static String toHexString(int i) {
        StringBuilder sb;
        int i2 = i;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("0x").append(Integer.toHexString(i2).toUpperCase()).toString();
    }
}

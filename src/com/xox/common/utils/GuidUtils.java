package com.xox.common.utils;
import java.net.InetAddress;
/**
 * UUID生成工具类
 * @author zhuw
 * @version 2013-1-13
 */
public class GuidUtils {

    private static final int IP;
    static {
        int ipadd;
        try {
            ipadd = toInt(InetAddress.getLocalHost().getAddress());
        }
        catch (Exception e) {
            ipadd = 0;
        }
        IP = ipadd;
    }
    private static short counter = (short) 0;
    private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

    /**
     * 构造方法
     */
    public GuidUtils() {
    }

    /**
     * 生成16进制表达的字符串UUID
     * 
     * @return
     */
    public static String generateHex() {
        return new StringBuffer(36).append(format(getIP())).append(
                format(getJVM())).append(format(getHighTime())).append(
                format(getLowTime())).append(format(getCount())).toString().toUpperCase();
    }

    /**
     * 生成字节数组的UUID
     * 
     * @return
     */
    public byte[] generateBytes() {
        byte[] bytes = new byte[16];
        System.arraycopy(getBytes(getIP()), 0, bytes, 0, 4);
        System.arraycopy(getBytes(getJVM()), 0, bytes, 4, 4);
        System.arraycopy(getBytes(getHighTime()), 0, bytes, 8, 2);
        System.arraycopy(getBytes(getLowTime()), 0, bytes, 10, 4);
        System.arraycopy(getBytes(getCount()), 0, bytes, 14, 2);
        return bytes;
    }

    private static String format(int intval) {
        String formatted = Integer.toHexString(intval);
        StringBuffer buf = new StringBuffer("00000000");
        buf.replace(8 - formatted.length(), 8, formatted);
        return buf.toString();
    }

    private static String format(short shortval) {
        String formatted = Integer.toHexString(shortval);
        StringBuffer buf = new StringBuffer("0000");
        buf.replace(4 - formatted.length(), 4, formatted);
        return buf.toString();
    }

    /**
     * Unique across JVMs on this machine (unless they load this class in the
     * same quater second - very unlikely)
     */
    private static int getJVM() {
        return JVM;
    }

    /**
     * Unique in a millisecond for this JVM instance (unless there are >
     * Short.MAX_VALUE instances created in a millisecond)
     */
    private static short getCount() {
        synchronized (GuidUtils.class) {
            if (counter < 0)
                counter = 0;
            return counter++;
        }
    }

    /**
     * Unique in a local network
     */
    private static int getIP() {
        return IP;
    }

    /**
     * Unique down to millisecond
     */
    private static short getHighTime() {
        return (short) (System.currentTimeMillis() >>> 32);
    }

    private static int getLowTime() {
        return (int) System.currentTimeMillis();
    }

    private static int toInt(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
        }
        return result;
    }

    private static byte[] getBytes(int intval) {
        return new byte[] { (byte) (intval >> 24), (byte) (intval >> 16),
                (byte) (intval >> 8), (byte) intval };
    }

    private static byte[] getBytes(short shortval) {
        return new byte[] { (byte) (shortval >> 8), (byte) shortval };
    }

    public static void main(String[] args) {
    	GuidUtils.generateHex();
    }
}

package com.wucstone.work;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class JolHashUtils {


    public static String hash(Object object) throws Exception{

        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);

        Long hashcode = 0L;
        for (int i = 7; i > 0; i--) {
            hashcode |= (unsafe.getByte(object, i) & 0xFF) << ((i - 1) * 8);
        }
        return Long.toHexString(hashcode);
    }
}

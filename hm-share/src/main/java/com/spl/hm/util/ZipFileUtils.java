package com.spl.hm.util;

import org.zeroturnaround.zip.ZipUtil;

import java.io.File;

public class ZipFileUtils {

    public ZipFileUtils() {
    }

    public static void unpack(File zipFile, File targetDirectory) {
        ZipUtil.unpack(zipFile, targetDirectory);
    }
}

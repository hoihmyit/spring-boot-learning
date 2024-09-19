package com.spl.hm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RunWith(MockitoJUnitRunner.class)
public class WriteATextFileToZipFileTest {

    @Test
    public void testWriteATextFileToZipFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Test write a text file to zip file! ~Hoih My~");

//        File file = new File("/Users/hmy/Projects/Learning/spring-boot-learn/hm-study/src/test/resources/out/testWriteATextFileToZipFile.zip");
        File file = new File(new File("src/test/resources/out"), "testWriteATextFileToZipFile.zip");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));
        ZipEntry newTxtFile = new ZipEntry("test.txt");
        out.putNextEntry(newTxtFile);

        byte[] data = sb.toString().getBytes();
        out.write(data, 0, data.length);
        out.closeEntry();

        out.close();
    }
}

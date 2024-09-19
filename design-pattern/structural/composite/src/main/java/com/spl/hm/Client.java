package com.spl.hm;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        final FileComponent file1 = new FileLeaf("file 1", 10);
        final FileComponent file2 = new FileLeaf("file 2", 3);
        final FileComponent file3 = new FileLeaf("file 3", 12);

        List<FileComponent> files = Arrays.asList(file1, file2, file3);
        final FileComponent folder = new FolderComposite(files);
        folder.showProperty();
        System.out.println("Total Size: " + folder.totalSize());

        //OUTPUT
        //FileLeaf [name=file 1, size=10]
        //FileLeaf [name=file 2, size=3]
        //FileLeaf [name=file 3, size=12]
        //Total Size: 25
    }
}

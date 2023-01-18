package org.example;

import java.io.File;

public class FileSearch implements Runnable {
    private File[] files;

    public FileSearch(File[] files) {

        this.files = files;
    }

    public void searchFileFolder() {
        for (int i = 0; i < files.length; i++) {
            search(files[i]);
        }
    }

    public void search(File file) {
        if (file.isFile()) {
            if (file.getName().equals("txt.txt")) {
                System.out.println(file.getAbsoluteFile() + Thread.currentThread().getName());
            }
        }
        if (DirectoryCheck.check(file)) {
            File[] files = file.listFiles();
            for (File fileCurrent : files) {
                search(fileCurrent);
            }
        }
    }

    @Override
    public void run() {
        searchFileFolder();
    }
}

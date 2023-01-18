package org.example;

import java.io.File;

public class DirectoryCheck {
    public static boolean check(File file) {
        if (file != null && file.isDirectory()) {
            return true;
        }
        return false;
    }
}

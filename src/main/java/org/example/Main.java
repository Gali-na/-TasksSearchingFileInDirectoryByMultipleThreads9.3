package org.example;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File[] firstPartOfFile = new File[]{};
        File[] secondPartOfFile = new File[]{};
        File file = new File("C:\\Users\\Acer Nitro 5\\Desktop\\English text");
        if (DirectoryCheck.check(file)) {
            File[] files = file.listFiles();
            int sizeOfFile = files.length;
            if (sizeOfFile % 2 == 0) {
                int phalfOfArray = sizeOfFile / 2;
                firstPartOfFile = new File[phalfOfArray];
                secondPartOfFile = new File[phalfOfArray];
                for (int i = 0; i < phalfOfArray; i++) {
                    firstPartOfFile[i] = files[i];
                }
                for (int i = 0, j = phalfOfArray; i < phalfOfArray; i++, j++) {
                    secondPartOfFile[i] = files[j];
                }
            }
            if (sizeOfFile == 1) {
                firstPartOfFile = files;
            }
            if (sizeOfFile % 2 != 0 && sizeOfFile != 1) {
                int phalfOfArray = sizeOfFile / 2;
                firstPartOfFile = new File[phalfOfArray];
                secondPartOfFile = new File[phalfOfArray + 1];
                for (int i = 0; i < phalfOfArray; i++) {
                    firstPartOfFile[i] = files[i];
                }
                for (int i = 0, j = phalfOfArray; i < phalfOfArray + 1; i++, j++) {
                    secondPartOfFile[i] = files[j];
                }
            }
        }

        Thread oneThread = new Thread(new FileSearch(firstPartOfFile));
        Thread twoThread = new Thread(new FileSearch(secondPartOfFile));
        oneThread.start();
        twoThread.start();

    }
}

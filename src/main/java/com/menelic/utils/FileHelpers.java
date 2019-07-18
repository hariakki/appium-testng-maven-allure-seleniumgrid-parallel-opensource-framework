package com.menelic.utils;

import java.io.File;

class FileHelpers {

    /**
     * Check if file exists and that it is not a directory.
     *
     * @param path the path to the file
     * @return true if file exists
     */
    static boolean fileExists(String path) {
        Log.info("Checking for existence of: " + path);
        File file = new File(path);
        return file.exists() && !file.isDirectory();
    }

    /**
     * Create the given path.
     *
     * @param path the path to create
     */
    static void createPath(String path) {
        if (!fileExists(path)) {
            File file = new File(path);
            file.mkdirs();
        }
    }
}

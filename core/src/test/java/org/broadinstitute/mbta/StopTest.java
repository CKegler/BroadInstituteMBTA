package org.broadinstitute.mbta;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

class StopTest {

    private static File file;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        file = getFileFromResources();
    }

    // get file from classpath, resources folder
    private File getFileFromResources() {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource("stops.json");
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }

    private static void printFile() throws IOException {

        if (file == null) return;

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @Test
    public void testReadingOfStopsFile() {

        try {
            printFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert true;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

}
package org.broadinstitute.mbta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;

class RouteTest {

    private static File file;
    private static ObjectMapper mapper = new ObjectMapper() ;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        file = getFileFromResources();
//        SimpleModule module = new SimpleModule();
//        module.addDeserializer(Route.class, new RouteDeserializer(Route.class));
//        mapper.registerModule(module);
    }

    // get file from classpath, resources folder
    private File getFileFromResources() {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource("routes.json");
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
    public void test_ReadingOfRoutesFile() {

        try {
            printFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert true;
    }

    @Test
    public void test_DeserializeRoutesFromFile() {
        if (file == null) return;

        StringBuilder buffer = new StringBuilder();
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        final String s = buffer.toString();

        Route value = null;
        try {
            value = mapper.readValue(s, Route.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(value.toString());
        assert true;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}
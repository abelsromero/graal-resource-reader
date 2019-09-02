package org.abelsromero.nativ;

import java.io.File;
import java.io.InputStream;

public class App {

    private static final String FILE = "config.properties";

    public static void main(String[] args) {
        new App().readFile();
    }

    private void readFile() {

        System.out.println("== new File");
        System.out.println(new File(FILE).exists());
        System.out.println(new File("/" + FILE).exists());

        System.out.println("== App.class.getResource");
        System.out.println(App.class.getResourceAsStream(FILE));
        System.out.println(App.class.getResourceAsStream("/" + FILE));

        System.out.println("== new App().getClass().getClassLoader().getResourceAsStream");
        System.out.println(new App().getClass().getClassLoader().getResourceAsStream(FILE));
        System.out.println(new App().getClass().getClassLoader().getResourceAsStream("/" + FILE));

        System.out.println("== ClassLoader.class.getResourceAsStream");
        System.out.println(ClassLoader.class.getResourceAsStream(FILE));
        System.out.println(ClassLoader.class.getResourceAsStream("/" + FILE));

        System.out.println("== ClassLoader.getSystemResource");
        System.out.println(ClassLoader.getSystemResource(FILE));
        System.out.println(ClassLoader.getSystemResource("/" + FILE));

        System.out.println("== ClassLoader.getSystemClassLoader().getResourceAsStream");
        System.out.println(ClassLoader.getSystemClassLoader().getResourceAsStream(FILE));
        System.out.println(ClassLoader.getSystemClassLoader().getResourceAsStream("/" + FILE));

    }

    private static int readPrivateKey(final String pemResName) {
        try {
            InputStream contentIS = App.class.getResourceAsStream(pemResName);
            byte[] tmp = new byte[4096];
            int length = contentIS.read(tmp);
            return length;
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return -1;
    }

}

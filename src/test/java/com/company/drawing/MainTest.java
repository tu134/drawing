package com.company.drawing;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class MainTest {

    @Test()
    public void loop() {
        String[] input = new String[]{ "C 20 4", "L 1 2 6 2", "L 6 3 6 4", "R 14 1 18 3", "B 10 3 o" };
        InputStream inputStream = new ByteArrayInputStream(String.join(System.lineSeparator(), input).getBytes());
        var out = new ByteArrayOutputStream();
        Main.loop(inputStream, new PrintStream(out), false);

        String[] actual = out.toString().split("\\r?\\n");

        try {
            InputStream stream = this.getClass().getResourceAsStream("/MainTestOutput.txt");
            String[] expected = new String(stream.readAllBytes()).split("\\r?\\n");
            Assert.assertArrayEquals(expected, actual);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
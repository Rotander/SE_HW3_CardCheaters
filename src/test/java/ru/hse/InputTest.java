package ru.hse;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class InputTest {

    @Test
    void inputNormalValue() {
        ByteArrayInputStream stream = new ByteArrayInputStream("5".getBytes());
        System.setIn(stream);
        Input.inputCount(0, "нормальная строка");
        System.setIn(System.in);
    }

    @Test
    void inputNormalValueAnother() {
        ByteArrayInputStream stream = new ByteArrayInputStream("100".getBytes());
        System.setIn(stream);
        Input.inputCount(1, "нормальная строка");
        System.setIn(System.in);
    }

    @Test
    void inputEmptyValue() {
        ByteArrayInputStream stream = new ByteArrayInputStream("".getBytes());
        System.setIn(stream);
        new Thread(() ->
                Input.inputCount(1, "нормальная строка"));
        new ByteArrayInputStream("5".getBytes());
        System.setIn(System.in);
    }

    @Test
    void inputSomeValue() throws InterruptedException {
        ByteArrayInputStream stream = new ByteArrayInputStream("stringAnd!@#$%^&*(".getBytes());
        System.setIn(stream);
        Thread thread = new Thread(() ->
                Input.inputCount(1, "нормальная строка"));
        new ByteArrayInputStream("65".getBytes());
        thread.join();
        System.setIn(System.in);
    }

    @Test
    void inputLessAndLessValue() throws InterruptedException {
        ByteArrayInputStream stream = new ByteArrayInputStream("0".getBytes());
        System.setIn(stream);
        Thread thread = new Thread(() ->
                Input.inputCount(1, "нормальная строка"));
        new ByteArrayInputStream("100".getBytes());
        thread.join();
        System.setIn(System.in);
    }

    @Test
    void inputMoreValue() throws InterruptedException {
        ByteArrayInputStream stream = new ByteArrayInputStream("101".getBytes());
        System.setIn(stream);
        Thread thread = new Thread(() ->
                Input.inputCount(1, "нормальная строка"));
        new ByteArrayInputStream("100".getBytes());
        thread.join();
        System.setIn(System.in);
    }
}
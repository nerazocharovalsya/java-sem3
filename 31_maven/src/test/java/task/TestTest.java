package task;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {

    @org.junit.jupiter.api.Test
    void test1() {
        Test test = new Test();
        int expected = test.func(6);
        int actual = 36;
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void test2() {
        Test test = new Test();
        int expected = test.subtract(6,4);
        int actual = 2;
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void test3() {
        Test test = new Test();
        int expected = test.summ(6,4);
        int actual = 10;
        assertEquals(expected,actual);
    }
}
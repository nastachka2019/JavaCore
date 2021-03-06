
Задание:
Создать класс Calculator как минимум с 5-ю методами
Написать для него юнит тесты, среди которых должны быть:
позитивные
негативные
которые выполнятся на наборе параметров
проигнорированные
с подробным описанием
      3. Создать тест-сьют, в который должны входить минимум 3 класса тестов или несколько пакетов
      4. Показать результирующее покрытие, которое должно составлять не менее 70%


import java.util.Scanner;

public class Calculator {
    int result;
    int x;
    int y;
    char operation;

    public static int getSum(int x, int y) {
        int result = x + y;
        return result;
    }

    public static int getDifference(int x, int y) {
        int result = x - y;
        return result;
    }

    public static int getMultiply(int x, int y) {
        int result = x * y;
        return result;
    }

    public static int getDivision(int x, int y) {
        int result = x / y;
        return result;
    }

    public static int getMod(int x, int y) {
        int result = x % y;
        return result;
    }
}
///////////////TESTS
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class CalculatorTest {


    @BeforeEach
    public void setUp() {
        System.out.println("before");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("after");
    }

    @Test
    public void getSum() {
        Calculator calculator = new Calculator();
        int actual = calculator.getSum(6, 4);
        int expected = 10;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Hello Hello Hello")
    public void getMultiply() {
        Calculator calculator = new Calculator();
        int actual = calculator.getMultiply(10, 4);
        int expected = 40;
        Assertions.assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void getMod() {
        Calculator calculator = new Calculator();
        int actual = calculator.getMod(10, 4);
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getDivision() {
        Calculator calculator = new Calculator();
        int actual = calculator.getDivision(33, 11);
        int expected = 3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getDifference() {
        Calculator calculator = new Calculator();
        int actual = calculator.getDifference(10, 5);
        int expected = 7;
        Assertions.assertEquals(actual, expected, "not today");
    }

    @RunWith(value = Parameterized.class)
    class ParameterizedTest {
        private int numberX;
        private int numberY;
        private int expected;

        public ParameterizedTest(int numberX, int numberY, int expected) {
            this.numberX = numberX;
            this.numberY = numberY;
            this.expected = expected;
        }

        @Parameterized.Parameters(name = "{index}: testGetDivision({10}/{2}) = {5}")
        public Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {12, 6, 2},
                    {2, 2, 1},
                    {8, 2, 4},
                    {14, 7, 2},
                    {18, 2, 9}
            });
        }

        @Test
        public void test_getDivision() {
            Assertions.assertEquals(Calculator.getDivision(numberX, numberY), expected);
        }

    }
}

/////////////
class CalculatorTest1 {

    @Test
    public void getDifference() {
        Calculator calculator = new Calculator();
        int actual = calculator.getDifference(10, 5);
        int expected = 7;
        Assertions.assertEquals(actual, expected, "not today");
    }

}
/////////////

@RunWith(JUnitPlatform.class)
@SelectClasses({CalculatorTest.class, CalculatorTest1.class, ParameterizedTest.class })
class JunitCalculatorTest {

}
///////
@RunWith(value = Parameterized.class)
class ParameterizedTest {
    private int numberX;
    private int numberY;
    private int expected;

    public ParameterizedTest(int numberX, int numberY, int expected) {
        this.numberX = numberX;
        this.numberY = numberY;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: testGetDivision({10}/{2}) = {5}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {12, 6, 2},
                {2, 2, 1},
                {8, 2, 4},
                {14, 7, 2},
                {18, 2, 9}
        });
    }

    @Test
    public void test_getDivision() {
        Assertions.assertEquals(Calculator.getDivision(numberX, numberY), expected);
    }

}

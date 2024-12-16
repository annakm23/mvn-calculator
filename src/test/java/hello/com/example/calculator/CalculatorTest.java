package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorTest {

    // Тест для правильного виразу (повертає 2)
    @Test
    public void testValidExpression() {
        String expression = "1+1";  // вираз, який має повертати 2
        double expectedResult = 2.0;

        try {
            // Створюємо вираз і обчислюємо результат
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();

            // Перевіряємо, чи результат дорівнює очікуваному значенню
            assertEquals(expectedResult, result, 0.001);
        } catch (Exception e) {
            // Якщо сталася помилка, тест не має пройти
            fail("Exception should not have been thrown");
        }
    }

    // Тест для неправильного виразу (повинно бути 4)
    @Test
    public void testInvalidExpression() {
        String expression = "5-1";  // вираз, який має повертати 4
        double expectedResult = 4.0;  // Очікуваний результат 4

        try {
            // Створюємо вираз і обчислюємо результат
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();

            // Перевіряємо, чи результат дорівнює очікуваному значенню
            assertEquals(expectedResult, result, 0.001);
        } catch (Exception e) {
            // Якщо сталася помилка, тест не має пройти
            fail("Exception should not have been thrown");
        }
    }
}

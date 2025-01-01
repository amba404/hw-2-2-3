package pro.sky.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CalcServiceImplTest {

    @InjectMocks
    private CalcServiceImpl calcService;

    @ParameterizedTest
    @CsvSource({"1, 2, 1.000000 + 2.000000 = 3.000000",
            "2, 3, 2.000000 + 3.000000 = 5.000000"})
    public void testPlus(double num1, double num2, String expected) {
        String result = calcService.plus(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 1.000000 - 2.000000 = -1.000000",
            "12, 3, 12.000000 - 3.000000 = 9.000000"})
    public void testMinus(double num1, double num2, String expected) {
        String result = calcService.minus(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 1.000000 * 2.000000 = 2.000000",
            "2, 3, 2.000000 * 3.000000 = 6.000000"})
    public void testMultiply(double num1, double num2, String expected) {
        String result = calcService.multiply(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 1.000000 / 2.000000 = 0.500000",
        "6, -2, 6.000000 / -2.000000 = -3.000000"})
    public void testDivide(double num1, double num2, String expected) {
        String result = calcService.divide(num1, num2);
        assertEquals(expected, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ZeroDivideException.class, () -> calcService.divide(6.0, 0.0));
    }

    @Test
    public void testWelcome() {
        String result = calcService.welcome();
        assertEquals("Добро пожаловать в калькулятор", result);
    }
}

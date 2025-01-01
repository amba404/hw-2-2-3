package pro.sky.calculator;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public String plus(double num1, double num2) {
        return String.format(Locale.ROOT, "%f + %f = %f", num1, num2, num1 + num2);
    }

    @Override
    public String minus(double num1, double num2) {
        return String.format(Locale.ROOT, "%f - %f = %f", num1, num2, num1 - num2);
    }

    @Override
    public String multiply(double num1, double num2) {
        return String.format(Locale.ROOT, "%f * %f = %f", num1, num2, num1 * num2);
    }

    @Override
    public String divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ZeroDivideException("Ошибка! Деление на ноль");
        }
        return String.format(Locale.ROOT, "%f / %f = %f", num1, num2, num1 / num2);
    }

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }
}

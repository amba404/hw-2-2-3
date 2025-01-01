package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/plus")
    public String answerPlus(@RequestParam() double num1, @RequestParam() double num2) {
        return calcService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String answerMinus(@RequestParam() double num1, @RequestParam() double num2) {
        return calcService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String answerMultiply(@RequestParam() double num1, @RequestParam() double num2) {
        return calcService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String answerDivide(@RequestParam() double num1, @RequestParam() double num2) {
        return calcService.divide(num1, num2);
    }

    @GetMapping("")
    public String welcome() {
        return calcService.welcome();
    }
}

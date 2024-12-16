package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return "<html>" +
            "<body>" +
                "<form action=\"/calculate\" method=\"post\">" +
                    "<label for=\"expression\">Введіть вираз:</label>" +
                    "<input type=\"text\" id=\"expression\" name=\"expression\" placeholder=\"наприклад: 2+2*2\" required>" +
                    "<button type=\"submit\">Обчислити</button>" +
                "</form>" +
            "</body>" +
        "</html>";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String expression) {
        try {
            // Обчислення математичного виразу з використанням бібліотеки exp4j
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();
            return "<html>" +
                "<body>" +
                    "<p>Результат: " + result + "</p>" +
                    "<a href=\"/\">Назад</a>" +
                "</body>" +
            "</html>";
        } catch (Exception e) {
            return "<html>" +
                "<body>" +
                    "<p>Помилка: Невірний вираз!</p>" +
                    "<a href=\"/\">Назад</a>" +
                "</body>" +
            "</html>";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
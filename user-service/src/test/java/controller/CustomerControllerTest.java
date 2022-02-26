package controller;

import com.sharpEdge.UserService.controller.CustomerController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {
}

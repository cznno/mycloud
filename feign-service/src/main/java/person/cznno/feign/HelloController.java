package person.cznno.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cznno
 * Date: 18-1-25
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/hello1")
    public String hello(@RequestParam(value = "name", defaultValue = "guest", required = false) String name) {
        return "Hello " + name;
    }
}

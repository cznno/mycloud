package feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by cznno
 * Date: 18-1-25
 */
@FeignClient("hello-service")
public interface HelloService {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/hello1")
    String hello(@RequestParam("name") String name);
}

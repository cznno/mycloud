package person.cznno.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by cznno
 * Date: 18-2-26
 */
@FeignClient(name = "monitor-server")
public interface ErrorHandlerService {

    @PostMapping("/alertMail")
    void alertMail(@RequestBody String errorCode);
}

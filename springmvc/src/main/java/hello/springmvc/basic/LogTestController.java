package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class LogTestController {
    // private final Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);
        log.trace(" trace my log = " + name); // 이렇게 사용하면 안 됨
        // logging.level.hello.springmvc=debug 이기 때문에 trace는 출력이 되면 안 된다.
        // 자바 언어적 특성으로 연산이 이루어진다. trace my log = name이 되는 현상

        log.trace("trace log={}", name);
        // 파라미터 넘겼을 때 없으면 출력되지 않음.
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        return "ok";
    }
}

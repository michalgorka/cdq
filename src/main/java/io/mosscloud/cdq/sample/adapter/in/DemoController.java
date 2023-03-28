package io.mosscloud.cdq.sample.adapter.in;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
class DemoController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    String helloWord() {
        return "helloworld";
    }
}

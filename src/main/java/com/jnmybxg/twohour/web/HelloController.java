package com.jnmybxg.twohour.web;

import com.jnmybxg.twohour.domain.Boy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Value("${myName}")
    private String myName;

    @Autowired
    private Boy boy;

    @RequestMapping(value = "/{id}/hello", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "HELLO" + myName +":" +id;
    }

    // 使用 hello2?id=10这种url形式访问
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String sayH(@RequestParam(value = "id",required = false,defaultValue = "22") Integer id){
        return "HELLO" + myName +":" +id;
    }

    @GetMapping("/boy")
    public String boy(){
        return boy.getName()+":"+boy.getAge();
    }


}

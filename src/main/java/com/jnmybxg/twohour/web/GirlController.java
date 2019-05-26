package com.jnmybxg.twohour.web;

import com.jnmybxg.twohour.domain.Girl;
import com.jnmybxg.twohour.service.GirlRepository;
import com.jnmybxg.twohour.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/girls", method = RequestMethod.GET)
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    @PostMapping("/girls")
    public Integer girlAdd(@RequestParam(value = "age", required = false, defaultValue = "0") Integer age,
                           @RequestParam(value = "cupSize", required = false, defaultValue = "A") String cupSize) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl).getId();
    }

    @RequestMapping(value = "/{id}/girls", method = RequestMethod.GET)
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id);
    }

    @PutMapping(value = "/{id}/girls")
    public String girlUpdate(@PathVariable("id") Integer id,
                             @RequestParam(value = "age") Integer age,
                             @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girlRepository.save(girl);
        return "success";
    }

    @DeleteMapping(value = "/{id}/girls")
    public String girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
        return "success";
    }

    @GetMapping(value = "/age/{age}/girls")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findGirlsByAge(age);
    }

    @PostMapping("/girl/two")
    public void girlAddTwo() {
         girlService.twoGirlInsert();
    }
}

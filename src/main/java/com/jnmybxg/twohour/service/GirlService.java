package com.jnmybxg.twohour.service;

import com.jnmybxg.twohour.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void twoGirlInsert(){
        Girl girl = new Girl();
        girl.setAge(15);
        girl.setCupSize("E");
        girlRepository.save(girl);

        Girl girl2 = new Girl();
        girl2.setAge(18);
        girl2.setCupSize("SS");
        girlRepository.save(girl2);
    }
}

package com.forezp.servicefeign;

import org.springframework.stereotype.Component;

/**
 * @author cph
 * @date 2019/5/6
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}

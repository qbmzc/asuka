package com.cong.asukaclient.service;

import com.cong.asukaclient.third.AsukaClientWithFactory;
import com.cong.asukaclient.third.AsukaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientService {


    @Qualifier("com.cong.asukaclient.third.AsukaService")
    @Autowired
    private AsukaService asukaService;

    public String test(){
        log.info("Client-service");
        return asukaService.getTest();
    }
}

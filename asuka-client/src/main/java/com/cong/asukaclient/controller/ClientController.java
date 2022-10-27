package com.cong.asukaclient.controller;


import com.cong.asukaclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     *
     * @return
     */
    @GetMapping("test")
    public String test(){
        return clientService.test();
    }

    @GetMapping("file")
    public String upload(){
        return clientService.upload();
    }
}

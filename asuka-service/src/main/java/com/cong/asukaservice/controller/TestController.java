package com.cong.asukaservice.controller;

import com.cong.asukaservice.pojo.Test;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("asuka/test")
public class TestController {

    @SneakyThrows
    @GetMapping("get")
    public Test getTest(HttpServletRequest request, HttpServletResponse response){
        log.info("requestURI: {}",request.getRequestURI());
        log.info("getRemoteHost: {}",request.getRemoteHost());
        Test test = new Test();
        test.setName("测试");
        test.setAge(16);
        test.setUrl("http://10.104.1.206/foo/bar");
//        TimeUnit.SECONDS.sleep(1);
        return test;
    }
    @PostMapping("file")
    public String upload(@RequestPart("file")MultipartFile multipartFile) throws IOException {
        log.info("file  {}",multipartFile.getOriginalFilename());
        FileCopyUtils.copy(multipartFile.getInputStream(), Files.newOutputStream(Paths.get("/home/cong/Downloads/a.tmp")));
        return "success";
    }
}

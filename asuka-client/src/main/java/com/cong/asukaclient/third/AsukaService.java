package com.cong.asukaclient.third;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "asuka-service",fallback = Fallback.class)
public interface AsukaService {

    @GetMapping("asuka/test/get")
     String getTest();

    @PostMapping(value = "asuka/test/file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file")MultipartFile multipartFile);
}

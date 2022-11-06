package com.cong.asukaclient.service;

import ch.qos.logback.core.util.FileUtil;
import com.cong.asukaclient.third.AsukaClientWithFactory;
import com.cong.asukaclient.third.AsukaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@Service
public class ClientService {


    @Qualifier("com.cong.asukaclient.third.AsukaService")
    @Autowired
    private AsukaService asukaService;

    public String test() {
        log.info("Client-service");
        return asukaService.getTest();
    }

    public String upload() {
        File file = new File("/home/cong/Downloads/评价胃肠超声诊断助显剂安全性和有效性的多中心、前瞻性、随机对照临床研究-结题质控-器械临床试验质量检查记录表-2022-09-30.docx");
        MultipartFile multipartFile = getMultipartFile(file);
        return this.asukaService.upload(multipartFile);
    }

    /**
     * 文件类型转换
     *
     * @param file
     * @return
     */
    public MultipartFile getMultipartFile(File file) {
        DiskFileItem item = new DiskFileItem("file"
                , MediaType.MULTIPART_FORM_DATA_VALUE
                , true
                , file.getName()
                , (int) file.length()
                , file.getParentFile());
        try (OutputStream os = item.getOutputStream()) {
            FileUtils.copyFile(file, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CommonsMultipartFile(item);
    }
}

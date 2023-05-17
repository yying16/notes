package com.notes.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.notes.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/notes")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @PostMapping("/upload")
    public boolean toUpload(@RequestBody MultipartFile file, HttpServletRequest request) throws IOException {
        try{
            String dir = SpringUtil.getBean("filePath");  //存放目录
            // System.out.println(dir);
            java.io.File path = new java.io.File(dir);  //确认路径存在
            if (!path.exists()) {
                path.mkdirs();
            }
            String photoName = file.getOriginalFilename();
            String photoPath = dir + photoService.repeatedNaming(photoName,photoService.getIncrement());
            String photoType = photoService.getSuffix(photoName);
            file.transferTo(new java.io.File(photoPath));
            photoService.insert(photoName,photoPath,photoType);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //文件下载
    @GetMapping("/toDownload/{fileName}/{fileId}")
    public ResponseEntity<byte[]> toDownload(@PathVariable("fileName")String fileName, @PathVariable("fileId")int fileId, HttpServletRequest request) {
        return photoService.downloadFile(request, fileName, fileId);
    }
}

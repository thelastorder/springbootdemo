package com.webdemo.springbootdemo.controller;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@RestController
public class ImageUpload {

    private static String UPLOAD_FOLDER = "E:/java/新建文件夹/springbootdemo/src/main/resources/static/";

    @PostMapping("/image")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException{
        return singleFileUpload(file);
    }

    public static String singleFileUpload(MultipartFile pc1 ) throws IOException {
        if (Objects.isNull(pc1) || pc1.isEmpty()) {//判断非空
            return "文件为空，请重新上传";
        }
        try {
            byte[] bytes = pc1.getBytes();
            //要存入本地的地址放到path里面
            Path path = Paths.get( UPLOAD_FOLDER+"/");
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(path);
            }
            String extension = getFileExtension(pc1);  //获取文件后缀

            UUID uuid = UUID.randomUUID();  //这里调用了UUID，得到全宇宙唯一的命名
            String str = uuid.toString(); // 真正的UUID打印出来是这样的：xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx (8-4-4-4-12)
            //所以我们可以去掉去掉"-"符号
            String picname = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) +   str.substring(19, 23) + str.substring(24);
            String relativeAddr = picname  + extension;  //唯一的名字接上后缀
            Thumbnails.of(pc1.getInputStream()).size(200, 200)    //写入
                    .outputQuality(0.8f).toFile(path+"/"+relativeAddr);
            //logger.debug("文件写入成功...");
            return UPLOAD_FOLDER + relativeAddr;
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }

    private static String getFileExtension(MultipartFile File) {
        String originalFileName = File.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));

    }
}

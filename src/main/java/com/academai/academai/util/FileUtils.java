package com.academai.academai.util;

import org.springframework.core.io.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class FileUtils {
    private static final String UPLOAD_PATH = "data/files";

    public static ResponseEntity<?> downloadFile(String filename){
        try {
            Path filePath = Paths.get(UPLOAD_PATH + filename);
            if (Files.exists(filePath)) {
                Resource resource = new ByteArrayResource(Files.readAllBytes(filePath));
                String encodedFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8)
                        .replace("+", "%20");
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFilename)
                        .contentLength(resource.contentLength())
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (IOException e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    public static String uploadFile(MultipartFile file) {
        String uuidFile = UUID.randomUUID().toString();
        String resultFilePath = uuidFile + "_" + file.getOriginalFilename();

        Path uploadPath = Paths.get(UPLOAD_PATH);
        try {
            Files.createDirectories(uploadPath);

            Path filePath = uploadPath.resolve(resultFilePath);
            try (OutputStream os = Files.newOutputStream(filePath)){
                os.write(file.getBytes());
                log.info("File uploaded: " + resultFilePath);
                return resultFilePath;
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException("Ошибка при сохранении файла", e);
        }
    }



}



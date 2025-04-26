package com.academai.academai.service;

import com.academai.academai.enums.FileType;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void uploadFile(FileType fileType, Long contentId, MultipartFile uploadFile);
}

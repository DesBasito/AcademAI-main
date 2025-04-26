package com.academai.academai.service.impl;

import com.academai.academai.entity.File;
import com.academai.academai.enums.FileType;
import com.academai.academai.repository.FileRepository;
import com.academai.academai.service.interfaces.FileService;
import com.academai.academai.util.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    @Override
    public void uploadFile(FileType fileType, Long contentId, MultipartFile uploadFile){
        File file = new File();
        String fileName = FileUtils.uploadFile(uploadFile);
        file.setType(fileType.name());
        file.setContentId(contentId);
        file.setOriginalFileName(uploadFile.getOriginalFilename());
        file.setFile(fileName);
        fileRepository.save(file);
    }

}

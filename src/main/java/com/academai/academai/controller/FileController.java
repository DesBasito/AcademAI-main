package com.academai.academai.controller;

import com.academai.academai.enums.FileType;
import com.academai.academai.service.interfaces.FileService;
import com.academai.academai.service.interfaces.UserService;
import com.academai.academai.util.FileUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/files")
public class FileController {
    private final FileService fileService;
    private final UserService userService;

    @GetMapping("download/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename) {
        return FileUtils.downloadFile(filename);
    }

    @PostMapping("upload/avatar/{userId}")
    public ResponseEntity<?> updateUserAvatar(@PathVariable("userId") Long userId, @RequestParam("file") MultipartFile file) {
        String fileName = userService.uploadAvatar(userId, file);
        return ResponseEntity.ok(Map.of("fileName", fileName));
    }

    @Operation(
            summary = "Загрузить файл",
            description = "Если указаны тип и contentId, файл будет привязан к материалу или заданию." +
                    " Иначе — просто картинка для редактора, в этом случае API возвращает url картинки"
    )
    @PostMapping("/upload/file")
    public ResponseEntity<?> uploadAnyFile(
            @RequestParam("file") MultipartFile file,
            @Parameter(description = "Тип содержимого (MATERIAL, TASK)", required = false)
            @RequestParam(value = "type", required = false) FileType type,
            @Parameter(description = "ID сущности (materialId, taskId)", required = false)
            @RequestParam(value = "contentId", required = false) Long contentId
    ) {
        if (type != null && contentId != null) {
            fileService.uploadFile(type, contentId, file);
            return ResponseEntity.ok().build();
        } else {
            String fileUrl = FileUtils.uploadFile(file);
            return ResponseEntity.ok(Map.of("url", fileUrl));
        }

    }

}

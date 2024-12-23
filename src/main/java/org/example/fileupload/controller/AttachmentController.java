package org.example.fileupload.controller;

import org.example.fileupload.ResponseData;
import org.example.fileupload.entity.Attachment;
import org.example.fileupload.service.AttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.Resource;

import java.nio.charset.StandardCharsets;

@RestController
public class AttachmentController {
    private AttachmentService attachmentService;
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/uploadFile")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println("name"+file.getName());
        System.out.println("size"+file.getSize());
        System.out.println("contentType"+file.getContentType());
//        System.out.println("content"+file.getBytes());
        System.out.println("resource"+file.getResource());
        System.out.println("original filename"+file.getOriginalFilename());
        Attachment attachment=attachmentService.saveAttachment(file);
        String downloadUrl="";
        downloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

        return new ResponseData(attachment.getFileName(), file.getContentType(),downloadUrl, file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment=null;
        attachment=attachmentService.getAttachment(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                                + "\"")
                .body((Resource) new ByteArrayResource(attachment.getData()));

    }

}

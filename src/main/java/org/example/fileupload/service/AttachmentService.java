package org.example.fileupload.service;

import org.example.fileupload.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws IOException;
    Attachment getAttachment(String fileId) throws IOException;
}

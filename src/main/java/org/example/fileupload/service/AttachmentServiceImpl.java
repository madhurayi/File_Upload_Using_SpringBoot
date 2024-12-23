package org.example.fileupload.service;

import org.example.fileupload.entity.Attachment;
import org.example.fileupload.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    private AttachmentRepository attachmentRepository;
    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws IOException {
        System.out.println("entered service");
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Attachment attachment = new Attachment(fileName,file.getContentType(),file.getBytes());
        attachmentRepository.save(attachment);
        return attachment;
    }

    @Override
    public Attachment getAttachment(String fileId) throws IOException {
        return attachmentRepository.findById(fileId).orElseThrow();
    }
}

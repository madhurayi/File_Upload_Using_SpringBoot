package org.example.fileupload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {

    private String fileName;

    private String fileType;

    private String downloadUrl;

    private long fileSize;

}

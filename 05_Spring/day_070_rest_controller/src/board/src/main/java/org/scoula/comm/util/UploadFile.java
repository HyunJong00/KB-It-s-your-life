package org.scoula.comm.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadFile {
    public static String upload(String baseDir, MultipartFile part) throws IOException {
        File base = new File(baseDir);
        if(!base.exists()){
            base.mkdirs();
        }
        String fileName = part.getOriginalFilename();
        File dest = new File(baseDir, UploadFileName.getUniqueName(fileName));
        part.transferTo(dest);
        return dest.getPath();
    }
}

package com.KCG.Online_Shopping_Products.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<byte[]> convertMultipartFilesToByteArrays(MultipartFile[] files) throws IOException {
        List<byte[]> imageDataList = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                imageDataList.add(file.getBytes());
            }
        }
        return imageDataList;
    }
}

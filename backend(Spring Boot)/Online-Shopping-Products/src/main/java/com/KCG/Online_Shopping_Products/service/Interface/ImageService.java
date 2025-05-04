package com.KCG.Online_Shopping_Products.service.Interface;

import org.springframework.stereotype.Service;
import java.util.Base64;

@Service
public interface ImageService {
    byte[] decodeBase64(String base64Image);
    String getImageType(byte[] imageData);
    byte[] resizeImage(byte[] imageData, int width, int height);  // Example for resizing images
}

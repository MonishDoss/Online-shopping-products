package com.KCG.Online_Shopping_Products.service.Implements;

import com.KCG.Online_Shopping_Products.service.Interface.ImageService;
import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Base64;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public byte[] decodeBase64(String base64Image) {
        return Base64.getDecoder().decode(base64Image);
    }

    @Override
    public String getImageType(byte[] imageData) {
        try {
            ImageInfo imageInfo = Imaging.getImageInfo(imageData);
            return imageInfo.getFormat().getName(); // Returns the format like "JPEG", "PNG"
        } catch (IOException e) {
            throw new RuntimeException("Failed to detect image type", e);
        } catch (ImageReadException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] resizeImage(byte[] imageData, int width, int height) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
            BufferedImage originalImage = ImageIO.read(bais);

            BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
            resizedImage.getGraphics().drawImage(originalImage, 0, 0, width, height, null);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resizedImage, "JPEG", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to resize image", e);
        }
    }
}

package com.example.qrcodeservice.service;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QRCodeService {

    public QRCodeService() {

    }


    public static BufferedImage generateImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        return image;
    }
}

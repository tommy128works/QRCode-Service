package com.example.qrcodeservice.controller;


import com.example.qrcodeservice.service.QRCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api")
public class QRCodeController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/qrcode")
    public ResponseEntity<BufferedImage> getImage() {
        BufferedImage bufferedImage = QRCodeService.generateImage(250, 250);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bufferedImage);
    }

}

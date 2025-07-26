package com.example.qrcodeservice.controller;


import com.example.qrcodeservice.service.QRCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class QRCodeController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/qrcode")
    public ResponseEntity<?> getImage(
            @RequestParam Integer size,
            @RequestParam String type
    ) {
        if (size < 150 || size > 350) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Image size must be between 150 and 350 pixels"));
        } else if (!(type.equals("png") || type.equals("jpeg") || type.equals("gif"))) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Only png, jpeg and gif image types are supported"));
        }

        BufferedImage bufferedImage = QRCodeService.generateImage(250, 250);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bufferedImage);
    }

}

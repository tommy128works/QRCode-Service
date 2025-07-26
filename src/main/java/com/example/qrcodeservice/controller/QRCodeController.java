package com.example.qrcodeservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QRCodeController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/qrcode")
    public ResponseEntity<String> getQRCode() {
        return new ResponseEntity<>("Not implemented", HttpStatus.NOT_IMPLEMENTED);
    }

}

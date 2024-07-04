package com.example.stockInventory.controller;

import com.example.stockInventory.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/stock")
    public ResponseEntity<String> generateStockReport() {
        String report = reportService.generateStockReport();
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<String> generateOrderReport() {
        String report = reportService.generateOrderReport();
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @GetMapping("/suppliers")
    public ResponseEntity<String> generateSupplierReport() {
        String report = reportService.generateSupplierReport();
        return new ResponseEntity<>(report, HttpStatus.OK);
    }
}

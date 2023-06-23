package com.vjtechnologies.demotransactionannotation.controller;

import com.vjtechnologies.demotransactionannotation.service.TransactionIsolationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transactions/isolations")
public class TransactionIsolationController {
  private final TransactionIsolationService transactionIsolationService;

  @GetMapping("/repeatable-read")
  public ResponseEntity<?> getRepeatableRead() throws InterruptedException {
    return ResponseEntity.ok(transactionIsolationService.getRepeatableRead());
  }

  @GetMapping("/serializable")
  public ResponseEntity<?> getSerializable() throws InterruptedException {
    return ResponseEntity.ok(transactionIsolationService.getSerializable());
  }
}

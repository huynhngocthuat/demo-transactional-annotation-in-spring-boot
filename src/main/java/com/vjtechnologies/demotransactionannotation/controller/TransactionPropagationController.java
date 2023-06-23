package com.vjtechnologies.demotransactionannotation.controller;

import com.vjtechnologies.demotransactionannotation.service.TransactionPropagationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transactions/propagations")
public class TransactionPropagationController {
  private final TransactionPropagationService transactionPropagationService;

  @GetMapping("/required")
  public ResponseEntity<?> propagationRequired() {
    return ResponseEntity.ok(transactionPropagationService.propagationRequired());
  }

  @GetMapping("/supports")
  public ResponseEntity<?> propagationSupports() {
    return ResponseEntity.ok(transactionPropagationService.propagationSupports());
  }

  @GetMapping("/not-supported")
  public ResponseEntity<?> propagationNotSupported() {
    return ResponseEntity.ok(transactionPropagationService.propagationNotSupported());
  }

  @GetMapping("/requires-new")
  public ResponseEntity<?> propagationRequiresNew() {
    return ResponseEntity.ok(transactionPropagationService.propagationRequiresNew());
  }

  @GetMapping("/never")
  public ResponseEntity<?> propagationNever() {
    return ResponseEntity.ok(transactionPropagationService.propagationNever());
  }

  @GetMapping("/mandatory")
  public ResponseEntity<?> propagationMandatory() {
    return ResponseEntity.ok(transactionPropagationService.propagationMandatory());
  }
}

package com.vjtechnologies.demotransactionannotation.service;

public interface TransactionPropagationService {
  boolean propagationRequired();

  boolean propagationSupports();

  boolean propagationNotSupported();

  boolean propagationRequiresNew();

  boolean propagationNever();

  boolean propagationMandatory();
}

package com.socialNetwork.restservice;

public class RegisterUnsuccesfulException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    RegisterUnsuccesfulException(String field, String condition) {
      super("The" + field + "is not correct, "+ condition);
    }
  }
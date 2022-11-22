package com.hamid.redis.exception;

public class AccessDeniedException extends RuntimeException {

  public AccessDeniedException() {
    super("You don't have access to perform this action");
  }
}

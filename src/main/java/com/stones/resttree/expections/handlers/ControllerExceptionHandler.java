package com.stones.resttree.expections.handlers;

import com.stones.resttree.expections.CannotDeleteException;
import com.stones.resttree.expections.NodeAlreadyExistsException;
import com.stones.resttree.expections.NodeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CannotDeleteException.class)
  public ResponseEntity<Object> cannotDeleteHandler(CannotDeleteException ex) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
  }

  @ExceptionHandler(NodeNotFoundException.class)
  public ResponseEntity<Object> nodeNotFoundHandler(NodeNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(NodeAlreadyExistsException.class)
  public ResponseEntity<Object> nodeAlreadyExistsHandler(NodeAlreadyExistsException ex) {
    return ResponseEntity.ok(ex.getMessage());
  }

}

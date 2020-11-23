package com.stones.resttree.controllers;

import com.stones.resttree.controllers.dto.DistanceFromRootResponse;
import com.stones.resttree.entities.BinaryTree;
import com.stones.resttree.services.TreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/")
public class TreeController {

  private final TreeService treeService;

  public TreeController(TreeService treeService) {
    this.treeService = treeService;
  }

  @GetMapping(produces = { MediaType.APPLICATION_XML_VALUE })
  public ResponseEntity<BinaryTree> getTree() {
    return ResponseEntity.ok(treeService.getTree());
  }

  @GetMapping(value = { "/{number}" }, produces = { MediaType.APPLICATION_XML_VALUE })
  public ResponseEntity<DistanceFromRootResponse> getNumber(@PathVariable int number) {
    return ResponseEntity.ok(DistanceFromRootResponse.distance(treeService.searchNumber(number)));
  }

  @PostMapping(value = { "/{number}" }, produces = { MediaType.APPLICATION_XML_VALUE })
  public ResponseEntity<Object> addNumber(@PathVariable int number) {
    treeService.addNumber(number);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping(value = { "/{number}" }, produces = { MediaType.APPLICATION_XML_VALUE })
  public ResponseEntity<Object> deleteNumber(@PathVariable int number) {
    treeService.deleteNumber(number);
    return ResponseEntity.ok().build();
  }

}

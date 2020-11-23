package com.stones.resttree.controllers.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "distance")
public class DistanceFromRootResponse {

  @JacksonXmlText
  private int distance;

  public DistanceFromRootResponse(int distance) {
    this.distance = distance;
  }

  public static DistanceFromRootResponse distance(int distance) {
    return new DistanceFromRootResponse(distance);
  }

}

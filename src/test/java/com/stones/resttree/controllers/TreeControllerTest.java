package com.stones.resttree.controllers;

import com.stones.resttree.entities.BinaryTree;
import com.stones.resttree.services.TreeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TreeControllerTest {

  private BinaryTree binaryTree;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TreeService treeService;

  @BeforeEach
  public void beforeTestClass() {
    binaryTree = new BinaryTree();
    binaryTree.add(5);
    binaryTree.add(1);
    binaryTree.add(7);
    binaryTree.add(8);
  }

  @Test
  public void sendGetRequest_ExpectTreeStructureInXML() throws Exception {

    String expectedMessage = "<tree><root><number>5</number><right-leaf><number>1</number><right-leaf/><left-leaf/></right-leaf><left-leaf><number>7</number><right-leaf/><left-leaf><number>8</number><right-leaf/><left-leaf/></left-leaf></left-leaf></root></tree>";

    when(treeService.getTree()).thenReturn(binaryTree);
    mockMvc.perform(get("/api/v1/"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(Matchers.containsString(expectedMessage)));
  }

  @Test
  public void sendGetRequestOnSpecificNumber_ExpectDepthToBeShown() throws Exception {
    String expectedMessage = "<distance>1</distance>";

    when(treeService.searchNumber(7)).thenReturn(1);
    mockMvc.perform(get("/api/v1/7"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(Matchers.containsString(expectedMessage)));
  }

  @Test
  public void sendingPostRequest_ExpectingStatusCreated() throws Exception {
    mockMvc.perform(post("/api/v1/1"))
            .andDo(print())
            .andExpect(status().isCreated());
  }

}
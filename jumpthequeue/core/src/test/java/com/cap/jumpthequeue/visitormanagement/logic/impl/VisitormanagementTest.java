package com.cap.jumpthequeue.visitormanagement.logic.impl;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.jumpthequeue.SpringBootApp;
import com.cap.jumpthequeue.visitormanagement.logic.api.Visitormanagement;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorCto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorEto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * <p>
 * My testing exercise.<br>
 * Tests for {@link Visitormanagement} logic component.
 * </p>
 */
@SpringBootTest(classes = SpringBootApp.class)
public class VisitormanagementTest extends ComponentTest {

  @Inject
  private Visitormanagement visitormanagement;

  /**
   * <p>
   * Tests for {@link Visitormanagement#registerVisitor(VisitorEto)}
   * </p>
   */
  @Test
  public final void registerVisitorTest() {

    VisitorCto result = this.visitormanagement.registerVisitor(new VisitorEto("Mary", "mary@mail.com", "123456789"));
    assertThat(result).isNotNull();
    assertThat(result.getVisitor().getName()).isNotEmpty().isNotEqualTo("").isEqualTo("Mary");
    assertThat(result.getVisitor().getEmail()).isEqualTo("mary@mail.com");
    assertThat(result.getVisitor().getPhone()).isEqualTo("123456789");
    assertThat(result.getCode()).isNotNull();
    assertThat(result.getCode().getCode()).isNotEmpty();
  }

  /**
   * <p>
   * Tests for {@link Visitormanagement#findVisitorCtos(VisitorSearchCriteriaTo)}
   * </p>
   */
  @Test
  public final void listVisitorsTest() {

    PaginatedListTo<VisitorCto> result = this.visitormanagement.findVisitorCtos(new VisitorSearchCriteriaTo());
    assertThat(result).isNotNull();
  }

}
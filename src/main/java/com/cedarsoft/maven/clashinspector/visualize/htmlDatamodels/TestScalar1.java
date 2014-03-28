package com.cedarsoft.maven.clashinspector.visualize.htmlDatamodels;

import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 18.03.14
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
public class TestScalar1 implements TemplateScalarModel{
  private String testScalar1;

  public TestScalar1( String testScalar1 ) {
    this.testScalar1 = testScalar1;
  }

  public String getTestScalar1() {
    return testScalar1;
  }

  public void setTestScalar1( String testScalar1 ) {
    this.testScalar1 = testScalar1;
  }

  @Override
  public String getAsString() throws TemplateModelException {
    return testScalar1;
  }
}

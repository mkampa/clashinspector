package com.cedarsoft.maven.clashinspector.visualize.htmlDatamodels;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;
import freemarker.template.TemplateSequenceModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 15.03.14
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
public class TestList1{
  private List root = new ArrayList();

  public TestList1( List root ) {
    this.root = root;
  }

  public List getRoot() {
    return root;
  }

  public void setRoot( List root ) {
    this.root = root;
  }


  public double sup(){
    return 12345;
  }
}

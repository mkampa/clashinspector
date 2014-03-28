package com.cedarsoft.maven.clashinspector.visualize.htmlDatamodels;

import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 15.03.14
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
public class TestHash1{
  private String header;
  private Map root = new HashMap();

  public TestHash1( String header, Map root ) {
    this.header = header;
    this.root = root;
  }

  public Map getRoot() {
    return root;
  }

  public void setRoot( Map root ) {
    this.root = root;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader( String header ) {
    this.header = header;
  }
  public double sup(){
    return 12345;
  }
}

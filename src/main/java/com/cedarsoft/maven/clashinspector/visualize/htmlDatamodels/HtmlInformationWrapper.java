package com.cedarsoft.maven.clashinspector.visualize.htmlDatamodels;

import com.cedarsoft.maven.clashinspector.model.ClashCollectResultWrapper;
import com.cedarsoft.maven.clashinspector.mojos.ClashHtmlMojo;
import com.cedarsoft.maven.clashinspector.mojos.ClashSeverity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 18.03.14
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public class HtmlInformationWrapper {
  HashMap root = new HashMap();

  public HtmlInformationWrapper(ClashCollectResultWrapper clashCollectResultWrapper, ClashSeverity clashSeverity, ClashHtmlMojo clashHtmlMojo) {
    root.put("clashCollectResultWrapper", clashCollectResultWrapper);
    root.put("clashSeverity", clashSeverity);
    root.put("clashHtmlMojo", clashHtmlMojo);
  }

  public HashMap getRoot() {
    return root;
  }

  public void setRoot( HashMap root ) {
    this.root = root;
  }
}

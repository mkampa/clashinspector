package com.cedarsoft.maven.clashinspector.visualize.htmlDatamodels;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 18.03.14
 * Time: 12:31
 * To change this template use File | Settings | File Templates.
 */
public class TestDataModelGenerator {
  HashMap root = new HashMap();

  public HashMap generateDataModel(){
    TestScalar1 testScalar1 = new TestScalar1("Mond");
    Map map = new HashMap(  );
    map.put("name", "Günter");
    map.put("ort", "Stuttgart");
    map.put("haustier", "Ziege");
    TestHash1 testHash1 = new TestHash1("Kopf", map);
    //HashMap testHash1 = new HashMap( map );

    List list = new LinkedList(  );
    list.add( "eins" );
    list.add( "zwei" );

    TestList1 testList1 = new TestList1(list);

    root.put( "testScalar1", testScalar1 );
    root.put( "testHash1", testHash1 );
    root.put( "testList1", testList1 );

    return root;
  }
}

package com.cedarsoft.hsrt.zkb.ourplugin.model;

import com.cedarsoft.hsrt.zkb.ourplugin.mojos.ClashSeverity;
import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.version.Version;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: m
 * Date: 18.11.13
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
public class DependencyNodeWrapper  {
  //DependencyNodeVersionDetails

  private final DependencyNode dependencyNode;
  private final ArrayList<DependencyNodeWrapper> children = new ArrayList<DependencyNodeWrapper>();


  //private final ArrayList<DependencyNodeWrapper> ancestors = new ArrayList<DependencyNodeWrapper>()  ;
  //Tiefe innerhalb des baumes
  private final int graphDepth;
  //  Rangfolge innerhalb einer ebene(Tiefe)
  private final int graphLevelOrder;
  //important for usedversion
  private final int addCounter;
  private final DependencyNodeWrapper parent;
  private Project project;

   //relationship to used version


  public DependencyNodeWrapper( DependencyNode dependencyNode, DependencyNodeWrapper parent, Project project, int graphDepth, int graphLevelOrder, int addCounter ) {
    this.dependencyNode = dependencyNode;
    this.graphDepth = graphDepth;
    this.graphLevelOrder = graphLevelOrder;
    this.parent = parent;
    this.addCounter = addCounter;
    this.project = project;
  }

  public DependencyNodeWrapper( DependencyNode dependencyNode ) {
    this.dependencyNode = dependencyNode;
    this.graphDepth = 0;
    this.graphLevelOrder = 0;
    this.parent = null;
    this.addCounter = 0;
    this.project = null;
  }


  protected DependencyNode getDependencyNode() {
    return dependencyNode;
  }

  public String getGroupId() {

    return this.dependencyNode.getArtifact().getGroupId();

  }

  public String getArtifactId() {
    return this.dependencyNode.getArtifact().getArtifactId();
  }

  public Version getVersion() {
    return this.dependencyNode.getVersion();
  }


  public List<DependencyNodeWrapper> getChildren() {
    return Collections.unmodifiableList( this.children );
  }


  public DependencyNodeWrapper getParent() {
    return this.parent;
  }

  public List<DependencyNodeWrapper> getAllAncestors() {
    List<DependencyNodeWrapper> list = new ArrayList<DependencyNodeWrapper>();
    return this.collectAncestors( list );
  }


  private List<DependencyNodeWrapper> collectAncestors( List<DependencyNodeWrapper> list ) {
    if ( this.graphDepth != 0 ) {

      this.parent.collectAncestors( list );
      list.add( this );
    }

    return list;
  }



  public RelationshipToUsedVersion getRelationShipToUsedVersion() {
    //compare nodeVersion with inMavenUsedVersion
    int clashResult = this.getVersion().compareTo( this.project.getUsedVersion() );


    if ( clashResult < 0 ) {
      return RelationshipToUsedVersion.USED_VERSION_HIGHER;
    } else if ( clashResult > 0 ) {
      return RelationshipToUsedVersion.USED_VERSION_LOWER;
    } else {
      return RelationshipToUsedVersion.EQUAL;
    }
  }


  public String toString() {
    return this.dependencyNode.toString();
  }


  public void addChildren( DependencyNodeWrapper dependencyNodeWrapper ) {
    this.children.add( dependencyNodeWrapper );
  }

  public int getGraphDepth() {
    return graphDepth;
  }

  public int getGraphLevelOrder() {
    return graphLevelOrder;
  }

  public int getAddCounter() {
    return addCounter;
  }


  public Project getProject() {
    return project;
  }



  public enum RelationshipToUsedVersion
      {
        EQUAL(ClashSeverity.SAFE),USED_VERSION_HIGHER(ClashSeverity.UNSAFE),USED_VERSION_LOWER(ClashSeverity.CRITICAL)     ;

        private ClashSeverity clashSeverity;

        private RelationshipToUsedVersion( ClashSeverity clashSeverity ) {
          this.clashSeverity = clashSeverity;
        }

        public ClashSeverity getClashSeverity() {
          return clashSeverity;
        }
      }


}

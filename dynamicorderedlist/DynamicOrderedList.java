/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicorderedlist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Node<T> {
 
 private T data = null;
 private Date timestamp;
 private Integer nodeNumber;
 private String nodeId;
 private String referenceNode;
 private String childReferenceNode;
 private String genesisReferenceNodeId;
 private String HashValue;
 
 private List<Node<T>> children = new ArrayList<>();
 
 
 private Node<T> parent = null;
 
 public Node(T data) {
 this.data = data;
 }
 
 public Node<T> addChild(Node<T> child) {
 child.setParent(this);
 this.children.add(child);
 return child;
 }
 
 public void addChildren(List<Node<T>> children) {
 children.forEach(each -> each.setParent(this));
 this.children.addAll(children);
 }
 
 public List<Node<T>> getChildren() {
 return children;
 }
 
 public Date getTimeStamp()
 {
  return timestamp;
 }
 
 public Integer getNodeNumber()
 {
  return nodeNumber;
 }
 
 public String getNodeId()
 {
  return nodeId;
 }
 
 public String getChileReferenceNodeId()
 {
  return childReferenceNode;
 }
 
 public String getGenesisReferenceNodeId()
 {
  return genesisReferenceNodeId;
 }
 
 public T getData() {
 return data;
 }
 
 public void setData(T data) {
 this.data = data;
 }
 
 private void setParent(Node<T> parent) {
 this.parent = parent;
 }
 
 public Node<T> getParent() {
 return parent;
 }
}

public class DynamicOrderedList {
    
    
 private static Node<String> createTree() {
Node<String> genesis = new Node<>("root");
Scanner sc = new Scanner(System.in);
     System.out.println("Enter the value of Genesis(root) Node : ");
     int r = sc.nextInt();
     System.out.println("Enter the value of Left Node : ");
     int l = sc.nextInt();
     System.out.println("Enter the value of Right Node : ");
     int ri = sc.nextInt();
     String sr = String.valueOf(r);
     String sl = String.valueOf(l);
     String sri = String.valueOf(ri);
     if(r-(l-ri)<=3)
     {
      Node<String> noder = genesis.addChild(new Node<String>("A "+sr));
      Node<String> nodel = noder.addChild(new Node<String>("B "+sl));
      Node<String> noderi = nodel.addChild(new Node<String>("C "+sri));
     }
     else
         System.out.println("Tree cannot exists as sum of values of sibling chile nodes cannot have greater than root node!!");
     

return genesis;
	}
	
	 private static <T> void printTree(Node<T> node, String appender) {
		  System.out.println(appender + node.getData());
		  node.getChildren().forEach(each ->  printTree(each, appender + appender));
	 }
         
    public static void main(String[] args) {
        
		Node<String> root = createTree();
		printTree(root, " ");

    }
    
}


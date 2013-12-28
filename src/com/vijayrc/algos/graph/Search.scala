package com.vijayrc.algos.graph

import java.util

trait Search {
  def on(graph:Graph)
}
class BreadthFirst extends Search{
  def on(graph:Graph){
    val queue = new java.util.LinkedList[Node]()
    val root: Node = graph.nodes(0)
    root.seen = true
    print(root.value +",")
    queue.add(root)

    while(!queue.isEmpty){
      val node = queue.remove()
      var child = node.unvisitedEdgeNode
      while(child != null){
        child.seen = true
        print(child.value +",")
        queue.add(child)
        child = node.unvisitedEdgeNode
      }
    }
  }
}
class DepthFirst extends Search{
  def on(graph:Graph){
    val stack = new util.Stack[Node]() //stack of visitedNodes
    val root: Node = graph.nodes(0)
    root.seen = true
    print(root.value +",")
    stack.push(root)

    while(!stack.isEmpty){
      val node = stack.peek()
      val child = node.unvisitedEdgeNode

      if(child != null){
        child.seen = true
        print(child.value +",")
        stack.push(child)
      }else{
        stack.pop() // all child nodes have been visited, so need to be in processing stack anymore
      }
    }
  }
}

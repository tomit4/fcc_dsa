const LinkedList = require("./SinglyLinkedList.js");

class Graph {
  constructor(nodes) {
    this.adjList = [];
    this.createGraph(nodes);
    this.vertices = nodes;
    this.edges = 0;
  }

  createGraph(nodes) {
    for (let i = 0; i < nodes; i++) {
      this.adjList[i] = new LinkedList();
    }
  }

  addEdge(u, v) {
    this.adjList[u].append(v);
    this.adjList[v].append(u);
    this.edges++;
  }
}

const main = () => {
  const graph = new Graph(4);
  graph.addEdge(0, 1);
  graph.addEdge(1, 2);
  graph.addEdge(2, 3);
  graph.addEdge(3, 0);
  return graph;
};

const newGraph = main();

const printGraph = () => {
  console.log(`${newGraph.vertices} vertices, ${newGraph.edges} edges`);
  for (let i = 0; i < newGraph.adjList.length; i++) {
    console.log(
      `${i}: ${newGraph.adjList[i].head.value} ${newGraph.adjList[i].head.next.value}`,
    );
  }
};

printGraph();
/*
4 vertices, 4 edges
0: 1 3
1: 0 2
2: 1 3
3: 2 0
*/

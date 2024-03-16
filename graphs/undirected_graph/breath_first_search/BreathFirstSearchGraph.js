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

  bfs(s) {
    const visited = new Array(this.vertices).fill(false);
    const queue = [];
    queue.push(s);
    visited[s] = true;
    while (queue.length) {
      const u = queue.shift();
      console.log(u);
      let current = this.adjList[u].head;
      while (current) {
        if (!visited[current.value]) {
          visited[current.value] = true;
          queue.push(current.value);
        }
        current = current.next;
      }
    }
  }
}

const main = () => {
  const graph = new Graph(5);
  graph.addEdge(0, 1);
  graph.addEdge(1, 2);
  graph.addEdge(2, 3);
  graph.addEdge(3, 0);
  graph.addEdge(2, 4);
  return graph;
};

const newGraph = main();

const printGraph = () => {
  console.log(`${newGraph.vertices} vertices, ${newGraph.edges} edges`);
  for (let i = 0; i < newGraph.adjList.length; i++) {
    let current = newGraph.adjList[i].head;
    let output = `${i}:`;
    while (current) {
      output += ` ${current.value}`;
      current = current.next;
    }
    console.log(output);
  }
};
printGraph();
/*
5 vertices, 5 edges
0: 1 3
1: 0 2
2: 1 3 4
3: 2 0
4: 2
*/
newGraph.bfs(0);
/*
0;
1;
3;
2;
4;
*/

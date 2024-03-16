class Graph {
  constructor(nodes) {
    this.adjMatrix = [];
    this.createGraph(nodes);
  }

  createGraph(nodes) {
    this.adjMatrix = Array(nodes)
      .fill(null)
      .map(() => {
        return Array(nodes).fill(0);
      });
  }

  addEdge(u, v) {
    this.adjMatrix[u][v] = 1;
    this.adjMatrix[v][u] = 1;
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
console.log("newGraph.adjMatrix :=>", newGraph.adjMatrix);
// newGraph.adjMatrix :=> [ [ 0, 1, 0, 1 ], [ 1, 0, 1, 0 ], [ 0, 1, 0, 1 ], [ 1, 0, 1, 0 ] ]

// Nicer Output:
/*
[ 
    [ 0, 1, 0, 1 ], 
    [ 1, 0, 1, 0 ], 
    [ 0, 1, 0, 1 ], 
    [ 1, 0, 1, 0 ] 
]
*/

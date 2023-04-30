/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number}
 */
var maxNumEdgesToRemove = function(n, edges) {
  let removedEdge = 0;

  edges.sort((a, b) => b[0] - a[0]);
  
  const alice = new UnionFind(n);
  const bob = new UnionFind(n);
  
  for(let i = 0; i < edges.length; i++){
    let type = edges[i][0];
    let u = edges[i][1];
    let v = edges[i][2];

    switch(type){
      case 3:
        if(!alice.union(u - 1, v - 1) || !bob.union(u - 1, v - 1)){
          removedEdge++;
        }
        break;
      case 2:
        if(!bob.union(u - 1, v - 1)){
          removedEdge++;
        }
        break;
      case 1:
        if(!alice.union(u - 1, v - 1)){
          removedEdge++;
        }
        break;
    }
  }
  if(alice.groups !== 1 || bob.groups !== 1) return -1;
  return removedEdge;
};

class UnionFind {
  constructor(n){
    this.parent = Array(n).fill().map((_, index) => index);
    this.groups = n;
  }

  find(i){
    if(this.parent[i] !== i){
      this.parent[i] = this.find(this.parent[i]);
    }
    return this.parent[i];
  }

  union(u, v){
    const x = this.find(u), y = this.find(v);
        if(x === y) return false;
        else{
            this.parent[x] = y;
            this.groups--;
            return true;
        }
  }
}
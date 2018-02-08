% Name: Nisha Patel
% File: primlp
% Description: Implementation of Prims algorithm in asp
% Date: 03/21/17

% Prims

%Vertices of the graph.
node(a;b;c;d;e;f;g;h;i).

%Edges of the graph.
edge(a, b, 4). edge(a, h, 10).
edge(b, c, 8). edge(b, h, 11).
edge(c, i, 2). edge(c, f, 4). edge(c, d, 7).
edge(d, f, 14). edge(d, e, 9).
edge(e, f, 10).
edge(f, g, 2).
edge(g, i, 6). edge(g, h, 1).
edge(h, i, 7).

%Declare a root from the node. A starting node of the tree
start(root).

%Edges are undirected
edge(Y,X,C):- edge(X,Y,C).

%Edges that are part of tree
tree(X,Y,C) ; not tree(X,Y,C):- edge(X,Y,C), reachable(X).

% avoid duplicates edges
:-tree(X,Y,C), tree(Z,Y,C2), X!=Z.

%Each node is reachable if it's adjacent to the starting node
reachable(X):-start(X).

%A node is reachable if it is adjacent to another reachable node
reachable(Y):-reachable(X),tree(X,Y,C). 

%automatically exclude graphs with unreachable nodes
:-node(X), not reachable(X).

%minimizes total costs 
#minimize{C,X,Y : tree (X,Y,C), edge(X,Y,C)}.

#show tree/3.
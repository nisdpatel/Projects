{-
Name		:  Nisha Patel
Module		:  prims.hs
Description :  Implementation of Prim's Algorithm in Haskell
Date 		:  02/09/17
      
-}
import Data.List (minimumBy,nub)
import Data.Ord (comparing)


{-
Description: 
The prim function takes a graph.  
First, it picks a "random" node(The first letter of the  first node) in the graph and finds the smallest edge associated with that node. 
Second, prim' parameter currentPath - It grabs the first node in from the tuple and find its edges. We keep traversing the nodes, prim' 
keeps tracks of our current path based on our previous moves. Third, prim' parameter visted - we start with an empty list and we keep 
adding nodes as we go along and prim' will keep track of nodes that we have visited in the graph by adding the current nodes to the l
ist of visited nodes. Lastly, prim' parameter notVisited - we start with nodes that we have in the graph and as we go along, we keep 
removing them. prim' will keep track of nodes that we have notvisited yet in the graph by generating a list of nodes not visited.

Input: A graph (a list of tuples).
Output: A list of tuples that has a minimum path in the graph by picking a random point in the graph and find closest based on it. 
-}
prim :: [(Char, Char, Integer)] -> [(Char, Char, Integer)]
prim aGraph = prim' aGraph (findClosest (findEdges aGraph (fst3 (head aGraph)))) (addVisited (head (findClosest (findEdges aGraph (fst3 (head aGraph))))) []) (removeVisited (head (findClosest (findEdges aGraph (fst3 (head aGraph))))) (findVertices aGraph))

     

{-
Description: 
The prim' function take a graph and track a current path as we go along. The currentPath keep track of nodes that we have visited in 
the graph by finding the closest nodes. It keeps adding the tuples after finding the closest possbile next move. The visited keep track
of nodes that are visited in the graph. It adds the node in the previous list as we go along. We start with a visited list of only the
nodes added from prim and it adds the visited nodes into the visited list after we have seen a node. As soon as we have seen a node,
it removes the node from the notVisited list and adds it into the visitedList. The notVisited keep track of nodes that are not visited
in the graph. It removes the node from the previous list as we go alon.

Input: A graph, currentpath (a list of tuples), a list of characters that are visited, and a list of characters that are notvisited.
Output: A list of tuples. 
-}
prim' :: [(Char, Char, Integer)]->[(Char, Char, Integer)]->[Char]->[Char]->[(Char, Char, Integer)]
prim' aGraph currentPath visited [] = currentPath
prim' aGraph currentPath visited notVisited = prim' aGraph (currentPath ++ (findClosest (findNextNode aGraph visited notVisited))) (addVisited (head (findClosest (findNextNode aGraph visited notVisited))) visited) (removeVisited (head (findClosest (findNextNode aGraph visited notVisited))) notVisited)



{-
Description: The findNextNode function makes a list of nodes that have a least one node in visited and one node in notVisited. 
Input: A list of tuples, and a first and a second letters of that tuple.
Output: A list of tuples.
-}
findNextNode :: (Foldable t1, Foldable t) =>[(Char, Char, Integer)]-> t1 Char -> t Char -> [(Char, Char, Integer)]
findNextNode aGraph visited notVisited = [x | x <- aGraph, (((fst3 x) `elem` visited) || ((snd3 x) `elem` visited)) && (((fst3 x) `elem` notVisited) || ((snd3 x) `elem` notVisited))  ]


{-
Description: The removeVisited function takes a tuple and a list of characters and it filters out the nodes that are in the tuple 
and returns the list with rest of the nodes. 
Input: A tuple and a list of nodes.
Output: A list of nodes after removing the visited nodes.
-}
removeVisited :: (Char, Char, Integer)->[Char]->[Char]
removeVisited x xs = filter (/= (fst3 x)) (filter (/= (snd3 x)) xs)


{-
Description: The addVisited function add the nodes that are visited into the list.
Input: A tuple and a list of characters.
Output: A list of characters.
-}
addVisited :: (Char, Char, Integer)->[Char]->[Char]
addVisited x xs = xs ++ [(fst3 x)] ++ [(snd3 x)]


{- 
Description: The findEdges function returns all the tuples that are associated with the given node. 
Input: A list of tuples with a node.
Output: A list of tuples that are associated with the node.
-}
findEdges :: [(Char, Char, Integer)]->Char->[(Char, Char, Integer)]
findEdges [] l = []
findEdges (x1:x) l = 
     if checkTuple x1 l == True then x1:findEdges x l
     else findEdges x l


{-
Description: The findClosest function checks for a tuple that has a smallest weight.
Input: A list of tuples.
Output: A list of tuple that has a smallest weight. 
-}
findClosest :: [(Char, Char, Integer)] -> [(Char, Char, Integer)]
findClosest x  = [minimumBy (comparing trd3) x ]


{-
Description: checkTuple function checks whether a letter is in the tuple or not. If the letter is in the tuple, it returns true ,or false otherwise. 
Input: A tuple and a character.
Output: Bool
-}
checkTuple :: (Char,Char,Integer)->Char->Bool
checkTuple (a,b,c) l = (l == a)||(l == b)


{-
Description: The findVertices function finds all unique vertices of the list after removing the duplicates.
Input: A list of tuples.
Output: A list of unique all nodes.
-}
findVertices ::[(Char, Char, Integer)] -> [Char]
findVertices n = (nub ([a | (a,_,_) <- n ] ++ [b | (_,b,_) <- n]))


{-
The weight function weight the tree.
Input: A list of integers from the tuples.
Output: An integer.
-}
weight::[(Char,Char,Integer)] -> Integer
weight m = sum [a | (_,_,a)<- m]


{- 
Description: fst3 function takes a tuple and returns a first character from the tuple. 
Input: Takes a tuple.
Output: First character.
-}
fst3 :: (Char, Char, Integer) ->Char
fst3 (x,_,_) = x


{-
Description: snd3 function takes a tuple and returns a second character from the tuple.
Input: Takes a tuple. 
Output: Second character.
-}
snd3 :: (Char, Char, Integer) ->Char
snd3 (_,x,_) = x


{-
Descrition: trd3 function takes a tuple and returns a third Integer from the tuple.
Input: Takes a tuple.
Output: Third Integer.
-}
trd3 :: (Char, Char, Integer) -> Integer
trd3 (_,_,x) = x


-- The Sample graph function for testing purpose only 
graph = [ ('a', 'b',4),('b','c',8),('c','i',2),('i','h',7),('h','a',10),('h','g',1),('i','g',6),('g','f',2),('f','e',10),('f','c',4),('f','d',14),('d','e',10),('c','d',7),('h','b',11)]































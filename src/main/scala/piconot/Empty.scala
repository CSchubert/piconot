import piconot.NewPiconot

object EmptyMazeSolution extends NewPiconot {

    // These rules represent the solution for an empty maze.
  
	State(0)
		freeDirections(N)
		blockedDirections()
		moveDirection(N)
		newState(0)
	
		freeDirections()
		blockedDirections(N)
		moveDirection(X)
		newState(1)

	State(1)
		freeDirections(E)
		blockedDirections()
		moveDirection(E)
		newState(1)
	
		freeDirections()
		blockedDirections(E)
		moveDirection(X)
		newState(2)

	State(2)
		freeDirections(W)
		blockedDirections()
		moveDirection(W)
		newState(2)
	
		freeDirections()
		blockedDirections(W)
		moveDirection(S)
		newState(1)		
	
	runMaze("empty.txt")
} 
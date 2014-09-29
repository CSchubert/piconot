import piconot.NewPiconot

object RightHandSolution extends NewPiconot {

    // These rules represent the solution for an maze using the right hand rule.
    // Picobot only makes right-hand turns. If the bot can go right, it will.
    // Otherwise, it will stay put and enter a state such that going right in
    // that state corresponds with going straight in the original state.
  
    // Picobot is facing North.
	State(0)
		freeDirections(E)
		blockedDirections()
		moveDirection(E)
		newState(1)
	
		freeDirections()
		blockedDirections(E)
		moveDirection(X)
		newState(2)

    // Picobot is facing East.
	State(1)
		freeDirections(S)
		blockedDirections()
		moveDirection(S)
		newState(3)
	
		freeDirections()
		blockedDirections(S)
		moveDirection(X)
		newState(0)

    // Picobot is facing West.
	State(2)
		freeDirections(N)
		blockedDirections()
		moveDirection(N)
		newState(0)
	
		freeDirections()
		blockedDirections(N)
		moveDirection(X)
		newState(3)		

    // Picobot is facing South.
	State(3)
		freeDirections(W)
		blockedDirections()
		moveDirection(W)
		newState(2)
	
		freeDirections()
		blockedDirections(W)
		moveDirection(X)
		newState(1)		
	
	runMaze("maze.txt")
} 
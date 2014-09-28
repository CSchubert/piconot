/**
 * New Picobot Syntax
 * Implemented by Christine Schubert & Michael Culhane
 */

package piconot

import java.io.File
import picolib.maze.Maze
import picolib.semantics.Anything
import picolib.semantics.Blocked
import picolib.semantics.East
import picolib.semantics.GUIDisplay
import picolib.semantics.North
import picolib.semantics.Open
import picolib.semantics.Picobot
import picolib.semantics.Rule
import picolib.semantics.South
import picolib.semantics.State
import picolib.semantics.Surroundings
import picolib.semantics.TextDisplay
import picolib.semantics.West
import scalafx.application.JFXApp
import picolib.semantics.MoveDirection
import picolib.semantics.StayHere
import picolib.semantics.RelativeDescription
import scala.collection.mutable.MutableList

trait NewPiconot extends JFXApp {
  
  var currentState: Int
  var freeDirectionValues: Seq[MoveDirection]
  var blockedDirectionValues: Seq[MoveDirection]
  var moveDirectionValue: MoveDirection
  var newStateValue: Int
  
  var rules: List[Rule] = List()
  
  def State(stateNumber: Int) = {
    currentState = stateNumber
  }
  
  def freeDirections(directions: String*) = {
    freeDirectionValues = directions map getDirectionForString
  }
    
  def blockedDirections(directions: String*) = {
    blockedDirectionValues = directions map getDirectionForString
  }
    
  def moveDirection(direction: String) = {
    moveDirectionValue = getDirectionForString(direction)
  }
  
  def newState(state: Int) = {
    newStateValue = state
    createRule
  }
  
  def runMaze(fileName: String) = {
    val maze = Maze("resources" + File.separator + fileName)
    object MazeBot extends Picobot(maze, rules)
        with TextDisplay with GUIDisplay
    stage = MazeBot.mainStage
  }
  
  def getDirectionForString(directionString: String): MoveDirection = {
    directionString match {
      case "N" => North
      case "E" => East
      case "W" => West
      case "S" => South
    }
  }
  
  def getRelativeDescription(direction: MoveDirection): RelativeDescription = {
    if (freeDirectionValues.contains(direction)) {
      Open
    } else if (blockedDirectionValues.contains(direction)) {
      Blocked
    } else {
      Anything
    }
  } 
  
  def surroundings: Surroundings = {
    Surroundings(
      getRelativeDescription(North),
      getRelativeDescription(East),
      getRelativeDescription(West),
      getRelativeDescription(South)
    )
  } 
  
  def createRule = {
    rules = rules :+ Rule(
     picolib.semantics.State(currentState.toString),
     surroundings,
     moveDirectionValue,
     picolib.semantics.State(newStateValue.toString)  
    )
  }
}
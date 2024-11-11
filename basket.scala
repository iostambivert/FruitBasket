import scala.collection.mutable.ListBuffer

class Basket(val name: String) {
  private val contents = ListBuffer[String]()

  // Method to add a fruit to the basket
  def addFruit(fruitName: String): Unit = {
    contents += fruitName
    println(s"$fruitName added to $name.")
  }

  def removeFruit(fruitName: String): Boolean = {
    if (contents.contains(fruitName)) {
      contents -= fruitName
      println(s"$fruitName removed from $name.")
      true
    } else {
      println(s"$fruitName not found in $name.")
      false
    }
  }

  def copyTo(otherBasket: Basket): Unit = {
    otherBasket.contents ++= this.contents
    println(s"All items copied from $name to ${otherBasket.name}.")
  }
  
  def moveTo(otherBasket: Basket): Unit = {
    otherBasket.contents ++= this.contents
    contents.clear()
    println(s"All items moved from $name to ${otherBasket.name}. $name is now empty.")
  }

  def showContents(): Unit = {
    println(s"$name contents: ${contents.mkString(", ")}")
  }
}

// Create two baskets
val basket1 = new Basket("basket1")
val basket2 = new Basket("basket2")

// Adding
basket1.addFruit("Apple")
basket1.addFruit("Banana")
basket1.showContents()

// Removing
basket1.removeFruit("Banana")
basket1.showContents()

// Copying
basket1.copyTo(basket2)
basket2.showContents()

// Moving
basket1.moveTo(basket2)
basket1.showContents()
basket2.showContents()

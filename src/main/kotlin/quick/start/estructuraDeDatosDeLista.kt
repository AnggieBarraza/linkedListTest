
fun main(){
    val list = AnggieLinkedList()
    val hi = list.isEmpty()
            println("It's $hi       => True: Empty list - False: non-empty list")

        list.insert((Pair(1, "insert")))
        list.insert((Pair(3, "insert")))
        list.insert((Pair(2, "insert")))
        list.prepend((Pair(-1, "prepend")))
        list.prepend((Pair(-2, "prepend")))
        list.prepend((Pair(-3, "prepend")))
        list.append((Pair(4, "append")))
        list.append((Pair(5, "append")))
        list.append((Pair(6, "append")))
            println()
    val list0 = list.toString()
        println("List: ")
        println(list0)
        println()

        print("El puntero esta en el nodo:          ")
        println(list.get())
        println()

        list.delete()
        println("Despues de eliminar")
        println(list.toString())
        println()

    val list1 = list.toString()
        println("List: ")
        println(list1)
        println()

    list.getNext()
        print("EL puntero esta en el nodo:          ")
        println(list.get())
        println()

        list.delete()
        println("Despues de eliminar")
        println(list.toString())
        println()
}


data class Node (internal var info: Pair<Int, String>, internal var next : Node? = null){
    override fun toString(): String {
        return if(next != null){
            "$info => $next"
        } else {
            "$info"
        }
    }
}
open class AnggieLinkedList{
    private var head: Node? = null
    private var currentPointer: Node? = null
    private var previousPointer: Node? = null
    private var endPointer: Node? = null

    fun insert(info: Pair<Int, String>){
        val node = Node(info)

        if (currentPointer == null){
            createNewFirstNode(node)
        }
        else if(currentPointer?.next == null){
            currentPointer?.next = node
            endPointer = node
        }
        else {
            node.next = currentPointer?.next
            currentPointer?.next = node
        }
    }
    fun prepend(info: Pair<Int, String>){
        val firstNode = Node(info)
        if (head == null){
            createNewFirstNode(firstNode)
        }
        else if(currentPointer == head){
            firstNode.next = head
            head = firstNode
            previousPointer = firstNode
        }
        else {
            firstNode.next = head
            head = firstNode
        }
    }
    fun append(info: Pair<Int, String>){
        val endNode = Node(info)
        if (head == null){
            createNewFirstNode(endNode)
        }
        else if(head?.next == currentPointer){
            previousPointer = head
            endPointer?.next = endNode
            endPointer = endNode
        }
        else {
            endPointer?.next = endNode
            endPointer = endNode
        }
    }
    private fun createNewFirstNode(firstNode: Node) {
        head = firstNode
        currentPointer = firstNode
        endPointer = firstNode
    }
    fun delete() {
        var ant = head
        var act = head
        var punteroSiguiente = act?.next

        if (currentPointer == null){
            previousPointer = null
            endPointer = null
            currentPointer = head
            head = null
        }
        else if (head?.next == null){
            head = null
            currentPointer = null
            endPointer = null
            previousPointer = null
        }
        else if (currentPointer == head){
            head = currentPointer?.next
            currentPointer = currentPointer?.next
        }
        else if (currentPointer?.next != null){
            currentPointer = currentPointer?.next
            previousPointer?.next = currentPointer
        }
        else if (currentPointer == endPointer){
            while (punteroSiguiente != null ){
                ant = act
                act = punteroSiguiente
                punteroSiguiente = act.next
            }
            previousPointer = ant
            ant?.next = null
            endPointer = ant
            endPointer?.next = null
            currentPointer = ant
            currentPointer?.next = null
        }
    }
    fun isEmpty(): Boolean {
        return  head == null
    }
    override fun toString(): String{
        return if (head  == null){
            ("null")
        } else {
            (head.toString())
        }
    }
    fun getNext (){
        val nextPointer = currentPointer?.next
        
        if (nextPointer == null){
            currentPointer
        }
        else if (currentPointer == head){
            currentPointer = nextPointer
            previousPointer = head
        }
        else {
            currentPointer = nextPointer
            previousPointer = previousPointer?.next
        }
    }
    fun get(): Pair<Int, String>? {
        return currentPointer?.info
    }



}


//list.insert(Pair(2, "holiwis")) YA     // Creates and inserts a new node after the current pointer
//list.delete()                   // Deletes the current pointer node
//list.prepend(Pair(3, "gato")  YA       // Creates a new node and sets it as the new head
//list.append(Pair(4, "perro")  YA       // Creates a new node and sets it at the end of the list
//list.isEmpty()                YA       // Returns true if the list is empty
//list.toString()               YA       // Returns a String of the values in this format "[(1, hola),(2, adios),(3, cokis)]"
//list.getNext()                     // Mueve el puntero actual al siguiente nodo de la lista
//list.get()                    YA       // Retorna el valor del nodo actual
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

    list.GetNext()
        print("EL puntero esta en el nodo:          ")
        println(list.get())
        println()

        list.delete()
        println("Despues de eliminar")
        println(list.toString())
        println()
}

data class Node (var info: Pair<Int, String>, var next : Node? = null ){
    override fun toString(): String {
        return if(next != null){
            "$info => $next"
        } else {
            "$info"
        }
    }
}
class AnggieLinkedList {
    var head: Node? = null
    var CurrentPointer: Node? = null
    var PreviousPointer: Node? = null
    var EndPointer: Node? = null


    fun insert(info: Pair<Int, String>){
        val node = Node(info)

        if (CurrentPointer == null){
            createNewFirstNode(node)
        }
        else if(CurrentPointer?.next == null){
            CurrentPointer?.next = node
            EndPointer = node
        }
        else {
            node.next = CurrentPointer?.next
            CurrentPointer?.next = node
        }
    }
    fun prepend(info: Pair<Int, String>){
        val firstNode = Node(info)
        if (head == null){
            createNewFirstNode(firstNode)
        }
        else if(CurrentPointer == head){
            firstNode.next = head
            head = firstNode
            PreviousPointer = firstNode
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
        else if(head?.next == CurrentPointer){
            PreviousPointer = head
            EndPointer?.next = endNode
            EndPointer = endNode
        }
        else {
            EndPointer?.next = endNode
            EndPointer = endNode
        }
    }

    private fun createNewFirstNode(firstNode: Node) {
        head = firstNode
        CurrentPointer = firstNode
        EndPointer = firstNode
    }

    fun delete() {
        var ant = head
        var act = head
        var punteroSiguiente = act?.next

        if (CurrentPointer == null){
            PreviousPointer = null
            EndPointer = null
            CurrentPointer = head
            head = null
        }
        else if (head?.next == null){
            head = null
            CurrentPointer = null
            EndPointer = null
            PreviousPointer = null
        }
        else if (CurrentPointer == head){
            head = CurrentPointer?.next
            CurrentPointer = CurrentPointer?.next
        }
        else if (CurrentPointer?.next != null){
            CurrentPointer = CurrentPointer?.next
            PreviousPointer?.next = CurrentPointer
        }
        else if (CurrentPointer == EndPointer){
            while (punteroSiguiente != null ){
                ant = act
                act = punteroSiguiente
                punteroSiguiente = act.next
            }
            PreviousPointer = ant
            ant?.next = null
            EndPointer = ant
            EndPointer?.next = null
            CurrentPointer = ant
            CurrentPointer?.next = null
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
    fun GetNext (){
        val nextPointer = CurrentPointer?.next
        
        if (nextPointer == null){
            CurrentPointer
        }
        else if (CurrentPointer == head){
            CurrentPointer = nextPointer
            PreviousPointer = head
        }
        else {
            CurrentPointer = nextPointer
            PreviousPointer = PreviousPointer?.next
        }
    }
    fun get(): Pair<Int, String>? {
        return CurrentPointer?.info
    }

}

//list.insert(Pair(2, "holiwis")) YA     // Creates and inserts a new node after the current pointer
//list.delete()                   // Deletes the current pointer node
//list.prepend(Pair(3, "gato")  YA       // Creates a new node and sets it as the new head
//list.append(Pair(4, "perro")  YA       // Creates a new node and sets it at the end of the list
//list.isEmpty()                YA       // Returns true if the list is empty
//list.toString()               YA       // Returns a String of the values in this format "[(1, hola),(2, adios),(3, cokis)]"
//list.GetNext()                     // Mueve el puntero actual al siguiente nodo de la lista
//list.get()                    YA       // Retorna el valor del nodo actual
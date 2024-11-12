fun main(){
    val list = AnggieLinkedList() //objeto/instancia
    val hi = list.isEmpty()
            println("It's $hi       => True: lista vacia - False: lista no vacia") //TRUE vacia

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
    val lista0 = list.toString() //(1, append) -> (2, append) -> null
        println("List: ")
        println(lista0)
        println()

        print("El puntero esta en el nodo:          ")
        println(list.get())
        println()

        list.delete()
        println("Despues de eliminar")
        println(list.toString())
        println()

    val lista1 = list.toString() //(1, append) -> (2, append) -> null
        println("List: ")
        println(lista1)
        println()

        list.next()
    list.next()
    list.next()
        print("EL puntero esta en el nodo:          ")
        println(list.get())
        println()

        list.delete()
        println("Despues de eliminar")
        println(list.toString())
        println()

//    val lista2 = list.toString() //(1, append) -> (2, append) -> null
//        println("List: ")
//        println(lista2)
//        println()
//
//        print("EL puntero esta en el nodo:          ")
//        println(list.get())
//        println()
//
//        list.delete()
//        println("Despues de eliminar")
//        println(list.toString())
//        println()

}

data class Node (var info: Pair<Int, String>, var siguiente : Node? = null ){
    override fun toString(): String {
        return if(siguiente != null){
            "$info => $siguiente"
        } else {
            "$info"
        }
    }
}
class AnggieLinkedList {
    var head: Node? = null
    var punteroActual: Node? = null 
    var punteroAnterior: Node? = null
    var punteroFinal: Node? = null
//    var nodoGeneral = Nodo(Pair(0, "head"))


    fun insert(info: Pair<Int, String>){
        val node = Node(info)

        if (punteroActual == null){
            createNewFirstNode(node)
        }
        else if(punteroActual?.siguiente == null){
            punteroActual?.siguiente = node
            punteroFinal = node
        }
        else {
            node.siguiente = punteroActual?.siguiente
            punteroActual?.siguiente = node
        }
    }
    fun prepend(info: Pair<Int, String>){
        val firstNode = Node(info)
        if (head == null){
            createNewFirstNode(firstNode)
        }
        else if(punteroActual == head){
            firstNode.siguiente = head
            head = firstNode
            punteroAnterior = firstNode
        }
        else {
            firstNode.siguiente = head
            head = firstNode
        }
    }
    fun append(info: Pair<Int, String>){ //final de la lista
        val endNode = Node(info)
        if (head == null){
            createNewFirstNode(endNode)
        }
        else if(head?.siguiente == punteroActual){
            punteroAnterior = head
            punteroFinal?.siguiente = endNode
            punteroFinal = endNode
        }
        else {
            punteroFinal?.siguiente = endNode
            punteroFinal = endNode
        }
    }

    private fun createNewFirstNode(firstNode: Node) {
        head = firstNode
        punteroActual = firstNode
        punteroFinal = firstNode
    }

    fun delete() {
        var ant = head
        var act = head
        var punteroSiguiente = act?.siguiente

        if (punteroActual == null){
            punteroAnterior = null
            punteroFinal = null
            punteroActual = head
            head = null
        }
        else if (head?.siguiente == null){//solo esta el head
            head = null
            punteroActual = null
            punteroFinal = null
            punteroAnterior = null
        }
        else if (punteroActual == head){
            head = punteroActual?.siguiente
            punteroActual = punteroActual?.siguiente
        }
        else if (punteroActual?.siguiente != null){ // el puntero esta en el medio
            punteroActual = punteroActual?.siguiente
            punteroAnterior?.siguiente = punteroActual
        }
        else if (punteroActual == punteroFinal){
            while (punteroSiguiente != null ){ //head?.siguiente != null
                ant = act
                act = punteroSiguiente
                punteroSiguiente = act.siguiente
            }
            punteroAnterior = ant
            ant?.siguiente = null
            punteroFinal = ant
            punteroFinal?.siguiente = null
            punteroActual = ant
            punteroActual?.siguiente = null
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
    fun next (){
        val nextPointer = punteroActual?.siguiente
        
        if (nextPointer == null){
            punteroActual
        }
        else if (punteroActual == head){
            punteroActual = nextPointer
            punteroAnterior = head
        }
        else {
           punteroActual = nextPointer
           punteroAnterior = punteroAnterior?.siguiente
        }
    }
    fun get(): Pair<Int, String>? {
        return punteroActual?.info
    }

}

//list.insert(Pair(2, "holiwis")) YA     // Creates and inserts a new node after the current pointer
//list.delete()                   // Deletes the current pointer node
//list.prepend(Pair(3, "gato")  YA       // Creates a new node and sets it as the new head
//list.append(Pair(4, "perro")  YA       // Creates a new node and sets it at the end of the list
//list.isEmpty()                YA       // Returns true if the list is empty
//list.toString()               YA       // Returns a String of the values in this format "[(1, hola),(2, adios),(3, cokis)]"
//list.next()                     // Mueve el puntero actual al siguiente nodo de la lista
//list.get()                    YA       // Retorna el valor del nodo actual
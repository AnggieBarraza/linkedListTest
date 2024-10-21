//recursion, recursividad y quiero le cambie a recursividad a ciclo, explicar ventajas y desventajas de estos dos
fun main(){
    val list: AnggieLinkedList = AnggieLinkedList() //objeto/instancia
    val hi = list.isEmpty()
            println("It's $hi       => True: lista vacia - False: lista no vacia") //TRUE vacia

        list.insert((Pair(1, "insert")))
        list.insert((Pair(3, "insert")))
        list.insert((Pair(2, "insert")))
        list.prepend((Pair(0, "prepend")))
//        list.prepend((Pair(-1, "prepend")))
//        list.prepend((Pair(-2, "prepend")))
//        list.append((Pair(4, "append")))
//        list.append((Pair(5, "append")))
//        list.append((Pair(6, "append")))
            println()
    val lista0 = list.toString() //(1, append) -> (2, append) -> null
        println("Lista: ")
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
        println("Lista: ")
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

    val lista2 = list.toString() //(1, append) -> (2, append) -> null
        println("Lista: ")
        println(lista2)
        println()

        print("EL puntero esta en el nodo:          ")
        println(list.get())
        println()

        list.delete()
        println("Despues de eliminar")
        println(list.toString())
        println()

}

data class Nodo (var info: Pair<Int, String>, var siguiente : Nodo? = null ){
    override fun toString(): String {
        return if(siguiente != null){
            "$info => $siguiente"
        } else {
            "$info"
        }
    }
}
class AnggieLinkedList(){
    var head: Nodo? = null
    var punteroActual: Nodo? = null 
    var punteroAnterior: Nodo? = null
    var punteroFinal: Nodo? = null

    fun insert(info: Pair<Int, String>){
        val node = Nodo(info) //creo un nuevo nodo

        if (punteroActual == null){ //checamos que head no este vacio
            head = node
            punteroActual = node
            punteroFinal = node
        }
        else if(punteroActual?.siguiente == null){
            punteroActual?.siguiente = node
            punteroFinal = node
        }
        else {
            node.siguiente = punteroActual?.siguiente
            punteroActual?.siguiente = node
            // punteroFinal = node.siguiente //
            // punteroAnterior = punteroAnterior?.siguiente//
        }
    }
    fun prepend(info: Pair<Int, String>){// inicio de la list
        val nodoInicio = Nodo(info)
        if (head == null){ 
            head = nodoInicio
            punteroActual = nodoInicio//
            punteroFinal = punteroActual//
        }
        else if(punteroActual == head){
            nodoInicio.siguiente = head
            head = nodoInicio
            punteroAnterior = nodoInicio
        }
        else {
            nodoInicio.siguiente = head
            head = nodoInicio
        }
    }
    fun append(info: Pair<Int, String>){ //final de la lista
        val nodoFinal = Nodo(info)
        if (head == null){
            head = nodoFinal
            punteroActual = nodoFinal
            punteroFinal = nodoFinal
        }
        else if(head?.siguiente == punteroActual){
            punteroAnterior = head
            punteroFinal?.siguiente = nodoFinal
            punteroFinal = nodoFinal
        }
        else {
            punteroFinal?.siguiente = nodoFinal
            punteroFinal = nodoFinal
            // punteroActual = punteroActual?.next
            // punteroAnterior = punteroAnterior?.next
        }
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
        val punteroSiguiente = punteroActual?.siguiente
//        if (punteroSiguiente == null && head != null){ //lo hace circular
//            punteroActual = head
//            punteroAnterior = null
//        }
        if (punteroSiguiente == null){
            punteroActual = punteroActual
        }
        else if (punteroActual == head){
            punteroActual = punteroSiguiente
            punteroAnterior = head
        }
        else {
           punteroActual = punteroSiguiente
           punteroAnterior = punteroAnterior?.siguiente
        }
    }
    fun get(): Pair<Int, String>? {
        return punteroActual?.info
    }
    fun getFinal(): Pair<Int, String>? {
        return punteroFinal?.info
    }
}
//checar los parametros y enviarselo 

//list.insert(Pair(2, "holiwis")) YA     // Creates and inserts a new node after the current pointer
//list.delete()                   // Deletes the current pointer node
//list.prepend(Pair(3, "gato")  YA       // Creates a new node and sets it as the new head
//list.append(Pair(4, "perro")  YA       // Creates a new node and sets it at the end of the list
//list.isEmpty()                YA       // Returns true if the list is empty
//list.toString()               YA       // Returns a String of the values in this format "[(1, hola),(2, adios),(3, cokis)]"
//list.next()                     // Mueve el puntero actual al siguiente nodo de la lista
//list.get()                    YA       // Retorna el valor del nodo actual
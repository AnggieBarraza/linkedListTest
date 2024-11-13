package quick.start

import AnggieLinkedList
import Node
import org.junit.Test
import kotlin.test.assertEquals

class AnggieLinkedListTest {

    @Test
    fun `isEmpty() empty list`() {
        //Arrange
        val list = AnggieLinkedList()

        //Act
        val isEmpty = list.isEmpty()

        //Assert
        assertEquals(isEmpty, true)
    }

    @Test
    fun `isEmpty() non-empty list`() {
        //Arrange
        val list = AnggieLinkedList()
        list.head = Node(Pair(0, ""))

        //Act
        val isEmpty = list.isEmpty()

        //Assert
        assertEquals(isEmpty, false)
    }

    @Test
    fun `insert() add head with insert`() {
        //Arrange
        val list = AnggieLinkedList()
        val value = Pair(4, "inert")

        //Act
        list.insert(info = value)

        //Assert
        assertEquals(list.head?.info, value)
    }

    @Test
    fun `insert() add 2 nodes with insert`() {
        //Arrange
        val list = AnggieLinkedList()
        val value1 = Pair(0, "aa")
        val value2 = Pair(1, "bb")

        //Act
        list.insert(info = value1)
        list.insert(info = value2)

        //Assert
        assertEquals(list.head?.info, value1)
        assertEquals(list.head?.siguiente?.info, value2)
    }

    @Test
    fun `insert() add 3 nodes or more with insert`() {
        //Arrange
        val list = AnggieLinkedList()
        val value1 = Pair(0, "aa")
        val value2 = Pair(1, "bb")
        val value3 = Pair(2, "cc")
        val value4 = Pair(3, "dd")

        //Act
        list.insert(info = value1)
        list.insert(info = value2)
        list.insert(info = value3)
        list.insert(info = value4)

        //Assert
        assertEquals(list.head?.info, value1)
        assertEquals(list.head?.siguiente?.info, value4)
        assertEquals(list.head?.siguiente?.siguiente?.info, value3)
        assertEquals(list.head?.siguiente?.siguiente?.siguiente?.info, value2)
    }

    @Test
    fun `append() add head with append`() {
        //Arrange
        val list = AnggieLinkedList()
        val value = Pair(4, "aa")

        //Act
        list.append(info = value)

        //Assert
        assertEquals(list.head?.info, value)
    }

    @Test
    fun `append() add 2 nodes with append`() {
        //Arrange
        val list = AnggieLinkedList()
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")

        //Act
        list.append(info = value1)
        list.append(info = value2)

        //Assert
        assertEquals(list.head?.info, value1)
        assertEquals(list.head?.siguiente?.info, value2)
    }

    @Test
    fun `append() add 3 nodes or more with append`() {
        //Arrange
        val list = AnggieLinkedList()
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        val value3 = Pair(2, "bb")

        //Act
        list.append(info = value1)
        list.append(info = value2)
        list.append(info = value3)

        //Assert
        assertEquals(list.head?.info, value1)
        assertEquals(list.head?.siguiente?.info, value2)
        assertEquals(list.head?.siguiente?.siguiente?.info, value3)
    }

    @Test
    fun `append() add 3 nodes with append and check what's the current point`() {
        //Arrange
        val list = AnggieLinkedList()
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        val value3 = Pair(2, "bb")

        //Act
        list.append(info = value1)
        list.append(info = value2)
        list.append(info = value3)

        //Assert
        assertEquals(list.punteroActual?.info, value1)
    }

    @Test
    fun `prepend() add head with prepend`() {
        //Arrange
        val list = AnggieLinkedList()
        val value1 = Pair(1, "aa")

        //Act
        list.prepend(info = value1)

        //Assert
        assertEquals(list.head?.info, value1)
    }

    @Test
    fun `prepend() add 2 nodes with prepend`() {
        //Arrange
        val list = AnggieLinkedList()
        val value2 = Pair(1, "aa")
        val value1 = Pair(2, "bb")

        //Act
        list.prepend(info = value2)
        list.prepend(info = value1)

        //Assert
        assertEquals(list.head?.info, value1)
        assertEquals(list.head?.siguiente?.info, value2)
    }

    @Test
    fun `prepend() add 3 nodes with prepend`() {
        //Arrange
        val list = AnggieLinkedList()
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        val value3 = Pair(3, "bb")

        //Act
        list.prepend(info = value3)
        list.prepend(info = value2)
        list.prepend(info = value1)

        //Assert
        assertEquals(list.head?.info, value1)
        assertEquals(list.head?.siguiente?.info, value2)
        assertEquals(list.head?.siguiente?.siguiente?.info, value3)
    }

    @Test
    fun `prepend() add 3 nodes and check what's the current point`() {
        //Arrange
        val list = AnggieLinkedList()
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        val value3 = Pair(3, "bb")

        //Act
        list.prepend(info = value3)
        list.prepend(info = value2)
        list.prepend(info = value1)

        //Assert
        assertEquals(list.punteroActual?.info, value3)
    }

    @Test
    fun `delete() when empty list`() {
        //Arrange
        val list = AnggieLinkedList()
        list.head = null
        list.punteroActual = null
        list.punteroFinal = null
        list.punteroAnterior = null

        //Act
        list.delete()

        //Assert
        assertEquals(list.head, null)
    }

    @Test
    fun `delete() delete when only have head`() {
        //Arrange
        val list = AnggieLinkedList()
        val value1 = Node(Pair(1, "aa"), null)
        list.head = value1
        list.punteroActual = value1
        list.punteroFinal = value1
        list.punteroAnterior = null

        //Act
        list.delete()

        //Assert
        assertEquals(list.head, null)
    }

    @Test
    fun `delete() when current pointer is head`() {
        //Arrange
        val list = AnggieLinkedList()
        val value3 = Node(Pair(3, "bb"))
        val value2 = Node(Pair(2, "bb"), value3)
        val value1 = Node(Pair(1, "aa"), value2)
        list.head = value1
        list.punteroActual = value1
        list.punteroFinal = value3
        list.punteroAnterior = null

        //Act
        list.delete()

        //Assert
        assertEquals(list.head, value2)
    }

    @Test
    fun `delete() delete current pointer node when next node is not null`() {
        //Arrange
        val list = AnggieLinkedList()
        val value3 = Node(Pair(3, "cc"))
        val value2 = Node(Pair(2, "bb"), value3)
        val value1 = Node(Pair(1, "aa"), value2)
        list.head = value1
        list.punteroActual = value2
        list.punteroFinal = value3
        list.punteroAnterior = value1

        //Act
        list.delete()

        //Assert
        assertEquals(list.head?.siguiente, value3)
    }

    @Test
    fun `delete() delete when current pointer node is end pointer`() {
        //Arrange
        val list = AnggieLinkedList()
        val value3 = Node(Pair(3, "bb"))
        val value2 = Node(Pair(2, "bb"), value3)
        val value1 = Node(Pair(1, "aa"), value2)
        list.head = value1
        list.punteroActual = value3
        list.punteroFinal = value3
        list.punteroAnterior = value2

        //Act
        list.delete()

        //Assert
        assertEquals(list.head?.siguiente, value2)
    }

    @Test
    fun `get() get current pointer node with get`() {
        //Arrange
        val list = AnggieLinkedList()
        val value3 = Node(Pair(3, "bb"))
        val value2 = Node(Pair(2, "bb"), value3)
        val value1 = Node(Pair(1, "aa"), value2)
        list.head = value1
        list.punteroActual = value1
        list.punteroFinal = value3
        list.punteroAnterior = null

        //Act
        list.get()

        //Assert
        assertEquals(list.punteroActual, value1)
    }

    @Test
    fun `get() get current pointer 2`() {
        //Arrange
        val list = AnggieLinkedList()
        val value3 = Node(Pair(3, "bb"))
        val value2 = Node(Pair(2, "bb"), value3)
        val value1 = Node(Pair(1, "aa"), value2)
        list.head = value1
        list.punteroActual = value3
        list.punteroFinal = value3
        list.punteroAnterior = null

        //Act
        list.get()

        //Assert
        assertEquals(list.punteroActual, value3)
    }

    @Test
    fun `next() next node is not null`() {
        //Arrange
        val list = AnggieLinkedList()
        val value3 = Node(Pair(3, "bb"))
        val value2 = Node(Pair(2, "bb"), value3)
        val value1 = Node(Pair(1, "aa"), value2)
        list.head = value1
        list.punteroActual = value1
        list.punteroFinal = value3
        list.punteroAnterior = null

        //Act
        list.next()

        //Assert
        assertEquals(list.head?.siguiente, value2)
    }

    @Test
    fun `next() next node is not null 2`() {
        //Arrange
        val list = AnggieLinkedList()
        val value3 = Node(Pair(3, "bb"))
        val value2 = Node(Pair(2, "bb"), value3)
        val value1 = Node(Pair(1, "aa"), value2)
        list.head = value1
        list.punteroActual = value3
        list.punteroFinal = value3
        list.punteroAnterior = value2

        //Act
        list.next()

        //Assert
        assertEquals(list.head?.siguiente?.siguiente, value3)
    }

    @Test
    fun `toString() string list not null`() {
        //Arrange
        val list = AnggieLinkedList()

        //Act
        val toString = list.toString()

        //Assert
        assertEquals(toString, "null")
    }

}
package quick.start
import AnggieLinkedList
import Node
import org.junit.Test
import kotlin.test.assertEquals
import java.lang.reflect.Field

class AnggieLinkedListTest (){

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
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true
        val node = Node(Pair(3, "bb"))
        headField.set(list,node)

        //Act
        val isEmpty = list.isEmpty()

        //Assert
        assertEquals(isEmpty, false)
    }
    @Test
    fun `insert() add one node with insert where head = info`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        val info = Pair(4, "insert")
        list.insert(info = info)

        //Assert
        val head: Node? = headField.get(list) as Node?
        assertEquals(head?.info, info)
    }
    @Test
    fun `insert() add 2 nodes with insert, when head = value1 and second node = value2 should show info from the head and info from de second node `() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        list.insert(info = value1)
        list.insert(info = value2)

        //Assert
        val fieldValue: Node? = headField.get(list) as Node?
        assertEquals(fieldValue?.info, value1)
        assertEquals(fieldValue?.next?.info, value2)
    }

    @Test
    fun `insert() add 3 nodes or more with insert, should show value from the first node, second node, third node and fourth node, `() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        val value1 = Pair(0, "aa")
        val value2 = Pair(1, "bb")
        val value3 = Pair(2, "cc")
        val value4 = Pair(3, "dd")
        list.insert(info = value1)
        list.insert(info = value2)
        list.insert(info = value3)
        list.insert(info = value4)

        //Assert
        val fieldValue: Node? = headField.get(list) as Node?
        assertEquals(fieldValue?.info, value1)
        assertEquals(fieldValue?.next?.info, value4)
        assertEquals(fieldValue?.next?.next?.info, value3)
        assertEquals(fieldValue?.next?.next?.next?.info, value2)
    }
    @Test
    fun `append() add one node with append where head = value`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        val value = Pair(1, "aa")
        list.append(info = value)

        //Assert
        val fieldValue: Node? = headField.get(list) as Node?
        assertEquals(fieldValue?.info, value)
    }
    @Test
    fun `append() add 2 nodes with append where head = value1 and second node = value2`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        list.append(info = value1)
        list.append(info = value2)

        //Assert
        val fieldValue: Node? = headField.get(list) as Node?
        assertEquals(fieldValue?.info, value1)
        assertEquals(fieldValue?.next?.info, value2)
    }
    @Test
    fun `append() add 3 nodes or more with append where head = value1, second node = value2 and third node = value3`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        val value3 = Pair(2, "bb")
        list.append(info = value1)
        list.append(info = value2)
        list.append(info = value3)

        //Assert
        val fieldValue: Node? = headField.get(list) as Node?
        assertEquals(fieldValue?.info, value1)
        assertEquals(fieldValue?.next?.info, value2)
        assertEquals(fieldValue?.next?.next?.info, value3)
    }
    @Test
    fun `append() currentPointer should stay as head node after adding 3 nodes with append`() {
        //Arrange
        val list = AnggieLinkedList()
        val currentPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("currentPointer")
        currentPointerField.isAccessible = true

        //Act
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        val value3 = Pair(3, "cc")
        list.append(info = value1)
        list.append(info = value2)
        list.append(info = value3)

        //Assert
        val currentPointer: Node? = currentPointerField.get(list) as Node?
        assertEquals(currentPointer?.info, value1)
    }

    @Test
    fun `prepend() add one node with prepend where head should be value1`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        val value1 = Pair(1, "aa")
        list.prepend(info = value1)

        //Assert
        val fieldValue: Node? = headField.get(list) as Node?
        assertEquals(fieldValue?.info, value1)
    }

    @Test
    fun `prepend() add two nodes with prepend where head should be value1 and second node should be value2`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        val value2 = Pair(1, "aa")
        val value1 = Pair(2, "bb")
        list.prepend(info = value2)
        list.prepend(info = value1)

        //Assert
        val fieldValue: Node? = headField.get(list) as Node?
        assertEquals(fieldValue?.info, value1)
        assertEquals(fieldValue?.next?.info, value2)
    }

    @Test
    fun `prepend() add three nodes with prepend where head should be value1, second node should be value2 and third node should be value3`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        val value3 = Pair(3, "bb")
        list.prepend(info = value3)
        list.prepend(info = value2)
        list.prepend(info = value1)

        //Assert
        val fieldValue: Node? = headField.get(list) as Node?
        assertEquals(fieldValue?.info, value1)
        assertEquals(fieldValue?.next?.info, value2)
        assertEquals(fieldValue?.next?.next?.info, value3)
    }

    @Test
    fun `prepend() add 3 nodes and check what's the current point`() {
        //Arrange
        val list = AnggieLinkedList()
        val currentPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("currentPointer")
        currentPointerField.isAccessible = true

        //Act
        val value1 = Pair(1, "aa")
        val value2 = Pair(2, "bb")
        val value3 = Pair(3, "bb")
        list.prepend(info = value3)
        list.prepend(info = value2)
        list.prepend(info = value1)

        //Assert
        val currentPointer: Node? = currentPointerField.get(list) as Node?
        assertEquals(currentPointer?.info, value3)
    }

    @Test
    fun `delete() delete when empty list should stay empty`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        //Act
        list.delete()

        //Assert
        val head: Node? = headField.get(list) as Node?
        assertEquals(head, null)

    }

    @Test
    fun `delete() delete when only have one node should result in empty head`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true

        val node = Node(Pair(1, "aa"))
        headField.set(list,node)

        //Act
        list.delete()

        //Assert
        val head: Node? = headField.get(list) as Node?
        assertEquals(head, null)
    }
    @Test
    fun `delete() delete currentPointer when its = to head and there are 2+ nodes, currentPointer should change to second node`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        val currentPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("currentPointer")
        headField.isAccessible = true
        currentPointerField.isAccessible = true

        val node3 = Node(Pair(3, "bb"))
        val node2 = Node(Pair(2, "bb"), node3)
        val node1 = Node(Pair(1, "aa"), node2)
        headField.set(list,node1)
        currentPointerField.set(list,node1)

        //Act
        list.delete()

        //Assert
        val currentPointer: Node? = currentPointerField.get(list) as Node?
        assertEquals(currentPointer, node2)
    }

    @Test
    fun `delete() delete current pointer node when next node is not null`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        val currentPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("currentPointer")
        val previousPointer: Field = AnggieLinkedList::class.java.getDeclaredField("previousPointer")
        val endPointer: Field = AnggieLinkedList::class.java.getDeclaredField("endPointer")

        headField.isAccessible = true
        currentPointerField.isAccessible = true
        previousPointer.isAccessible = true
        endPointer.isAccessible = true

        val node3 = Node(Pair(3, "bb"))
        val node2 = Node(Pair(2, "bb"), node3)
        val node1 = Node(Pair(1, "aa"), node2)
        headField.set(list,node1)
        currentPointerField.set(list,node2)
        endPointer.set(list,node3)
        previousPointer.set(list,node1)

        //Act
        list.delete()

        //Assert
        val currentPointer: Node? = currentPointerField.get(list) as Node?
        assertEquals(currentPointer, node3)
    }

    @Test
    fun `delete() delete when current pointer node is end pointer`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        val currentPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("currentPointer")
        val previousPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("previousPointer")
        val endPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("endPointer")

        endPointerField.isAccessible = true
        previousPointerField.isAccessible = true
        headField.isAccessible = true
        currentPointerField.isAccessible = true

        val node3 = Node(Pair(3, "bb"))
        val node2 = Node(Pair(2, "bb"), node3)
        val node1 = Node(Pair(1, "aa"), node2)
        headField.set(list, node1)
        currentPointerField.set(list,node3)
        endPointerField.set(list, node3)
        previousPointerField.set(list,node2)

        //Act
        list.delete()

        //Assert
        val currentPointer: Node? = currentPointerField.get(list) as Node?
        assertEquals(currentPointer, node2)
    }

    @Test
    fun `get() WITH non-empty list and currentPointer = head SHOULD return info from the head`() {
        //Arrange
        val list = AnggieLinkedList()
        val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
        headField.isAccessible = true
        val currentPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("currentPointer")
        currentPointerField.isAccessible = true
        val node3 = Node(Pair(3, "bb"))
        val node2 = Node(Pair(2, "bb"), node3)
        val node1 = Node(Pair(1, "aa"), node2)
        headField.set(list,node1)
        currentPointerField.set(list,node1)

        //Act
        val info = list.get()

        //Assert
        val head: Node? = headField.get(list) as Node?
        assertEquals(head?.info, info)

    }

    @Test
    fun `get() Whit non-empty list and currentPointer = endPointer SHOULd return info from the endPointer `() {
    //Arrange
    val list = AnggieLinkedList()
    val headField: Field = AnggieLinkedList::class.java.getDeclaredField("head")
    val currentPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("currentPointer")
    val endPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("endPointer")
    headField.isAccessible = true
    currentPointerField.isAccessible = true
    endPointerField.isAccessible = true
    val node3 = Node(Pair(3, "bb"))
    val node2 = Node(Pair(2, "bb"), node3)
    val node1 = Node(Pair(1, "aa"), node2)
    headField.set(list,node1)
    currentPointerField.set(list,node3)
    endPointerField.set(list,node3)

    //Act
    val info = list.get()

    //Assert
    val currentPointer: Node? = currentPointerField.get(list) as Node?
    assertEquals(currentPointer?.info, info)
    }

    @Test
    fun `getNext() when currentPointer its = head and next node is not null should return second node`() {
        //Arrange
        val list = AnggieLinkedList()
        val currentPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("currentPointer")
        currentPointerField.isAccessible = true
        val node3 = Node(Pair(3, "bb"))
        val node2 = Node(Pair(2, "bb"), node3)
        val node1 = Node(Pair(1, "aa"), node2)
        currentPointerField.set(list,node1)

        //Act
        list.getNext()

        //Assert
        val currentPointer: Node? = currentPointerField.get(list) as Node?
        assertEquals(currentPointer, node2)
    }

    @Test
    fun `getNext() when currentPointer its = endPointer should return endPointer`() {
        //Arrange
        val list = AnggieLinkedList()
        val currentPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("currentPointer")
        val endPointerField: Field = AnggieLinkedList::class.java.getDeclaredField("endPointer")

        endPointerField.isAccessible = true

        currentPointerField.isAccessible = true
        val node3 = Node(Pair(3, "bb"))
        val node2 = Node(Pair(2, "bb"), node3)
        val node1 = Node(Pair(1, "aa"), node2)
        currentPointerField.set(list,node3)
        endPointerField.set(list,node3)


        //Act
        list.getNext()

        //Assert
        val currentPointer: Node? = currentPointerField.get(list) as Node?
        assertEquals(currentPointer, node3)
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
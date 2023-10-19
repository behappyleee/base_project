package data_structure

import java.util.LinkedList

fun main() {

    // LinkedList - A Linked List is a linear data structure, in which the elements are not stored
    // at contiguous memory locations. It consist of nodes where  each node contains a data field and a link
    // to the next node in the list.

    var linkedList: LinkedList<Int> = LinkedList<Int>();

    linkedList.add(7);
    linkedList.add(1);
    linkedList.add(5);
    linkedList.add(3);

    for (i in linkedList) {
        println(i);
    }

}
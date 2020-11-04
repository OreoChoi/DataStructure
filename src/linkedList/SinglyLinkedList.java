package linkedList;

/**
 * Singly Linked List
 * */
public class SinglyLinkedList<T> {
    private Node head = null;

    /**
     * preNode 다음에 새로운 노드를 insert합니다.
     * */
    public void insert(Node preNode, T data) {
        preNode.link = new Node<>(data, preNode.link);
    }

    /**
     * 마지막 노드 다음에 새로운 노드를 insert합니다.
     * */
    public void insert(T data) {
        Node<T> newNode = new Node<>(data, null);

        if (head == null) {
            this.head = newNode;
        } else {
            Node tempNode = head;

            while (tempNode.link != null) {
                tempNode = tempNode.link;
            }

            tempNode.link = newNode;
        }
    }

    /**
     * 노드를 삭제 합니다.
     * */
    public void delete(T data) {
        Node preNode = head;
        Node tempNode = head.link;

        if (data.equals(preNode.getData())) {
            head = preNode.link;
            preNode.link = null;
        } else {
            while (tempNode != null) {
                if (data.equals(tempNode.getData())) {
                    if (tempNode.link == null) {
                        preNode.link = null;
                    } else {
                        preNode.link = tempNode.link;
                        tempNode.link = null;
                    }
                    break;
                } else {
                    preNode = tempNode;
                    tempNode = tempNode.link;
                }
            }
        }
    }

    /**
     * 가장 마지막 노드를 삭제합니다.
     * */
    public void lastDelete() {
        Node preNode;
        Node tempNode;

        if (head == null) {
            return;
        }

        if (head.link == null) {
            head = null;
        } else {
            preNode = head;
            tempNode = head.link;

            while (tempNode.link != null) {
                preNode = tempNode;
                tempNode = tempNode.link;
            }

            preNode.link = null;
        }
    }

    /**
     * 원하는 노드를 찾습니다.
     * */
    public Node search(T data) {
        Node tempNode = this.head;

        while (tempNode != null) {
            if (data == tempNode.getData()) {
                return tempNode;
            } else {
                tempNode = tempNode.link;
            }
        }

        return tempNode;
    }

    /**
     * 현재 입력된 노드들을 순서대로 출력합니다.
     * */
    public void print() {
        Node tempNode = this.head;

        while (tempNode != null) {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.link;
        }
    }
}

/**
 * Node class
 * */
class Node<T> {
    private T data;     //데이터
    public Node link;   //다음 노드

    public Node(T data, Node link) {
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }
}
class Node {
    int key;
    int value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class hashmap {

    private int size = 10;
    private Node[] table;

    public hashmap() {
        table = new Node[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        if (head == null) {
            table[index] = new Node(key, value);
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            if (current.next == null)
                break;
            current = current.next;
        }
        current.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1; 
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

public class CustomHashMap {
    public static void main(String[] args) {

        hashmap map = new hashmap();

        map.put(1, 10);
        map.put(11, 20);   
        map.put(2, 30);

        System.out.println(map.get(1));    
        System.out.println(map.get(11));   

        map.remove(1);
        System.out.println(map.get(1));    
    }
}

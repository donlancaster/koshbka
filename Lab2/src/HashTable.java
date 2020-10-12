public class HashTable {
    private LinkedList[] hashArray;
    private int size;

    public int getSize() {
        return size;
    }

    public HashTable(int size) {
        this.size = size;
        this.hashArray = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new LinkedList();
        }
    }

    public int hashFunction(int value) {
        return value % size;
    }

    public void add(Node node) {
        int hashKey = hashFunction(node.getNum());
        hashArray[hashKey].add(node);
    }

    public void delete(String word) {
        int value = toValue(word);
        int hashKey = hashFunction(value);
        hashArray[hashKey].delete(value);
    }

    public Node find(String word) {
        int value = toValue(word);
        int hashKey = hashFunction(value);
        Node node = hashArray[hashKey].find(value);
        return node;
    }

    public int toValue(String word) {
        word = word.trim();
        int value = 0;
        for (int i = 0; i < word.length(); i++) {
            value += word.charAt(i);
        }
        return value;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.printf("\t%d : ", i);
            hashArray[i].print();
            System.out.println();
        }
    }

}
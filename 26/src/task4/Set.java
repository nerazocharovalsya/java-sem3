package task4;

public class Set {
    int realSize;
    int currentSize;

    Element[] table;

    private Integer hashtabHash(int iKey){
        return iKey % currentSize;
    }

    public void hashtabInit(){
        realSize = 0;
        currentSize = 8;
        table = new Element[currentSize];
    }

    public void hashtabAdd(int key, String value){
        int iPlace = hashtabHash(key);

        realSize++;
        if (realSize > currentSize * 0.75) hashtabResize(currentSize * 2);

        if (table[iPlace] == null) table[iPlace] = new Element(key,value);
        else {
            Element tmp = table[iPlace];
            while (tmp.next != null) tmp = tmp.next;
            tmp.addNext(new Element(key,value));
        }

    }

    public void hashtabDelete(int key){
        realSize--;

        int iPlace = hashtabHash(key);

        if(table[iPlace].Key == key ) table[iPlace] = (table[iPlace].next == null)  ? null : table[iPlace].next;
        else if (table[iPlace] != null){
            Element tmp = table[iPlace];
            while (tmp.next != null && tmp.next.Key != key) tmp = tmp.next;
            tmp.next = null;
        }

    }

    public Element hashtabLookUp(int key){
        Element res = table[hashtabHash(key)];
        if (res == null) return null;
        else{
            if (res.Key == key) return res;
            else {
                while (res != null && res.Key != key) res = res.next;
                return res;
            }
        }
    }

    private void hashtabResize(int newSize){
        Element[] newTable = new Element[newSize];

        currentSize = newSize;

        for(Element elem : table){
            if (elem == null) continue;
            int iPlace = hashtabHash(elem.Key);
            if (newTable[iPlace] == null) newTable[iPlace] = elem;
            else {
                Element tmp = newTable[iPlace];
                while (tmp.next != null) tmp = tmp.next;
                tmp.addNext(elem);
            }
        }

        table = newTable;
    }



    public static void main(String[] args){
        Set tab = new Set();
        tab.hashtabInit();
        tab.hashtabAdd(10,"a");
        tab.hashtabAdd(15,"b");
        tab.hashtabAdd(8,"c");
        tab.hashtabAdd(3,"d");
        tab.hashtabAdd(16,"e");
        tab.hashtabAdd(2,"f");
        tab.hashtabAdd(4,"g");
        tab.hashtabAdd(1,"h");
        tab.hashtabAdd(25,"i");
        tab.hashtabAdd(5,"j");
        System.out.println(tab.hashtabLookUp(10));
    }
}
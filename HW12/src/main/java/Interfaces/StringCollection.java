package Interfaces;

public interface StringCollection {
    String get(int index);

//    boolean add(String str);
    void add(String str);

    boolean add(int index, String str);

    boolean delete(String str);

    boolean contains(String str);

    boolean equals(StringCollection collection);

    boolean clear();

    int size();
}

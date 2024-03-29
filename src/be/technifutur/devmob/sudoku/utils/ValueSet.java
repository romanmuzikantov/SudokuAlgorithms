package be.technifutur.devmob.sudoku.utils;

import java.util.Iterator;

public class ValueSet implements Iterable<Integer> {
    private int data;
    private int size;

    public ValueSet(int size) {
        this.data = 0;
        this.size = size;
    }

    public boolean isEmpty() {
        return this.data == 0;
    }

    public boolean add(char val) {
        int intVal = Character.getNumericValue(val) - 1;
        boolean result = false;
        if (!contains(val)) {
            data |= 1 << intVal;
            result = true;
        }
        return result;
    }

    public boolean contains(char val) {
        int intVal = Character.getNumericValue(val) - 1;
        boolean result = false;
        if ((data >> intVal & 1) == 1) {
            result = true;
        }
        return result;
    }

    public boolean delete(char val) {
        int intVal = Character.getNumericValue(val) - 1;
        boolean result = false;
        if (contains(val)) {
            data ^= 1 << intVal;
            result = true;
        }
        return result;
    }

    public int size() {
        return Integer.bitCount(data);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ValueSetIterator();
    }

    private class ValueSetIterator implements Iterator<Integer> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            boolean result = true;
            if(Integer.bitCount(data >>> position) == 0) result = false;
            return result;
        }

        @Override
        public Integer next() {
            if(hasNext()) {
                for(int i = position; i < size; i++) {
                    if((data >>> i & 1) == 1) {
                        position = ++i;
                        return position;
                    }
                }
            }
            return null;
        }
    }
}

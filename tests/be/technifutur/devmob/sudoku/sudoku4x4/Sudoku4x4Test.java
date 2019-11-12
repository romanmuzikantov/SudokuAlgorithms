package be.technifutur.devmob.sudoku.sudoku4x4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sudoku4x4Test {

    /*
        Testing if creating a new instance of Sudoku4x4 creates an array full of Empty cases
     */
    @Test
    void testValuesEmptyAfterCreatingNewSudoku4x4Instance() {
        Sudoku4x4 s = new Sudoku4x4();
        char[] values = s.getValues();
        for(char c : values) {
            assertTrue(c == Sudoku4x4.EMPTY);
        }
    }

    /*
        Testing if adding a new value that is correct at a given Position4x4 correctly adds it to the values array
     */
    @Test
    void testAddingCorrectValueAtPositionAddsValueToArray() {
        Sudoku4x4 s = new Sudoku4x4();
        boolean isAdded = s.add(new Position4x4(5), '1');
        assertTrue(isAdded);
        assertEquals('1', s.getValues()[5]);
    }

    /*
        Testing if adding a new value that is not correct at a given Position4x4 doesn't add it to the values array
     */
    @Test
    void testAddingNotCorrectValueAtPositionDoesNotAddValueToArray() {
        Sudoku4x4 s = new Sudoku4x4();
        boolean isAdded = s.add(new Position4x4(5), 'z');
        assertFalse(isAdded);
        assertEquals(Sudoku4x4.EMPTY, s.getValues()[5]);
    }

    /*
        Testing if getting the value at a given Position returns the correct value
     */
    @Test
    void testGetValueReturnsTheCorrectValue() {
        Sudoku4x4 s = new Sudoku4x4();
        Position4x4 pos = new Position4x4(10);
        s.add(pos, '3');
        assertEquals('3', s.get(pos));
    }

    /*
        Testing if isComplete() returns false when the sudoku is not full yet
     */
    @Test
    void testIsCompleteReturnsFalseWhenTheSudokuIsNotFull() {
        Sudoku4x4 s = new Sudoku4x4();
        s.add(new Position4x4(10), '2');
        assertFalse(s.isComplete());
    }

    /*
        Testing if isComplete() returns true when the sudoky is full
     */
    @Test
    void testIsCompleteReturnsTrueWhenTheSudokuIsFull() {
        Sudoku4x4 s = new Sudoku4x4();
        for(int i = 0; i < 16; i++) {
            s.add(new Position4x4(i), '1');
        }
        assertTrue(s.isComplete());
    }

    /*
        Testing if delete() deletes the value at the given position and sets it back to an empty value
     */
    @Test
    void testDeleteSetsBackValueToEmpty() {
        Sudoku4x4 s = new Sudoku4x4();
        Position4x4 p = new Position4x4(9);
        s.add(p, '2');
        assertEquals('2', s.get(p), String.format("Should get 2 but got %s", s.get(p)));
        s.delete(p);
        assertEquals(Sudoku4x4.EMPTY, s.get(p), String.format("Should get empty but got %s", s.get(p)));
    }

    /*
        Testing if delete() on an empty value does not change the value
     */
    @Test
    void testDeleteDoesNotChangeEmptyValue() {
        Sudoku4x4 s = new Sudoku4x4();
        Position4x4 p = new Position4x4(2);
        assertEquals(Sudoku4x4.EMPTY, s.get(p), String.format("Should be empty but got %s", s.get(p)));
        s.delete(p);
        assertEquals(Sudoku4x4.EMPTY, s.get(p), String.format("Should be empty but got %s", s.get(p)));
    }
}
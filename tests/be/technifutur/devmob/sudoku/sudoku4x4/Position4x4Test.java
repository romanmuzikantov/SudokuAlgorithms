package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.PositionInvalidException;
import be.technifutur.devmob.sudoku.SudokuException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Position4x4Test {

    /*
        Test N°1 : Testing if getPos() returns the position given to the constructor
     */
    @Test
    void testGetPosFromOneVariableConstructor() {
        Position4x4 s = new Position4x4(12);
        assertEquals(12, s.getPos());
    }


    /*
        Test N°2 : Testing if row and col given to constructor are correctly translated to one only value
     */
    @Test
    void testGetPosFromTwoVariablesConstructor() {
        Position4x4 s1 = new Position4x4(2,0);
        Position4x4 s2 = new Position4x4(3,3);
        Position4x4 s3 = new Position4x4(2,2);
        assertEquals(2, s1.getPos(), String.format("Col 2 Row 0 should give Pos 2 but got %d", s1.getPos()));
        assertEquals(15, s2.getPos(), String.format("Col 3 Row 3 should give Pos 15 but got %d", s2.getPos()));
        assertEquals(10, s3.getPos(), String.format("Col 2 Row 2 should give Pos 10 but got %d", s3.getPos()));
    }

    /*
        Test N°3 : Testing if getCol() returns the correct column from the row/col given to the constructor
     */
    @Test
    void testGetColFromTwoVariableConstructor() {
        Position4x4 s = new Position4x4(2, 3);
        assertEquals(2, s.getCol(), String.format("Col 2 Row 3 should give Col 2 but got %d", s.getCol()));
    }

    /*
        Test N°4 : Testing if getRow() returns the correct row from the row/col given to the constructor
     */
    @Test
    void testGetRowFromTwoVariableConstructor() {
        Position4x4 s = new Position4x4(2, 3);
        assertEquals(3, s.getRow(), String.format("Col 2 Row 3 should give Row 3 but got %d", s.getRow()));
    }

    /*
        Test N°5 : Testing if getRow() returns the correct column from the pos given to the constructor
     */
    @Test
    void testGetColFromOneVariableConstructor() {
        Position4x4 s = new Position4x4(9);
        assertEquals(1, s.getCol(), String.format("Pos 9 should give Col 1 but got %d", s.getCol()));
    }

    /*
        Test N°6 : Testing if getCol() returns the correct column from the pos given to the constructor
     */
    @Test
    void testGetRowFromOneVariableConstructor() {
        Position4x4 s = new Position4x4(9);
        assertEquals(2, s.getRow(), String.format("Pos 9 should give Row 2 but got %d", s.getCol()));
    }

    /*
        Test N°7 : Testing if getSector() returns the correct sector
     */
    @Test
    void testGetSector() {
        Position4x4 s1 = new Position4x4(9);
        Position4x4 s2 = new Position4x4(6);
        Position4x4 s3 = new Position4x4(4);
        Position4x4 s4 = new Position4x4(15);
        assertEquals(2, s1.getSector(), String.format("Pos 9 should give Sector 2 but got %d", s1.getSector()));
        assertEquals(1, s2.getSector(), String.format("Pos 6 should give Sector 1 but got %d", s2.getSector()));
        assertEquals(0, s3.getSector(), String.format("Pos 4 should give Sector 0 but got %d", s3.getSector()));
        assertEquals(3, s4.getSector(), String.format("Pos 15 should give Sector 3 but got %d", s4.getSector()));
    }

    /*
        Test N°8 : Testing if getRowSector() returns the correct row in the form of a sector
     */
    @Test
    void testGetSectorRow() {
        Position4x4 s1 = new Position4x4(9);
        Position4x4 s2 = new Position4x4(6);
        Position4x4 s3 = new Position4x4(14);
        assertEquals(1, s1.getRowSector(), String.format("Pos 9 should give Sector Row 1 but got %d", s1.getRowSector()));
        assertEquals(0, s2.getRowSector(), String.format("Pos 6 should give Sector Row 0 but got %d", s2.getRowSector()));
        assertEquals(1, s3.getRowSector(), String.format("Pos 14 should give Sector Row 1 but got %d", s3.getRowSector()));
    }

    /*
        Test N°9 : Testing if getColSector() returns the correct col in the form of a sector
     */
    @Test
    void testGetSectorCol() {
        Position4x4 s1 = new Position4x4(9);
        Position4x4 s2 = new Position4x4(6);
        Position4x4 s3 = new Position4x4(14);
        assertEquals(0, s1.getColSector(), String.format("Pos 9 should give Sector Col 0 but got %d", s1.getColSector()));
        assertEquals(1, s2.getColSector(), String.format("Pos 6 should give Sector Col 1 but got %d", s2.getColSector()));
        assertEquals(1, s3.getColSector(), String.format("Pos 14 should give Sector Col 1 but got %d", s3.getColSector()));
    }

    /*
        Test N°10 : Testing if isValid() returns false when giving a position out of the limits
     */
    @Test
    void testIsValidReturnsFalseWhenOutOfLimits() throws SudokuException {
        assertThrows(PositionInvalidException.class, () -> Position4x4.isValid(-1));
        assertThrows(PositionInvalidException.class, () -> Position4x4.isValid(16));
        assertThrows(PositionInvalidException.class, () -> Position4x4.isValid(35));
        assertThrows(PositionInvalidException.class, () -> Position4x4.isValid(-1, 2));
        assertThrows(PositionInvalidException.class, () -> Position4x4.isValid(2, -1));
    }

    /*
        Test N°11 : Testing if isValid() returns true when giving a valid position
     */
    @Test
    void testIsValidReturnsTrueWithValidPosition() throws SudokuException {
        assertTrue(Position4x4.isValid(0));
        assertTrue(Position4x4.isValid(15));
        assertTrue(Position4x4.isValid(5));
        assertTrue(Position4x4.isValid(0, 3));
    }
}
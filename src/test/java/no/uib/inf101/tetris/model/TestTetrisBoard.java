package no.uib.inf101.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import no.uib.inf101.grid.CellPosition;



public class TestTetrisBoard {
    @Test
    public void testPrettyString() {
    TetrisBoard board = new TetrisBoard(3, 4);
    board.set(new CellPosition(0, 0), 'g');
    board.set(new CellPosition(0, 3), 'y');
    board.set(new CellPosition(2, 0), 'r');
    board.set(new CellPosition(2, 3), 'b');
    String expected = String.join("\n", new String[] {
        "g--y",
        "----",
        "r--b"
    });
    assertEquals(expected, board.prettyString());
    }


    @Test
public void testRemoveFullRows() {
  // Tester at fulle rader fjernes i brettet:
  // -T
  // TT
  // LT
  // L-
  // LL

  TetrisBoard board = new TetrisBoard(5, 2);
  board.set(new CellPosition(0, 1), 'T');
  board.set(new CellPosition(1, 0), 'T');
  board.set(new CellPosition(1, 1), 'T');
  board.set(new CellPosition(2, 1), 'T');
  board.set(new CellPosition(4, 0), 'L');
  board.set(new CellPosition(4, 1), 'L');
  board.set(new CellPosition(3, 0), 'L');
  board.set(new CellPosition(2, 0), 'L');

  assertEquals(3, board.removeFullRows());

  String expected = String.join("\n", new String[] {
    "--",
    "--",
    "--",
    "-T",
    "L-"
  });
  assertEquals(expected, board.prettyString());
}


/**
 * 
 * @param stringBoard takes in a board made of string
 * @return a TetrisBoard
 */
private TetrisBoard getTetrisBoardWithContent(String[] stringBoard){

  int rows = stringBoard.length;
  int cols = stringBoard[1].length();
  TetrisBoard board = new TetrisBoard(rows, cols);

  for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
          char c = stringBoard[i].charAt(j);
          board.set(new CellPosition(i, j), (c));
      }
  }
  return board;
}  

  @Test
  public void testRemoveFullRowsAndgetTetrisBoardWithContent() {
    TetrisBoard board = getTetrisBoardWithContent(new String[] {
      "-T",
      "TT",
      "LT",
      "L-",
      "LL"
    });
    assertEquals(3, board.removeFullRows());
    String expected = String.join("\n", new String[] {
      "--",
      "--",
      "--",
      "-T",
      "L-"
    });
    assertEquals(expected, board.prettyString());
  }

  @Test
  public void testRemoveFullRowsRemoveBot() {
    TetrisBoard board = getTetrisBoardWithContent(new String[] {
      "-T",
      "TT",
      "-T",
      "LL",
      "L-"
    });
    assertEquals(2, board.removeFullRows());
    String expected = String.join("\n", new String[] {
      "--",
      "--",
      "-T",
      "-T",
      "L-"
    });
    assertEquals(expected, board.prettyString());
  }


  @Test
  public void testRemoveFullRowsRemoveTop() {
    TetrisBoard board = getTetrisBoardWithContent(new String[] {
      "TT",
      "T-",
      "TT",
      "-L",
      "L-"
    });
    assertEquals(2, board.removeFullRows());
    String expected = String.join("\n", new String[] {
      "--",
      "--",
      "T-",
      "-L",
      "L-"
    });
    assertEquals(expected, board.prettyString());
  }
  @Test
  public void testRemoveFullRows4x4() {
    TetrisBoard board = getTetrisBoardWithContent(new String[] {
      "TTTT",
      "TTT-",
      "TT-L",
      "LLLL",
      "L--L"
    });
    assertEquals(2, board.removeFullRows());
    String expected = String.join("\n", new String[] {
      "----",
      "----",
      "TTT-",
      "TT-L",
      "L--L"
    });
    assertEquals(expected, board.prettyString());
  }
}

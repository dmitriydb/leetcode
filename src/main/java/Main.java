import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

  static final PrintWriter out = new PrintWriter(System.out);
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    List<String> lines = readLines();
    GameField field = GameField.from(lines);
    field.firstFilledRow().ifPresent(Main::processAnswer);
    field.firstFilledColumn().ifPresent(Main::processAnswer);
    field.filledDiagonal().ifPresent(Main::processAnswer);
    out.println("Draw");
    out.flush();
  }

  private static List<String> readLines() {
    List<String> lines = new ArrayList<>();
    lines.add(in.nextLine());
    lines.add(in.nextLine());
    lines.add(in.nextLine());
    return lines;
  }

  private static void processAnswer(Character answer) {
    if (answer == 'X') {
      out.println("Win");
    } else {
      out.println("Lose");
    }
    out.flush();
    System.exit(0);
  }

  private static class GameField {

    private final char[][] chars;

    public GameField(char[][] chars) {
      this.chars = chars;
    }

    public static GameField from(List<String> lines) {
      char[][] chars = new char[3][3];
      chars[0] = lines.get(0).toCharArray();
      chars[1] = lines.get(1).toCharArray();
      chars[2] = lines.get(2).toCharArray();
      return new GameField(chars);
    }

    private Optional<Character> runPredicate(Function<Integer, Boolean> predicate, boolean row) {
      for (int i = 0; i < chars.length; i++) {
        if (predicate.apply(i)) {
          if (row) {
            return Optional.of(chars[i][0]);
          } else {
            return Optional.of(chars[0][i]);
          }
        }
      }
      return Optional.empty();
    }

    private Optional<Character> filledDiagonal() {
      if (mainDiagonalIsFilled() || auxDiagonalIsFilled()) {
        return Optional.of(chars[1][1]);
      }
      return Optional.empty();
    }

    private boolean auxDiagonalIsFilled() {
      return chars[0][2] != '.' && chars[1][1] != '.' && chars[2][0] != '.' &&
          chars[0][2] == chars[1][1] && chars[1][1] == chars[2][0];
    }

    private boolean mainDiagonalIsFilled() {
      return chars[0][0] != '.' && chars[1][1] != '.' && chars[2][2] != '.' &&
          chars[0][0] == chars[1][1] && chars[1][1] == chars[2][2];
    }

    private Optional<Character> firstFilledRow() {
      return runPredicate(this::rowIsFilled, true);
    }

    private Optional<Character> firstFilledColumn() {
      return runPredicate(this::columnIsFilled, false);
    }

    private boolean rowIsFilled(int i) {
      return chars[i][0] != '.' && chars[i][1] != '.' && chars[i][2] != '.' &&
          chars[i][0] == chars[i][1] && chars[i][1] == chars[i][2];
    }

    private boolean columnIsFilled(int i) {
      return  chars[0][i] != '.' && chars[1][i] != '.' && chars[2][i] != '.' &&
          chars[0][i] == chars[1][i] && chars[1][i] == chars[2][i];
    }
  }
}
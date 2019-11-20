package be.technifutur.devmob.sudoku.sudoku9x9;

import be.technifutur.devmob.sudoku.Cellule;
import be.technifutur.devmob.sudoku.sudoku_interfaces.VisualSudoku;
import be.technifutur.devmob.sudoku.utils.User;
import be.technifutur.devmob.sudoku.utils.UserConsole;


public class Sudoku9x9Vue {
    private StringBuilder sb;
    private VisualSudoku model;
    private User user;

    public Sudoku9x9Vue(VisualSudoku model) {
        this.model = model;
        this.user = new UserConsole();
        update();
    }

    public void update() {
        sb = new StringBuilder();
        sb.append(              "+---------+---------+---------+\n");
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", model.get(new Position9x9(0)), model.get(new Position9x9(1)), model.get(new Position9x9(2)), model.get(new Position9x9(3)), model.get(new Position9x9(4)), model.get(new Position9x9(5)), model.get(new Position9x9(6)), model.get(new Position9x9(7)), model.get(new Position9x9(8))));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", model.get(new Position9x9(9)), model.get(new Position9x9(10)), model.get(new Position9x9(11)), model.get(new Position9x9(12)), model.get(new Position9x9(13)), model.get(new Position9x9(14)), model.get(new Position9x9(15)), model.get(new Position9x9(16)), model.get(new Position9x9(17))));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", model.get(new Position9x9(18)), model.get(new Position9x9(19)), model.get(new Position9x9(20)), model.get(new Position9x9(21)), model.get(new Position9x9(22)), model.get(new Position9x9(23)), model.get(new Position9x9(24)), model.get(new Position9x9(25)), model.get(new Position9x9(26))));
        sb.append(              "+---------+---------+---------+\n");
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", model.get(new Position9x9(27)), model.get(new Position9x9(28)), model.get(new Position9x9(29)), model.get(new Position9x9(30)), model.get(new Position9x9(31)), model.get(new Position9x9(32)), model.get(new Position9x9(33)), model.get(new Position9x9(34)), model.get(new Position9x9(35))));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", model.get(new Position9x9(36)), model.get(new Position9x9(37)), model.get(new Position9x9(38)), model.get(new Position9x9(39)), model.get(new Position9x9(40)), model.get(new Position9x9(41)), model.get(new Position9x9(42)), model.get(new Position9x9(43)), model.get(new Position9x9(44))));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", model.get(new Position9x9(45)), model.get(new Position9x9(46)), model.get(new Position9x9(47)), model.get(new Position9x9(48)), model.get(new Position9x9(49)), model.get(new Position9x9(50)), model.get(new Position9x9(51)), model.get(new Position9x9(52)), model.get(new Position9x9(53))));
        sb.append(              "+---------+---------+---------+\n");
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", model.get(new Position9x9(54)), model.get(new Position9x9(55)), model.get(new Position9x9(56)), model.get(new Position9x9(57)), model.get(new Position9x9(58)), model.get(new Position9x9(59)), model.get(new Position9x9(60)), model.get(new Position9x9(61)), model.get(new Position9x9(62))));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", model.get(new Position9x9(63)), model.get(new Position9x9(64)), model.get(new Position9x9(65)), model.get(new Position9x9(66)), model.get(new Position9x9(67)), model.get(new Position9x9(68)), model.get(new Position9x9(69)), model.get(new Position9x9(70)), model.get(new Position9x9(71))));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", model.get(new Position9x9(72)), model.get(new Position9x9(73)), model.get(new Position9x9(74)), model.get(new Position9x9(75)), model.get(new Position9x9(76)), model.get(new Position9x9(77)), model.get(new Position9x9(78)), model.get(new Position9x9(79)), model.get(new Position9x9(80))));
        sb.append(              "+---------+---------+---------+\n");
    }

    public void showSudoku() {
        System.out.println(sb.toString());
    }

    public void separator() {
        System.out.println("---------------------");
    }

    public void show(String message) {
        user.show(message);
    }

    public String prompt(String message) {
        return user.prompt(message);
    }

    public void setUser(User user) {
        this.user = user;
    }
}

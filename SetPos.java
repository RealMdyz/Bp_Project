import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SetPos {
    Application application;
    public static String path = "D:\\Sharif univercity of technology\\Semester one\\bp\\project\\Chess6-6\\src\\Chess.txt";

    public SetPos(Application application) throws IOException {
        this.application = application;
    }
    public char sFirstPos() throws IOException{
        File file = new File(path);
        PrintWriter p;
        Scanner scanner;
        p = new PrintWriter(file);
        scanner = new Scanner(file);
        p.println("w");
        // Pawn = p,
        // Bishop = b,
        // Rock = r,
        // King = g,
        // Queen = q,
        // knight = t;
        application.setCellProperties(1, 'f', PieceName.WHITE_BISHOP, null, Color.WHITE);
        p.println("1fbw");
        application.setCellProperties(2, 'f', PieceName.WHITE_BISHOP, null, Color.WHITE);
        p.println("2fbw");
        application.setCellProperties(3, 'f', PieceName.WHITE_BISHOP, null, Color.WHITE);
        p.println("3fbw");
        application.setCellProperties(1, 'b', PieceName.WHITE_PAWN, null, Color.WHITE);
        p.println("1bpw");
        application.setCellProperties(1, 'c', PieceName.WHITE_ROCK, null, Color.WHITE);
        p.println("1crw");
        application.setCellProperties(1, 'd', PieceName.WHITE_KNIGHT, null, Color.WHITE);
        p.println("1dtw");
        application.setCellProperties(1, 'e', PieceName.WHITE_QUEEN, null, Color.WHITE);
        p.println("1eqw");
        application.setCellProperties(2, 'c', PieceName.WHITE_PAWN, null, Color.WHITE);
        p.println("2cpw");
        application.setCellProperties(3, 'd', PieceName.WHITE_PAWN, null, Color.WHITE);
        p.println("3dpw");
        application.setCellProperties(4, 'e', PieceName.WHITE_PAWN, null, Color.WHITE);
        p.println("4epw");
        application.setCellProperties(5, 'f', PieceName.WHITE_PAWN, null, Color.WHITE);
        p.println("5fpw");
        application.setCellProperties(4, 'g', PieceName.WHITE_PAWN, null, Color.WHITE);
        p.println("4gpw");
        application.setCellProperties(3, 'h', PieceName.WHITE_PAWN, null, Color.WHITE);
        p.println("3hpw");
        application.setCellProperties(2, 'i', PieceName.WHITE_PAWN, null, Color.WHITE);
        p.println("2ipw");
        application.setCellProperties(1, 'k', PieceName.WHITE_PAWN, null, Color.WHITE);
        p.println("1kpw");
        application.setCellProperties(1, 'g', PieceName.WHITE_KING, null, Color.WHITE);
        p.println("1ggw");
        application.setCellProperties(1, 'h', PieceName.WHITE_KNIGHT, null, Color.WHITE);
        p.println("1htw");
        application.setCellProperties(1, 'i', PieceName.WHITE_ROCK, null, Color.WHITE);
        p.println("1irw");


        application.setCellProperties(9, 'f', PieceName.BLACK_BISHOP, null, Color.BLACK);
        p.println("9fbb");
        application.setCellProperties(10, 'f', PieceName.BLACK_BISHOP, null, Color.BLACK);
        p.println("10fbb");
        application.setCellProperties(11, 'f', PieceName.BLACK_BISHOP, null, Color.BLACK);
        p.println("11fbb");
        application.setCellProperties(7, 'b', PieceName.BLACK_PAWN, null, Color.BLACK);
        p.println("7bpb");
        application.setCellProperties(8, 'c', PieceName.BLACK_ROCK, null, Color.BLACK);
        p.println("8crb");
        application.setCellProperties(9, 'd', PieceName.BLACK_KNIGHT, null, Color.BLACK);
        p.println("9dtb");
        application.setCellProperties(10, 'e', PieceName.BLACK_QUEEN, null, Color.BLACK);
        p.println("10eqb");
        application.setCellProperties(7, 'c', PieceName.BLACK_PAWN, null, Color.BLACK);
        p.println("7cpb");
        application.setCellProperties(7, 'd', PieceName.BLACK_PAWN, null, Color.BLACK);
        p.println("7dpb");
        application.setCellProperties(7, 'e', PieceName.BLACK_PAWN, null, Color.BLACK);
        p.println("7epb");
        application.setCellProperties(7, 'f', PieceName.BLACK_PAWN, null, Color.BLACK);
        p.println("7fpb");
        application.setCellProperties(7, 'g', PieceName.BLACK_PAWN, null, Color.BLACK);
        p.println("7gpb");
        application.setCellProperties(7, 'h', PieceName.BLACK_PAWN, null, Color.BLACK);
        p.println("7hpb");
        application.setCellProperties(7, 'i', PieceName.BLACK_PAWN, null, Color.BLACK);
        p.println("7ipb");
        application.setCellProperties(7, 'k', PieceName.BLACK_PAWN, null, Color.BLACK);
        p.println("7kpb");
        application.setCellProperties(10, 'g', PieceName.BLACK_KING, null, Color.BLACK);
        p.println("10ggb");
        application.setCellProperties(9, 'h', PieceName.BLACK_KNIGHT, null, Color.BLACK);
        p.println("9htb");
        application.setCellProperties(8, 'i', PieceName.BLACK_ROCK, null, Color.BLACK);
        p.println("8irb");
        p.flush();
        p.close();
        return  'w';
    }
    public void setPos(String data){
        String pieceName = "";
        int row;
        char col;
        int i = 0;
        row = data.charAt(i) - '0';
        i += 1;
        if(data.charAt(i) - '0' >= 0 && data.charAt(i) - '0' <= 9){
            row *= 10;
            row += (data.charAt(i) - '0');
            i += 1;
        }
        col = data.charAt(i);
        i += 1;
        // Pawn = p,
        // Bishop = b,
        // Rock = r,
        // King = g,
        // Queen = q,
        // knight = t;
        char color = data.charAt(i + 1);
        if(data.charAt(i) == 'p' && color == 'w'){
            pieceName = "\u2659";
        }
        else if(data.charAt(i) == 'b' && color == 'w'){
            pieceName = "\u2657";
        }
        else if(data.charAt(i) == 'r' && color == 'w'){
            pieceName = "\u2656";
        }
        else if(data.charAt(i) == 'g' && color == 'w'){
            pieceName = "\u2654";
        }
        else if(data.charAt(i) == 'q' && color == 'w'){
            pieceName = "\u2655";
        }
        else if(data.charAt(i) == 't' && color == 'w'){
            pieceName = "\u2658";
        }
        else if(data.charAt(i) == 'p' && color == 'b'){
            pieceName =  "\u265F";
        }
        else if(data.charAt(i) == 'b' && color == 'b'){
            pieceName =  "\u265D";
        }
        else if(data.charAt(i) == 'r' && color == 'b'){
            pieceName = "\u265C";
        }
        else if(data.charAt(i) == 'g' && color == 'b'){
            pieceName = "\u265A";
        }
        else if(data.charAt(i) == 'q' && color == 'b'){
            pieceName = "\u265B";
        }
        else if(data.charAt(i) == 't' && color == 'b'){
            pieceName = "\u265E";
        }
        if(color == 'w')
            application.setCellProperties(row, col, pieceName, null, Color.WHITE);
        else
            application.setCellProperties(row, col, pieceName, null, Color.BLACK);
        return;

    }
    public char setPos() throws IOException{

        char turn;
        File file = new File(path);
        PrintWriter p;
        Scanner scanner;
        scanner = new Scanner(file);
        String data = scanner.nextLine();
        turn = data.charAt(0);
        while (scanner.hasNextLine()){
            data = scanner.nextLine();
            setPos(data);
        }
        return turn;
    }
}

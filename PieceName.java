// God always with me :)
import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;

import javax.imageio.IIOException;
import java.awt.*;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.util.Scanner;

import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
public class PieceName {

    Application application;

    public static String path = "D:\\Sharif univercity of technology\\Semester one\\bp\\project\\Chess6-6\\src\\Chess.txt";

    public PieceName(Application application) {
        this.application = application;
    }
    public static String pieceName = "";
    public static int row;
    public static char col;
    public static char Information(String data){
        int i = 0;row = data.charAt(i) - '0';i += 1;
        if(data.charAt(i) - '0' >= 0 && data.charAt(i) - '0' <= 9){
            row *= 10;
            row += (data.charAt(i) - '0');
            i += 1;
        }
        col = data.charAt(i);
        i += 1;
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
        return color;
    }
    public void Show(){
        char turn;
        File file = new File(path);
        Scanner scanner = new Scanner(System.in);
        try {
            scanner = new Scanner(file);
        }
        catch (Exception e){}
        String data = scanner.nextLine();
        turn = data.charAt(0);
        int cntWhite_bishop = 0;
        int cntWhite_rock = 0;
        int cntWhite_pawn = 0;
        int cntWhite_queen = 0;
        int cntWhite_knight = 0;
        int cntBlack_bishop = 0;
        int cntBlack_rock = 0;
        int cntBlack_pawn = 0;
        int cntBlack_queen = 0;
        int cntBlack_knight = 0;
        ArrayList<StringColor> stringColors = new ArrayList<>();
        while (scanner.hasNextLine()){
            data = scanner.nextLine();
            Information(data);
            if(pieceName == WHITE_BISHOP){
                cntWhite_bishop += 1;
            }
            else if(pieceName == WHITE_KNIGHT){
                cntWhite_knight += 1;
            }
            else if(pieceName == WHITE_QUEEN){
                cntWhite_queen += 1;
            }
            else if(pieceName == WHITE_PAWN){
                cntWhite_pawn += 1;
            }
            else if(pieceName == WHITE_ROCK){
                cntWhite_rock += 1;
            }
            if(pieceName == BLACK_BISHOP){
                cntBlack_bishop += 1;
            }
            else if(pieceName == BLACK_KNIGHT){
                cntBlack_knight += 1;
            }
            else if(pieceName == BLACK_QUEEN){
                cntBlack_queen += 1;
            }
            else if(pieceName == BLACK_PAWN){
                cntBlack_pawn += 1;
            }
            else if(pieceName == BLACK_ROCK){
                cntBlack_rock += 1;
            }
        }
        while(cntBlack_pawn < 9){
            StringColor st = new StringColor(PieceName.BLACK_PAWN, StringColor.BLACK);
            stringColors.add(st);
            cntBlack_pawn += 1;
        }
        while(cntBlack_bishop < 3){
            StringColor st = new StringColor(PieceName.BLACK_BISHOP, StringColor.BLACK);
            stringColors.add(st);
            cntBlack_bishop += 1;
        }
        while(cntBlack_rock < 2){
            StringColor st = new StringColor(PieceName.BLACK_ROCK, StringColor.BLACK);
            stringColors.add(st);
            cntBlack_rock += 1;
        }
        while(cntBlack_knight < 2){
            StringColor st = new StringColor(PieceName.BLACK_KNIGHT, StringColor.BLACK);
            stringColors.add(st);
            cntBlack_knight += 1;
        }
        while(cntBlack_queen < 1){
            StringColor st = new StringColor(PieceName.BLACK_QUEEN, StringColor.BLACK);
            stringColors.add(st);
            cntBlack_queen += 1;
        }
        while(cntWhite_pawn < 9){
            StringColor st = new StringColor(PieceName.WHITE_PAWN, StringColor.WHITE);
            stringColors.add(st);
            cntWhite_pawn += 1;
        }
        while(cntWhite_bishop < 3){
            StringColor st = new StringColor(PieceName.WHITE_BISHOP, StringColor.WHITE);
            stringColors.add(st);
            cntWhite_bishop += 1;
        }
        while(cntWhite_rock < 2){
            StringColor st = new StringColor(PieceName.WHITE_ROCK, StringColor.WHITE);
            stringColors.add(st);
            cntWhite_rock += 1;
        }
        while(cntWhite_knight < 2){
            StringColor st = new StringColor(PieceName.WHITE_KNIGHT, StringColor.WHITE);
            stringColors.add(st);
            cntWhite_knight += 1;
        }
        while(cntWhite_queen < 1){
            StringColor st = new StringColor(PieceName.WHITE_QUEEN, StringColor.WHITE);
            stringColors.add(st);
            cntWhite_queen += 1;
        }
        StringColor[] stringColor = new StringColor[stringColors.size()];
        int u = 0;
        for(StringColor st : stringColors){
            stringColor[u] = st;
            u += 1;
        }
        application.setRemovedPieces(stringColor);
        return;
    }

    public static String WHITE_ROCK = "\u2656";
    public static String WHITE_KNIGHT = "\u2658";
    public static String WHITE_BISHOP = "\u2657";
    public static  String WHITE_QUEEN = "\u2655";
    public static  String WHITE_KING = "\u2654";
    public static String WHITE_PAWN = "\u2659";

    public static  String BLACK_ROCK = "\u265C";
    public static  String BLACK_KNIGHT = "\u265E";
    public static  String BLACK_BISHOP = "\u265D";
    public static  String BLACK_QUEEN = "\u265B";
    public static  String BLACK_KING = "\u265A";
    public static  String BLACK_PAWN = "\u265F";


}
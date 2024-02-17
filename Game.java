// God always with me :)
import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import  sun.misc.*;
import javax.imageio.IIOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.List;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
فیچر های اضافه ای که زدم :
1 اگه روی یه مهره کلیک کنی و دوباره روی خودش کلیک کنی مهره از حالت انتخاب شده خارج میشه

 */

public class Game {
    Application application;

    public static String path = "D:\\Sharif univercity of technology\\Semester one\\bp\\project\\Chess6-6\\src\\Chess.txt";

    public static Tile[][] tile = new Tile[11][11];
    public static String pieceName = "";
    public static int row;
    public static char col, turn;
    public static PieceName pA;
    public static String u1234 = "D:\\Sharif univercity of technology\\Semester one\\bp\\project\\Chess6-6\\src\\mouse_click_sfx.mp3";


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
    public void updTile(){
        tile = new Tile[11][11];
        for(int i = 0; i < 11; i++){
            for(char j = 'a';  j <= 'k'; j++){

                char su = j;
                if(su == 'j') {
                    su = 'k';
                }
                else if(su == 'k'){
                    su = 'l';
                }


                if(i + 1 <= 6){
                    application.setCellProperties(i + 1, su,null, null,null);
                    tile[i][j - 'a'] = new Tile(i + 1, su, true);
                }
                else{
                    if((i + 1 - 6 <= (j - 'a')) && j - 'a'<= 10 - i + 5){
                        tile[i][j - 'a'] = new Tile(i + 1, su, true);
                        application.setCellProperties(i + 1, su,null, null,null);

                    }
                    else{
                        tile[i][j - 'a'] = new Tile(i + 1, su, false);
                    }
                }

            }
        }
        File file = new File(path);
        PrintWriter p;
        Scanner scanner = new Scanner(System.in);
        try {
            scanner = new Scanner(file);
        }
        catch (Exception e){

        }
        String data = scanner.nextLine();
        turn = data.charAt(0);
        while (scanner.hasNextLine()){
            data = scanner.nextLine();
            char color = Information(data);
            if(col >= 'k'){
                tile[row - 1][col - 'a' - 1].setColor(color);
                tile[row - 1][col - 'a' - 1].setName(pieceName);
            }
            else{
                tile[row - 1][col - 'a'].setColor(color);
                tile[row - 1][col - 'a'].setName(pieceName);
            }
            if(color == 'w')
                application.setCellProperties(row, col, pieceName, null,Color.WHITE);
            else{
                application.setCellProperties(row, col, pieceName, null,Color.BLACK);
            }
            if(pieceName == pA.WHITE_PAWN){
                if((row == 1 && col == 'b') || (row == 2 && col == 'c') || (row == 3 && col == 'd') ||  (row == 4 && col == 'e') ||(row == 5 && col == 'f') || (row == 4 && col == 'g') || (row == 3 && col == 'h') || (row == 2 && col == 'i') || (row == 1 && col == 'k')){
                    if(col >= 'k'){
                        tile[row - 1][col - 'a' - 1].setDontMovedPawn(true);
                    }
                    else{
                        tile[row - 1][col - 'a'].setDontMovedPawn(true);
                    }
                }
                else {
                    if(col >= 'k'){
                        tile[row - 1][col - 'a' - 1].setDontMovedPawn(false);
                    }
                    else{
                        tile[row - 1][col - 'a'].setDontMovedPawn(false);
                    }
                }
            }
            else if(pieceName == pA.BLACK_PAWN){
                if((row == 7 && col == 'b') || (row == 7 && col == 'c') || (row == 7 && col == 'd') ||  (row == 7 && col == 'e') ||(row == 7 && col == 'f') || (row == 7 && col == 'g') || (row == 7 && col == 'h') || (row == 7 && col == 'i') || (row == 7 && col == 'k')){
                    if(col >= 'k'){
                        tile[row - 1][col - 'a' - 1].setDontMovedPawn(true);
                    }
                    else{
                        tile[row - 1][col - 'a'].setDontMovedPawn(true);
                    }
                }
                else {
                    if(col >= 'k'){
                        tile[row - 1][col - 'a' - 1].setDontMovedPawn(false);
                    }
                    else{
                        tile[row - 1][col - 'a'].setDontMovedPawn(false);
                    }
                }
            }
        }
        return ;
    }
    public Game(Application application){
        this.application = application;
        pA = new PieceName(application);
    }
    public boolean isNull(Tile tile){
        if(tile.name == "Nothing"){
            return  true;
        }
        return false;
    }

    public void Move(int r, char c){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(tile[i][j].isSelected){
                    row = tile[i][j].getRow();
                    col = tile[i][j].getCol();

                }
            }
        }
        application.setCellProperties(row, col, null, null, null);
        char su = 'a';
        if(c >= 'k')
            su = 'b';
        char sv = 'a';
        if(col >= 'k')
            sv = 'b';
        tile[r - 1][c - su].color = tile[row - 1][col - sv].color;
        tile[r - 1][c - su].name = tile[row - 1][col - sv].name;
        if(tile[r - 1][c - su].name == pA.BLACK_PAWN && r == 1){
            String pr = application.showPromotionPopup();
            if(pr == "Bishop"){
                tile[r - 1][c - su].name = pA.BLACK_BISHOP;
            }
            if(pr == "Knight"){
                tile[r - 1][c - su].name = pA.BLACK_KNIGHT;
            }
            if(pr == "Rook"){
                tile[r - 1][c - su].name = pA.BLACK_ROCK;
            }
            if (pr == "Queen"){
                tile[r - 1][c - su].name = pA.BLACK_QUEEN;
            }
        }
        if(tile[r - 1][c - su].name == pA.WHITE_PAWN && ((r == 7 && c == 'b') || (r == 8 && c == 'c') || (r == 9 && c == 'd') || (r == 10 && c == 'e') || (r == 11 && c == 'f') || (r == 10 && c == 'g') || (r == 9 && c == 'h') || (r == 8 && c == 'i') || (r == 7 && c == 'k') || (r == 6 && c == 'a') || (r == 6 && c == 'l') )  ){
            String pr = application.showPromotionPopup();
            if(pr.equals("Bishop")){
                tile[r - 1][c - su].name = pA.WHITE_BISHOP;
            }
            if(pr.equals("Knight")){
                tile[r - 1][c - su].name = pA.WHITE_KNIGHT;
            }
            if(pr.equals("Rook")){
                tile[r - 1][c - su].name = pA.WHITE_ROCK;
            }
            if (pr.equals( "Queen")){
                tile[r - 1][c - su].name = pA.WHITE_QUEEN;
            }
        }
        tile[row - 1][col - sv].name = "Nothing";
        tile[row - 1][col - sv].color = 'o';

        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++)
                tile[i][j].isSelected = false;
        }
        PrintWriter printWriter;
        File file = new File(path);
        try {
            printWriter = new PrintWriter(file);
            printWriter.close();
            printWriter.flush();
            printWriter = new PrintWriter(file);
            if(turn == 'w')
                 printWriter.write('b');
            else
                printWriter.write('w');
            printWriter.write('\n');

            for(int i = 0; i <11; i++){
                for(int j = 0; j < 11; j++){
                    if(tile[i][j].isAvailable() && tile[i][j].name != "Nothing"){
                        String data = "";
                        data += tile[i][j].getRow();
                        data += tile[i][j].getCol();
                        if(tile[i][j].getName() == "\u2659"){
                            data += 'p';
                        }
                        else if(tile[i][j].getName() == "\u2657"){
                            data += 'b';
                        }
                        else if(tile[i][j].getName() == "\u2656"){
                            data += 'r';
                        }
                        else if(tile[i][j].getName() == "\u2654"){
                            data += 'g';
                        }
                        else if(tile[i][j].getName() == "\u2655"){
                            data += 'q';
                        }
                        else if(tile[i][j].getName() == "\u2658"){
                            data += 't';
                        }
                        else if(tile[i][j].getName() == "\u265F"){
                            data += 'p';
                        }
                        else if(tile[i][j].getName() == "\u265D"){
                            data += 'b';
                        }
                        else if(tile[i][j].getName() == "\u265C"){
                            data += 'r';
                        }
                        else if(tile[i][j].getName() == "\u265A"){
                            data += 'g';
                        }
                        else if(tile[i][j].getName() == "\u265B"){
                            data += 'q';
                        }
                        else if(tile[i][j].getName() == "\u265E"){
                            data += 't';
                        }
                        data += tile[i][j].getColor();
                        printWriter.write(data);
                        printWriter.write('\n');
                       // System.out.println(data);

                    }
                }
            }
            printWriter.close();
            printWriter.flush();
           updTile();
        }
        catch (Exception e){}
        if(turn == 'w'){
            application.setMessage("White's Turn");
        }
        else {
            application.setMessage("Black's Turn");
        }

    }
    public boolean CheckMove(int r, char c){
        updTile();
        boolean res = true;
        char st = 'a';
        if(c >= 'k')
            st = 'b';
        if(tile[r - 1][c - st].name == "Nothing" || tile[r - 1][c - st].color != turn){
            return false;
        }
        tile[r - 1][c - st].isSelected = true;

        return res;
    }
    public ArrayList<Point> CanAttack(int r, char c){
        ArrayList<Point> tiles = new ArrayList<>();

        char st = 'a';
        if(c >= 'k')
            st = 'b';
        if(tile[r - 1][c - st].name == pA.WHITE_ROCK || tile[r - 1][c - st].name == pA.BLACK_ROCK){
            int rq = r;
            while(rq <= 10){
                rq += 1;
                Point point = new Point();
                point.r = rq;
                point.c = c;
                if(rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][c - st].color == tile[r - 1][c - st].color){
                    break;
                }
                tiles.addFirst(point);
                if(tile[rq - 1][c - st].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][c - st].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            while(rq >= 2){
                rq -= 1;
                Point point = new Point();
                point.r = rq;
                point.c = c;
                if(rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][c - st].color == tile[r - 1][c - st].color){
                    break;
                }
                tiles.addFirst(point);
                if(tile[rq - 1][c - st].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][c - st].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }

            rq = r;
            char cq = c;
            while(cq <= 'k' && rq <= 10){
                rq += 1;
                cq += 1;
                Point point = new Point();
                if(cq == 'j')
                    cq += 1;
                if(cq > 'f')
                    rq -= 1;
                point.r = rq;
                point.c = cq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    System.out.println();
                    break;
                }
                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }

            rq = r;
            cq = c;
            while(cq >= 'b' && rq <= 10){
                rq += 1;
                cq -= 1;
                Point point = new Point();
                if(cq == 'j')
                    cq -= 1;
                if(cq < 'f')
                    rq -= 1;
                point.r = rq;
                point.c = cq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            // inja!!
            rq = r;
            cq = c;
            while(cq <= 'k' && rq >= 1){
                rq -= 1;
                cq += 1;
                Point point = new Point();
                if(cq == 'j')
                    cq += 1;
                if(cq <= 'f')
                    rq += 1;
                if(rq == 0)
                    break;
                point.r = rq;
                point.c = cq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            cq = c;
            st = 'a';
            if(c >= 'k')
                st = 'b';
            while(cq >= 'b' && rq >= 1){
                rq -= 1;
                cq -= 1;
                Point point = new Point();

                if(cq == 'j')
                    cq -= 1;
                if(cq >= 'f')
                    rq += 1;
                if(rq == 0)
                    break;
                point.r = rq;
                point.c = cq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }

        }
        else if(tile[r - 1][c - st].name == pA.WHITE_BISHOP || tile[r - 1][c - st].name == pA.BLACK_BISHOP){
            int rq;
            char cq;
            rq = r;
            cq = c;
            st = 'a';
            if(c >= 'k')
                st = 'b';
            while (true){
                if(cq == 'k')
                    cq -= 1;
                if(cq == 'g'){

                }
                else if(cq <= 'f'){
                    rq -= 1;
                }
                else
                    rq += 1;
                cq -= 2;
                if(cq == 'j'){
                    cq -= 1;
                }

                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                        break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            cq = c;
            while (true){
                if(cq == 'e'){

                }
                else if(cq >= 'f'){
                    rq -= 1;
                }
                else
                    rq += 1;
                cq += 2;
                if(cq == 'j'){
                    cq += 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }
            int add = 2;
            rq = r;
            cq = c;
            add = 2;
            while (true){
                if(cq >= 'f'){
                    add = 1;
                }
                cq += 1;
                rq += add;
                if(cq == 'j'){
                    cq += 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }
            cq = c;
            rq = r;
            add = 2;
            while (true){
                if(cq <= 'f'){
                    add = 1;
                }
                cq -= 1;
                rq += add;
                if(cq == 'j'){
                    cq -= 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            cq = c;
            add = 1;
            while (true){
                if(cq >= 'f'){
                    add = 2;
                }
                cq += 1;
                rq -= add;
                if(cq == 'j'){
                    cq += 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }

            rq = r;
            cq = c;
            add = 1;
            while (true){
                if(cq <= 'f'){
                    add = 2;
                }
                cq -= 1;
                rq -= add;
                if(cq == 'j'){
                    cq -= 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }

        }
        else if(tile[r - 1][c - st].name == pA.WHITE_QUEEN || tile[r - 1][c - st].name == pA.BLACK_QUEEN){
            int rq;
            char cq;
            rq = r;
            cq = c;
            st = 'a';
            if(c >= 'k')
                st = 'b';
            while (true){
                if(cq == 'k')
                    cq -= 1;
                if(cq == 'g'){

                }
                else if(cq <= 'f'){
                    rq -= 1;
                }
                else
                    rq += 1;
                cq -= 2;
                if(cq == 'j'){
                    cq -= 1;
                }

                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            cq = c;
            while (true){
                if(cq == 'e'){

                }
                else if(cq >= 'f'){
                    rq -= 1;
                }
                else
                    rq += 1;
                cq += 2;
                if(cq == 'j'){
                    cq += 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }
            int add = 2;
            rq = r;
            cq = c;
            add = 2;
            while (true){
                if(cq >= 'f'){
                    add = 1;
                }
                cq += 1;
                rq += add;
                if(cq == 'j'){
                    cq += 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }
            cq = c;
            rq = r;
            add = 2;
            while (true){
                if(cq <= 'f'){
                    add = 1;
                }
                cq -= 1;
                rq += add;
                if(cq == 'j'){
                    cq -= 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }
                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            cq = c;
            add = 1;
            while (true){
                if(cq >= 'f'){
                    add = 2;
                }
                cq += 1;
                rq -= add;
                if(cq == 'j'){
                    cq += 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }

            rq = r;
            cq = c;
            add = 1;
            while (true){
                if(cq <= 'f'){
                    add = 2;
                }
                cq -= 1;
                rq -= add;
                if(cq == 'j'){
                    cq -= 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }



            /// like Rock
            cq = c;
            rq = r;
            while(rq <= 10){
                rq += 1;
                Point point = new Point();
                point.r = rq;
                point.c = c;

                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][c - st].color == tile[r - 1][c - st].color){
                    break;
                }
                tiles.addFirst(point);
                if(tile[rq - 1][c - st].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][c - st].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            cq = c;
            while(rq >= 2){
                rq -= 1;
                Point point = new Point();
                point.r = rq;
                point.c = c;
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][c - st].color == tile[r - 1][c - st].color){
                    break;
                }
                tiles.addFirst(point);
                if(tile[rq - 1][c - st].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][c - st].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }

            rq = r;
            while(cq <= 'k' && rq <= 10){
                rq += 1;
                cq += 1;
                Point point = new Point();
                if(cq == 'j')
                    cq += 1;
                if(cq > 'f')
                    rq -= 1;
                point.r = rq;
                point.c = cq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    System.out.println();
                    break;
                }
                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }

            rq = r;
            cq = c;
            while(cq >= 'b' && rq <= 10){
                rq += 1;
                cq -= 1;
                Point point = new Point();
                if(cq == 'j')
                    cq -= 1;
                if(cq < 'f')
                    rq -= 1;
                point.r = rq;
                point.c = cq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }
                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            // inja!!
            rq = r;
            cq = c;
            while(cq <= 'k' && rq >= 1){
                rq -= 1;
                cq += 1;
                Point point = new Point();
                if(cq == 'j')
                    cq += 1;
                if(cq <= 'f')
                    rq += 1;
                if(rq == 0)
                    break;
                point.r = rq;
                point.c = cq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            cq = c;
            st = 'a';
            if(c >= 'k')
                st = 'b';
            while(cq >= 'b' && rq >= 1){
                rq -= 1;
                cq -= 1;
                Point point = new Point();
                if(cq == 'j')
                    cq -= 1;
                if(cq >= 'f')
                    rq += 1;
                if(rq == 0)
                    break;
                point.r = rq;
                point.c = cq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
        }
        else if(tile[r - 1][c - st].name == pA.WHITE_PAWN){
            int rq = r;
            char cq = c;
            if(c == 'a'){
                if(r > 10 || c - st + 1 > 10){

                }
                else if(tile[r][c - st +  1].color == 'b'){
                    Point point = new Point();
                    point.r = r + 1;
                    char u = c;
                    u += 1;
                    if(u == 'j')
                        u += 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
            else if(c == 'l'){
                if(r > 10 || c - st - 1 < 0){

                }
                else if(tile[r][c - st -  1].color == 'b'){
                    Point point = new Point();
                    point.r = r + 1;
                    char u = c;
                    u -= 1;
                    if(u == 'j')
                        u -= 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
            else if(c == 'f'){
                if(c - st - 1 < 0){

                }
                else if(tile[r  - 1][c - st -  1].color == 'b'){
                    Point point = new Point();
                    point.r = r;
                    char u = c;
                    u -= 1;
                    if(u == 'j')
                        u -= 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
                if(c - st + 1 > 10){

                }
                else if(tile[r  - 1][c - st +  1].color == 'b'){
                    Point point = new Point();
                    point.r = r;
                    char u = c;
                    u += 1;
                    if(u == 'j')
                        u += 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
            else if(c < 'f'){
                if(c - st - 1 < 0){

                }
                else if(tile[r  - 1][c - st -  1].color == 'b'){
                    Point point = new Point();
                    point.r = r;
                    char u = c;
                    u -= 1;
                    if(u == 'j')
                        u -= 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
                if(r > 10 || c - st + 1 > 10){

                }
                else if(tile[r][c - st +  1].color == 'b'){
                    Point point = new Point();
                    point.r = r + 1;
                    char u = c;
                    u += 1;
                    if(u == 'j')
                        u += 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
            else if(c > 'f'){
                if(r > 10 || c - st - 1 < 0){

                }
                else if(tile[r][c - st -  1].color == 'b'){
                    Point point = new Point();
                    point.r = r + 1;
                    char u = c;
                    u -= 1;
                    if(u == 'j')
                        u -= 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
                if(c - st + 1 > 10){

                }
                else if(tile[r  - 1][c - st +  1].color == 'b'){
                    Point point = new Point();
                    point.r = r;
                    char u = c;
                    u += 1;
                    if(u == 'j')
                        u += 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
        }
        else if(tile[r - 1][c - st].name == pA.BLACK_PAWN){
            int rq = r;
            char cq = c;
            if(c == 'a'){
                if(c - st + 1 > 10){

                }
                else if(tile[r  - 1][c - st +  1].color == 'w'){
                    Point point = new Point();
                    point.r = r;
                    char u = c;
                    u += 1;
                    if(u == 'j')
                        u += 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
            else if(c == 'l'){
                if(c - st - 1 < 0){

                }
                else if(tile[r - 1][c - st -  1].color == 'w'){
                    Point point = new Point();
                    point.r = r;
                    char u = c;
                    u -= 1;
                    if(u == 'j')
                        u -= 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
            else if(c == 'f'){
                if(r < 2 || c - st - 1 < 0){

                }
                else if(tile[r  - 2][c - st -  1].color == 'w'){
                    Point point = new Point();
                    point.r = r - 1;
                    char u = c;
                    u -= 1;
                    if(u == 'j')
                        u -= 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
                if(r < 2 || c - st + 1 > 10){
                }
                else if(tile[r  - 2][c - st +  1].color == 'w'){
                    Point point = new Point();
                    point.r = r  - 1;
                    char u = c;
                    u += 1;
                    if(u == 'j')
                        u += 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
            else if(c < 'f'){
                if(r < 2 || c - st - 1 < 0){

                }
                else if(tile[r  - 2][c - st -  1].color == 'w'){
                    Point point = new Point();
                    point.r = r - 1;
                    char u = c;
                    u -= 1;
                    if(u == 'j')
                        u -= 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
                if(c - st + 1 > 10){

                }
                else if(tile[r - 1][c - st +  1].color == 'w'){
                    Point point = new Point();
                    point.r = r;
                    char u = c;
                    u += 1;
                    if(u == 'j')
                        u += 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
            else if(c > 'f'){
                if(c - st - 1 < 0){

                }
                else if(tile[r - 1][c - st -  1].color == 'w'){
                    Point point = new Point();
                    point.r = r;
                    char u = c;
                    u -= 1;
                    if(u == 'j')
                        u -= 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
                if(r < 2 || c - st + 1 > 10){

                }
                else if(tile[r  - 2][c - st +  1].color == 'w'){
                    Point point = new Point();
                    point.r = r - 1;
                    char u = c;
                    u += 1;
                    if(u == 'j')
                        u += 1;
                    point.c = u;
                    tiles.addFirst(point);
                }
            }
        }
        else if (tile[r - 1][c - st].name == pA.WHITE_KNIGHT || tile[r - 1][c - st].name == pA.BLACK_KNIGHT){

            int rq = r;
            char cq = c;
            if(c == 'f'){
                Point point = new Point();
                char u = c;
                u -= 1;
                if(u == 'j')
                    u = 'k';
                u -= 1;
                if(u == 'j')
                    u = 'k';
                u -= 1;
                if(u == 'j')
                    u = 'k';

                point.c = u;
                point.r = r - 1;
                if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point);
                }
                Point point1 = new Point();
                point1.c = u;
                point1.r = r - 2;
                if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point1);
                }

                Point point2 = new Point();
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                point2.c = u;
                point2.r = r - 1;
                if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point2);
                }
                Point point3 = new Point();
                point3.c = u;
                point3.r = r - 2;
                if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point3);
                }
                //
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'k';
                u -= 1;
                if(u == 'j')
                    u = 'k';
                Point point4 = new Point();
                point4.c = u;
                point4.r = r + 1;
                if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point4);
                }
                Point point5 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'k';
                point5.c = u;
                point5.r = r + 2;
                if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color) {
                    tiles.addFirst(point5);
                }
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'k';
                u -= 1;
                if(u == 'j')
                    u = 'k';
                Point point6 = new Point();
                point6.c = u;
                point6.r = r - 3;
                if(point6.isvalid() && tile[point6.r - 1][point6.c - point6.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point6);
                }
                Point point7 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'k';
                point7.c = u;
                point7.r = r - 3;
                if(point7.isvalid() && tile[point7.r - 1][point7.c - point7.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point7);
                }
                /////
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point8 = new Point();
                point8.c = u;
                point8.r = r + 1;
                if(point8.isvalid() && tile[point8.r - 1][point8.c - point8.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point8);
                }
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point9 = new Point();
                point9.c = u;
                point9.r = r + 2;
                if(point9.isvalid() && tile[point9.r - 1][point9.c - point9.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point9);
                }
                Point point10 = new Point();
                point10.c = u;
                point10.r = r - 3;
                if(point10.isvalid() && tile[point10.r - 1][point10.c - point10.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point10);
                }
                Point point11 = new Point();
                u += 1;
                if(u == 'j')
                    u = 'k';
                point11.c = u;
                point11.r = r - 3;
                if(point11.isvalid() && tile[point11.r - 1][point11.c - point11.sv()].color != tile[r - 1][c - st].color ){
                    tiles.addFirst(point11);
                }
            }
            else if(c <= 'c'){
                    Point point = new Point();
                    char u = c;
                    u -= 1;
                    if(u == 'j')
                        u = 'k';
                    u -= 1;
                    if(u == 'j')
                        u = 'k';
                    u -= 1;
                    if(u == 'j')
                        u = 'k';

                    point.c = u;
                    point.r = r - 1;
                    if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point);
                    }
                    Point point1 = new Point();
                    point1.c = u;
                    point1.r = r - 2;
                    if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point1);
                    }

                    Point point2 = new Point();
                    u = c;
                    u += 1;
                    if(u == 'j')
                        u = 'k';
                    u += 1;
                    if(u == 'j')
                        u = 'k';
                    u += 1;
                    if(u == 'j')
                        u = 'k';
                    point2.c = u;
                    point2.r = r + 1;
                    if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point2);
                    }
                    Point point3 = new Point();
                    point3.c = u;
                    point3.r = r + 2;
                    if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point3);
                    }
                    //
                    u = c;
                    u -= 1;
                    if(u == 'j')
                        u = 'k';
                    u -= 1;
                    if(u == 'j')
                        u = 'k';
                    Point point4 = new Point();
                    point4.c = u;
                    point4.r = r + 1;
                    if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point4);
                    }
                    Point point5 = new Point();
                    u = c;
                    u -= 1;
                    if(u == 'j')
                        u = 'k';
                    point5.c = u;
                    point5.r = r + 2;
                    if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color) {
                        tiles.addFirst(point5);
                    }
                    u = c;
                    u -= 1;
                    if(u == 'j')
                        u = 'k';
                    u -= 1;
                    if(u == 'j')
                        u = 'k';
                    Point point6 = new Point();
                    point6.c = u;
                    point6.r = r - 3;
                    if(point6.isvalid() && tile[point6.r - 1][point6.c - point6.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point6);
                    }
                    Point point7 = new Point();
                    u = c;
                    u -= 1;
                    if(u == 'j')
                        u = 'k';
                    point7.c = u;
                    point7.r = r - 3;
                    if(point7.isvalid() && tile[point7.r - 1][point7.c - point7.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point7);
                    }
                    /////

                    u = c;
                    u += 1;
                    if(u == 'j')
                        u = 'k';
                    u += 1;
                    if(u == 'j')
                        u = 'k';
                    Point point8 = new Point();
                    point8.c = u;
                    point8.r = r + 3;
                    if(point8.isvalid() && tile[point8.r - 1][point8.c - point8.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point8);
                    }
                    u = c;
                    u += 1;
                    if(u == 'j')
                        u = 'k';
                    Point point9 = new Point();
                    point9.c = u;
                    point9.r = r + 3;
                    if(point9.isvalid() && tile[point9.r - 1][point9.c - point9.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point9);
                    }
                    Point point10 = new Point();
                    point10.c = u;
                    point10.r = r - 2;
                    if(point10.isvalid() && tile[point10.r - 1][point10.c - point10.sv()].color != tile[r - 1][c - st].color){
                        tiles.addFirst(point10);
                    }
                    Point point11 = new Point();
                    u += 1;
                    if(u == 'j')
                        u = 'k';
                    point11.c = u;
                    point11.r = r - 1;
                    if(point11.isvalid() && tile[point11.r - 1][point11.c - point11.sv()].color != tile[r - 1][c - st].color ){
                        tiles.addFirst(point11);
                    }

            }
            else if(c >= 'i'){
                Point point = new Point();
                char u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point.c = u;
                point.r = r + 2;
                if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point);
                }
                Point point1 = new Point();
                point1.c = u;
                point1.r = r + 1;
                if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point1);
                }

                Point point2 = new Point();
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                point2.c = u;
                point2.r = r - 1;
                if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point2);
                }
                Point point3 = new Point();
                point3.c = u;
                point3.r = r - 2;
                if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point3);
                }
                //
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point4 = new Point();
                point4.c = u;
                point4.r = r + 3;
                if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point4);
                }
                Point point5 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point5.c = u;
                point5.r = r + 3;
                if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color) {
                    tiles.addFirst(point5);
                }
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point6 = new Point();
                point6.c = u;
                point6.r = r - 1;
                if(point6.isvalid() && tile[point6.r - 1][point6.c - point6.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point6);
                }
                Point point7 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point7.c = u;
                point7.r = r - 2;
                if(point7.isvalid() && tile[point7.r - 1][point7.c - point7.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point7);
                }
                /////
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point8 = new Point();
                point8.c = u;
                point8.r = r + 1;
                if(point8.isvalid() && tile[point8.r - 1][point8.c - point8.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point8);
                }
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point9 = new Point();
                point9.c = u;
                point9.r = r + 2;
                if(point9.isvalid() && tile[point9.r - 1][point9.c - point9.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point9);
                }
                Point point10 = new Point();
                point10.c = u;
                point10.r = r - 3;
                if(point10.isvalid() && tile[point10.r - 1][point10.c - point10.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point10);
                }
                Point point11 = new Point();
                u += 1;
                if(u == 'j')
                    u = 'k';
                point11.c = u;
                point11.r = r - 3;
                if(point11.isvalid() && tile[point11.r - 1][point11.c - point11.sv()].color != tile[r - 1][c - st].color ){
                    tiles.addFirst(point11);
                }
            }
            else if(c == 'd'){
                Point point = new Point();
                char u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';

                point.c = u;
                point.r = r - 1;
                if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point);
                }
                Point point1 = new Point();
                point1.c = u;
                point1.r = r - 2;
                if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point1);
                }

                Point point2 = new Point();
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                point2.c = u;
                point2.r = r;
               // System.out.println(point2.c + " " + point2.r);
                if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point2);
                }
                Point point3 = new Point();
                point3.c = u;
                point3.r = r + 1;
             //   System.out.println(point3.c + " " + point3.r);
                if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point3);
                }
                //
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point4 = new Point();
                point4.c = u;
                point4.r = r + 1;
                if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point4);
                }
                Point point5 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point5.c = u;
                point5.r = r + 2;
                if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color) {
                    tiles.addFirst(point5);
                }
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point6 = new Point();
                point6.c = u;
                point6.r = r - 3;
                if(point6.isvalid() && tile[point6.r - 1][point6.c - point6.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point6);
                }
                Point point7 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point7.c = u;
                point7.r = r - 3;
                if(point7.isvalid() && tile[point7.r - 1][point7.c - point7.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point7);
                }
                /////
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point8 = new Point();
                point8.c = u;
                point8.r = r + 3;
                //System.out.println(point8.r + " " + point8.c);
                if(point8.isvalid() && tile[point8.r - 1][point8.c - point8.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point8);
                }
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point9 = new Point();
                point9.c = u;
                point9.r = r + 3;
                if(point9.isvalid() && tile[point9.r - 1][point9.c - point9.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point9);
                }
                Point point10 = new Point();
                point10.c = u;
                point10.r = r - 2;
                if(point10.isvalid() && tile[point10.r - 1][point10.c - point10.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point10);
                }
                Point point11 = new Point();
                u += 1;
                if(u == 'j')
                    u = 'k';
                point11.c = u;
                point11.r = r - 1;
                if(point11.isvalid() && tile[point11.r - 1][point11.c - point11.sv()].color != tile[r - 1][c - st].color ){
                    tiles.addFirst(point11);
                }
            }
            else if(c == 'e'){
                Point point = new Point();
                char u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';

                point.c = u;
                point.r = r - 1;
                if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point);
                }
                Point point1 = new Point();
                point1.c = u;
                point1.r = r - 2;
                if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point1);
                }

                Point point2 = new Point();
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                point2.c = u;
                point2.r = r - 1;
                // System.out.println(point2.c + " " + point2.r);
                if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point2);
                }
                Point point3 = new Point();
                point3.c = u;
                point3.r = r ;
                //   System.out.println(point3.c + " " + point3.r);
                if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point3);
                }
                //
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point4 = new Point();
                point4.c = u;
                point4.r = r + 1;
                if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point4);
                }
                Point point5 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point5.c = u;
                point5.r = r + 2;
                if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color) {
                    tiles.addFirst(point5);
                }
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point6 = new Point();
                point6.c = u;
                point6.r = r - 3;
                if(point6.isvalid() && tile[point6.r - 1][point6.c - point6.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point6);
                }
                Point point7 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point7.c = u;
                point7.r = r - 3;
                if(point7.isvalid() && tile[point7.r - 1][point7.c - point7.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point7);
                }
                /////
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point8 = new Point();
                point8.c = u;
                point8.r = r + 2;
                //System.out.println(point8.r + " " + point8.c);
                if(point8.isvalid() && tile[point8.r - 1][point8.c - point8.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point8);
                }
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point9 = new Point();
                point9.c = u;
                point9.r = r + 3;
                if(point9.isvalid() && tile[point9.r - 1][point9.c - point9.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point9);
                }
                Point point10 = new Point();
                point10.c = u;
                point10.r = r - 2;
                if(point10.isvalid() && tile[point10.r - 1][point10.c - point10.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point10);
                }
                Point point11 = new Point();
                u += 1;
                if(u == 'j')
                    u = 'k';
                point11.c = u;
                point11.r = r - 2;
                if(point11.isvalid() && tile[point11.r - 1][point11.c - point11.sv()].color != tile[r - 1][c - st].color ){
                    tiles.addFirst(point11);
                }
            }
            else if(c == 'g'){
                Point point = new Point();
                char u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';

                point.c = u;
                point.r = r - 1;
                if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point);
                }
                Point point1 = new Point();
                point1.c = u;
                point1.r = r;
                if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point1);
                }

                Point point2 = new Point();
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                point2.c = u;
                point2.r = r - 1;
                if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point2);
                }
                Point point3 = new Point();
                point3.c = u;
                point3.r = r - 2;
                if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point3);
                }
                //
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point4 = new Point();
                point4.c = u;
                point4.r = r + 2;
                if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point4);
                }
                Point point5 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point5.c = u;
                point5.r = r + 3;
                if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color) {
                    tiles.addFirst(point5);
                }
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point6 = new Point();
                point6.c = u;
                point6.r = r - 2;
                if(point6.isvalid() && tile[point6.r - 1][point6.c - point6.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point6);
                }
                Point point7 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point7.c = u;
                point7.r = r - 2;
                if(point7.isvalid() && tile[point7.r - 1][point7.c - point7.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point7);
                }
                /////
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point8 = new Point();
                point8.c = u;
                point8.r = r + 1;
                if(point8.isvalid() && tile[point8.r - 1][point8.c - point8.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point8);
                }
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point9 = new Point();
                point9.c = u;
                point9.r = r + 2;
                if(point9.isvalid() && tile[point9.r - 1][point9.c - point9.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point9);
                }
                Point point10 = new Point();
                point10.c = u;
                point10.r = r - 3;
                if(point10.isvalid() && tile[point10.r - 1][point10.c - point10.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point10);
                }
                Point point11 = new Point();
                u += 1;
                if(u == 'j')
                    u = 'k';
                point11.c = u;
                point11.r = r - 3;
                if(point11.isvalid() && tile[point11.r - 1][point11.c - point11.sv()].color != tile[r - 1][c - st].color ){
                    tiles.addFirst(point11);
                }
            }
            else{
                Point point = new Point();
                char u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';

                point.c = u;
                point.r = r;
                if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point);
                }
                Point point1 = new Point();
                point1.c = u;
                point1.r = r + 1;
                if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point1);
                }

                Point point2 = new Point();
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                point2.c = u;
                point2.r = r - 1;
                if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point2);
                }
                Point point3 = new Point();
                point3.c = u;
                point3.r = r - 2;
                if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point3);
                }
                //
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point4 = new Point();
                point4.c = u;
                point4.r = r + 3;
                if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point4);
                }
                Point point5 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point5.c = u;
                point5.r = r + 3;
                if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color) {
                    tiles.addFirst(point5);
                }
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                u -= 1;
                if(u == 'j')
                    u = 'i';
                Point point6 = new Point();
                point6.c = u;
                point6.r = r - 1;
                if(point6.isvalid() && tile[point6.r - 1][point6.c - point6.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point6);
                }
                Point point7 = new Point();
                u = c;
                u -= 1;
                if(u == 'j')
                    u = 'i';
                point7.c = u;
                point7.r = r - 2;
                if(point7.isvalid() && tile[point7.r - 1][point7.c - point7.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point7);
                }
                /////
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point8 = new Point();
                point8.c = u;
                point8.r = r + 1;
                if(point8.isvalid() && tile[point8.r - 1][point8.c - point8.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point8);
                }
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                Point point9 = new Point();
                point9.c = u;
                point9.r = r + 2;
                if(point9.isvalid() && tile[point9.r - 1][point9.c - point9.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point9);
                }
                Point point10 = new Point();
                point10.c = u;
                point10.r = r - 3;
                if(point10.isvalid() && tile[point10.r - 1][point10.c - point10.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point10);
                }
                Point point11 = new Point();
                u += 1;
                if(u == 'j')
                    u = 'k';
                point11.c = u;
                point11.r = r - 3;
                if(point11.isvalid() && tile[point11.r - 1][point11.c - point11.sv()].color != tile[r - 1][c - st].color ){
                    tiles.addFirst(point11);
                }
            }


        }
        else if(pA.BLACK_KING == tile[r - 1][c - st].name || pA.WHITE_KING == tile[r - 1][c - st].name){
            int rq;
            char cq;
            rq = r;
            cq = c;
            st = 'a';
            if(c >= 'k')
                st = 'b';
            int l = 0;
            while (l == 0){
                l += 1;
                if(cq == 'k')
                    cq -= 1;
                if(cq == 'g'){

                }
                else if(cq <= 'f'){
                    rq -= 1;
                }
                else
                    rq += 1;
                cq -= 2;
                if(cq == 'j' || cq == 'k'){
                    cq -= 1;
                }

                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            cq = c;
            l = 0;
            while (l == 0){
                l = 1;
                if(cq == 'e'){

                }
                else if(cq >= 'f'){
                    rq -= 1;
                }
                else
                    rq += 1;
                cq += 2;
                if(cq == 'j' || cq == 'k'){
                    cq += 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }
            int add = 2;
            rq = r;
            cq = c;
            add = 2;
            l = 0;
            while (l == 0){
                l = 1;
                if(cq >= 'f'){
                    add = 1;
                }
                cq += 1;
                rq += add;
                if(cq == 'j' || cq == 'k'){
                    cq += 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }
            cq = c;
            rq = r;
            add = 2;
            l = 0;
            while (l == 0){
                l = 1;
                if(cq <= 'f'){
                    add = 1;
                }
                cq -= 1;
                rq += add;
                if(cq == 'j'){
                    cq -= 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            rq = r;
            cq = c;
            add = 1;
            l = 0;
            while (l == 0){
                l = 1;
                if(cq >= 'f'){
                    add = 2;
                }
                cq += 1;
                rq -= add;
                if(cq == 'j' || cq == 'k'){
                    cq += 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;

                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }

                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }

            }

            rq = r;
            cq = c;
            add = 1;
            l = 0;
            while (l == 0){
                l = 1;
                if(cq <= 'f'){
                    add = 2;
                }
                cq -= 1;
                rq -= add;
                if(cq == 'j'){
                    cq -= 1;
                }
                Point point = new Point();
                point.c = cq;
                point.r = rq;
                char lsm = 'a';
                if(cq >= 'k'){
                    lsm = 'b';
                }
                if(cq < 'a' || cq > 'l' || rq < 1 || rq > 11)
                    break;
                if(tile[rq - 1][cq - lsm].color == tile[r - 1][c - st].color){
                    break;
                }
                tiles.addFirst(point);
                if(tile[rq - 1][cq - lsm].color == 'w' && tile[r - 1][c - st].color == 'b'){
                    break;
                }
                else if(tile[rq - 1][cq - lsm].color == 'b' && tile[r - 1][c - st].color == 'w'){
                    break;
                }
            }
            if(c == 'f'){
                Point point = new Point();
                point.r = r + 1;
                point.c = c;
                if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point);
                }
                Point point1 = new Point();
                point1.r = r - 1;
                point1.c = c;
                if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point1);
                }

                Point point3 = new Point();
                point3.r = r;
                char u = c;
                u -= 1;
                if(u == 'j'){
                    u = 'i';
                }
                point3.c = u;
                if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point3);
                }
                Point point2 = new Point();
                point2.r = r;
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';;
                point2.c = u;
                if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point2);
                }

                Point point4 = new Point();
                point4.r = r - 1;
                u = c;
                u -= 1;
                if(u == 'j'){
                    u = 'i';
                }
                point4.c = u;
                if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point4);
                }
                Point point5 = new Point();
                point5.r = r - 1;
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';;
                point5.c = u;
                if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point5);
                }

            }
            else if(c < 'f'){
                Point point = new Point();
                point.r = r + 1;
                point.c = c;
                if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point);
                }
                Point point1 = new Point();
                point1.r = r - 1;
                point1.c = c;
                if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point1);
                }

                Point point3 = new Point();
                point3.r = r;
                char u = c;
                u -= 1;
                if(u == 'j'){
                    u = 'i';
                }
                point3.c = u;
                if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point3);
                }
                Point point2 = new Point();
                point2.r = r + 0;
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';;
                point2.c = u;
                if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point2);
                }

                Point point4 = new Point();
                point4.r = r - 1;
                u = c;
                u -= 1;
                if(u == 'j'){
                    u = 'i';
                }
                point4.c = u;
                if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point4);
                }
                Point point5 = new Point();
                point5.r = r + 1;
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';
                point5.c = u;
                if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point5);
                }
            }
            else{
                Point point = new Point();
                point.r = r + 1;
                point.c = c;
                if(point.isvalid() && tile[point.r - 1][point.c - point.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point);
                }
                Point point1 = new Point();
                point1.r = r - 1;
                point1.c = c;
                if(point1.isvalid() && tile[point1.r - 1][point1.c - point1.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point1);
                }

                Point point3 = new Point();
                point3.r = r + 0;
                char u = c;
                u -= 1;
                if(u == 'j'){
                    u = 'i';
                }
                point3.c = u;
                if(point3.isvalid() && tile[point3.r - 1][point3.c - point3.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point3);
                }
                Point point2 = new Point();
                point2.r = r;
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';;
                point2.c = u;
                if(point2.isvalid() && tile[point2.r - 1][point2.c - point2.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point2);
                }

                Point point4 = new Point();
                point4.r = r + 1;
                u = c;
                u -= 1;
                if(u == 'j'){
                    u = 'i';
                }
                point4.c = u;
                if(point4.isvalid() && tile[point4.r - 1][point4.c - point4.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point4);
                }
                Point point5 = new Point();
                point5.r = r - 1;
                u = c;
                u += 1;
                if(u == 'j')
                    u = 'k';;
                point5.c = u;
                if(point5.isvalid() && tile[point5.r - 1][point5.c - point5.sv()].color != tile[r - 1][c - st].color){
                    tiles.addFirst(point5);
                }
            }

        }

        return tiles;
    }
    public int ShowPossibleMove(int r, char c){
        ArrayList<Point> tiles = new ArrayList<>();
        Point point = new Point();
        char st = 'a';
        if(c >= 'k')
            st = 'b';
        pA = new PieceName(application);

        tiles = CanAttack(r, c);
        if(pA.WHITE_PAWN ==tile[r - 1][c - st].name){
            if(tile[r - 1][c - st].dontMovedPawn){
                if(tile[r][c - st].name == "Nothing"){
                    Point point1 = new Point();
                    point1.r = r + 1;
                    point1.c = c;
                    tiles.addFirst(point1);
                    if(tile[r  + 1][c - st].name == "Nothing"){
                        Point point2 = new Point();
                        point2.r = r + 2;
                        point2.c = c;
                        tiles.addFirst(point2);
                    }
                }
            }
            else {
                if(tile[r][c - st].name == "Nothing"){
                    Point point1 = new Point();
                    point1.r = r + 1;
                    point1.c = c;
                    tiles.addFirst(point1);
                }
            }
        }
        else if(pA.BLACK_PAWN ==tile[r - 1][c - st].name){
            if(tile[r - 1][c - st].dontMovedPawn){
                if(tile[r - 2][c - st].name == "Nothing"){
                    Point point1 = new Point();
                    point1.r = r - 1;
                    point1.c = c;
                    tiles.addFirst(point1);
                    if(tile[r  - 3][c - st].name == "Nothing"){
                        Point point2 = new Point();
                        point2.r = r - 2;
                        point2.c = c;
                        tiles.addFirst(point2);
                    }
                }

            }
            else {
                if(tile[r - 2][c - st].name == "Nothing"){
                    Point point1 = new Point();
                    point1.r = r - 1;
                    point1.c = c;
                    tiles.addFirst(point1);
                }
            }
        }
        st = 'a';
        if(c >= 'k')
            st = 'b';
        if(tile[r - 1][c - st].name == "Nothing" && tile[r - 1][c - st].isAvailable()){
            application.setCellProperties(r, c, null, Color.RED, null);
        }
        else if(tile[r - 1][c - st].isAvailable()){
            application.setCellProperties(r, c, tile[r - 1][c - st].name, Color.RED, Color.WHITE);
            if(tile[r - 1][c - st].color == 'b')
                application.setCellProperties(r, c, tile[r - 1][c - st].name, Color.RED, Color.BLACK);
        }
        if(pA.BLACK_KING == tile[r - 1][c - st].name || pA.WHITE_KING == tile[r - 1][c - st].name){
            ArrayList<Point> points = new ArrayList<>();
            for(Point point1 : tiles){
                if(!OnderAttack(point1.r,point1.c, turn)){
                    points.add(point1);
                }
            }
            tiles.clear();
            tiles.addAll(points);
        }

            File file = new File(path);
            PrintWriter p;
            Scanner scanner = new Scanner(System.in);
            try {
                scanner = new Scanner(file);
            }
            catch (Exception e){
                System.out.println("Error!");;
            }
            String data = scanner.nextLine();
            turn = data.charAt(0);
            while (scanner.hasNextLine()){
                data = scanner.nextLine();
                Information(data);
                st = 'a';
                if(c >= 'k')
                    st = 'b';
            }
            st = 'a';
            if(c >= 'k')
                st = 'b';
            for(Point point1 : tiles){
                c = point1.c;
                r = point1.r;
                st = 'a';
                if(c >= 'k')
                    st = 'b';
                if(tile[r - 1][c - st].name == "Nothing" && tile[r - 1][c - st].isAvailable()){
                    application.setCellProperties(r, c, null, Color.GRAY, null);
                }
                else if(tile[r - 1][c - st].isAvailable()){
                    application.setCellProperties(r, c, tile[r - 1][c - st].name, Color.GRAY, Color.WHITE);
                    if(tile[r - 1][c - st].color == 'b')
                        application.setCellProperties(r, c, tile[r - 1][c - st].name, Color.GRAY, Color.BLACK);
                }
            }

            return tiles.size();

    }

    public boolean OnderAttack(int r1, char c1, char turn1){
        File file = new File(path);
        PrintWriter p;
        Scanner scanner = new Scanner(System.in);
        try {
            scanner = new Scanner(file);
        }
        catch (Exception e){
            System.out.println("Error!");;
        }
        String data = scanner.nextLine();
        turn = data.charAt(0);
        ArrayList<Point> OnderAttack =new ArrayList<>();
        char st = 'a';
        if(c1 >= 'k')
            st += 1;
        AllPossibleMove allPossibleMove = new AllPossibleMove(tile, application);
        while (scanner.hasNextLine()){
            data = scanner.nextLine();
            if(Information(data) != turn1)
                OnderAttack.addAll(allPossibleMove.CanAttack(row, col));
        }
        for(Point point1 : OnderAttack){
            //System.out.println(point1.r + " " + point1.c);
            if(point1.r == r1 && point1.c == c1){
                //System.out.println(point1.r + " " + point1.c);
                return true;
            }

        }
        return false;
    }
    public Point KingPlace(char color){
        Point point = new Point();
        if(color == 'w'){
            for(int i = 0; i < 11; i++){
                for(int j = 0; j < 11; j++){
                    if(tile[i][j].name == pA.WHITE_KING){
                        point.r = tile[i][j].getRow();
                        point.c = tile[i][j].getCol();
                    }
                }
            }
            return point;

        }
        else{
            for(int i = 0; i < 11; i++){
                for(int j = 0; j < 11; j++){
                    if(tile[i][j].name == pA.BLACK_KING){
                        point.r = tile[i][j].getRow();
                        point.c = tile[i][j].getCol();
                    }
                }
            }
            return point;
        }
    }
    public int ShowPossibleMoveSize(int r, char c){
        ArrayList<Point> tiles = new ArrayList<>();
        Point point = new Point();
        char st = 'a';
        if(c >= 'k')
            st = 'b';
        pA = new PieceName(application);
        tiles = CanAttack(r, c);
        Point point14 = new Point();
        point14.r = r;
        point14.c = c;
        if(point14.isvalid() == false)
            return 0;
        st = 'a';
        if(c >= 'k')
            st = 'b';
        if(pA.BLACK_KING == tile[r - 1][c - st].name || pA.WHITE_KING == tile[r - 1][c - st].name){
            ArrayList<Point> points = new ArrayList<>();
            for(Point point1 : tiles){
                if(!OnderAttack(point1.r,point1.c, turn)){
                    points.add(point1);
                }
            }
            tiles.clear();
            tiles.addAll(points);
        }

        File file = new File(path);
        PrintWriter p;
        Scanner scanner = new Scanner(System.in);
        try {
            scanner = new Scanner(file);
        }
        catch (Exception e){
            System.out.println("Error!");;
        }
        String data = scanner.nextLine();
        turn = data.charAt(0);
        while (scanner.hasNextLine()){
            data = scanner.nextLine();
            Information(data);
            st = 'a';
            if(c >= 'k')
                st = 'b';
        }
        return tiles.size();

    }

    public static Tile[][] getTile() {
        return tile;
    }

    public static void setTile(Tile[][] tile) {
        Game.tile = tile;
    }
}

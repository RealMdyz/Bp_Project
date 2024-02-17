// God always with me :)
import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;

import javax.imageio.IIOException;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.util.Scanner;
/*

تنها چیزی که از بازی مونده : پیاده سازی وضعیت مات !

 */
public class Main{
    public static String path = "D:\\Sharif univercity of technology\\Semester one\\bp\\project\\Chess6-6\\src\\Chess.txt";
    public static Application application = new Application();
    public static boolean onTheMove = false;
    public static String pieceName = "";
    public static int row, r;
    public static char col, c, turn;
    public static PieceName pieceName1 = new PieceName(application);
    public static int r12;
    public static char c12;
    public void CheckTurn(){
        if(turn == 'w'){
            application.setMessage("White's Turn");
        }
        else {
            application.setMessage("Black's Turn");
        }
    }
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

    public static void main (String[] args) throws IOException {
        File file = new File(path);
        Scanner scanner;
        SetPos setPos = new SetPos(application);
        int x = 0;
        scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            x += 1;
            scanner.nextLine();
        }
        if(x == 0){
            turn = setPos.sFirstPos();
        }
        else{
            turn = setPos.setPos();
        }
        if(turn == 'w'){
            application.setMessage("White's Turn");
        }
        else {
            application.setMessage("Black's Turn");
        }
        Game game  = new Game(application);
        pieceName1.Show();

        application.registerEventListener(new EventListener() {
            @Override public void onClick(int r1, char c1){
                if(onTheMove){
                    Point point = new Point();
                    point.r = r1;
                    point.c = c1;
                    if(r1 == r12 && c1 == c12 ){
                        onTheMove = false;
                        game.updTile();
                    }
                    else{
                        game.Move(r1, c1);
                        if(game.OnderAttack(game.KingPlace(turn).r, game.KingPlace(turn).c, turn)){
                            if(turn == 'w'){
                                application.showMessagePopup("Black Win");
                            }
                            else{
                                application.showMessagePopup("White Win");
                            }
                            try {
                                PrintWriter p;
                                p = new PrintWriter(file);
                                p.close();
                                p.flush();
                            }
                            catch (Exception e){
                                System.out.println("Error!");;
                            }
                        }
                        pieceName1.Show();
                        onTheMove = false;
                    }

                }
                else{
                    if(game.CheckMove(r1, c1)){
                        int cnt = game.ShowPossibleMove(r1, c1);
                        if(game.ShowPossibleMoveSize(game.KingPlace(turn).r, game.KingPlace(turn).c) == 0){
                            File file = new File(path);
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
                                if(Information(data) == turn)
                                    if(game.ShowPossibleMoveSize(row, col) > 0){
                                        onTheMove = true;
                                    }
                            }
                            if(!onTheMove  && game.OnderAttack(game.KingPlace(turn).r, game.KingPlace(turn).c, turn) == false){
                               application.showMessagePopup("Tie!");
                                try {
                                    PrintWriter p;
                                    p = new PrintWriter(file);
                                    p.close();
                                    p.flush();
                                }
                                catch (Exception e){
                                    System.out.println("Error!");;
                                }
                            }
                            else if(!onTheMove  && game.OnderAttack(game.KingPlace(turn).r, game.KingPlace(turn).c, turn) == true){
                                if(turn == 'w'){
                                    application.showMessagePopup("Black Win");
                                }
                                else{
                                    application.showMessagePopup("White Win");
                                }
                                try {
                                    PrintWriter p;
                                    p = new PrintWriter(file);
                                    p.close();
                                    p.flush();
                                }
                                catch (Exception e){
                                    System.out.println("Error!");;
                                }
                            }
                        }
                        else if(cnt == 0){
                            application.showMessagePopup("This Piece Cant Move!!!");
                        }
                        else{
                            r12 = r1;
                            c12 = c1;
                            onTheMove = true;
                        }
                        r12 = r1;
                        c12 = c1;
                    }
                    else {
                        application.showMessagePopup("This is not available!");
                    }
                }
            }
            @Override public void onLoad(File file) {

            }
            @Override public void onSave(File file) {

            }
            @Override public void onNewGame() {
                try {
                    PrintWriter p = new PrintWriter(file);
                    p.close();
                    setPos.sFirstPos();
                }
                catch (Exception e){

                }
            }
        });
    }
}
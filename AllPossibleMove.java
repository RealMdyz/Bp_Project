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

public class AllPossibleMove {
    Application application;

    Tile[][] tile;
    public static PieceName pA;
    public AllPossibleMove(Tile[][] tile, Application application){
        this.tile = tile;
        this.application = application;
    }
    public ArrayList<Point> CanAttack(int r, char c){
        ArrayList<Point> tiles = new ArrayList<>();
        char[][]  color = new char[11][11];
        char lq = 'a';
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                lq += 1;
                color[i][j] = tile[i][j].color;
                tile[i][j].color = lq;
            }
        }
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
        } ///////////!!!!!!!!!!!!!//////////////
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
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                lq += 1;
                 tile[i][j].color = color[i][j];
            }
        }
        return tiles;
    }

}

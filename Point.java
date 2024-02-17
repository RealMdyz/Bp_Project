public class Point {
    public  int r;
    public char c;

    public Point() {
    }

    public boolean isvalid(){
        if(r >= 1 && r <= 11 && c >= 'a' && c <= 'l')
            return true;
        return false;
    }
    public char sv(){
        if(c >= 'k')
            return 'b';
        return 'a';
    }
}

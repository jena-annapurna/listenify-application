package listenify;

public class Song {
    public  String name;
    private double duration;

    public Song(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }
    public String toString()
    {
        return "Printing song{" + "title= '" + name+'\'' + ",duration=" +duration+'}';
    }
}

package listenify;

import java.util.*;
public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {
        Album album=new Album("One(Original Never Ends)","Badshah");
        album.addSongToAlbum("Dj Waley Babu",2.49);
        album.addSongToAlbum("She Move It Like",3.02);
        album.addSongToAlbum("Mercy",2.43);
        albums.add(album);

        album=new Album("Kabir Singh","Armaan Malik");
        album.addSongToAlbum("Tujhe kitna chahne Lage",4.45);
        album.addSongToAlbum("Bekhayali",6.11);
        album.addSongToAlbum("Kaise Hua",3.55);
        albums.add(album);

        LinkedList<Song> playList1=new LinkedList<>();
        albums.get(0).addSongToPlayList("Mercy",playList1);
        albums.get(0).addSongToPlayList("She Move It Like",playList1);
        albums.get(1).addSongToPlayList("Kaise Hua",playList1);
        albums.get(1).addSongToPlayList("Bekhayali",playList1);
        play(playList1);
    }
    public static void play(LinkedList<Song> playList)
    {
        ListIterator<Song> listIterartor=playList.listIterator();
        if(playList.size()==0)
            return;
        Scanner sc=new Scanner(System.in);
        printMenu();
        System.out.println(
                "Now playing"+listIterartor.next()
        );
        boolean forward=true;
        boolean quit=false;
        while(quit==false)
        {
            int choice=sc.nextInt();
            switch(choice)
            {
                case 0:
                    quit=true;
                    break;
                case 1:
                    if(forward==false)
                    {
                        listIterartor.next();
                        forward=true;
                    }
                    if(listIterartor.hasNext()){
                        System.out.println(listIterartor.next().toString());
                    }
                    else
                        System.out.println("You are at the last song");
                    break;
                case 2:
                    if(forward==true)//already towards the right of the last printed value
                    {
                        listIterartor.previous();
                        forward=false;
                    }
                    if(listIterartor.hasPrevious()){
                        System.out.println(listIterartor.previous().toString());
                    }
                    else {
                        System.out.println("You are already at the first song");
                    }
                    break;
                case 3:
                    if(forward==true) {
                        System.out.println(listIterartor.previous().toString());
                        forward=false;
                    }
                    else {
                        System.out.println(listIterartor.next().toString());
                        forward=true;
                    }
                    break;
                case 4:
                    printAllSongs(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0)
                    {
                        System.out.println(listIterartor.previous().toString()+" has been removed from the playlist");
                        listIterartor.remove();
                        if(playList.size()>0 && listIterartor.hasPrevious())
                        {
                            System.out.println("Now playing "+listIterartor.next().toString());
                        }
                        else if(playList.size()>0 && listIterartor.hasNext())
                            System.out.println("Now playing "+listIterartor.previous().toString());
                        else {
                            System.out.println("The playlist is already empty");
                        }
                    }
                    break;

            }
        }
    }
    private static void printAllSongs(LinkedList<Song> songs)
    {
        ListIterator<Song> listIterator=songs.listIterator();
        while(listIterator.hasNext())
        {
            System.out.println(listIterator.next().toString());
        }
    }
    public static void printMenu()
    {
        System.out.println("Available options\n press");
        System.out.println("0- to quit\n"+
                "1- to play next Song\n"+
                "2- to play previous song\n"+
                "3- to replay the current song\n"+
                "4- list of all songs\n"+
                "5- print all available options\n"+
                "6- delete the current song"
        );


    }
}
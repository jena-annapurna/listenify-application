package listenify;

import java.util.*;
import java.util.ArrayList;

public class Album {
    public static String artistName;
    public String albumName;
    public List<Song> songList;

    public Album(String albumName,String artistName) {
        this.albumName = albumName;
        this.artistName=artistName;
        this.songList=new ArrayList<>();
    }
    boolean findSongInAlbum(String title)
    {
        for(Song song:songList)
        {
            if((song.name).equals(title))
                return true;

        }
        return false;
    }
    public String addSongToAlbum(String title,double duration)
    {
        //check if the song already exists or not
        if(findSongInAlbum(title)==true)
            return "Song is already present";
            //if the song is not present,add it to the album
            //i need to create a song object then add it to the songList
        else {
            Song newSong = new Song(title, duration);
            songList.add(newSong);
            return "New song has been added successfully";
        }
    }
    public String addSongToPlayList(int trackNo,LinkedList<Song> playList)
    {
        int index=trackNo-1;
        //checking for validity and then add it to the playList using index
        if(index>=0 && index<this.songList.size())
        {
            if(playList.contains(this.songList.get(index)))
            {
                return "Song is already present in the playList";
            }
            playList.add(this.songList.get(index));
            return "Song added to the PlayList";
        }
        return "Invalid track number";
    }
    public String addSongToPlayList(String title,LinkedList<Song> playList) {
        //find the song using title
        for (Song song : songList) {
            if (song.name==title) {
                playList.add(song);
                return "Song has been added to Playlist";
            }
        }
        return "Song does not exist";
    }
}

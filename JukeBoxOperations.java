package JukeBox;

import JukeBox.Beans.Album;
import JukeBox.Beans.Artist;
import JukeBox.Beans.Gener;
import JukeBox.Beans.Song;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class JukeBoxOperations
{
    JukeBoxDao dao=null;
    public ArrayList<Song> displayacatalog()
    {
        ArrayList<Song> al=null;
        try
        {
            al = new ArrayList<Song>();
            dao = new JukeBoxDao();
            ResultSet res = dao.allSongs();
            Song s = null;
            while (res != null)
            {
                String name = res.getString("name");
                int duration = res.getInt("duration");
                int genere = res.getInt("genere");
                String genere_name = dao.getGName(genere);
                int album = res.getInt("album");
                String album_name = dao.getAName(album);
                int artist = res.getInt("artist");
                String artist_name = dao.getArName(artist);
                s = new Song(name, duration, new Gener(genere_name), new Artist(artist_name), new Album(artist_name));
                al.add(s);
            }
            al.stream().sorted(Comparator.comparing(Song::getName));
            int i=1;
            for (Song song : al)
            {
                System.out.println(i+" "+song);
                i++;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return al;
    }
    public ArrayList<Song> displayArtistPlaylistSorted()
    {
        ArrayList<Song> al=null;
        try
        {
            al = new ArrayList<Song>();
            dao = new JukeBoxDao();
            Scanner sc=new Scanner(System.in);
            System.out.println("These are artists available Enter related artist id to listen");
            dao.allArtistNames();
            int artist_id=sc.nextInt();
            ResultSet res = dao.artistBasedSongs(artist_id);
            Song s = null;
            while (res != null)
            {
                String name = res.getString("name");
                int duration = res.getInt("duration");
                int genere = res.getInt("genere");
                String genere_name = dao.getGName(genere);
                int album = res.getInt("album");
                String album_name = dao.getAName(album);
                int artist = res.getInt("artist");
                String artist_name = dao.getArName(artist);
                s = new Song(name, duration, new Gener(genere_name), new Artist(artist_name), new Album(artist_name));
                al.add(s);
            }
            al.stream().sorted(Comparator.comparing(Song::getName));
            int i=1;
            for (Song song : al)
            {
                System.out.println(i+" "+song);
                i++;
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return al;
    }
    public ArrayList<Song> displayAlbumPlaylistSorted()
    {
        ArrayList<Song> al=null;
        try
        {
            al = new ArrayList<Song>();
            dao = new JukeBoxDao();
            Scanner sc=new Scanner(System.in);

            System.out.println("These are albums/Bollywood Movie songs available Enter related album id to listen");
            dao.allAlbumNames();
            int album_id=sc.nextInt();
            ResultSet res = dao.albumBasedSongs(album_id);
            Song s = null;
            while (res != null)
            {
                String name = res.getString("name");
                int duration = res.getInt("duration");
                int genere = res.getInt("genere");
                String genere_name = dao.getGName(genere);
                int album = res.getInt("album");
                String album_name = dao.getAName(album);
                int artist = res.getInt("artist");
                String artist_name = dao.getArName(artist);
                s = new Song(name, duration, new Gener(genere_name), new Artist(artist_name), new Album(artist_name));
                al.add(s);
            }
            al.stream().sorted(Comparator.comparing(Song::getName));
            int i=1;
            for (Song song : al)
            {
                System.out.println(i+" "+song);
                i++;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return al;
    }
    public ArrayList<Song> displayGenerePlaylistSorted()
    {
        ArrayList<Song> al=null;
        try
        {
            al = new ArrayList<Song>();
            dao = new JukeBoxDao();
            Scanner sc=new Scanner(System.in);
            System.out.println("These are genere available Enter related artist id to listen");
            dao.allGenereNames();
            int genere_id=sc.nextInt();
            ResultSet res = dao.genereBasedSongs(genere_id);
            Song s = null;
            while (res != null)
            {
                String name = res.getString("name");
                int duration = res.getInt("duration");
                int genere = res.getInt("genere");
                String genere_name = dao.getGName(genere);
                int album = res.getInt("album");
                String album_name = dao.getAName(album);
                int artist = res.getInt("artist");
                String artist_name = dao.getArName(artist);
                s = new Song(name, duration, new Gener(genere_name), new Artist(artist_name), new Album(artist_name));
                al.add(s);
            }
            al.stream().sorted(Comparator.comparing(Song::getName));
            int i=1;
            for (Song song : al)
            {
                System.out.println(i+" "+song);
                i++;
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return al;
    }
    public ArrayList<Song> displayPlaylistSorted()
    {
        ArrayList<Song> al=null;
        try
        {
            al = new ArrayList<Song>();
            dao = new JukeBoxDao();
            Scanner sc=new Scanner(System.in);
            System.out.println("These are playlists available Enter related playlist id to listen");
            dao.allPlaylistNames();
            int genere_id=sc.nextInt();
            ResultSet res1 = dao.playlistBasedSongs(genere_id);
            while(res1!=null)
            {
                int song_id=res1.getInt("song_id");
                ResultSet res=dao.getSongDeatils(song_id);
                Song s = null;
                while (res != null)
                {
                    String name = res.getString("name");
                    int duration = res.getInt("duration");
                    int genere = res.getInt("genere");
                    String genere_name = dao.getGName(genere);
                    int album = res.getInt("album");
                    String album_name = dao.getAName(album);
                    int artist = res.getInt("artist");
                    String artist_name = dao.getArName(artist);
                    s = new Song(name, duration, new Gener(genere_name), new Artist(artist_name), new Album(artist_name));
                    al.add(s);
                }

            }
            al.stream().sorted(Comparator.comparing(Song::getName));
            int i=1;
            for (Song song : al)
            {
                System.out.println(i+" "+song);
                i++;
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return al;
    }
    public ArrayList<Song> createOwnPlaylist()
    {
        ArrayList<Song> al=new ArrayList<>();
        System.out.println("Please enter Your playlist name=");
        Scanner sc=new Scanner(System.in);
        String playlist_name=sc.next();
        int i=0;
        //int i=createPlaylist(playlist_name);
        if(i>0)
            System.out.println("One Playlist Created!!");
        System.out.println("Songs and podcast List to add in playlist"+playlist_name);
        displayacatalog();
        //addToPlaylist()

        return al;
    }


}

package JukeBox;


import JukeBox.Beans.Album;
import JukeBox.Beans.Artist;
import JukeBox.Beans.Gener;
import JukeBox.Beans.Song;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JukeBoxDao
{
    public Connection getConnection()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","shruti");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
    public ResultSet allSongs()
    {
        ResultSet res=null;

        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select * from song");
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return res;
    }
    public String getGName(int genere)
    {
        ResultSet res=null;
        String genere_name=null;
        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select genere_name from genere where genere_id="+genere);
            while (res!=null)
            {
                genere_name=res.getString("genere_name");
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return genere_name;
    }
    public String getAName(int album)
    {
        ResultSet res=null;
        String album_name=null;
        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select album_name from album where album_id="+album);
            while (res!=null)
            {
                album_name=res.getString("album_name");
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return album_name;
    }
    public String getArName(int artist)
    {
        ResultSet res=null;
        String artist_name=null;
        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select artist_name from album where artist_id="+artist);
            while (res!=null)
            {
                artist_name=res.getString("artist_name");
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return artist_name;
    }
    public ResultSet artistBasedSongs(int artist_id)
    {
        ResultSet res=null;

        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select * from song where artist_id="+artist_id);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return res;
    }
    public void allArtistNames()
    {
        ResultSet res=null;

        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select * from artist");
            while(res!=null)
            {
                System.out.println(res.getInt("artist_id")+" "+res.getString("artist_name"));
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    public ResultSet albumBasedSongs(int album_id)
    {
        ResultSet res=null;

        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select * from song where album_id="+album_id);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return res;
    }
    public void allAlbumNames()
    {
        ResultSet res=null;

        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select * from album");
            while(res!=null)
            {
                System.out.println(res.getInt("album_id")+" "+res.getString("album_name"));
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    public ResultSet genereBasedSongs(int genere_id)
    {
        ResultSet res=null;

        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select * from song where genere_id="+genere_id);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return res;
    }
    public void allGenereNames()
    {
        ResultSet res=null;

        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select * from genere");
            while(res!=null)
            {
                System.out.println(res.getInt("genere_id")+" "+res.getString("genere_name"));
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    public void allPlaylistNames()
    {
        ResultSet res=null;

        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select * from playlist");
            while(res!=null)
            {
                System.out.println(res.getInt("playlist_id")+" "+res.getString("playlist_name"));
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    public ResultSet playlistBasedSongs(int playlist_id)
    {
        ResultSet res=null;

        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select song_id from createdPlaylist where playlist_id="+playlist_id);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return res;
    }
    public ResultSet getSongDeatils(int song_id)
    {
        ResultSet res=null;
        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select * from song where playlist_id="+song_id);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return res;
    }
    public ResultSet getWaveFile(int song_id)
    {
        ResultSet res=null;
        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select song_url from song where song_id="+song_id);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return res;
    }
    public ResultSet getWaveFile(String song_name)
    {
        ResultSet res=null;
        try
        {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            res=stmt.executeQuery("Select song_url from song where song_name="+song_name);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return res;
    }
}

package JukeBox;

import JukeBox.Beans.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class JukeBoxImpl
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        JukeBoxOperations op=new JukeBoxOperations();
        System.out.println("Hello Listeners!!");
        System.out.println("Do you wants to check our Catalog or wants to create your own playlist?");
        System.out.println("To view catalog enter 1 || To create your own playlist enter 2 || to quit enter 3");
        int ans=sc.nextInt();
        do
        {
            if(ans==1)
            {
                System.out.println("List of song of our JukeboX");
                ArrayList<Song> all=op.displayacatalog();
                whattoPlay(all);

                System.out.println("What to check other play lists of jukebox");
                System.out.println("Enter 1 for Artist pocast");
                System.out.println("Enter 2 for Album pocast");
                System.out.println("Enter 3 for genere pocast");
                System.out.println("Enter 4 for already created playlists");
                System.out.println("Enter 5 create your own playlist/podcast");
                int option= sc.nextInt();
                ArrayList<Song> al=null;
                switch (option)
                {
                    case 1:
                        al=op.displayArtistPlaylistSorted();
                        whattoPlay(al);

                        break;
                    case 2:
                        al=op.displayAlbumPlaylistSorted();
                        whattoPlay(al);
                        break;
                    case 3:
                        al=op.displayGenerePlaylistSorted();
                        whattoPlay(al);
                        break;
                    case 4:
                        al=op.displayPlaylistSorted();
                        whattoPlay(al);
                        break;
                }
            }
            else if(ans==2)
            {
                ArrayList<Song> al=op.createOwnPlaylist();
                whattoPlay(al);
            }
            System.out.println("Do you want to continue?");
            System.out.println("To view catalog enter 1 || To create your own playlist enter 2 || to quit enter 3");
            ans=sc.nextInt();

        }while(ans!=3);


    }
    public static void whattoPlay(ArrayList<Song> al)
    {
        Scanner sc=new Scanner(System.in);
        JukeBoxPlaySong pl=new JukeBoxPlaySong();
        System.out.println("Enter Song number to play to play all songs enter 0 Dont want to play from list enter -1  ");
        int whattoplay=sc.nextInt();
        if(whattoplay>0)
            pl.playSong(whattoplay);
        else if(whattoplay==0)
            pl.playAll(al);
    }
}

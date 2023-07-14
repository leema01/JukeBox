package JukeBox;

import JukeBox.Beans.Song;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.*;
public class JukeBoxPlaySong
{
        JukeBoxDao obj=new JukeBoxDao();
        public void playS(String filename) throws UnsupportedAudioFileException, IOException, LineUnavailableException
        {
            Scanner scanner = new Scanner(System.in);
            File file=new File(filename);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            String response = "";
            while(!response.equals("Q"))
            {
                System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
                System.out.print("Enter your choice: ");
                response = scanner.next();
                response = response.toUpperCase();
                switch(response)
                {

                    case ("P"): clip.start();

                        break;

                    case ("S"): clip.stop();

                        break;

                    case ("R"): clip.setMicrosecondPosition(0);

                        break;

                    case ("Q"): clip.close();

                        break;

                    default: System.out.println("Not a valid response");

                }

            }

            System.out.println("Byeeee!");

        }
        public void playSong(int song_id)
        {
            ResultSet res=obj.getWaveFile(song_id);
            try
            {
                while (res!=null)
                {
                    String furl=res.getURL("song_url").toString();
                    playS(furl);
                }
            }
            catch(Exception e)
            {
               System.out.println(e);
            }


        }
        public void playAll(ArrayList<Song> al)
        {
            for(Song s:al)
            {
                String song_name=s.getName();
                ResultSet res=obj.getWaveFile(song_name);
                try
                {
                    while (res!=null)
                    {
                        String furl=res.getURL("song_url").toString();
                        playS(furl);
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }


            }
        }

    }


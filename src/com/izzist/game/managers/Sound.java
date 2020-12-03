package com.izzist.game.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Sound {
    //
    public static String bombExplose = "data/sound/bomb_bang.wav";
    public static String startStage ="data/sound/startstage.wav";
    public static String bomberDie = "data/sound/bomber_die.wav";
    public static String item = "data/sound/item.wav";
    public static String lose = "data/sound/lose.mid";
    public static String menu = "data/sound/menu.wav";
    public static String mosterDie = "data/sound/monster_die.wav";
    public static String win = "data/sound/win.wav";
    public static String backgroundGame = "data/sound/2stepfromhell.wav";
    public static String playGame = "data/sound/playgame.mid";
    public static String destroy ="data/sound/destroy.wav";

    public Sound() {
    }



    public static void play( String filePath){
        InputStream music;
        try{

            music = new FileInputStream ( new File ( filePath) );
            AudioStream  audio = new AudioStream (music);
            AudioPlayer.player.start(audio);


        }catch(IOException e) {
            e.printStackTrace();
        }


    }

    public static void playDestroy(){
        Sound.play(destroy);
    }

    public static  void playBombExplose(){
        play(bombExplose);
    }
    public static void playStartStage(){
        Sound.play(startStage);
    }

    public static void playBomberDie(){
        Sound.play(bomberDie);
    }
    public static void playGetNewItem(){
        Sound.play(item);
    }
    public static void playLose(){
        Sound.play(lose);
    }
    public static void playMenu(){
        Sound.play(menu);
    }
    public static void playMosterDie(){
        Sound.play(mosterDie);
    }

    public static void playWin(){
        Sound.play(win);
    }

    public static void playBackGround(){
       // Sound.play(backgroundGame);
    }


}

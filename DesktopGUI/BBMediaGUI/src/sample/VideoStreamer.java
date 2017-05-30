package sample;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

public class VideoStreamer{

	public static void thingy(String mrl) throws InterruptedException{
		String media = mrl;
		String options = formatHttpStream("127.0.0.1", 7777);
		
		System.out.println("Streaming " +media  +" to " +options);
		
		try{
		MediaPlayerFactory mpf = new MediaPlayerFactory(mrl);
		HeadlessMediaPlayer mediaPlayer = mpf.newHeadlessMediaPlayer();
		
		mediaPlayer.playMedia(media, options);
		}catch(Exception e){
			e.printStackTrace();
		}
		

        Thread.currentThread().join();
	}

	private static String formatHttpStream(String serverAddress, int serverPort) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#duplicate{dst=std{access=http,mux=ts,");
        sb.append("dst=");
        sb.append(serverAddress);
        sb.append(':');
        sb.append(serverPort);
        sb.append("}}");
        return sb.toString();
    }
}

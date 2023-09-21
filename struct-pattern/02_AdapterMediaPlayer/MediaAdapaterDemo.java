interface MediaPlayer {
    public void play(String type, String fileName);
}

// Adaptee
class AdvanceMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing Vlc type " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing Mp4 type " + fileName);
    }

    public void playMp3(String fileName) {
        System.out.println("Playing Mp3 type " + fileName);
    }

    public void playAvi(String fileName) {
        System.out.println("Playing Avi type " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer adv = new AdvanceMediaPlayer();

    public void play(String type, String fileName) {
        switch (type.toLowerCase()) {
            case "vlc":
                adv.playVlc(fileName);
                break;
            case "mp3":
                adv.playMp3(fileName);
                break;
            case "mp4":
                adv.playMp4(fileName);
                break;

            default:
                throw new Error("file type not supported");

        }

    }

}

class AudioPlayer implements MediaPlayer {
    public void play(String type, String fileName) {
        // if (type.equalsIgnoreCase("vlc"))
        // System.out.println("Playing " + type + " type " + fileName);

        MediaPlayer md = new MediaAdapter();
        md.play(type, fileName);
    }
}

class MediaAdapterDemo {
    public static void main(String[] args) {
        MediaPlayer m = new AudioPlayer();
        m.play("vlc", "music1.vlc");
        m.play("mp3", "music2.mp3");
        m.play("mp4", "music3.mp4");
    }
}
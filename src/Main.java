import it.sauronsoftware.jave.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        final File src = new File("最佳损友(Concert YY 黄伟文作品展 演唱会) - 陈奕迅.mp4");
        final File target = new File("最佳损友(Concert YY 黄伟文作品展 演唱会) - 陈奕迅");
        Encoder encoder = new Encoder();
        MultimediaInfo multimediaInfo;
        try {
            multimediaInfo = encoder.getInfo(src);
//            System.out.println(multimediaInfo.getAudio().toString());
//            System.out.println(multimediaInfo.getVideo().toString());

            AudioAttributes audioAttributes = new AudioAttributes();
            audioAttributes.setBitRate(131);
            audioAttributes.setChannels(2);
            audioAttributes.setCodec("acc");

            EncodingAttributes encodingAttributes = new EncodingAttributes();
            encodingAttributes.setDuration((float) (multimediaInfo.getDuration()));
            encodingAttributes.setFormat("mp3");
            encodingAttributes.setAudioAttributes(audioAttributes);

            System.out.println(encodingAttributes.toString());
            encoder.encode(src, target, encodingAttributes);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

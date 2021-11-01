package aoto.com.ttstest;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import aoto.com.mylibrary.MediaTTSManager;
import aoto.com.mylibrary.OriginalTTSManager;
import aoto.com.mylibrary.WhyTTS;

/**
 * @author why
 * @date 2019-7-13 8:46:57
 */
public class Test1Activity extends AppCompatActivity {

    private WhyTTS whyTTS;
    private EditText ttsEditor;
    String testText="你想说啥就说啥，直接告诉我。天地有正气，杂然赋流形。下则为河岳，上则为日星。于人曰浩然，沛乎塞苍冥。\n" +
            "皇路当清夷，含和吐明庭。时穷节乃见，一一垂丹青。在齐太史简，在晋董狐笔。\n" +
            "在秦张良椎，在汉苏武节。为严将军头，为嵇侍中血。为张睢阳齿，为颜常山舌。\n" +
            "或为辽东帽，清操厉冰雪。或为出师表，鬼神泣壮烈。或为渡江楫，慷慨吞胡羯。\n" +
            "或为击贼笏，逆竖头破裂。是气所磅礴，凛烈万古存。当其贯日月，生死安足论。\n" +
            "地维赖以立，天柱赖以尊。三纲实系命，道义为之根。嗟予遘阳九，隶也实不力。\n" +
            "楚囚缨其冠，传车送穷北。鼎镬甘如饴，求之不可得。阴房阗鬼火，春院闭天黑。\n" +
            "牛骥同一皂，鸡栖凤凰食。一朝蒙雾露，分作沟中瘠。如此再寒暑，百疠自辟易。\n" +
            "哀哉沮洳场，为我安乐国。岂有他缪巧，阴阳不能贼。顾此耿耿存，仰视浮云白。\n" +
            "悠悠我心悲，苍天曷有极。哲人日已远，典刑在夙昔。风檐展书读，古道照颜色";
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsEditor=findViewById(R.id.tts_content);
        //Achieve TTS pause and resume by Android original TTS and MediaPlayer
        whyTTS= OriginalTTSManager.getInstance(this,"com.iflytek.speechcloud");
        //Achieve TTS pause and resume by Android original TTS
        //whyTTS= OriginalTTSManager.getInstance(this);
    }

    public void startTest(View view){
        if(!ttsEditor.getText().toString().isEmpty()){
            whyTTS.speak(ttsEditor.getText().toString());
        }
        else {
            whyTTS.speak(testText);
        }
    }

    public void pause(View view){
        whyTTS.pause();
    }

    public void resume(View view){
        whyTTS.resume();
    }
}

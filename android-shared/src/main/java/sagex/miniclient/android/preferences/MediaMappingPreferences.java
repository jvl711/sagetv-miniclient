package sagex.miniclient.android.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import sagex.miniclient.SageCommand;

public class MediaMappingPreferences
{

    private Context context;
    private SharedPreferences preferences;
    private String prefix;

    public MediaMappingPreferences(Context context)
    {
        this(context, "default");
    }

    public MediaMappingPreferences(Context context, String prefix)
    {
        this.context = context;
        this.prefix = prefix;
        this.preferences = PreferenceManager.getDefaultSharedPreferences(this.context);
    }

    public SageCommand getSelect()
    {
        String key = preferences.getString(prefix + "_select", SageCommand.SELECT.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getRight()
    {
        String key = preferences.getString(prefix + "_right", SageCommand.RIGHT.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getLeft()
    {
        String key = preferences.getString(prefix + "_left", SageCommand.LEFT.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getUp()
    {
        String key = preferences.getString(prefix + "_up", SageCommand.UP.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getDown()
    {
        String key = preferences.getString(prefix + "_down", SageCommand.DOWN.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getSelectLongPress()
    {
        String key = preferences.getString(prefix + "_select_long_press", SageCommand.SELECT.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getRightLongPress()
    {
        String key = preferences.getString(prefix + "_right_long_press", SageCommand.RIGHT.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getLeftLongPress()
    {
        String key = preferences.getString(prefix + "_left_long_press", SageCommand.LEFT.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getUpLongPress()
    {
        String key = preferences.getString(prefix + "_up_long_press", SageCommand.UP.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getDownLongPress()
    {
        String key = preferences.getString(prefix + "_down_long_press", SageCommand.DOWN.getKey());

        return SageCommand.parseByKey(key);
    }


    public SageCommand getPlay()
    {
        String key = preferences.getString(prefix + "_play", SageCommand.PLAY.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getPause()
    {
        String key = preferences.getString(prefix + "_pause", SageCommand.PAUSE.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getPlayPause()
    {
        String key = preferences.getString(prefix + "_playpause", SageCommand.PLAY_PAUSE.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getStop()
    {
        String key = preferences.getString(prefix + "_stop", SageCommand.STOP.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getFastForward()
    {
        String key = preferences.getString(prefix + "_fastforward", SageCommand.FF.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getRewind()
    {
        String key = preferences.getString(prefix + "_rewind", SageCommand.REW.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNextTrack()
    {
        String key = preferences.getString(prefix + "_next_track", SageCommand.FF_2.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getPreviousTrack()
    {
        String key = preferences.getString(prefix + "_previous_track", SageCommand.REW_2.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getVolumeUp()
    {
        String key = preferences.getString(prefix + "_volume_up", SageCommand.VOLUME_UP.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getVolumeDown()
    {
        String key = preferences.getString(prefix + "_volume_down", SageCommand.VOLUME_DOWN.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getMute()
    {
        String key = preferences.getString(prefix + "_mute", SageCommand.MUTE.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getChannelUp()
    {
        String key = preferences.getString(prefix + "_channel_up", SageCommand.CHANNEL_UP.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getChannelDown()
    {
        String key = preferences.getString(prefix + "_channel_down", SageCommand.CHANNEL_DOWN.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getMenu()
    {
        String key = preferences.getString(prefix + "_menu", SageCommand.OPTIONS.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getGuide()
    {
        String key = preferences.getString(prefix + "_guide", SageCommand.GUIDE.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getInfo()
    {
        String key = preferences.getString(prefix + "_info", SageCommand.INFO.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getSearch()
    {
        String key = preferences.getString(prefix + "_search", SageCommand.SEARCH.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getDelete()
    {
        String key = preferences.getString(prefix + "_delete", SageCommand.DELETE.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getYellow()
    {
        String key = preferences.getString(prefix + "_yellow", SageCommand.NONE.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getBlue()
    {
        String key = preferences.getString(prefix + "_blue", SageCommand.NONE.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getRed()
    {
        String key = preferences.getString(prefix + "_red", SageCommand.NONE.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getGreen()
    {
        String key = preferences.getString(prefix + "_green", SageCommand.NONE.getKey());

        return SageCommand.parseByKey(key);
    }

    public boolean isLongPressSelectShowOSDNav()
    {
        return preferences.getBoolean("long_press_select_for_osd_nav", true);
    }

    public SageCommand getNum0()
    {
        String key = preferences.getString(prefix + "_num_0", SageCommand.NUM0.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNum1()
    {
        String key = preferences.getString(prefix + "_num_1", SageCommand.NUM1.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNum2()
    {
        String key = preferences.getString(prefix + "_num_2", SageCommand.NUM2.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNum3()
    {
        String key = preferences.getString(prefix + "_num_3", SageCommand.NUM3.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNum4()
    {
        String key = preferences.getString(prefix + "_num_4", SageCommand.NUM4.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNum5()
    {
        String key = preferences.getString(prefix + "_num_5", SageCommand.NUM5.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNum6()
    {
        String key = preferences.getString(prefix + "_num_6", SageCommand.NUM6.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNum7()
    {
        String key = preferences.getString(prefix + "_num_7", SageCommand.NUM7.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNum8()
    {
        String key = preferences.getString(prefix + "_num_8", SageCommand.NUM8.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getNum9()
    {
        String key = preferences.getString(prefix + "_num_9", SageCommand.NUM9.getKey());

        return SageCommand.parseByKey(key);
    }

    //Game pad

    public SageCommand getA()
    {
        String key = preferences.getString(prefix + "_A", SageCommand.SELECT.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getB()
    {
        String key = preferences.getString(prefix + "_B", SageCommand.BACK.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getX()
    {
        String key = preferences.getString(prefix + "_X", SageCommand.STOP.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getY()
    {
        String key = preferences.getString(prefix + "_Y", SageCommand.INFO.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getR1()
    {
        String key = preferences.getString(prefix + "_R1", SageCommand.FF.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getR2()
    {
        String key = preferences.getString(prefix + "_R2", SageCommand.FF_2.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getL1()
    {
        String key = preferences.getString(prefix + "_R1", SageCommand.REW.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getL2()
    {
        String key = preferences.getString(prefix + "_R2", SageCommand.REW_2.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getGamepadSelect()
    {
        String key = preferences.getString(prefix + "_gp_select", SageCommand.OPTIONS.getKey());

        return SageCommand.parseByKey(key);
    }

    public SageCommand getGamepadStart()
    {
        String key = preferences.getString(prefix + "_gp_start", SageCommand.HOME.getKey());

        return SageCommand.parseByKey(key);
    }
}

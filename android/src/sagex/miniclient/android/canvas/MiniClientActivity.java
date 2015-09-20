package sagex.miniclient.android.canvas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.badlogic.gdx.Input;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import sagex.miniclient.MgrServerInfo;
import sagex.miniclient.MiniClient;
import sagex.miniclient.MiniClientConnection;
import sagex.miniclient.ServerDiscovery;
import sagex.miniclient.ServerInfo;
import sagex.miniclient.UIManager;
import sagex.miniclient.android.R;
import sagex.miniclient.android.canvas.CanvasUIManager;
import sagex.miniclient.android.canvas.UIGestureListener;
import sagex.miniclient.gl.*;
import sagex.miniclient.gl.SageTVGestureListener;
import sagex.miniclient.uibridge.Keys;
import sagex.miniclient.uibridge.UIFactory;

/**
 * Created by seans on 20/09/15.
 */
public class MiniClientActivity extends Activity {
    public static final String ARG_SERVER_INFO = "server_info";

    private static final String TAG = "MINICLIENT";
    SurfaceView surface;

    View pleaseWait = null;
    TextView plaseWaitText = null;

    CanvasUIManager mgr;
    GestureDetectorCompat mDetector = null;
    private MiniClientConnection client;

    public MiniClientActivity() {
        MiniClient.startup(new String[]{});
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.miniclient_layout);
        surface=(SurfaceView)findViewById(R.id.surface);
        pleaseWait = (View)findViewById(R.id.waitforit);
        plaseWaitText = (TextView)findViewById(R.id.pleaseWaitText);

        mgr = new CanvasUIManager(this);
        surface.getHolder().addCallback(mgr);

        System.setProperty("user.home", getCacheDir().getAbsolutePath());

        ServerInfo si = (ServerInfo) getIntent().getSerializableExtra(ARG_SERVER_INFO);
        if (si==null) {
            Log.e(TAG, "Missing SERVER INFO in Intent: " + ARG_SERVER_INFO );
            finish();
        }

        plaseWaitText.setText("Connecting to " + si.address + "...");
        setConnectingIsVisible(true);

        startMiniClient(si);
    }

    public void startMiniClient(final ServerInfo si) {
        final UIFactory factory = new UIFactory() {
            @Override
            public UIManager<?> getUIManager(MiniClientConnection conn) {
                return mgr;
            }
        };
        MgrServerInfo info = new MgrServerInfo(si.address, (si.port==0)?31099:si.port, si.locatorID);
        client = new MiniClientConnection(si.address, null, false, info, factory);

        final UIGestureListener gestureListener =new UIGestureListener(client);
        mDetector = new GestureDetectorCompat(this, gestureListener);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client.connect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Closing MiniClient Connection");

        try {
            if (client!=null) {
                client.close();
            }
        } catch (Throwable t) {
            Log.w(TAG, "Error shutting down client", t);
        }
        super.onDestroy();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mDetector!=null) {
            //Log.d(TAG, "Passing to touch event: " + event);
            mDetector.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }


    private static final Map<Integer, Integer> KEYMAP = new HashMap<>();

    static {
        KEYMAP.put(KeyEvent.KEYCODE_DPAD_UP, Keys.VK_UP);
        KEYMAP.put(KeyEvent.KEYCODE_DPAD_DOWN, Keys.VK_DOWN);
        KEYMAP.put(KeyEvent.KEYCODE_DPAD_LEFT, Keys.VK_LEFT);
        KEYMAP.put(KeyEvent.KEYCODE_DPAD_RIGHT, Keys.VK_RIGHT);
        KEYMAP.put(KeyEvent.KEYCODE_BUTTON_SELECT, Keys.VK_ENTER);
        KEYMAP.put(KeyEvent.KEYCODE_BUTTON_A, Keys.VK_ENTER);
        KEYMAP.put(KeyEvent.KEYCODE_BUTTON_B, Keys.VK_ESCAPE);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (KEYMAP.containsKey(keyCode)) {
            keyCode = KEYMAP.get(keyCode);
            client.postKeyEvent(keyCode, 0, (char)0);
        } else {
            client.postKeyEvent(keyCode, 0, (char)event.getUnicodeChar());
        }
        return super.onKeyUp(keyCode, event);
    }

    public void setConnectingIsVisible(final boolean connectingIsVisible) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pleaseWait.setVisibility((connectingIsVisible) ? View.VISIBLE : View.GONE);
            }
        });
    }
}
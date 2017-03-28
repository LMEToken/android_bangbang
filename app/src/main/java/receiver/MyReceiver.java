package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import utils.Tools;

/**
 * Created by tom on 2017/3/21.
 */

public class MyReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Tools.checkNetWorkState(context);
    }

}

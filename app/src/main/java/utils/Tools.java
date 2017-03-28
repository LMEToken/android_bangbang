package utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by tom on 2017/3/21.
 */

public class Tools {


    public static boolean NETWORK_STATE = true;

    public static void checkNetWorkState(Context context)
    {
        ConnectivityManager cn =(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cn.getActiveNetworkInfo();

        if (networkInfo ==null)
        {
            Toast.makeText(context,"无可用网络",Toast.LENGTH_LONG).show();
            NETWORK_STATE = false;

        }else
        {
            if (networkInfo.isConnected())
            {
                if(networkInfo.getType()==ConnectivityManager.TYPE_MOBILE)
                {
                    NETWORK_STATE = true;
                    Toast.makeText(context,"你正在使用手机移动网络",Toast.LENGTH_LONG).show();

                }else  if (networkInfo.getType()==ConnectivityManager.TYPE_WIFI)
                {

                    NETWORK_STATE = true;
                    Toast.makeText(context,"你正在使用WIFI",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}

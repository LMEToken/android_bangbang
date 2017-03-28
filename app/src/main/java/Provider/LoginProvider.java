package Provider;



import Model.UserModel;
import manager.NetAddress;
import utils.ApiJSONUtil;

import static manager.NetManager.post;

/**
 * Created by tom on 2017/3/21.
 */

public class LoginProvider {



    //账号密码登录
     public static UserModel login(String userID, String userPwd)
     {
         String postStr = "app_flag=i&m_id="+userID+"&m_pushid=&m_pw="+userPwd+"&m_uuid=1E883D5A-084C-411B-B109-869DB47F8453";

         String jsonStr = post(NetAddress.NET_API_LOGIN,postStr);

         UserModel user = null;

         if (jsonStr!=null)
         {
             try {

                 user = (UserModel )ApiJSONUtil.JSONToObj(jsonStr,UserModel.class);

             } catch (Exception e) {
                 e.printStackTrace();

             }
         }


         return user;
     }

}

package Model;

/**
 * Created by tom on 2017/3/21.
 */

public class UserModel {

    public String id = "";
    public String pauth = "";
    public String m_no = "";
    public String m_id = "";
    public String m_pw = "";
    public String e_state = "";
    public String e_online = "";
    public String m_nick = "";
    public String m_lang = "";
    public String target_lang = "";
    public String m_pimg = "";
//    public String m_pimgUrl = "";
    public String mpoint = "";
    public String m_voiceid = "";
    public String popupDate = "";
    public String result = "";
    public String result_msg = "";
    public String chk_app = "";
    public String show_coupon = "";


    private  static  UserModel instance = null;
    //用户单例
    public synchronized  static  UserModel getInstance()
    {
        if (instance ==null)
        {
            instance = new UserModel();
        }

        return  instance;
    }

    public static void setInstance (UserModel model)
    {
        instance = model;
    }

}

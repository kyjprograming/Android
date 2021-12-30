package com.kyj.mysnsapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    // 서버 URL 설정 ( PHP 파일 연동 )
    final static private String URL = "http://110.14.3.208/Register.php";
    private Map<String, String> map;


    public RegisterRequest(String userID, String userPassword, String userName, int userAge, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("UserID",userID);
        map.put("UserPwd", userPassword);
        map.put("UserName", userName);
        map.put("UserAge", userAge + "");

        /*
            $userID = $_POST["userID"];
            $userPassword = $_POST["userPassword"];
            $userName = $_POST["userName"];
            $userAge = $_POST["userAge"];
         */
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
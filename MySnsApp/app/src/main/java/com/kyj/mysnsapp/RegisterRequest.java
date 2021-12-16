package com.kyj.mysnsapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    // 서버 URL 설정 ( PHP 파일 연동 )
    final static private String URL = "https://110.14.3.208/Register.php";
    private Map<String, String> map;


    public RegisterRequest(String UserID, String UserPwd, String UserName, int UserProfillname, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("UserID",UserID);
        map.put("UserPwd", UserPwd);
        map.put("UserName", UserName);
        map.put("UserProfillname", UserProfillname + "");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
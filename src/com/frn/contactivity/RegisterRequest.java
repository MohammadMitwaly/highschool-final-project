package com.frn.contactivity;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class RegisterRequest extends StringRequest{
	
	private static final String REGISTER_REQUEST_URL = "http://mohammadmitwaly.comxa.com/Register.php";
    private Map<String, String> params;
    
    public RegisterRequest(String username, String mainemail, String secondaryemail, String mainphone, String secondaryphone, String password, Response.Listener<String> listener){
    	
    	super(Method.POST, REGISTER_REQUEST_URL, listener, null);
    	params = new HashMap<String, String>();
    	params.put("username", username);
    	params.put("mainemail", mainemail);
    	params.put("secondaryemail", secondaryemail);
    	params.put("mainphone", mainphone);
    	params.put("secondaryphone", secondaryphone);
    	params.put("password", password);
    }
    @Override
    public Map<String, String> getParams(){
    	return params;
    
    }
}

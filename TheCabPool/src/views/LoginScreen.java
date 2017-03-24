package views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.groupten.thecabpool.R;

import controllers.SecurityController;

public class LoginScreen extends Activity{

	private static EditText txtUsername;
	private static EditText txtPassword;
	private static Button btnSubmit;
	private static TextView lblMessage;
	private static String username, password, gender, age;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
		
		txtUsername = (EditText) findViewById(R.id.txtLoginUsername);
		txtPassword = (EditText) findViewById(R.id.txtLoginPassword);
		btnSubmit = (Button) findViewById(R.id.btnLoginSubmit);
		lblMessage = (TextView) findViewById(R.id.lblLoginMessage);
		
		SecurityController controller = new SecurityController(this);
		
		btnSubmit.setOnClickListener(controller);
	}
	


	public static String getUsername(){
		return txtUsername.getText().toString();
	}
	
	public static String getPassword(){
		return txtPassword.getText().toString();
	}
	
	public static void setLoginData(String user, String pass){
		username = user;
		password = pass;
	}
	
	public static void setUserData(String newGender, String newAge){
		if(newGender.equals("m")) gender = "Male";
		if(newGender.equals("f")) gender = "Female";
		age = newAge;
		Log.d("gender", newGender);
		Log.d("age", newAge);
	}
	
	public static String[] getLoginData(){
		String data[] = {username, password, gender, age};
		return data;
	}
	
	public void closeScreen(){
		finish();
	}
}
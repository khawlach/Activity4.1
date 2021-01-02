package com.example.myapplication41;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private String mPreferences;
    private SharedPreferences.Editor mEditor;
    private EditText mName,mPassword;
    private Button btnLogin;
    private CheckBox mCheckBox;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName=(EditText)findViewById(R.id.etName);
        mPassword=(EditText)findViewById(R.id.etPassword);
        btnLogin=(Button)findViewById(R.id.btnlogin);
        mCheckBox=(CheckBox)findViewById(R.id.checkbox);


            mPreferences= PreferenceManager.getDefaultSharedPreferencesName(this);

       // mPreferences=getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor=mPreferences.edit();
        checkboxSharedPreferences();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBox.isChecked()){
                    mEditor.putString(getString(R.string.checkbox),"true");
                    mEditor.commit();
                    //save the name
                    String name =mName.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit();
                    //save password
                    String password =mName.getText().toString();
                    mEditor.putString(getString(R.string.password),password);
                    mEditor.commit();


                }else {
                    mEditor.putString(getString(R.string.checkbox),"False");
                    mEditor.commit();
                    //save the name

                    mEditor.putString(getString(R.string.name),"");
                    mEditor.commit();
                    //save password
                   
                    mEditor.putString(getString(R.string.password),"");
                    mEditor.commit();


                }
            }
        });

    }
    private void checkboxSharedPreferences(){
        String checkbox =mPreferences.getString(getString(R.string.checkbox),"False");
        String name =mPreferences.getString(getString(R.string.name),"");
        String password =mPreferences.getString(getString(R.string.password),"");
        mName.setText(name);
        mPassword.setText(password);
        if (checkbox.equals("true")){
            mCheckBox.setChecked(true);

        }else {
            mCheckBox.setChecked(false);
        }
    }
}
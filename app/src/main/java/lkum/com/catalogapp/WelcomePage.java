package lkum.com.catalogapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }

    public void toMainPage(View v) {
        // does something very interesting
        Toast toast = Toast.makeText(this, "Redirecting to Main Page", Toast.LENGTH_SHORT);
        toast.show();
        Intent myIntent = new Intent(WelcomePage.this,
                MainPage.class);
        startActivity(myIntent);
        //startActivity(myIntent);
    }
}

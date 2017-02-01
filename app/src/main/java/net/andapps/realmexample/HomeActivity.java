package net.andapps.realmexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import io.realm.Realm;

import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        welcome = ((TextView) findViewById(R.id.welcome_text));

        String name = getIntent().getStringExtra("username");

        Realm realm = Realm.getDefaultInstance();


        User user = realm.where(User.class).equalTo("name", name).findFirst();

        LoginDate loginDate =  new LoginDate();
        loginDate.setDate(new Date());
        realm.beginTransaction();
        user.getMyList().add(loginDate);
        realm.commitTransaction();

        List<User> users = realm.where(User.class).findAll();

        welcome.setText("Welcome back " +
                user.getName() +
                " \n" +
                "There are " +
                users.size() +
                " users in this app");

        Toast.makeText(getApplicationContext(), "hey ho!", Toast.LENGTH_LONG).show();

    }
}

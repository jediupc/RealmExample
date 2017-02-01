package net.andapps.realmexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import io.realm.Realm;

import static net.andapps.realmexample.R.id.user;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginButton;
    EditText name;
    EditText pass;

    String username = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = ((EditText) findViewById(user));
        pass = ((EditText) findViewById(R.id.password));
        loginButton = ((Button) findViewById(R.id.sign_in));
        loginButton.setOnClickListener(this);
    }

    private void navigateToHome() {
        startActivity(new Intent(this, HomeActivity.class)
                .putExtra("username", username));
    }

    private void createRealmUser() {
        Realm realm = Realm.getDefaultInstance();

        User user = new User();
        user.getMyList().add(new LoginDate());
        username = name.getText().toString();
        user.setName(username);
        user.setPass(pass.getText().toString());

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
    }

    @Override
    public void onClick(View view) {
        createRealmUser();
        navigateToHome();
    }
}


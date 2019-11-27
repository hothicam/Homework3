package com.example.room_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView Name,Name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.tvName);
        Name1 = findViewById(R.id.tvName1);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();



        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                User user = new User("Nam");
                User user1 = new  User("Hoa");
                db.userDao().insert(user);
                db.userDao().insert(user1);

                List<User> users = db.userDao().getAll();
                Log.i("TAGss", "size" +users.size());
                displayUser(users);
                return null;
            }
        }.execute();
    }

    void  displayUser(List<User> users){
        User user = users.get(0);
        Name.setText(user.name);

    }
}

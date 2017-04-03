package com.example.abe.firebasetest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import com.firebase.client.DataSnapshot;
//import com.firebase.client.Firebase;
//import com.firebase.client.FirebaseError;
//import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

//    private Firebase mFirebaseRef;
//    private Firebase mChild;

    private static final String url1 = "https://project-1941426662122637973.firebaseio.com/";
    private static final String url2 = "https://myfirstapp-cc2d4.firebaseio.com/";
    private static final String url3 = "https://project-5470807327983073781.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.button100);
        Button btn2 = (Button)findViewById(R.id.button200);
        btn1.setText(url1);
        btn2.setText(url2);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new TweetListFragment();
//        fragmentTransaction.replace(R.id.container, fragment);
//        fragmentTransaction.addToBackStack(null); // 戻るボタンでreplace前に戻る
//        fragmentTransaction.commit();

        // クライアントライブラリにコンテキスト(Activity)をセットします。
        //Firebase.setAndroidContext(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth auth = FirebaseAuth.getInstance();

            try {
                    FirebaseOptions options = new FirebaseOptions.Builder()
                    //.setApplicationId("1:530266078999:android:481c4ecf3253701e") // Required for Analytics.
                     .setApiKey("AIzaSyBRxOyIj5dJkKgAVPXRLYFkdZwh2Xxq51k") // Required for Aut
                            .setDatabaseUrl("https://project-1765055333176374514.firebaseio.com/") // Required for RTDB.
            .build();
            }catch(Exception e){
                    Log.v("abe", e.getMessage().toString());
                    return;
            }
                //auth.initialize(this /* Context */, options, "secondary");



                auth.createUserWithEmailAndPassword("aaa@gmail.com", "password")
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                FirebaseUser user = authResult.getUser();
                                String str1 = user.getEmail();
                                String str2 = user.getUid();
                                Log.v("abe", str1 + " " + str2);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.v("abe", e.getMessage().toString());
                            }
                        });
                /*
                mFirebaseRef = new Firebase(url1);
                mFirebaseRef.createUser("aaa@gmail.com", "abcd1234", new Firebase.ResultHandler() {
                    @Override
                    public void onSuccess() {
                        Log.d("aaa", "Successfully created user account with uid: ");
                    }
                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Log.d("bbb", "error: " + firebaseError.getMessage());
                    }
                });
                mChild = mFirebaseRef.child("messages");
                mChild.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Log.v("abe", snapshot.toString());
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            //String sender = (String) dataSnapshot.child("0").getValue();
                            String sender = (String) dataSnapshot.getKey();
                            Object value = (Object)dataSnapshot.getValue();
                            Log.v("abe", String.format("name:%s, body:%s", sender, value.toString()));
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError error) {
                    }
                });
                */
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setApplicationId("1:530266078999:android:481c4ecf3253701e") // Required for Analytics.
                    .setApiKey("AIzaSyC7TEHvvtuI25EgdVIaFZNKUaB0WeKtNuw") // Required for Auth.
                    .setDatabaseUrl(url2) // Required for RTDB.
                    .build();
        }catch(Exception e){
            Log.v("abe", e.getMessage().toString());
            return;
        }
        FirebaseApp.initializeApp(getApplicationContext() /* Context */, options, "secondary");

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {


                                        FirebaseApp app = FirebaseApp.getInstance("secondary");
// Get the database for the other app.
                                        DatabaseReference ref = FirebaseDatabase.getInstance(app).getReference();
                                        DatabaseReference mChild = ref.child("messages");
                                        mChild.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot snapshot) {
                                                Log.v("abe", snapshot.toString());
                                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                    //String sender = (String) dataSnapshot.child("0").getValue();
                                                    String sender = (String) dataSnapshot.getKey();
                                                    Object value = (Object) dataSnapshot.getValue();
                                                    Log.v("abe", String.format("name:%s, body:%s", sender, value.toString()));
                                                }
                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {

                                            }

                                        });
                                    }
                                });

            Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener(){
                int num;
                @Override
                public void onClick (View view){
//                Map<String, String> data = new HashMap<String, String>();
//                data.put(String.valueOf(num++), "Hello");
//                data.put(String.valueOf(num++), "Hello");
//                data.put(String.valueOf(num++), "Hello");
//                mChild.setValue(data, new Firebase.CompletionListener() {
//                    public void onComplete(FirebaseError error, Firebase ref) {
//                        Toast.makeText(getApplicationContext(), ref.toString(), Toast.LENGTH_SHORT).show();
//                    };
//                });
            }
            });
    }
}
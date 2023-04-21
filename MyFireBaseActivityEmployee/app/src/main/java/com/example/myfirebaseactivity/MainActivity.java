package com.example.myfirebaseactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAINACTIVITY";
    DatabaseReference myRef;
    private TextView displayText;
    private EditText fname;
    private EditText lname;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.firstNameText);
        lname = findViewById(R.id.lastNameText);
        displayText = findViewById(R.id.displayText);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

         myRef = database.getReference("employees");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Employee
                String result ="";
                Employee temp;
                counter = 0;
                for(DataSnapshot ds: snapshot.getChildren()){
                    temp = (Employee)ds.getValue(Employee.class);
                    result+= temp.getFirstName() + " " + temp.getlastName() + "\n";
                    counter++;
                }
                displayText.setText(result);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    public void addEmployee(View view){
        String firstName = fname.getText().toString();
        String lastName = lname.getText().toString();
        if(firstName.equals("")||lastName.equals("")){
            return;
        }
        Employee temp = new Employee(firstName,lastName);
        myRef.child(""+counter).setValue(temp);
        fname.setText("");
        lname.setText("");
    }
}
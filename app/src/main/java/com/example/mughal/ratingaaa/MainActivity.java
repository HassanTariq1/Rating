package com.example.mughal.ratingaaa;

import android.database.Cursor;
import android.os.ParcelUuid;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper data;

    EditText txt1;
    EditText txt2;
    Button add, view;
    RatingBar rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    data=new DatabaseHelper(this);
txt1=(EditText)findViewById(R.id.editText);
txt2=(EditText)findViewById(R.id.editText2);
rate=(RatingBar)findViewById(R.id.ratingBar);

        view=(Button)findViewById(R.id.btnView);

add=(Button)findViewById(R.id.btnAdd);
addData(); ViewAll();


        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                txt2.setText("Your rating is: " + rate.getRating());

            }

        });

    }

    public  void addData(){

add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

boolean isin= data.insertData(txt1.getText().toString());
if (isin==true){
    Toast.makeText(MainActivity.this,"DATA insert",Toast.LENGTH_SHORT).show();


}else {    Toast.makeText(MainActivity.this,"DATA nott insert",Toast.LENGTH_SHORT).show();
}


    }
});




    }
    public  void  ViewAll(){

view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {



        Cursor resl=data.getDATA();
        if (resl.getCount()==0) {

            return;
        }
StringBuffer buffer= new StringBuffer();
        while (resl.moveToNext()){
            buffer.append("ID:"+resl.getString(0)+"\n");
            buffer.append("NAME:"+resl.getString(0)+"\n");
            buffer.append("RATING:"+resl.getString(0)+"\n");

        }


    }
});


    }

public  void  message(String title, String message){
    AlertDialog.Builder build= new AlertDialog.Builder(this);
            build.setCancelable(true);
            build.setTitle(title);
            build.setMessage(message);
            build.show();






}
}

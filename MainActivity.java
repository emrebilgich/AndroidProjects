package com.bilgic.alertdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Toast Message", Toast.LENGTH_LONG).show();
    }

    public void save(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

        alert.setTitle("Save");
        alert.setMessage("Are you sure?");
        alert.setPositiveButton("Yes", (dialog, which) -> {
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            dialog.dismiss();
        });

        alert.setNegativeButton("No", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "Not Saved", Toast.LENGTH_LONG).show();
            dialog.dismiss();
        });

        alert.show();
    }
}

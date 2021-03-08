package dk.easj.anbo.preferenceexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLoad(View view) {
        Intent intent = new Intent(this, AppPreferenceActivity.class);
        startActivity(intent);
    }

    public void onClickDisplay(View view) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        Map<String, ?> map = pref.getAll();
        Log.d("MINE", map.toString());
        Toast.makeText(this, map.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickModify(View view) {
        EditText editText = findViewById(R.id.txtString);
        String str = editText.getText().toString();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("editTextPref", str);
        editor.apply();
    }
}

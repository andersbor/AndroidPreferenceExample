package dk.easj.anbo.preferenceexample;

import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AppPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_app_preference);
        // addPreferencesFromResource(R.xml.myapppreferences); // deprecated
        // http://alvinalexander.com/android/android-tutorial-preferencescreen-preferenceactivity-preferencefragment
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new MyPreferenceFragment())
                .commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.myapppreferences);
        }
    }
}

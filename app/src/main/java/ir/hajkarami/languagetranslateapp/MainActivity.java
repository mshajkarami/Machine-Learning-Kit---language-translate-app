package ir.hajkarami.languagetranslateapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DiffUtil;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.mlkit.nl.translate.TranslateLanguage;

public class MainActivity extends AppCompatActivity {

    private Spinner fromSpinner, toSpinner;
    private TextInputEditText sourceEdt;
    private ImageView micIV;
    private MaterialButton translateBtn;
    private TextView translatedTV;
    // Source Array of String - Spinners' Data
    String[] fromLanguages = {"from", "English", "Afrikaans", "Arabic", "Belarusian", "Bengali", "Catalan", "Czech", "Welsh", "Hindi", "Urdu"};
    String[] toLanguages = {"from", "English", "Afrikaans", "Arabic", "Belarusian", "Bengali", "Catalan", "Czech", "Welsh", "Hindi", "Urdu"};
    private static final int REQUEST_PERMISSION_CODE = 1;
    String languageCode, fromLanguageCode, toLanguageCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fromSpinner = findViewById(R.id.idFromSpinner);
        toSpinner = findViewById(R.id.idToSpinner);
        sourceEdt = findViewById(R.id.idEdtSource);
        micIV = findViewById(R.id.idIVMic);
        translateBtn = findViewById(R.id.idBtnTranslate);
        translatedTV = findViewById(R.id.idTvTranslatedTV);

        fromSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fromLanguageCode = getLanguageCode(fromLanguages[position]);
            }
        });

        ArrayAdapter fromAdapter = new ArrayAdapter(this, R.layout.spinner_item, fromLanguages);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(fromAdapter);
    }

    private String getLanguageCode(String language) {
        String LanguageCode;
        switch (language) {
            case "English":
                LanguageCode = TranslateLanguage.ENGLISH;
                break;
            case "Afrikaans":
                LanguageCode = TranslateLanguage.AFRIKAANS;
                break;
            case "Arabic":
                LanguageCode = TranslateLanguage.ARABIC;
                break;
            case "Belarusian":
                LanguageCode = TranslateLanguage.BELARUSIAN;
                break;
            case "Bengali":
                LanguageCode = TranslateLanguage.BENGALI;
                break;
            case "Catalan":
                LanguageCode = TranslateLanguage.CATALAN;
                break;
            case "Czech":
                LanguageCode = TranslateLanguage.CZECH;
                break;
            case "Welsh":
                LanguageCode = TranslateLanguage.WELSH;
                break;
            case "Hindi":
                LanguageCode = TranslateLanguage.HINDI;
                break;
            case "Urdu":
                LanguageCode = TranslateLanguage.URDU;
                break;
            default:
                LanguageCode = "";
        }
        return LanguageCode;
    }
}
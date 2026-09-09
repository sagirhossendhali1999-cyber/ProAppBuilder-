package com.besome.sketch;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import pro.sketchware.R;
import pro.sketchware.managers.SdkManager;

public class SdkSettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sdk_settings);

        EditText etCompile = findViewById(R.id.et_compile);
        EditText etTarget = findViewById(R.id.et_target);
        EditText etMin = findViewById(R.id.et_min);
        Button btnSave = findViewById(R.id.btn_save);

        SdkManager sdk = new SdkManager(this);
        etCompile.setText(String.valueOf(sdk.getCompileSdk()));
        etTarget.setText(String.valueOf(sdk.getTargetSdk()));
        etMin.setText(String.valueOf(sdk.getMinSdk()));

        btnSave.setOnClickListener(v -> {
            try {
                int c = Integer.parseInt(etCompile.getText().toString().trim());
                int t = Integer.parseInt(etTarget.getText().toString().trim());
                int m = Integer.parseInt(etMin.getText().toString().trim());
                sdk.setSdks(c, t, m);
                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
                finish();
            } catch (Exception e) {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

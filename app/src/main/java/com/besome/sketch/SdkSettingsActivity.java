package com.besome.sketch;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.besome.sketch.R;

public class SdkSettingsActivity extends AppCompatActivity {
    EditText etCompile, etTarget, etMin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sdk_settings);
        etCompile = findViewById(R.id.et_compile);
        etTarget = findViewById(R.id.et_target);
        etMin = findViewById(R.id.et_min);
        Button btnSave = findViewById(R.id.btn_save);
        etCompile.setText(String.valueOf(SdkManager.getCompile(this)));
        etTarget.setText(String.valueOf(SdkManager.getTarget(this)));
        etMin.setText(String.valueOf(SdkManager.getMin(this)));
        btnSave.setOnClickListener(v -> {
            try {
                int c = Integer.parseInt(etCompile.getText().toString());
                int t = Integer.parseInt(etTarget.getText().toString());
                int m = Integer.parseInt(etMin.getText().toString());
                SdkManager.saveSdk(this, c, t, m);
                Toast.makeText(this, "SDK Saved: " + t, Toast.LENGTH_LONG).show();
                finish();
            } catch (Exception e){
                Toast.makeText(this, "Enter valid number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

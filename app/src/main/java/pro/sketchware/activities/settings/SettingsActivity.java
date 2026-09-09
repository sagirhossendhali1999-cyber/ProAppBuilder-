package pro.sketchware.activities.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import com.besome.sketch.SdkSettingsActivity;
import com.besome.sketch.lib.base.BaseAppCompatActivity;

import pro.sketchware.databinding.ActivitySettingsBinding;
import pro.sketchware.fragments.settings.appearance.SettingsAppearanceFragment;
import pro.sketchware.fragments.settings.block.selector.BlockSelectorManagerFragment;
import pro.sketchware.fragments.settings.events.EventsManagerFragment;

public class SettingsActivity extends BaseAppCompatActivity {

    public static final String FRAGMENT_TAG_EXTRA = "fragment_tag";
    public static final String SETTINGS_APPEARANCE_FRAGMENT = "settings_appearance";
    public static final String EVENTS_MANAGER_FRAGMENT = "events_manager";
    public static final String BLOCK_SELECTOR_MANAGER_FRAGMENT = "block_selector_manager";
        public static final String SETTINGS_SDK_FRAGMENT = "settings_sdk";
    private ActivitySettingsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        enableEdgeToEdgeNoContrast();
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String fragmentTag = getIntent().getStringExtra(FRAGMENT_TAG_EXTRA);
                if ("settings_sdk".equals(fragmentTag)) {
            startActivity(new Intent(this, SdkSettingsActivity.class));
            finish();
            return;
                }
    
    
    
    Fragment fragment = switch (fragmentTag) {
            case SETTINGS_APPEARANCE_FRAGMENT -> new SettingsAppearanceFragment();
            case EVENTS_MANAGER_FRAGMENT -> new EventsManagerFragment();
            case BLOCK_SELECTOR_MANAGER_FRAGMENT -> new BlockSelectorManagerFragment();
            default -> throw new IllegalArgumentException("Unknown fragment tag: " + fragmentTag);
        };

        openFragment(fragment);
    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.settingsFragmentContainer.getId(), fragment)
                .commit();
    }
}

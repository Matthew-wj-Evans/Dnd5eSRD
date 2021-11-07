package ca.nait.dnd5esrd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import ca.nait.dnd5esrd.activities.AttributeActivity;
import ca.nait.dnd5esrd.activities.ClassActivity;
import ca.nait.dnd5esrd.activities.HitDieActivity;
import ca.nait.dnd5esrd.activities.SkillActivity;
import ca.nait.dnd5esrd.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pages_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.menu_item_activity_attribute: {
                intent = new Intent(this, AttributeActivity.class);
                break;
            }
            case R.id.menu_item_activity_class: {
                intent = new Intent(this, ClassActivity.class);
                break;
            }
            case R.id.menu_item_activity_skill: {
                intent = new Intent(this, SkillActivity.class);
                break;
            }
            case R.id.menu_item_activity_hitdie: {
                intent = new Intent(this, HitDieActivity.class);
                break;
            }
            default :
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return true;
    }

    public void onClick(View view) {

    }
}
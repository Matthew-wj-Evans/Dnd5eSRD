package ca.nait.dnd5esrd.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import ca.nait.dnd5esrd.database.DatabaseHelper;
import ca.nait.dnd5esrd.databinding.ActivityAttributeBinding;
import ca.nait.dnd5esrd.entities.Attribute;
import ca.nait.dnd5esrd.adapters.AttributeRecyclerViewAdapter;

public class AttributeActivity extends AppCompatActivity {

    private ActivityAttributeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAttributeBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        rebindRecyclerView();
    }

    private void rebindRecyclerView() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        List<Attribute> attributes = dbHelper.getAttributesList();
        AttributeRecyclerViewAdapter adapter = new AttributeRecyclerViewAdapter(this, attributes);
        binding.activityAttributeAttributesRecycler.setAdapter(adapter);
        binding.activityAttributeAttributesRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onSave(View view) {
        String attributeName = binding.activityAttributeAttributenameTextview.getText().toString();
        if (!attributeName.isEmpty()) {
            Attribute newAttribute = new Attribute();
            newAttribute.setName(attributeName);
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            long attributeId = dbHelper.addAttribute(newAttribute);
            Toast.makeText(this, String.format(Locale.CANADA,"Attribute created with an Id of %d", attributeId), Toast.LENGTH_SHORT).show();
            rebindRecyclerView();
        } else {
            Toast.makeText(this, "Attribute name cannot be empty", Toast.LENGTH_SHORT).show();
        }


    }

    public void updateAttribute(int id, Attribute attribute) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        if (dbHelper.updateAttribute(id, attribute) > 0) {
            rebindRecyclerView();
            Toast.makeText(this, "Update successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show();
        }
    }
}
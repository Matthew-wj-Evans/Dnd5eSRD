package ca.nait.dnd5esrd.dialogs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ca.nait.dnd5esrd.activities.AttributeActivity;
import ca.nait.dnd5esrd.R;
import ca.nait.dnd5esrd.entities.Attribute;

public class DialogAttributeEdit extends DialogFragment {
    private Attribute attribute;
    private AttributeActivity parentActivity;

    public DialogAttributeEdit(Attribute attribute, AttributeActivity parentActivity) {
        this.attribute = attribute;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstance) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.dialog_attribute_edit, null);

        EditText attributeNameEditText = dialogView.findViewById(R.id.dialog_attribute_edit_name_edittext);
        attributeNameEditText.setText(attribute.getName());
        attributeNameEditText.requestFocus();

        Button cancelButton = dialogView.findViewById(R.id.dialog_attribute_edit_cancel_button);
        Button saveButton = dialogView.findViewById(R.id.dialog_attribute_edit_save_button);

        cancelButton.setOnClickListener(view -> {
            Toast.makeText(getActivity(), "Edit cancelled", Toast.LENGTH_SHORT).show();
            dismiss();
        });

        saveButton.setOnClickListener(view -> {
            String attributeName = attributeNameEditText.getText().toString();
            if (!attributeName.isEmpty()) {
                attribute.setName(attributeName);
                parentActivity.updateAttribute(attribute.getId(), attribute);
                dismiss();
            } else {
                Toast.makeText(getActivity(), "Attribute name is required.", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(dialogView).setTitle("Edit Attribute");
        return builder.create();
    }

}
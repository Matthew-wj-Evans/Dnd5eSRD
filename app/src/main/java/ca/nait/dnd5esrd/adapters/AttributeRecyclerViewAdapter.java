package ca.nait.dnd5esrd.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import ca.nait.dnd5esrd.R;
import ca.nait.dnd5esrd.entities.Attribute;

public class AttributeRecyclerViewAdapter extends RecyclerView.Adapter<AttributeRecyclerViewAdapter.AttributeViewHolder>{

    private Context context;
    private List<Attribute> attributes;

    public AttributeRecyclerViewAdapter(Context context, List<Attribute> attributes){
        this.context = context;
        this.attributes = attributes;
    }

    public void addItem(Attribute newAttribute) {
        this.attributes.add(newAttribute);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AttributeRecyclerViewAdapter.AttributeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_attribute, parent, false);
        AttributeViewHolder viewHolder = new AttributeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttributeRecyclerViewAdapter.AttributeViewHolder holder, int position) {
        Attribute currentAttribute = attributes.get(position);
        holder.attributeIdTextView.setText("" + currentAttribute.getId());
        holder.attributeNameTextView.setText(currentAttribute.getName());
    }

    @Override
    public int getItemCount() {
        return attributes.size();
    }

    public class AttributeViewHolder extends RecyclerView.ViewHolder {
        TextView attributeIdTextView;
        TextView attributeNameTextView;

        public AttributeViewHolder(@NonNull View itemView) {
            super(itemView);

            attributeIdTextView = itemView.findViewById(R.id.list_item_attribute_id_textview);
            attributeNameTextView = itemView.findViewById(R.id.list_item_attribute_name_textview);

        }
    }
}

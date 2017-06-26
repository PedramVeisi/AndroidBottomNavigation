package si.vei.pedram.bottomnavigation.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import si.vei.pedram.bottomnavigation.R;
import si.vei.pedram.bottomnavigation.model.GlobalCreateRowItem;

public class GlobalCreateAdapter extends ArrayAdapter<GlobalCreateRowItem> {

    private final int resourceId;
    Context context;

    public GlobalCreateAdapter(Context context, int resourceId,
                                 List<GlobalCreateRowItem> items) {
        super(context, resourceId, items);
        this.context = context;
        this.resourceId = resourceId;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        GlobalCreateRowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(resourceId, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.row_global_create_text);
            holder.imageView = (ImageView) convertView.findViewById(R.id.row_global_create_icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtTitle.setText(rowItem.getRowTtile());
        holder.imageView.setImageResource(rowItem.getImageResId());

        return convertView;
    }
}
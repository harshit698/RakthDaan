package com.example.dellpc.bloodbank;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class padapter extends ArrayAdapter<Person> {
    private Context mcontext;
    int mresource;
    private int lastPosition = -1;
    private static class ViewHolder {
        TextView namee;
        TextView blood;
    }

    public padapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        mcontext = context;
        mresource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String blood = getItem(position).getBlood();
        Person person=new Person(name,blood);
        final View result;
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mcontext);
            convertView = inflater.inflate(mresource, parent, false);
            holder= new ViewHolder();
            holder.namee = (TextView) convertView.findViewById(R.id.nameee);
            holder.blood = (TextView) convertView.findViewById(R.id.blooo);
            result = convertView;
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        Animation animation = AnimationUtils.loadAnimation(mcontext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.namee.setText(person.getName());
        holder.blood.setText(person.getBlood());
        return convertView;
    }
}

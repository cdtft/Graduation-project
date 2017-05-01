package com.cdut.shici.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cdut.shici.R;
import com.cdut.shici.javabean.User;

import java.util.List;

/**
 * Created by 城 on 2017/3/27.
 */

public class MyUserAdapter extends BaseAdapter {

    private List<User> mUserList;
    private Context mContext;

    public MyUserAdapter(Context context, List<User> userList){
        this.mUserList = userList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mUserList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view;
        if(convertView == null){
            view = View.inflate(mContext, R.layout.user_item, null);
            TextView username = (TextView) view.findViewById(R.id.tv_username);

            TextView currentnumber = (TextView) view.findViewById(R.id.current_number);

            User user = mUserList.get(position);
            currentnumber.setText(user.getCurrent().toString());
            username.setText(user.getUsername());
        } else{
            view = convertView;
        }

        return view;
    }
}

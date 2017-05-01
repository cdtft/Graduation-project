package com.cdut.shici.fragment;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cdut.shici.R;
import com.cdut.shici.adapter.MyUserAdapter;
import com.cdut.shici.javabean.Poetry;
import com.cdut.shici.javabean.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class Rank extends Fragment {

    private List<User> userList = new ArrayList<>();

    @BindView(R.id.tx_rankName_1)
    TextView rankName_1;
    @BindView(R.id.tx_rankName_2)
    TextView rankName_2;
    @BindView(R.id.tx_rankName_3)
    TextView rankName_3;
    @BindView(R.id.tx_rankName_4)
    TextView rankName_4;
    @BindView(R.id.tx_rankName_5)
    TextView rankName_5;
    @BindView(R.id.tx_rankName_6)
    TextView rankName_6;
    @BindView(R.id.tx_rankName_7)
    TextView rankName_7;
    @BindView(R.id.tx_rankName_8)
    TextView rankName_8;
    @BindView(R.id.tx_rankName_9)
    TextView rankName_9;
    @BindView(R.id.tx_rankName_10)
    TextView rankName_10;
    @BindView(R.id.tx_rankNum_1)
    TextView rankNum_1;
    @BindView(R.id.tx_rankNum_2)
    TextView rankNum_2;
    @BindView(R.id.tx_rankNum_3)
    TextView rankNum_3;
    @BindView(R.id.tx_rankNum_4)
    TextView rankNum_4;
    @BindView(R.id.tx_rankNum_5)
    TextView rankNum_5;
    @BindView(R.id.tx_rankNum_6)
    TextView rankNum_6;
    @BindView(R.id.tx_rankNum_7)
    TextView rankNum_7;
    @BindView(R.id.tx_rankNum_8)
    TextView rankNum_8;
    @BindView(R.id.tx_rankNum_9)
    TextView rankNum_9;
    @BindView(R.id.tx_rankNum_10)
    TextView rankNum_10;

    public Rank() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        ButterKnife.bind(this, view);
        Bmob.initialize(getContext(), "85de6ff456a4d4331d15542f8a3b4bf9");
        //查询排名
        queryUserOrderByCurrent();
        return view;
    }


    /*
    * 初始化排名
    * */
    private void initRank(List<User> list) {
        rankName_1.setText(list.get(0).getUsername());
        rankNum_1.setText("1");
        rankName_2.setText(list.get(1).getUsername());
        rankNum_2.setText("2");
        rankName_3.setText(list.get(2).getUsername());
        rankNum_3.setText("3");
        rankName_4.setText(list.get(3).getUsername());
        rankNum_4.setText("4");
        rankName_5.setText(list.get(4).getUsername());
        rankNum_5.setText("5");
        rankName_6.setText(list.get(5).getUsername());
        rankNum_6.setText("6");
        rankName_7.setText(list.get(6).getUsername());
        rankNum_7.setText("7");
        rankName_8.setText(list.get(7).getUsername());
        rankNum_8.setText("8");
        rankName_9.setText(list.get(8).getUsername());
        rankNum_9.setText("9");
        rankName_10.setText(list.get(9).getUsername());
        rankNum_10.setText("10");

    }


    /*
    *刷新排名
    * */
    @OnClick(R.id.btn_refresh)
    public void refreshRank() {
        queryUserOrderByCurrent();
    }

    /*
    * 获取全球排名
    * */
    private void queryUserOrderByCurrent() {
        /*String bql = "select * from _User order by current limit 10";
        new BmobQuery<User>().doSQLQuery(bql, new SQLQueryListener<User>() {
            @Override
            public void done(BmobQueryResult<User> bmobQueryResult, BmobException e) {
                if (e == null) {
                    userList = bmobQueryResult.getResults();
                    initRank(userList);
                }
            }
        });*/
        BmobQuery<User> query = new BmobQuery<>();
        query.setLimit(10);
        query.order("-current");
        query.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if(e == null){
                    initRank(list);
                }
            }
        });

    }

}

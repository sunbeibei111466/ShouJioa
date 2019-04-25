package project01.shoujioa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView head_name_text;
    private Button quit_button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_discovery, container,false);
        initview();

        return view;
    }

    private void initview() {
        SharedPreferences sp=getContext().getSharedPreferences("abc",0);
        String name = sp.getString("name", "");
        head_name_text = view.findViewById(R.id.head_name_text);
        head_name_text.setText(name);
        quit_button = view.findViewById(R.id.quit_button);//退出登录
        quit_button.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        if (v==quit_button){//退出登录
            SharedPreferences sp=getContext().getSharedPreferences("abc",0);
            SharedPreferences.Editor edit = sp.edit();
            edit.clear();
            edit.commit();
            startActivity(new Intent(getContext(),login_Sign_in.class));
            getActivity().finish();
        }

    }
}

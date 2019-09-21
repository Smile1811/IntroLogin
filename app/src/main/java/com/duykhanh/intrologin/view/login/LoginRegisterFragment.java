package com.duykhanh.intrologin.view.login;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.duykhanh.intrologin.R;
import com.duykhanh.intrologin.presenter.login.PresenterLogin;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginRegisterFragment extends Fragment implements View.OnClickListener, ViewLoginListener {

    private TextView tvLogin;
    private TextView tvRegister;
    public EditText edtUsername;
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLoginRegister;

    // tang presenter
    private PresenterLogin presenterLogin;

    public LoginRegisterFragment() {
        // Required empty public constructor
    }

    public static LoginRegisterFragment newInstance() {
        LoginRegisterFragment loginRegisterFragment = new LoginRegisterFragment();
        return loginRegisterFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_register, container, false);
        tvLogin = view.findViewById(R.id.tv_login);
        tvRegister = view.findViewById(R.id.tv_register);
        edtUsername = view.findViewById(R.id.edt_username);
        edtEmail = view.findViewById(R.id.edt_email);
        edtPassword = view.findViewById(R.id.edt_password);
        btnLoginRegister = view.findViewById(R.id.btn_register_login);

        tvLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        btnLoginRegister.setOnClickListener(this);

        presenterLogin = new PresenterLogin(this);
        return view;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                tvLogin.setBackgroundResource(R.drawable.bg_login_register_active);
                tvRegister.setBackgroundResource(R.drawable.bg_login_register_inactive);
                edtUsername.setVisibility(View.GONE);
                btnLoginRegister.setText("Login");
                tvLogin.setTextColor(R.color.colorWhite);
                break;
            case R.id.tv_register:
                tvRegister.setBackgroundResource(R.drawable.bg_login_register_active);
                tvLogin.setBackgroundResource(R.drawable.bg_login_register_inactive);
                edtUsername.setVisibility(View.VISIBLE);
                btnLoginRegister.setText("Register");
                break;
                // khi click button login (View) -> sẽ báo cho Presenter biết user muốn đăng nhập
            case R.id.btn_register_login:
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                presenterLogin.receivedHanleLogin(email, password);


                break;
        }
    }

//    // Tầng view
//    private void loginSuccess() {
//        // start sang man hinh khac
//    }
//
//    private void loginFaild() {
//
//    }
//    // end Tầng view
//
//    // Tầng model xử lý -> trả lại cho presenter -> trả lại cho view
//    private void handleLogin(String email, String password) {
//        if ("khanhlerduy@gmail.com".equals(email) && "khanhlerduy".equals(password)) {
//            loginSuccess();
//        } else {
//            loginFaild();
//        }
//    }

    // MVP
    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(getActivity(),UserInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(getActivity(), "Email hoac password khong dung vui long thu lai", Toast.LENGTH_SHORT).show();
    }
    // end MVP

    // MVP Model - View - Presenter
    // Moddel: là nơi xử lý login, hoặc xử lý nghiệp vụ cho các chức năng hay app của các bạn
    // View: Là nơi hiển thị thông tin cho người dùng (Activity, Fragment, View....)
    // Presenter: Là nơi trung gian giao tiếp giữa view và model gọi và trả lại kết quả xử lý

}

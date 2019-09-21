package com.duykhanh.intrologin.presenter.login;

import com.duykhanh.intrologin.model.login.ModelLogin;
import com.duykhanh.intrologin.model.login.ModelResponseToPresenterListtener;
import com.duykhanh.intrologin.view.login.ViewLoginListener;

public class PresenterLogin implements ModelResponseToPresenterListtener {

    private ModelLogin modelLogin;
    private ViewLoginListener callback;

    public PresenterLogin(ViewLoginListener callback) {
        this.callback = callback;
    }

    public void receivedHanleLogin(String email, String password) {
        // Tại phương thực này-> Thông báo cho model biết để xử lý login
        modelLogin = new ModelLogin(this);
        modelLogin.handleLogin(email, password);
    }

    @Override
    public void onLoginSuccess() {
        callback.onLoginSuccess();
    }

    @Override
    public void onLoginFailed() {
        callback.onLoginFailed();
    }
}

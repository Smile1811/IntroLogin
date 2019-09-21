package com.duykhanh.intrologin.model.login;

public class ModelLogin {

    ModelResponseToPresenterListtener callback;

    // hàm khởi tạo
    public ModelLogin (ModelResponseToPresenterListtener callback){
       this.callback = callback;
    }

    public void handleLogin(String email, String password){
        // Xử lý logic ở đây
        if("khanhlerduy@gmail.com".equals(email) && "khanhlerduy".equals(password)){
            callback.onLoginSuccess();
        }
        else{
            callback.onLoginFailed();
        }
    }
}

package com.example.ramya.adkoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Button SignOut = (Button)findViewById(R.id.logout);
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountKit.logOut();
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
            @Override
            public void onSuccess(Account account) {
                EditText editUserId,editUserPhone,editUserEmail;

                editUserId = (EditText)findViewById(R.id.edituserid);
                editUserId.setText(String.format("UserId %s",account.getId()));

                editUserEmail = (EditText)findViewById(R.id.edituseremail);
                editUserEmail.setText(String.format("Email Id %s",account.getEmail()));

                editUserPhone = (EditText)findViewById(R.id.edituserphone);
                editUserPhone.setText(String.format("Phone %s",account.getPhoneNumber()==null ? "":account.getPhoneNumber().toString()));


            }

            @Override
            public void onError(AccountKitError accountKitError) {

            }
        });
    }
}

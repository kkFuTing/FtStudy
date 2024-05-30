package com.futing.ftstudy.dialog;

import android.app.Activity;
import android.view.Window;

import com.futing.ftstudy.R;

public class DialogActivity {

    public void showDialog(Activity context) {
        PrivacyPolicyDialog dialog = new PrivacyPolicyDialog(context);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.dialog_background);
//            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        dialog.show();
        dialog.setOnDismissListener(new PrivacyPolicyDialog.OnDismissListener() {
            @Override
            public void agree() {
                //可以进行初始化
            }

            @Override
            public void reject() {
                context.finish();
//                finish();
            }
        });
    }
}

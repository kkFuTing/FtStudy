package com.futing.ftstudy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.futing.ftstudy.R;
import com.futing.ftstudy.utils.ResFinder;

import com.qmuiteam.qmui.util.QMUIDisplayHelper;
public class PrivacyPolicyDialog extends Dialog {

    private Context context;

    //
//    public PrivacyPolicyDialog(Context context) {
//        super(context);
//        this.context = context;
//    }
    public PrivacyPolicyDialog(Context context) {
//        this(context, false, null);
        this(context, R.style.CustomDialogTheme);

    }

    public PrivacyPolicyDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    public PrivacyPolicyDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.privacy_policy_dialog, null);
        setContentView(dialogView);

        // 找到按钮并设置点击事件
        Button exitButton = dialogView.findViewById(R.id.btnReject);
        Button agreeButton = dialogView.findViewById(R.id.btnAccept);


        GradientDrawable shapeDrawable = new GradientDrawable();
        shapeDrawable.setShape(GradientDrawable.RECTANGLE); // 设置形状为矩形
        shapeDrawable.setCornerRadius(QMUIDisplayHelper.dp2px(context,20)); // 设置圆角半径为20dp
        int privacyColor = Color.parseColor(ResFinder.string(context, "privacy_color"));
// 设置背景色
        shapeDrawable.setColor(privacyColor); // 使用项目定义的颜色资源

// 或者使用直接设置颜色
// shapeDrawable.setColor(Color.parseColor("#2196F3")); // 设置颜色为指定颜色
        agreeButton.setBackground(shapeDrawable);

        TextView tvPrivacyContent = dialogView.findViewById(R.id.tv_privacy_content);
        TextView setAgreementTextView = dialogView.findViewById(R.id.user_agreement_textview);

        int privacyContent = ResFinder.stringId(context, "privacy_content");
        int agreement_html = ResFinder.stringId(context, "agreement_html");
        if (privacyContent == 0) {
            setAgreementTextView.setVisibility(View.GONE);

            tvPrivacyContent.setLinkTextColor(privacyColor);
            tvPrivacyContent.setText(agreement_html);
            tvPrivacyContent.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            // 在设置文本之前，设置超链接的文本颜色
            setAgreementTextView.setLinkTextColor(privacyColor);
            setAgreementTextView.setText(agreement_html);
            setAgreementTextView.setMovementMethod(LinkMovementMethod.getInstance());
            tvPrivacyContent.setText(privacyContent);

        }



//        serAgreementTextView.setText(Html.fromHtml("点击阅读完整版本" +
//                "<a href='https://xx_policy.html'>" +
//                "《用户协议》</a>和" +
//                "<a href='https://xxprivacy_policy.html'>" +
//                " 《隐私协议》</a>" +
//                "，了解详细信息。如果您同意，请点击同意并使用开始接受我们的服务。"));

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 进行退出并拒绝的操作
                dismiss(); // 关闭弹窗
                if (onDismissListener != null) {
                    dismiss(); // 关闭弹窗
                    onDismissListener.reject();
                }

            }
        });

        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 进行同意并使用的操作
                if (onDismissListener != null) {
                    dismiss(); // 关闭弹窗
                    onDismissListener.agree();
                }
            }
        });
    }

    OnDismissListener onDismissListener;

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public interface OnDismissListener {

        void agree();

        void reject();
    }

}

package com.poly.lmsapp.ui.subject;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.poly.lmsapp.R;
import com.poly.lmsapp.commons.base.LMSAdapter;
import com.poly.lmsapp.commons.resource.KeyResource;
import com.poly.lmsapp.commons.utils.EnviromentSingleton;
import com.poly.lmsapp.model.Subject;
import com.poly.lmsapp.ui.file_system.FileSystemActivity;
import com.poly.lmsapp.ui.m_class.ClassActivity;

import java.util.ArrayList;

public class SubjectAdapter extends LMSAdapter {
    private CardView mContainer;
    private ImageView mIvSubject;
    private TextView mTvSubject;


    public SubjectAdapter(ArrayList listData, int layout) {
        super(listData, layout);
    }

    @Override
    public void declareViews(View view, BaseViewHolder holder) {
        mIvSubject = view.findViewById(R.id.iv_subject);
        mTvSubject = view.findViewById(R.id.tv_subject);
        mContainer = view.findViewById(R.id.container);
    }

    @Override
    public void bindingViewHolder(BaseViewHolder holder, int position) {
        Subject subject = (Subject) getListData().get(position);
        mTvSubject.setText(subject.getName());
        mContainer.setOnClickListener(view -> {
            Intent intent;
            EnviromentSingleton.getEnviromentSingleton().setIdSubject(subject.getId());
            if (EnviromentSingleton.getEnviromentSingleton().getRepositoryType().equalsIgnoreCase("tài liệu")) {
                intent = new Intent(context, FileSystemActivity.class);
            } else {
                intent = new Intent(context, ClassActivity.class);
            }
            intent.putExtra(KeyResource.ID_SUBJECT, subject.getId());
            intent.putExtra(KeyResource.NAME_SUBJECT, subject.getName());
            context.startActivity(intent);
        });
    }
}

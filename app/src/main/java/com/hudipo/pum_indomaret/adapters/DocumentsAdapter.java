package com.hudipo.pum_indomaret.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.model.Document;

import java.util.ArrayList;

public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.DocumentsViewHolder> {

    private Context mCtx;
    private ArrayList<Document> documentList;

    public DocumentsAdapter(ArrayList<Document> documentList) {
        this.documentList = documentList;
    }



    @NonNull
    @Override
    public DocumentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_request_document, parent, false);
        return new DocumentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentsViewHolder documentsViewHolder, int position) {
        Document document = documentList.get(position);
        documentsViewHolder.tv_cell_doc_number.setText(document.getDOC_NUM());
        documentsViewHolder.tv_cell_doc_amount.setText(""+document.getDOC_AMOUNT());
        documentsViewHolder.tv_cell_doc_vendor_num.setText(document.getVENDOR_NUM());
        documentsViewHolder.tv_cell_doc_vendor_name.setText(document.getVENDOR_NAME());


    }

    @Override
    public int getItemCount() {
        return documentList.size();
    }

    class DocumentsViewHolder extends RecyclerView.ViewHolder{
        TextView tv_cell_doc_number;
        TextView tv_cell_doc_amount;
        TextView tv_cell_doc_vendor_num;
        TextView tv_cell_doc_vendor_name;


        public DocumentsViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_cell_doc_number = itemView.findViewById(R.id.tv_cell_doc_number);
            tv_cell_doc_amount = itemView.findViewById(R.id.tv_cell_doc_amount);
            tv_cell_doc_vendor_num = itemView.findViewById(R.id.tv_cell_doc_vendor_num);
            tv_cell_doc_vendor_name = itemView.findViewById(R.id.tv_cell_doc_vendor_name);
        }
    }
}

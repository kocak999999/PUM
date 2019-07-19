package com.hudipo.pum_indomaret.model;

import java.util.ArrayList;
import java.util.List;

public class DocumentsResponse {

    private boolean error;
    private Document[] documents;

    public boolean isError() {
        return error;
    }

    public Document[] getDocuments() {
        return documents;
    }

    public DocumentsResponse(boolean error, Document[] documents) {
        this.error = error;
        this.documents = documents;
    }
}

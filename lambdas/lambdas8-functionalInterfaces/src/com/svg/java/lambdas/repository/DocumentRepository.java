package com.svg.java.lambdas.repository;

import com.svg.java.lambdas.domain.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentRepository {

    static List<Document> documentList = new ArrayList<>();

    static {
        documentList.add(new Document("document1", 1));
        documentList.add(new Document("document1", 2));
        documentList.add(new Document("document2", 1));
        documentList.add(new Document("document2", 2));
        documentList.add(new Document("document2", 3));
        documentList.add(new Document("document3", 1));
    }

    public List<Document> getAll(){
        return documentList;
    }
}


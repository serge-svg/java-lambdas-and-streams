package com.svg.java.lambdas.services;

import com.svg.java.lambdas.domain.Document;
import com.svg.java.lambdas.repository.DocumentRepository;

import java.util.List;
import java.util.Optional;

public class DocumentService {

    DocumentRepository documentRepository = new DocumentRepository();

    public List<Document> getAll() {
        return documentRepository.getAll();
    }

    public Document getDocumentByTitle(String title) {
        Optional<Document> document = getAll().stream().filter((d) -> d.title().contentEquals(title)).findFirst();
        return document.isPresent() ? document.get() : new Document(title, 1);
    }

}

package com.svg.java.lambdas.functionalinterfaces.bifunction;

import com.svg.java.lambdas.domain.Document;
import com.svg.java.lambdas.domain.Versionable;
import com.svg.java.lambdas.service.DocumentService;

import java.util.List;

/*
    Represents a function that accepts two arguments and produces a result.
*/
public class Main {

    public static void main(String[] args) {
        DocumentService documentService = new DocumentService();
        Document document1 = documentService.getDocumentByTitle("document1");
        Document document2 = documentService.getDocumentByTitle("document2");

        List<Document> documentList = documentService.getAll();
        // Reduce with an accumulator and a bioperator, instead of accumulate, the accumulator is being use to keep the document with major version
        Document higherDocument1 = documentList.stream().filter((d) -> d.title().contentEquals(document1.title())).reduce(document1, Versionable::isHigherVersion);
        Document higherDocument2 = documentList.stream().filter((d) -> d.title().contentEquals(document2.title())).reduce(document2, Versionable::isHigherVersion);

        // Printing the document with major version
        System.out.printf("Document: %s, Version: %s %n", higherDocument1.title(), higherDocument1.version());
        System.out.printf("Document: %s, Version: %s %n", higherDocument2.title(), higherDocument2.version());

        // Comparing two documents
        System.out.printf("The document with higher version is: %s", document1.isHigher(document2).title());

    }


}

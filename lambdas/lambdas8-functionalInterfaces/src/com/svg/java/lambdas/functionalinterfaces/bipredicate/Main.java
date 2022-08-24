package com.svg.java.lambdas.functionalinterfaces.bipredicate;

import com.svg.java.lambdas.domain.Document;
import com.svg.java.lambdas.service.DocumentService;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/*
    BiPredicate<T,U> - Represents a predicate (boolean-valued function) of two arguments. Given two input
    parameters decides for true or false.
    This is a functional interface whose functional method is test(Object, Object).
 */
public class Main {

    public static void main(String[] args) {
        DocumentService documentService = new DocumentService();
        List<Document> documentList = documentService.getAll();
        List<Document> filteredDocumentList = filter(documentList, Main::higherThan, documentService.getDocumentByTitle("document1"));
        filteredDocumentList.stream().map(Document::title).forEach(System.out::println);
    }

    public static List<Document> filter(List<Document> list, BiPredicate<Document, Document> predicate, Document documentToCompare) {
        return list
                .stream()
                .filter((initialDoc) -> predicate.test(initialDoc, documentToCompare))
                .collect(Collectors.toList());
    }

    // BiPredicate
    public static boolean higherThan(Document initial, Document toCompare) {
        return initial.version() > toCompare.version();
    }

}

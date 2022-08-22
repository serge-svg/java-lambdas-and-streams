package com.svg.java.lambdas.domain;

public record Document(String title, int version) implements Versionable<Document>{}

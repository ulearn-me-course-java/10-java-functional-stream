package com.example.task05;


class ContentContainer<ContentType> {
    private String from;
    private String to;
    private ContentType content;

    public ContentContainer(String from, String to, ContentType content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public ContentType getContent() {
        return this.content;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }
}

package lld.stackoverflow;

public class Answer {
    private String id;
    private String text;
    private final Question question;
    private User author;
    private Tag tag;
    private int upVote;
    private int creationDate;

    Answer(String id, String text, Question question) {
        this.id = id;
        this.text = text;
        this.question = question;
        this.upVote = 0;
    }

}
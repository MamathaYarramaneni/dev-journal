package lld.stackoverflow;

public class Comment {
    private String id;
    private String text;
    private User author;
    private int creationDate;

    Answer(String id, String text, Question question) {
        this.id = id;
        this.text = text;
        this.question = question;
        this.upVote = 0;
    }


}
package lld.stackoverflow;

public interface Commentable {
    void addComment(Comment comment);
    List<Comment> getComments();
}
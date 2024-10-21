package lld.stackoverflow;

public class Question implements Votable, Commentable {
    private String id;
    private String title;
    private String content;
    private User author;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Vote> votes;
    private User author;
    private Tag tag;
    private int upVote;
    private int creationDate;

    Question(User user, String title, String content, List<Tag> tags) {
        this.id = generateId();
        this.title = title;
        this.content = content;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        this.answerList.add(answer);
    }

    public void addUpVote() {
        this.upVote++;
    }

    private int generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(User user, int value) {
        if(value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote must be either -1 or +1");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user, value));
        author.updateReputation(value * 5);
    }

    @Override
    public int getVoteCount() {
        return this.votes.stream().mapToInt(Vote::getValue).sum();
    }
}
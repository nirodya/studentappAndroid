package javainstitute.edu.lk.studentapp.model;

/**
 * Created by Nirodya on 3/31/2016.
 */
public class FaqPOJO {
    private String question;
    private String answer;
    private String id;

    public FaqPOJO(String question, String answer, String id) {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

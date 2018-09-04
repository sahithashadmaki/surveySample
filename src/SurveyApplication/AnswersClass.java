package SurveyApplication;

public class AnswersClass {
	int userId;
	int quesId;
	String answer;
	int formId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuesId() {
		return quesId;
	}
	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	@Override
	public String toString() {
		return "AnswersClass [userId=" + userId + ", quesId=" + quesId + ", answer=" + answer + "]";
	}
	
}

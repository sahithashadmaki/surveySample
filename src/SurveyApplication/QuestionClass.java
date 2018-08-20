package SurveyApplication;

public class QuestionClass implements QuestionsInterface {
	int questionId;
	String question;
String queType;



public void setQuestionId(int questionId) {
	this.questionId = questionId;
}
@Override
public int getQuestionId() {
	return questionId;
	
}
public void setQuestion(String question) {
	this.question = question;
}

@Override
public String getquestion() {
	return question;
}
@Override
public String toString() {
	return "QuestionClass [questionId=" + questionId + ", question=" + question + ", queType=" + queType + "]";
}
public void setQueType(String queType) {
	this.queType = queType;
}
@Override
public String getQueType() {
	return queType;
}

		
		
		
}

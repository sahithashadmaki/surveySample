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

public void setQueType(String queType) {
	this.queType = queType;
}
@Override
public String getQueType() {
	return queType;
}

		
		
		
}

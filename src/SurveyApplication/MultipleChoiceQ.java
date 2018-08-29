package SurveyApplication;

public class MultipleChoiceQ extends QuestionClass{

String[] questionOptions;

	
	public String[] getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(String[] questionOptions) {
		this.questionOptions = questionOptions;
	}
	@Override
	public String toString() {
		return "MultipleChoiceQ [questionOptions=" + questionOptions + ", questionId=" + questionId + ", question="
				+ question + ", queType=" + queType + "]";
	}


}

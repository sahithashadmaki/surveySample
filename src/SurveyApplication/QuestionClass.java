package SurveyApplication;

public class QuestionClass implements QuestionsInterface {
	int questionId;
	String question;
String queType;

		
		@Override
		public void question(String a) {
		this.question=a;
			
		}
		public String getQuestion() {
			return question;
		}
		@Override
		public void setQueType(String a) {
			// TODO Auto-generated method stub
			
		}
		public String getQueType() {
			return queType;
		}
		@Override
		public void setQuestionId(int a) {
			this.questionId=a;
			
		}
		public int getQuestionId() {
			return questionId;
		}
		
}

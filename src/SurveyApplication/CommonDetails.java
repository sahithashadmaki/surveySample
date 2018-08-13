package SurveyApplication;

public class CommonDetails implements QuestionsInterface{
	int questionNo;
	String question;
String queType;

		@Override
		public void setQuestionNo(int a) {
			this.questionNo=a;
			
		}
		public int getQuestionNo() {
			return questionNo;
		}
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

}

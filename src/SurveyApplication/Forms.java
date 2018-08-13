package SurveyApplication;

import java.util.ArrayList;


public class Forms {
int formId;
String formTitle;
ArrayList<QuestionsInterface> list;
public int getFormId() {
	return formId;
}
public void setFormId(int formId) {
	this.formId = formId;
}
public String getFormTitle() {
	return formTitle;
}
public void setFormTitle(String formTitle) {
	this.formTitle = formTitle;
}
public ArrayList<QuestionsInterface> getList() {
	return list;
}
public void setList(ArrayList<QuestionsInterface> list) {
	this.list = list;
}

}

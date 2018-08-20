package SurveyApplication;

import java.util.ArrayList;


public class Forms {
int formId;
String formTitle;
ArrayList<QuestionClass> list;
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
public ArrayList<QuestionClass> getList() {
	return list;
}
public void setList(ArrayList<QuestionClass> list) {
	this.list = list;
}

}

package SurveyApplication;

import java.util.ArrayList;


public class Forms {
int formId;
String formTitle;
ArrayList<QuestionClass> list;
boolean valid;
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

public boolean isValid() {
	return valid;
}
public void setValid(boolean valid) {
	this.valid = valid;
}
@Override
public String toString() {
	return "Forms [formId=" + formId + ", formTitle=" + formTitle + "]"+"\n";
}

}

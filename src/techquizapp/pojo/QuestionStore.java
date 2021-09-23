/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

/**
 *
 * @author Pushpendra
 */

import java.util.ArrayList;


public class QuestionStore {
    ArrayList<Question> questionList;
    
    public String toString() {
        String sb=new String();
        for(Question q:questionList)
            sb=sb+q;
        return sb;
    }
    
    public QuestionStore()
    {
        questionList=new ArrayList<>();
    }
    
    public ArrayList<Question> getAllQuestions()
    {
        return questionList;
    }
    
    public void addQuestion(Question ques)
    {
        questionList.add(ques);
    }
    
    public Question getQuestion(int pos)
    {
        return questionList.get(pos);
    }
    
    public Question getQuestionByQno(int qno)
    {
        for(Question ques:questionList)
        {
            if(ques.getQno()==qno)
                return ques;
        }
        return null;
    }
    
    public void removeQuestion(int pos)
    {
        questionList.remove(pos);
    }
    
    public void setQuestionAt(Question question, int pos)
    {
        questionList.add(pos, question);
    }
    
    public int getCount()
    {
        return questionList.size();
    }
}

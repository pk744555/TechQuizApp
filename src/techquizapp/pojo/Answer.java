/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

import java.util.Objects;

/**
 *
 * @author Pushpendra
 */
public class Answer {
 
    String examId;
    String subjectName;
    int qno;
    String chosenAnswer;
    String correctAnswer;
    
    @Override
    public String toString()
    {
        return "Answer( exam="+examId+", subject="+subjectName+", qno="+qno+", choosenAnswer="+chosenAnswer+", correctAnswer="+correctAnswer;
    }
    
    @Override
    public boolean equals(Object obj) {
        Answer other=(Answer) obj;
        if(this.chosenAnswer.equals(other.chosenAnswer)==false){
            return false;
        }
        if(this.correctAnswer.equals(other.correctAnswer)==false){
            return false;
        }
        if(this.qno!=other.qno){
            return false;
        }
        if(this.examId.equals(other.examId)==false)
        {
            return false;
        }
        if(this.subjectName.equals(other.subjectName)==false)
        {
            return false;
        }
        return true;
            
    }
    
    public Answer(String examid,String subjectname,int qno,String chosenanswer,String correctanswer){
        this.examId=examid;
        this.subjectName=subjectname;
        this.qno=qno;
        this.chosenAnswer=chosenanswer;
        this.correctAnswer=correctanswer;
    }
    
    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

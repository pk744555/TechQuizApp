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

import java.util.Objects;


public class Question {

    
    @Override
    public boolean equals(Object obj) {
        Question other=(Question) obj;
        if(this.examId.equals(other.examId)==false){
            return false;
        }
        if(this.Qno!=other.Qno){
            return false;
        }
        if(this.Question.equals(other.Question)==false){
            return false;
        }
        if(this.answer1.equals(other.answer1)==false){
            return false;
        }
        if(this.answer2.equals(other.answer2)==false){
            return false;
        }
        if(this.answer3.equals(other.answer3)==false){
            return false;
        }
        if(this.answer4.equals(other.answer4)==false){
            return false;
        }
        if(this.correctAnswer.equals(other.correctAnswer)==false){
            return false;
        }
        return true;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getQno() {
        return Qno;
    }

    public void setQno(int Qno) {
        this.Qno = Qno;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" + "examId=" + examId + ", qno=" + Qno + ", language=" + Language + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", correctAnswer=" + correctAnswer + ", question=" + Question + '}';
    }
    
    
    
    public Question()
    {
        
    }
    
    public Question(String examid,int qno,String question,String language,String correctanswer,String Answer1,String Answer2,String Answer3,String Answer4)
    {
        this.examId=examid;
        this.Qno=qno;
        this.Language=language;
        this.correctAnswer=correctanswer;
        this.answer1=Answer1;
        this.answer2=Answer2;
        this.answer3=Answer3;
        this.answer4=Answer4;
        this.Question=question;
    }

    
   private String examId;
   private int Qno;
   private String Language;
   private String Question;
   private String answer1,answer2,answer3,answer4;
   private String correctAnswer;
}

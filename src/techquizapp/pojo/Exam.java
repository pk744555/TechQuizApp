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


public class Exam {

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
    
    public Exam()
    {
        
    }
    
    public Exam(String examid,String language,int totalquestions)
    {
        this.examId=examid;
        this.language=language;
        this.totalQuestions=totalquestions;
    }
 
    private String language;
    private String examId;
    private int totalQuestions;
}

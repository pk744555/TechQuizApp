/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;

/**
 *
 * @author Pushpendra
 */
public class QuestionDAO {
    public static void addQuestions(QuestionStore qStore) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList<Question> questionList=qStore.getAllQuestions();
        for(Question q:questionList)
        {
            ps.setString(1, q.getExamId());
            ps.setInt(2, q.getQno());
            ps.setString(3, q.getQuestion());
            ps.setString(4, q.getAnswer1());
            ps.setString(5, q.getAnswer2());
            ps.setString(6, q.getAnswer3());
            ps.setString(7, q.getAnswer4());
            ps.setString(8, q.getCorrectAnswer());
            ps.setString(9, q.getLanguage());
            ps.executeUpdate();
        }
    }
    
    public static void updateQuestions(QuestionStore qStore) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=? where examid=? and qno=?");
        ArrayList<Question> quesList=qStore.getAllQuestions();
        for(Question q:quesList)
        {
            ps.setString(1, q.getQuestion());
            ps.setString(2, q.getAnswer1());
            ps.setString(3, q.getAnswer2());
            ps.setString(4, q.getAnswer3());
            ps.setString(5, q.getAnswer4());
            ps.setString(6, q.getCorrectAnswer());
            ps.setString(7, q.getExamId());
            ps.setInt(8, q.getQno());
            ps.executeUpdate();
        }
    }
    
    public static ArrayList<Question> getQuestionsByExamId(String examId) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from questions where examid=? order by qno");
        ps.setString(1, examId);
        ResultSet rs=ps.executeQuery();
        ArrayList<Question> quesList=new ArrayList<>();
        while(rs.next())
        {
            int qno=rs.getInt(2);
            String question=rs.getString(3);
            String answer1=rs.getString(4);
            String answer2=rs.getString(5);
            String answer3=rs.getString(6);
            String answer4=rs.getString(7);
            String correctAnswer=rs.getString(8);
            String language=rs.getString(9);
            Question ques=new Question(examId,qno,question,language,correctAnswer,answer1,answer2,answer3,answer4);
//            System.out.println(ques.getExamId()+" "+ques.getQno()+" "+ques.getQuestion()+" "+ques.getAnswer1()+" "+ques.getAnswer2()+" "+ques.getAnswer3()+" "+ques.getAnswer4()+" "+ques.getCorrectAnswer()+" "+ques.getLanguage());
            quesList.add(ques);
            
            
        }
        return quesList;
    }
}

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
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Exam;

/**
 *
 * @author Pushpendra
 */
public class ExamDAO {
    public static String getExamId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(*) from exam");
        rs.next();
        String examId;
        int count=rs.getInt(1);
        examId="EX-"+(count+1);
        return examId;
        
    }
    
    public static boolean addExam(Exam exam) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into exam values(?,?,?)");
        ps.setString(1, exam.getExamId());
        ps.setString(2, exam.getLanguage());
        ps.setInt(3, exam.getTotalQuestions());
        int ans=ps.executeUpdate();
        return ans==1;
    }
    
    public static ArrayList<String> getAllSubjects() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select distinct language from exam");
        ArrayList<String> subjectList=new ArrayList<>();
//        subjectList.add("");
        while(rs.next())
        {
            subjectList.add(rs.getString(1));
        }
        return subjectList;
    }
    
    public static ArrayList<String> getExamIdBySubject(String subject) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select examid from exam where language=?");
        ps.setString(1, subject);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examidList=new ArrayList<>();
        while(rs.next())
        {
            examidList.add(rs.getString(1));
        }
        return examidList;
    }
    
    public static int getQuestionCountByExam(String examid) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select total_question from exam where examid=?");
        ps.setString(1, examid);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    
    public static boolean isPaperSet(String subject) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select 1 from exam where language=?");
        ps.setString(1, subject);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    
    public static ArrayList<String> getExamIdBySubject(String userid,String subject)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String query="select examid from exam where language=? minus select examid from performance where userid=?";
        PreparedStatement ps=conn.prepareStatement(query);
        ps.setString(1, subject);
        ps.setString(2, userid);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> quesList=new ArrayList<>();
        while(rs.next())
        {
            quesList.add(rs.getString(1));
        }
        return quesList;
    }
}

package com.sample.spring;

import org.springframework.context.*;
import org.springframework.context.support.*;

import com.sample.spring.QuizMaster;

public class QuizProgram {


    private QuizMaster quizMaster;
    public void setQuizMaster(QuizMaster quizzer){
        this.quizMaster = quizzer;
    }

    public String askQuestion() {
        return quizMaster.popQuestion();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});

        QuizProgram myquiz = context.getBean("quizProgram", QuizProgram.class);

        String question = myquiz.askQuestion();

        System.out.println(question);
    }

}
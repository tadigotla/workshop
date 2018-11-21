package com.sample.spring;
public class StrutsQuizMaster implements QuizMaster {

    @Override
    public String popQuestion() {
        return "Are you new to Struts?";
    }

}
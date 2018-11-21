package com.sample.spring;

public class SpringQuizMaster implements QuizMaster {

    @Override
    public String popQuestion() {
        return "Are you new to Spring?";
    }

}
package com.rosualexandru.disertatie.Model;

import lombok.Getter;

@Getter
public enum Subject {
    ENGLISH_LANGUAGE_AND_LITERATURE(0),
    MATHEMATICS(1),
    SCIENCE(2),
    HISTORY(3),
    GEOGRAPHY(4),
    COMPUTER_SCIENCE(5),
    ART(6),
    MUSIC(7),
    PSYCHOLOGY(8),
    PHILOSOPHY(9),
    ECONOMICS(10);
    private final int subjectNumber;

     Subject(int subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

}

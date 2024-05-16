package com.example.advancedesigns;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "Quantative_practice_questions";
        public static final String TABLE_NAME1 = "Quantative_quiz_questions";
        public static final String TABLE_NAME2 = "Logical_practice_questions";
        public static final String TABLE_NAME3 = "Logical_quiz_questions";
        public static final String TABLE_NAME4 = "Verbal_practice_questions";
        public static final String TABLE_NAME5 = "Verbal_quiz_questions";
        public static final String TABLE_NAME6 = "Mock_test_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
    }
}
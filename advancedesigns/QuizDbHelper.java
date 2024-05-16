package com.example.advancedesigns;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.advancedesigns.QuizContract.QuestionsTable;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "apti.db";

    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;



        final String SQL_CREATE_QUANTATIVE_PRACTICE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUANTATIVE_PRACTICE_QUESTIONS_TABLE);
        fillQuestionsTable();


        final String SQL_CREATE_QUANTATIVE_QUIZ_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME1 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUANTATIVE_QUIZ_QUESTIONS_TABLE);
        fillQuestionsTable1();


        final String SQL_CREATE_LOGICAL_PRACTICE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME2 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_LOGICAL_PRACTICE_QUESTIONS_TABLE);
        fillQuestionsTable2();


        final String SQL_CREATE_LOGICAL_QUIZ_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME3 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_LOGICAL_QUIZ_QUESTIONS_TABLE);
        fillQuestionsTable3();


        final String SQL_CREATE_VERBAL_PRACTICE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME4 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_VERBAL_PRACTICE_QUESTIONS_TABLE);
        fillQuestionsTable4();

        final String SQL_CREATE_VERBAL_QUIZ_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME5 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

            db.execSQL(SQL_CREATE_VERBAL_QUIZ_QUESTIONS_TABLE);
        fillQuestionsTable5();


            final String SQL_CREATE_MOCK_TEST_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME6 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_MOCK_TEST_QUESTIONS_TABLE);
        fillQuestionsTable6();


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME5);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question(
                "A fruit seller had some apples. He sells 40% apples and still has 420 apples. Originally, he had:",
                "588 apples", "600 apples", "672 apples", 2);
        addQuestion(q1);
        Question q2 = new Question("What percentage of numbers from 1 to 70 have 1 or 9 in the unit's digit?", "1", "14", "20", 3);
        addQuestion(q2);
        Question q3 = new Question(
                "If 20% of a = b, then b% of 20 is the same as:", "4% of a", "5% of a", "20% of a", 1);
        addQuestion(q3);
        Question q4 = new Question(
                "Two numbers A and B are such that the sum of 5% of A and 4% of B is two-third of the sum of 6% of A and 8% of B. Find the ratio of A : B.", "2:3", "4:3", "1:1", 2);
        addQuestion(q4);
        Question q5 = new Question("The population of a town increased from 1,75,000 to 2,62,500 in a decade. The average percent increase of population per year is:", "4%", "6%", "5%", 3);
        addQuestion(q5);
    }

    private void fillQuestionsTable1() {
        Question q1 = new Question("Rajeev buys good worth Rs. 6650. He gets a rebate of 6% on it. After getting the rebate, he pays sales tax @ 10%. Find the amount he will have to pay for the goods.", "Rs. 6876.10", "Rs. 6999.2", "Rs. 7000", 1);
        addQuestion1(q1);
        Question q2 = new Question(
                "Gauri went to the stationers and bought things worth Rs. 25, out of which 30 paise went on sales tax on taxable purchases. If the tax rate was 6%, then what was the cost of the tax free items?", "Rs. 15.70", "Rs. 15", "Rs. 19.70", 3);
        addQuestion1(q2);
        Question q3 = new Question("A student multiplied a number by 3/5 instead of 5/3 , What is the percentage error in the calculation?", "34%", "44%", "64%", 3);
        addQuestion1(q3);
        Question q4 = new Question("In an election between two candidates, one got 55% of the total valid votes, 20% of the votes were invalid. If the total number of votes was 7500, the number of valid votes that the other candidate got, was:", "2700", "2900", "3000", 1);
        addQuestion1(q4);
        Question q5 = new Question("Two tailors X and Y are paid a total of Rs. 550 per week by their employer. If X is paid 120 percent of the sum paid to Y, how much is Y paid per week?", "Rs. 200", "Rs. 250", "Rs. 300", 2);
        addQuestion1(q5);

    }
    private void fillQuestionsTable2() {
        Question q1 = new Question("Look at this series: 2, 1, (1/2), (1/4), ... What number should come next?", "(1/3)", "(1/8)", "(1/4)", 2);
        addQuestion2(q1);
        Question q2 = new Question(
                "Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?", "7", "10", "12", 2);
        addQuestion2(q2);
        Question q3 = new Question("Look at this series: 21, 9, 21, 11, 21, 13, 21, ... What number should come next?", "15", "14", "21", 1);
        addQuestion2(q3);
        Question q4 = new Question("Look at this series: 58, 52, 46, 40, 34, ... What number should come next?", "26", "30", "28", 3);
        addQuestion2(q4);
        Question q5 = new Question("Look at this series: 31, 29, 24, 22, 17, ... What number should come next?", "15", "14", "13", 1);
        addQuestion2(q5);
    }
    private void fillQuestionsTable3() {
        Question q1 = new Question(
                "Look at this series: 544, 509, 474, 439, ... What number should come next?", "404", "414", "420", 1);
        addQuestion3(q1);
        Question q2 = new Question(
                "Look at this series: 80, 10, 70, 15, 60, ... What number should come next?", "25", "21", "20", 3);
        addQuestion3(q2);
        Question q3 = new Question("Look at this series: 2, 6, 18, 54, ... What number should come next?", "108", "148", "162", 3);
        addQuestion3(q3);
        Question q4 = new Question("Look at this series: 5.2, 4.8, 4.4, 4, ... What number should come next?", "3", "3.6", "3.3", 2);
        addQuestion3(q4);
        Question q5 = new Question(
                "Look at this series: 8, 6, 9, 23, 87 , ... What number should come next?", "128", "226", "429", 3);
        addQuestion3(q5);
    }
    private void fillQuestionsTable4() {
        Question q1 = new Question("Statements: Some actors are singers. All the singers are dancers.\n" +
                "Conclusions:\n" +
                "1.Some actors are dancers.\n" +
                "2.No singer is actor.", "Only(1) conclusion follows", "Only(2) conclusion follows",
                "Either(1)or(2) follows", 1);
        addQuestion4(q1);
        Question q2 = new Question("Statements: All the harmoniums are instruments. All the instruments are flutes.\n" +

                "Conclusions:\n" +
                "All the flutes are instruments.\n" +
                "All the harmoniums are flutes.", "Only(1) conclusion follows", "Only(2) conclusion follows", "Both (1) and (2) follow", 2);
        addQuestion4(q2);
        Question q3 = new Question("\n" +
                "Statements: Some mangoes are yellow. Some tixo are mangoes.\n" +
                "Conclusions:\n" +
                "Some mangoes are green.\n" +
                "Tixo is a yellow.",
                "Only (1) conclusion follows",
                "Only (2) conclusion follows", "Neither (1) nor (2) follows", 3);
        addQuestion4(q3);
        Question q4 = new Question("\n" +
                "Statements: Some ants are parrots. All the parrots are apples.\n" +
                "Conclusions:\n" +
                "All the apples are parrots.\n" +
                "Some ants are apples.",
                "Only (1) conclusion follows",
                "Only (2) conclusion follows", "Neither (1) nor (2) follows", 2);
        addQuestion4(q4);
        Question q5 = new Question("Statements: Some papers are pens. All the pencils are pens.\n" +
                "Conclusions:\n" +
                "Some pens are pencils.\n" +
                "Some pens are papers.", "Only (1) conclusion follows",
                "Either (1) or (2) follows", "Both (1) and (2) follow", 3);
        addQuestion4(q5);
    }
    private void fillQuestionsTable5() {
        Question q1 = new Question("\n" +"Statements: All the actors are girls. All the girls are beautiful.\n" +
                "Conclusions:\n" +
                "All the actors are beautiful.\n" +
                "Some girls are actors.",
                "Only (1) conclusion follows",
                "Only (2) conclusion follows",
                "Both (1) and (2) follow", 3);
        addQuestion5(q1);
        Question q2 = new Question("\n" +
                "Statements: All the windows are doors. No door is a wall.\n" +
                "Conclusions:\n" +
                "Some windows are walls.\n" +
                "No wall is a door.",
                "Only (1) conclusion follows", "Only (2) conclusion follows", "Either (1) or (2) follows", 2);
        addQuestion5(q2);
        Question q3 = new Question("Statements: Some cows are crows. Some crows are elephants.\n" +
                "Conclusions:\n" +
                "Some cows are elephants.\n" +
                "All crows are elephants.", "Only (2) conclusion follows", "Neither (1) nor (2) follows",
                "Both (1) and (2) follow", 2);
        addQuestion5(q3);
        Question q4 = new Question("\n" +
                "Statements: All the pencils are pens. All the pens are inks.\n" +
                "Conclusions:\n" +
                "All the pencils are inks.\n" +
                "Some inks are pencils.", "\n" +
                "Only (1) conclusion follows",
                "Only (2) conclusion follows", "Both (1) and (2) follow", 3);
        addQuestion5(q4);
        Question q5 = new Question("Statements: All the trucks are flies. Some scooters are flies.\n" +
                "Conclusions:\n" +
                "All the trucks are scooters.\n" +
                "Some scooters are trucks.", "Only (1) conclusion follows", "Only (2) conclusion follows",
                "Neither (1) nor (2) follows", 3);
        addQuestion5(q5);
    }
    private void fillQuestionsTable6() {
        Question q1 = new Question(
                "120, 99, 80, 63, 48, ?", "35", "38", "39", 1);
        addQuestion6(q1);
        Question q2 = new Question(
                "A, P, R, X, S and Z are sitting in a row. S and Z are in the centre. A and P are at the ends. R is sitting to the left of A. Who is to the right of P ?", "A", "X", "S", 2);
        addQuestion6(q2);
        Question q3 = new Question("Pointing to a photograph of a boy Suresh said, \"He is the son of the only son of my mother.\" How is Suresh related to that boy?", "Brother", "Uncle", "Father", 3);
        addQuestion6(q3);
        Question q4 = new Question("A person crosses a 600 m long street in 5 minutes. What is his speed in km per hour?", "3.6", "7.2", "10", 2);
        addQuestion6(q4);
        Question q5 = new Question(
                "A and B invest in a business in the ratio 3 : 2. If 5% of the total profit goes to charity and A's share is Rs. 855, the total profit is:", "Rs. 1500", "Rs. 1425", "Rs. 1576", 1);
        addQuestion6(q5);
        Question q6 = new Question(
                "A sum of money at simple interest amounts to Rs. 815 in 3 years and to Rs. 854 in 4 years. The sum is:", "Rs. 650", "Rs. 698",
                "Rs. 690", 2);
        addQuestion6(q6);
        Question q7 = new Question(
                "In the following the questions choose the word which best expresses the meaning of the given word.\n\n" +
                        "CORPULENT",
                "Lean", "Gaunt", "Obese", 3);
        addQuestion6(q7);
        Question q8 = new Question("SCD, TEF, UGH, ____, WKL", "CMN", "UJI", "VIJ", 3);
        addQuestion6(q8);
        Question q9 = new Question("What decimal of an hour is a second ?", ".0025",
                ".00027", ".000126", 2);
        addQuestion6(q9);
        Question q10 = new Question(
                "In the first 10 overs of a cricket game, the run rate was only 3.2. What should be the run rate in the remaining 40 overs to reach the target of 282 runs?", "6.25",
                "6.5",
                "7", 1);
        addQuestion6(q10);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }
    private void addQuestion1(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME1, null, cv);
    }
    private void addQuestion2(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME2, null, cv);
    }
    private void addQuestion3(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME3, null, cv);
    }
    private void addQuestion4(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME4, null, cv);
    }
    private void addQuestion5(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME5, null, cv);
    }
    private void addQuestion6(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME6, null, cv);
    }

    @SuppressLint("Range")
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Quantative_practice_questions", null);
        Log.d("TAG", "getAllQuestions: "+c.getCount());
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
    public List<Question> getAllQuestions1() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Quantative_quiz_questions", null);
        Log.d("TAG", "getAllQuestions: "+c.getCount());
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(1));
                question.setOption1(c.getString(2));
                question.setOption2(c.getString(3));
                question.setOption3(c.getString(4));
                question.setAnswerNr(c.getInt(5));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
    public List<Question> getAllQuestions2() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM logical_practice_questions", null);
        Log.d("TAG", "getAllQuestions: "+c.getCount());
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(1));
                question.setOption1(c.getString(2));
                question.setOption2(c.getString(3));
                question.setOption3(c.getString(4));
                question.setAnswerNr(c.getInt(5));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
    public List<Question> getAllQuestions3() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM logical_quiz_questions", null);
        Log.d("TAG", "getAllQuestions: "+c.getCount());
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(1));
                question.setOption1(c.getString(2));
                question.setOption2(c.getString(3));
                question.setOption3(c.getString(4));
                question.setAnswerNr(c.getInt(5));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
    public List<Question> getAllQuestions4() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Verbal_practice_questions", null);
        Log.d("TAG", "getAllQuestions: "+c.getCount());
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(1));
                question.setOption1(c.getString(2));
                question.setOption2(c.getString(3));
                question.setOption3(c.getString(4));
                question.setAnswerNr(c.getInt(5));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
    public List<Question> getAllQuestions5() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Verbal_quiz_questions", null);
        Log.d("TAG", "getAllQuestions: "+c.getCount());
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(1));
                question.setOption1(c.getString(2));
                question.setOption2(c.getString(3));
                question.setOption3(c.getString(4));
                question.setAnswerNr(c.getInt(5));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
    public List<Question> getAllQuestions6() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Mock_test_questions", null);
        Log.d("TAG", "getAllQuestions: "+c.getCount());
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(1));
                question.setOption1(c.getString(2));
                question.setOption2(c.getString(3));
                question.setOption3(c.getString(4));
                question.setAnswerNr(c.getInt(5));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}

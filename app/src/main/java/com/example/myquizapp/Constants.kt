package com.example.myquizapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWERS:String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia", "Anguilla", "Austria",
            1
        )
        questionsList.add(q1)

        val q2 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kazakhstan", "Kenya", "Kuwait", "Liberia",
            3
        )
        questionsList.add(q2)

        val q3 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_bangladesh,
            "Bahamas", "Bangladesh", "Barbados", "Belize",
            2
        )
        questionsList.add(q3)

        val q4 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_canada,
            " Cambodia", "Chile", "China", "Canada",
            4
        )
        questionsList.add(q4)

        val q5 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            " Iran", "India", "Iceland", "Italy",
            2
        )
        questionsList.add(q5)

        val q6 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            " Germany", "Georgia", "Gambia", "Ghana",
            1
        )
        questionsList.add(q6)

        val q7 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_france,
            "Fiji", "Bangladesh", "France", "Finland",
            3
        )
        questionsList.add(q7)

        val q8 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Djibouti", "Denmark", "Egypt",
            3
        )
        questionsList.add(q8)

        val q9 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_netherlands,
            "Niger", "Netherlands", "Niue", "North Korea",
            2
        )
        questionsList.add(q9)

        val q10 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_nigeria,
            "North Korea", "Niger", "Nepal", "Nigeria",
            4
        )
        questionsList.add(q10)

        return questionsList
    }

}
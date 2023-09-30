package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myquizapp.R.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition:Int = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0
    private var mUserName:String? = null

    private var mCorrectAnswers:Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvoption1: TextView? = null
    private var tvoption2: TextView? = null
    private var tvoption3: TextView? = null
    private var tvoption4: TextView? = null

    private var btnSubmit:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.prog_bar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)

        tvoption1 = findViewById(R.id.tv_option1)
        tvoption2 = findViewById(R.id.tv_option2)
        tvoption3 = findViewById(R.id.tv_option3)
        tvoption4 = findViewById(R.id.tv_option4)
        btnSubmit = findViewById(R.id.btn_submit)

        tvoption1?.setOnClickListener(this)
        tvoption2?.setOnClickListener(this)
        tvoption3?.setOnClickListener(this)
        tvoption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        setQuestion()
    }

    private fun setQuestion(){
        defaultOptionsView()

        val question: Question = mQuestionList!![mCurrentPosition - 1]

        ivImage?.setImageResource(question.image)

        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question

        tvoption1?.text = question.optionOne
        tvoption2?.text = question.optionTwo
        tvoption3?.text = question.optionThree
        tvoption4?.text = question.optionFour

        btnSubmit?.text = "SUBMIT"
    }

    private fun defaultOptionsView()
    {
        val options = ArrayList<TextView>()
        tvoption1?.let {
            options.add(0,it)
        }
        tvoption2?.let {
            options.add(1,it)
        }
        tvoption3?.let {
            options.add(2,it)
        }
        tvoption4?.let {
            options.add(3,it)
        }

        for (option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int)
    {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
        Log.i("Selected op no.:", "$mSelectedOptionPosition")
    }

    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.tv_option1 -> {
                tvoption1?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_option2 -> {
                tvoption2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option3 -> {
                tvoption3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option4 -> {
                tvoption4?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else
                {
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition)
                    {
                        ansView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else
                    {
                        mCorrectAnswers++
                    }
                    ansView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text = "FINISH"
                    }
                    else
                    {
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun ansView(ans:Int, drawableView: Int)
    {
        when(ans)
        {
            1 -> {
                tvoption1?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tvoption2?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tvoption3?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tvoption4?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}
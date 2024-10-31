package com.example.tuan7_bai1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tham chiếu các view từ file XML
        val inputText: EditText = findViewById(R.id.inputText)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val btnShow: Button = findViewById(R.id.button)
        val errorText: TextView = findViewById(R.id.textView3)
        val listView: ListView = findViewById(R.id.listView)

        // Xử lý khi nhấn nút "Show"
        btnShow.setOnClickListener {
            val input = inputText.text.toString()

            // Kiểm tra dữ liệu đầu vào có hợp lệ không
            val n = input.toIntOrNull()
            if (n == null || n < 0) {
                errorText.text = "Vui lòng nhập số nguyên dương"
                return@setOnClickListener
            } else {
                errorText.text = ""
            }

            // Lấy loại số từ RadioGroup
            val selectedId = radioGroup.checkedRadioButtonId
            val resultList = when (selectedId) {
                R.id.soChan -> generateEvenNumbers(n)
                R.id.soLe -> generateOddNumbers(n)
                R.id.soChinhPhuong -> generateSquareNumbers(n)
                else -> emptyList()
            }

            // Cập nhật ListView với kết quả
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resultList)
            listView.adapter = adapter
        }
    }

    // Hàm tạo danh sách số chẵn từ 0 đến n
    private fun generateEvenNumbers(n: Int): List<Int> {
        val evenList = mutableListOf<Int>()
        for (i in 2..n step 2) {
            evenList.add(i)
        }
        return evenList
    }

    // Hàm tạo danh sách số lẻ từ 1 đến n
    private fun generateOddNumbers(n: Int): List<Int> {
        val oddList = mutableListOf<Int>()
        for (i in 1..n step 2) {
            oddList.add(i)
        }
        return oddList
    }

    // Hàm tạo danh sách số chính phương từ 0 đến n
    private fun generateSquareNumbers(n: Int): List<Int> {
        val squareList = mutableListOf<Int>()
        var i = 1
        while (i * i <= n) {
            squareList.add(i * i)
            i++
        }
        return squareList
    }
}

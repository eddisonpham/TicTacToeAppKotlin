package com.example.tictactoe_minimaxapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var txtTurn: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTurn=findViewById(R.id.txtTurn)
    }
    fun BuClick(view: View){
        var buSelected:Button = findViewById(view.id)
        var CellID = 0
        when (buSelected.id){
            R.id.b1->CellID=1
            R.id.b2->CellID=2
            R.id.b3->CellID=3
            R.id.b4->CellID=4
            R.id.b5->CellID=5
            R.id.b6->CellID=6
            R.id.b7->CellID=7
            R.id.b8->CellID=8
            R.id.b9->CellID=9
        }
        PlayGame(CellID-1,buSelected)
    }

    var ActivePlayer = 1
    var board = arrayOf(arrayOf(0,0,0),arrayOf(0,0,0), arrayOf(0,0,0))
    fun PlayGame(CellID: Int, buSelected: Button){
        var x = CellID/3
        var y = CellID%3
        board[x][y]=ActivePlayer
        Log.i("tag","$x $y")
        buSelected.isEnabled = false
        if (ActivePlayer==1){
            buSelected.text = "X"
            ActivePlayer = 2
            txtTurn.text = "Turn: O"
            buSelected.setBackgroundColor(Color.GREEN)
        }else{
            buSelected.text = "O"
            ActivePlayer = 1
            txtTurn.text = "Turn: X"
            buSelected.setBackgroundColor(Color.RED)
        }
        var currPlayer = if (ActivePlayer==2) 1 else 2
        if (CheckWinner(currPlayer)!=-1){
            when(CheckWinner(currPlayer)){
                0->tie()
                1->gameEnd(1)
                2->gameEnd(2)
            }
            disableEnable(false)
        }
    }

    fun CheckWinner(currPlayer:Int):Int{
        var winner = -1
        for (i:Int in 0..2){
            if (board[0][i]==currPlayer && board[1][i]==board[0][i] && board[2][i]==board[0][i] && board[0][i]!=0){
                winner = currPlayer
            }
        }
        for (i:Int in 0..2){
            if (board[i][0]==currPlayer && board[i][1]==board[i][0] && board[i][2]==board[i][0] && board[i][0]!=0){
                winner = currPlayer
            }
        }
        if (board[0][0]==currPlayer && board[1][1]==board[0][0] && board[2][2]==board[0][0] && board[0][0]!=0){
            winner = currPlayer
        }
        if (board[0][2]==currPlayer && board[1][1]==board[0][2] && board[2][0]==board[0][2] && board[0][2]!=0){
            winner = currPlayer
        }
        if (!board[0].contains(0)&&!board[1].contains(0)&&!board[2].contains(0) && winner==-1){
            winner = 0
        }
        return winner
    }

    fun tie(){
        Toast.makeText(this, "Tie Game", Toast.LENGTH_SHORT).show()
        txtTurn.text = "Tie Game"
    }
    fun gameEnd(winner:Int){
        val winnerStr = if (winner==1) "X" else "O"
        txtTurn.text = "Winner: $winnerStr"
    }
    fun disableEnable(bool:Boolean){
        var b1: Button = findViewById(R.id.b1)
        b1.isEnabled=bool
        var b2: Button = findViewById(R.id.b2)
        b2.isEnabled=bool
        var b3: Button = findViewById(R.id.b3)
        b3.isEnabled=bool
        var b4: Button = findViewById(R.id.b4)
        b4.isEnabled=bool
        var b5: Button = findViewById(R.id.b5)
        b5.isEnabled=bool
        var b6: Button = findViewById(R.id.b6)
        b6.isEnabled=bool
        var b7: Button = findViewById(R.id.b7)
        b7.isEnabled=bool
        var b8: Button = findViewById(R.id.b8)
        b8.isEnabled=bool
        var b9: Button = findViewById(R.id.b9)
        b9.isEnabled=bool
    }

    fun reset(view: View){
        disableEnable(true)
        var b1: Button = findViewById(R.id.b1)
        b1.setBackgroundColor(Color.GRAY)
        b1.text = ""
        var b2: Button = findViewById(R.id.b2)
        b2.setBackgroundColor(Color.GRAY)
        b2.text = ""
        var b3: Button = findViewById(R.id.b3)
        b3.setBackgroundColor(Color.GRAY)
        b3.text = ""
        var b4: Button = findViewById(R.id.b4)
        b4.setBackgroundColor(Color.GRAY)
        b4.text = ""
        var b5: Button = findViewById(R.id.b5)
        b5.setBackgroundColor(Color.GRAY)
        b5.text = ""
        var b6: Button = findViewById(R.id.b6)
        b6.setBackgroundColor(Color.GRAY)
        b6.text = ""
        var b7: Button = findViewById(R.id.b7)
        b7.setBackgroundColor(Color.GRAY)
        b7.text = ""
        var b8: Button = findViewById(R.id.b8)
        b8.setBackgroundColor(Color.GRAY)
        b8.text = ""
        var b9: Button = findViewById(R.id.b9)
        b9.setBackgroundColor(Color.GRAY)
        b9.text = ""
        txtTurn.text = "Turn: X"
    }
}
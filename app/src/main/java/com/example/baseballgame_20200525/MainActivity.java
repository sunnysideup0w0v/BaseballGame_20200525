package com.example.baseballgame_20200525;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.example.baseballgame_20200525.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    // 문제에 사용될 세자리 숫자 배열
    int[] questionArr = new int[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    // 문제로 나올 세자리 숫자를 입력력
   void makeQuestion(){
        //세자리 숫자를 채우기 위한 for
        for(int i=0;i<questionArr.length;i++){
            //각 자리에 올바른 숫자가 들어갈 때 까지 무한 반복
            while(true){
                int randomNum = (int)(Math.random()*9+1);
                boolean isDuplOk = true;
                for(int num:questionArr){
                    //문제에서 같은 숫자를 찾았다 => 중복검사 통과 x
                    if(num == randomNum){
                        isDuplOk = false;
                        break;
                    }
                }
                // 중복검사를 통과함
                if(isDuplOk){
                    // 배열의 문제로 이 숫자를 채택
                    questionArr[i] = randomNum;
                    // 올바른 숫자를 뽑았으니 => 무한반복 종료 => 다음 배열의 칸에 들어갈 숫자를 뽑자
                    break;
                }
            }
        }
        for(int num:questionArr){
            Log.d("문제숫자",num+"");
        }
    }
}

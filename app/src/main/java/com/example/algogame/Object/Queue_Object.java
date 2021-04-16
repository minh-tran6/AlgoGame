package com.example.algogame.Object;

import android.text.Layout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Handler;

public class Queue_Object {
    String prompt;
    Stack<String> bufferScramble = new Stack<String>();
    String scramble="";
    Stack<String> scrambleCopy = new Stack<String>();
    Stack<String> result = new Stack<String>();
    Stack <Character> robotStack = new Stack<Character>();
    Stack<String> direction = new Stack<String>();
    int index=0;

    Random rand = new Random();
    String[] library =
            {"GAME","STOP"};

    public String getPrompt(int i)
    {
        prompt = library[rand.nextInt(library.length)];
        return prompt;
    }

    public void setScramble()
    {
        Stack<String> generate = new Stack<String>();
        int randomNumber;
        int startFromLeft=0;
        while(!generate.isEmpty() || startFromLeft!=prompt.length())
        {
            //0 = push to gen
            //1= pop from gen
            randomNumber = rand.nextInt(3);
            if(randomNumber == 0 || randomNumber == 1) //push to gen
            {
                if(startFromLeft==prompt.length())
                {
                    bufferScramble.push(generate.get(generate.size() - 1));
                    generate.pop();
                }
                else {

                    generate.push(prompt.substring(startFromLeft, startFromLeft + 1));
                    startFromLeft++;
                }
            }
            else //pop to gen
            {
                if(generate.size()==0) //If nothing to pop, then push word to gen
                {
                    generate.push(prompt.substring(startFromLeft, startFromLeft + 1));
                    startFromLeft++;
                }
                else {
                    while(generate.size()!=0) {
                        bufferScramble.push(generate.get(generate.size() - 1));
                        generate.pop();
                    }
                }

            }
        }
        scrambleCopy = (Stack<String>) bufferScramble.clone();
    }

    public void reset()
    {
        bufferScramble = (Stack<String>) scrambleCopy.clone();
        while(!result.isEmpty())
        {
            result.pop();
        }
    }

    public String getScramble()
    {
        for(int i=0;i<bufferScramble.size();i++)
        {
            scramble = scramble + bufferScramble.get(i);
        }

        char str[] = scramble.toCharArray();
        int index = 0;

        for(int i=0;i<scramble.length();i++)
        {
            int j;
            for(j=0;j<i;j++)
            {
                if(str[i]==str[j])
                {
                    break;
                }
            }
            if(j == i)
            {
                str[index++] = str[i];
            }
        }

        scramble = String.valueOf(Arrays.copyOf(str,index));
        return scramble;
    }

    public void setRobot()
    {
        robotStack.push('|');
    }

    public void rightRobot()
    {
        robotStack.push('=');
        direction.push("RIGHT");
    }
    public void leftRobot()
    {
        robotStack.pop();
        direction.push("LEFT");
    }
    public void downRobot()
    {
        direction.push("DOWN");
    }

    public String getRobot()
    {
        String robot = "";
        for(int i=robotStack.size()-1;i>-1;i--)
        {
            robot = robot + robotStack.get(i);
        }
        return robot;
    }

    public void clearRobot()
    {
        while(!robotStack.isEmpty())
        {
            robotStack.pop();
        }
    }

    public String getDirection()
    {
        String stringStack="";
        for(int i=0;i<direction.size();i++)
        {
            stringStack = direction.get(i) + "\n" + stringStack;
        }
        return stringStack;
    }

    public int getDirectionSize()
    {
        return direction.size();
    }

    public void performDirection()
    {
        String direct = direction.get(0);
        if(direct == "LEFT")
        {
            robotStack.pop();
            index--;
        }
        else if(direct == "RIGHT")
        {
            robotStack.push('=');
            index++;
        }
        else
        {
            result.push(scramble.substring(index,index+1));
        }
        direction.remove(0);
    }

    public void setResult()
    {

    }

    //Print Result
    public String getResult()
    {
        String stringResult="";
        for(int i=0;i<result.size();i++)
        {
            stringResult = stringResult + result.get(i);
        }
        return stringResult;
    }


    public boolean checkMatching()
    {
        if(prompt.equals(getResult()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

package com.example.algogame.Object;

import android.text.Layout;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class Queue_Object {
    String prompt;
    Stack<String> bufferScramble = new Stack<String>();
    String scramble="";
    Stack<String> scrambleCopy = new Stack<String>();
    Stack<String> result = new Stack<String>();
    Stack <Character> robotStack = new Stack<Character>();
    Random rand = new Random();
    String[] library =
            {"BIKECYCLE","UMBRELLA","ALLIGATOR","CRYSTALLINE","TERMITE", "DOLPHIN",
                    "CUCUMBER","SENTENCE","PUNISHMENT","SPIDER", "AFRICAN","GOVERNMENT",
                    "LEGENDARY","JAPANESE","SPANISH","MADAGASCAR","PURPOSE","COMPANY",
                    "EXAMPLE","COUNTRY","PROBLEM","INTEREST","RESEARCH","EVIDENCE",
                    "LANGUAGE","PRACTICE","DECISION","HOSPITAL","COMPUTER","MOVEMENT",
                    "ANALYSIS","MATERIAL","PRESSURE","ACTIVITY","MAJORITY","SOFTWARE",
                    "DAUGHTER","CAMPAIGN","INSTANCE","ARGUMENT","EXCHANGE","MARRIAGE",
                    "SOLUTION","ACCIDENT","EXERCISE","STRATEGY","VIOLENCE","EMPHASIS",
                    "AUDIENCE","PLEASURE","MAGAZINE","APPROVAL","DELIVERY","CURRENCY",
                    "EDUCATION","COMMUNITY","COMMITTEE","PROGRAMME","AUTHORITY","PRESIDENT",
                    "SITUATION","SECRETARY","KNOWLEDGE","STRUCTURE","ATTENTION","AGREEMENT",
                    "BEHAVIOUR","TREATMENT","OPERATION","STATEMENT","EQUIPMENT","CHARACTER",
                    "PRINCIPLE","AFTERNOON","EXISTENCE","ADVANTAGE","INSURANCE","TELEPHONE",
                    "NEWSPAPER","CRITICISM","INFLATION","TECHNIQUE","BREAKFAST","FRAMEWORK"};

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
        robotStack.push('-');
    }

    public void rightRobot()
    {
        robotStack.push('O');
    }
    public void leftRobot()
    {
        robotStack.pop();
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

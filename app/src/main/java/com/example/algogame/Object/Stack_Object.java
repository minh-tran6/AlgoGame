package com.example.algogame.Object;

import java.util.Random;
import java.util.Stack;

public class Stack_Object {
    String prompt;
    Stack<String> scramble = new Stack<String>();
    Stack<String> stack = new Stack<String>();
    Stack<String> result = new Stack<String>();
    Random rand = new Random();
    String[] library =
            {"BICYCLE","UMBRELLA","ALLIGATOR","CRYSTALLINE","TERMITE", "DOLPHIN",
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
        //EBKIYCELC
//        scramble.push("C");
//        scramble.push("L");
//        scramble.push("E");
//        scramble.push("C");
//        scramble.push("Y");
//        scramble.push("I");
//        scramble.push("K");
//        scramble.push("B");
//        scramble.push("E");
        Stack<String> generate = new Stack<String>();
        int randomNumber;
        int startFromLeft=0;
        int startFromRight=prompt.length()-1;
        for(int i=0;i<prompt.length();i++)
        {
            randomNumber = rand.nextInt(2);
            if(randomNumber==0)
            {
                if(!generate.isEmpty())
                {
                    scramble.push(generate.get(0));
                    generate.pop();
                }
                generate.push(prompt.substring(startFromLeft,startFromLeft+1));
                startFromLeft++;
            }
            else
            {
                scramble.push(prompt.substring(startFromLeft,startFromLeft+1));
                startFromLeft++;
            }
        }
        if(!generate.isEmpty())
        {
            scramble.push(generate.get(0));
            generate.pop();
        }
    }

    public String getScramble()
    {
        String stringScramble="";
        for(int i=0;i<scramble.size();i++)
        {
            stringScramble = stringScramble + scramble.get(i);
        }
        return stringScramble;
    }
    public void setStack()
    {
        stack.push(scramble.get(scramble.size() - 1));
        scramble.pop();

    }
    public String getStack()
    {
        String stringStack="";
        for(int i=0;i<stack.size();i++)
        {
            stringStack = stringStack + stack.get(i);
        }
        return stringStack;
    }

    public void setResult()
    {
        result.push(stack.get(stack.size()-1));
        stack.pop();
    }

    public String getResult()
    {
        String stringResult="";
        for(int i=0;i<result.size();i++)
        {
            stringResult = stringResult + result.get(i);
        }
        return stringResult;
    }
}


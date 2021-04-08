package com.example.algogame.Object;

import java.util.Random;
import java.util.Stack;

public class Stack_Object {
    String prompt;
    Stack<String> scramble = new Stack<String>();
    Stack<String> scrambleCopy = new Stack<String>();
    Stack<String> stack = new Stack<String>();
    Stack<String> result = new Stack<String>();
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
                    scramble.push(generate.get(generate.size() - 1));
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
                    generate.push(prompt.substring(startFromLeft,startFromLeft+1));
                    startFromLeft++;
                }
                else {
                    while(generate.size()!=0) {
                        scramble.push(generate.get(generate.size() - 1));
                        generate.pop();
                    }
                }

            }
        }
        scrambleCopy = (Stack<String>) scramble.clone();
    }

    public void reset()
    {
        scramble = (Stack<String>) scrambleCopy.clone();
        while(!stack.isEmpty())
        {
            stack.pop();
        }
        while(!result.isEmpty())
        {
            result.pop();
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
        if(!scramble.isEmpty()) {
            stack.push(scramble.get(0));
            scramble.remove(0);
        }

    }
    public String getStack()
    {
        String stringStack="";
        for(int i=0;i<stack.size();i++)
        {
            stringStack =  stack.get(i) + "\n" + stringStack;
        }
        return stringStack;
    }

    public void setResult()
    {
        if(!stack.isEmpty()) {
            result.push(stack.get(stack.size() - 1));
            stack.pop();
        }
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


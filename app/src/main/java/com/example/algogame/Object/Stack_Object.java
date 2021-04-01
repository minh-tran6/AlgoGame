package com.example.algogame.Object;

import java.util.Stack;

public class Stack_Object {
    String prompt;
    Stack<String> stack = new Stack<String>();
    Stack<String> scramble = new Stack<String>();
    String result;
    String[] library = {"BICYCLE","UMBRELLA"};

    //generate random num
    public String getPrompt(int i)
    {
        prompt = library[i];
        return prompt;
    }

    //PUSH_POP
    public void setScramble()
    {
        //loop push_pop
        scramble.push("a");
        scramble.push("b");
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
    //split set get
    public String getStack()
    {
        String stringStack="";
        stack.push(scramble.get(0));
        scramble.pop();
        for(int i=0;i<stack.size();i++)
        {
            stringStack = stringStack + stack.get(i);
        }
        return stringStack;
    }
}


package com.example.motoparts;

import data.classes.Piston;

import java.util.ArrayList;

public class InputValidator {
    final String HAS_CHARACTERS = "HAS_CHARACTERS";
    final String HAS_NUMBERS = "HAS_NUMBERS";
    final String IS_EMPTY = "IS_EMPTY";
    final String IS_VALID = "IS_VALID";
    String inputStatus = "";

    public String getInputStatus(){
        return inputStatus;
    }
    public void setInputStatus(String status){
        inputStatus = status;
    }

    public void validateNumeric(String numericString){
        char [] numericStringChars = numericString.toCharArray();
        boolean hasCharacters = false;
        for(char c : numericStringChars){
            if(!Character.isDigit(c)){
                hasCharacters = true;
                break;
            }
        }
        if(hasCharacters){
            setInputStatus(HAS_CHARACTERS);
        }
        else if(numericString.isEmpty()){
            setInputStatus(IS_EMPTY);
        }
        else{
            setInputStatus(IS_VALID);
        }
    }

    public void validateCharacters(String characterString){
        char [] characterStringChars = characterString.toCharArray();
        boolean hasNumbers = false;
        for(char c : characterStringChars){
            if(Character.isDigit(c)){
                hasNumbers = true;
                break;
            }
        }
        if(hasNumbers){
            setInputStatus(HAS_NUMBERS);
        }
        else if(characterString.isEmpty()){
            setInputStatus(IS_EMPTY);
        }
        else{
            setInputStatus(IS_VALID);
        }
    }
    public void validateEmptiness(String nonEmptyString){
        if(nonEmptyString.isEmpty()){
            setInputStatus(IS_EMPTY);
        }
        else{
            setInputStatus(IS_VALID);
        }
    }

    public boolean isInputValid(ArrayList<Boolean> inputValidated){
        boolean isInputValid = false;
        int validated = 0;
        for(boolean b : inputValidated){
            if(b){
                validated++;
            }
        }
        if(validated == inputValidated.size()){
            isInputValid = true;
        }
        return isInputValid;
    }

}

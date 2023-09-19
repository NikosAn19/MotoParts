package com.example.motoparts;

import java.util.LinkedHashMap;
import java.util.Map;

public class QueryGenerator {

    public QueryGenerator(){

    }
    public String generateSelectQuery(String inCompression , String inDiameter , String inPinDiameter , String inModel , String inBrand , String inStroke ){

        LinkedHashMap<String , String> pistonMap;

        //For query generator
        String queryPart = "";
        String ex1 = "'";
        String ex2 = "'";

        String query = "SELECT *" +"\n" +
                       "FROM PISTONS"+ "\n" +
                       "WHERE" +"\n" ;


        //For empty entrance to avoid IO exception
       if      ((inCompression == "" || inCompression == null) &&
               (inDiameter == "" || inDiameter == null) &&
               (inPinDiameter == "" || inPinDiameter == null) &&
               (inModel == "" || inModel == null) &&
               (inBrand == "" || inBrand == null) &&
               (inStroke == "" || inStroke == null))
       {
           query = "SELECT *" +"\n" +
                   "FROM PISTONS ;";
       }

        pistonMap = new LinkedHashMap<>();
        if(inCompression != "" && inCompression != null){
            pistonMap.put("compressionHeight" , inCompression);
        }
        if(inDiameter != "" && inDiameter != null){
            pistonMap.put("diameter" , inDiameter);
        }
        if(inPinDiameter != "" && inPinDiameter != null){
            pistonMap.put("pinDiameter" , inPinDiameter);
        }
        if(inModel != "" && inModel != null){
            pistonMap.put("model" , ex1 +inModel +ex2);
        }
        if(inBrand != "" && inBrand != null){
            pistonMap.put("brand" , ex1 +inBrand +ex2);
        }
        if(inStroke != "" && inStroke != null){
            pistonMap.put("stroke" , ex1 +inStroke +ex2);
        }
        int elementCounter = 1;
        int pistonMapSize = pistonMap.size();
        for (Map.Entry<String, String> set :
                pistonMap.entrySet()) {
            if(elementCounter == pistonMapSize){
                queryPart = queryPart +"PISTONS."+set.getKey() +" = " +set.getValue()  +";";
            }
            else{
                queryPart = queryPart +"PISTONS."+set.getKey() +" = " +set.getValue()  +" AND " ;
            }

            elementCounter++;
        }
        query = query + queryPart;
        System.out.println("Query generated : " +"\n" +query);

        return query;
    }




}

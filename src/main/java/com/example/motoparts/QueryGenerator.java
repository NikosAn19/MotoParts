package com.example.motoparts;

import java.util.LinkedHashMap;
import java.util.Map;

public class QueryGenerator {

    public QueryGenerator(){

    }
    public String generateSelectQuery(String inCode , String inTotalHeight, String inCompression , String inDiameter
            , String inPinDiameter , String inModel , String inBrand , String inStroke , String inOversize ){

        LinkedHashMap<String , String> pistonMap;

        //For query generator
        String queryPart = "";
        String ex1 = "'";
        String ex2 = "'";

        String query = "";


        //For empty entrance to avoid IO exception
       if      (( inCode == null|| inCode.isEmpty()) &&
               (inDiameter == null || inDiameter.isEmpty()) &&
               (inTotalHeight == null|| inTotalHeight.isEmpty()) &&
               (inCompression == null||inCompression.isEmpty()) &&
               (inPinDiameter == null||inPinDiameter.isEmpty()) &&
               (inStroke == null||inStroke.isEmpty()) &&
               (inBrand == null ||inBrand.isEmpty()) &&
               (inModel == null||inModel.isEmpty()) &&
               (inOversize == null|| inOversize.isEmpty()))
       {
           query = getZeroArgumentQuery();

       }
       else if (inStroke.equals("2T") || inStroke.equals("4T") )
       {
           pistonMap = new LinkedHashMap<>();
           if(inCode != null && !inCode.isEmpty()){
               pistonMap.put("pistonCode" , ex1 +inCode +ex2);
           }
           if(inDiameter != null && !inDiameter.isEmpty()){
               pistonMap.put("diameter" , ex1 +inDiameter +ex2);
           }
           if(inTotalHeight != null && !inTotalHeight.isEmpty()){
               pistonMap.put("totalHeight" , ex1 +inTotalHeight +ex2);
           }
           if(inCompression != null && !inCompression.isEmpty()){
               pistonMap.put("compressionHeight" , ex1 +inCompression +ex2);
           }
           if(inPinDiameter != null && !inPinDiameter.isEmpty()){
               pistonMap.put("pinDiameter" , ex1 +inPinDiameter +ex2);
           }
               pistonMap.put("stroke" , ex1 +inStroke +ex2);
           if(inBrand != null && !inBrand.isEmpty()){
               pistonMap.put("brand" , ex1 +inBrand +ex2);
           }
           if(inModel != null && !inModel.isEmpty()){
               pistonMap.put("model" , ex1 +inModel +ex2);
           }
           if(inOversize != null && !inOversize.isEmpty()){
               pistonMap.put("oversize" , ex1 +inOversize +ex2);
           }
          query = getBinaryStrokeQuery(pistonMap);
       }
       else if (( inCode == null|| inCode.isEmpty()) &&
               (inDiameter == null || inDiameter.isEmpty()) &&
               (inTotalHeight == null|| inTotalHeight.isEmpty()) &&
               (inCompression == null||inCompression.isEmpty()) &&
               (inPinDiameter == null||inPinDiameter.isEmpty()) &&
               (inStroke != null||!inStroke.isEmpty()) &&
               (inBrand == null ||inBrand.isEmpty()) &&
               (inModel == null||inModel.isEmpty()) &&
               (inOversize == null|| inOversize.isEmpty()))
       {
           query = getZeroArgumentQuery();

       }
       else{
           pistonMap = new LinkedHashMap<>();
           if(inCode != null && !inCode.isEmpty()){
               pistonMap.put("pistonCode" , ex1 +inCode +ex2);
           }
           if(inDiameter != null && !inDiameter.isEmpty()){
               pistonMap.put("diameter" , ex1 +inDiameter +ex2);
           }
           if(inTotalHeight != null && !inTotalHeight.isEmpty()){
               pistonMap.put("totalHeight" , ex1 +inTotalHeight +ex2);
           }
           if(inCompression != null && !inCompression.isEmpty()){
               pistonMap.put("compressionHeight" , ex1 +inCompression +ex2);
           }
           if(inPinDiameter != null && !inPinDiameter.isEmpty()){
               pistonMap.put("pinDiameter" , ex1 +inPinDiameter +ex2);
           }
//           pistonMap.put("stroke" , ex1 +inStroke +ex2);
           if(inBrand != null && !inBrand.isEmpty()){
               pistonMap.put("brand" , ex1 +inBrand +ex2);
           }
           if(inModel != null && !inModel.isEmpty()){
               pistonMap.put("model" , ex1 +inModel +ex2);
           }
           if(inOversize != null && !inOversize.isEmpty()){
               pistonMap.put("oversize" , ex1 +inOversize +ex2);
           }
           query = getAllStrokesQuery(pistonMap);
       }


        return query;
    }

    private String getZeroArgumentQuery(){
        String query = "SELECT *" +"\n" +
                       "FROM PISTONS ;";
        System.out.println("Query generated : " +"\n" +query);
        return query;
    }

    private String getBinaryStrokeQuery(LinkedHashMap<String , String> pistonMap){
        String queryPart = "";
        String query = "SELECT *" +"\n" +
                       "FROM PISTONS"+ "\n" +
                       "WHERE" +"\n" ;

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

    private String getAllStrokesQuery(LinkedHashMap<String , String> pistonMap){
        String queryPart = "";
        String query = "SELECT *" +"\n" +
                       "FROM PISTONS"+ "\n" +
                       "WHERE" +"\n" ;

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

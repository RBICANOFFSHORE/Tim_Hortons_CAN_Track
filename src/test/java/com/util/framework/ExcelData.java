package com.util.framework;

import com.codoid.products.fillo.Connection;

import com.codoid.products.fillo.Fillo;

import com.codoid.products.fillo.Recordset;

import java.util.ArrayList;

public class ExcelData extends ReadFromProperties{
    static Recordset recordset =null;
    static Connection connection;
    public ExcelData(){

    }
    public static Recordset getExcelData(){
        try{
            String filePath = getFromProperties("RBIData");
            upDateLog("Using Test Data file as " + "\n" + filePath);
            Fillo fillo = new Fillo();
            connection = fillo.getConnection(filePath);
            String strSelectQuery = getFromProperties("Query");
            recordset = connection.executeQuery(strSelectQuery);
            return recordset;

        }catch (Exception ex){
            upDateLog("Exception while getting data from excel sheet" + "\n" + ex.toString());
            return null;
        }finally {
            connection.close();
        }
    }
    public static void updateExcelData(String value){
        try{
            String filePath = getFromProperties("RBIData");
            upDateLog("Using Test Data file as " + "\n" + filePath);
            String[] result = value.split("-");
            Fillo fillo = new Fillo();
            connection = fillo.getConnection(filePath);
            String insertQuery = "Update OffersID Set OffersID = " + "'" + value + "'";
            connection.executeUpdate(insertQuery);

        }catch (Exception ex){
            upDateLog("Exception while updating data from excel sheet" + "\n" + ex.toString());
        }finally {
            connection.close();
        }
    }
    public static void insertExcelData(String value){
        try{
            String filePath = getFromProperties("RBIData");
            upDateLog("Using Test Data file as " + "\n" + filePath);
            Fillo fillo = new Fillo();
            connection = fillo.getConnection(filePath);
            String insertQuery = "INSERT INTO OffersID (OffersID) VALUES " + "('" + value + "')";
            connection.executeUpdate(insertQuery);

        }catch (Exception ex){
            upDateLog("Exception while updating data from excel sheet" + "\n" + ex.toString());
        }finally {
            connection.close();
        }
    }
    public static Connection getExcelConnection(){
        try{
            String filePath = getFromProperties("RBIData");
            upDateLog("Using Test Data file as " + filePath);
            Fillo fillo = new Fillo();
            connection = fillo.getConnection(filePath);
            return connection;

        }catch (Exception ex){
            upDateLog("Exception while getting excel connection" + "\n" + ex.toString());
            return null;
        }
    }
}
